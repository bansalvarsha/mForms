package rc25.mFormsAutomation.OR_Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class Home_objects {

	//Page factory objects
		@FindBy(how = How.CLASS_NAME, using = "headerlogo") 
		private WebElement AppLogo;
		public WebElement getAppLogo() {
			return AppLogo;
			}
		
		@FindBy(how = How.CLASS_NAME, using = "banner_text_area") 
		private WebElement banner_text;
		public WebElement getbanner_text() {
			return banner_text;
			}
		
		@FindBys({@FindBy(how = How.ID, using = "footer"), @FindBy(how = How.ID, using = "copyrights")})
		private WebElement copyrights;
		public WebElement getcopyrights() {
			return copyrights;
			}
		
		@FindBys({@FindBy(how = How.ID, using = "footer"), @FindBy(how = How.ID, using = "version")})
		private WebElement version;
		public WebElement getversion() {
			return version;
			}
		
		@FindBys({@FindBy(how = How.ID, using = "footer"), @FindBy(how = How.XPATH, using = "//div[@id='address']/span/img")})
		private WebElement Copyrights_image;
		public WebElement getCopyrights_image() {
			return Copyrights_image;
			}
}
