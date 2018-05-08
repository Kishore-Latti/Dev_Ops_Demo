package module.two.ass;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchGoogle {
//  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  static WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Edureka\\Browser-Drivers\\geckodriver.exe");
    driver = new FirefoxDriver();
  //  baseUrl = "https://www.google.co.in";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLaunchGoogle() throws Exception {
    driver.get("https://www.google.co.in");
    driver.findElement(By.linkText("Gmail")).click();
    driver.findElement(By.id("identifierId")).click();
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys("kishan.03592");
   /* driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("lifeisshort");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//div[@id='gb']/div/div/div[2]/div[5]/div/a/span")).click();
    driver.findElement(By.id("gb_71")).click();*/
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
