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

public class AddInputTypesInForms_Action extends AddItemsInForms_Action{
	public AddInputTypesInForms_Action(WebDriver driver) {
		super(driver);
	}

	static AddInputTypeInForms_objects AddInputTypeObj;
	public static void pageFactory() {
		AddInputTypeObj= PageFactory.initElements(driver, AddInputTypeInForms_objects.class);
	}
	
	public static void Input_Item_Attachment(int row) throws Exception {
		AddInputTypeObj.getInputItem_Attachment().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String MaxNoOfFiles= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getMaxNoOfFilesDDL()).selectByVisibleText(MaxNoOfFiles); 
		Log.info("Attachment added");
	}
	
	public static void Input_Item_Audio(int row) throws Exception {
		AddInputTypeObj.getInputItem_Audio().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
    	
    	String MaximumNumberOfAudios = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
    	new Select(AddInputTypeObj.getAudioCount()).selectByVisibleText(MaximumNumberOfAudios);
    	
    	String MaximumFileDuration = ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
    	new Select(AddInputTypeObj.getAudioSize()).selectByVisibleText(MaximumFileDuration);
    	Log.info("Input type Audio added");
	}
	
	public static void Input_Item_Barcode(int row) throws Exception {
		AddInputTypeObj.getInputItem_Barcode().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type Barcode added");
	}
	
	public static void Input_Item_Camera(int row) throws Exception {
		AddInputTypeObj.getInputItem_Camera().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String NumberOfImages= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getImageCount()).selectByVisibleText(NumberOfImages);
		Log.info("Input type Camera added");
	}
	
	public static void Input_Item_Date(int row) throws Exception {
		AddInputTypeObj.getInputItem_Date().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type Date added");
	}
	
	public static void Input_Item_DateTime(int row) throws Exception {
		AddInputTypeObj.getInputItem_DateTime().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type Date-time added");
	}
	
	public static void Input_item_Dropdown(int row) throws Exception {
		AddInputTypeObj.getInputItem_DropDown().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		Log.info("Input type Dropdown added");
	}
	
	public static void Input_Item_GeoStamp(int row) throws Exception {
		AddInputTypeObj.getInputItem_GeoStamp().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type GeoStamp added");
	}

	public static void Input_Item_label(int row) throws Exception {
		AddInputTypeObj.getInputItem_Label().click();
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		Log.info("Input type label added");
	}
		
	public static void Input_Item_signature(int row) throws Exception {
		AddInputTypeObj.getInputItem_Signature().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type Signature added");
	}
		
	public static void Input_Item_SketchPad(int row) throws Exception {
		AddInputTypeObj.getInputItem_SketchPad().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type sketch pad added");
	}
	
	public static void Input_Item_Audio_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Audio_DisplayOnly().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
    	
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
		
		AddInputTypeObj.getInputItem_Image_DisplayOnly().click();
		Thread.sleep(2000);
 	   	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
      	Runtime.getRuntime().exec(Constant.ImagePath);
      	Thread.sleep(4000);
      	
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
      		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
          	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
          	
          	String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption1);
          	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
          	
      	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
      	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
      		new Actions(driver).sendKeys(Keys.ENTER).perform();
      	}
      	Log.info("Input type image (display only) added");
      	
	}
	
	public static void Input_Item_video_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Video_DisplayOnly().click();
 	    
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
        String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
 		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
  	   	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
       	Runtime.getRuntime().exec(Constant.VideoFilePath);
       	
        String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
        driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
        
        String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
        for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
        	driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
        	new Actions(driver).sendKeys(Keys.ENTER).perform();
        }
        Log.info("Input type video (display only) added");
	}
		
	public static void Input_Item_Hyperlink_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Hyperlink_DisplayOnly().click();
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
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
		
		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
			new Actions(driver).sendKeys(Keys.ENTER).perform();
		}
			String InputOption1= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).sendKeys(InputOption1);
			Log.info("Input type hyperlink (display only) added");
	}
	
	public static void Input_Item_map(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Map().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.CaptionOfButtonLocForMap())).sendKeys(CaptionOfButton);
		
		String MinNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MinNoOfPin);
		AddInputTypeObj.getMinCount().sendKeys(MinNumberOfPin);
		
		String MaxNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfPin);
		AddInputTypeObj.getMaxCount().sendKeys(MaxNumberOfPin);
		
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
		Runtime.getRuntime().exec(Constant.mapImageFile);
		Log.info("Input type map added");
	}
	
	public static void Input_Item_Matrix_Multi_select(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_MatrixMultiSelect().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
    	 
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
 		Log.info("Input type matrix multi select added");
	}
	
	public static void Input_Item_Matrix_Single_Select(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_MatrixSingleSelect().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
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
 		 Log.info("Input type matrix single select added");
	}
	
	public static void Input_Item_MultiSelect(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_MultiSelect().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		Log.info("Input type multi select added");
	}
		
	public static void Input_Item_Rating(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Rating().click();	
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String RatingType= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getRatingInputType()).selectByVisibleText(RatingType);
		DriverUtils.InputOption(row);
		Log.info("Input type rating added");
	}
	
	public static void Input_Item_SingleSelect(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_SingleSelect().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		Log.info("Input type single select added");
	}
	
	public static void Input_Item_Textbox(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		AddInputTypeObj.getInputItem_TextBox().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
	    driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionForTextBox())).sendKeys(InputOption);
	    Log.info("Input type TextBox added");
	}
	
	public static void Input_Item_TextArea(int row) throws Exception {
		AddInputTypeObj.getInputItem_TextArea().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		DriverUtils.InputOption(row);
		Log.info("Input type Text area added");
	}
		
	public static void Input_Item_Video(int row) throws Exception {
		AddInputTypeObj.getInputItem_Video().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
    	
    	String NumberOfVideos = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
    	new Select(AddInputTypeObj.getVideoCount()).selectByVisibleText(NumberOfVideos);
    	
    	String SizeOFVideo= ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
    	new Select(AddInputTypeObj.getVideoSize()).selectByVisibleText(SizeOFVideo);
    	Log.info("Input type video added");
	}
	
	public static void Input_Item_Time(int row) throws Exception {
		AddInputTypeObj.getInputItem_Time().click();
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		DriverUtils.ButtonCaption(row);
		Log.info("Input type time added");
	}
	
	
}
