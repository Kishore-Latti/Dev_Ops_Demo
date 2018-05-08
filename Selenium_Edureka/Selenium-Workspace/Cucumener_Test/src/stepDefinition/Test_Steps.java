package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	
	public static WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demoqa.com/registration/");
       // driver.findElement(By.id("menu-item-374")).click();
	//    throw new PendingException();
        
     
        /*    Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            String datetime = ft.format(dNow);
            System.out.println(datetime);
            String UserName="Kishan"+datetime;
            String Mail= UserName+"gmail.com";
            */
  
	    
	}

	/*@When("^User Navigate to Registration Page$")
	public void user_Navigate_to_LogIn_Page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("menu-registration")).click();
	} */

/*	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("name_3_firstname")).sendKeys(username); 	 
	    driver.findElement(By.id("pwd")).sendKeys(password);
	    driver.findElement(By.id("login")).click();
	} */
	
	
	@When("^User enters details$")
	public void user_enters_UserName_and_Password() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("name_3_firstname")).sendKeys("Kishore.0359223"); 	 
	    driver.findElement(By.id("name_3_lastname")).sendKeys("Latti");
	    driver.findElement(By.cssSelector("input[value='married']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input[value='reading']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("dropdown_7")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("option[value='India']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("mm_date_8")).click();
	    driver.findElement(By.cssSelector("option[value='5']")).click();
	    Thread.sleep(1000);
	    Select dat = new Select(driver.findElement(By.id("dd_date_8")));
	    dat.selectByVisibleText("11");
	    //dat.selectByIndex(1);
	   //driver.findElement(By.id("dd_date_8")).click();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("option[value='6']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("yy_date_8")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("option[value='1990']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("phone_9")).sendKeys("1234567890");
	    Thread.sleep(1000);
	    driver.findElement(By.id("username")).sendKeys("Kishan.098765222");
	    Thread.sleep(1000);
	    driver.findElement(By.id("email_1")).sendKeys("kis2q222@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.id("profile_pic_10")).sendKeys("D:\\kishan.jpg");
	    Thread.sleep(1000);
	    driver.findElement(By.name("description")).sendKeys("HI this si my scripts");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password_2")).sendKeys("Test@1232322");
	    Thread.sleep(1000);
	    driver.findElement(By.id("confirm_password_password_2")).sendKeys("Test@1232322");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input[value='Submit']")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@When("^User tries to LogIn$")
	public void get_page() throws Exception{
		driver.get("http://www.store.demoqa.com");
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	
	}
	
	

	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser_and_Test() throws Throwable {
		 
		//Write the code to handle Data Table
		
			driver.findElement(By.id("log")).clear();
			driver.findElement(By.id("log")).sendKeys("Kishan_03592");
			driver.findElement(By.id("pwd")).clear();
		    driver.findElement(By.id("pwd")).sendKeys("Test@123");
		    driver.findElement(By.id("login")).click();
		    Thread.sleep(3000);
			
		
		
	}
	
	
	
	
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login Successfully");
	}

	
	
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("LogOut Successfully");
	}
}
