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
	WebElement verifyingText(String text) {
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
		return wd.findElement(By.xpath("//div/h1[text()='What We offer']/..//p[contains(text(),'" + text + "')]"));
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
	private String Learnmorebtton = webLocators.getPaths("Learnmorebtton");
	private String impactfulexperienceatscale = webLocators.getPaths("Impactfulexperienceatscale");
	private String explorebutton = webLocators.getPaths("Explorebutton");
	private String contactbutton = webLocators.getPaths("Contactbutton");
	private String outsystemslink = webLocators.getPaths("Outsystemslink");
	private String tricentislink = webLocators.getPaths("Tricentislink");
	private String salesforcelink = webLocators.getPaths("Salesforcelink");
	private String microsoftlink = webLocators.getPaths("Microsoftlink");
	private String linkedinlink = webLocators.getPaths("Linkedinlink");
	private String twitterlink = webLocators.getPaths("Twitterlink");
	private String instagramlink = webLocators.getPaths("Instagramlink");
	private String facebooklink = webLocators.getPaths("Facebooklink");
	private String dbizsolutionlink = webLocators.getPaths("Dbizsolutionlink");
	private String contactformsubmitbutton = webLocators.getPaths("Contactformsubmitbutton");
	private String contactformdisabledsubmitbutton = webLocators.getPaths("Contactformdisabledsubmitbutton");

	// HomePage Text
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
	String getintouchwithustext = CommonText.getintouchwithus_Text;
	String joinourteamtext = CommonText.joinourteam_Text;

	// Navigate to the home page using the base URL from properties
	public void goToHomePage() {
		String baseurl = String.format(PropertiesFile.getProperty("BaseURL"), PropertiesFile.getProperty("ENV"));
		goToUrl(baseurl);
		sleep(5);
		LOG.info("Navigated to URL: " + baseurl); // Log URL navigation
	}

	// Validate the page title for a specific page
	public boolean validatePageTitle(String Page) {
		boolean status = false;
		switch (Page) {
		case "Home":
			sleep(4);
			String homePageTitle = PropertiesFile.getProperty("HomePageTitle");
			status = getWindowTitle().equals(homePageTitle);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + homePageTitle + ", Actual: " + getWindowTitle());
			}
			break;
		case "Contact":
			sleep(2);
			String contactPageTitle = PropertiesFile.getProperty("ContactPageTitle");
			status = getWindowTitle().equals(contactPageTitle);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + contactPageTitle + ", Actual: "
						+ getWindowTitle());
			}
			break;
		case "About":
			sleep(2);
			String aboutPageTitle = PropertiesFile.getProperty("AboutPageTitle");
			status = getWindowTitle().equals(aboutPageTitle);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + aboutPageTitle + ", Actual: "
						+ getWindowTitle());
			}
			break;
		case "(20) DBiz.ai: Overview | LinkedIn":
		case "Log in to Twitter / X":
		case "www.instagram.com":
		case "DBiz Solutions | Facebook":
			String title = PropertiesFile.getProperty("ContactPageTitle");
			status = getWindowTitle().equals(title);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + title + ", Actual: " + getWindowTitle());
			}
			break;

		default:
			LOG.warn("Unhandled Page title: " + Page);
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
				status = isElementPresent(about) && isElementPresent(services) && isElementPresent(contact);

