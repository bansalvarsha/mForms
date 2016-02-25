package rc25.mFormsAutomation.Actions_Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.AddResponse_objects;
import rc25.mFormsAutomation.OR_Library.SaveAndverifyTheForm_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class PublishForm_Actions extends BaseClass {
		
		public PublishForm_Actions(WebDriver driver) {
			super(driver);
		}

		static Properties props = new Properties();
		static InputStream input = null;
		static AddResponse_objects responseObj;
		static SaveAndverifyTheForm_objects SaveAndverifyObj;
		
		public static void publishTheForm(int row) throws Exception{
			SaveAndverifyObj= PageFactory.initElements(driver, SaveAndverifyTheForm_objects.class);
			responseObj= PageFactory.initElements(driver, AddResponse_objects.class);
			
			try {
				input = new FileInputStream(Constant.MessageConfigPath);
				props.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			SaveAndverifyObj.getRecordInTheList().click();
			responseObj.getPublish_btn().click();
			String alert= responseObj.getPopup().getText();
			String DateAlert= props.getProperty("DateAlert");
			if(alert.equals(DateAlert)){
				responseObj.getPopup_ok().click();
			}
			
			CreateForm_Action.AddActivationDate(row);
			
			responseObj.getPublish_btn().click();
			responseObj.getPopup_ok().click();
		
			WebElement ConfirmtionMessage= SaveAndverifyObj.getConfirmationMessage();
			try {
				Utils.waitForElementOnvisibilityOf(ConfirmtionMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ConfirmtionMessage.isDisplayed()){
				String getConfirmtionMessage=  ConfirmtionMessage.getText();
				System.out.println(getConfirmtionMessage);
				
				String RecordUpdated= props.getProperty("RecordUpdated");
				if(getConfirmtionMessage.contains(RecordUpdated)){
					Log.info(getConfirmtionMessage);
				}
			}
		}
}
