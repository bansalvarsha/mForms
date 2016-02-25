package rc25.mFormsAutomation.OR_Users;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;

public class AddUser_objects {

	@FindBy(how = How.ID, using = "Email") 
	private WebElement Email;
	public WebElement getEmail() {
		return Email;
		}
	
	@FindBy(how = How.ID, using = "Password") 
	private WebElement Password;
	public WebElement getPassword() {
		return Password;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userTypeSelect']//span[@class='selectArrow']") 
	private WebElement UserTypeArrow;
	public WebElement getUserTypeArrow() {
		return UserTypeArrow;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userTypeSelect']//span[@class='selectOption select_option_link']") 
	private WebElement AddUserType;
	public WebElement getAddUserType() {
		return AddUserType;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userTypeSelect']//span[@name]") 
	private List<WebElement> UserTypelist;
	public List<WebElement> getUserTypelist() {
		return UserTypelist;
		}
	

	public static String UserType(int row) throws Exception {
		String Usertype= ExcelUtils.getCellData(row, Constant.Col_userType);
		return "//div[@class='adduser_input_label_area userTypeSelect']//span[@name='" + Usertype + "']";	
	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@style[contains(.,'display: block')]]//input[@class='user_editablediv_input']") 
	private WebElement EditUser;
	public WebElement getEditUser() {
		return EditUser;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userTypeSelect']//span[@class='barcode_ok_icon addgroup_input']") 
	private WebElement EditUserTypeOk_btn;
	public WebElement getEditUserTypeOk_btn() {
		return EditUserTypeOk_btn;
		}
	
	@FindBy(how = How.ID, using = "FirstName") 
	private WebElement FirstName;
	public WebElement getFirstName() {
		return FirstName;
		}
	
	@FindBy(how = How.ID, using = "LastName") 
	private WebElement LastName;
	public WebElement getLastName() {
		return LastName;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userGroupSelect']//span[@class='selectArrow']") 
	private WebElement UserGroupArrow;
	public WebElement getUserGroupArrow() {
		return UserGroupArrow;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userGroupSelect']//span[@name]") 
	private List<WebElement> UserGrouplist;
	public List<WebElement> getUserGrouplist() {
		return UserGrouplist;
		}
	

	public static String getUsergroup(int row) throws Exception {
		String UserGroup= ExcelUtils.getCellData(row, Constant.Col_UserGroup);
		return "//div[@class='adduser_input_label_area userGroupSelect']//span[@name='" + UserGroup + "']";	
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userGroupSelect']//span[@class='selectOption select_option_link']") 
	private WebElement AddUserGroup;
	public WebElement getAddUserGroup() {
		return AddUserGroup;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userGroupSelect']//input[@class='user_editablediv_input']") 
	private WebElement EditUserGroup;
	public WebElement getEditUserGroup() {
		return EditUserGroup;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_input_label_area userGroupSelect']//span[@class='barcode_ok_icon addgroup_input']") 
	private WebElement EditUserGroupOk_Btn;
	public WebElement getEditUserGroupOk_Btn() {
		return EditUserGroupOk_Btn;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_footer_area']//input[@class='cancel_user_btn']") 
	private WebElement Cancel_btn;
	public WebElement getCancel_btn() {
		return Cancel_btn;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_footer_area']//input[@class='save_user_btn']") 
	private WebElement Save_btn;
	public WebElement getSave_btn() {
		return Save_btn;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='adduser_footer_area']//input[@class='save_another_user_btn']") 
	private WebElement SaveAndAddAnother_btn;
	public WebElement getSaveAndAddAnother_btn() {
		return SaveAndAddAnother_btn;
		}

	@FindBy(how = How.ID, using = "search") 
	private WebElement search_txtbox;
	public WebElement getsearch_txtbox() {
		return search_txtbox;
		}

	@FindBy(how = How.CSS, using = ".width30") 
	private WebElement Search_result;
	public WebElement getSearch_result() {
		return Search_result;
		}

	
}
