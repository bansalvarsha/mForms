package rc25.mFormsAutomation.OR_Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Forgot_Password_objects {
	
	@FindBy(how = How.LINK_TEXT, using = "Forgot password?")
	private WebElement ForgotPassword_txt;
	public WebElement getForgotPassword_txt() {
		return ForgotPassword_txt;
		}
	
	@FindBy(how = How.ID, using = "Email")
	private WebElement Email_txtBox;
	public WebElement getEmail_txtBox() {
		return Email_txtBox;
		}
	
	@FindBy(how = How.ID, using = "forgotPwd")
	private WebElement Send_btn;
	public WebElement getSend_btn() {
		return Send_btn;
		}

	@FindBy(how = How.CSS, using = ".center_auto") 
	private WebElement infoMessage;
	public WebElement getinfoMessage() {
		return infoMessage;
	}
	
	@FindBy(how = How.LINK_TEXT, using = "click here")
	private WebElement clickhere_txt;
	public WebElement getclickhere_txt() {
		return clickhere_txt;
		}
	
	@FindBy(how = How.ID, using = "body")
	private WebElement body;
	public WebElement getBody() {
		return body;
		}
	
	@FindBy(how = How.ID, using = "Password")
	private WebElement Password;
	public WebElement getPassword() {
		return Password;
		}
	
	@FindBy(how = How.ID, using = "ConfirmPassword")
	private WebElement ConfirmPassword;
	public WebElement getConfirmPassword() {
		return ConfirmPassword;
		}
	
	@FindBy(how = How.ID, using = "resetPwd")
	private WebElement resetPwd;
	public WebElement getResetPwd() {
		return resetPwd;
		}
	
}

