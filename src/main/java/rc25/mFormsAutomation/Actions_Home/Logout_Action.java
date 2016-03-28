package rc25.mFormsAutomation.Actions_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Home.Logout_objects;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class Logout_Action extends BaseClass {
	public Logout_Action(WebDriver driver) {
		super(driver);
	}

	private static WebElement element = null;
	static Logout_objects logoutObject;
	
	public static void Logout() throws Exception{
	
		logoutObject= PageFactory.initElements(driver, Logout_objects.class);
		//This is to click on logout menu icon to find the logout option
		element= logoutObject.getlogout_icon();
		Thread.sleep(6000);
		Utils.waitForElementOnvisibilityOf(element);
		element.click();
	
		//This is to click on logout button
		element= logoutObject.getbtnlogout();
		Utils.waitForElementOnvisibilityOf(element);
		element.click();
		Log.info("Logout button found on home page");
	}
}
