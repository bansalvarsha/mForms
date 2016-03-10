package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rc25.mFormsAutomation.OR_Library.AddInputTypeInForms_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class AddInputTypesInForms_Action extends AddItemsInForms_Action{
	public AddInputTypesInForms_Action(WebDriver driver) {
		super(driver);
	}

	static AddInputTypeInForms_objects AddInputTypeObj;
	public static void pageFactory() {
		AddInputTypeObj= PageFactory.initElements(driver, AddInputTypeInForms_objects.class);
	}
	
	public static void Input_Item_Attachment(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Attachment().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String MaxNoOfFiles= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getMaxNoOfFilesDDL()).selectByVisibleText(MaxNoOfFiles); 
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Attachment added");
		} else Log.info("Attachment updated");
	}
	
	public static void Input_Item_Audio(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Audio().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
    	
    	String MaximumNumberOfAudios = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
    	new Select(AddInputTypeObj.getAudioCount()).selectByVisibleText(MaximumNumberOfAudios);
    	
    	String MaximumFileDuration = ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
    	new Select(AddInputTypeObj.getAudioSize()).selectByVisibleText(MaximumFileDuration);
    	
    	if(CreateForm_Action.getFormNameValue.equals("")){
    	Log.info("Input type Audio added");
    	} else Log.info("Input type Audio updated");
	}
	
	public static void Input_Item_Barcode(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Barcode().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Barcode added");
		} else Log.info("Input type barcode updated");
	}
	
	public static void Input_Item_Camera(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Camera().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String NumberOfImages= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getImageCount()).selectByVisibleText(NumberOfImages);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Camera added");
		} else Log.info("Camera updated ");
	}
	
	public static void Input_Item_Date(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Date().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Date added");
		} else Log.info("Input type date updated");
	}
	
	public static void Input_Item_DateTime(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_DateTime().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Date-time added");
		}else Log.info("Input type date time updated");
	}
	
	public static void Input_item_Dropdown(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_DropDown().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Dropdown added");
		} else Log.info("Input type dropdown updated");
	}
	
	public static void Input_Item_GeoStamp(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_GeoStamp().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type GeoStamp added");
		} else Log.info("Input type geo stamp updated");
	}

	public static void Input_Item_label(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Label().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type label added");
		}else Log.info("Input type label updated");
	}
		
	public static void Input_Item_signature(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Signature().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Signature added");
		} else Log.info("Input type signature updated");
	}
		
	public static void Input_Item_SketchPad(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_SketchPad().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type sketch pad added");
		} else Log.info("Input type sketch pad updated");
	}
	
	public static void Input_Item_Audio_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Audio_DisplayOnly().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		
		Utils.Scroll_Down_Page();
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
    	
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
    	Runtime.getRuntime().exec(Constant.AudioFilePath);
    	Thread.sleep(4000);
    	    	
    	String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
    	
    	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
    	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
    		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
    		new Actions(driver).sendKeys(Keys.ENTER).perform();
    	}
    	Log.info("Input type audio (display only) added");
	}
	
	public static void Input_Item_Image_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Image_DisplayOnly().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		Thread.sleep(2000);
 	   	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
      	Runtime.getRuntime().exec(Constant.ImagePath);
      	Thread.sleep(4000);
      	
      	Utils.Scroll_Down_Page();
      	String req= ExcelUtils.getCellData(row, Constant.Col_Required);
      	if(req.equalsIgnoreCase("yes")) {
      		Thread.sleep(2000);
      		if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequiredForDiplayControls())).isSelected() ){
        		driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequiredForDiplayControls())).click();
        		}
      	} else System.out.println("required has been skiped");
      	String opencom= ExcelUtils.getCellData(row, Constant.Col_openComment);
      	if(opencom.equalsIgnoreCase("yes")) {
      		if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLocForDiplayControls())).isSelected() ){
        		driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLocForDiplayControls())).click();
        		}
      	} else 
      		System.out.println("open comment has been skiped");
      	
      	
      	 if(!CreateForm_Action.getFormNameValue.equals("")){
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).clear();
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).clear();
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).clear();
      	 }
      	 
      		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
          	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
          	
          	String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption1);
          	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
          	
      	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
      	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
      		new Actions(driver).sendKeys(Keys.ENTER).perform();
      	}
      	
      	if(CreateForm_Action.getFormNameValue.equals("")){
      	Log.info("Input type image (display only) added");
      	} else Log.info("Image display only updated");
	}
	
	public static void Input_Item_video_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
	
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Video_DisplayOnly().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
      	String req= ExcelUtils.getCellData(row, Constant.Col_Required);
        if(req.equalsIgnoreCase("yes")) {
        	if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequiredForDiplayControls())).isSelected() ){
        		driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequiredForDiplayControls())).click();
        		}
        } else System.out.println("required has been skiped");
        String opencom= ExcelUtils.getCellData(row, Constant.Col_openComment);
        if(opencom.equalsIgnoreCase("yes"))	{
			if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLocForDiplayControls())).isSelected() ){
        		driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLocForDiplayControls())).click();
        		}
        } else System.out.println("open comment has been skiped");
        
    	Utils.Scroll_Down_Page();
        if(!CreateForm_Action.getFormNameValue.equals("")){
        	 driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).clear();
        	 driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).clear();
        	 driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).clear();
        }
        
        String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
       
 		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
 		driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
       	Runtime.getRuntime().exec(Constant.VideoFilePath);
       	
       	Thread.sleep(2000);
        String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
        driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
        
        String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
        for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
        	driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
        	new Actions(driver).sendKeys(Keys.ENTER).perform();
        }
        
        if(CreateForm_Action.getFormNameValue.equals("")){
        Log.info("Input type video (display only) added");
        } else Log.info("Video display only updated");
	}
		
	public static void Input_Item_Hyperlink_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Hyperlink_DisplayOnly().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		String req= ExcelUtils.getCellData(row, Constant.Col_Required);
		if(req.equalsIgnoreCase("yes")) {
			if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequiredForDiplayControls())).isSelected() ){
				driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequiredForDiplayControls())).click();
			}
		} else System.out.println("required has been skiped");
		String opencom= ExcelUtils.getCellData(row, Constant.Col_openComment);
		if(opencom.equalsIgnoreCase("yes")) {
			if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLocForDiplayControls())).isSelected() ){
				driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLocForDiplayControls())).click();
			}
		} else System.out.println("open comment has been skiped");
		
		if(!CreateForm_Action.getFormNameValue.equals("")){
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).clear();
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).clear();
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).clear();
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).clear();
		}
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
		
		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
		
		Utils.Scroll_Down_Page();
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
			new Actions(driver).sendKeys(Keys.ENTER).perform();
		}
			String InputOption1= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).sendKeys(InputOption1);
			
			if(CreateForm_Action.getFormNameValue.equals("")){
			Log.info("Input type hyperlink (display only) added");
			} else Log.info("Input type hyperlink display only updated");
	}
	
	public static void Input_Item_map(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Map().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
		Runtime.getRuntime().exec(Constant.mapImageFile);
		Log.info("Input type map added");
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.CaptionOfButtonLocForMap())).sendKeys(CaptionOfButton);
		
		String MinNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MinNoOfPin);
		AddInputTypeObj.getMinCount().sendKeys(MinNumberOfPin);
		
		String MaxNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfPin);
		AddInputTypeObj.getMaxCount().sendKeys(MaxNumberOfPin);
		
		Log.info("Input type map added");
	}
	
	public static void Input_Item_Matrix_Multi_select(int row) throws Exception {

		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_MatrixMultiSelect().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
    	 
 		
 		if(!CreateForm_Action.getFormNameValue.equals("")){
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOption())).clear();
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOptionColumn())).clear();
 		}
 		
 		String InputOptionRows= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
 		for (String InputOptSpl: InputOptionRows.split("-", InputOptionRows.length())) {
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOption())).sendKeys(InputOptSpl);
 			new Actions(driver).sendKeys(Keys.ENTER).perform();
 		}
 		
 		String InputOptionColumns= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
 		for (String InputOptSpl: InputOptionColumns.split("-", InputOptionColumns.length())) {
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOptionColumn())).sendKeys(InputOptSpl);
 			new Actions(driver).sendKeys(Keys.ENTER).perform();
 		}
 		
 		if(CreateForm_Action.getFormNameValue.equals("")){
 		Log.info("Input type matrix multi select added");
 		} else Log.info("Input type matrix multi select updated");
	}

	public static void Input_Item_Matrix_Single_Select(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_MatrixSingleSelect().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
 		if(!CreateForm_Action.getFormNameValue.equals("")){
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOption())).clear();
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOptionColumn())).clear();
 		}
 		
 		String InputOptionRows= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
 		for (String InputOptSpl: InputOptionRows.split("-", InputOptionRows.length())) {
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOption())).sendKeys(InputOptSpl);
 			new Actions(driver).sendKeys(Keys.ENTER).perform();
 		}
 		
 		String InputOptionColumns= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
 		for (String InputOptSpl: InputOptionColumns.split("-", InputOptionColumns.length())) {
 			driver.findElement(By.xpath(AddInputTypeInForms_objects.getMatrixMultiSelect_TextareaOptionColumn())).sendKeys(InputOptSpl);
 			new Actions(driver).sendKeys(Keys.ENTER).perform();
 		}
 		
 		if(CreateForm_Action.getFormNameValue.equals("")){
 			Log.info("Input type matrix single select added");
 		} else Log.info("Input type matrix single select updated");
	}
	
	public static void Input_Item_MultiSelect(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_MultiSelect().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type multi select added");
		}else Log.info("Input type multi select updated");
	}
	
	public static void Input_Item_Rating(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Rating().click();	
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String RatingType= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getRatingInputType()).selectByVisibleText(RatingType);
		DriverUtils.InputOption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type rating added");
		} else Log.info("Input type rating updated");
	}
	
	public static void Input_Item_SingleSelect(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_SingleSelect().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type single select added");
		} else Log.info("Input type single select updated");
	}
	
	public static void Input_Item_Textbox(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_TextBox().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionForTextBox())).sendKeys(InputOption);
			Log.info("Input type TextBox added");
		}else{
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionForTextBox())).clear();
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionForTextBox())).sendKeys(InputOption);
			Log.info("Input type text box updated");
		}
	}
	
	public static void Input_Item_TextArea(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_TextArea().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type Text area added");
		} else Log.info("Input type text area updated");
	}
		
	public static void Input_Item_Video(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Video().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
    	
    	String NumberOfVideos = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
    	new Select(AddInputTypeObj.getVideoCount()).selectByVisibleText(NumberOfVideos);
    	
    	String SizeOFVideo= ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
    	new Select(AddInputTypeObj.getVideoSize()).selectByVisibleText(SizeOFVideo);
    	
    	if(CreateForm_Action.getFormNameValue.equals("")){
    	Log.info("Input type video added");
    	} else Log.info("Input type video updated");
	}
	
	public static void Input_Item_Time(int row) throws Exception {
		if(CreateForm_Action.getFormNameValue.equals("")){
		AddInputTypeObj.getInputItem_Time().click();
		}else Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		if(CreateForm_Action.getFormNameValue.equals("")){
		Log.info("Input type time added");
		}else Log.info("Input type time updated");
	}
	
}
