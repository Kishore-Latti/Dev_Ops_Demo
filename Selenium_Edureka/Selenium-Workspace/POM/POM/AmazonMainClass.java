package co.edureka.selenium.webdriver.POM;

public class AmazonMainClass {

	public static void main(String[] args) {
	
		CommonDriver driver = new CommonDriver();
		driver.openBrowser("chrome", "http://www.amazon.in");
		AmazonHome homePage = new AmazonHome(driver.getDriver());
		
		homePage.yourAmazon();
		driver.closeBrowser();

	}

}
