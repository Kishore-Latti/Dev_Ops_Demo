package automation.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pom.pages.Barne_Home_Page;
import com.mindtree.pom.pages.Login_Page;

public class POM_Test1 {

	static Login_Page loginPage;
	static Barne_Home_Page barnePage;
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium_Edureka\\Browser-Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		POM_Test1 pomPage = new POM_Test1();
		
		//.......... Question 1 ................

		pomPage.Login_Check();
		
		//.......... Question 2 ................
		pomPage.Validate_Barne();

	}

	public void Login_Check() {
		driver.get("http://newtours.demoaut.com");

		loginPage = PageFactory.initElements(driver, Login_Page.class);
		loginPage.username.sendKeys("Kishan.03592");
		loginPage.password.sendKeys("mercury");
		loginPage.login_btn.click();
		boolean val = loginPage.oneway_btn.isDisplayed();
		if (val == true) {
			System.out.println(" Login successfull");
		} else
			System.out.println(" Login Unsuccessfull");
	}

	public void Validate_Barne() {
		try {
			driver.get("http://barnesandnoble.com");
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			barnePage = PageFactory.initElements(driver, Barne_Home_Page.class);
			Thread.sleep(3000);
			barnePage.close_btn.click();
			Thread.sleep(3000);
			Actions builder = new Actions(driver);
			builder.moveToElement(barnePage.booksLink).clickAndHold(barnePage.booksLink).build().perform();			
			barnePage.bioGraphy.click();
			
			String Bio_Text = barnePage.bio_text.getText();
			if ( Bio_Text.contains("Biography"))
			{
				System.out.println(" Biography is present");
				
			}
			else 
				System.out.println( " Biography is not present");
			
			String Seller_Text = barnePage.seller_text.getText();
			
			if ( Seller_Text.contains("Bestsellers"))
			{
				System.out.println(" Bestsellers is present");
				
			}
			else 
				System.out.println( " Bestsellers is not present");
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
