package com.selenium.rc.test;



import com.thoughtworks.selenium.*;


@SuppressWarnings("deprecation")
public class RC_Launch_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*	String DrivPath = "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Edureka\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		// To Accept SSL certificate
		//capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); */
		
	//Selenium selenium = new DefaultSelenium("localhost",4444,"*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","https://www.facebook.com");
		Selenium selenium = new DefaultSelenium("localhost",4444,"*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe","https://www.facebook.com"); 
		selenium.start();
	  selenium.open("/");
	  
	  selenium.isVisible("id=email");
	  selenium.type("id=email","kishan.03592@gmail.com");
	  selenium.isVisible("id=pass");
	  selenium.type("id=pass","1234542");
	  selenium.click("id=u_0_2");
	  selenium.isVisible("id=email");
	}

}
