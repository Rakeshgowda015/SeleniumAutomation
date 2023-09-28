package BVTRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/UIfeature/HomePage.feature",
    glue = {"stepdefinations"},
    		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class TestRunner extends AbstractTestNGCucumberTests {


	
}
