package tests;

import org.testng.annotations.Test;

public class DataDrivenTest {

	@Test
	public void fbLoginLogout() {
		// Import excel sheet.
    Facebook_Login fblog = new Facebook_Login();
    fblog.loginfacebook();
     
	}
}