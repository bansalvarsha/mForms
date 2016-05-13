package rc25.mFormsAutomation.Actions_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Home.Login_objects;
import rc25.mFormsAutomation.utility.*;

public class Login_Action extends BaseClass{

	public Login_Action(WebDriver driver) {
		super(driver);
	}

	private static WebElement element = null;
	
	static Login_objects loginObject;
	static String Username;
	static String password;
	
	//This method is to perform the login action
	public static void Login_steps(int Row) throws Exception {
		
		loginObject= PageFactory.initElements(driver, Login_objects.class);
		
		//This is to get the user name value from excel sheet and send it to user name field
		Username= ExcelUtils.getCellData(Row, Constant.Col_UserName);
		loginObject.getUsername().clear();
		loginObject.getUsername().sendKeys(Username);
		Log.info("User name '" + Username + "' entered");
		
		//This is to get the password value from excel sheet and send it to password field
		password= ExcelUtils.getCellData(Row, Constant.Col_Password);
		loginObject.getpassword().clear();
		loginObject.getpassword().sendKeys(password); 
		Log.info("password '" + password + "' entered");
		
		//this is to check if user wants to remember the credentials or not by clicking on remember me check box
		String RM= ExcelUtils.getCellData(Row, Constant.Col_rememberMe);
		if(RM.equalsIgnoreCase("yes")) {
			loginObject.getrememberMe().click();
		}
		
		//This is to click on log out button 
		element= loginObject.getbtnlogin();
		Utils.waitForElementOnvisibilityOf(element);
		element.click();
		Log.info("Clicked on login button");
		System.out.println("Entered the credentials " + Username + "/" + password + " clicked on login button");
	}
			 
	
	//This method is to check user type after login and check the validation messages while login if user has entered the wrong data in test data sheet 
	public static void TestDatavalidation() {
		try{
			String currentURL= driver.getCurrentUrl();
			
			//verify the validation messages on login page in case if user has entered the wrong credentials
			if(currentURL.equals(Constant.URL)){
				if(loginObject.getValidation_summary_error().isDisplayed()){
					String validationError= loginObject.getValidation_summary_error().getText();
					Log.info("Validation error is '" + validationError + "'");
				}else {
					int NumberOfvalidationMsg= loginObject.getallValidation_errorsInList().size();
				for(int i=0; i<NumberOfvalidationMsg; i++ ){
					String validationMsg= loginObject.getallValidation_errorsInList().get(i).getText();
					Log.info("Validation message is '" + validationMsg + "'");
				}
				}
			}
			//Verify the user type on the basis of top navigations in case if user is successfully logged in
			else{ 
				if(loginObject.gettop_nav().getText().contains("CUSTOMERS")) {
					Log.info("Top navigations are found on home page");
					Log.info("Logged in user is the super admin");
					System.out.println("Logged in user is the super admin");
				} else if (loginObject.gettop_nav().getText().contains("USERS")) {
					Log.info("Logged in user is the admin");
					System.out.println("Logged in user is the admin");
				}else {
					Log.info("Logged in user is a general type of user");
					System.out.println("Logged in user is a general type of user");
				}
				
				Thread.sleep(4000);
				Logout_Action.Logout();
			}
		}catch(Exception e){
			Log.error("Some thing is suspicious here, no validation messages occured");
		}
	}
	
	
}
	
