package rc25.mFormsAutomation.Actions_Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.OR_Library.AddItems_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;

public class AddItemsInInputTypes_Action extends CreateInputType_Action {
	public AddItemsInInputTypes_Action(WebDriver driver) {
		super(driver);
	}

	static AddItems_objects AddItemsObj;
	public static String inputType;
	public static void add(int row) {
		AddItemsObj= PageFactory.initElements(driver, AddItems_objects.class);
		try {
			inputType = ExcelUtils.getCellData(row, Constant.Col_InputType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Click on "Add input type" button
		if(row==1){
			AddItemsObj.getAddIputType().click();                                                                
		} else AddItemsObj.getAddAnotherIputType().click();
			
		AddItemsObj.getAddInputTypeDDL_AllTab().click();
		AddItemsObj.getDDL_Search().sendKeys(inputType);
	}
}
