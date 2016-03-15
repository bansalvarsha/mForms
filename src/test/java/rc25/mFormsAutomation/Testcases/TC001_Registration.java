/*---------------------------------------------------------------------------------------------------------------------
<copyright file="TC001_Registration.java" company="Astegic Info solutions" Product= "MForms">
Copyright 2016
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/
package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Home.UserRegistration_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC001_Registration {
	
    private String sTestCaseName;
	public WebDriver driver;
	private ExtentReports extent= ExtentReports.get(TC001_Registration.class);
	
	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		driver= Utils.OpenBrowser();
		new BaseClass(driver);
		extent.init(Constant.ReportsLocation, true);
	}
	
	//@Test(dataProvider = "dtProvider")
	@Test
	public void main() throws Exception{
		extent.startTest(sTestCaseName, "description");
		try{
			ExcelUtils.setExcelFile(ExcelPaths.UserRegistrationDataSheetPath, Constant.SuperAdminCredentials);
			int TotalNumberOfRows= ExcelUtils.getRowUsed();
			for(int Row=1;Row<=TotalNumberOfRows;Row++){
				Login_Action.Login_steps(Row);
				UserRegistration_Action.MoveToRegistrationPage();
				ExcelUtils.setExcelFile(ExcelPaths.UserRegistrationDataSheetPath, Constant.RegSheetName);
				UserRegistration_Action.Registration(Row);
			}
			extent.log(LogStatus.PASS, "Details");
			extent.log(LogStatus.ERROR, "Details");
		 
			//ExcelUtils.setCellData("Pass", Row, Constant.Col_Result);
		}catch (Exception e) {
			//ExcelUtils.setCellData("Fail", Row, Constant.Col_Result);
			Utils.takeScreenshot(driver, sTestCaseName);
			extent.attachScreenshot(Constant.ReportsLocation, "Fail");
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	@AfterTest
	public void afterMethod() {
		Log.endTestCase(sTestCaseName);
		driver.close();
		driver.quit();
		extent.endTest();
	}
	
	/*@DataProvider(name="dtProvider")
	public Object[][] dp() {
		Object[][] testObjArray = ExcelUtils.getTableArray(ExcelPaths.UserRegistrationDataSheetPath,Constant.RegSheetName);
		return (testObjArray);
	}*/
}
