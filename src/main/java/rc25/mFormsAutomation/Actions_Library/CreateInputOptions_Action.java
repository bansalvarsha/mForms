package rc25.mFormsAutomation.Actions_Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class CreateInputOptions_Action extends BaseClass{

	public CreateInputOptions_Action(WebDriver driver) {
		super(driver);
	}
	
	public CreateInputOptions_Action(String libraryName) {
		super(libraryName);
	}

	//Created a object of CreateInputType_page.java class to use it's variables
	static CreateLibrary_objects CreateLibObj;
	public static String inputType;
	static String InputOptionName;
	static String IOptionName;
	
	//Method to open the form 
	public static void OpenAndFillForm(int row) throws Exception{
		//Call all the elements located in CreateInputType_page.java class using page factory 
		CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
		Log.info("Called all the elements using page factory ");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		
	    WebElement mte=CreateLibObj.getLibrary();
	    new Actions(driver).moveToElement(mte).perform();
	    Log.info("Mouse hover on library from navigation menu.");
	    
	    CreateLibObj.getInputOptInLibMenu().click();
	    Log.info("Clicked on Input options in library menu.");
	    
	    Thread.sleep(3000);
	    libraryName=DriverUtils.getLibraryName();
	    new BaseClass(libraryName);
	    
	    WebElement getCreateNewButton= CreateLibObj.getcreateNew_btn();
	    Utils.waitForElementOnvisibilityOf(getCreateNewButton);
	    getCreateNewButton.click();
	    Log.info("Clicked on create new button");
	    
	    //Enter the input type name in input type form
	    InputOptionName= ExcelUtils.getCellData(row, Constant.Col_InputOptionName);
	    WebElement getInputOptionName= CreateLibObj.getInputOptionName();
	    Utils.waitForElementOnvisibilityOf(getInputOptionName);
	    Thread.sleep(2000);
	    getInputOptionName.sendKeys(InputOptionName);
	    Log.info("Input option name '" + InputOptionName + "' has been added.");
	    
	    //Select collection
	    new Select(CreateLibObj.getCollectionDDL()).selectByIndex(2);
	    Log.info("Collection has been selected");
	    
	    ExcelUtils.setExcelFile(ExcelPaths.InputOptionDataSheetPath, Constant.SheetNameForIO);
	    int Total_number_of_rows= ExcelUtils.getRowUsed();
	    
	    for(int Row=1; Row<=Total_number_of_rows; Row++){
	    String inputOptions= ExcelUtils.getCellData(Row, Constant.Col_IOItems);
	    CreateLibObj.getInputOption().sendKeys(inputOptions);
	    new Actions(driver).sendKeys(Keys.ENTER).perform();
	    }
	    Log.info("Input option(s) have been entered.");
	    System.out.println("Open and fill the input option form details");
	}
}
