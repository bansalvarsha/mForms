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
		if(ActRequired.equalsIgnoreCase("yes")) {
			AddInputTypeInForms_objects.mRow= row;
			WebElement element= driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired()));
			Utils.waitForElementOnvisibilityOf(element);
			if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired())).isSelected() ){
	    		driver.findElement(By.xpath(AddInputTypeInForms_objects.getRequired())).click();
	    		}                                            
		} else System.out.println("required has been skiped");
	}
		
	//Method for check the open comment check box in every input type rather than display input types
	public static void OpenCommentChkbox(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		String openCommand= ExcelUtils.getCellData(row, Constant.Col_openComment);//Fetching Data from excel 
		if(openCommand.equalsIgnoreCase("yes")) {
			if ( !driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLoc())).isSelected() ){
	    		driver.findElement(By.xpath(AddInputTypeInForms_objects.getOpenCommLoc())).click();
	    		}
		}else System.out.println("open comment has been skiped");
	}
	
	//Method for enter the caption of the button in every input type rather than display input types
	public static void ButtonCaption(int row) throws Exception {
		AddInputTypeInForms_objects.mRow= row;
		String CaptionOfButton= ExcelUtils.getCellData(row, Constant.Col_Caption1);//Fetching Data from excel 
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
		Log.error("Class DriverUtils | Method getInfoMessages | Exception occured while getting get Info Message : " + e.getMessage());
		throw new IOException();
	}
	
	}*/
}
