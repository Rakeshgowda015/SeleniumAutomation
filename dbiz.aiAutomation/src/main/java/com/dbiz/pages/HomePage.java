package com.dbiz.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dbiz.libs.BasePage;
import com.dbiz.libs.CommonText;
import com.dbiz.utils.PropertiesFile;
import com.dbiz.libs.WebObjectLocators;

public class HomePage extends BasePage {
	private WebDriver wd;
	private static final Logger LOG = LogManager.getLogger(HomePage.class);

	// Constructor
	public HomePage(WebDriver wd) {
		super(wd);
		this.wd = wd;
	}

	// Find banner heading element by text
	WebElement bannerHeading(String text) {
		return wd.findElement(By.xpath("//*[text()='" + text + "']"));
	}

	// Find Industries section element by text
	WebElement IndustriesSection(String text) {
		return wd.findElement(By.xpath("//div[@class='serviceBlock']//li/h6[text()='" + text + "']"));
	}

	WebElement OfferSection(String text) {
		return wd.findElement(By.xpath("//div/h1[text()='What We offer']/..//h3[text()='" + text + "']"));
	}

	WebElement OfferSectionP(String text) {
		return wd.findElement(By.xpath("//div/h1[text()='What We offer']/..//p[text()='" + text + "']"));
	}

	WebObjectLocators webLocators = new WebObjectLocators();

	// Web object locators
	private String about = webLocators.getPaths("About");
	private String services = webLocators.getPaths("Services");
	private String technology = webLocators.getPaths("Technology");
	private String insights = webLocators.getPaths("Insights");
	private String careers = webLocators.getPaths("Careers");
	private String contact = webLocators.getPaths("Contact");
	private String dbizlogo = webLocators.getPaths("Dbizlogo");
	private String Explorebutton = webLocators.getPaths("Explorebutton");

	// HomePage Text
	String welcometext = CommonText.homepagewelcome_Text;
	String fasttracktext = CommonText.homepagefasttrack_Text;
	String fasttrackptext = CommonText.homepagefasttreckP_Text;
	String blendingarttext = CommonText.homepageblendingart_Text;
	String blendingartptext = CommonText.homepageblendingartP_Text;
	String digitaltext = CommonText.homepagedigital_Text;
	String digitalptext = CommonText.homepagedigitalp_Text;
	String productdevelopmenttext = CommonText.productdevelopment_Text;
	String platformtext = CommonText.platform_Text;
	String dataarchitecturetext = CommonText.dataarchitecture_Text;
	String cloudtext = CommonText.cloud_Text;
	String rapidapplicationdevelopmenttext = CommonText.rapidapplicationdevelopment_Text;
	String experiencedesgntext = CommonText.experiencedesgn_Text;
	String digitalmarketingtext = CommonText.digitalmarketing_Text;
	String acceleratedgrowthconsultingtext = CommonText.acceleratedgrowthconsulting_Text;
	String aitext = CommonText.ai_Text;
	
	String joinourteamtext = CommonText.joinourteam_Text;

	// Navigate to the home page using the base URL from properties
	public void goToHomePage() {
		String baseurl = PropertiesFile.getProperty("BaseURL");
		goToUrl(baseurl);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOG.info("Navigated to URL: " + baseurl); // Log URL navigation
	}

	// Validate the page title for a specific page
	public boolean validatePageTitle(String title, String Page) {
		boolean status = false;
		switch (Page) {
		case "Home":
			status = getWindowTitle().equals(title);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + title + ", Actual: " + getWindowTitle());
			}
			break;
		}
		return status;
	}

	// Check if elements in the home page navigation bar are present
	public boolean homePageNavigationBarElements(String pageName) {
		boolean status = false;

		try {
			switch (pageName) {
			case "HomePage":
				scrollIntoView(about);
				status = isElementPresent(about) && isElementPresent(services) && isElementPresent(technology)
						&& isElementPresent(insights) && isElementPresent(careers) && isElementPresent(contact)
						&& isElementPresent(dbizlogo);
				if (!status) {
					LOG.error("Navigation bar element check failed.");
				}
				break;
			}
		} catch (Exception e) {
			// Handle exceptions here (e.g., log the error)
			LOG.error("Error during navigation bar element check: " + e.getMessage());
		}

		return status;
	}

	// Check if specific text elements are displayed on the home page
	public boolean textInHomePage(String textName) {
		boolean status = false;

		try {
			switch (textName) {
			case "Bannerheading":
				String text = CommonText.homepagebanner_Text;
				scrollIntoViewUsingWebElement(bannerHeading(text));
				status = bannerHeading(text).isDisplayed();
				if (!status) {
					LOG.error("Banner heading not displayed.");
				}
				break;
			case "WelcomeText":
				scrollIntoViewUsingWebElement(bannerHeading(welcometext));
				status = bannerHeading(welcometext).isDisplayed() && bannerHeading(fasttracktext).isDisplayed()
						&& bannerHeading(fasttrackptext).isDisplayed() && bannerHeading(blendingarttext).isDisplayed()
						&& bannerHeading(blendingartptext).isDisplayed() && bannerHeading(digitaltext).isDisplayed()
						&& bannerHeading(digitalptext).isDisplayed();
				if (!status) {
					LOG.error(textName + " WelcomeText not displayed.");
				}
				break;
			case "Offersection":
				scrollIntoViewUsingWebElement(OfferSectionP(productdevelopmenttext));  				
				status = OfferSectionP(productdevelopmenttext).isDisplayed()
						&& OfferSectionP(platformtext).isDisplayed()
						&& OfferSectionP(dataarchitecturetext).isDisplayed()
						&& OfferSectionP(rapidapplicationdevelopmenttext).isDisplayed()
						&& OfferSectionP(experiencedesgntext).isDisplayed() && OfferSectionP(cloudtext).isDisplayed()
						&& OfferSectionP(digitalmarketingtext).isDisplayed() && OfferSectionP(aitext).isDisplayed();
				if (!status) {
					LOG.error("Offersection not displayed.");
				}
				break;
			case "JOIN OUR TEAM":
				scrollIntoViewUsingWebElement(bannerHeading(textName));
				status = bannerHeading(textName).isDisplayed() && bannerHeading(joinourteamtext).isDisplayed() && isElementPresent(Explorebutton);
				if (!status) {
					LOG.error("Offersection not displayed.");
				}
				break;
			}
		} catch (Exception e) {
			// Handle exceptions here (e.g., log the error)
			LOG.error("Error during text validation: " + e.getMessage());
		}

		return status;
	}

	// Check if specific text elements are displayed on the home page
	public boolean industriesTextInHomePage(String textName) {
		boolean status = false;
		scrollIntoViewUsingWebElement(IndustriesSection(textName));
		status = IndustriesSection(textName).isDisplayed();

		return status;
	}

//Check if specific text elements are displayed on the home page
	public boolean offerTextInHomePage(String textName) {
		boolean status = false;
		scrollIntoViewUsingWebElement(OfferSection(textName));
		status = OfferSection(textName).isDisplayed();

		return status;
	}

}
