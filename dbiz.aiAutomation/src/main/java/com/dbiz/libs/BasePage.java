package com.dbiz.libs;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dbiz.pages.HomePage;

// alt+shift+j  short cut key to add Documentation Comments

public class BasePage {

	private static final Logger LOG = LogManager.getLogger(HomePage.class);
	private WebDriver wd;

	/**
	 * Constructor for the BasePage class.
	 *
	 * @param wd The WebDriver instance to be used for page interactions.
	 */
	public BasePage(WebDriver wd) {
		this.wd = wd;
	}

	/**
	 * Navigate to a specific URL.
	 *
	 * @param url The URL to navigate to.
	 */
	protected void goToUrl(String url) {
		wd.get(url);
		LOG.info("Navigated to URL: " + url); // Log URL navigation
	}

	/**
	 * Get the title of the current page.
	 *
	 * @return The title of the current page.
	 */
	protected String getWindowTitle() {
		try {
			return wd.getTitle();
		} catch (Exception e) {
			LOG.error("Error getting window title.");
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Method to make the driver wait for a specified time interval before
	 * proceeding further.
	 *
	 * @param timeOutInSeconds The time to wait in seconds.
	 */
	public void sleep(int timeOutInSeconds) {
		try {
			Thread.sleep(timeOutInSeconds * 1000);
		} catch (InterruptedException e) {
			LOG.error("Sleep interrupted: " + e.getMessage());
		}
	}

	/**
	 * Set the page load timeout for the WebDriver.
	 *
	 * @param loadTimeInSec The maximum time to wait for a page to load.
	 */
	protected void pageLoadTime(int loadTimeInSec) {
		try {
			wd.manage().timeouts().pageLoadTimeout(loadTimeInSec, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			// Handle the timeout exception as needed
			e.printStackTrace(); // You can print the stack trace for debugging
		}

	}

	/**
	 * Refresh the current page.
	 */
	public void refresh() {
		wd.navigate().refresh();
		LOG.info("Page refreshed.");
	}

	/**
	 * Check if an element is present on the page.
	 *
	 * @param locator The locator string for the element.
	 * @return True if the element is present, false otherwise.
	 */
	protected boolean isElementPresent(String locator) {
		By by = ObjectLocators.getBySelector(locator);
		return isElementPresent(by);
	}

	private boolean isElementPresent(By by) {
		try {
			WebElement element = wd.findElement(by);
			return element != null;
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void scrollIntoView(String locator) {
		By by = ObjectLocators.getBySelector(locator);
		WebElement element = wd.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollIntoViewUsingWebElement(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].scrollIntoView(true);", locator);
	}

	public void scrollBy(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		String script = String.format("window.scrollBy(0, %d);", pixels);
		js.executeScript(script);
	}

	public boolean clickOnElement(String locator) {
		try {
			By by = ObjectLocators.getBySelector(locator);
			WebElement element = wd.findElement(by);
			element.click();
			return true; // Indicate success if the element was clicked
		} catch (Exception e) {
			// Handle any exceptions that may occur during the click action
			LOG.error("Error clicking on element with locator: " + locator, e);
			return false; // Indicate failure if an exception occurred
		}
	}

	protected boolean isElementClickable(String locator) {
		By by = ObjectLocators.getBySelector(locator);
		return isElementClickable(by);
	}

	private boolean isElementClickable(By by) {
		try {
			WebElement element = wd.findElement(by);
			return (element != null && element.isEnabled());
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean typeTextInField(String locator, String text) {
		try {
			By by = ObjectLocators.getBySelector(locator);
			WebElement element = wd.findElement(by);
			element.clear(); // Clear the input field
			element.sendKeys(text); // Type the new text into the input field
			return true; // Indicate success if the text was typed
		} catch (Exception e) {
			// Handle any exceptions that may occur during the text typing action
			LOG.error("Error typing text '" + text + "' in element with locator: " + locator, e);
			return false; // Indicate failure if an exception occurred
		}
	}
	
	public boolean hoverOverElement(String locator) {
	    try {
	        By by = ObjectLocators.getBySelector(locator);
	        WebElement element = wd.findElement(by);
	        
	        // Use Actions class to hover over the element
	        Actions actions = new Actions(wd);
	        actions.moveToElement(element).build().perform();

	        return true; // Indicate success if the mouse over action is performed
	    } catch (Exception e) {
	        // Handle any exceptions that may occur during the action
	        LOG.error("Error hovering over element with locator: " + locator, e);
	        return false; // Indicate failure if an exception occurred
	    }
	}
	 // Method to click on an element using JavaScript
    public boolean clickElementWithJavaScript(String locator) {
        try {
            // Convert the locator string to a By object
            By by = ObjectLocators.getBySelector(locator);
            
            // Find the element using the By object
            WebElement element = wd.findElement(by);

            // Use JavaScript to click on the element
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("arguments[0].click();", element);

            return true; // Indicate success if the element was clicked
        } catch (Exception e) {
            // Handle any exceptions that may occur during the click action
            LOG.error("Error clicking on element with locator: " + locator, e);
            return false; // Indicate failure if an exception occurred
        }
    }

}
