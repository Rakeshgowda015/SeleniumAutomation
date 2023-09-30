package ui_stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.dbiz.utils.PropertiesFile;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks {
	public static WebDriver driver;

	public static WebDriver setUp() {
		String browser = PropertiesFile.getProperty("Browser");	
	
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "../dbiz.aiAutomation/drivers/chromedriver.exe");

			// Set up Chrome options (optional)
			ChromeOptions chromeOptions = new ChromeOptions();
			// You can add additional options here if needed

			driver = new ChromeDriver(chromeOptions);
		}else if (browser.equalsIgnoreCase("Firefox")) {
			try {
		System.setProperty("webdriver.gecko.driver", "../dbiz.aiAutomation/drivers/geckodriver.exe");

			    // Set up Firefox options (optional)
			    FirefoxOptions firefoxOptions = new FirefoxOptions();
			    // You can add additional options here if needed

			    driver = new FirefoxDriver(firefoxOptions);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
		

		// Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return driver;
	}



	@After(order =0)
	public void sa() {
		// Close the WebDriver instance
		if (driver != null) {
			driver.quit();
		}
	}
	
	 @After(order =1)
	    public static void tearDown(Scenario scenario) {
	 
	        //validate if scenario has failed
	        if(scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName()); 
	        }   
	    }

}
