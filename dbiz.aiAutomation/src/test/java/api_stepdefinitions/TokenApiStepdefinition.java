package api_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.dbiz.libs.GlobalConstants;

public class TokenApiStepdefinition {
	 private Response response;
	    private String token;
	    private static final Logger LOG = LogManager.getLogger(TokenApiStepdefinition.class);

	    @Given("Token Payload")
	    public void token_payload() {
	        // You can create a request payload if needed
	    }

	    @When("user calls TokenAPI with Post http request")
	    public void user_calls_with_post_http_request() {
	        try {
	            // Define the base URI
	            RestAssured.baseURI = "https://uat.dbizsolution.com";

	            // Send a POST request to obtain the token
	            response = RestAssured.given().log().all()
	                    .contentType(ContentType.JSON)
	                    .post("/drupal/session/token?_format=json");

	            LOG.info("Sending a POST request to TokenAPI");
	            LOG.info("Response status code: " + response.getStatusCode());
	            LOG.info("Response body: " + response.getBody().asString());

	            // Extract the token from the response body
	            token = response.getBody().asString().trim();
	        } catch (Exception e) {
	            LOG.error("An exception occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    @Then("the TokenAPI call got success with status code {int}")
	    public void the_api_call_got_success_with_status_code(Integer expectedStatusCode) {
	        try {
	            LOG.info("Logging response details:");
	            response.then().log().all().assertThat().statusCode(expectedStatusCode);
	            LOG.info("Status code assertion passed: " + expectedStatusCode);
	        } catch (Exception e) {
	            LOG.error("An exception occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    @Then("Validating response body from the TokenAPI")
	    public void validating_response_body_from_the() {
	        try {
	            // You can add validation logic here if needed
	        } catch (Exception e) {
	            LOG.error("An exception occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    @When("user store token value to Global Constant")
	    public void user_store_token_value_to_Global_Constant() {
	        try {
	            // Storing the token in a Global Constant
	            GlobalConstants.Token = token;
	            LOG.info("Token has been stored in GlobalConstants.Token: " + token);
	        } catch (Exception e) {
	            LOG.error("An exception occurred while storing the Token: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
