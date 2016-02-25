package rc25.mFormsAutomation.OR_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;

public class AddResponse_objects {
	
	public static int mRow;
	
	@FindBy(how = How.CSS, using = "span.publish_head_btn") 
	private WebElement Publish_btn;
	public WebElement getPublish_btn() {
		return Publish_btn;
	}
	
	@FindBy(how = How.XPATH, using = "//tr[@class='note hightlightTr']//div[@class='toggle_header']") 
	private WebElement ToggleLst;
	public WebElement getToggleLst() {
		return ToggleLst;
	}
		
	@FindBy(how = How.XPATH, using = "div[@class='grid_toggle_label']//*[contains(text(), 'Add response')]") 
	private WebElement Add_response;
	public WebElement getAdd_response() {
		return Add_response;
	}
	
	//Add response attachment objects
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Browse')]") 
	private WebElement Browse_btn;
	public WebElement getBrowse_btn() {
		return Browse_btn;
	}
	
	@FindBy(how = How.CSS, using = "li.working>img") 
	private WebElement UploadedImageOnAttachment;
	public WebElement getUploadedImageOn_Attachment() {
		return UploadedImageOnAttachment;
	}
	
	@FindBy(how = How.CSS, using = "div.gallery_zoom_out") 
	private WebElement ImageZoomOutOn_Attachment;
	public WebElement getImageZoomOutOn_Attachment() {
		return ImageZoomOutOn_Attachment;
	}
	
	@FindBy(how = How.CSS, using = "div.gallery_zoom_in") 
	private WebElement ImageZoomInOn_Attachment;
	public WebElement getImageZoomInOn_Attachment() {
		return ImageZoomInOn_Attachment;
	}
	
	@FindBy(how = How.XPATH, using = "//label[@class='title']//following-sibling::span[@class='left_pop_close_icon']") 
	private WebElement CloseImagePopup;
	public WebElement getCloseImagePopup() {
		return CloseImagePopup;
	}
	
	
	
	@FindBy(how = How.ID, using = "popup_message") 
	private WebElement Popup;
	public WebElement getPopup() {
		return Popup;
	}
	
	@FindBy(how = How.ID, using = "popup_ok") 
	private WebElement Popup_ok;
	public WebElement getPopup_ok() {
		return Popup_ok;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='grid_toggle_label'][contains(text(),'Add Response')]") 
	private WebElement GridToggleAddResponse_lbl;
	public WebElement getGridToggleAddResponse_lbl() {
		return GridToggleAddResponse_lbl;
	}
	
	//date objects
	@FindBy(how = How.CSS, using = "input.normal.date.datepicker") 
	private WebElement AddRespOnDate;
	public WebElement getAddRespOnDate() {
		return AddRespOnDate;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@style[contains(.,'display: block;')]]//div[@class='xdsoft_label xdsoft_month']/span") 
	private WebElement SelectMonth;
	public WebElement getSelectMonth() {
		return SelectMonth;
	}
	
	public static String getMonthFromAddResponsePage(int row) throws Exception {
		String getMonth= ExcelUtils.getCellData(row, Constant.col_Month);
		return "//div[@style='display: block;']//div[contains(text(),'" + getMonth + "')]";
	}
	
	@FindBy(how = How.XPATH, using = "//div[@style[contains(.,'display: block;')]]//div[@class='xdsoft_label xdsoft_year']/span") 
	private WebElement SelectYear;
	public WebElement getSelectYear() {
		return SelectYear;
	}
		
	public static String getYearFromAddResponsePage(int row) throws Exception {
		String getYear= ExcelUtils.getCellData(row, Constant.col_Year);
		return "//div[@style='display: block;']//div[contains(text(), '" + getYear + "')]";
	}
	
	public static String getDateFromAddResponsePage(int row) throws Exception {
		String getDate= ExcelUtils.getCellData(row, Constant.col_Date);
		return "//div[@style[contains(.,'display: block;')]]//td[@data-date='" + getDate + "']";
	}
	
	public static String getRemark_txtbox_FromAddResponse() throws Exception {
		return "//div[@questionnumber='" + mRow + "']//descendant::div/textarea[@placeholder='Enter text here']";
	}
	
	//save button objects
	@FindBy(how = How.CSS, using = ".create_new_btn.save_form_btn") 
	private WebElement SaveMenuOnAddResponsePage;
	public WebElement getSaveMenuOnAddResponsePage() {
		return SaveMenuOnAddResponsePage;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@id='Create'][(text()='Save')]") 
	private WebElement Save_btn_OnAddResponsepage;
	public WebElement getSave_btn_OnAddResponsepage() {
		return Save_btn_OnAddResponsepage;
	}
	
	//date time objects
	@FindBy(how = How.CSS, using = ".normal.date.datetimepicker") 
	private WebElement datetimepicker;
	public WebElement getdatetimepicker() {
		return datetimepicker;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@style[contains(.,'display: block')]]//following-sibling::div[@class='xdsoft_label xdsoft_month']") 
	private WebElement MonthOfDateTime;
	public WebElement getMonthOfDateTime() {
		return MonthOfDateTime;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@style[contains(.,'display: block')]]//following-sibling::div[@class='xdsoft_label xdsoft_year']") 
	private WebElement YearOfDateTime;
	public WebElement getYearOfDateTime() {
		return YearOfDateTime;
	}
	
