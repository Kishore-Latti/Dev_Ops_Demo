import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Songs_Download {
	
	static WebDriver driver;

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_Edureka\\Browser-Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://pagalworld.info/01-happy-happy-blackmail-badshah-320kbps-mp3/download.html");
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			WebElement ele = driver.findElement(By.partialLinkText("Download Original MP3"));
			Actions action= new Actions(driver);
			action.moveToElement(ele);
			action.contextClick(ele).build().perform();
			Thread.sleep(3000);
			Screen screen = new Screen();			
			Pattern save_linnk = new Pattern("D:\\Selenium_Edureka\\Sikuli_Images\\Saveas.png");
			screen.click(save_linnk);			
			Thread.sleep(8000);
			String command ="D:\\Selenium_Edureka\\autoit-v3\\Scripts\\FileSave.exe";
			Runtime.getRuntime().exec(command);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
