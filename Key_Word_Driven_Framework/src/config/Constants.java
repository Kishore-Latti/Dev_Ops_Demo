package config;

public class Constants {

	// This is the list of System Variables
	// Declared as 'public', so that it can be used in other classes of this project
	// Declared as 'static', so that we do not need to instantiate a class object
	// Declared as 'final', so that the value of this variable can be changed
	// 'String' & 'int' are the data type for storing a type of value
	public static final String URL = "http://www.store.demoqa.com";
	static String path = System.getProperty("user.dir");
	
	public static final String Path_TestData = path + "\\src\\dataEngine\\DataEngine.xlsx";
	public static final String File_TestData = "DataEngine.xlsx";
	public static final String Path_OR = path +  "\\src\\config\\OR.txt";
	public static final String Path_Driver = "C:\\personal_repo\\Dev_Ops_Demo\\Selenium_Edureka\\Browser-Drivers\\chromedriver.exe";

	// List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;
	public static final int Col_TestScenarioID = 1;
	public static final int Col_PageObject =3 ;
	public static final int Col_ActionKeyword = 4;
	public static final int Col_RunMode =2 ;
	

	// List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
	public static final String Sheet_TestCases = "Test Cases";

	// List of Test Data
	public static final String UserName = "Kishan_03592";
	public static final String Password = "Test@123";

}
