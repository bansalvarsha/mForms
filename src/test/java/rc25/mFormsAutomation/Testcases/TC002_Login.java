package rc25.mFormsAutomation.Testcases; 

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rc25.mFormsAutomation.Actions_Home.Home_Action;
import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(main.resources.logging.Listener.class)
public class TC002_Login {
	public WebDriver driver;
	private String sTestCaseName;
	
	// Create object of extent report and specify the Class name in get method in my case I have used AdvanceReporting.class
	private ExtentReports extent= ExtentReports.get(TC002_Login.class);
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void beforeMethod() throws Exception {
		try{
		DOMConfigurator.configure("log4j.xml");
		
		// Getting the Test Case name, we will get long test case name including package and class name etc.
	  	sTestCaseName = this.toString();
	  	
	  	// This method will refine test case name, exactly the name we have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// For setting up Excel for Data driven testing
		ExcelUtils.setExcelFile(ExcelPaths.excelfilename, Constant.loginSheetName);
		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver= Utils.OpenBrowser();
					
		// Initializing the Base Class for Selenium driver, we do need to provide the Selenium driver to any of the Page classes or Module Actions
		new BaseClass(driver);
		
		// Call init method and specify the location where you want to save this report second parameter is set to true it means it will overwrite report with new one
		extent.init(Constant.ReportsLocation, true);
		
		extent.startTest(sTestCaseName, "Login test to check the login with valid or invalid credentials");
		extent.config().displayCallerClass(false);
		extent.config().displayTestHeaders(true);
		extent.config().documentTitle("mForms Automation Testing");
		extent.config().reportHeadline("mForms Automation Test Report of Selenium WebDriver");
		extent.config().reportTitle("mForms Automation");
		extent.config().useExtentFooter(false);
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}

	@Test
	public void main() throws Exception{
		try{
			//verify the home page/login page content like logo, banner text, copy right text and version number of the application
			Home_Action.Home_content_Verification();
			
			//This is to get the total number of rows in excel file which will get from ExcelUtils.java file
			int TotalNumberOfRows= ExcelUtils.getRowUsed();
			 
			//This loop is for perform the login action for multiple number of users available in excel sheet
			for(int Row=1; Row<=TotalNumberOfRows; Row++) {
				
				Log.info("User: " + Row);
				
				//Call the login steps method from login action class
				Login_Action.Login_steps(Row);
				
				//call the test data validation method from login action class
				Login_Action.TestDatavalidation();
			}
			extent.log(LogStatus.PASS, "Script is executed successfully");
		}catch(Exception e){
			Utils.takeScreenshot(driver, sTestCaseName);
			extent.attachScreenshot(Constant.AbsolutePath_ScreenShot + sTestCaseName +".jpg", "Fail");
			extent.log(LogStatus.ERROR, e.getMessage());
			Log.error(e.getMessage());
			throw (e);
		}
	
	}
	
	@AfterMethod
	public void afterMethod() {
		try{
		Log.endTestCase(sTestCaseName);
		driver.close();
		driver.quit();
		Log.info("Browser closed");
		extent.endTest();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
}
