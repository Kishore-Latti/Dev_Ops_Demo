package automationFramework;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Registration_Page;

public class POM_TC {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Path path = Path.of("").toAbsolutePath().getParent().getParent();
		
		String driverPath = path.toString() +"\\Browser-Drivers\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver",driverPath);

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	    driver.get("http://demoqa.com/registration/");
	    
	   Registration_Page reg_page = PageFactory.initElements(driver, Registration_Page.class);
	   
	   reg_page.first_Name.sendKeys("Kishore");
	   
	   reg_page.last_Name.sendKeys("Latti");
	   
	   Thread.sleep(3000);
	   
	   driver.quit();  		
	    
	}

}
