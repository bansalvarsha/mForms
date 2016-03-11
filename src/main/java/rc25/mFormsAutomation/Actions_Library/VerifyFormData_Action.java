package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.OR_Library.AddInputTypeInForms_objects;
import rc25.mFormsAutomation.OR_Library.AddItems_objects;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class VerifyFormData_Action  extends BaseClass{
	
	public static String inputType;
	static AddInputTypeInForms_objects AddInputTypeObj;
	
	public VerifyFormData_Action(WebDriver driver) {
		super(driver);
	}

	static CreateLibrary_objects CreateLibObj; 
	static String DataMatch;
	static String DataMismatch;
	
	public static void verifyCreatedFormData(String sheetname) throws Exception{
		try{
		AddInputTypeObj= PageFactory.initElements(driver, AddInputTypeInForms_objects.class);
		int row=1;
		EditForm_Action.EditForm();
		VerifyFormNameAndDesc(row);
		ExcelUtils.setExcelFile(ExcelPaths.excelfileForCreateForm, sheetname);
		int Total_number_of_rows= ExcelUtils.getRowUsed();
		for(int Row = 1; Row <= Total_number_of_rows; Row++) {
			VerifyItemDetails(Row);
			inputType = ExcelUtils.getCellData(Row, Constant.Col_InputType);
			AddInputTypesInForms_Action.pageFactory();
			//Check condition if input items are found 
			switch (inputType.toLowerCase()){
			case "attachment":
				Input_Item_Attachment(Row);
				break;
			case "audio":
				Input_Item_Audio(Row);
				break;
			case "barcode":
				Input_Item_Barcode(Row);
				break;
			case "camera":
				Input_Item_Camera(Row);
				break;
			case "date":
				Input_Item_Date(Row);
				break;
			case "date-time":
				Input_Item_DateTime(Row);
				break;
			case "dropdown":
				Input_item_Dropdown(Row);
				break;
			case "geostamp":
				Input_Item_GeoStamp(Row);
				break;
			case "label":
				Input_Item_label(Row);
				break;
			case "signature":
				Input_Item_signature(Row);
				break;
			case "sketch pad":
				Input_Item_SketchPad(Row);
				break;
			case "audio (display only)":
				Input_Item_Audio_DisplayOnly(Row);
				break;
			case "image (display only)":
				Input_Item_Image_DisplayOnly(Row);
				break;
			case "video (display only)":
				Input_Item_video_DisplayOnly(Row);
				break;
			case "hyperlink (display only)":
				Input_Item_Hyperlink_DisplayOnly(Row);
				break;
			case "matrix multi-select":
				Input_Item_Matrix_Multi_select(Row);
				break;
			case "matrix single-select":
				Input_Item_Matrix_Single_Select(Row);
				break;
			case "map":
				Input_Item_map(Row);
				break;
			case "multi-select":
				Input_Item_MultiSelect(Row);
				break;
			case "rating":
				Input_Item_Rating(Row);
				break;
			case "single-select":
				Input_Item_SingleSelect(Row);
				break;
			case "textbox":
				Input_Item_Textbox(Row);
				break;
			case "textarea":
				Input_Item_TextArea(Row);
				break;
			case "video":
				Input_Item_Video(Row);
				break;
			case "time":
				Input_Item_Time(Row);
				break;
			}
		}
		AddInputTypeObj.getCancel_btn().click();
		} catch(Exception e){
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	private static void Input_Item_Time(int row) throws Exception {
		try{
		 Log.info("-------------" + inputType + "-------------");
		 DriverUtils.VerifyRequiredChkbox(row);
		 DriverUtils.VerifyOpenCommentChkbox(row);
		 DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Video(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		
		String NumberOfVideos = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		String getNumberOfVideos= AddInputTypeObj.getSelectedVideoCount().getText();
		//Print messages on console
		
		DataMatch= "'Number of videos' are same as mentioned in data sheet";
		DataMismatch=	"'Number of videos' are different from data sheet. " 
				+ "Data sheet value is: " + NumberOfVideos
				+ " and Form value is: " + getNumberOfVideos;
		Utils.VerifyMessages(NumberOfVideos, getNumberOfVideos, row, DataMatch, DataMismatch);
	    	
		String SizeOFVideo= ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
		String getSizeOFVideo= AddInputTypeObj.getSelectedVideoSize().getText();
		//Print messages on console
		DataMatch= "'Size OF Video' is same as mentioned in data sheet";
		DataMismatch=	"'Size OF Video' is different from data sheet. " 
				+ "Data sheet value is: " + SizeOFVideo
				+ " and Form value is: " + getSizeOFVideo;
		Utils.VerifyMessages(SizeOFVideo, getSizeOFVideo, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_TextArea(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		DriverUtils.VerifyInputOption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Textbox(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		String getInputOption= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionForTextBox())).getAttribute("value");
		//Print messages on console
		DataMatch = "Input options are same as mentioned in data sheet";
		DataMismatch =	"Input options are different from data sheet. " 
				+ "Data sheet value is: " + InputOption + " and Form value is: " + getInputOption;
		Utils.VerifyMessages(InputOption, getInputOption, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void Input_Item_SingleSelect(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		DriverUtils.VerifyInputOption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Rating(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		
		String RatingType= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		String getRatingType= AddInputTypeObj.getRatingType().getText();
		DataMatch = "Rating type is same as mentioned in data sheet";
		DataMismatch =	"Rating type is different from data sheet. " 
				+ "Data sheet value is: " + RatingType + " and Form value is: " + getRatingType;
		Utils.VerifyMessages(RatingType, getRatingType, row, DataMatch, DataMismatch);
		DriverUtils.VerifyInputOption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_MultiSelect(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		DriverUtils.VerifyInputOption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_map(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		String getCaptionOfButton= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditMapButtonCaption())).getAttribute("value");
		DataMatch= "Caption of button is same as mentioned in data sheet.";
		DataMismatch=	"Caption of button is dirfferent from data sheet. " 
				+ "Data sheet value is: " + CaptionOfButton + " and Form value is: " + getCaptionOfButton;	
		Utils.VerifyMessages(CaptionOfButton, getCaptionOfButton, row, DataMatch, DataMismatch);
		
		String MinNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MinNoOfPin);
		String getMinNumberOfPin= AddInputTypeObj.getMinCount().getAttribute("value");
		DataMatch= "'Min number of pin' is same as mentioned in data sheet.";
		DataMismatch=	"'Min number of pin' is different from data sheet. " 
				+ "Data sheet value is: " + MinNumberOfPin + " and Form value is: " + getMinNumberOfPin;
		Utils.VerifyMessages(MinNumberOfPin, getMinNumberOfPin, row, DataMatch, DataMismatch);
		
		String MaxNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfPin);
		String getMaxNumberOfPin= AddInputTypeObj.getMaxCount().getAttribute("value");
		DataMatch= "'Max number of pin' is same as mentioned in data sheet.";
		DataMismatch= "'Max number of pin' is different from data sheet. " 
				+ "Data sheet value is: " + MaxNumberOfPin + " and Form value is: " + getMaxNumberOfPin;
		Utils.VerifyMessages(MaxNumberOfPin, getMaxNumberOfPin, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Matrix_Single_Select(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		
 		String InputOptionRows= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
 		String getInputOptionRows=	driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOption())).getText();
 		DataMatch= "'Input option rows' are same as mentioned in data sheet.";
 		DataMismatch=	"'Input option rows' are different from data sheet. " 
				+ "Data sheet value is: " + InputOptionRows + " and Form value is: " + getInputOptionRows;	
 		Utils.VerifyMessages(InputOptionRows, getInputOptionRows, row, DataMatch, DataMismatch);
 		
 		String InputOptionColumns= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
 		String getInputOptionColumns= driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOptionColumn())).getText();
 		DataMatch= "'Input option columns' are same as mentioned in data sheet.";
 		DataMismatch=	"'Input option columns' are different from data sheet. " 
				+ "Data sheet value is: " + InputOptionColumns + " and Form value is: " + getInputOptionColumns;	
		Utils.VerifyMessages(InputOptionColumns, getInputOptionColumns, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Matrix_Multi_select(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
    	 
 		String InputOptionRows= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
 		String getInputOptionRows= driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOption())).getText();
 		DataMatch= "'Input option rows' are same as mentioned in data sheet.";
 		DataMismatch=	"'Input option rows' are different from data sheet. "
 				+ "Data sheet value is: " + InputOptionRows + " and Form value is: " + getInputOptionRows;	
		Utils.VerifyMessages(InputOptionRows, getInputOptionRows, row, DataMatch, DataMismatch);
 		
 		String InputOptionColumns= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
 		String getInputOptionColumns= driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOptionColumn())).getText();
 		DataMatch= "'Input option columns' are same as mentioned in data sheet.";
 		DataMismatch=	"'Input option columns' are different from data sheet. " 
				+ "Data sheet value is: " + InputOptionColumns + " and Form value is: " + getInputOptionColumns;	
		Utils.VerifyMessages(InputOptionColumns, getInputOptionColumns, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Hyperlink_DisplayOnly(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);

		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
		String getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2())).getAttribute("value");
		DataMatch= "Caption of button 2 is same as mentioned in data sheet.";
		DataMismatch=	"Caption of button 2 is different from data sheet. Data sheet value is: " + CaptionOfButton2 + " and Form value is: " + getCaptionOfButton2;	
		Utils.VerifyMessages(CaptionOfButton2, getCaptionOfButton2, row, DataMatch, DataMismatch);
		
		Utils.Scroll_Down_Page();
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		String getInputOption= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).getText();
		DataMatch= "Input options are same as mentioned in data sheet.";
		DataMismatch=	"Input options are different from data sheet. Data sheet value is: " + InputOption + " and Form value is: " + getInputOption;	
		Utils.VerifyMessages(InputOption, getInputOption, row, DataMatch, DataMismatch);
		
		String InputOption1= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
		String getInputOption1= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).getAttribute("value");
		DataMatch= "Input options 1 are same as mentioned in data sheet.";
		DataMismatch=	"Input options 1 are different from data sheet. Data sheet value is: " + InputOption1 + " and Form value is: " + getInputOption1;	
		Utils.VerifyMessages(InputOption1, getInputOption1, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_video_DisplayOnly(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
        DriverUtils.VerifyButtonCaption(row);
 		
        String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
        String getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2())).getAttribute("value");
        DataMatch= "Caption of button 2 is same as mentioned in data sheet.";
        DataMismatch= "Caption of button 2 is different from data sheet. Data sheet value is: " + CaptionOfButton2 + " and Form value is: " + getCaptionOfButton2;
        Utils.VerifyMessages(CaptionOfButton2, getCaptionOfButton2, row, DataMatch, DataMismatch);
        
        String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
        String getInputOption= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).getText();
        DataMatch = "Input options are same as mentioned in data sheet";
        DataMismatch =	"Input options are different from data sheet. Data sheet value is: " + InputOption + " and Form value is: " + getInputOption;
		Utils.VerifyMessages(InputOption, getInputOption, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Image_DisplayOnly(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
      	DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
          	
		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
        String getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2())).getAttribute("value");
        DataMatch= "Caption of button 2 is same as mentioned in data sheet.";
        DataMismatch= "Caption of button 2 is different from data sheet. Data sheet value is: " + CaptionOfButton2 + " and Form value is: " + getCaptionOfButton2;
  		Utils.VerifyMessages(CaptionOfButton2, getCaptionOfButton2, row, DataMatch, DataMismatch);
          	
      	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
      	String getInputOption= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).getText();
      	DataMatch= "Input options are same as mentioned in data sheet";
        DataMismatch=	"Input options are different from data sheet. Data sheet value is: " + InputOption + " and Form value is: " + getInputOption;
  		Utils.VerifyMessages(InputOption, getInputOption, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Audio_DisplayOnly(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		AddInputTypeInForms_objects.mRow= row;
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		
		Utils.Scroll_Down_Page();
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1); //get button caption from the excel sheet
		String getCaptionOfButton= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButtonCaption())).getAttribute("value");// get button caption from the form
		DataMatch="Caption of button 1 is same as mentioned in data sheet.";
		DataMismatch=	"Caption of button 1 is different from data sheet. Data sheet value is: " + CaptionOfButton + " and Form value is: " + getCaptionOfButton;	
		Utils.VerifyMessages(CaptionOfButton, getCaptionOfButton, row, DataMatch, DataMismatch);
			
		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
		String getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2Caption())).getAttribute("Value");
		DataMatch= "Caption of button 2 is same as mentioned in data sheet.";
		DataMismatch=	"Caption of button 2 is different from data sheet. Data sheet value is: " + CaptionOfButton2 + " and Form value is: " + getCaptionOfButton2;
		Utils.VerifyMessages(CaptionOfButton2, getCaptionOfButton2, row, DataMatch, DataMismatch);
			 
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		String InputValuesInExcel= InputOption.replace("_", " ");
    	String getFormInputvalues= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).getText();
    	DataMatch= "Input options are same as mentioned in data sheet";
    	DataMismatch=	"Input options are different from data sheet. Data sheet value is: " + InputValuesInExcel + " and Form value is: " + getFormInputvalues;
    	Utils.VerifyMessages(InputOption, getFormInputvalues, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_SketchPad(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	private static void Input_Item_signature(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_label(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyButtonCaption(row);
		DriverUtils.VerifyInputOption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_GeoStamp(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_item_Dropdown(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		DriverUtils.VerifyInputOption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_DateTime(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Date(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Camera(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
			
		String NumberOfImages= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		String getNumberOfImages= AddInputTypeObj.getSelectedImageCount().getText();
		DataMatch= "'Number of images' are same as mentioned in data sheet";
		DataMismatch=	"'Number of images' are different from data sheet. Data sheet value is: " + NumberOfImages + " and Form value is: " + getNumberOfImages;
		Utils.VerifyMessages(NumberOfImages, getNumberOfImages, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Barcode(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Audio(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
			
		String MaximumNumberOfAudios = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		String getMaximumNumberOfAudios= AddInputTypeObj.getSelectedAudioCount().getText();
		DataMatch= "Audio file limit is same as mentioned in data sheet";
		DataMismatch= "Audio file limit is different from data sheet. Data sheet value is: " + MaximumNumberOfAudios + " and Form value is: " + getMaximumNumberOfAudios;
		Utils.VerifyMessages(MaximumNumberOfAudios, getMaximumNumberOfAudios, row, DataMatch, DataMismatch);
	    	
		String MaximumFileDuration = ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
		String getMaximumFileDuration= driver.findElement(By.xpath(AddInputTypeInForms_objects.getSelectedAudioSize())).getText();
		DataMatch= "Audio file duration is same as mentioned in data sheet";
		DataMismatch= "Audio file duration is different from data sheet. Data sheet value is: " + MaximumFileDuration + " and Form value is: " + getMaximumFileDuration;
		Utils.VerifyMessages(MaximumFileDuration, getMaximumFileDuration, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	private static void Input_Item_Attachment(int row) throws Exception {
		try{
		Log.info("-------------" + inputType + "-------------");
		DriverUtils.VerifyRequiredChkbox(row);
		DriverUtils.VerifyOpenCommentChkbox(row);
		DriverUtils.VerifyButtonCaption(row);
		
		String MaxNoOfFiles= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		String getMaxNoOfFiles= AddInputTypeObj.getAttachCount().getText(); 
		DataMatch= "Attachment value is same as mentioned in data sheet";
		DataMismatch= "Attachment value is different from data sheet. Data sheet value is: " + MaxNoOfFiles + " and Form value is: " + getMaxNoOfFiles;
		Utils.VerifyMessages(MaxNoOfFiles, getMaxNoOfFiles, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		}		
	}

	//Method to verify the form details
	public static void VerifyFormNameAndDesc(int row) throws Exception   {
		 CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
		 try {
			 Thread.sleep(2000);
			 String ActFormName = ExcelUtils.getCellData(row, Constant.Col_FormName);
			 String getFormNameValue= CreateLibObj.getForm_Name().getAttribute("value");
			 DataMatch= "Form name is simlilar with data sheet value";
			 DataMismatch=	"Form name is different from data sheet. Data sheet value is: " + ActFormName + " and Form value is: " + getFormNameValue;
			 Utils.VerifyMessages(ActFormName, getFormNameValue, row, DataMatch, DataMismatch);
			
			 String ActFormDisc= ExcelUtils.getCellData(row, Constant.Col_FormDescription);
			 String getFormDescriptionValue= CreateLibObj.getForm_desc().getAttribute("value");
			 DataMatch= "Form description is simlilar with data sheet value";
			 DataMismatch= "Form description is different from data sheet. Data sheet value is: " + ActFormName + " and Form value is: " + getFormNameValue;
			 Utils.VerifyMessages(ActFormDisc, getFormDescriptionValue, row, DataMatch, DataMismatch);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }		
	 }

	public static void VerifyItemDetails(int row) throws Exception {
		try{
		AddItems_objects.mRow= row;
		driver.findElement(By.xpath(AddItems_objects.getAddItemName()));
		
		Thread.sleep(1000);
		String ActItemName= ExcelUtils.getCellData(row, Constant.Col_ItemName);
		String getActItemName= driver.findElement(By.xpath(AddItems_objects.getAddItemName())).getAttribute("value");
		DataMatch= "Item" + row + " has same item name mentioned in data sheet";
		DataMismatch=	"Item" + row + " has the different item name from data sheet. Data sheet value is: " + ActItemName + " and Form value is: " + getActItemName;
		Utils.VerifyMessages(ActItemName, getActItemName, row, DataMatch, DataMismatch);
		
		String ActItemDesc= ExcelUtils.getCellData(row, Constant.Col_ItemDescription);
		String getActItemDesc= driver.findElement(By.xpath(AddItems_objects.getAddItemDesc())).getAttribute("value");
		DataMatch= "Item" + row + " has same item description mentioned in data sheet";
		DataMismatch=	"Item" + row + " has the different item description from data sheet. Data sheet value is: " + ActItemDesc + " and Form value is: " + getActItemDesc;
		Utils.VerifyMessages(ActItemDesc, getActItemDesc, row, DataMatch, DataMismatch);
		} catch (Exception e) {
			 e.printStackTrace();
		 }		
	 }

}
