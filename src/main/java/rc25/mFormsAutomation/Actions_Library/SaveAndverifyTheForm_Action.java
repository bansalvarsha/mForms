package rc25.mFormsAutomation.Actions_Library;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.SaveAndverifyTheForm_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class SaveAndverifyTheForm_Action extends BaseClass {
	public SaveAndverifyTheForm_Action(WebDriver driver) {
		super(driver);
	}
	
	public SaveAndverifyTheForm_Action(String libraryName) {
		super(libraryName);
	}

	//Get information from MessageConfig.properties 		
	static Properties props = new Properties();
	static InputStream input = null;
	static SaveAndverifyTheForm_objects SaveAndverifyObj;
	 static String AddedItemName;
		
	//Method to save the form
	public static void SaveAndVerify(int row) throws Exception {
		SaveAndverifyObj= PageFactory.initElements(driver, SaveAndverifyTheForm_objects.class);
		
		input = new FileInputStream(Constant.MessageConfigPath);
		props.load(input);
		
		Thread.sleep(5000);
		//Click on save button if user is creating "Form"
		if(libraryName.toLowerCase().contains("forms library"))
			SaveAndverifyObj.getSaveForm_btn().click();
		else 
		 SaveAndverifyObj.getsave_btn().click();
		 Log.info("Clicked on save button");
		 
		 WebElement ConfirmtionMessage= SaveAndverifyObj.getConfirmationMessage();
		 
		 
		 Utils.waitForElementOnvisibilityOf(ConfirmtionMessage);
		 if(ConfirmtionMessage.isDisplayed()){
			 String getConfirmtionMessage=  ConfirmtionMessage.getText();
			 System.out.println(getConfirmtionMessage);
		
		 
			 //Get confirmation message from property file, after click on save message that message is saved or not 
			 String RecordAdded= props.getProperty("RecordAdded");
			 if(getConfirmtionMessage.contains(RecordAdded)){
				 Log.info(getConfirmtionMessage);
				 WebElement getRecordInTheList= SaveAndverifyObj.getRecordInTheList();
				 if (getRecordInTheList.isDisplayed()){
					 
					 if(libraryName.toLowerCase().equals("forms library")){
						 AddedItemName= getRecordInTheList.getAttribute("frmnm").toString();
						 Log.info("Recently added Form name= " + AddedItemName);
						 System.out.println("Recently added Form name= " + AddedItemName);
						 
					 } else if(libraryName.toLowerCase().equals("input types library")){
						 AddedItemName= SaveAndverifyObj.getInputTypeName().getText();
						 Log.info("Recently added Input type name= " + AddedItemName);
						 System.out.println("Recently added Input type name= " + AddedItemName);
					
					 } else if(libraryName.toLowerCase().equals("item library")){
						 AddedItemName= SaveAndverifyObj.getItemName().getText();
						 Log.info("Recently added Form Item name= " + AddedItemName);
						 System.out.println("Recently added Form Item name= " + AddedItemName);
					
					 } else if(libraryName.toLowerCase().equals("input options library")){
						 AddedItemName= SaveAndverifyObj.getIOptionname().getText();
						 Log.info("input option name= " + AddedItemName);
			    		System.out.println("input option name= " + AddedItemName);
					 }
					 
					 String ItemNameFromExcelFile= ExcelUtils.getCellData(row, Constant.Col_FormName);
					 System.out.println("Item name in data sheet (Excel)= " + ItemNameFromExcelFile);
					 Log.info("Item name in data sheet (Excel)= " + ItemNameFromExcelFile);
					 
					 if(AddedItemName.equals(ItemNameFromExcelFile)){
						 Log.info(AddedItemName + " is available on the" + libraryName + "listing page.");
					 } else Log.info("Newly created item's name is not matched with data sheet item's name");
				 }else Log.info("Record is not found in the items list.");
			 } else Log.info(getConfirmtionMessage);
		 }else { 
			 Log.info("No confirmation message is found"); 
			 System.out.println("No confirmation message is found");
		 }
	 }
	
	public static void getTheConfirmationMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ConfirmtionMessage= SaveAndverifyObj.getConfirmationMessage();
	    wait.until(ExpectedConditions.visibilityOf(ConfirmtionMessage));
	    String getConfirmtionMessage=  ConfirmtionMessage.getText();
	    System.out.println(getConfirmtionMessage);
	}
}
