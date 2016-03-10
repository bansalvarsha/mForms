package rc25.mFormsAutomation.OR_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddInputTypeInForms_objects {

	public static int mRow;
		//These are dynamic x paths which cannot be called by find by annotation.
		
		public static String getInputOptionForTextBox(){
			return  "//div[@id='divSort_" + mRow + "']//input[@name='Option']";
		}
		
		public static String getCaptionOfButton1Loc(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_control_right']//div[@class='input_control_area']/div/div[1]/div/div/span/input";
		}
		
		
		public static String getTextbox_url(){
			return "//*[@id='divSort_" + mRow + "']//input[@class='textbox_url']";
		}

		public static String getUploadFromComputer(){
			return "//div[@id='divSort_"+ mRow +"']//a[contains(text(),'Upload From Computer')]";
		}
		
		public static String getCaptionOfButton2Loc(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_control_right']//div[@class='input_control_area input_type_merge']/div/div[1]/div/div/span/input";
			
		}
		
		public static String getInputOptionLocDisplay(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_options_edit_textarea']/textarea";
		}
		
		public static String getRequiredForDiplayControls(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_control_right']//div[@class='input_control_area input_type_merge']/div/div[1]/div/div[3]/span";
		}
		
		public static String getOpenCommLocForDiplayControls(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_control_right']//div[@class='input_control_area input_type_merge']/div/div[1]/div/div[4]/span";
		}
		
		public static String getInputOption1Loc(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_options_edit_textarea']/input";
		}
		
		public static String CaptionOfButtonLocForMap(){
			return "//div[@id='divSort_"+ mRow +"']//div[@class='input_control_area']/div/div/div/div/span/input";
		}
		
		public static String getMatrixMultiSelect_TextareaOption(){
			return "//div[@id='divSort_" + mRow + "']//textarea[@name='Option']";
		}
		
		public static String getMatrixMultiSelect_TextareaOptionColumn(){
			return "//div[@id='divSort_" + mRow + "']//textarea[@name='OptionColumn']";
		}
		
		public static String getRequired(){
			return "//div[@id='divSort_"+ mRow +"']//input[@name='isRequired']//preceding-sibling::span";
		}
		
		public static String getOpenCommLoc(){
			return "//div[@id='divSort_"+ mRow +"']//input[@name='isAdditional']//preceding-sibling::span"; 
		}
		
		public static String getCaptionOfButtonLoc(){
			return "//div[@id='divSort_"+ mRow +"']//input[@name='Caption']"; 
		}
		
		public static String getInputOptionLoc(){
			return "//div[@id='divSort_" + mRow + "']//textarea[@name='Option']"; 
		}
		
		////////////////////////////////////////////////////////////////////////////////////
		//Form edit objects
		
		public static String getEditButton2(){
		return "//div[@id='divSort_" + mRow + "']//div[@class='input_control_area input_type_merge']//input[@name='Caption']";	
		}
		
		public static String getEditButtonCaption(){
			return "//*[@id='librarybodyareaCount_"+ mRow +"']/div[2]/div/div/div/div/div[1]/div/div[4]/span/input"; 
		}
		
		public static String getEditButton2Caption() {
			return "//div[@id='divSort_"+ mRow +"']//div[5]/span/input";
		}
		
		public static String getEditMapButtonCaption() {
			return "//div[@id='divSort_" + mRow + "']//div[@class='input_control_area']/div/div/div/div/div/div/span/input";
		}
		
		@FindBy(how= How.CSS, using = "input[class=cancel_head_btn]")
		private WebElement Cancel_Btn;
		public WebElement getCancel_btn(){
			return Cancel_Btn;
		}
		
		@FindBy(how= How.CSS, using = "#RatingInputType>option[selected='selected']")
		private WebElement RatingType;
		public WebElement getRatingType(){
			return RatingType;
		}
		
		@FindBy(how= How.CSS, using = "#AttachCount>option[selected='selected']")
		private WebElement AttachCount;
		public WebElement getAttachCount(){
			return AttachCount;
		}
		
		@FindBy(how= How.CSS, using = "#VideoCount>option[selected='selected']")
		private WebElement SelectedVideoCount;
		public WebElement getSelectedVideoCount(){
			return SelectedVideoCount;
		}
		
		@FindBy(how= How.CSS, using = "#MediaSize>option[selected='selected']")
		private WebElement SelectedVideoSize;
		public WebElement getSelectedVideoSize(){
			return SelectedVideoSize;
		}
		
		@FindBy(how= How.CSS, using = "#ImageCount>option[selected='selected']")
		private WebElement SelectedImageCount;
		public WebElement getSelectedImageCount(){
			return SelectedImageCount;
		}
		
		@FindBy(how= How.CSS, using = "#MediaSize>option[selected='selected']")
		private WebElement SelectedAudioSize;
		public WebElement getSelectedAudioSize(){
			return SelectedAudioSize;
		}
		
		@FindBy(how= How.CSS, using = "#AudioCount>option[selected='selected']")
		private WebElement SelectedAudioCount;
		public WebElement getSelectedAudioCount(){
			return SelectedAudioCount;
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='8']") 
		private WebElement InputItem_Attachment;
		public WebElement getInputItem_Attachment() {
			return InputItem_Attachment;
			}
		
		@FindBy(how= How.ID, using= "AttachCount")
		private WebElement MaxNoOfFilesDDL;
		public WebElement getMaxNoOfFilesDDL() {
			return MaxNoOfFilesDDL;
		}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='19']") 
		private WebElement InputItem_Audio;
		public WebElement getInputItem_Audio() {
			return InputItem_Audio;
			}
		
		@FindBy(how = How.ID, using = "AudioCount") 
		private WebElement AudioCount;
		public WebElement getAudioCount() {
			return AudioCount;
			}
		
		//common
		@FindBy(how = How.ID, using = "AudioSize") 
		private WebElement AudioSize;
		public WebElement getAudioSize() {
			return AudioSize;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='6']") 
		private WebElement InputItem_Barcode;
		public WebElement getInputItem_Barcode() {
			return InputItem_Barcode;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='7']") 
		private WebElement InputItem_Camera;
		public WebElement getInputItem_Camera() {
			return InputItem_Camera;
			}
		
		@FindBy(how = How.ID, using = "ImageCount") 
		private WebElement ImageCount;
		public WebElement getImageCount() {
			return ImageCount;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='10']") 
		private WebElement InputItem_Date;
		public WebElement getInputItem_Date() {
			return InputItem_Date;
			}
		
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='11']") 
		private WebElement InputItem_DateTime;
		public WebElement getInputItem_DateTime() {
			return InputItem_DateTime;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='4']") 
		private WebElement InputItem_DropDown;
		public WebElement getInputItem_DropDown() {
			return InputItem_DropDown;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='13']") 
		private WebElement InputItem_GeoStamp;
		public WebElement getInputItem_GeoStamp() {
			return InputItem_GeoStamp;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='14']") 
		private WebElement InputItem_Label;
		public WebElement getInputItem_Label() {
			return InputItem_Label;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='17']") 
		private WebElement InputItem_Signature;
		public WebElement getInputItem_Signature() {
			return InputItem_Signature;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='18']") 
		private WebElement InputItem_SketchPad;
		public WebElement getInputItem_SketchPad() {
			return InputItem_SketchPad;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='34']") 
		private WebElement InputItem_Audio_DisplayOnly;
		public WebElement getInputItem_Audio_DisplayOnly() {
			return InputItem_Audio_DisplayOnly;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='37']") 
		private WebElement InputItem_Image_DisplayOnly;
		public WebElement getInputItem_Image_DisplayOnly() {
			return InputItem_Image_DisplayOnly;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='35']") 
		private WebElement InputItem_Video_DisplayOnly;
		public WebElement getInputItem_Video_DisplayOnly() {
			return InputItem_Video_DisplayOnly;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='36']") 
		private WebElement InputItem_Hyperlink_DisplayOnly;
		public WebElement getInputItem_Hyperlink_DisplayOnly() {
			return InputItem_Hyperlink_DisplayOnly;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='9']") 
		private WebElement InputItem_Map;
		public WebElement getInputItem_Map() {
			return InputItem_Map;
			}
		
		@FindBy(how = How.ID, using = "MMinCount") 
		private WebElement MinCount;
		public WebElement getMinCount() {
			return MinCount;
			}
		
		@FindBy(how = How.ID, using = "MMaxCount") 
		private WebElement MaxCount;
		public WebElement getMaxCount() {
			return MaxCount;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='33']") 
		private WebElement InputItem_MatrixMultiSelect; 
		public WebElement getInputItem_MatrixMultiSelect() {
			return InputItem_MatrixMultiSelect;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='32']") 
		private WebElement InputItem_MatrixSingleSelect;
		public WebElement getInputItem_MatrixSingleSelect() {
			return InputItem_MatrixSingleSelect;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='16']") 
		private WebElement InputItem_MultiSelect;
		public WebElement getInputItem_MultiSelect() {
			return InputItem_MultiSelect;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='21']") 
		private WebElement InputItem_Rating;
		public WebElement getInputItem_Rating() {
			return InputItem_Rating;
			}
		
		@FindBy(how = How.ID, using = "RatingInputType") 
		private WebElement RatingInputType;
		public WebElement getRatingInputType() {
			return RatingInputType;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='22']") 
		private WebElement InputItem_SingleSelect;
		public WebElement getInputItem_SingleSelect() {
			return InputItem_SingleSelect;
			}
		
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='1']") 
		private WebElement InputItem_TextBox;
		public WebElement getInputItem_TextBox() {
			return InputItem_TextBox;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='2']") 
		private WebElement InputItem_TextArea;
		public WebElement getInputItem_TextArea() {
			return InputItem_TextArea;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='20']") 
		private WebElement InputItem_Video;
		public WebElement getInputItem_Video() {
			return InputItem_Video;
			}
		
		@FindBy(how = How.NAME, using = "VideoCount") 
		private WebElement VideoCount;
		public WebElement getVideoCount() {
			return VideoCount;
			}
		
		@FindBy(how = How.NAME, using = "VideoSize") 
		private WebElement VideoSize;
		public WebElement getVideoSize() {
			return VideoSize;
			}
		
		@FindBy(how = How.XPATH, using = "//div[@class='jquery-gdakram-tooltip']//tr[@id='12']") 
		private WebElement InputItem_Time;
		public WebElement getInputItem_Time() {
			return InputItem_Time;
			}
}
