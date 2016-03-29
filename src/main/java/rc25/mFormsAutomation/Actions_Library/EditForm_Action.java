package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.AddInputTypeInForms_objects;
import rc25.mFormsAutomation.OR_Library.AddItems_objects;
import rc25.mFormsAutomation.OR_Library.SaveAndverifyTheForm_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class EditForm_Action extends BaseClass{
	public EditForm_Action(WebDriver driver) {
		super(driver);
	}

	static SaveAndverifyTheForm_objects SaveAndverifyObj;
	static AddInputTypeInForms_objects AddInputTypeObj;
	
	public static String inputType;
	
	public static void EditForm() throws Exception {
		AddInputTypeObj= PageFactory.initElements(driver, AddInputTypeInForms_objects.class);
		SaveAndverifyObj= PageFactory.initElements(driver, SaveAndverifyTheForm_objects.class);
		Utils.waitForElementOnvisibilityOf(SaveAndverifyObj.getRecordInTheList());
		SaveAndverifyObj.getRecordInTheList().click();
		Thread.sleep(5000);
	}
	
	public static void UpdateItemDetails(int row) throws Exception {
		//Set the value of mRow in AddItems_objects.java class to set the dynamic xpath values
		AddItems_objects.mRow= row;
		driver.findElement(By.xpath(AddItems_objects.getAddItemName()));
		
		Thread.sleep(1000);
		String ActItemName= ExcelUtils.getCellData(row, Constant.Col_ItemName);
		driver.findElement(By.xpath(AddItems_objects.getAddItemName())).clear();
		driver.findElement(By.xpath(AddItems_objects.getAddItemName())).sendKeys(ActItemName); 
				
		String ActItemDesc= ExcelUtils.getCellData(row, Constant.Col_ItemDescription);
		driver.findElement(By.xpath(AddItems_objects.getAddItemDesc())).clear();
		driver.findElement(By.xpath(AddItems_objects.getAddItemDesc())).sendKeys(ActItemDesc);
		
		inputType = ExcelUtils.getCellData(row, Constant.Col_InputType);
	}
	
	public static void Input_Item_Audio_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButtonCaption())).clear();
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButtonCaption())).sendKeys(CaptionOfButton);
			
		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2Caption())).clear();
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2Caption())).sendKeys(CaptionOfButton2);
			 
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).clear();
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
    	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
    		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
    		new Actions(driver).sendKeys(Keys.ENTER).perform();
    	}
    	
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
    	Runtime.getRuntime().exec(Constant.AudioFilePath);
    	Thread.sleep(4000);
    	    	
    	Log.info("Audio display only updated");
	}
	
	public static void Input_Item_map(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		Utils.Scroll_Down_To_InputType(row);
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
		Runtime.getRuntime().exec(Constant.mapImageFile);
		Log.info("Input type map updated");
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		WebElement EditCaptionOfButton= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditMapButtonCaption()));
		
		Actions actionObj = new Actions(driver);
		actionObj.clickAndHold(EditCaptionOfButton).sendKeys(Keys.chord(Keys.CONTROL, "a"), CaptionOfButton).build().perform();
		
		EditCaptionOfButton.sendKeys(CaptionOfButton);
			
		String MinNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MinNoOfPin);
		AddInputTypeObj.getMinCount().clear();
		AddInputTypeObj.getMinCount().sendKeys(MinNumberOfPin);
		
		String MaxNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfPin);
		AddInputTypeObj.getMaxCount().clear();
		AddInputTypeObj.getMaxCount().sendKeys(MaxNumberOfPin);
		
		Log.info("Input type map updated");
	}

	public static void Input_Item_Image_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		Utils.Scroll_Down_To_InputType(row);
		Thread.sleep(2000);
 	   	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
      	Runtime.getRuntime().exec(Constant.ImagePath);
      	Thread.sleep(4000);
      	
      	DriverUtils.RequiredChkbox(row);
      	DriverUtils.OpenCommentChkbox(row);
      	DriverUtils.ButtonCaption(row);
  	 
      	String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
      	WebElement getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2()));
      	getCaptionOfButton2.clear();
      	getCaptionOfButton2.sendKeys(CaptionOfButton2);
          	
      	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
      	driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).clear();
      	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
      		new Actions(driver).sendKeys(Keys.ENTER).perform();
      	}
      	Log.info("Image display only updated");
	}
	
	public static void Input_Item_video_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		Utils.Scroll_Down_To_InputType(row);
		DriverUtils.RequiredChkbox(row);
      	DriverUtils.OpenCommentChkbox(row);
      	DriverUtils.ButtonCaption(row);

    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getUploadFromComputer())).click();
       	Runtime.getRuntime().exec(Constant.VideoFilePath);
       	
       	Thread.sleep(2000);
        String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
        WebElement getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2()));
        getCaptionOfButton2.clear();
        getCaptionOfButton2.sendKeys(CaptionOfButton2);
        
        String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
        WebElement getInputOption= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())); 
        getInputOption.clear();
        for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
        	getInputOption.sendKeys(InputOptSpl);
        	new Actions(driver).sendKeys(Keys.ENTER).perform();
        }
        
        Log.info("Video display only updated");
	}
		
	public static void Input_Item_Hyperlink_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		Utils.Scroll_Down_To_InputType(row);
		DriverUtils.RequiredChkbox(row);
      	DriverUtils.OpenCommentChkbox(row);
      	DriverUtils.ButtonCaption(row);
		
		String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
		WebElement getCaptionOfButton2= driver.findElement(By.xpath(AddInputTypeInForms_objects.getEditButton2()));
		getCaptionOfButton2.clear();
		getCaptionOfButton2.sendKeys(CaptionOfButton2);
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).clear();
		for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
			new Actions(driver).sendKeys(Keys.ENTER).perform();
		}
		String InputOption1= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumns);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).clear();
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).sendKeys(InputOption1);
		
		Log.info("Input type hyperlink display only updated");
	}

	//use sikuli jar to save the form
	public static void Save_Form() throws FindFailed {
		
		//Create and initialize an instance of Screen object    
		Screen screen = new Screen();

		//Add image path  
		Pattern image = new Pattern("./src/test/java/rc25/mFormsAutomation/TestData/save_btn.png");
		    
		//Wait 10ms for image  
		screen.wait(image, 10);
		    
		//Click on the image
		screen.click(image);
		  
	}

}
