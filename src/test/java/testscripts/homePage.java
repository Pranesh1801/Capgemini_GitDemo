package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	WebDriver driver;

	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	By registerEle = By.xpath("//a[normalize-space()='Register']");
	By gender = By.id("gender-male");
	By firstName = By.name("FirstName");
	By lastName = By.name("LastName");
	By email = By.name("Email");
	By password = By.id("Password");
	By confirmPassword = By.id("ConfirmPassword");
	By register = By.id("register-button");

	public void getRegister(String firstname, String lastname, String mail, String pwd, String cpwd) {
		driver.findElement(registerEle).click();
		driver.findElement(gender).click();
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmPassword).sendKeys(cpwd);
		driver.findElement(register).click();
	}

	By logLink = By.xpath("//a[normalize-space()='Log in']");
	By logmail = By.id("Email");
	By logpass = By.id("Password");
	By logsub = By.xpath("//input[@value='Log in']");
	By logout = By.xpath("//a[normalize-space()='Log out']");

	public void login(String mail, String pwd) {
		driver.findElement(logLink).click();
		driver.findElement(logmail).sendKeys(mail);
		driver.findElement(logpass).sendKeys(pwd);
		driver.findElement(logsub).click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement logo;
	
	public void logout() {
		logo.click();
	}
}