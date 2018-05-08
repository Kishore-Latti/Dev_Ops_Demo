package com.mindtree.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Barne_Home_Page {

	final WebDriver driver=null;
	
	 @FindBy(partialLinkText="Books")
	 public WebElement booksLink;
	 
	 @FindBy(partialLinkText="Biography")
	 public WebElement bioGraphy;
	 
	 @FindBy(how=How.NAME,using="login")
	 public WebElement login_btn;
	 
	 @FindBy(xpath="//div[@class='modal__content modal--611-wide focus']//a[@href='#']")
	 public WebElement close_btn;
	 
	 @FindBy(xpath="//h1[@class='header-with-brackets']//span[@class='text-container']")
	 public WebElement bio_text;
	 
	 @FindBy(xpath="//section[@id='hotBooksWithDesc_Bestsellers']//h2[@class='rule mb-xs']")
	 public WebElement seller_text;
	 
	 
}
