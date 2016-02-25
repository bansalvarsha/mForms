package rc25.mFormsAutomation.OR_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddInputTypeInInputTypes_objects {
	public static int mRow;
	
	public static String getRequired() {
		return ".//*[@id='divInputType_" + mRow + "']//input[@name='isRequired']//preceding-sibling::span";
		}
	
	public static String getOpenCommLoc() {
		return ".//*[@id='divInputType_" + mRow + "']//input[@name='isAdditional']//preceding-sibling::span";
		}
		
	public static String getCaptionOfButtonLoc(){
		return ".//*[@id='divInputType_" + mRow + "']//input[@name='Caption']";
		}
	
	//common
	@FindBy(how= How.ID, using= "AttachCount")
	private WebElement MaxNoOfFilesDDL;
	public WebElement getMaxNoOfFilesDDL() {
		return MaxNoOfFilesDDL;
		}
	
	public static String getInputOptionLoc(){
		return ".//*[@id='divInputType_" + mRow + "']//*[@name='Option']"; 
		}

	public static String getMatrix_InputOptionColumn(){
		return ".//*[@id='divInputType_" + mRow + "']//*[@name='OptionColumn']";
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Attachment')]]")
	private WebElement InputItem_Attachment;
	public WebElement getInputItem_Attachment() {
		return InputItem_Attachment;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Audio')]]")
	private WebElement InputItem_Audio;
	public WebElement getInputItem_Audio() {
		return InputItem_Audio;
		}

	//common
	@FindBy(how = How.ID, using = "AudioCount") 
	private WebElement AudioCount;
	public WebElement getAudioCount() {
		return AudioCount;
		}
	
	@FindBy(how = How.CLASS_NAME, using = "AudioSize") 
	private WebElement AudioSize;
	public WebElement getAudioSize() {
		return AudioSize;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[contains(text(),'Camera')]")//"//*[text()[contains(.,'Camera')]]")
	private WebElement InputItem_Camera;
	public WebElement getInputItem_Camera() {
		return InputItem_Camera;
		}
	
	//common
	@FindBy(how = How.ID, using = "ImageCount") 
	private WebElement ImageCount;
	public WebElement getImageCount() {
		return ImageCount;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Video')]]")
	private WebElement InputItem_Video;
	public WebElement getInputItem_Video() {
		return InputItem_Video;
		}
	
	//common
	@FindBy(how = How.NAME, using = "VideoCount") 
	private WebElement VideoCount;
	public WebElement getVideoCount() {
		return VideoCount;
		}
	
	//common
	@FindBy(how = How.CLASS_NAME, using = "VideoSize") 
	private WebElement VideoSize;
	public WebElement getVideoSize() {
		return VideoSize;
		}

	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Rating')]]")
	private WebElement InputItem_Rating;
	public WebElement getInputItem_Rating() {
		return InputItem_Rating;
		}
	
	//common
	@FindBy(how = How.ID, using = "RatingInputType") 
	private WebElement RatingInputType;
	public WebElement getRatingInputType() {
		return RatingInputType;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Dropdown')]]")
	private WebElement InputItem_DropDown;
	public WebElement getInputItem_DropDown() {
		return InputItem_DropDown;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Label')]]")
	private WebElement InputItem_Label;
	public WebElement getInputItem_Label() {
		return InputItem_Label;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[starts-with(.,'Multi-Select')]]")
	private WebElement InputItem_MultiSelect;
	public WebElement getInputItem_MultiSelect() {
		return InputItem_MultiSelect;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[starts-with(.,'Single-Select')]]")
	private WebElement InputItem_SingleSelect;
	public WebElement getInputItem_SingleSelect() {
		return InputItem_SingleSelect;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Textbox')]]")
	private WebElement InputItem_TextBox;
	public WebElement getInputItem_TextBox() {
		return InputItem_TextBox;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Textarea')]]")
	private WebElement InputItem_TextArea;
	public WebElement getInputItem_TextArea() {
		return InputItem_TextArea;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Barcode')]]")
	private WebElement InputItem_Barcode;
	public WebElement getInputItem_Barcode() {
		return InputItem_Barcode;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Date')]]")
	private WebElement InputItem_Date;
	public WebElement getInputItem_Date() {
		return InputItem_Date;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Date-Time')]]")
	private WebElement InputItem_DateTime;
	public WebElement getInputItem_DateTime() {
		return InputItem_DateTime;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Geostamp')]]")
	private WebElement InputItem_GeoStamp;
	public WebElement getInputItem_GeoStamp() {
		return InputItem_GeoStamp;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Signature')]]")
	private WebElement InputItem_Signature;
	public WebElement getInputItem_Signature() {
		return InputItem_Signature;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Sketch Pad')]]")
	private WebElement InputItem_SketchPad;
	public WebElement getInputItem_SketchPad() {
		return InputItem_SketchPad;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Matrix Multi-Select')]]")
	private WebElement InputItem_MatrixMultiSelect; 
	public WebElement getInputItem_MatrixMultiSelect() {
		return InputItem_MatrixMultiSelect;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Matrix Single-Select')]]")
	private WebElement InputItem_MatrixSingleSelect;
	public WebElement getInputItem_MatrixSingleSelect() {
		return InputItem_MatrixSingleSelect;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add_popup_menu_area']//*[text()[contains(.,'Time')]]")
	private WebElement InputItem_Time;
	public WebElement getInputItem_Time() {
		return InputItem_Time;
		}
}
