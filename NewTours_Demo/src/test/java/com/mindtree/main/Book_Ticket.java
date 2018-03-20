package com.mindtree.main;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import com.mindtree.launcher.Launch_Browser;
import com.mindtree.pages.Confirmation_Page;
import com.mindtree.pages.Flight_Finder_page;
import com.mindtree.pages.Login_Page;
import com.mindtree.pages.Select_Flight_Page;
import com.mindtree.pages.Summary_Page;
import utility.Constants;
import utility.ExcelUtils;

import com.mindtree.email.Email_Conf;

public class Book_Ticket {
	static String path = System.getProperty("user.dir");

	@BeforeSuite
	public void getData() {
		try {
			ExcelUtils.setExcelFile(Constants.Path_TestData, "MercuryTourData");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Book_Ticket() {
		super();
	}

	Launch_Browser launch = new Launch_Browser();
	static WebDriver driver;
	WebElement element;
	Select oSelect;

	@BeforeClass
	public void test() {
		System.out.println(" I a used");
		launch.demo();
	}

	@BeforeClass
	public void test1() {
		try {
			Files.copy(Paths.get(path + "\\src\\test\\resources\\Mercury.png"), Paths.get("D:\\Mercury.png"),
					StandardCopyOption.REPLACE_EXISTING);
			Files.copy(Paths.get(path + "\\src\\test\\resources\\pdfngreport.properties"),
					Paths.get("D:\\pdfngreport.properties"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void launchPage() {
		launch.launchpage("chrome", Constants.URL);
		driver = launch.getDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void takeScreenshot() throws IOException {
		// Convert web driver object to TakeScreenshot
		Book_Ticket test = new Book_Ticket();
		String date = test.getTime();
		String Path = path + "\\ScreenShots\\S_" + date + ".png";
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(Path);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public String getTime() {
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		return current_time_str;
	}

	@AfterSuite
	public void triggerMail() {
		Email_Conf sendMail = new Email_Conf();
		sendMail.sendPDFReportByGMail();

	}
}
