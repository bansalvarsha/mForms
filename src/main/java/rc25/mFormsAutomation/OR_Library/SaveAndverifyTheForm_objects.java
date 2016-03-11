package rc25.mFormsAutomation.OR_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SaveAndverifyTheForm_objects {
	@FindBy(how = How.CSS, using = ".center_auto") 
	private WebElement ConfirmationMessage;
	public WebElement getConfirmationMessage() {
		return ConfirmationMessage;
	}
	
	@FindBy(how = How.XPATH, using = "//tr[@class='note hightlightTr']") 
	private WebElement FormInTheList;
	public WebElement getRecordInTheList() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return FormInTheList;
	}
	
	@FindBy(how = How.CLASS_NAME, using = "save_head_btn")//"//button[contains(text(),'Save')]") 
	private WebElement save_btn;
	public WebElement getsave_btn() {
		return save_btn;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]")//"//button[contains(text(),'Save')]") 
	private WebElement SaveForm_btn;
	public WebElement getSaveForm_btn() {
		return SaveForm_btn;
	}
	
	/*@FindBy(how = How.XPATH, using = "//ul[@class='header-button-group drop']//span[@class='save_draft_head_btn']")//"//button[contains(text(),'Save')]") 
	private WebElement EditSaveForm_btn;
	public WebElement getEditSaveForm_btn() {
		return EditSaveForm_btn;
	}*/
	
	
	@FindBy(how = How.XPATH, using = "//tr[@class='note hightlightTr']//td[@class='width30 left_align']")
	private WebElement InputTypeName;
	public WebElement getInputTypeName() {
		return InputTypeName;
	}
	
	@FindBy(how = How.XPATH, using = "//tr[@class='note hightlightTr']/td[@class='width30 left_align']/em")
	private WebElement ItemName;
	public WebElement getItemName() {
		return ItemName;
	}
	
	@FindBy(how = How.XPATH, using = "//tr[@class='note hightlightTr']//td[@class='width30 left_align']")
	private WebElement Ioptionname;
	public WebElement getIOptionname() {
		return Ioptionname;
	}
	
	@FindBy(how = How.CSS, using = ".library_head")
	private WebElement Libraryname;
	public WebElement getLibraryname() {
		return Libraryname;
	}
	
	@FindBy(how = How.ID, using = "CustomInputType")
	private WebElement AddInputTypeNameField;
	public WebElement getAddInputTypeNameField() {
		return AddInputTypeNameField;
	}
	
	@FindBy(how = How.ID, using = "FrmName")
	private WebElement FormTitleField;
	public WebElement getFormTitleField() {
		return FormTitleField;
	}
}
