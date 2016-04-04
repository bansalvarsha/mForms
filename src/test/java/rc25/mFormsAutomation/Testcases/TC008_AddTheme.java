package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Library.CreateForm_Action;
import rc25.mFormsAutomation.Actions_Library.Theme_Actions;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC008_AddTheme {
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
		//extent.startTest(sTestCaseName, "description");
		try{
			ExcelUtils.setExcelFile(ExcelPaths.Theme, Constant.loginSheetName);
			int Row= 1;
			Login_Action.Login_steps(Row);
			
			CreateForm_Action.BlankForm();
			Row++;
			ExcelUtils.setExcelFile(ExcelPaths.Theme, Constant.AddTheme);
			Theme_Actions.pageFactory();
			Theme_Actions.Add_theme(Row);
		}catch(Exception e){ 
			Utils.takeScreenshot(driver, sTestCaseName);
			//extent.attachScreenshot(Constant.ReportsLocation, "Fail");
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	@AfterTest
	public void afterMethod() {
		Log.endTestCase(sTestCaseName);
		driver.close();
		driver.quit();
	//	extent.endTest();
	}
}
