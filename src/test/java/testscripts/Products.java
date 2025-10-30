package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {
	WebDriver driver;

	public Products(WebDriver driver) {
		this.driver = driver;
	}
	By searchBox = By.id("small-searchterms");
	By searchBut = By.xpath("//input[@value='Search']");
	public void searchBook(String name) {
		driver.findElement(searchBox).sendKeys(name);
		driver.findElement(searchBut).click();
	}
}
