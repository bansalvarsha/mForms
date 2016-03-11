package rc25.mFormsAutomation.Actions_Library;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;
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
	static CreateLibrary_objects CreateLibObj; 
	static String AddedItemName;
	static WebElement getRecordInTheList;
	static boolean save_btn = false;
	 
		
	//Method to save the form
	public static void SaveAndVerify(int row) throws Exception {
		SaveAndverifyObj= PageFactory.initElements(driver, SaveAndverifyTheForm_objects.class);
		CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
		
		input = new FileInputStream(Constant.MessageConfigPath);
		props.load(input);
		
		Thread.sleep(5000);
		
		/*//Click on save button if user is creating "Form"
		if(libraryName.toLowerCase().contains("forms library"))
			SaveAndverifyObj.getSaveForm_btn().click();
		else 
		 SaveAndverifyObj.getsave_btn().click();
		 Log.info("Clicked on save button");*/
		 
		 
		 
	      try{
	    	  save_btn = SaveAndverifyObj.getSaveForm_btn().isDisplayed();
	    	  save_btn= true;
	          } catch(Exception e){
	       e.getStackTrace();
	       save_btn= false;
	          }
	      
	          if(save_btn){
	        	  SaveAndverifyObj.getSaveForm_btn().click();
	        	  try{
	        	  SaveAndverifyObj.getSaveForm_btn().click();
	        	  }catch(Exception nsee){
	        		  nsee.getStackTrace();
	        	  }
	          }else SaveAndverifyObj.getsave_btn().click();
		 
		 //Handle save form pop up while user edit and saves the form
		 EditFormPopup();
		 
		 WebElement ConfirmtionMessage= SaveAndverifyObj.getConfirmationMessage();
		 Utils.waitForElementOnvisibilityOf(ConfirmtionMessage);
		 if(ConfirmtionMessage.isDisplayed()){
			 String getConfirmtionMessage=  ConfirmtionMessage.getText();
			 System.out.println(getConfirmtionMessage);
		 
			 //Get confirmation message from property file, after click on save message that message is saved or not 
			 String RecordAdded= props.getProperty("RecordAdded");
			 if(getConfirmtionMessage.contains(RecordAdded)){
				 Log.info(getConfirmtionMessage);
				  getRecordInTheList= SaveAndverifyObj.getRecordInTheList();
				 if (getRecordInTheList.isDisplayed()){
					 
					 if(libraryName.toLowerCase().equals("forms library")){
						 getFormCount_and_NewFormName();
					 
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
	
	static void EditFormPopup(){
		boolean popup = false; 
		if(!CreateForm_Action.getFormNameValue.equals("")){
			try{
				popup = driver.findElement(By.id("popup_container")).isDisplayed();
				popup= true;
			} catch(Exception nsee){
				nsee.getStackTrace();
				popup= false;
			}
			if(popup){
				driver.findElement(By.id("popup_ok")).click();
			}
		}
	}
	
	static void getFormCount_and_NewFormName(){
		if( CreateLibObj.getFormList().isDisplayed()){
			 int Total_Forms_Count_after_Form_Creation= CreateLibObj.getAllForms().size();//get forms count
			 System.out.println("After adding a form, total number of forms are " + Total_Forms_Count_after_Form_Creation);
			 if(Total_Forms_Count_after_Form_Creation>CreateForm_Action.TotalFormsCount){
				 AddedItemName= getRecordInTheList.getAttribute("frmnm").toString(); //get new added form name
				 Log.info("Recently added Form name= " + AddedItemName);
				 System.out.println("Recently added Form name= " + AddedItemName);	 
			 }
		 }
	}
	
}
