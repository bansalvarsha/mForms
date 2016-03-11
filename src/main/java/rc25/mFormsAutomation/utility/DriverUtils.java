package rc25.mFormsAutomation.utility;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.AddInputTypeInForms_objects;
import rc25.mFormsAutomation.OR_Library.AddResponse_objects;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;

public class DriverUtils extends BaseClass{
	public DriverUtils(WebDriver driver) {
		super(driver);
	}
	
	static CreateLibrary_objects CreateLibObj;
	public static String libraryName;
	
	static Properties props = new Properties();
	static InputStream input = null;
	public static String RecordAdded;

	//Method to get the library name 
	public static String getLibraryName() throws Exception {
		try{
		CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
		libraryName= CreateLibObj.getlibraryName().getText();
		return libraryName;
		}catch(Exception e){
			Log.error("Class Utils | Method getLibraryName | Exception occured while getting library name : "+e.getMessage());
			throw new Exception();
		}
	}
	
	//Method to add remarks in add response
	public static void Remarks(int row) throws Exception{
		String Remarks= ExcelUtils.getCellData(row, Constant.col_Remarks);
		driver.findElement(By.xpath(AddResponse_objects.getRemark_txtbox_FromAddResponse())).sendKeys(Remarks);
	}
	
	//Method for check the required check box in every input type rather than display input types
	public static void RequiredChkbox(int row) throws Exception {
		String ActRequired= ExcelUtils.getCellData(row, Constant.Col_Required);
		AddInputTypeInForms_objects.mRow= row;
		WebElement element= driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired()));
		
		if(ActRequired.equalsIgnoreCase("yes")) {
			//Verify if the check box is not checked
			if(element.getAttribute("style").contains("background-position: 0px 0px;")){
				Utils.waitForElementOnvisibilityOf(element);
				driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired())).click();
			} else Log.info("Required has been skipped");
		
		}else {
			if(element.getAttribute("style").contains("background-position: 0px 0px;")){
				Log.info("Required has been skipped");
			} else{
				Utils.waitForElementOnvisibilityOf(element);
				driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired())).click();
			}
		}
	}
		
	//Method for check the open comment check box in every input type rather than display input types
	public static void OpenCommentChkbox(int row) throws Exception {
		String openCommand= ExcelUtils.getCellData(row, Constant.Col_openComment);//Fetching Data from excel 
		AddInputTypeInForms_objects.mRow= row;
		WebElement element= driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLoc()));
		
		if(openCommand.equalsIgnoreCase("yes")) {
			if(element.getAttribute("style").contains("background-position: 0px 0px;")){
					driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLoc())).click();
			}else Log.info("open comment has been skiped");
			
		} else{
			if(element.getAttribute("style").contains("background-position: 0px 0px;")){
				Log.info("open comment has been skiped");
			} else{
				driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLoc())).click();
			}
		}
	}
	
	//Method for enter the caption of the button in every input type rather than display input types
	public static void ButtonCaption(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);//Fetching Data from excel 
		
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButtonLoc())).clear();
		driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButtonLoc())).sendKeys(CaptionOfButton);   
	}
	
	//Method for enter the input options in the list of some input types
	public static void InputOption(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
    	for (String InputOptSpl: InputOption.split("-", InputOption.length())) {
    		driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLoc())).sendKeys(InputOptSpl);
    	    new Actions(driver).sendKeys(Keys.ENTER).perform();
    	}
	}
		
	/*//Method to call the properties file
	public static String getInfoMessages() throws IOException{
	try {
		input = new FileInputStream(Constant.MessageConfigPath);
		props.load(input);
		//RegistrationSuccessfull= props.getProperty("RegistrationSuccessfull");
		RecordAdded= props.getProperty("RecordAdded");
		//forgotPwdlinksent= props.getProperty("forgotPwdlinksent");
		//ResetMailSubject= props.getProperty("ResetMailSubject");
		return RecordAdded ;
	} catch (IOException e) {
		e.printStackTrace();
		Log.error("Class DriverUtils | Method getInfoMessages | Exception occurred while getting get Info Message : " + e.getMessage());
		throw new IOException();
	}
	
	}*/
	
	//Method to verify the created or edited form's required check box value from excel sheet
	public static void VerifyRequiredChkbox(int row) throws Exception {
		String getActRequired;
		String ActRequired= ExcelUtils.getCellData(row, Constant.Col_Required).toLowerCase();
		AddInputTypeInForms_objects.mRow= row;
		
		WebElement element= driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired()));
		
		//Verify if the check box is not checked
		if(element.getAttribute("style").contains("background-position: 0px 0px;")){
			getActRequired= "No".toLowerCase();
		}else getActRequired= "Yes".toLowerCase();
		
		String DataMatch= "Required checkbox has same value as mentioned in data sheet.";
		String DataMismatch= 	"Required checkbox has different value from data sheet. "
				+ "Data sheet value is: " + ActRequired + " and Form value is: " + getActRequired;	
		Utils.VerifyMessages(ActRequired, getActRequired, row, DataMatch, DataMismatch);
	}
		
	//Method to verify the created or edited form's Open for comment check box value from excel sheet
	public static void VerifyOpenCommentChkbox(int row) throws Exception {
		String getOpenCommand;
		String openCommand= ExcelUtils.getCellData(row, Constant.Col_openComment).toLowerCase();//Fetching Data from excel 
		AddInputTypeInForms_objects.mRow= row;
		
		WebElement element= driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLoc()));
			
		//Verify if the check box is not checked
		if(element.getAttribute("style").contains("background-position: 0px 0px;")){
			getOpenCommand= "No".toLowerCase();
		}else getOpenCommand= "Yes".toLowerCase();
		
		String DataMatch= "'Add Open Comment text area' checkbox has same value as mentioned in data sheet.";
		String DataMismatch= "'Add Open Comment text area' checkbox has different value from data sheet. "
				+ "Data sheet value is: " + openCommand + " and Form value is: " + getOpenCommand;
		Utils.VerifyMessages(openCommand, getOpenCommand, row, DataMatch, DataMismatch);
	}
	
	public static void VerifyButtonCaption(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);//Fetching Data from excel 
		String getCaptionOfButton= driver.findElement(By.xpath(AddInputTypeInForms_objects.getCaptionOfButtonLoc())).getAttribute("value");
		 
		String DataMatch= "Caption button has same value as mentioned in data sheet.";
		String DataMismatch= "Caption button value is different from data sheet. " 
				+ "Data sheet value is: " + CaptionOfButton + " and Form value is: " + getCaptionOfButton;
		Utils.VerifyMessages(CaptionOfButton, getCaptionOfButton, row, DataMatch, DataMismatch);
	}
		
	public static void VerifyInputOption(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		String InputOption= ExcelUtils.getCellData(row, Constant.Col_InputOptionRows);
    	String getInputOption= driver.findElement(By.xpath(AddInputTypeInForms_objects.getInputOptionLoc())).getText();
    	
    	String DataMatch= "Input options has same value as mentioned in data sheet";
		String DataMismatch= "Input options has different values from data sheet. " 
				+ "Data sheet value is: " + InputOption + " and Form value is: " + getInputOption;
		Utils.VerifyMessages(InputOption, getInputOption, row, DataMatch, DataMismatch);
	}
	
	
}
