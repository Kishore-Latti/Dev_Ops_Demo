package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.Registartion_Page;

public class POM_TC {
	
	private static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	    driver.get("http://demoqa.com/registration/");
	    
	    Registartion_Page.get_firstname(driver).sendKeys("Kishore");
	    
	    Registartion_Page.get_lastName(driver).sendKeys("Latti");

	    Thread.sleep(3000);
	    
	    driver.quit();
	}

}
