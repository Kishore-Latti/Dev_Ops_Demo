package executionEngine;

import utility.ExcelUtils;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import config.*;

public class DriverScript {

	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method method[];
	public static Properties OR;
	public static String sPageObject;

	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		// This will load all the methods of the class 'ActionKeywords' in it.
		// It will be like array of method, use the break point here and do the watch
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {

		String sPath = Constants.Path_TestData;
		String Path_OR = Constants.Path_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		OR = new Properties(System.getProperties());
		OR.load(fs);
		ExcelUtils.setExcelFile(sPath);
		DriverScript scripts = new DriverScript();
		scripts.execute_TestCase();
	}

	private void execute_TestCase() throws Exception {
		// This will return the total number of test cases mentioned in the Test cases
		// sheet
		int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		// This loop will execute number of times equal to Total number of test cases
		for (int iTestcase = 1; iTestcase <= iTotalTestCases; iTestcase++) {
			// This is to get the Test case name from the Test Cases sheet
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
			// This is to get the value of the Run Mode column for the current test case
			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);
			// This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")) {
				// Only if the value of Run Mode is 'Yes', this part of code will execute
				iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
				// This loop will execute number of times equal to Total number of test steps
				for (;iTestStep <= iTestLastStep; iTestStep++) {
					sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,
							Constants.Sheet_TestSteps);
					sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject,
							Constants.Sheet_TestSteps);
					execute_Actions();
				}
			}
		}
	}

	private static void execute_Actions() throws Exception {
		// method variable contain all the method and method.length returns the total
		// number of methods
		for (int i = 0; i < method.length; i++) {
			// This is now comparing the method name with the ActionKeyword value got from
			// excel
			if (method[i].getName().equals(sActionKeyword)) {
				// In case of match found, it will execute the matched method
				method[i].invoke(actionKeywords, sPageObject);
				// Once any method is executed, this break statement will take the flow outside
				// of for loop
				break;
			}
		}

	}

}
