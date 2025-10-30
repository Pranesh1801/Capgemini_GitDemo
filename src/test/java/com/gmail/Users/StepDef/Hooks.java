package com.gmail.Users.StepDef;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.gmail.Users.config.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends base {
	public static ExtentSparkReporter spark;
    public static ExtentReports extReports;
    public static ExtentTest test;
 
    @BeforeAll
    public static void beforeAll() {
        
        spark = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }
 
    @AfterAll
    public static void afterAll() {
        extReports.flush();
    }
 
    @Before
    public void beforeScenario(Scenario scenario) {
       test = extReports.createTest(scenario.getName());
       launchBrowser();
    }
   
    @After
    public void afterScenario() {
    	closeBrowser();
    }
 
}
 