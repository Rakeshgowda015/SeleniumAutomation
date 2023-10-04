package api_stepdefinitions;

import com.dbiz.libs.GlobalConstants;
import com.dbiz.model.ApiRequestBody;
import com.dbiz.utils.PropertiesFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class SubmitApiStepdefinition {
    private static final Logger logger = LogManager.getLogger(SubmitApiStepdefinition.class);
    Response response;
    ApiRequestBody requestbody;

    @Given("SubmitAPI Payload")
    public void submit_api_payload() {
        requestbody = new ApiRequestBody();
    }

    @When("user calls SubmitAPI with Post http request")
    public void user_calls_submit_api_with_post_http_request() {
        try {
            // Construct the base URI by formatting the baseURL with the environment
            // property
            String baseURI = String.format(PropertiesFile.getProperty("SubmitApiBaseURI"),
                    PropertiesFile.getProperty("ENV"));

            // Set the base URI for the REST Assured request
            RestAssured.baseURI = baseURI;

            // Send a POST request to the postToken API
            response = RestAssured.given().log().all() // Log request details (including headers and body)
                    .contentType(ContentType.JSON) // Set content type as JSON
                    .header("X-CSRF-Token",GlobalConstants.Token)
                    .body(requestbody.submitApiPayLoad()) // Set the request body
                    .post(); // Specify the API path for the POST request

            // Log the response
            logger.info("Response: " + response.asString());

        } catch (Exception e) {
            // Handle exceptions gracefully and log them
            logger.error("An error occurred while making the API call: " + e.getMessage());
        }
    }

    @Then("the SubmitAPI call got success with status code {int}")
    public void the_homepageapi_call_got_success_with_status_code(Integer expectedStatusCode) {
        try {
            // Assert the status code
            response.then().log().all().assertThat().statusCode(expectedStatusCode);
        } catch (Exception e) {
            // Handle exceptions gracefully and log them
            logger.error("An error occurred while asserting the status code: " + e.getMessage());
        }
    }

    @And("Validating response body from the SubmitAPI")
    public void validating_response_body_from_the_submit_api() {
        try {
            // Parse the response JSON
            JsonPath jsonPath = response.jsonPath();

            // Extract the "sid" value from the response
            String sid = jsonPath.get("sid");

            // Log the extracted "sid" value
            logger.info("Extracted 'sid' from response: " + sid);

            // Perform your validation based on the extracted "sid" value
            // For example, assert that it's not null or empty
            Assert.assertNotNull(sid);
            Assert.assertFalse(sid.isEmpty());

            // You can also assert it against an expected value if needed
            // For example:
            // Assert.assertEquals(expectedSid, sid);
        } catch (Exception e) {
            // Handle exceptions gracefully and log them
            logger.error("An error occurred while asserting the response: " + e.getMessage());
        }
    }
}
