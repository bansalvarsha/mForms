package rc25.mFormsAutomation.Actions_Library;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.AddResponse_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.DriverUtils;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;

public class AddResponseQuestionType_Actions extends BaseClass{
	public AddResponseQuestionType_Actions(WebDriver driver) {
		super(driver);
	}

	static AddResponse_objects responseObj;
	
	public static void pageFactory() {
		responseObj= PageFactory.initElements(driver, AddResponse_objects.class);
	}
	
	public static void AddRespOn_Date(int row) throws Exception {
		AddResponse_objects.mRow= row;
		//response on input type date
		responseObj.getAddRespOnDate().click();
		responseObj.getSelectMonth().click();
		WebElement Month= driver.findElement(By.xpath(AddResponse_objects.getMonthFromAddResponsePage(row)));
		Month.click();
		
		responseObj.getSelectYear().click();
		WebElement Year= driver.findElement(By.xpath(AddResponse_objects.getYearFromAddResponsePage(row)));
		Year.click();
		
		WebElement Date= driver.findElement(By.xpath(AddResponse_objects.getDateFromAddResponsePage(row)));
		Date.click();
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_DateTime(int row) throws Exception{
		AddResponse_objects.mRow= row;
		responseObj.getdatetimepicker().click();
		
		responseObj.getMonthOfDateTime().click();
		driver.findElement(By.xpath(AddResponse_objects.getMonthFromAddResponsePage(row))).click();
		
		responseObj.getYearOfDateTime().click();
		driver.findElement(By.xpath(AddResponse_objects.getYearFromAddResponsePage(row))).click();
		
		driver.findElement(By.xpath(AddResponse_objects.getDateFromAddResponsePage(row))).click();
		
	//	try{
			WebElement time= driver.findElement(By.xpath(AddResponse_objects.SelectTime(row)));
			
			WebElement STime= responseObj.getSTime();
			while(!STime.isDisplayed()){
			responseObj.getScrollPrevious().click();
			}
			
			while(!time.isDisplayed()){
				responseObj.getScrollNext().click();
			}
			time.click();
		//} catch(NotFoundException | ElementNotVisibleException e){
		//	System.out.println("Given time in data sheet is not present in the list.");
	//	}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Attachment(int row) throws Exception {
		AddResponse_objects.mRow= row;
		//Add response of the form
		 responseObj.getBrowse_btn().click();
		 Runtime.getRuntime().exec(Constant.ImagePath);
		 Thread.sleep(3000);
		 responseObj.getUploadedImageOn_Attachment().click();
		 responseObj.getImageZoomInOn_Attachment().click();
		 responseObj.getImageZoomOutOn_Attachment().click();
		 responseObj.getCloseImagePopup().click();
		 DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Camera(int row) throws Exception {
		AddResponse_objects.mRow= row;
		responseObj.getStartCamera_btn().click();
		if(responseObj.getAlert_popup().isDisplayed()){
			String alert= responseObj.getPopup().getText();
			Log.info(alert);
			responseObj.getPopup_ok().click();
		}else {
			System.out.println("please add the camera functionality");
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Video(int row) throws Exception {
		AddResponse_objects.mRow= row;
		responseObj.getVideoIcon().click();
		responseObj.getRecord_video().click();
		if(responseObj.getAlert_popup().isDisplayed()){
			String alert= responseObj.getPopup().getText();
			Log.info(alert);
			responseObj.getPopup_ok().click();
			responseObj.getCloseImagePopup().click();
		}else {
			//add video functionality
			System.out.println("please add the video functionality");
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Audio(int row) throws Exception {
		AddResponse_objects.mRow= row;
		responseObj.getAudioIcon().click();
		responseObj.getRecord_Audio().click();
		if(responseObj.getAlert_popup().isDisplayed()){
			String alert= responseObj.getPopup().getText();
			Log.info(alert);
			responseObj.getPopup_ok().click();
			responseObj.getCloseImagePopup().click();
		}else {
			///add audio functionality
			System.out.println("please add the audio functionality");
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Rating(int row) throws Exception {
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.getRating(row))).click();
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Dropdown(int row) throws Exception {
		AddResponse_objects.mRow= row;
		Select dropdown= new Select(driver.findElement(By.xpath(AddResponse_objects.getDropDown())));
		dropdown.selectByIndex(1);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_label(int row) throws Exception {
		AddResponse_objects.mRow= row;
		String getLabel= driver.findElement(By.xpath(AddResponse_objects.getLabel())).getText();
		System.out.println(getLabel);
		Log.info(getLabel);
	}
	
	public static void AddRespOn_MultiSelect(int row) throws Exception {
		AddResponse_objects.mRow= row;
		List<WebElement> getallCheckBoxes= driver.findElements(By.xpath(AddResponse_objects.getCheckBoxesofMultiSelect()));
		for(WebElement checkBoxes : getallCheckBoxes) {
			checkBoxes.click();
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_SingleSelect(int row) throws Exception {
		AddResponse_objects.mRow= row;
		List<WebElement> getallRadio_Btns= driver.findElements(By.xpath(AddResponse_objects.getCheckBoxesofSingleSelect()));
		getallRadio_Btns.get(1).click();
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Textarea(int row) throws Exception {
		AddResponse_objects.mRow= row;
		String TextareaData= ExcelUtils.getCellData(row, Constant.col_Text);
		WebElement getTextarea= driver.findElement(By.xpath(AddResponse_objects.getTextarea()));
		getTextarea.clear();
		getTextarea.sendKeys(TextareaData);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_TextBox(int row) throws Exception {
		AddResponse_objects.mRow= row;
		String TextBoxData= ExcelUtils.getCellData(row, Constant.col_Text);
		WebElement getTextbox= driver.findElement(By.xpath(AddResponse_objects.getTextbox()));
		getTextbox.clear();
		getTextbox.sendKeys(TextBoxData);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Matrix_multiSelect(int row) throws Exception {
		AddResponse_objects.mRow= row;
		List<WebElement> getallCheckBoxes= driver.findElements(By.xpath(AddResponse_objects.getMatrix_mutliSelect()));
		for(WebElement checkBoxes : getallCheckBoxes) {
			checkBoxes.click();
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Matrix_SingleSelect(int row) throws Exception {
		AddResponse_objects.mRow= row;
		List<WebElement> getall_rows= driver.findElements(By.xpath(AddResponse_objects.getRows()));
		int size= getall_rows.size();
		for(int RowCount=1; RowCount<=size; RowCount++){
			List<WebElement> getall_radioBtns= driver.findElements(By.xpath(AddResponse_objects.getMatrix_SingleSelect()));
			getall_radioBtns.get(1).click();
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Time(int row) throws Exception {
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.getTime())).click();
	//	try{
		WebElement time= driver.findElement(By.xpath(AddResponse_objects.SelectTime(row)));
		while(!time.isDisplayed()){
			responseObj.getScrollNext().click();
		}
		time.click();
		//} catch(NotFoundException | ElementNotVisibleException e){
		//	System.out.println("Given time in data sheet is not present in the list.");
		//}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Barcode(int row) throws Exception {
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.getBarCode_btn())).click();
		
		if(responseObj.getAlert_popup().isDisplayed()){
			String alert= responseObj.getPopup().getText();
			Log.info(alert);
			responseObj.getPopup_ok().click();
			responseObj.getCloseImagePopup().click();
		}else {
			///add barcode functionality
			System.out.println("please add the barcode functionality");
		}
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_GeoStamp(int row) throws Exception{
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.getGeoStamp())).click();
		String location= driver.findElement(By.xpath(AddResponse_objects.GeoStamplocation())).getAttribute("value");
		System.out.println("Location coordinates are: " + location);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Signature(int row) throws Exception{
		AddResponse_objects.mRow= row;
		Actions actionBuilder=new Actions(driver);
		WebElement canvasElement= driver.findElement(By.xpath(AddResponse_objects.getSignature()));
		Action drawOnCanvas=actionBuilder.clickAndHold(canvasElement).moveByOffset(10, 50).
		moveByOffset(40,-30).
		moveByOffset(-30,80).
		moveByOffset(80,-70)
		.release(canvasElement)
		.build();
		drawOnCanvas.perform();
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_SketchPad(int row) throws Exception {
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.getSketchPad())).click();
		Runtime.getRuntime().exec(Constant.ImagePath);
		Thread.sleep(2000);
		
		Actions actionBuilder=new Actions(driver);
		WebElement pencil= driver.findElement(By.xpath(AddResponse_objects.getPencil()));
		Action drawOnCanvas=actionBuilder.clickAndHold(pencil).moveByOffset(10, 50).
				moveByOffset(40,-30).
				moveByOffset(-30,80).
				moveByOffset(80,-70)
				.release(pencil)
				.build();
		drawOnCanvas.perform();
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_ImageDisplay(int row) throws Exception{
		AddResponse_objects.mRow= row;
		String ImageSrc =driver.findElement(By.xpath(AddResponse_objects.ImageDisplay_img())).getAttribute("src");
		System.out.println(ImageSrc);
		
		Select ddl= new Select(driver.findElement(By.xpath(AddResponse_objects.getDropDown())));
		ddl.selectByIndex(2);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_VideoDisplay(int row) throws Exception {
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.VideoDisplay_Video())).click();
		Select ddl= new Select(driver.findElement(By.xpath(AddResponse_objects.getDropDown())));
		ddl.selectByIndex(1);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_HyperLinkDisplay(int row) throws Exception{
		AddResponse_objects.mRow= row;
		String hyperlink= driver.findElement(By.xpath(AddResponse_objects.HyperlinkDisplay_Hyperlink()))
				.getAttribute("href");	
		System.out.println(hyperlink);
		Select ddl= new Select(driver.findElement(By.xpath(AddResponse_objects.getDropDown())));
		ddl.selectByIndex(1);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_AudioDisplay_audio(int row) throws Exception{
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.AudioDisplay_Audio())).click();
		Select ddl= new Select(driver.findElement(By.xpath(AddResponse_objects.getDropDown())));
		ddl.selectByIndex(1);
		DriverUtils.Remarks(row);
	}
	
	public static void AddRespOn_Map(int row) throws Exception {
		AddResponse_objects.mRow= row;
		driver.findElement(By.xpath(AddResponse_objects.ImageDisplay_img())).click();
		DriverUtils.Remarks(row);
	}
}
