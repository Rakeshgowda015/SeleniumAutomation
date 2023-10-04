package api_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import com.dbiz.utils.PropertiesFile;

import static org.hamcrest.Matchers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactPageApiStepdefinition {
	private Response response;
	private static final Logger logger = LogManager.getLogger(ContactPageApiStepdefinition.class);

	@Given("user calls ContactPageAPI with GET http request")
	public void userCallsContactUsAPIWithGETRequest() {
		try {
			// Construct the base URI for the Contact Us API by formatting the baseURL with
			// the environment property
			String baseURI = String.format(PropertiesFile.getProperty("ContactPageURI"),
					PropertiesFile.getProperty("ENV"));

			// Set the base URI for the REST Assured request
			RestAssured.baseURI = baseURI;

			// Send a GET request and capture the response
			response = RestAssured.given().log().all() // Log request details (including headers and body)
					.when().get();

			logger.info("GET request to ContactUsAPI has been sent successfully.");
		} catch (Exception e) {
			logger.error("An error occurred while sending the GET request to ContactUsAPI: " + e.getMessage());
			throw e;
		}
	}

	@Then("the ContactPageAPI call got success with status code {int}")
	public void theAPICallGotSuccessWithStatusCode(Integer expectedStatusCode) {
		try {
			// Assert the status code
			int actualStatusCode = response.getStatusCode();
			Assert.assertEquals(actualStatusCode, expectedStatusCode.intValue(), "Status code does not match.");

			logger.info("API call was successful with status code: " + actualStatusCode);
		} catch (Exception e) {
			logger.error("An error occurred while validating the API response status code: " + e.getMessage());
			throw e;
		}
	}

	@Then("Validating response body from the ContactPageAPI")
	public void validatingResponseBodyFromContactUsAPI() {
		try {
			// Validate the response body here
			response.then().log().all() // Log response details (including headers and body)
					.statusCode(200) // Assert the status code is 200 OK
					.body("nid", equalTo("5")) // Assert the 'nid' field
					.body("uuid", not(emptyOrNullString())) // Assert the 'uuid' field is not empty
					.body("title", equalTo("Contact Us")); // Assert the 'title' field

			logger.info("API response body has been validated successfully.");
		} catch (Exception e) {
			logger.error("An error occurred while validating the API response body: " + e.getMessage());
			throw e;
		}
	}
}
