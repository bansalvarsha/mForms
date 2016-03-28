package rc25.mFormsAutomation.OR_Library;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;

public class CreateLibrary_objects {
		
		@FindBy(how = How.XPATH, using = "//li[@id='Library']") 
		private WebElement library;
		public WebElement getLibrary() {
			return library;
			}
		
		@FindBy(how = How.XPATH, using = "//li[@id='Library']/ul/li[1]/a") 
		private WebElement Forms_inLibraryMenu;
		public WebElement getForms_inLibraryMenu() {
			return Forms_inLibraryMenu;
			}
		
		@FindBy(how = How.CSS, using = ".library_head") 
		private WebElement libraryName;
		public WebElement getlibraryName() {
			return libraryName;
			}
		
		@FindBy(how= How.ID, using= "FormList")
		private WebElement FormList;
		public WebElement getFormList(){
			return FormList;
		}
		
		@FindAll({
			@FindBy(how= How.CLASS_NAME, using= "note")
		})
			private List<WebElement> AllForms;
			public List<WebElement> getAllForms(){
				return AllForms;
			}
		
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Blank form')]") 
		private WebElement BlankForm;
		public WebElement getBlankForm() {
			return BlankForm;
			}
		
		@FindBy(how = How.CSS, using = ".bootstrap_btn") 
		private WebElement createNew_DDL;
		public WebElement getcreateNew_DDL() {
			return createNew_DDL;
			}
		
		@FindBy(how = How.ID, using = "FrmName") 
		private WebElement Form_Name;
		public WebElement getForm_Name() {
			return Form_Name;
			}
		
		@FindBy(how = How.XPATH, using = "//textarea[@id='FrmDesc']") 
		private WebElement Form_desc;
		public WebElement getForm_desc() {
			return Form_desc;
			}
		
		@FindBy(how = How.XPATH, using = "//select[@id='FormCollectionId']") 
		private WebElement Form_collection;
		public WebElement getForm_collection() {
			return Form_collection;
			}
		
		@FindAll({
			@FindBy(how = How.CLASS_NAME, using = "master_table_createemail")
		}) 
		private List<WebElement> label;
		public List<WebElement> getLabels() {
			return label;
			}
		
		@FindBy(how = How.XPATH, using = "//span[@id='ChooseThemeSpan']") 
		private WebElement ChooseTheme_btn;
		public WebElement getChooseTheme_btn() {
			return ChooseTheme_btn;
			}
		
		@FindBy(how = How.NAME, using = "Super admin theme") 
		private WebElement ChooseTheme;
		public WebElement getChooseTheme() {
			return ChooseTheme;
			}
		
		@FindBy(how = How.XPATH, using = "//form[@id='CreateForm1']/div[1]/div/div/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/span") 
		private WebElement activation_chkbox;
		public WebElement getactivation_chkbox() {
			return activation_chkbox;
			}
		
		@FindBy(how = How.XPATH, using = "//li[@id='Library']/ul/li[3]/a") 
		private WebElement FormsItems_inLibraryMenu;
		public WebElement getFormsItems_inLibraryMenu() {
			return FormsItems_inLibraryMenu;
			}
		
		@FindBy(how = How.ID, using = "Create") 
		private WebElement createNew_btn;
		public WebElement getcreateNew_btn() {
			return createNew_btn;
		}
		
		@FindBy(how = How.ID, using = "ItemTitle") 
		private WebElement ItemTitle_txtbox;
		public WebElement getItemTitle_txtbox() {
			return ItemTitle_txtbox;
		}
		
		@FindBy(how = How.ID, using = "ItemDescription") 
		private WebElement ItemDescription_txtarea;
		public WebElement getItemDescription_txtarea() {
			return ItemDescription_txtarea;
		}
		
		@FindBy(how = How.ID, using = "CustomItemCollectionID") 
		private WebElement CustomItemCollectionID_DDL;
		public WebElement getCustomItemCollectionID_DDL() {
			return CustomItemCollectionID_DDL;
		}
		
		@FindBy(how = How.XPATH, using = ".//*[@id='Library']/ul/li[5]/a") 
		private WebElement InputOptions_inLibraryMenu;
		public WebElement getInputOptInLibMenu() {
			return InputOptions_inLibraryMenu;
			}

		@FindBy(how = How.ID, using = "InputName") 
		private WebElement InputOptionName;
		public WebElement getInputOptionName() {
			return InputOptionName;
		}
		
		@FindBy(how = How.ID, using = "CollectionID") 
		private WebElement CollectionDDL;
		public WebElement getCollectionDDL() {
			return CollectionDDL;
		}
		
		@FindBy(how = How.ID, using = "InputOption") 
		private WebElement InputOption;
		public WebElement getInputOption() {
			return InputOption;
		}
		
		@FindBy(how = How.ID, using = "btnSave") 
		private WebElement btnSave;
		public WebElement getBtnSave() {
			return btnSave;
		}

		@FindBy(how = How.XPATH, using = ".//*[@id='Library']/ul/li[4]/a") 
		private WebElement InputTypes_inLibraryMenu;
		public WebElement getInputTypes_inLibraryMenu() {
			return InputTypes_inLibraryMenu;
			}

		@FindBy(how = How.ID, using = "CustomInputType") 
		private WebElement InputTypeName;
		public WebElement getInputTypeName() {
			return InputTypeName;
		}
		
		@FindBy(how = How.ID, using = "StartDate") 
		private WebElement StartDate;
		public WebElement getStartDate() {
			return StartDate;
		}
		
		@FindBy(how = How.ID, using = "EndDate") 
		private WebElement EndDate;
		public WebElement getEndDate() {
			return EndDate;
		}
		
