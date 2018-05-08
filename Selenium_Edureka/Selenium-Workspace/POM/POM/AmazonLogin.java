package co.edureka.selenium.webdriver.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLogin {
	
	@FindBy(id="ap_email")
	public WebElement userId;
	
	@FindBy(id="ap_password")
	public WebElement password;
	
	@FindBy(linkText="Forgot Password")
	public WebElement forgottenAccount;
	
	@FindBy(id="signInSubmit")
	public WebElement loginButton;
	
	@FindBy(name="rememberMe")
	public WebElement keepSignIn;
	
	@FindBy(id="createAccountSubmit")
	public WebElement signUp;
	
	public AmazonLogin(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void signIn(String id, String pass){		
		userId.sendKeys(id);
		password.sendKeys(pass);
		loginButton.click();
		
	}
	
	public void signUp(){
		//instatiate your sign up page and initialize its elements
		//call action
	}
	
	


}
