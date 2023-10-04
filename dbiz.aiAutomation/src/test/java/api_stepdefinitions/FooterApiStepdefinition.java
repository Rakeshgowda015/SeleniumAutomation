package api_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static org.hamcrest.Matchers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FooterApiStepdefinition {
	private Response response;
	private static final Logger logger = LogManager.getLogger(FooterApiStepdefinition.class);

	@Given("user calls FooterAPI with GET http request")
	public void userCallsFooterAPIWithGETRequest() {
		try {
			// Define the base URI
			RestAssured.baseURI = "https://uat.dbizsolution.com";

			// Send a GET request and capture the response
			response = RestAssured.given().log().all() // Log request details (including headers and body)
					.when().get("/api/global/footer");

			logger.info("GET request to FooterAPI has been sent successfully.");
		} catch (Exception e) {
			logger.error("An error occurred while sending the GET request to FooterAPI: " + e.getMessage());
			throw e;
		}
	}

	@Then("the FooterAPI call got success with status code {int}")
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

	@Then("Validating response body from the FooterAPI")
	public void validatingResponseBodyFromFooterAPI() {
		try {
			// Validate the response body here
			response.then().log().all() // Log response details (including headers and body)
					.statusCode(200) // Assert the status code is 200 OK
					.body(containsString("dbiz.ai")); // Example validation, customize as needed

			logger.info("API response body has been validated successfully.");
		} catch (Exception e) {
			logger.error("An error occurred while validating the API response body: " + e.getMessage());
			throw e;
		}
	}
}
