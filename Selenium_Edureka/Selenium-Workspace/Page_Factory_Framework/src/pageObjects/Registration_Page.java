package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class Registration_Page {
 
	final WebDriver driver=null;
 
	@FindBy(how=How.ID, using="name_3_firstname")
	
	public WebElement first_Name;
	
	@FindBy(how=How.ID, using="name_3_lastname")
	
	public WebElement last_Name;
 
}
