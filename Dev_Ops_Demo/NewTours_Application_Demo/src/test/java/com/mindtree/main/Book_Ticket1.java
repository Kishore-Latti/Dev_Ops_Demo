package com.mindtree.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mindtree.launcher.Launch_Browser;
import com.mindtree.pages.Confirmation_Page;
import com.mindtree.pages.Flight_Finder_page;
import com.mindtree.pages.Login_Page;
import com.mindtree.pages.Select_Flight_Page;
import com.mindtree.pages.Summary_Page;
import com.mindtree.email.Email_Conf;

import com.mindtree.pages.Flight_Finder_page;
import com.mindtree.pages.Login_Page;

public class Book_Ticket1 extends Book_Ticket {

	@Test(priority = 0)
	public void loginPage() {
		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
		System.out.println(" Page Title is: " + driver.getTitle());
		Login_Page.username(driver).sendKeys("Kishan.03592");
		Login_Page.password(driver).sendKeys("mercury");
		Login_Page.login(driver).click();

	}

	@Test(priority = 1)
	public void findFlights() {
		try {
			if (driver.getTitle() != "Find a Flight: Mercury Tours:") {
				System.out.println(" User failed to login Please try again");
			}
			Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
			System.out.println(" Page Title is: " + driver.getTitle());
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

	public Book_Ticket1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Book_Ticket1 bticket = new Book_Ticket1();
		bticket.launchPage();
	}
}
