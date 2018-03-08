package com.mindtree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Flight_Finder_page {
	public Flight_Finder_page() {
		super();
		// TODO Auto-generated constructor stub
	}

	final WebDriver driver=null;
	 
	@FindBy(how=How.XPATH, using="//select[@name='passCount']")
	
	public WebElement pass_Count;
	
	@FindBy(how=How.XPATH, using="//select[@name='fromPort']")
	
	public WebElement from_Fort;
	
    @FindBy(how=How.XPATH, using="//select[@name='toPort']")
	
	public WebElement to_Fort;
    
	@FindBy(how=How.XPATH, using="//select[@name='fromMonth']")
	
	public WebElement from_Month;
	
    @FindBy(how=How.XPATH, using="//select[@name='toMonth']")
	
	public WebElement to_Month;
    
	@FindBy(how=How.XPATH, using="//select[@name='fromDay']")
	
	public WebElement from_Day;
	
    @FindBy(how=How.XPATH, using="//select[@name='toDay']")
	
	public WebElement to_Day;
    
    @FindBy(how=How.CSS, using="option[value='1']")
	
   	public WebElement pass_No;
    
    @FindBy(how=How.NAME, using="findFlights")
	
   	public WebElement find_Flights_Btn;
    
    
	
	

}
