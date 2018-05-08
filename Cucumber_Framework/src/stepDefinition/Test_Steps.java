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
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import launcher.*;

public class Test_Steps {

	public static WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		Launch_Browser launch = new Launch_Browser();
		launch.launchpage("chrome", "http://demoqa.com/registration/");
		driver = launch.getDriver();

	}

	/*
	 * @When("^User Navigate to Registration Page$") public void
	 * user_Navigate_to_LogIn_Page() throws Exception { // Write code here that
	 * turns the phrase above into concrete actions
	 * driver.findElement(By.id("menu-registration")).click(); }
	 */

	/*
	 * @When("^User enters \"(.*)\" and \"(.*)\"$") public void
	 * user_enters_UserName_and_Password(String username, String password) throws
	 * Exception { // Write code here that turns the phrase above into concrete
	 * actions driver.findElement(By.id("name_3_firstname")).sendKeys(username);
	 * driver.findElement(By.id("pwd")).sendKeys(password);
	 * driver.findElement(By.id("login")).click(); }
	 */

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
		// dat.selectByIndex(1);
		// driver.findElement(By.id("dd_date_8")).click();
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
		driver.findElement(By.id("profile_pic_10")).sendKeys("D:\\Mercury.png");
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
	public void get_page() throws Exception {
		driver.get("http://www.store.demoqa.com");
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

	}

	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser_and_Test() throws Throwable {

		// Write the code to handle Data Table

		driver.findElement(By.id("log")).clear();
		driver.findElement(By.id("log")).sendKeys("Kishan_03592");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("log")).clear();
		driver.findElement(By.name("log")).sendKeys(arg1);
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys(arg2);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);

	}

	@SuppressWarnings("deprecation")
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle());
		if (driver.findElement(By.xpath(".//*[@id='account_logout']/a")).isDisplayed())
			System.out.println("Login Successfully");
		else {
			System.out.println(" Login Failed");
			Assert.fail();
		}
	}

	@When("^User enters Creds to LogIn$")
	public void user_enters_testusers_and_Test(List<Credentials> usercredentials) throws Throwable {

		// Write the code to handle Data Table
		for (Credentials credentials : usercredentials) {
			driver.findElement(By.name("log")).clear();
			driver.findElement(By.id("log")).sendKeys(credentials.getUsername());
			driver.findElement(By.name("pwd")).clear();
			driver.findElement(By.id("pwd")).sendKeys(credentials.getPassword());
			driver.findElement(By.id("login")).click();
		}
	}

	@When("^User enters Credis to LogIn$")
	public void user_enters_testuser_and_Test(DataTable usercredentials) throws Throwable {

		// Write the code to handle Data Table
		List<Map<String, String>> data = usercredentials.asMaps(String.class, String.class);
		driver.findElement(By.id("log")).sendKeys(data.get(0).get("Username"));
		driver.findElement(By.id("pwd")).sendKeys(data.get(0).get("Password"));
		driver.findElement(By.id("login")).click();
	}

	@When("^User enters Cred to LogIn$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {

		// Write the code to handle Data Table
		List<List<String>> data = usercredentials.raw();

		// This is to get the first data of the set (First Row + First Column)
		driver.findElement(By.id("log")).sendKeys(data.get(0).get(0));

		// This is to get the first data of the set (First Row + Second Column)
		driver.findElement(By.id("pwd")).sendKeys(data.get(0).get(1));

		driver.findElement(By.id("login")).click();
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("LogOut Successfully");
	}

	@Then("^I close the browser$")
	public void i_close_the_browser() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}

}
