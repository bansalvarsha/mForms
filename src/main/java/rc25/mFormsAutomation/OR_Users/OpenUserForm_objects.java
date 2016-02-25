package rc25.mFormsAutomation.OR_Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpenUserForm_objects {

	@FindBy(how = How.XPATH, using = "//li[@id='Users']") 
	private WebElement library;
	public WebElement getUsers() {
		return library;
		}
	
	@FindBy(how = How.XPATH, using = "//li[@id='Users']/ul/li[1]/a") 
	private WebElement Users_inUsersMenu;
	public WebElement getUsers_inUsersMenu() {
		return Users_inUsersMenu;
		}
	
	@FindBy(how = How.CSS, using = ".bootstrap_btn>span>span") 
	private WebElement createNew_DDL;
	public WebElement getcreateNew_DDL() {
		return createNew_DDL;
		}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Users')]")
	private WebElement AddUsers;
	public WebElement getAddUsers() {
		return AddUsers;
		}
	
}