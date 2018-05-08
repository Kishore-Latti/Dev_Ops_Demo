package com.mindtree.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Page {
	final WebDriver driver=null;
	
 @FindBy(name="userName")
 public WebElement username;
 
 @FindBy(name="password")
 public WebElement password;
 
 @FindBy(how=How.NAME,using="login")
 public WebElement login_btn;
 
 @FindBy(how=How.CSS,using="input[value='oneway']")
 public WebElement oneway_btn;
 

 


}
