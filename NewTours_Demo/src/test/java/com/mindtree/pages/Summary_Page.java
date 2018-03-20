package com.mindtree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelUtils;

public class Summary_Page {
	public Summary_Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	int rowCount;
	String fName;
	String mName;
	String lName;
	String passMeal;
	String cardNo;
	String cardMonth;
	String cardYear;
	String address;
	
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
	
	public void fillUserInfo(int row)
	{
		try {
			rowCount=row;
			fName = ExcelUtils.getCellData(rowCount, 8);
			mName = ExcelUtils.getCellData(rowCount, 9);
			lName = ExcelUtils.getCellData(rowCount, 10);
			passMeal=ExcelUtils.getCellData(rowCount, 11);
			cardNo=ExcelUtils.getCellData(rowCount, 12);
			cardMonth=ExcelUtils.getCellData(rowCount, 13);
			cardYear=ExcelUtils.getCellData(rowCount, 14);
			address=ExcelUtils.getCellData(rowCount, 15);
			Select oSelect;
			pass_First.sendKeys(fName);
			pass_Last.sendKeys(lName);
			Thread.sleep(500);
			oSelect = new Select(pass_Meal);
			oSelect.selectByVisibleText(passMeal);
			Thread.sleep(2000);
			System.out.println(cardNo);
			cre_No.sendKeys(cardNo);
			Thread.sleep(1000);
			oSelect = new Select(cc_Month);
			oSelect.selectByVisibleText(cardMonth);	
			Thread.sleep(1000);
			oSelect = new Select(cc_Year);
			oSelect.selectByVisibleText(cardYear);
			Thread.sleep(1000);
			cc_FirstName.sendKeys(fName);
			Thread.sleep(500);
			cc_MiddleName.sendKeys(mName);
			Thread.sleep(500);
			cc_LastName.sendKeys(lName);
			Thread.sleep(500);
			bill_Address2.sendKeys(address);
			Thread.sleep(500);
			buy_Flights_Btn.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
