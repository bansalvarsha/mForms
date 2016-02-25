package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.OR_Library.AddResponse_objects;
import rc25.mFormsAutomation.OR_Library.SaveAndverifyTheForm_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;

public class AddResponse_Actions extends BaseClass{
	
	public AddResponse_Actions(WebDriver driver) {
		super(driver);
	}
	static AddResponse_objects responseObj;
	static SaveAndverifyTheForm_objects SaveAndverifyObj;
	
	public static void AddResponse() throws Exception{
		responseObj= PageFactory.initElements(driver, AddResponse_objects.class);
		SaveAndverifyObj= PageFactory.initElements(driver, SaveAndverifyTheForm_objects.class);
		
		WebElement getRecordInTheList= SaveAndverifyObj.getRecordInTheList();
		 WebElement toggle= responseObj.getToggleLst();
		 if (getRecordInTheList.isDisplayed()){
			 Actions action= new Actions(driver);
			 action.moveToElement(getRecordInTheList).perform();
			 Thread.sleep(1000);
			 toggle.click();
			 String parentHandle = driver.getWindowHandle();
			 responseObj.getGridToggleAddResponse_lbl().click();
			 for (String winHandle : driver.getWindowHandles()) {
				 // switch focus of WebDriver to the next found window handle (that's your newly opened window)
				 driver.switchTo().window(winHandle); 
			 }
			 			 
			 for(int qRow = 1; qRow <= ExcelUtils.getRowUsed(); qRow++) {
				 String InputTypesFromAddForm= ExcelUtils.getCellData(qRow, Constant.Col_InputType);
				 
				 ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.AddResponseDataSheet);
				 String InputTypesFromAddResponse= ExcelUtils.getCellData(qRow, Constant.col_InputType);
					 
				 if(InputTypesFromAddForm.toLowerCase().equalsIgnoreCase(InputTypesFromAddResponse)){
					 AddResponseQuestionType_Actions.pageFactory();
					 switch (InputTypesFromAddResponse.toLowerCase()){
					 case "date":
						 AddResponseQuestionType_Actions.AddRespOn_Date(qRow);
						 break;
					 case "date-time":
						 AddResponseQuestionType_Actions.AddRespOn_DateTime(qRow);
						 break;
					 case "attachment":
						 AddResponseQuestionType_Actions.AddRespOn_Attachment(qRow);
						 break;
					 case "camera":
						 AddResponseQuestionType_Actions.AddRespOn_Camera(qRow);
						 break;
					 case "video":
						 AddResponseQuestionType_Actions.AddRespOn_Video(qRow);
						 break;
					 case "audio":
						 AddResponseQuestionType_Actions.AddRespOn_Audio(qRow);
						 break;
					 case "rating":
						 AddResponseQuestionType_Actions.AddRespOn_Rating(qRow);
						 break;
					 case "dropdown":
						 AddResponseQuestionType_Actions.AddRespOn_Dropdown(qRow);
						 break;
					 case "label":
						 AddResponseQuestionType_Actions.AddRespOn_label(qRow);
						 break;
					 case "multi-select":
						 AddResponseQuestionType_Actions.AddRespOn_MultiSelect(qRow);
						 break;
					 case "single-select":
						 AddResponseQuestionType_Actions.AddRespOn_SingleSelect(qRow);
						 break;
					 case "textarea":
						 AddResponseQuestionType_Actions.AddRespOn_Textarea(qRow);
						 break;
					 case "textbox":
						 AddResponseQuestionType_Actions.AddRespOn_TextBox(qRow);
						 break;
					 case "matrix multi-select":
						 AddResponseQuestionType_Actions.AddRespOn_Matrix_multiSelect(qRow);
						 break;
					 case "matrix single-select":
						 AddResponseQuestionType_Actions.AddRespOn_Matrix_SingleSelect(qRow);
						 break;
					 case "time":
						 AddResponseQuestionType_Actions.AddRespOn_Time(qRow);
						 break;
					 case "barcode":
						 AddResponseQuestionType_Actions.AddRespOn_Barcode(qRow);
						 break;
					 case "geostamp":
						 AddResponseQuestionType_Actions. AddRespOn_GeoStamp(qRow);
						 break;
					 case "signature":
						 AddResponseQuestionType_Actions.AddRespOn_Signature(qRow);
						 break;
					 case "sketch pad":
						 AddResponseQuestionType_Actions.AddRespOn_SketchPad(qRow);
						 break;
					 case "image (display only)":
						 AddResponseQuestionType_Actions.AddRespOn_ImageDisplay(qRow);
						 break;
					 case "video (display only)":
						 AddResponseQuestionType_Actions.AddRespOn_VideoDisplay(qRow);
						 break;
					 case "hyperlink (display only)":
						 AddResponseQuestionType_Actions.AddRespOn_HyperLinkDisplay(qRow);
						 break;
					 case "audio (display only)":
						 AddResponseQuestionType_Actions.AddRespOn_AudioDisplay_audio(qRow);
						 break;
					 case "map":
						 AddResponseQuestionType_Actions.AddRespOn_Map(qRow);
						 break;
						 }
					 } else 
						 System.out.println("Your excel data sheet is not correct. Please maintain the correct data in all the sheets.");
				 ExcelUtils.setExcelFile(ExcelPaths.AddResponseDataSheetPath, Constant.AddFormSheetName);	 
			 }
			 
			 responseObj.getSaveMenuOnAddResponsePage().click();
			 responseObj.getSave_btn_OnAddResponsepage().click();
			 
			 driver.close(); // close newly opened window when done with it
			 driver.switchTo().window(parentHandle); // switch back to the original window
		 }
	}
}
