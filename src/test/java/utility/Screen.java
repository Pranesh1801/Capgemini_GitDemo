package utility;
 
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class Screen {
	public void screen(WebDriver driver) {
		TakesScreenshot sc= (TakesScreenshot) driver;
		File f= sc.getScreenshotAs(OutputType.FILE);
		String check = datetime();
		File f2= new File(".\\src\\test\\java\\Reports\\"+check+".png");
		try {
			FileUtils.copyFile(f, f2);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String datetime() {
		Date dt=new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String s= df.format(dt);
		return s;
	}
	public WebDriver setup(String browser) {
		WebDriver driver = null;
		browser.toLowerCase();
		System.out.println(Thread.currentThread().getId());
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", "C:\\Selinium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
 
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Selinium\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
 
		default:
			System.out.println("Broswer not found");
		} 
		return driver;
	}
}