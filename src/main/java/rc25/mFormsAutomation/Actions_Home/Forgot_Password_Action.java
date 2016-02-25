package rc25.mFormsAutomation.Actions_Home;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Home.Forgot_Password_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

public class Forgot_Password_Action extends BaseClass{
	public Forgot_Password_Action(WebDriver driver) {
		super(driver);
	}

	static Forgot_Password_objects forgotPwdObj;
	static Properties props = new Properties();
	static InputStream input = null;
	static String resetURL;
	
	public static void forgotPassword(int row) throws Exception{
		input = new FileInputStream(Constant.MessageConfigPath);
		props.load(input);
		forgotPwdObj= PageFactory.initElements(driver, Forgot_Password_objects.class);
		forgotPwdObj.getForgotPassword_txt().click();
		String Email= ExcelUtils.getCellData(row, Constant.col_email);
		forgotPwdObj.getEmail_txtBox().sendKeys(Email);
		forgotPwdObj.getSend_btn().click();
		WebElement infoMessage= forgotPwdObj.getinfoMessage();
		 if(infoMessage.isDisplayed()){
			 String getMessage=  infoMessage.getText();
			 Log.info(getMessage);
			 
			 String forgotPwdlinksent= props.getProperty("forgotPwdlinksent");
			 if(getMessage.contains(forgotPwdlinksent)){
				 Log.info(getMessage);
			 }
		 }
	}
	
	public static void readResetPwdEmail(int row) throws Exception{
		
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		String Email =ExcelUtils.getCellData(row, Constant.col_email);
		String Password= ExcelUtils.getCellData(row, Constant.col_CurrentPwd);
		store.connect("imap.gmail.com", Email, Password);

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		 Log.info("Total Message:" + folder.getMessageCount());
		 Log.info("Unread Message:" + folder.getUnreadMessageCount());
	        
		 Message[] messages = null;
		 boolean isMailFound = false;
		 Message mailFromMForms= null;

		 //Search for mail from mForms
		 for (int i = 0; i<= 5; i++) {
			input = new FileInputStream(Constant.MessageConfigPath);
			props.load(input);
			String ResetMailSubject= props.getProperty("ResetMailSubject");
			messages = folder.search(new SubjectTerm(ResetMailSubject), folder.getMessages());
			//Wait for 10 seconds
			if (messages.length == 0) {
				 Thread.sleep(10000);
			}
		 }
		 
		 //Search for unread mail from MForms. 
		 for (Message mail : messages) {
			 if (!mail.isSet(Flags.Flag.SEEN)) {
				 mailFromMForms = mail;
				 Log.info("Message Count is: " + mailFromMForms.getMessageNumber());
				 isMailFound = true;
			 }
		 }

		 //Test fails if no unread mail was found from mForms
		 if (!isMailFound) {
			 throw new Exception("Could not find new mail");
			 
			 //Read the content of mail and launch registration URL                
		 } else {
			 String line;
			 StringBuffer buffer = new StringBuffer();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromMForms.getInputStream()));
			 while ((line = reader.readLine()) != null) {
				 buffer.append(line);
			 }
			// System.out.println(buffer);

			 //Your logic to split the message and get the reset URL goes here
			 resetURL = buffer.toString().split("\"")[1];
			 Log.info("resetURL= " + resetURL);
		 }
		}
	
	public static void ChangePassword(int row) throws Exception {
		forgotPwdObj.getBody().sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.get(resetURL);
		
		String NewPassword= ExcelUtils.getCellData(row, Constant.col_newPwd);
		forgotPwdObj.getPassword().sendKeys(NewPassword);
		forgotPwdObj.getConfirmPassword().sendKeys(NewPassword);
		
		forgotPwdObj.getResetPwd().click();
		String Email= ExcelUtils.getCellData(row, Constant.col_email);
		boolean b = driver.getPageSource().contains(Email);
		Assert.assertTrue(b);
		Log.info("Password has been reset successfully");
	}
}
