package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registartion_Page {

	private static WebElement element = null;
	
	public static WebElement get_firstname(WebDriver driver){
		element=driver.findElement(By.id("name_3_firstname"));
		return element;
	}
	
	public static WebElement get_lastName(WebDriver driver)
	{
		element = driver.findElement(By.id("name_3_lastname"));
		return element;
	}
}
