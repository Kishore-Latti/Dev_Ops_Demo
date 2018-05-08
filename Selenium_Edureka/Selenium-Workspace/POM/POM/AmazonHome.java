package co.edureka.selenium.webdriver.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome {
	
	WebDriver myDriver;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(id="searchDropdownBox")
	public WebElement selectBox;
	
	@FindBy(xpath="//input[@value='Go']")
	public WebElement searchButton;
	
	@FindBy(linkText="Your Amazon.in")
	public WebElement yourAmazon;
	
	@FindBy(linkText="Today's Deals")
	public WebElement dealOfTheDay;
	
	public AmazonHome(WebDriver driver){
		myDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void yourAmazon(){
		yourAmazon.click();
		AmazonLogin loginPage = new AmazonLogin(myDriver);
		loginPage.signIn("akanksha24.a@gmail.com", "password");
	}
	
	public void dealOfTheDay(){
		//write the code for today's deal
		
	}
	

}
