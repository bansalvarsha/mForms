package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Home.Logout_Action;
import rc25.mFormsAutomation.Actions_Library.CreateInputOptions_Action;
import rc25.mFormsAutomation.Actions_Library.SaveAndverifyTheForm_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC013_CreateInputOptions {
	private String sTestCaseName;
	public WebDriver driver;
	//private ExtentReports extent= ExtentReports.get(sTestCaseName);
	
	
	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		
		driver= Utils.OpenBrowser();
		new BaseClass(driver);
		//extent.init(Constant.ReportsLocation, false);
	}
	
	@Test
	public void main() throws Exception{
		//extent.startTest("sTestCaseName", "description");
		try{
			//This is to get the file names from Constant.java file	
			ExcelUtils.setExcelFile(ExcelPaths.InputOptionDataSheetPath, Constant.loginSheetName);
			int Row= 1;
			Login_Action.Login_steps(Row);
			CreateInputOptions_Action.OpenAndFillForm(Row);
			SaveAndverifyTheForm_Action.SaveAndVerify(Row);
			Logout_Action.Logout();
			//extent.log(LogStatus.PASS, "Details");
		}catch(Exception e){
			Utils.takeScreenshot(driver, sTestCaseName);
			//extent.attachScreenshot(Constant.ReportsLocation, "Fail");
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		Log.endTestCase(sTestCaseName);
		driver.close();
		driver.quit();
		//extent.endTest();
	}
}
