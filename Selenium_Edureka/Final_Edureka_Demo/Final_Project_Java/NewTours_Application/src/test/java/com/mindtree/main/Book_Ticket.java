package com.mindtree.main;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import com.mindtree.launcher.*;
import com.mindtree.pages.*;

import com.mindtree.email.*;

//@Listeners(Jyperion_Pdf.class)

public class Book_Ticket {

	Launch_Browser launch = new Launch_Browser();
	static WebDriver driver;
	WebElement element;
	Select oSelect;

	@BeforeTest
	public void launchPage() {
		launch.launchpage("chrome", "http://newtours.demoaut.com");
		driver = launch.getDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void takeScreenshot() throws IOException {
		// Convert web driver object to TakeScreenshot
		Book_Ticket test = new Book_Ticket();
		String date = test.getTime();
		String Path = "D:\\Selenium_Edureka\\Selenium-Workspace\\NewTours_Application\\ScreenShots\\S_" + date + ".png";

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(Path);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
	}

	public String getTime() {
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		// System.out.println(current_time_str);
		return current_time_str;

	}

	@Test(priority = 0)
	public void loginPage() {
		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
		System.out.println(" Page Title is: " + driver.getTitle());
		Login_Page.username(driver).sendKeys("Kishan.03592");
		Login_Page.password(driver).sendKeys("mercury");
		Login_Page.login(driver).click();

	}

	@Test(priority = 1)
	public void flightFinder() {
		try {
			if (driver.getTitle() != "Find a Flight: Mercury Tours:") {
				System.out.println(" User failed to login Please try again");
			}
			Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
			System.out.println(" Page Title is: " + driver.getTitle());
			// driver.findElement(By.cssSelector("input[value='oneway']")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Flight_Finder_page flightPage = PageFactory.initElements(driver, Flight_Finder_page.class);
			flightPage.pass_Count.click();
			flightPage.pass_No.click();
			element = flightPage.from_Fort;
			oSelect = new Select(element);
			oSelect.selectByVisibleText("Frankfurt");
			Thread.sleep(2000);
			element = flightPage.from_Month;
			oSelect = new Select(element);
			oSelect.selectByVisibleText("March");
			element = flightPage.from_Day;
			oSelect = new Select(element);
			oSelect.selectByVisibleText("13");
			Thread.sleep(1000);
			element = flightPage.to_Fort;
			oSelect = new Select(element);
			oSelect.selectByVisibleText("Paris");
			Thread.sleep(500);
			element = flightPage.to_Month;
			oSelect = new Select(element);
			oSelect.selectByVisibleText("March");
			element = flightPage.to_Day;
			oSelect = new Select(element);
			oSelect.selectByVisibleText("25");
			flightPage.find_Flights_Btn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void selectFlightPage() {
		Select_Flight_Page selFlight = PageFactory.initElements(driver, Select_Flight_Page.class);
		Assert.assertEquals("Select a Flight: Mercury Tours", driver.getTitle());
		System.out.println(" Page Title is: " + driver.getTitle());
		selFlight.reserve_Flight_Btn.click();
	}

	@Test(priority = 3)
	public void summaryPage() {
		Summary_Page sumPage = PageFactory.initElements(driver, Summary_Page.class);
		Assert.assertEquals("Book a Flight: Mercury Tours", driver.getTitle());
		System.out.println(" Page Title is: " + driver.getTitle());
		sumPage.pass_First.sendKeys("Kishore");
		sumPage.pass_Last.sendKeys("Latti");
		element = sumPage.pass_Meal;
		oSelect = new Select(element);
		oSelect.selectByVisibleText("Hindu");
		sumPage.cre_No.sendKeys("123456789");
		element = sumPage.cc_Month;
		oSelect = new Select(element);
		oSelect.selectByVisibleText("09");
		element = sumPage.cc_Year;
		oSelect = new Select(element);
		oSelect.selectByVisibleText("2010");
		sumPage.cc_FirstName.sendKeys("Kishore");
		sumPage.cc_MiddleName.sendKeys("Jagadish");
		sumPage.cc_LastName.sendKeys("Latti");

		sumPage.bill_Address2.sendKeys("Global Village");
		sumPage.buy_Flights_Btn.click();

	}

	@Test(priority = 4)
	public void confirmationPage() {
		Confirmation_Page confPage = PageFactory.initElements(driver, Confirmation_Page.class);
		Assert.assertEquals("Flight Confirmation: Mercury Tours", driver.getTitle());
		System.out.println(" Page Title is: " + driver.getTitle());
		System.out.println(".......Please find Booking Confirmation Details.....\n");
		System.out.println(confPage.conf_Text.getText());
		System.out.println("\n.....................................................");
	}

	@AfterSuite
	public void triggerMail() {
		Email_Conf sendMail = new Email_Conf();
		sendMail.sendPDFReportByGMail();

	}
/*
	@AfterClass
	public void sendMail() {
		Email_Sender sendEmail = new Email_Sender();
		sendEmail.sendMail();

	}*/

}
