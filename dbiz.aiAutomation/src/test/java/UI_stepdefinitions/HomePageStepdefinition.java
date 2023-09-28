package UI_stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.dbiz.utils.PropertiesFile;
import com.dbiz.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepdefinition {
	HomePage homePage;
	private static final Logger logger = LogManager.getLogger(HomePageStepdefinition.class);

	@Given("^I browse the Dbiz.ai url$")
	public void i_browse_the_dbizai_url() {
		logger.info("Browsing the Dbiz.ai URL");
		homePage = new HomePage(Hooks.setUp());
		homePage.goToHomePage();
	}

	@Then("I should be on {string} page")
	public void i_should_be_on_page(String pageName) {
		logger.info("Verifying that I am on the {} page", pageName);
		String homepageTitle = PropertiesFile.getProperty("Title");
		Assert.assertTrue(homePage.validatePageTitle(homepageTitle, pageName));
	}

	@And("I validate {string} Header Navigation bar elements")
	public void i_validate_somepage_navigation_bar_elements(String pageName) {
		logger.info("Validating {} Header Navigation bar elements", pageName);
		Assert.assertTrue(homePage.homePageNavigationBarElements(pageName));
	}

	@And("I validate {string} in homepage")
	public void i_validate_something_in_homepage(String text) {
		logger.info("Validating {} in homepage", text);
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

}
