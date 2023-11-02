package ui_stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.dbiz.pages.ContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactPageStepdefinition {
	private static final Logger logger = LogManager.getLogger(HomePageStepdefinition.class);
	ContactPage contactPage = new ContactPage(Hooks.driver);

	@And("I validate {string} in contactpage")
	public void i_validate_something_in_contactpage(String text) {
		logger.info("Validating '" + text + "' in contactpage", text);
		Assert.assertTrue(contactPage.textInContactPage(text));
	}
	
	@When("I enter {string} in contactpage")
	public void i_enter_something_in_contactpage(String text) {
		logger.info("Validating '" + text + "'  in contactpage", text);
		Assert.assertTrue(contactPage.enterTextInField(text));
	}

	@And("I click on {string} in contactpage")
	public void i_click_on_something_in_contactpage(String text) {
		logger.info("Click on '" + text + "' in contactpage", text);
		Assert.assertTrue(contactPage.clickOnCheckBox(text));
	}
	@When("I click on {string} link in contactpage")
	public void i_click_on_some_link_in_contactpage(String linkName)  {
		logger.info("I click on '" + linkName + "' link in homepage");
		Assert.assertTrue(contactPage.clickOnLink(linkName));
	}

}
