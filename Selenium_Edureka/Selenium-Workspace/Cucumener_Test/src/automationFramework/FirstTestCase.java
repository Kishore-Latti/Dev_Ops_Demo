package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.19.1\\geckodriver.exe");

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");

		//WebDriver driver = new  FirefoxDriver();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);



		driver.get("https://www.redbus.in/");

		

		System.out.println(" Successfully opened browser");


		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);

		//driver.manage().window().maximize();

		driver.findElement(By.id("src")).sendKeys("Banaglore");

		driver.findElement(By.id("dest")).sendKeys("Belgaum Bypass");
		driver.findElement(By.className("autoFill")).sendKeys("Belgaum Bypass");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.document.getElementById('onward_cal').setAttribute('value','5-Feb-2018')");


		driver.findElement(By.id("search_btn")).click();



		// driver.close();





	}

}
