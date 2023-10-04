package com.dbiz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dbiz.libs.BasePage;
import com.dbiz.libs.CommonText;
import com.dbiz.libs.WebObjectLocators;

public class ContactPage extends BasePage{
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
	
	// Web object locators
	private String about = webLocators.getPaths("About");
	
	
	// HomePage Text
	String welcometext = CommonText.homepagewelcome_Text;
		
	public boolean textInHomePage(String textName) {
	    boolean status = false;

	    try {
	        switch (textName) {
	            case "Contact US":
	                status = verifyingText(textName).isDisplayed();
	                if (!status) {
	                    LOG.error("Contact US heading not displayed.");
	                }
	                break; // Add this break statement
	            // Add more cases if needed

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

		

	
}

