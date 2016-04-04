/*---------------------------------------------------------------------------------------------------------------------
<copyright file="TC011_CreateFormItems.java" company="Astegic Info solutions" Product= "MForms">
Copyright 2015
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/
package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Home.Logout_Action;
import rc25.mFormsAutomation.Actions_Library.AddInputTypeInInputTypes_Action;
import rc25.mFormsAutomation.Actions_Library.AddItemsInInputTypes_Action;
import rc25.mFormsAutomation.Actions_Library.CreateFormItems_Action;
import rc25.mFormsAutomation.Actions_Library.SaveAndverifyTheForm_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC016_CreateFormItems {

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
	//	extent.startTest("sTestCaseName", "description");
		try{
			//This is to get the file names from Constant.java file	
			ExcelUtils.setExcelFile(ExcelPaths.FormItemsDataSheetPath, Constant.loginSheetName);
			int Row= 1;
			Login_Action.Login_steps(Row);
			CreateFormItems_Action.BlankForm(Row);
			ExcelUtils.setExcelFile(ExcelPaths.FormItemsDataSheetPath, Constant.FormItemsSheet2);
			int Total_number_of_rows= ExcelUtils.getRowUsed();
			for(int row = 1; row <= Total_number_of_rows; row++) {
				AddItemsInInputTypes_Action.add(row);
				AddInputTypeInInputTypes_Action.pageFactory();
				
				//Check condition if input items are found 
				switch (AddItemsInInputTypes_Action.inputType.toLowerCase()){
				case "attachment":
					AddInputTypeInInputTypes_Action.Input_Item_Attachment(row);
					break;
				case "audio":
					AddInputTypeInInputTypes_Action.Input_Item_Audio(row);
					break;
				case "barcode":
					AddInputTypeInInputTypes_Action.Input_Item_Barcode(row);
					break;
				case "camera":
					AddInputTypeInInputTypes_Action.Input_Item_Camera(row);
					break;
				case "date":
					AddInputTypeInInputTypes_Action.Input_Item_Date(row);
					break;
				case "date-time":
					AddInputTypeInInputTypes_Action.Input_Item_DateTime(row);
					break;
				case "dropdown":
					AddInputTypeInInputTypes_Action.Input_item_Dropdown(row);
					break;
				case "geostamp":
					AddInputTypeInInputTypes_Action.Input_Item_GeoStamp(row);
					break;
				case "label":
					AddInputTypeInInputTypes_Action.Input_Item_label(row);
					break;
				case "signature":
					AddInputTypeInInputTypes_Action.Input_Item_signature(row);
					break;
				case "sketch pad":
					AddInputTypeInInputTypes_Action.Input_Item_SketchPad(row);
					break;
				case "matrix multi-select":
					AddInputTypeInInputTypes_Action.Input_Item_Matrix_Multi_select(row);
					break;
				case "matrix single-select":
					AddInputTypeInInputTypes_Action.Input_Item_Matrix_Single_Select(row);
					break;
				case "multi-select":
					AddInputTypeInInputTypes_Action.Input_Item_MultiSelect(row);
					break;
				case "rating":
					AddInputTypeInInputTypes_Action.Input_Item_Rating(row);
					break;
				case "single-select":
					AddInputTypeInInputTypes_Action.Input_Item_SingleSelect(row);
					break;
				case "textbox":
					AddInputTypeInInputTypes_Action.Input_Item_Textbox(row);
					break;
				case "textarea":
					AddInputTypeInInputTypes_Action.Input_Item_TextArea(row);
					break;
				case "video":
					AddInputTypeInInputTypes_Action.Input_Item_Video(row);
					break;
				case "time":
					AddInputTypeInInputTypes_Action.Input_Item_Time(row);
					break;
				}
			}
			ExcelUtils.setExcelFile(ExcelPaths.FormItemsDataSheetPath, Constant.loginSheetName);
			SaveAndverifyTheForm_Action.SaveAndVerify(Row);
			Logout_Action.Logout();
		//	extent.log(LogStatus.PASS, "Details");
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
	//	extent.endTest();
	}
}
