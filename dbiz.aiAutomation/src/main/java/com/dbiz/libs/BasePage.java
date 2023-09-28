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
	     * Method to make the driver wait for a specified time interval before proceeding further.
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
	    	    
	    public  void scrollIntoView(String locator) {
	    	 By by = ObjectLocators.getBySelector(locator);
	    	 WebElement element = wd.findElement(by);
	        JavascriptExecutor js = (JavascriptExecutor) wd;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	    public  void scrollIntoViewUsingWebElement(WebElement locator) {
	        JavascriptExecutor js = (JavascriptExecutor) wd;
	        js.executeScript("arguments[0].scrollIntoView(true);", locator);
	    }
	


	    
	    
	}


