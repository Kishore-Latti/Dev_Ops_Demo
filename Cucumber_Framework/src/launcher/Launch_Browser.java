package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Launch_Browser {
	static WebDriver driver ;
	public void launchpage(String browser , String url )
	{
		if (browser=="chrome")
		{
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_Edureka\\Browser-Drivers\\chromedriver.exe");
			driver = new ChromeDriver(ops);
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


		}
		else if (browser=="firefox")
		{
			try {
				System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Edureka\\Browser-Drivers\\geckodriver.exe");
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
