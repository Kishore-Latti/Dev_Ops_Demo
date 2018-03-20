package config;

import static executionEngine.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {

	static WebDriver driver;
	

	public static void openBrowser(String object) {
		System.setProperty("webdriver.chrome.driver",Constants.Path_Driver);
		driver = new ChromeDriver();
	}

	public static void navigate(String object) {
		driver.get(Constants.URL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public static void click_MyAccount(String object) {
	driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	public static void input_UserName(String object) {
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(Constants.UserName);
	}

	public static void input_Password(String object) {
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(Constants.Password);
	}

	public static void click_Login(String object) {
		driver.findElement(By.id(OR.getProperty(object))).click();
	}

	public static void waitFor(String object) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void click_Logout(String object) {
		driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	public static void closeBroswer(String object) {
		driver.quit();
	}

}
