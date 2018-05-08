package inter.photo.test;

import org.openqa.selenium.WebDriver;

import com.faceboook.link.test.Facebook_Link_Test;
import com.mindtree.launch.LaunchBrowser;

public class Main_Module {
	
	static WebDriver driver ;
	
	public static void main(String[] args) {

		LaunchBrowser launcher = new LaunchBrowser();
		Test_Inter_Photo test = new Test_Inter_Photo();




		/*//................................. Module 3.............................
		// Answer for question 1 

		launcher.launchpage("ie","https://www.google.com");
		launcher.logToGmail();

		// Answer for question 2


		launcher.launchpage("chrome", "https://www.opensourcecms.com/demo/1/319/InterPhoto+Image+Gallery");



        test.menuValidation();
        String date= test.getTime();
        String Spath = "D:\\Selenium_Edureka\\Screenshots\\S_"+date+".png";
        try {
			test.takeScreenShot(odriver,Spath );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Answer for question 3 
		test.validatePageTitles();

		// Answer for question 4 
		test.pageEvents();
		// ..................................Module 3............................................


		// .................................... Module 4 .........................................
		launcher.launchpage("chrome", "http://toolsqa.com/automation-practice-form/");
		driver = launcher.getDriver();
		test.getDriver(driver);		
		test.boxValidation();

	
		// .................................... Module 4 .........................................
		
		//.................... Module 5 .....................
		
		// Answer for question 1 

		launcher.launchpage("chrome","https://www.google.com");
		launcher.logToGmail();
		
		//.................... Module 5 .....................
		 
		 
		 */
		
		
		// ............................. MODULE 6 ...............
		launcher.launchpage("firefox", "http://www.facebook.com");
		driver = launcher.getDriver();
		Facebook_Link_Test link = new Facebook_Link_Test();
		link.getDriver(driver);
		link.getFooterLinks();
		link.checkResponseCodes();
	}


}
