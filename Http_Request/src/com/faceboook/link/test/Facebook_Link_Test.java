package com.faceboook.link.test;

import java.awt.AWTException;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Facebook_Link_Test {

	static WebDriver driver;
	List<WebElement> links;

	String homePage = "https://www.facebook.com";
	String url ;
	HttpURLConnection huc = null;
	int respCode = 200;

	public void getDriver(WebDriver drive)
	{
		driver=drive;
	}

	public void getFooterLinks()
	{

		driver.findElement(By.id("email")).sendKeys("Kishore");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,400)");
		links = driver.findElements(By.xpath("//div[@role='contentinfo']/ul/li"));	

		Actions builder = new Actions(driver);
		Action eve;

		try {
			for (WebElement li : links )
			{
				System.out.println();

				String Text = li.getText();


				System.out.println(Text);
				System.out.println(" URL is " + url);
					WebElement ele = driver.findElement(By.partialLinkText(Text));
				eve  = builder.keyDown(Keys.CONTROL).click(ele).build();
				eve.perform();
				eve = builder.keyUp(Keys.CONTROL).build();
				eve.perform();

				Thread.sleep(500);


			}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void checkResponseCodes()
	{


		for (WebElement li : links )
		{
			String Text = li.getText();			
			System.out.println("Link text header is " +Text);
			String url = driver.findElement(By.partialLinkText(Text)).getAttribute("href");
			System.out.println(" URL is " + url);		

			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(!url.startsWith(homePage)){
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}

				Thread.sleep(4000);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
