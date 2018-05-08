package co.edureka.selenium.webdriver.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayPOM1Style {
	
	WebElement searchBox;
	WebElement selectBox;
	Select dropDown;
	WebElement searchButton;
	WebElement result;
	
	public EbayPOM1Style(WebDriver driver){
		searchBox = driver.findElement(By.id("gh-ac"));
		selectBox = driver.findElement(By.id("gh-cat"));
		
		dropDown = new Select(selectBox);
		
		searchButton = driver.findElement(By.id("gh-btn"));
	}

}
