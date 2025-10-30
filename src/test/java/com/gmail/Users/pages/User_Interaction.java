package com.gmail.Users.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;

public class User_Interaction {
    WebDriver driver;
    Scenario scenario;
    WebDriverWait wait;
    private static int failureCount = 1;

    public User_Interaction(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
    }

    public void navigateToLoginPage() { 
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    public void enterCredentials(String uname, String pass) {
        WebElement unamecheck = driver.findElement(By.name("userName"));
        WebElement passcheck = driver.findElement(By.name("password"));
        unamecheck.clear();
        passcheck.clear();
        unamecheck.sendKeys(uname);
        passcheck.sendKeys(pass);
        scenario.log("Username: " + uname + " " + "Password: " + pass);
    }

    public void clickSignIn() {
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
        scenario.log("Clicked Sign In button");
    }
    
    public void captureFailureScreenshot(String reason) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = "screenshots/failure_" + failureCount + ".png";
        File dest = new File(filename);	
        try {
            FileUtils.copyFile(src, dest);
            scenario.log("Screenshot captured for failure: " + reason);
            scenario.attach(FileUtils.readFileToByteArray(dest), "image/png", "Failure Screenshot " + failureCount);
            failureCount++;
        } catch (IOException e) {
            scenario.log("Failed to save screenshot: " + e.getMessage());
        }
    }

    public boolean validateLogin(String uname) throws InterruptedException {
        try {
            WebElement successMsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
            Assert.assertEquals(successMsg.getText(), "Login Successfully");
            scenario.log("Login successful for: " + uname);
            return true;
        } catch (Exception e) {
            scenario.log("Login failed for: " + uname);
            captureFailureScreenshot("Login failed for " + uname);
            Thread.sleep(1000);
            return false;
        }
    }

    public void logoutIfPossible() throws InterruptedException {
        try {
            driver.findElement(By.linkText("SIGN-OFF")).click();
            scenario.log("Logged out.");
            Thread.sleep(1000);
        } catch (Exception e) {
            scenario.log("Logout failed or not applicable.");
            Thread.sleep(1000);
        }
    }

    public void goToHomePage() {
    	try {
            driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
            scenario.log("Navigated to Home Page");
            Thread.sleep(1000);
        } catch (Exception e) {
            scenario.log("Could not navigate to Home Page");
            captureFailureScreenshot("Homepage navigation failed");
        }
    }

    public void testMultipleCredentials(List<List<String>> rows) throws InterruptedException {
        for (List<String> row : rows) {
            String uname = row.get(0);
            String pass = row.get(1);
            scenario.log("Starting test for credentials: Username: " + uname + " and " + "Password: " + pass);
            //navigateToLoginPage();
            enterCredentials(uname, pass);
            clickSignIn();
            boolean check = validateLogin(uname);
            if(check) {
            	goToHomePage();
            	logoutIfPossible();
            }
            else {
                scenario.log("Skipping homepage navigation due to failed login.");
            }          
            Thread.sleep(1000);
        }
    }
}