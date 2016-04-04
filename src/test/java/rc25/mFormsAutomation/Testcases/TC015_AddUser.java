package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Home.Logout_Action;
import rc25.mFormsAutomation.Actions_Users.AddUser_Actions;
import rc25.mFormsAutomation.Actions_Users.OpenUserForm_Actions;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC015_AddUser {
	private String sTestCaseName;
	public WebDriver driver;
	//private ExtentReports extent= ExtentReports.get(sTestCaseName);
	
	@BeforeMethod
	public void BeforeMethod() throws Exception {
		try{
		DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		
		driver= Utils.OpenBrowser();
		new BaseClass(driver);
		//extent.init(Constant.ReportsLocation, false);
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
	
	@Test
	public void main() throws Exception{
		//extent.startTest(sTestCaseName, "TestCase to add new user is going to start.");
		try{
			ExcelUtils.setExcelFile(ExcelPaths.AddUsersDataSheetPath, Constant.loginSheetName);
			int Row= 1;
			Login_Action.Login_steps(Row);
			OpenUserForm_Actions.OpenForm();
			ExcelUtils.setExcelFile(ExcelPaths.AddUsersDataSheetPath, Constant.AddUsersSheetName);
			AddUser_Actions.FillUserForm(Row);
			Logout_Action.Logout();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	@AfterTest
	public void afterMethod() {
		try{
		Log.endTestCase(sTestCaseName);
		driver.close();
		driver.quit();
		//extent.endTest();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
}
