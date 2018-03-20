package com.mindtree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Select_Flight_Page {
	public Select_Flight_Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	final WebDriver driver=null;
	 
	@FindBy(how=How.NAME, using="reserveFlights")
	
	public WebElement reserve_Flight_Btn;
	
	
	public void confirmFlight()
	{
		reserve_Flight_Btn.click();
	}
}
