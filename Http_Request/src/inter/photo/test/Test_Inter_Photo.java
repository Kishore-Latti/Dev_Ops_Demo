package inter.photo.test;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mindtree.launch.LaunchBrowser;

public class Test_Inter_Photo {

	static WebDriver odriver;

	public void getDriver(WebDriver driver)
	{
		odriver=driver;
	}
	public void menuValidation()
	{


		int isPresent = odriver.findElements(By.xpath("//div[@class='widget widget_categories']/ul/li")).size();
		//li[@class='cat-item cat-item-2']
		System.out.println(isPresent);

		List<WebElement> list = odriver.findElements(By.xpath("//div[@class='widget widget_categories']/ul/li"));
		for (WebElement li : list )
		{
			System.out.println(li.getText());
		}



	}

	public void takeScreenShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);

		//Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}


	public String getTime()
	{
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		//System.out.println(current_time_str);
		return current_time_str;

	}

	public void validatePageTitles()
	{
		String URL = odriver.getCurrentUrl();
		System.out.println(" Page URL is " + URL );

		String Title = odriver.getTitle();
		System.out.println(" Page URL is " + Title );

		String Header = odriver.findElement(By.id("thesis_logo_image")).getAttribute("title");
		System.out.println(" Page Header is " + Header );

		String Footer = odriver.findElement(By.xpath("//div[@class='footer']")).getText();
		System.out.println(" Page Footer is " + Footer );

	}

	public void pageEvents()
	{
		try {

			WebDriverWait wait=new WebDriverWait(odriver, 30);

			String URL0 = odriver.getCurrentUrl();
			System.out.println(" Page  present URL is " + URL0 );

			Thread.sleep(3000);


			WebElement GAccount;
			//GAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget widget_categories']/ul/li[@class='cat-item cat-item-2']")));
			GAccount = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Blog")));
			GAccount.click();



			Thread.sleep(7000);

			odriver.navigate().refresh();
			String URL = odriver.getCurrentUrl();
			System.out.println(" Page  present URL after refresh is " + URL );

			Thread.sleep(7000);

			//odriver.findElement(By.xpath("//div[@class='widget widget_categories']/ul/li[@class='cat-item cat-item-2']")).click();

			odriver.navigate().back();

			Thread.sleep(7000);

			String URL1 = odriver.getCurrentUrl();
			System.out.println(" Page  present URL after back key is " + URL1 );

			odriver.navigate().forward();
			String URL2 = odriver.getCurrentUrl();
			System.out.println(" Page URL after forward key is " + URL2 );
		}	
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void boxValidation()
	{

		try {
			Thread.sleep(1000);
			boolean check;
			/*
			check = odriver.findElement(By.id("profession-0")).isSelected();
			System.out.println(check);
			odriver.findElement(By.id("profession-0")).click();
			check = odriver.findElement(By.id("profession-0")).isSelected();
			Thread.sleep(3000);
			System.out.println(check);
			 */
			// 1st question............................	
			WebElement ele = odriver.findElement(By.name("lastname"));
			ele.sendKeys("Latti");
			System.out.println(ele.getText());
			System.out.println(ele.getAttribute("value"));
			check = ele.isDisplayed();
			System.out.println(" Feild is displayed is : " + check);

			// 2nd Question ...................... Passing value to first name using key events

			WebElement ele1 = odriver.findElement(By.name("firstname"));
			Actions aBuilder = new Actions(odriver);
			Action creEvnt= aBuilder.moveToElement(ele1).click().keyDown(Keys.SHIFT).sendKeys("kishore").build();
			creEvnt.perform();

			odriver.findElement(By.id("datepicker")).click();		       

			//creEvnt = aBuilder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build();
			Action creEvnt1 = aBuilder.moveToElement(ele1).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).build();
			creEvnt1.perform();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	



}
