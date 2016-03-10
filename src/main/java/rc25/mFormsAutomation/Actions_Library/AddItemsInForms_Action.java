package rc25.mFormsAutomation.Actions_Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.OR_Library.AddItems_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;

public class AddItemsInForms_Action extends CreateForm_Action{
	public AddItemsInForms_Action(WebDriver driver) {
		super(driver);
	}

	public static String inputType;

	public static void add(int row) throws Exception {
		
		//Create object for page factory AddItems_objects.java file
		AddItems_objects AddItemsObj= PageFactory.initElements(driver, AddItems_objects.class);
		
		Thread.sleep(5000);
		AddItemsObj.getAddItemBtn().click();
		AddItemsObj.getAddNewItem().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Set the value of mRow in AddItems_objects.java class to set the dynamic xpath values
		AddItems_objects.mRow= row;
		driver.findElement(By.xpath(AddItems_objects.getAddItemName()));
		
		Thread.sleep(1000);
		String ActItemName= ExcelUtils.getCellData(row, Constant.Col_ItemName);
		driver.findElement(By.xpath(AddItems_objects.getAddItemName())).sendKeys(ActItemName); 
		
		String ActItemDesc= ExcelUtils.getCellData(row, Constant.Col_ItemDescription);
		driver.findElement(By.xpath(AddItems_objects.getAddItemDesc())).sendKeys(ActItemDesc);                                         
		
		driver.findElement(By.xpath(AddItems_objects.getAddInputType())).click();                                                                
		
		AddItemsObj.getAllTab().click();              
		
		inputType = ExcelUtils.getCellData(row, Constant.Col_InputType);
		AddItemsObj.getAddInputTypeDDL_Search().sendKeys(inputType);
	}
}
