/*---------------------------------------------------------------------------------------------------------------------
<copyright file="Login_objects.java" company="Astegic Infosoultions" Product= "MForms">
Copyright 2015
</copyright>
-----------------------------------------------------------------------------------------------------------------------*/
package rc25.mFormsAutomation.OR_Home;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_objects {
	
	//Page factory objects
	@FindBy(how = How.ID, using = "username") 
	private WebElement Username;
	public WebElement getUsername() {
		return Username;
		}
	
	@FindBy(how = How.ID, using = "password") 
	private WebElement password;
	public WebElement getpassword() {
		return password;
		}
	
	@FindBy(how = How.CLASS_NAME, using = "btn_manage") 
	private WebElement btnlogin;
	public WebElement getbtnlogin() {
		return btnlogin;
		}
	
	@FindBy(how = How.CLASS_NAME, using = "remember_area") 
	private WebElement rememberMe;
	public WebElement getrememberMe() {
		return rememberMe;
		}
	
	@FindBy(how = How.CLASS_NAME, using = "top_nav") 
	private WebElement top_nav;
	public WebElement gettop_nav() {
		return top_nav;
		}
	
	@FindAll({
		@FindBy(how = How.CLASS_NAME, using = "field-validation-error")
		})
	private List<WebElement> allValidation_errorsInList;
	public List<WebElement> getallValidation_errorsInList() {
		return allValidation_errorsInList;
		}
	
	@FindBy(how = How.CLASS_NAME, using = "validation-summary-errors") 
	private WebElement Validation_summary_error;
	public WebElement getValidation_summary_error() {
		return Validation_summary_error;
		}
}
