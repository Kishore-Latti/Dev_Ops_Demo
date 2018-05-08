package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook_Login {
	static WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String message = "empty";

	public void loginfacebook() {

		try {
			File src = new File(
					"D:\\Selenium_Edureka\\Selenium-Workspace\\Data_Driven_Framework\\src\\test\\java\\testData\\DataEngine.xlsx");
			// Load the file.
			FileInputStream fis = new FileInputStream(src);
			// Load he workbook.
			workbook = new XSSFWorkbook(fis);
			// Load the sheet in which data is stored.
			sheet = workbook.getSheetAt(0);
			Facebook_Login fbLog = new Facebook_Login();
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				fbLog.driverInitialization();
				cell = sheet.getRow(i).getCell(0);
				// cell.setCellType(Cell.CELL_TYPE_STRING);
				driver.findElement(By.xpath("//input[@type='email'][@name='email']")).clear();
				driver.findElement(By.xpath("//input[@type='email'][@name='email']"))
						.sendKeys(cell.getStringCellValue());

				// Import data for password.
				cell = sheet.getRow(i).getCell(1);
				// cell.setCellType(Cell.CELL_TYPE_STRING);
				driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).clear();
				driver.findElement(By.xpath("//input[@type='password'][@name='pass']"))
						.sendKeys(cell.getStringCellValue());
				// To click on Login button
				driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
				// To write data in the excel
				FileOutputStream fos = new FileOutputStream(src);
				// Message to be written in the excel sheet

				boolean val = fbLog.validateElement();
				if (val == true)
					message = "Pass";
				else if (val == false)
					message = "Fail";

				// Create cell where data needs to be written.
				sheet.getRow(i).createCell(2).setCellValue(message);
				// finally write content
				workbook.write(fos);
				Thread.sleep(4000);
				fos.close();
				driver.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void driverInitialization() {
		// To set the path of the Chrome driver.
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		// To launch facebook
		driver.get("http://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// To maximize the browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public boolean validateElement() {
		try {
			WebElement element = driver.findElement(By.partialLinkText("Kishor"));
			System.out.println(element.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
