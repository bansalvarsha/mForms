package rc25.mFormsAutomation.OR_Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Logout_objects {
	@FindBy(how = How.CSS, using = ".logout_icon") 
	private WebElement logout_icon;
	public WebElement getlogout_icon() {
		return logout_icon;
		}
	
	@FindBy(how = How.LINK_TEXT, using = "Logout") 
	private WebElement btnlogout;
	public WebElement getbtnlogout() {
		return btnlogout;
		}
}
