package com.mindtree.testng;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;



public class LaunchBrowser {
	static WebDriver driver ;
	public void launchpage(String browser , String url )
	{
		if (browser=="chrome")
		{
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			Path path = Path.of("").toAbsolutePath().getParent().getParent();
			
			String driverPath = path.toString() +"\\Browser-Drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver(ops);
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


		}
		else if (browser=="firefox")
		{
			try {
				Path path = Path.of("").toAbsolutePath().getParent().getParent();
				
				String driverPath = path.toString() +"\\Browser-Drivers\\geckodriver.exe";
				
				System.setProperty("webdriver.gecko.driver", driverPath);
				driver = new FirefoxDriver();			
				driver.get(url);
				Runtime.getRuntime().exec("D:\\Selenium_Edureka\\autoit-v3\\Scripts\\Authentication.exe");
				Thread.sleep(20000);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				//driver.manage().deleteAllCookies();
				//driver.manage().window().maximize();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(org.openqa.selenium.UnhandledAlertException e ) {
				// No alert found on page, proceed with test.
				e.printStackTrace();
			}




		}
		else if (browser=="ie")
		{
			System.setProperty("webdriver.ie.driver","D:\\Selenium_Edureka\\Browser-Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		}	


	}

	public WebDriver getDriver()
	{
		return driver;
	}




}




