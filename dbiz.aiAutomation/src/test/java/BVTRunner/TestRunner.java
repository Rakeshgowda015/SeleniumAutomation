package BVTRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/UI_features/HomePage.feature",
    glue = {"UI_stepdefinitions"},
    		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class TestRunner extends AbstractTestNGCucumberTests {


	
}
