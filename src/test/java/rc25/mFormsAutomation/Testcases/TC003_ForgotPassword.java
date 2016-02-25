package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Forgot_Password_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC003_ForgotPassword {
	private String sTestCaseName;
	public WebDriver driver;
	//private ExtentReports extent= ExtentReports.get(TC003_ForgotPassword.class);
	
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
			ExcelUtils.setExcelFile(ExcelPaths.ForgotPasswordFilePath, Constant.loginSheetName);
			int Row= 1;
			Forgot_Password_Action.forgotPassword(Row);
			Forgot_Password_Action.readResetPwdEmail(Row);
			Forgot_Password_Action.ChangePassword(Row);
			//extent.log(LogStatus.PASS, "Details");
		}catch(Exception e){
			//Utils.takeScreenshot(driver, sTestCaseName);
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