//						&& isElementPresent(insights) && isElementPresent(careers) 
//						
//						&& isElementPresent(dbizlogo);
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
				status = verifyingText(text).isDisplayed() && isElementPresent(Learnmorebtton);
				if (!status) {
					LOG.error("'" + textName + "' not displayed.");
				}
				break;
			case "Welcomeblock":
				status = isElementPresent(impactfulexperienceatscale) && verifyingText(fasttracktext).isDisplayed()
				// && verifyingText(fasttrackptext).isDisplayed()
						&& verifyingText(blendingarttext).isDisplayed() && verifyingText(blendingartptext).isDisplayed()
						&& verifyingText(digitaltext).isDisplayed() && verifyingText(digitalptext).isDisplayed();
				if (!status) {
					LOG.error("'" + textName + "' not displayed");
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
					LOG.error("'" + textName + "' not displayed.");
				}
				break;
			case "JOIN OUR TEAM":
				scrollIntoViewUsingWebElement(verifyingText(textName));
				status = verifyingText(textName).isDisplayed() && verifyingText(joinourteamtext).isDisplayed()
						&& isElementPresent(explorebutton);
				if (!status) {
					LOG.error("'" + textName + "' not displayed.");
				}
				break;
			case "Get in touch with us":
				scrollIntoViewUsingWebElement(verifyingText(textName));
				status = verifyingText(textName).isDisplayed() && verifyingText(getintouchwithustext).isDisplayed()
						&& isElementPresent(contactbutton);
				if (!status) {
					LOG.error("'" + textName + "' not displayed.");
				}
				break;
			case "Our Tech Partners":
				scrollIntoViewUsingWebElement(verifyingText(textName));
				status = verifyingText(textName).isDisplayed() && isElementPresent(outsystemslink)
						&& isElementPresent(tricentislink) && isElementPresent(salesforcelink)
						&& isElementPresent(microsoftlink);
				if (!status) {
					LOG.error("'" + textName + "' not displayed.");
				}
				break;

			case "Connect with us":
				scrollIntoViewUsingWebElement(verifyingText(textName));
				status = verifyingText(textName).isDisplayed() && isElementPresent(linkedinlink)
						&& isElementPresent(twitterlink) && isElementPresent(instagramlink)
						&& isElementPresent(facebooklink) && isElementPresent(dbizsolutionlink);
				if (!status) {
					LOG.error("'" + textName + "' not displayed.");
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

	public boolean clickOnButton(String buttonName) {
		boolean status = false;

		switch (buttonName) {
		case "Dbiz.ai":
			sleep(2);
			status = clickOnElement(dbizlogo);
			sleep(2);
			break;
		case "Contact":
			scrollIntoView(contactbutton);
			sleep(4);
			status = clickOnElement(contactbutton);
			sleep(2);
			break;
		case "submit":
			scrollIntoView(contactformsubmitbutton);
			sleep(5);
			status = clickOnElement(contactformsubmitbutton);
			sleep(1);
			break;
		case "disabled":
			scrollIntoView(contactformsubmitbutton);
			sleep(3);
			status = isElementPresent(contactformdisabledsubmitbutton);
			sleep(2);
			break;
		default:
			LOG.error("Button not recognized: " + buttonName);
			break;
		}

		return status;
	}

	public boolean clickOnLink(String linkName)  {
		boolean status = false;

		switch (linkName) {
		case "Linkedin":
			sleep(4);
			scrollIntoView(linkedinlink);
			status = clickOnElement(linkedinlink);
			sleep(3);
			break;
		case "Twitter":
			sleep(4);
			scrollIntoView(twitterlink);
			status = clickOnElement(twitterlink);
			sleep(4);
			break;
		case "Instagram":
			sleep(4);
			scrollIntoView(instagramlink);
			status = clickOnElement(instagramlink);
			sleep(3);
			break;
		case "Facebook":
			sleep(4);
			scrollIntoView(facebooklink);
			status = clickOnElement(facebooklink);
			sleep(4);
			break;
		case "Mail":
			sleep(3);
			scrollIntoView(dbizsolutionlink);
			status = isElementClickable(dbizsolutionlink);
			sleep(3);
		case "Contact":
			sleep(4);
			status = clickOnElement(contact);
			sleep(4);
			break;
		case "About":
			sleep(4);
			status = clickOnElement(about);
			sleep(4);
			break;
		default:
			LOG.error("Link not recognized: " + linkName);
			break;
		}

		return status;
	}

}
