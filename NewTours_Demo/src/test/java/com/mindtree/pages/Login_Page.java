package com.mindtree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.ExcelUtils;

public class Login_Page {
	String user = "Kish";
	String pass = "merc";
	int rowCount = 1;

	public Login_Page() {

		super();
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;

	public static WebElement username(WebDriver driver) {
		element = driver.findElement(By.name("userName"));
		return element;
	}

	@FindBy(how = How.NAME, using = "userName")

	public WebElement userName;

	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}

	@FindBy(how = How.NAME, using = "password")
	public WebElement password;

	public static WebElement login(WebDriver driver) {
		element = driver.findElement(By.name("login"));
		return element;
	}

	@FindBy(how = How.NAME, using = "login")
	public WebElement login;

	public void userLogin(int row) {
		rowCount = row;
		try {
			user = ExcelUtils.getCellData(rowCount, 0);
			pass = ExcelUtils.getCellData(rowCount, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userName.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
}
