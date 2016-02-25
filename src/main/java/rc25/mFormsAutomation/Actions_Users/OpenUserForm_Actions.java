package rc25.mFormsAutomation.Actions_Users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Users.OpenUserForm_objects;
import rc25.mFormsAutomation.utility.Log;

public class OpenUserForm_Actions extends BaseClass {

	public OpenUserForm_Actions(WebDriver driver) {
		super(driver);
	}

	static OpenUserForm_objects CreateLibObj; 
	
	public static void OpenForm() throws Exception{
		CreateLibObj= PageFactory.initElements(driver, OpenUserForm_objects.class);
		Log.info("Called all the elements using page factory ");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		
	    WebElement mte=CreateLibObj.getUsers();
	    new Actions(driver).moveToElement(mte).perform();
	    Log.info("Mouse hover on Users from navigation menu");
	    
	    CreateLibObj.getUsers_inUsersMenu().click();
	    Log.info("Clicked on Users in Users menu");
	    
	    WebElement getCreateNewButton= CreateLibObj.getcreateNew_DDL();
	    
	    getCreateNewButton.click();
	    Log.info("Clicked on create new button");
	    
	    Thread.sleep(2000);
	    CreateLibObj.getAddUsers().click();
	    Log.info("Clicked on Add users");
	}
}
