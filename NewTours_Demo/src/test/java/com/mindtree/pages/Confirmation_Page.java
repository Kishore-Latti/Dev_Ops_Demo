package com.mindtree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Confirmation_Page {

	public Confirmation_Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	final WebDriver driver = null;
	@FindBy(how = How.XPATH, using = "//td[@class='frame_header_info']")
	@CacheLookup
	public WebElement conf_Text;

}
