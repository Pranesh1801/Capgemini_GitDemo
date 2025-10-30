package com.gmail.Users.config;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver;
    public static void launchBrowser() {
        Properties prop = property_reader.readProperty();
        String browser = prop.getProperty("Browser");
 
        if (browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
        else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
        driver.manage().window().maximize();      
    }
    
    public static void closeBrowser() {
        if (driver != null) driver.quit();
    }
 
    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