		@FindBy(how = How.CSS, using = "select.ui-datepicker-month") 
		private WebElement DatePickerMonth;
		public WebElement getDatePickerMonth() {
			return DatePickerMonth;
		}
		
		@FindBy(how = How.CSS, using = "select.ui-datepicker-year") 
		private WebElement DatePickerYear;
		public WebElement getDatePickerYear() {
			return DatePickerYear;
		}
		
		public static String StartDate(int row) throws Exception {
			String getDate= ExcelUtils.getCellData(row, Constant.col_StartDate);
			return "//a[@class='ui-state-default'][text()='" + getDate + "']";
		}
		
		public static String EndDate(int row) throws Exception {
			String getEndDate= ExcelUtils.getCellData(row, Constant.col_EndDate);
			return "//a[@class='ui-state-default'][text()='" + getEndDate + "']";
		}
		
		@FindBy(how = How.CLASS_NAME, using = "version_label_new") 
		private WebElement Version_title;
		public WebElement getVersion_title() {
			return Version_title;
		}
		
		@FindBy(how = How.ID, using = "FrmVer") 
		private WebElement Version;
		public WebElement getVersion() {
			return Version;
		}
		
		@FindBy(how = How.CLASS_NAME, using = "activation_date_area") 
		private WebElement activation_date_area;
		public WebElement getActivation_date_area() {
			return activation_date_area;
		}
		
		@FindBy(how = How.ID, using = "barcode_show") 
		private WebElement Assign_barcode_link;
		public WebElement getAssign_barcode_link() {
			return Assign_barcode_link;
		}
		
		@FindBy(how = How.ID, using = "Barcode") 
		private WebElement Barcode_txtbox;
		public WebElement getBarcode_txtbox() {
			return Barcode_txtbox;
		}
		
		@FindBy(how = How.ID, using = "img_show") 
		private WebElement AddMasterImg_link;
		public WebElement getAddMasterImg_link() {
			return AddMasterImg_link;
		}
		
		@FindBy(how = How.CSS, using = "#basic-modal>a") 
		private WebElement change_btn;
		public WebElement getchange_btn() {
			return change_btn;
		}
		
		@FindBy(how = How.XPATH, using = "//*[@id='FileUpload1']//preceding-sibling::span") 
		private WebElement Browse_btn;
		public WebElement getBrowse_btn() {
			return Browse_btn;
		}
		
		@FindBy(how = How.CSS, using = ".Upload_btn[value=Done]") 
		private WebElement Upload_btn;
		public WebElement getUpload_btn() {
			return Upload_btn;
		}
		
		@FindBy(how = How.ID, using = "PageText_1") 
		private WebElement PageText_1;
		public WebElement getPageText_1() {
			return PageText_1;
		}
		
		@FindBy(how = How.CLASS_NAME, using = "create_theme_new_btn") 
		private WebElement AddTheme;
		public WebElement getAddTheme() {
			return AddTheme;
		}
		
		@FindBy(how = How.ID, using = "ThemeName") 
		private WebElement ThemeName;
		public WebElement getThemeName() {
			return ThemeName;
		}
		
		@FindBy(how = How.ID, using = "DivBGColor") 
		private WebElement DivBGColor;
		public WebElement getDivBGColor() {
			return DivBGColor;
		}
		
		@FindBy(how = How.CLASS_NAME, using = "colpick_submit") 
		private WebElement colpick_submit;
		public WebElement getcolpick_submit() {
			return colpick_submit;
		}
		
		@FindBy(how = How.ID, using = "DivTextColor") 
		private WebElement DivTextColor;
		public WebElement getDivTextColor() {
			return DivTextColor;
		}
		
		@FindBy(how = How.ID, using = "DivLinkColor") 
		private WebElement DivLinkColor;
		public WebElement getDivLinkColor() {
			return DivLinkColor;
		}
		
		@FindBy(how = How.ID, using = "DivButtonBGColor") 
		private WebElement DivButtonBGColor;
		public WebElement getDivButtonBGColor() {
			return DivButtonBGColor;
		}
		
		@FindBy(how = How.ID, using = "DivButtonTextColor") 
		private WebElement DivButtonTextColor;
		public WebElement getDivButtonTextColor() {
			return DivButtonTextColor;
		}
		
		@FindBy(how = How.CSS, using = ".colpick_rgb_b.colpick_field>input") 
		private WebElement b_color;
		public WebElement getb_color() {
			return b_color;
		}
		
		@FindBy(how = How.CSS, using = ".colpick_rgb_r.colpick_field>input") 
		private WebElement r_color;
		public WebElement getr_color() {
			return r_color;
		}
		
		@FindBy(how = How.CSS, using = ".colpick_rgb_g.colpick_field>input") 
		private WebElement g_color;
		public WebElement getg_color() {
			return g_color;
		}
		
		@FindBy(how = How.ID, using = "lookSaveBtn") 
		private WebElement lookSaveBtn;
		public WebElement getlookSaveBtn() {
			return lookSaveBtn;
		}

		@FindBy(how = How.ID, using = "lookCancelBtn") 
		private WebElement lookCancelBtn;
		public WebElement getlookCancelBtn() {
			return lookCancelBtn;
		}
		
		@FindBy(how = How.ID, using = "ChooseThemeSpan") 
		private WebElement ChooseThemeSpan;
		public WebElement getChooseThemeSpan() {
			return ChooseThemeSpan;
		}
		
		public static String View_Btn(int row) throws Exception {
			String getThemeView_Btn= ExcelUtils.getCellData(row, Constant.Col_ThemeName);
			return "//*[@name='" + getThemeView_Btn + "']//following-sibling::a";
		}
}
