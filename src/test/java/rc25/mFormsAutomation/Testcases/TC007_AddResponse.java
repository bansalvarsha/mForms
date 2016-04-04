/*---------------------------------------------------------------------------------------------------------------------
<copyright file="TC007_AddResponse.java" company="Astegic Info solutions" Product= "MForms">
Copyright 2016
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/
package rc25.mFormsAutomation.Testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rc25.mFormsAutomation.Actions_Home.Login_Action;
import rc25.mFormsAutomation.Actions_Library.AddInputTypesInForms_Action;
import rc25.mFormsAutomation.Actions_Library.AddItemsInForms_Action;
import rc25.mFormsAutomation.Actions_Library.AddResponse_Actions;
import rc25.mFormsAutomation.Actions_Library.CreateForm_Action;
import rc25.mFormsAutomation.Actions_Library.PublishForm_Actions;
import rc25.mFormsAutomation.Actions_Library.SaveAndverifyTheForm_Action;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class TC007_AddResponse {
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
		//extent.startTest(sTestCaseName, "description");
		try{
			ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.loginSheetName);
			int Row= 1;
			Login_Action.Login_steps(Row);
			CreateForm_Action.BlankForm();
			CreateForm_Action.fillBlankForm(Row);
		
			ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.AddFormSheetName);
			int Total_number_of_rows= ExcelUtils.getRowUsed();
			for(int row = 1; row <= Total_number_of_rows; row++) {
					
				AddItemsInForms_Action.add(row);
				AddInputTypesInForms_Action.pageFactory();
				//Check condition if input items are found 
				switch (AddItemsInForms_Action.inputType.toLowerCase()){
				case "attachment":
					AddInputTypesInForms_Action.Input_Item_Attachment(row);
					break;
				case "audio":
					AddInputTypesInForms_Action.Input_Item_Audio(row);
					break;
				case "barcode":
					AddInputTypesInForms_Action.Input_Item_Barcode(row);
					break;
				case "camera":
					AddInputTypesInForms_Action.Input_Item_Camera(row);
					break;
				case "date":
					AddInputTypesInForms_Action.Input_Item_Date(row);
					break;
				case "date-time":
					AddInputTypesInForms_Action.Input_Item_DateTime(row);
					break;
				case "dropdown":
					AddInputTypesInForms_Action.Input_item_Dropdown(row);
					break;
				case "geostamp":
					AddInputTypesInForms_Action.Input_Item_GeoStamp(row);
					break;
				case "label":
					AddInputTypesInForms_Action.Input_Item_label(row);
					break;
				case "signature":
					AddInputTypesInForms_Action.Input_Item_signature(row);
					break;
				case "sketch pad":
					AddInputTypesInForms_Action.Input_Item_SketchPad(row);
					break;
				case "audio (display only)":
					AddInputTypesInForms_Action.Input_Item_Audio_DisplayOnly(row);
					break;
				case "image (display only)":
					AddInputTypesInForms_Action.Input_Item_Image_DisplayOnly(row);
					break;
				case "video (display only)":
					AddInputTypesInForms_Action.Input_Item_video_DisplayOnly(row);
					break;
				case "hyperlink (display only)":
					AddInputTypesInForms_Action.Input_Item_Hyperlink_DisplayOnly(row);
					break;
				case "matrix multi-select":
					AddInputTypesInForms_Action.Input_Item_Matrix_Multi_select(row);
					break;
				case "matrix single-select":
					AddInputTypesInForms_Action.Input_Item_Matrix_Single_Select(row);
					break;
				case "map":
					AddInputTypesInForms_Action.Input_Item_map(row);
					break;
				case "multi-select":
					AddInputTypesInForms_Action.Input_Item_MultiSelect(row);
					break;
				case "rating":
					AddInputTypesInForms_Action.Input_Item_Rating(row);
					break;
				case "single-select":
					AddInputTypesInForms_Action.Input_Item_SingleSelect(row);
					break;
				case "textbox":
					AddInputTypesInForms_Action.Input_Item_Textbox(row);
					break;
				case "textarea":
					AddInputTypesInForms_Action.Input_Item_TextArea(row);
					break;
				case "video":
					AddInputTypesInForms_Action.Input_Item_Video(row);
					break;
				case "time":
					AddInputTypesInForms_Action.Input_Item_Time(row);
					break;
				}
			}
			ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.loginSheetName);
			SaveAndverifyTheForm_Action.SaveAndVerify(Row);
			
			ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.ActivationDateSheetName);
			PublishForm_Actions.publishTheForm(Row);
		
			ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.AddFormSheetName);
			AddResponse_Actions.AddResponse();
			//extent.log(LogStatus.PASS, "Details");
		}catch(Exception e){
			Utils.takeScreenshot(driver, sTestCaseName);
			//extent.attachScreenshot(Constant.ReportsLocation, "Fail");
			Log.error(e.getMessage());
			throw (e);
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
