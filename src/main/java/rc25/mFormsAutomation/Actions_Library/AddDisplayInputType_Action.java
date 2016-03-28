package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.AddInputTypeInForms_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class AddDisplayInputType_Action extends BaseClass{

	
	public AddDisplayInputType_Action(WebDriver driver) {
		super(driver);
	}

	static AddInputTypeInForms_objects AddInputTypeObj;
	public static void pageFactory() {
		AddInputTypeObj= PageFactory.initElements(driver, AddInputTypeInForms_objects.class);
	}
	
	public static void Input_Item_Audio_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Audio_DisplayOnly().click();
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
    	
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
    	
    	String URL= ExcelUtils.getCellData(row, Constant.Col_URL);
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getTextbox_url())).sendKeys(URL);
    	    	
    	String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
    	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
    	
    	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRowsForDisplay);
    	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
    		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
    		new Actions(driver).sendKeys(Keys.ENTER).perform();
    	}
    	Log.info("Input type audio (display only) added");
    	Utils.Scroll_Down_Page();
	}
	
	public static void Input_Item_Image_DisplayOnly(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Image_DisplayOnly().click();
		
		String URL= ExcelUtils.getCellData(row, Constant.Col_URL);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getTextbox_url())).sendKeys(URL);
      	
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
      	} else 
      		System.out.println("open comment has been skiped");
      		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
          	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton1Loc())).sendKeys(CaptionOfButton);
          	
          	String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption1);
          	driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
          	
      	String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRowsForDisplay);
      	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
      		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
      		new Actions(driver).sendKeys(Keys.ENTER).perform();
      	}
      	Log.info("Input type image (display only) added");
    	Utils.Scroll_Down_Page();
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
 		String URL= ExcelUtils.getCellData(row, Constant.Col_URL);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getTextbox_url())).sendKeys(URL);
       	
        String CaptionOfButton2= ExcelUtils.getCellData(row, Constant.Col_Caption2);
        driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButton2Loc())).sendKeys(CaptionOfButton2);
        
        String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRowsForDisplay);
        for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
        	driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
        	new Actions(driver).sendKeys(Keys.ENTER).perform();
        }
        Log.info("Input type video (display only) added");
        Utils.Scroll_Down_Page();
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
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRowsForDisplay);
		for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLocDisplay())).sendKeys(InputOptSpl);
			new Actions(driver).sendKeys(Keys.ENTER).perform();
		}
			String InputOption1= ExcelUtils.getCellData(row, Constant.Col_InputOptionColumnsForDsiplay);
			driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOption1Loc())).sendKeys(InputOption1);
			Log.info("Input type hyperlink (display only) added");
			Utils.Scroll_Down_Page();
	}
	
	public static void Input_Item_map(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		AddInputTypeObj.getInputItem_Map().click();
		
		DriverUtils.RequiredChkbox(row);
		DriverUtils.OpenCommentChkbox(row);
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.CaptionOfButtonLocForMap())).sendKeys(CaptionOfButton);
		
		String MinNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MinNoOfPinForDisplay);
		AddInputTypeObj.getMinCount().sendKeys(MinNumberOfPin);
		
		String MaxNumberOfPin= ExcelUtils.getCellData(row, Constant.Col_MaxNoOfPinForDisplay);
		AddInputTypeObj.getMaxCount().sendKeys(MaxNumberOfPin);
		
		String URL= ExcelUtils.getCellData(row, Constant.Col_URL);
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getTextbox_url())).sendKeys(URL);
		Log.info("Input type map added");
		Utils.Scroll_Down_Page();
	}
}
