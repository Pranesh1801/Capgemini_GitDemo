package com.gmail.Users.StepDef;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.Users.pages.User_Interaction;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginDemo {
	WebDriver driver = new ChromeDriver();
	Scenario scenario;
	User_Interaction ui;
	
	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        this.ui = new User_Interaction(driver, scenario);

    }

	@Given("^I navigate to login page$")
	public void i_navigate_to_login_page() throws Throwable {
		ui.navigateToLoginPage();
	}

	
	@When("I insert {string} and {string}")
	public void i_insert_username_and_password(String uname, String pass) throws Throwable {
		ui.enterCredentials(uname, pass);
	}

	@But("^Invalid pwd$")
	public void invalid_pwd() throws Throwable {
		System.out.println("Invalid password");
	}

	@And("^I clicked signin button$")
	public void i_clicked_signin_button() throws Throwable {
//		WebElement submit = driver.findElement(By.name("submit"));
//		submit.click();
//		WebElement sc = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
//		Assert.assertEquals(sc.getText(), "Login Successfully");
//		System.out.println("Ok done...");
		ui.clickSignIn();
	}
	
	
//	@And("I test the following credentials")
//	public void i_test_the_following_credentials(io.cucumber.datatable.DataTable dataTable) throws Throwable {
//	    List<List<String>> rows = dataTable.asLists(String.class);
//
//	    for (List<String> row : rows) {
//	        String uname = row.get(0);
//	        String pass = row.get(1);
//
//	        driver.get("https://demo.guru99.com/test/newtours/");
//	        System.out.println("Testing credentials: Username: " + uname + ", Password: " + pass);
//
//	        driver.findElement(By.name("userName")).sendKeys(uname);
//	        driver.findElement(By.name("password")).sendKeys(pass);
//	        driver.findElement(By.name("submit")).click();
//
//	        try {
//	            WebElement successMsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
//	            Assert.assertEquals(successMsg.getText(), "Login Successfully");
//	            System.out.println("Login successful for: " + uname);
//	        } 
//	        catch (Exception e) {
//	            System.out.println("Login failed for: " + uname);
//	        }
//
//	        try {
//	            driver.findElement(By.linkText("SIGN-OFF")).click();
//	        } 
//	        catch (Exception e) {
//
//	        }
//
//	        Thread.sleep(1000);
//	    }
//	}
	
	@And("I test the following credentials")
	public void i_test_the_following_credentials(io.cucumber.datatable.DataTable dataTable) throws Throwable {
		List<List<String>> rows = dataTable.asLists(String.class);
        ui.testMultipleCredentials(rows);

//	    List<List<String>> rows = dataTable.asLists(String.class);
//
//	    for (List<String> row : rows) {
//	        String uname = row.get(0);
//	        String pass = row.get(1);
//
//	        driver.get("https://demo.guru99.com/test/newtours/");
//	        scenario.log("Testing credentials: Username: " + uname + ", Password: " + pass);
//
//	        driver.findElement(By.name("userName")).sendKeys(uname);
//	        driver.findElement(By.name("password")).sendKeys(pass);
//	        driver.findElement(By.name("submit")).click();
//
//	        try {
//	            WebElement successMsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
//	            Assert.assertEquals(successMsg.getText(), "Login Successfully");
//	            scenario.log("Login successful for: " + uname);
//	        } catch (Exception e) {
//	            scenario.log("Login failed for: " + uname);
//	        }
//
//	        try {
//	            driver.findElement(By.linkText("SIGN-OFF")).click();
//	            scenario.log("Logged out after attempt.");
//	        } catch (Exception e) {
//	            scenario.log("Could not log out — possibly failed login.");
//	        }
//	        Thread.sleep(1000);
//	    }
	}

	@Then("^Its navigated to the HomePage$")
	public void itas_navigated_to_the_HomePage() throws Throwable {
//		driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
//		System.out.println("compeleted...");
		ui.goToHomePage();
	}
	
//	@Given("I entered")
//	public void i_entered(io.cucumber.datatable.DataTable dataTable) throws Throwable {
//		WebElement us=driver.findElement(By.name("userName"));
//		WebElement pw=driver.findElement(By.name("password"));
//		List<List<String>> ele=dataTable.cells();
//		for(List<String> s:ele) {
//			us.sendKeys(s.get(0));
//			pw.sendKeys(s.get(1));
//			us.clear();
//			pw.clear();
//			Thread.sleep(1000);
//		}
//	}
}

//package com.gmail.Users.StepDef;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//public class loginDemo {
//	WebDriver driver = new ChromeDriver();
//
//	@Given("I navigate to login page")
//	public void i_navigate_to_login_page() {
//		
//		driver.get("https://demo.guru99.com/test/newtours/");
//		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/test/newtours/");
//		System.out.println("Page Navigated");
//	}
//
//	@And("I entered username and password")
//	public void i_entered_username_and_password() {
//		
//		WebElement username = driver.findElement(By.name("userName"));
//		username.sendKeys("mercury");
//		WebElement password = driver.findElement(By.name("password"));
//		password.sendKeys("mercury");
//		System.out.println("Data Entered");
//	}
//
//	@And("I clicked signin button")
//	public void i_clicked_signin_button() {
//		
//		WebElement submit = driver.findElement(By.name("submit"));
//		submit.click();
//		WebElement sc = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
//		Assert.assertEquals(sc.getText(), "Login Successfully");
//		System.out.println("Button clicked");
//	}
//
//	@Then("Its navigated to the HomePage")
//	public void its_navigated_to_the_home_page() {
//		driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
//		System.out.println("Homepage Launched");
//	}
//}
