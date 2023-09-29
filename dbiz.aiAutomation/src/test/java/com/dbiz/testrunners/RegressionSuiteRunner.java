package com.dbiz.testrunners;


	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(
	    features = "src/test/resources/UI_features",
	    glue = {"ui_stepdefinitions"},
	    		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    		tags="@Regression")

	public class RegressionSuiteRunner extends AbstractTestNGCucumberTests {
		
	}

