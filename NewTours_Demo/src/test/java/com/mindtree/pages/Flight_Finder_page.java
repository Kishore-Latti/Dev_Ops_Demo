package com.mindtree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelUtils;

public class Flight_Finder_page {
	String toPort = null;
	String fromPort = null;
	String fromMonth = null;
	String toMonth = null;
	String fromDay = null;
	String toDay = null;
	int rowCount;

	public Flight_Finder_page() {
		super();
		// TODO Auto-generated constructor stub
	}

	final WebDriver driver = null;

	@FindBy(how = How.XPATH, using = "//select[@name='passCount']")

	public WebElement pass_Count;

	@FindBy(how = How.XPATH, using = "//select[@name='fromPort']")

	public WebElement from_Fort;

	@FindBy(how = How.XPATH, using = "//select[@name='toPort']")

	public WebElement to_Fort;

	@FindBy(how = How.XPATH, using = "//select[@name='fromMonth']")

	public WebElement from_Month;

	@FindBy(how = How.XPATH, using = "//select[@name='toMonth']")

	public WebElement to_Month;

	@FindBy(how = How.XPATH, using = "//select[@name='fromDay']")

	public WebElement from_Day;

	@FindBy(how = How.XPATH, using = "//select[@name='toDay']")

	public WebElement to_Day;

	@FindBy(how = How.CSS, using = "option[value='1']")

	public WebElement pass_No;

	@FindBy(how = How.NAME, using = "findFlights")

	public WebElement find_Flights_Btn;

	public void findFlights(int row) {
		rowCount = row;
		Select oSelect;
		try {
			fromPort = ExcelUtils.getCellData(rowCount, 2);
			fromMonth = ExcelUtils.getCellData(rowCount, 3);
			fromDay = ExcelUtils.getCellData(rowCount, 4);
			toPort = ExcelUtils.getCellData(rowCount, 5);
			toMonth = ExcelUtils.getCellData(rowCount, 6);
			toDay = ExcelUtils.getCellData(rowCount, 7);

			pass_Count.click();
			pass_No.click();
			oSelect = new Select(from_Fort);
			oSelect.selectByVisibleText("Frankfurt");
			Thread.sleep(2000);
			oSelect = new Select(from_Month);
			oSelect.selectByVisibleText("March");
			oSelect = new Select(from_Day);
			oSelect.selectByVisibleText("13");
			Thread.sleep(1000);
			oSelect = new Select(to_Fort);
			oSelect.selectByVisibleText("Paris");
			Thread.sleep(500);
			oSelect = new Select(to_Month);
			oSelect.selectByVisibleText("March");
			oSelect = new Select(to_Day);
			oSelect.selectByVisibleText("25");
			find_Flights_Btn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
