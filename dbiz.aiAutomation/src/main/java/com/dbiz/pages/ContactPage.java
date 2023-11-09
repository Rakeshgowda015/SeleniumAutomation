package com.dbiz.pages;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dbiz.libs.BasePage;
import com.dbiz.libs.WebObjectLocators;
import com.dbiz.pojo.SubmitApiPojo;
import com.dbiz.utils.JsonReader;

public class ContactPage extends BasePage{
	SubmitApiPojo object=new SubmitApiPojo();
	public ContactPage(WebDriver wd) {
		super(wd);
		this.wd = wd;
	}

	
	private WebDriver wd;
	private static final Logger LOG = LogManager.getLogger(ContactPage.class);
	// Find banner heading element by text
	WebElement verifyingText(String text) {
		return wd.findElement(By.xpath("//*[text()='" + text + "']"));
	}
	
	WebObjectLocators webLocators = new WebObjectLocators();
	private String contactformheading = webLocators.getPaths("Contactformheading");
	private String firstnametextfield = webLocators.getPaths("Firstnametextfield");
	private String lastnametextfield = webLocators.getPaths("Lastnametextfield");
	private String emailtextfield = webLocators.getPaths("Emailtextfield");
	private String phonenumbertextfield = webLocators.getPaths("Phonenumbertextfield");
	private String mobilenumbertextfield = webLocators.getPaths("Mobilenumbertextfield");
	private String companynametextfield = webLocators.getPaths("Companynametextfield");
	private String jobtitletextfield = webLocators.getPaths("Jobtitletextfield");
	private String industrytextfield = webLocators.getPaths("Industrytextfield");
	private String countryregiontextfield = webLocators.getPaths("Country/regiontextfield");
	private String messagetextfield = webLocators.getPaths("Messagetextfield");
	private String contactmecheckbox = webLocators.getPaths("Contactmecheckbox");
	private String receivinginformationcheckbox = webLocators.getPaths("Receivinginformationcheckbox");
	private String contactformmandatorytext = webLocators.getPaths("Contactformmandatorytext");
	private String successmessage = webLocators.getPaths("Successmessage");
	private String contactpagecontactustext = webLocators.getPaths("Contactpagecontactustext");
	private String linkedinlink = webLocators.getPaths("Linkedinlink");
	private String twitterlink = webLocators.getPaths("Twitterlink");
	private String instagramlink = webLocators.getPaths("Instagramlink");
	private String facebooklink = webLocators.getPaths("Facebooklink");
	private String dbizsolutionlink = webLocators.getPaths("Dbizsolutionlink");
	
	// Web object locators
	private String about = webLocators.getPaths("About");
	

		
	public boolean textInContactPage(String textName) {
	    boolean status = false;

	    try {
	        switch (textName) {
	            case "Contact US":
	            case "About Us":
	                status = verifyingText(textName).isDisplayed();
	                if (!status) {
	                    LOG.error(textName+" heading not displayed.");
	                }
	                break; // Add this break statement
	                
	            case "ContactFormHeader":
	                status = isElementPresent(contactformheading);
	                if (!status) {
	                    LOG.error("Contact form header not displayed.");
	                }
	                break;
	                
	            case "Mandatorytext":
	                status = isElementPresent(contactformmandatorytext);
	                if (!status) {
	                    LOG.error("Contact form header not displayed.");
	                }
	                break;
	                
	            case "Successmessage":
	                status = isElementPresent(successmessage);
	                if (!status) {
	                    LOG.error("Contact form header not displayed.");
	                }
	                break;

	            default:
	                LOG.error("Text not recognized: " + textName);
	                break; // Add this break statement for the default case
	        }
	    } catch (Exception e) {
	        // Handle exceptions here (e.g., log the error)
	        LOG.error("Error during text validation: " + e.getMessage());
	    }

	    return status;
	}
	
	public boolean enterTextInField(String textName) {
	    boolean status = false;
	    JsonReader data = new JsonReader();
        Map<String, Object> sd = data.jsonData("SubmitapiReqestData.json");
	    try {
 			
	        switch (textName) {
	            case "Firstname":
	            	String firstname=(String) sd.get("first_name");
	                status = typeTextInField(firstnametextfield, firstname);
	                if (!status) {
	                    LOG.error("Error typing text in First Name field.");
	                }
	                break;
	            case "Lastname":
	            	String lastname=(String) sd.get("last_name");
	                status = typeTextInField(lastnametextfield, lastname);
	                if (!status) {
	                    LOG.error("Error typing text in Last Name field.");
	                }
	                break;
	            case "Email":
	            	String email=(String) sd.get("email");
	                status = typeTextInField(emailtextfield, email);
	                if (!status) {
	                    LOG.error("Error typing text in Email field.");
	                }
	            case "Phonenumber":
	            	String phonenumber=(String) sd.get("phone_number");
	                status = typeTextInField(phonenumbertextfield, phonenumber);
	                if (!status) {
	                    LOG.error("Error typing text in Phone Number field.");
	                }
	                break;
	            case "Mobilenumber":
	            	String mobilenumber=(String) sd.get("Mobilenumber");
	                status = typeTextInField(mobilenumbertextfield, mobilenumber);
	                if (!status) {
	                    LOG.error("Error typing text in Mobile Number field.");
	                }
	                break;
	            case "Companyname":
	            	String companyname=(String) sd.get("company_name");
	                status = typeTextInField(companynametextfield, companyname);
	                if (!status) {
	                    LOG.error("Error typing text in Company Name field.");
	                }
	                break;
	            case "Jobtitle":
	            	String jobtitle=(String) sd.get("job_title");
	                status = typeTextInField(jobtitletextfield, jobtitle);
	                if (!status) {
	                    LOG.error("Error typing text in Job Title field.");
	                }
	                break;
	            case "Industry":
	            	String industry=(String) sd.get("industry");
	                status = typeTextInField(industrytextfield, industry);
	                if (!status) {
	                    LOG.error("Error typing text in Industry field.");
	                }
	                break;
	            case "Country/region":
	            	String countryregion=(String) sd.get("country_region");
	                status = typeTextInField(countryregiontextfield, countryregion);
	                if (!status) {
	                    LOG.error("Error typing text in Country/Region field.");
	                }
	                break;
	            case "Message":
	            	scrollIntoView(messagetextfield);
	            	sleep(2);
	            	String message=(String) sd.get("message");
	                status = typeTextInField(messagetextfield, message);
	                if (!status) {
	                    LOG.error("Error typing text in Message field.");
	                }
	                break;

	            default:
	                LOG.error("Text not recognized: " + textName);
	                break;
	        }
	    } catch (Exception e) {
	        // Handle exceptions here (e.g., log the error)
	        LOG.error("Error during text typing: " + e.getMessage());
	    }


	    return status;
	}

	public boolean clickOnCheckBox(String checkBoxName) {
		boolean status = false;

		switch (checkBoxName) {
		case "Mandatorycheckbox":
			scrollBy(200);
			sleep(2);
			status = clickOnElement(contactmecheckbox);
		sleep(4);
			break;
		case "checkbox":
		sleep(2);
			status = clickOnElement(receivinginformationcheckbox);
		sleep(4);
			break;

		default:
			LOG.error("Checkbox is not recognized: " + checkBoxName);
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
		default:
			LOG.error("Link not recognized: " + linkName);
			break;
		}

		return status;
	}

	
}

