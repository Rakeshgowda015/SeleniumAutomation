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
	private String rapidProductEngineering = webLocators.getPaths("RapidProductEngineering");
	private String platform = webLocators.getPaths("Platform");
	private String dataEngineering = webLocators.getPaths("DataEngineering");
	private String cloud = webLocators.getPaths("Cloud");

	private String d365SF = webLocators.getPaths("D365SF");
	private String factweaversdatasuite = webLocators.getPaths("Factweaversdatasuite");
	private String personadevelopment = webLocators.getPaths("Personadevelopment");
	private String clientexperiencedesign = webLocators.getPaths("Clientexperiencedesign");
	private String userexperiencedesign = webLocators.getPaths("Userexperiencedesign");
	private String journeymapping = webLocators.getPaths("Journeymapping");
	private String abtesting = webLocators.getPaths("Abtesting");
	private String searchenginemarketing = webLocators.getPaths("Searchenginemarketing");
	private String socialMediaMarketing = webLocators.getPaths("SocialMediaMarketing");
	private String sentimentTrackinge = webLocators.getPaths("SentimentTrackinge");
	private String emailautomation = webLocators.getPaths("Emailautomation");
	private String prototyping = webLocators.getPaths("Prototyping");

	private String rapidApplicationDevelopment = webLocators.getPaths("RapidApplicationDevelopment");
	private String experienceDesign = webLocators.getPaths("ExperienceDesign");
	private String acceleratedGrowthConsulting = webLocators.getPaths("AcceleratedGrowthConsulting");
	private String digitalMarketing = webLocators.getPaths("DigitalMarketing");
	private String product = webLocators.getPaths("Product");
	private String artificialIntelligence = webLocators.getPaths("ArtificialIntelligence");
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
	private String rootlinkedinlink = webLocators.getPaths("RootLinkedinlink");
	private String roottwitterlink = webLocators.getPaths("RootTwitterlink");
	private String rootinstagramlink = webLocators.getPaths("RootInstagramlink");
	private String rootfacebooklink = webLocators.getPaths("RootFacebooklink");
	private String dbizsolutionlink = webLocators.getPaths("Dbizsolutionlink");
	private String contactformsubmitbutton = webLocators.getPaths("Contactformsubmitbutton");
	private String contactformdisabledsubmitbutton = webLocators.getPaths("Contactformdisabledsubmitbutton");
	private String architectureasaService = webLocators.getPaths("ArchitectureasaService");
	private String infrastructureasaService = webLocators.getPaths("InfrastructureasaService");
	private String testingasaService = webLocators.getPaths("TestingasaService");
	private String exploreOpportunitiesbutton = webLocators.getPaths("ExploreOpportunitiesbutton");

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
		LOG.info("Navigated to URL: " + baseurl); // Log URL navigation
	}

	// Validate the page title for a specific page
	public boolean validatePageTitle(String Page) {
		boolean status = false;
		switch (Page) {
		case "Home":
		case "Contact":
		case "About":
		case "RapidProductEngineering":
		case "Services":
		case "Platform":
		case "DataEngineering":
		case "Cloud":
		case "RapidApplicationDevelopment":
		case "ArchitectureasaService":
		case "ExperienceDesign":
		case "DigitalMarketing":
		case "AcceleratedGrowthConsulting":
		case "Product":
		case "ArtificialIntelligence":
		case "InfrastructureasaService":
		case "TestingasaService":
		case "D365SF":
		case "FactweaversDataSuite":
		case "PersonaDevelopment":
		case "ClientExperienceDesign":
		case "UserExperienceDesign":
		case "JourneyMapping":
		case "ABTesting":
		case "SearchEngineMarketing":
		case "SocialMediaMarketing":
		case "SentimentTracking":
		case "EmailAutomation":
		case "Prototyping":
			sleep(3);
			String PageTitle = PropertiesFile.getProperty(Page + "PageTitle");
			sleep(2);
			status = getWindowTitle().equals(PageTitle);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + PageTitle + ", Actual: " + getWindowTitle());
			}
			break;
			
			
			
		case "ExploreOpportunities":
			sleep(3);
			String ExploreOpportunitiesPageTitle = PropertiesFile.getProperty(Page + "PageTitle");
			sleep(2);
			status = validateNewTabTitle(ExploreOpportunitiesPageTitle);
			if (!status) {
				LOG.error("Page title validation failed. Expected: " + ExploreOpportunitiesPageTitle + ", Actual: " + getWindowTitle());
			}
			break;
			
			
		case "(20) DBiz.ai: Overview | LinkedIn":
		case "Log in to Twitter / X":
		case "www.instagram.com":
		case "DBiz Solutions | Facebook":
			sleep(2);
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
			sleep(4);
			status = clickOnElement(contactbutton);
			sleep(2);
			break;
		case "submit":
			scrollBy(100);
			sleep(2);
			status = clickOnElement(contactformsubmitbutton);
			sleep(1);
			break;
		case "disabled":
			scrollIntoView(contactformsubmitbutton);
			sleep(3);
			status = isElementPresent(contactformdisabledsubmitbutton);
			sleep(2);
			break;
		case "ExploreOpportunities":
			sleep(4);
			scrollIntoView(outsystemslink);
			sleep(5);
			status = forceClickOnElement(exploreOpportunitiesbutton);
			sleep(2);
			break;
		default:
			LOG.error("Button not recognized: " + buttonName);
			break;
		}

		return status;
	}

	public boolean clickOnLink(String linkName) {
		boolean status = false;

		switch (linkName) {
		case "Linkedin":
			scrollBy(500);
			sleep(2);
			status = clickOnElement(linkedinlink);
			break;
		case "Twitter":
			scrollBy(500);
			sleep(2);
			status = clickOnElement(twitterlink);
			break;
		case "Instagram":	
			scrollBy(500);
			sleep(2);
			status = clickOnElement(instagramlink);
			break;
		case "Facebook":	
			scrollBy(500);
			sleep(2);
			status = clickOnElement(facebooklink);
			break;
		case "RootLinkedin":
			scrollBy(500);
			sleep(2);
			status = clickOnElement(rootlinkedinlink);
			break;
		case "RootTwitter":
			scrollBy(500);
			sleep(2);
			status = clickOnElement(roottwitterlink);
			break;
		case "RootInstagram":	
			scrollBy(500);
			sleep(2);
			status = clickOnElement(rootinstagramlink);
			break;
		case "RootFacebook":	
			scrollBy(500);
			sleep(2);
			status = clickOnElement(rootfacebooklink);
			break;
		case "Mail":
			scrollBy(500);
			sleep(2);
			status = isElementClickable(dbizsolutionlink);
			break;
		case "Contact":
			sleep(2);
			status = clickOnElement(contact);
			break;
		case "About":
			sleep(2);
			status = clickOnElement(about);
			sleep(4);
			break;
		case "Cloud":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(cloud);
			sleep(4);
			break;
		case "Services":
			sleep(4);
			status = clickOnElement(services);
			sleep(4);
			break;
		case "RapidProductEngineering":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(rapidProductEngineering);
			sleep(4);
			break;
		case "Platform":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(platform);
			sleep(4);
			break;
		case "DataEngineering":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(dataEngineering);
			sleep(4);
			break;
		case "RapidApplicationDevelopment":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(rapidApplicationDevelopment);
			sleep(4);
			break;
		case "ExperienceDesign":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(experienceDesign);
			sleep(4);
			break;
		case "DigitalMarketing":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(digitalMarketing);
			sleep(4);
			break;
		case "AcceleratedGrowthConsulting":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(acceleratedGrowthConsulting);
			sleep(4);
			break;
		case "Product":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(product);
			sleep(4);
			break;
		case "ArtificialIntelligence":
			sleep(4);
			hoverOverElement(services);
			sleep(4);
			status = clickOnElement(artificialIntelligence);
			sleep(4);
			break;

		case "ArchitectureasaService":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(rapidProductEngineering);
			sleep(2);
			status = clickOnElement(architectureasaService);
			sleep(4);
			break;

		case "InfrastructureasaService":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(rapidProductEngineering);
			sleep(2);
			status = clickOnElement(infrastructureasaService);
			sleep(4);
			break;

		case "TestingasaService":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(rapidProductEngineering);
			sleep(2);
			status = clickOnElement(testingasaService);
			sleep(4);
			break;

		case "D365SF":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(platform);
			sleep(2);
			status = clickOnElement(d365SF);
			sleep(4);
			break;
		case "FactweaversDataSuite":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(dataEngineering);
			sleep(2);
			status = clickOnElement(factweaversdatasuite);
			sleep(4);
			break;
		case "PersonaDevelopment":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(experienceDesign);
			sleep(2);
			status = clickOnElement(personadevelopment);
			sleep(4);
			break;
		case "ClientExperienceDesign":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(experienceDesign);
			sleep(2);
			status = clickOnElement(clientexperiencedesign);
			sleep(4);
			break;
		case "UserExperienceDesign":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(experienceDesign);
			sleep(2);
			status = clickOnElement(userexperiencedesign);
			sleep(4);
			break;
		case "JourneyMapping":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(experienceDesign);
			sleep(2);
			status = clickOnElement(journeymapping);
			sleep(4);
			break;
		case "ABTesting":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(experienceDesign);
			sleep(2);
			status = clickOnElement(abtesting);
			sleep(4);
			break;
		case "SearchEngineMarketing":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(digitalMarketing);
			sleep(2);
			status = clickOnElement(searchenginemarketing);
			sleep(4);
			break;
		case "SocialMediaMarketing":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(digitalMarketing);
			sleep(2);
			status = clickOnElement(socialMediaMarketing);
			sleep(4);
			break;
		case "SentimentTracking":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(digitalMarketing);
			sleep(2);
			status = clickOnElement(sentimentTrackinge);
			sleep(4);
			break;
		case "EmailAutomation":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(digitalMarketing);
			sleep(2);
			status = clickOnElement(emailautomation);
			sleep(4);
			break;
		case "Prototyping":
			sleep(4);
			hoverOverElement(services);
			sleep(2);
			hoverOverElement(product);
			sleep(2);
			status = clickOnElement(prototyping);
			sleep(4);
			break;
		default:
			LOG.error("Link not recognized: " + linkName);
			break;
		}

		return status;
	}

}
