package rc25.mFormsAutomation.Actions_Users;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.Base.ExcelPaths;
import rc25.mFormsAutomation.OR_Users.AddUser_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class AddUser_Actions extends BaseClass {

	public AddUser_Actions(WebDriver driver) {
		super(driver);
	}

	static AddUser_objects CreateLibObj;
	static String getUserType;
	static String getUserGroup;
	static String Email;
	static String FirstName;
	static String lastName;
	
	public static void FillUserForm(int row) throws Exception {
		CreateLibObj= PageFactory.initElements(driver, AddUser_objects.class);
		Log.info("Called all the elements using page factory ");
		
		Email= ExcelUtils.getCellData(row, Constant.col_email);
		CreateLibObj.getEmail().sendKeys(Email);
		
		String Password= ExcelUtils.getCellData(row, Constant.Col_Password);
		CreateLibObj.getPassword().sendKeys(Password);
		
		CreateLibObj.getUserTypeArrow().click();
		
		//Find the user type in the user type list
		String Usertype= ExcelUtils.getCellData(row, Constant.Col_userType);
		for(WebElement UserType: CreateLibObj.getUserTypelist()){
			getUserType= UserType.getAttribute("name");
			if(getUserType.equals(Usertype)) break;
		}
		
		if(getUserType.equals(Usertype))
			driver.findElement(By.xpath(AddUser_objects.UserType(row))).click();
		else {
			CreateLibObj.getAddUserType().click();
			CreateLibObj.getEditUser().clear();
			CreateLibObj.getEditUser().sendKeys(Usertype);
			CreateLibObj.getEditUserTypeOk_btn().click();
			Utils.getConfirmationMessage();
		}
		
		FirstName= ExcelUtils.getCellData(row, Constant.col_Firstname);
		CreateLibObj.getFirstName().sendKeys(FirstName);
		
		lastName= ExcelUtils.getCellData(row, Constant.Col_LastName);
		CreateLibObj.getLastName().sendKeys(lastName);
		
		CreateLibObj.getUserGroupArrow().click();
		
		//find the user group in the user group list
		String UserGroup= ExcelUtils.getCellData(row, Constant.Col_UserGroup);
		for(WebElement Usergroup: CreateLibObj.getUserGrouplist()){
			getUserGroup= Usergroup.getAttribute("name");
			if(getUserGroup.equals(UserGroup)) break;
		}
		
		if(getUserGroup.equals(UserGroup))
			driver.findElement(By.xpath(AddUser_objects.getUsergroup(row))).click();
		else{
			CreateLibObj.getAddUserGroup().click();
			CreateLibObj.getEditUserGroup().clear();
			CreateLibObj.getEditUserGroup().sendKeys(UserGroup);
			CreateLibObj.getEditUserGroupOk_Btn().click();
			Utils.getConfirmationMessage();
		}
		AddUser_Actions.performSave_Cancel_AddAnother_Action(row);
	}
	
	
	public static void performSave_Cancel_AddAnother_Action(int row) throws Exception{
		String performAction= ExcelUtils.getCellData(row, Constant.Col_PerformAction);
		if(performAction.equalsIgnoreCase("cancel")){
		CreateLibObj.getCancel_btn().click();
		
		} else if(performAction.equalsIgnoreCase("save")){
			CreateLibObj.getSave_btn().click();
			Utils.getConfirmationMessage();
			CreateLibObj.getsearch_txtbox().sendKeys(Email);
			CreateLibObj.getsearch_txtbox().sendKeys(Keys.ENTER);
			String verifyAddedUser= CreateLibObj.getSearch_result().getText();
			if(verifyAddedUser.equals(Email)){
				System.out.println("New user " + FirstName + " " + lastName + " with Email- " + Email + " has been added.");
			}
		} else if(performAction.equalsIgnoreCase("save and add another")){
			
			CreateLibObj.getSaveAndAddAnother_btn().click();
			Utils.getConfirmationMessage();
			
			ExcelUtils.setExcelFile(ExcelPaths.AddUsersDataSheetPath, Constant.AddAnotherUserSheetName);
			row++;
			FillUserForm(row);
		}
	}
}
