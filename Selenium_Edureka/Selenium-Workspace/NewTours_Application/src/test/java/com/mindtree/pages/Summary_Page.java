package com.mindtree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Summary_Page {
	final WebDriver driver = null;

	@FindBy(how = How.NAME, using = "passFirst0")

	public WebElement pass_First;

	@FindBy(how = How.NAME, using = "passLast0")

	public WebElement pass_Last;

	@FindBy(how = How.XPATH, using = "//select[@name='pass.0.meal']")

	public WebElement pass_Meal;

	@FindBy(how = How.NAME, using = "creditnumber")

	public WebElement cre_No;

	@FindBy(how = How.XPATH, using = "//select[@name='cc_exp_dt_mn']")

	public WebElement cc_Month;

	@FindBy(how = How.XPATH, using = "//select[@name='cc_exp_dt_yr']")

	public WebElement cc_Year;

	@FindBy(how = How.NAME, using = "cc_frst_name")

	public WebElement cc_FirstName;

	@FindBy(how = How.NAME, using = "cc_mid_name")

	public WebElement cc_MiddleName;

	@FindBy(how = How.NAME, using = "cc_last_name")

	public WebElement cc_LastName;
	
	@FindBy(how = How.NAME, using = "billAddress2")

	public WebElement bill_Address2;
	
	@FindBy(how = How.NAME, using = "buyFlights")

	public WebElement buy_Flights_Btn;

}
