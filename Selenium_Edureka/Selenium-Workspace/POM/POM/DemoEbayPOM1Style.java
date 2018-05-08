package co.edureka.selenium.webdriver.POM;

public class DemoEbayPOM1Style {

	public static void main(String[] args) {

		CommonDriver driver = new CommonDriver();

		driver.setPageLoadTimeout(90l);
		driver.setElementDetectionTimeout(30l);
		driver.openBrowser("chrome", "http://ebay.in");

		EbayPOM1Style homePage = new EbayPOM1Style(driver.getDriver());

		homePage.searchBox.sendKeys("Apple Watch");

		homePage.dropDown.selectByVisibleText("Watches");

		homePage.searchButton.click();

		driver.closeBrowser();

	}

}
