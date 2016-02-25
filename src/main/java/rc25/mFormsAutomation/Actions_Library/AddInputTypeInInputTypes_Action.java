package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rc25.mFormsAutomation.OR_Library.AddInputTypeInInputTypes_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;

public class AddInputTypeInInputTypes_Action extends CreateInputType_Action {

	public AddInputTypeInInputTypes_Action(WebDriver driver) {
		super(driver);
	}

	static AddInputTypeInInputTypes_objects AddInputTypeObj;
	public static void pageFactory() {
		AddInputTypeObj= PageFactory.initElements(driver, AddInputTypeInInputTypes_objects.class);
	}
	
	public static void Input_Item_Attachment(int row) throws Exception {
		AddInputTypeObj.getInputItem_Attachment().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		
		String MaxNoOfFiles= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getMaxNoOfFilesDDL()).selectByVisibleText(MaxNoOfFiles); 
		Log.info("Attachment added");
	}
	
	public static void Input_Item_Audio(int row) throws Exception {
		AddInputTypeObj.getInputItem_Audio().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
    	
    	String MaximumNumberOfAudios = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
    	new Select(AddInputTypeObj.getAudioCount()).selectByVisibleText(MaximumNumberOfAudios);
    	
    	String MaximumFileDuration = ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
    	new Select(AddInputTypeObj.getAudioSize()).selectByVisibleText(MaximumFileDuration);
    	Log.info("Input type Audio added");
	}
	
	public static void Input_Item_Barcode(int row) throws Exception {
		AddInputTypeObj.getInputItem_Barcode().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type Barcode added");
	}
	
	public static void Input_Item_Camera(int row) throws Exception {
		AddInputTypeObj.getInputItem_Camera().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		
		String NumberOfImages= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getImageCount()).selectByVisibleText(NumberOfImages);
		Log.info("Input type Camera added");
	}
	
	public static void Input_Item_Date(int row) throws Exception {
		AddInputTypeObj.getInputItem_Date().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type Date added");
	}
	
	public static void Input_Item_DateTime(int row) throws Exception {
		AddInputTypeObj.getInputItem_DateTime().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type Date-time added");
	}
	
	public static void Input_item_Dropdown(int row) throws Exception {
		AddInputTypeObj.getInputItem_DropDown().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		InputOption(row);
		Log.info("Input type Dropdown added");
	}
	
	public static void Input_Item_GeoStamp(int row) throws Exception {
		AddInputTypeObj.getInputItem_GeoStamp().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type GeoStamp added");
	}

	public static void Input_Item_label(int row) throws Exception {
		AddInputTypeObj.getInputItem_Label().click();
		ButtonCaption(row);
		InputOption(row);
		Log.info("Input type label added");
	}
	
	public static void Input_Item_signature(int row) throws Exception {
		AddInputTypeObj.getInputItem_Signature().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type Signature added");
	}
		
	public static void Input_Item_SketchPad(int row) throws Exception {
		AddInputTypeObj.getInputItem_SketchPad().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type sketch pad added");
	}
	
	public static void Input_Item_Matrix_Multi_select(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_MatrixMultiSelect().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
    	 
 		String InputOptionRows= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
 		for (String InputOptSpl: InputOptionRows.split("-", InputOptionRows.length())) {
 			driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getInputOptionLoc())).sendKeys(InputOptSpl);
 			new Actions(driver).sendKeys(Keys.ENTER).perform();
 		}
 		String InputOptionColumns= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
 		for (String InputOptSpl: InputOptionColumns.split("-", InputOptionColumns.length())) {
 			driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getMatrix_InputOptionColumn())).sendKeys(InputOptSpl);
 			new Actions(driver).sendKeys(Keys.ENTER).perform();
 		}
 		Log.info("Input type matrix multi select added");
	}
	
	public static void Input_Item_Matrix_Single_Select(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_MatrixSingleSelect().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		
 		String InputOptionRows= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
 		  for (String InputOptSpl: InputOptionRows.split("-", InputOptionRows.length())) {
 			 driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getInputOptionLoc())).sendKeys(InputOptSpl);
 			  new Actions(driver).sendKeys(Keys.ENTER).perform();
 		  }
 		  String InputOptionColumns= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
 		  for (String InputOptSpl: InputOptionColumns.split("-", InputOptionColumns.length())) {
 			 driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getMatrix_InputOptionColumn())).sendKeys(InputOptSpl);
 			  new Actions(driver).sendKeys(Keys.ENTER).perform();
 		  }
 		 Log.info("Input type matrix single select added");
	}
	
	public static void Input_Item_MultiSelect(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_MultiSelect().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		InputOption(row);
		Log.info("Input type multi select added");
	}
		
	public static void Input_Item_Rating(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Rating().click();	
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		
		String RatingType= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
		new Select(AddInputTypeObj.getRatingInputType()).selectByVisibleText(RatingType);
		InputOption(row);
		Log.info("Input type rating added");
	}
	
	public static void Input_Item_SingleSelect(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_SingleSelect().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		InputOption(row);
		Log.info("Input type single select added");
	}
	
	public static void Input_Item_Textbox(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		AddInputTypeObj.getInputItem_TextBox().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
	    driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getInputOptionLoc())).sendKeys(InputOption);
	    Log.info("Input type TextBox added");
	}
	
	public static void Input_Item_TextArea(int row) throws Exception {
		AddInputTypeObj.getInputItem_TextArea().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		InputOption(row);
		Log.info("Input type Text area added");
	}
		
	public static void Input_Item_Video(int row) throws Exception {
		AddInputTypeObj.getInputItem_Video().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
    	
    	String NumberOfVideos = ExcelUtils.getCellData(row, Constant.Col_MaxNoOfFilesOrRatingType);
    	new Select(AddInputTypeObj.getVideoCount()).selectByVisibleText(NumberOfVideos);
    	
    	String SizeOFVideo= ExcelUtils.getCellData(row, Constant.Col_MaxFileDuration);
    	new Select(AddInputTypeObj.getVideoSize()).selectByVisibleText(SizeOFVideo);
    	Log.info("Input type video added");
	}
	
	public static void Input_Item_Time(int row) throws Exception {
		AddInputTypeObj.getInputItem_Time().click();
		RequiredChkbox(row);
		OpenCommentChkbox(row);
		ButtonCaption(row);
		Log.info("Input type time added");
	}
	
	//Method for check the required check box in every input type rather than display input types
	public static void RequiredChkbox(int row) throws Exception {
		String ActRequired= ExcelUtils.getCellData(row, Constant.Col_Required);
		if(ActRequired.equalsIgnoreCase("yes")) {
			AddInputTypeInInputTypes_objects.mRow= row;
			if ( !driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getRequired())).isSelected() ){
	    		driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getRequired())).click();
	    		}                                            
		} else System.out.println("required has been skiped");
	}
		
	//Method for check the open comment check box in every input type rather than display input types
	public static void OpenCommentChkbox(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		String openCommand= ExcelUtils.getCellData(row, Constant.Col_openComment);//Fetching Data from excel 
		if(openCommand.equalsIgnoreCase("yes")) {
			if ( !driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getOpenCommLoc())).isSelected() ){
	    		driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getOpenCommLoc())).click();
	    		}
		}else System.out.println("open comment has been skiped");
	}
		
	////Method for enter the caption of the button in every input type rather than display input types
	public static void ButtonCaption(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);//Fetching Data from excel 
		driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getCaptionOfButtonLoc())).sendKeys(CaptionOfButton);   
	}
	
	//Method for enter the input options in the list of some input types
	public static void InputOption(int row) throws Exception {
		AddInputTypeInInputTypes_objects.mRow= row;
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
    	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
    	    driver.findElement(By.xpath(AddInputTypeInInputTypes_objects.getInputOptionLoc())).sendKeys(InputOptSpl);
    	    new Actions(driver).sendKeys(Keys.ENTER).perform();
    	}
	}
}
