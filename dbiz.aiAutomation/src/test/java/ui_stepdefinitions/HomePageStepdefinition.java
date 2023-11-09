package ui_stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.dbiz.utils.PropertiesFile;
import com.dbiz.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepdefinition {

	private static final Logger logger = LogManager.getLogger(HomePageStepdefinition.class);
	WebDriver driver = Hooks.setUp();
	HomePage homePage = new HomePage(driver);

	@Given("^I browse the Dbiz.ai url$")
	public void i_browse_the_dbizai_url() {
		logger.info("Browsing the Dbiz.ai URL");
		homePage.goToHomePage();
	}
	@Then("submit button should be in {string} mode in contactpage")
	public void submit_button_should_be_in_disabled_mode_in_contactpage(String button) {
		logger.info("submit button should be in disabled mode in contactpage");
		Assert.assertTrue(homePage.clickOnButton(button));
	}

	@Then("I should be on {string} page")
	public void i_should_be_on_page(String pageName)  {
		logger.info("Verifying that I am on the '" + pageName + "' page", pageName);
		Assert.assertTrue(homePage.validatePageTitle(pageName));
	}

	@And("I validate {string} Header Navigation bar elements")
	public void i_validate_somepage_navigation_bar_elements(String pageName) {
		logger.info("Validating '" + pageName + "' Header Navigation bar elements", pageName);
		Assert.assertTrue(homePage.homePageNavigationBarElements(pageName));
	}

	@And("I validate {string} in homepage")
	public void i_validate_something_in_homepage(String text) {
		logger.info("Validating '" + text + "' in homepage", text);
		Assert.assertTrue(homePage.textInHomePage(text));
	}

	@And("I validate Industries Section in homepage")
	public void i_validate_industries_section_in_homepage(DataTable dataTable) {
		logger.info("Validating Industries Section in homepage");
		List<String> industryNames = dataTable.asList(String.class);
		for (String industry : industryNames) {
			logger.info("Validating industry: {}", industry);
			Assert.assertTrue(homePage.industriesTextInHomePage(industry));
		}
	}

	@And("I validate Offer Section in homepage")
	public void i_validate_offer_section_in_homepage(DataTable dataTable) {
		logger.info("Validating Offer Section in homepage");
		List<String> offerNames = dataTable.asList(String.class);
		for (String offer : offerNames) {
			logger.info("Validating offer: {}", offer);
			Assert.assertTrue(homePage.offerTextInHomePage(offer));
		}

	}

	@And("I click on {string} logo in homepage")
	public void i_click_on_some_logo_in_homepage(String buttonName)  {
		logger.info("I click on '" + buttonName + "' logo in homepage");
		Assert.assertTrue(homePage.clickOnButton(buttonName));
	}

	@When("I click on {string} button in homepage")
	public void i_click_on_some_button_in_homepage(String buttonName)  {
		logger.info("I click on '" + buttonName + "' button in homepage");
		Assert.assertTrue(homePage.clickOnButton(buttonName));
	}

	@When("I click on {string} link in homepage")
	public void i_click_on_some_link_in_homepage(String linkName)  {
		logger.info("I click on '" + linkName + "' link in homepage");
		Assert.assertTrue(homePage.clickOnLink(linkName));
	}

	@When("I click on {string} button in contactpage")
	public void i_click_on_some_button_in_contactpage(String buttonName)  {
		logger.info("I click on '" + buttonName + "' button in homepage");
		Assert.assertTrue(homePage.clickOnButton(buttonName));
	}

}
