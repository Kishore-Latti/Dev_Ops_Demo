package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FBLogin_DataProvider {
	static WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	XSSFCell cell;
	String message = "No result updated";
	//String email;
	//String password;
	static int count=0;
	File src = new File(
			"D:\\Selenium_Edureka\\Selenium-Workspace\\Data_Driven_Framework\\src\\test\\java\\testData\\DataEngine.xlsx");
	FileInputStream fis ;
	
	@Test(dataProvider="testdataset")
	public void loginfacebook(String email , String password) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
        count =count+1;
		// To launch facebook
		driver.get("http://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// To maximize the browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='email'][@name='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email'][@name='email']"))
				.sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).clear();
		driver.findElement(By.xpath("//input[@type='password'][@name='pass']"))
				.sendKeys(password);
		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
		FBLogin_DataProvider fbLog = new FBLogin_DataProvider();
		fbLog.setCellData();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		driver.close();
	}
	
	@DataProvider(name="testdataset")
	public Object[][] getCellData() throws IOException
	{
		Object[][] data = new Object[2][2];
		// Load the file.
		 fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			int j=i-1;
			cell = sheet.getRow(i).getCell(0);
			data[j][0] = cell.getStringCellValue();
			cell = sheet.getRow(i).getCell(1);
			data[j][1] = cell.getStringCellValue();
		}
		return data;
	}
	
	public void setCellData()
	{
		try {
			FileOutputStream fos;		
			fos = new FileOutputStream(src);
			
			// Message to be written in the excel sheet
			FBLogin_DataProvider fbLog1 = new FBLogin_DataProvider();
			boolean val = fbLog1.validateElement();
			if (val == true)
				message = "Pass";
			else if (val == false)
				message = "Fail";
			//workbook = new XSSFWorkbook(fis);
			// Load the sheet in which data is stored.
			//sheet = workbook.getSheetAt(0);
			sheet.getRow(count).createCell(2).setCellValue(message);
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
