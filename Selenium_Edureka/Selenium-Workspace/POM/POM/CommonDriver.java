package co.edureka.selenium.webdriver.POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonDriver {

	private WebDriver oDriver;
	private long lngPageLoadTimeOut;
	private long lngElementDetectionTimeOut;
	
	public CommonDriver(){
		lngPageLoadTimeOut = 60L;
		lngElementDetectionTimeOut = 30L;
	}

	public WebDriver getDriver() {
		return oDriver;
	}

	public void setPageLoadTimeout(long l) {
		lngPageLoadTimeOut = l;
	}

	public void setElementDetectionTimeout(long l) {
		lngElementDetectionTimeOut = l;
				
	}

	public void openBrowser(String sBrowserType, String sUrl){
		try{
			
			switch (getBrowserTypeIndexed(sBrowserType)) {
			case 1:
				System.setProperty("webdriver.gecko.driver",
						"D:\\Akanksha\\Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
				oDriver = new FirefoxDriver();
				break;
			case 2:
				
				System.setProperty("webdriver.ie.driver", "D:\\Akanksha\\Selenium\\IEDriverServer.exe");
				oDriver = new InternetExplorerDriver();
				break;
				
			case 3:
				System.setProperty("webdriver.chrome.driver", "D:\\Akanksha\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
				oDriver = new ChromeDriver();
				break;
			default:
				throw new Exception("Unknow Browser Type = "+ sBrowserType);
				
			}
						
			if(sUrl.isEmpty()){
			
				sUrl = "about:blank";
				}
			
			oDriver.manage().window().maximize();
			oDriver.manage().deleteAllCookies();
			
			oDriver.manage().timeouts().pageLoadTimeout(lngPageLoadTimeOut, TimeUnit.SECONDS);
			
			oDriver.manage().timeouts().implicitlyWait(lngElementDetectionTimeOut, TimeUnit.SECONDS);
			
			oDriver.get(sUrl);
			
			Thread.sleep(2000);
			
			
		} catch (Throwable t){
			t.printStackTrace();
		}
	}
	
	//-----------------------------------------------------------------
	
	public void closeBrowser(){
		try{
			if(oDriver != null){
				oDriver.quit();
			}
			
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	private int getBrowserTypeIndexed(String sBrowserType){
		sBrowserType = sBrowserType.toLowerCase().trim();
		
		if(sBrowserType.isEmpty()){
			return -1;
		}
		
		if(sBrowserType.equals("ff") || sBrowserType.equals("firefox")  || sBrowserType.equals("mozilla") || sBrowserType.equals("mozilla firefox")){
			return 1;
		}
		
		if(sBrowserType.equals("ie") || sBrowserType.equals("explorer")  || sBrowserType.equals("internet explorer")){
			return 2;
		}
		
		if(sBrowserType.equals("chrome") || sBrowserType.equals("google")  || sBrowserType.equals("google chrome")){
			return 3;
		}
		
		return -1;
	}

}
