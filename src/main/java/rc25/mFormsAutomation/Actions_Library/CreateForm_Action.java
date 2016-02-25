/*---------------------------------------------------------------------------------------------------------------------
<copyright file="CreateForm_Action.java" company="Astegic Info solutions" Product= "MForms">
Copyright 2015
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/

package rc25.mFormsAutomation.Actions_Library;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

//Extends Utils for using the same driver initialized in Utils.java class
public class CreateForm_Action extends BaseClass{

	public CreateForm_Action(WebDriver driver) {
		super(driver);
	}
	
	public CreateForm_Action(String libraryName) {
		super(libraryName);
	}

	//Created a object of CreateLibrary_objects.java class to use it's variables
	static CreateLibrary_objects CreateLibObj; 

	//Method to open the form 
	public static void BlankForm() throws InterruptedException {
		//Call all the elements located in CreateLibrary_objects.java class using page factory 
		CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
		Log.info("Called all the elements using page factory ");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		
	    WebElement mte=CreateLibObj.getLibrary();
	    new Actions(driver).moveToElement(mte).perform();
	    Log.info("Mouse hover on library from navigation menu");
	    
	    CreateLibObj.getForms_inLibraryMenu().click();
	    Log.info("Clicked on Forms in library menu");
	    
	    try {
			Thread.sleep(5000);
	    libraryName=DriverUtils.getLibraryName();
	    } catch (Exception e) {
			e.printStackTrace();
		}
	    
	    Thread.sleep(5000);
	    new BaseClass(libraryName);
	    
	    WebElement getCreateNewButton= CreateLibObj.getcreateNew_DDL();
	    try {
			Utils.waitForElementOnvisibilityOf(getCreateNewButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    getCreateNewButton.click();
	    Log.info("Clicked on create new button");
	    
	    CreateLibObj.getBlankForm().click();
	    Log.info("Clicked on Blank form");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 
	 //Method to fill the form details
	 public static void fillBlankForm(int row) throws Exception   {
		 String ActFormName;
		 String ActFormDisc;
		try {
			Thread.sleep(1000);
			ActFormName = ExcelUtils.getCellData(row, Constant.Col_FormName);
			CreateLibObj.getForm_Name().sendKeys(ActFormName);
			Log.info("Form title: " + ActFormName + " is entered.");
			
			ActFormDisc= ExcelUtils.getCellData(row, Constant.Col_FormDescription);
			CreateLibObj.getForm_desc().sendKeys(ActFormDisc);
			Log.info("Form description:" + ActFormDisc + " is entered");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 /*//Select the collection
		 Select sel=new Select(CreateLibObj.getForm_collection());
		 sel.selectByIndex(1);
		 Log.info("Form collection at the index '1' is selected by the driver.");*/
		 
		 //get created by, last updated on, created on labels of the form
		 List<WebElement> getLables= CreateLibObj.getLabels();
		 for(WebElement label:getLables){
			 String getLabels= label.getText();
			 System.out.println(getLabels);
			 Log.info(getLabels);
		 }
		 
		 //Get version of the form
		 String version_title= CreateLibObj.getVersion_title().getText();
		 String Version= CreateLibObj.getVersion().getAttribute("value");
		 System.out.println(version_title + " " + Version);
		 
		 //Choose theme
		 WebElement getChooseThemeDDL= CreateLibObj.getChooseTheme_btn(); 
			Utils.waitForElementOnvisibilityOf(getChooseThemeDDL);
		 getChooseThemeDDL.click();
		 Log.info("Clicked on choose theme drop down list");
		 
		 //currently it is a static value
		 CreateLibObj.getChooseTheme().click();
		 Log.info("Theme 'Super admin theme' is selected");
		 
		 
		 //Check the activation check box
		 String Acti = ExcelUtils.getCellData(row, Constant.Col_Activation);
			 if(Acti.equalsIgnoreCase("yes")){
				 CreateLibObj.getactivation_chkbox().click();
				 Log.info("Form activated");
			 } else
				 Log.info("Activation has been skiped");
	 }
	 
	 public static void AssignBarcode_And_MasterImage(int row) throws Exception{
		 CreateLibObj.getAssign_barcode_link().click();
		 
		 String barcode= ExcelUtils.getCellData(row, Constant.Col_barcode);
		 CreateLibObj.getBarcode_txtbox().sendKeys(barcode);
		 
		 //Add master image
		 CreateLibObj.getAddMasterImg_link().click();
		 CreateLibObj.getchange_btn().click();
		 CreateLibObj.getBrowse_btn().click();
		 Runtime.getRuntime().exec(Constant.ImagePath);
	     Thread.sleep(5000);
	     
	     CreateLibObj.getUpload_btn().click();
	 }
	 
	 public static void AddActivationDate(int row) throws Exception {
		 if(CreateLibObj.getActivation_date_area().getAttribute("style").equals("display: block;")){
		 /*CreateLibObj.getStartDate().click();
			
		 String getMonth = ExcelUtils.getCellData(row, Constant.col_StartMonth);
		 Select Month= new Select(CreateLibObj.getDatePickerMonth());
		 Month.selectByVisibleText(getMonth);
		 
		 String getYear= ExcelUtils.getCellData(row, Constant.col_StartYear);
		 Select Year= new Select(CreateLibObj.getDatePickerYear());
		 Year.selectByVisibleText(getYear);
		
		 WebElement Date= driver.findElement(By.xpath(CreateLibrary_objects.StartDate(row)));
		 Date.click();*/
				
		 CreateLibObj.getEndDate().click();
		 String getEndMonth = ExcelUtils.getCellData(row, Constant.col_EndMonth);
		 Select EndMonth= new Select(CreateLibObj.getDatePickerMonth());
		 EndMonth.selectByVisibleText(getEndMonth);
		
		 String getEndYear= ExcelUtils.getCellData(row, Constant.col_EndYear);
		 Select EndYear= new Select(CreateLibObj.getDatePickerYear());
		 EndYear.selectByVisibleText(getEndYear);
		
		 WebElement EndDate= driver.findElement(By.xpath(CreateLibrary_objects.EndDate(row)));
		 EndDate.click();
		 }
	 }
	 
	 public static void RenamePageName(int row) throws Exception{
		 new Actions(driver).moveToElement(CreateLibObj.getPageText_1()).click().build().perform();
		 CreateLibObj.getPageText_1().clear();
		 
		 String PageName= ExcelUtils.getCellData(row, Constant.Col_pageName);
		 CreateLibObj.getPageText_1().sendKeys(PageName);
	 }
}