	//camera objects
	@FindBy(how = How.CSS, using = "input[value='Start Camera']") 
	private WebElement StartCamera_btn;
	public WebElement getStartCamera_btn() {
		return StartCamera_btn;
	}
	
	@FindBy(how = How.ID, using = "popup_container") 
	private WebElement Alert_popup;
	public WebElement getAlert_popup() {
		return Alert_popup;
	}
	
	//video objects
	@FindBy(how = How.CSS, using = ".start_video.bottommargin") 
	private WebElement VideoIcon;
	public WebElement getVideoIcon() {
		return VideoIcon;
	}
	
	@FindBy(how = How.ID, using = "record_video") 
	private WebElement record_video;
	public WebElement getRecord_video() {
		return record_video;
	}
	
	//Audio objects
	@FindBy(how = How.CSS, using = ".start_audio.bottommargin") 
	private WebElement AudioIcon;
	public WebElement getAudioIcon() {
		return AudioIcon;
	}
			
	@FindBy(how = How.ID, using = "record_audio") 
	private WebElement record_audio;
	public WebElement getRecord_Audio() {
		return record_audio;
	}
	
	//rating object
	public static String getRating(int row) throws Exception {
		String getRating= ExcelUtils.getCellData(row, Constant.col_Rating);
		return "//div[@class='form_rating_area']//a[@counter='" + getRating + "']";
	}
	
	//drop down objects
	public static String getDropDown() {
		return "//div[@questionnumber='" + mRow + "']//select";
	}
		
	//label objects
	public static String getLabel() {
		return "//div[@questionnumber='" + mRow + "']//div[@class='form_ans_area']/label";
	}
	
	//multi select object
	public static String getCheckBoxesofMultiSelect() {
		return "//div[@questionnumber='" + mRow + "']//span[@class='checkbox']";
	}
	
	//single select object
	public static String getCheckBoxesofSingleSelect() {
		return "//div[@questionnumber='" + mRow + "']//span[@class='radio']";
	}
	
	//text area object
	public static String getTextarea() {
		return "//div[@questionnumber='" + mRow + "']//div[@class='form_ans_area']//textarea";
	}
	
	//text box object
	public static String getTextbox() {
		return "//div[@questionnumber='" + mRow + "']//div[@class='form_ans_area']//input[@type='text']";
	}
	
	//matrix multi select
	public static String getMatrix_mutliSelect() {
		return "//div[@questionnumber='" + mRow + "']//div[@class='matrix_checkbox_area']/span[@class='checkbox']";
	}	
	
	//matrix multi select
	public static String getRows() {
		return "//div[@questionnumber='" + mRow + "']//div[@class='Row']";
	}
	
		
	public static String getMatrix_SingleSelect() {
		return "//div[@questionnumber='" + mRow + "']//div[@class='Row']//span[@class='radio']";
	}
	
	public static String getTime(){
		return "//div[@questionnumber='" + mRow + "']//div[@class='form_ans_area']/input[@placeholder='Select Time']";
	}
	
	public static String SelectTime(int row){
		String time = null;
		try {
			time = ExcelUtils.getCellData(row, Constant.col_Time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "//div[@style[contains(.,'display: block;')]]//div[@class='xdsoft_time_variant']//div[(text()='" + time + "')]";
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@style[contains(.,'display: block;')]]//div[@class='xdsoft_time_variant']//div[(text()='00:00')]") 
	private WebElement STime;
	public WebElement getSTime() {
		return STime;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@style[contains(.,'display: block')]]//div[@class='xdsoft_timepicker active']//button[@class='xdsoft_next']") 
	private WebElement ScrollNext;
	public WebElement getScrollNext() {
		return ScrollNext;
	}
	
	@FindBy(how = How.XPATH, using 
			= "//div[@style[contains(.,'display: block;')]]//div[@class='xdsoft_timepicker active']//button[@class='xdsoft_prev']") 
	private WebElement ScrollPrevious;
	public WebElement getScrollPrevious() {
		return ScrollPrevious;
	}
	
	public static String getBarCode_btn(){
		return "//div[@questionnumber='" + mRow + "']//input[@value='Scan Barcode']";
	}
	
	public static String getGeoStamp(){
		return "//div[@questionnumber='" + mRow + "']//input[@value='Get Location']";
	}
	
	public static String GeoStamplocation(){
		return "//div[@questionnumber='" + mRow + "']//div[@class='location_checkbox_area']/input";
	}
	
	public static String getSignature(){
		return "//div[@questionnumber='" + mRow + "']//canvas";
	}
	
	public static String getSketchPad(){
		return "//div[@questionnumber='" + mRow + "']//div[@class='sketchPad focus']";
	}
	
	public static String getPencil(){
		return "//div[@questionnumber='" + mRow + "']//a[@class='icon_bg Pencil']";
	}
	
	public static String ImageDisplay_img(){
		return "//div[@questionnumber='" + mRow + "']//div[@class='form_ans_area']//img";
	}
	
	public static String VideoDisplay_Video(){
		return "//div[@questionnumber='" + mRow + "']//video[@class='Video']";
	}
	
	public static String HyperlinkDisplay_Hyperlink(){
		return "//div[@questionnumber='" + mRow + "']//div[@class='form_ans_area']//a";
	}
	
	public static String AudioDisplay_Audio(){
		return "//div[@questionnumber='" + mRow + "']//audio[@class='audio']";
	}
}
