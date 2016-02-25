package rc25.mFormsAutomation.Actions_Home;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Home.UserRegistration_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;

public class UserRegistration_Action extends BaseClass {

	public UserRegistration_Action(WebDriver driver) {
		super(driver);
	}
	
	static UserRegistration_objects UserRegObjs;
	
	//Get information from MessageConfig.properties 		
	static Properties props = new Properties();
	static InputStream input = null;
	static String Email;
	static String parentHandle;
	static String getConfirmtionMessage;
	//static GenerateData genData;

	public static void MoveToRegistrationPage() throws Exception{
		UserRegObjs= PageFactory.initElements(driver, UserRegistration_objects.class);
		
		Thread.sleep(4000);
		UserRegObjs.getCustomersTab().click();
		Log.info("Clicked on Customers Tab");
		
		parentHandle = driver.getWindowHandle(); // get the current window handle
		Thread.sleep(3000);
		UserRegObjs.getCreateClient_btn().click();
		Log.info("Clicked on Create New button to open the registration page");
	}
		
	
	
	public static void Registration(int row) throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			 // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			 driver.switchTo().window(winHandle); 
		 }

		//genData=new GenerateData();
			UserRegObjs= PageFactory.initElements(driver, UserRegistration_objects.class);
			input = new FileInputStream(Constant.MessageConfigPath);
			props.load(input);
			
			Email= ExcelUtils.getCellData(row, Constant.col_email);
			//UserRegObjs.getEmail().sendKeys(genData.generateEmail(30));
			UserRegObjs.getEmail().sendKeys(Email);
			Log.info("Email entered");
			
			String Password= ExcelUtils.getCellData(row, Constant.Col_Password);
			UserRegObjs.getpassword().sendKeys(Password);
			Log.info("password entered");
			
			String CheckFirstName= ExcelUtils.getCellData(row, Constant.col_CheckFirstname);
			if(CheckFirstName.equalsIgnoreCase("yes")){
				String Firstname= ExcelUtils.getCellData(row, Constant.col_Firstname);
				UserRegObjs.getFirstName().sendKeys(Firstname);
				Log.info("First name entered");
			}
			
			String checkLastname= ExcelUtils.getCellData(row, Constant.col_checklastname);
			if(checkLastname.equalsIgnoreCase("yes")){
				String lastname= ExcelUtils.getCellData(row, Constant.col_lastname);
				UserRegObjs.getLastName().sendKeys(lastname);
				Log.info("last name entered");
			}
			
			String checkCompanyName= ExcelUtils.getCellData(row, Constant.col_checkCompanyName);
			if(checkCompanyName.equalsIgnoreCase("yes")){
				String Companyname= ExcelUtils.getCellData(row, Constant.col_CompanyName);
				UserRegObjs.getCompanyName().sendKeys(Companyname);
				Log.info("company name entered");
			}
			
			String checkIndustry= ExcelUtils.getCellData(row, Constant.col_CheckIndustrynaem);
			if(checkIndustry.equalsIgnoreCase("yes")){
				String Industry= ExcelUtils.getCellData(row, Constant.col_IndusrtyName);
				new Select(UserRegObjs.getIndustyId()).selectByVisibleText(Industry);
				Log.info("Industry selected");
			}
			
			UserRegObjs.getNext_btn().click();
			Thread.sleep(2000);
			UserRegObjs.getregister_btn().click();
			 WebElement ConfirmtionMessage= UserRegObjs.getConfirmationMessage();
			 if(ConfirmtionMessage.isDisplayed()){
			    	getConfirmtionMessage=  ConfirmtionMessage.getText();
			    	System.out.println(getConfirmtionMessage);
			    	Log.info(getConfirmtionMessage);
			 }
			 
			 driver.close(); // close newly opened window when done with it
			 driver.switchTo().window(parentHandle); // switch back to the original window
			 
			 Thread.sleep(3000);
		 
			 if(driver.getCurrentUrl().equals((Constant.URL)+ "u/0/Customer/CustomerManagementMain")) {
				 if(getConfirmtionMessage.equals(props.getProperty("RecordAdded"))){
					 Log.info("New customer: " + Email + " has been added");
					 System.out.println("New customer: " + Email + " has been added");
				 } else {
					 Log.info("Customer name: " + Email + ", " + getConfirmtionMessage);
					 System.out.println("Customer name: " + Email + ", " + getConfirmtionMessage);
				 }				 
				 Thread.sleep(2000);
				 Logout_Action.Logout();
			 } 
	}
}
