package ui_stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.dbiz.pages.ContactPage;
import io.cucumber.java.en.And;


public class ContactPageStepdefinition {

	private static final Logger logger = LogManager.getLogger(HomePageStepdefinition.class);
	ContactPage contactPage = new ContactPage(Hooks.driver);
	  
	@And("I validate {string} in contactpage")
	public void i_validate_something_in_contactpage(String text) {
	    logger.info("Validating {} in contactpage", text);   
	    Assert.assertTrue(contactPage.textInHomePage(text));
	}

}
