package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Home.Logout_Action;
import rc25.mFormsAutomation.Actions_Library.AddDisplayInputType_Action;
import rc25.mFormsAutomation.Actions_Library.AddItemsInForms_Action;
import rc25.mFormsAutomation.Actions_Library.CreateForm_Action;
import rc25.mFormsAutomation.Actions_Library.SaveAndverifyTheForm_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC006_CreateFormWithDisplayControls {
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
			ExcelUtils.setExcelFile(ExcelPaths.CreateFormWithDisplayControlsDataSheetPath, Constant.loginSheetName);
			int Row= 1;
			Login_Action.Login_steps(Row);
			
			CreateForm_Action.BlankForm();
			CreateForm_Action.fillBlankForm(Row);
			//CreateForm_Action.AssignBarcode_And_MasterImage(Row); (defect)
			
			ExcelUtils.setExcelFile(ExcelPaths.CreateFormWithDisplayControlsDataSheetPath, Constant.ActivationDateSheetName);
			CreateForm_Action.AddActivationDate(Row);
			//CreateForm_Action.RenamePageName(Row);
			
			ExcelUtils.setExcelFile(ExcelPaths.CreateFormWithDisplayControlsDataSheetPath, Constant.InputTypeDetails);
			int Total_number_of_rows= ExcelUtils.getRowUsed();
			for(int row = 1; row <= Total_number_of_rows; row++) {
				AddItemsInForms_Action.add(row);
				AddDisplayInputType_Action.pageFactory();
				
				switch (AddItemsInForms_Action.inputType.toLowerCase()){
				case "audio (display only)":
					AddDisplayInputType_Action.Input_Item_Audio_DisplayOnly(row);
					break;
				case "image (display only)":
					AddDisplayInputType_Action.Input_Item_Image_DisplayOnly(row);
					break;
				case "video (display only)":
					AddDisplayInputType_Action.Input_Item_video_DisplayOnly(row);
					break;
				case "hyperlink (display only)":
					AddDisplayInputType_Action.Input_Item_Hyperlink_DisplayOnly(row);
					break;
				case "map":
					AddDisplayInputType_Action.Input_Item_map(row);
					break;
				}
			}
			ExcelUtils.setExcelFile(ExcelPaths.CreateFormWithDisplayControlsDataSheetPath, Constant.loginSheetName);
			SaveAndverifyTheForm_Action.SaveAndVerify(Row);
		}catch(Exception e){
			Utils.takeScreenshot(driver, sTestCaseName);
			//extent.attachScreenshot(Constant.ReportsLocation, "Fail");
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	
	@AfterTest
	public void afterMethod() throws Exception {
		Logout_Action.Logout();
		Log.endTestCase(sTestCaseName);
		driver.close();
		driver.quit();
		//extent.endTest();
	}
}
