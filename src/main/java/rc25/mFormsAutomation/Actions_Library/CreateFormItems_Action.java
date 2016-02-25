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

public class CreateFormItems_Action extends BaseClass {

	public CreateFormItems_Action(WebDriver driver) {
		super(driver);
	}
	
	public CreateFormItems_Action(String libraryName) {
		super(libraryName);
	}

	static CreateLibrary_objects CreateLibObj;
	//Method to open the form 
	public static void BlankForm(int row) throws Exception{
		CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
		Log.info("Called all the elements using page factory ");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		
	    WebElement mte=CreateLibObj.getLibrary();
	    new Actions(driver).moveToElement(mte).perform();
	    Log.info("Mouse hover on library from navigation menu");
	    
	    CreateLibObj.getFormsItems_inLibraryMenu().click();
	    Log.info("Clicked on Form items in library menu");
	    
	    Thread.sleep(10000);
	    libraryName=DriverUtils.getLibraryName();
	    new BaseClass(libraryName);
	    
	    WebElement getCreateNewButton= CreateLibObj.getcreateNew_btn();
	    Utils.waitForElementOnvisibilityOf(getCreateNewButton);
	    getCreateNewButton.click();
	    Log.info("Clicked on create new button");
	    
	    Thread.sleep(2000);
	    String ItemTitle= ExcelUtils.getCellData(row, Constant.ItemTitle);
	    CreateLibObj.getItemTitle_txtbox().sendKeys(ItemTitle);
	    
	    String ItemDescription= ExcelUtils.getCellData(row, Constant.ItemDescription);
	    CreateLibObj.getItemDescription_txtarea().sendKeys(ItemDescription);
	    
	   // new Select(CreateLibObj.getCustomItemCollectionID_DDL()).selectByIndex(0);
	}
}
