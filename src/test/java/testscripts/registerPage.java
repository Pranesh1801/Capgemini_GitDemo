package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {
	WebDriver driver;

	By registerLink = By.linkText("Register");
	By gender = By.id("gender-female");
	By firstName = By.name("FirstName");
	By lastname = By.xpath("//input[@id='LastName']");
	By email = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	By confirmPassword = By.xpath("//input[@id='Confirm Password']");
	By registerButton = By.xpath("//input[@id='register-button']");

	public void RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getRegister() {
		driver.findElement(registerLink).click();
		driver.findElement(gender).click();
		driver.findElement(firstName).sendKeys("ababa");
		driver.findElement(lastname).sendKeys("oyaba");
		driver.findElement(email).sendKeys("abaya@kno.com");
		driver.findElement(password).sendKeys("boom");
		driver.findElement(confirmPassword).sendKeys("boom");
		driver.findElement(registerButton).click();
	}
}