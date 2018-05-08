package co.edureka.selenium.webdriver.POM;

public class DemoEbayPOM3Style {

	public static void main(String[] args) {
		CommonDriver driver = new CommonDriver();

		driver.setPageLoadTimeout(90l);
		driver.setElementDetectionTimeout(30l);
		driver.openBrowser("chrome", "http://ebay.in");

		EbayPOM3Style homePage = new EbayPOM3Style(driver.getDriver());

		homePage.searchProduct("Apple Watch", "Watches");

	}

}
