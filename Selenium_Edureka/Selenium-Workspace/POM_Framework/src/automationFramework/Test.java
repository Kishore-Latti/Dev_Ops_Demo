package automationFramework;

import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	private static WebDriver driver = null ;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    
	Path path = Path.of("").toAbsolutePath().getParent().getParent();
		
	String driverPath = path.toString() +"\\Browser-Drivers\\chromedriver.exe";

    System.setProperty("webdriver.chrome.driver",driverPath);
    
    driver = new ChromeDriver();
    
    driver.get("https://www.facebook.com/");
    
	}

}
