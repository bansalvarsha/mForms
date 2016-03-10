/*---------------------------------------------------------------------------------------------------------------------
<copyright file="Utils.java" company="Astegic Infosoultions" Product= "MForms">
Copyright 2015
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/
package rc25.mFormsAutomation.utility;

import java.awt.AWTException;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rc25.mFormsAutomation.OR_Library.AddItems_objects;
import rc25.mFormsAutomation.OR_Library.SaveAndverifyTheForm_objects;

public class Utils {
	
	public static WebDriver driver= null;
	public static String path;
	
	public static WebDriver OpenBrowser() throws Exception{
		String sBrowserName;
		String ChromePath= Constant.ChromePath;
		try{
		//sBrowserName = ExcelUtils.getCellData(Row, Constant.Col_Browser);
		sBrowserName= Constant.browsername;
		if(sBrowserName.equals("firefox")){
			driver = new FirefoxDriver();
		}else if (sBrowserName.equals("chrome")){
			File ChromeFile = new File(ChromePath);
        	System.setProperty("webdriver.chrome.driver", ChromeFile.getAbsolutePath());
			driver = new ChromeDriver();
		}else if(sBrowserName.equals("ie")){
			driver = new InternetExplorerDriver();
		}
		//Log.info("New driver instantiated");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Log.info("Implicit wait applied on the driver for 10 seconds");
		
		driver.get(Constant.URL);
		Log.info("Web application launched successfully");
		System.out.println("Web application launched successfully");
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
		
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
		}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
		}
	}
		
	//This is to add the explicit wait for click able elements which will wait for 15 second to locate the element
	public static void waitForElementOnvisibilityOf(WebElement element)  throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 130);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*public void waitToHandleException(){
	WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 15)
	.pollingEvery(2,TimeUnit.MILLISECONDS)
	.ignoring(NoSuchElementException.class)
	.ignoring(StaleElementReferenceException.class);
	}*/
	
	//Method to capture the screen shot
	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			path= Constant.Path_ScreenShot + sTestCaseName +".jpg";
			System.out.println(path);
			FileUtils.copyFile(scrFile, new File(path));
		} catch (Exception e){
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
	}
	
	public static void getConfirmationMessage() throws Exception {
    	SaveAndverifyTheForm_objects SaveAndverifyObj= PageFactory.initElements(driver, SaveAndverifyTheForm_objects.class);
    	WebElement ConfirmtionMessage= SaveAndverifyObj.getConfirmationMessage();
		 Utils.waitForElementOnvisibilityOf(ConfirmtionMessage);
		 if(ConfirmtionMessage.isDisplayed()){
			 String getConfirmtionMessage=  ConfirmtionMessage.getText();
			 System.out.println(getConfirmtionMessage);
		 }
	}
	
	
	//Scroll the page
	public static void Scroll_Down_Page() throws AWTException, InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;  
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@id='addItemInputBtn_1']")));
	}
	
	public static void Scroll_Down_To_InputType(int row){
		AddItems_objects.mRow= row;
		JavascriptExecutor je = (JavascriptExecutor) driver;  
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(AddItems_objects.getAddItemName())));
	
	}
}
