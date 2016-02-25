package rc25.mFormsAutomation.OR_Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserRegistration_objects {
	@FindBy(how = How.ID, using = "Customers") 
	private WebElement CustomersTab;
	public WebElement getCustomersTab() {
		return CustomersTab;
		}
	
	@FindBy(how = How.ID, using = "createClient") 
	private WebElement CreateClient_btn;
	public WebElement getCreateClient_btn() {
		return CreateClient_btn;
		}
	
	@FindBy(how = How.ID, using = "Email") 
	private WebElement Email;
	public WebElement getEmail() {
		return Email;
		}
	
	@FindBy(how = How.ID, using = "Password") 
	private WebElement password;
	public WebElement getpassword() {
		return password;
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
	
	@FindBy(how = How.ID, using = "CompanyName") 
	private WebElement CompanyName;
	public WebElement getCompanyName() {
		return CompanyName;
		}
	
	@FindBy(how = How.ID, using = "IndustyId") 
	private WebElement IndustyId;
	public WebElement getIndustyId() {
		return IndustyId;
		}
	
	@FindBy(how = How.CSS, using = ".btn_admin_login[value='Next']") 
	private WebElement Next_btn;
	public WebElement getNext_btn() {
		return Next_btn;
		}
	
	@FindBy(how = How.CSS, using = ".btn_admin_login[value='Register!']") 
	private WebElement register_btn;
	public WebElement getregister_btn() {
		return register_btn;
		}
	
	
	@FindBy(how = How.CSS, using = ".center_auto") 
	private WebElement ConfirmationMessage;
	public WebElement getConfirmationMessage() {
		return ConfirmationMessage;
	}
	
	
	
}
