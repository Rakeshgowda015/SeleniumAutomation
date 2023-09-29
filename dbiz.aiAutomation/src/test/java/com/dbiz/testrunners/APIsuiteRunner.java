package com.dbiz.testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/API_features",
    glue = {"api_stepdefinitions"},
    		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class APIsuiteRunner extends AbstractTestNGCucumberTests {


	
}