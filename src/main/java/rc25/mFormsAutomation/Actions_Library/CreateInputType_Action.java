package rc25.mFormsAutomation.Actions_Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class CreateInputType_Action extends BaseClass{

	public CreateInputType_Action(WebDriver driver) {
		super(driver);
	}
	
	public CreateInputType_Action(String libraryName) {
		super(libraryName);
	}

	//Created a object of CreateInputType_page.java class to use it's variables
		static CreateLibrary_objects CreateLibObj;
		public static String inputType;
		
		//Method to open the form 
		public static void BlankForm(int row) throws Exception{
			//Call all the elements located in CreateInputType_page.java class using page factory 
			CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
			Log.info("Called all the elements using page factory ");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 10 seconds");
			
		    WebElement mte=CreateLibObj.getLibrary();
		    new Actions(driver).moveToElement(mte).perform();
		    Log.info("Mouse hover on library from navigation menu.");
		    
		    CreateLibObj.getInputTypes_inLibraryMenu().click();
		    Log.info("Clicked on Input types in library menu.");
		    
		    Thread.sleep(3000);
		    libraryName=DriverUtils.getLibraryName();
		    new BaseClass(libraryName);
		    WebElement getCreateNewButton= CreateLibObj.getcreateNew_btn();
		    Utils.waitForElementOnvisibilityOf(getCreateNewButton);
		    getCreateNewButton.click();
		    Log.info("Clicked on create new button");
		    
		    //Enter the input type name in input type form
		    String InputTypeName= ExcelUtils.getCellData(row, Constant.Col_InputItemName);
		    WebElement getInputTypeName= CreateLibObj.getInputTypeName();
		    Utils.waitForElementOnvisibilityOf(getInputTypeName);
		    Thread.sleep(2000);
		    getInputTypeName.sendKeys(InputTypeName);
		    
		    //Select collection
		    //new Select(CreateLibObj.getCollectionDDL()).selectByIndex(2);
		}
}
