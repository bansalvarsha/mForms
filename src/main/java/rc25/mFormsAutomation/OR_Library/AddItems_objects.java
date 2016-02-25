package rc25.mFormsAutomation.OR_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddItems_objects {
	
	@FindBy(how = How.XPATH, using= "//input[@id='addItemInputBtn_1']")
	private WebElement AddItemBtn;
	public WebElement getAddItemBtn() {
		return AddItemBtn;
	}

	@FindBy(how = How.XPATH, using = "//form[@id='CreateForm1']/div[1]/div/div/div[5]/div[2]/ul/li[1]") 
	private WebElement AddNewItem;
	public WebElement getAddNewItem() {
		return AddNewItem;
		}
	
	@FindBy(how = How.XPATH, using = "html/body/div[4]/div[3]/div[2]/div/ul/li[1]/input") 
	private WebElement AllTab;
	public WebElement getAllTab() {
		return AllTab;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='content_pop']//input[@id='filter']") 
	private WebElement AddInputTypeDDL_Search;
	public WebElement getAddInputTypeDDL_Search() {
		return AddInputTypeDDL_Search;
		}

	//web elements of AddItems_objects.java file
	//These are dynamic x paths which cannot be called by find by annotation.
	public static int mRow;
	public static String getAddItemName(){
		return "//div[@id='divSort_" + mRow + "']//input[@id='item_ItemTxt']";
	}
	
	public static String getAddItemDesc(){
		return "//div[@id='divSort_" + mRow + "']//textarea[@id='item_ItemDescription']";
	}
	
	public static String getAddInputType(){
	return "//div[@id='divSort_"+ mRow +"']//input[@value='Add Input Type']"; 
	}

	@FindBy(how = How.CSS, using = ".add_input_btn") 
	private WebElement AddIputType;
	public WebElement getAddIputType() {
		return AddIputType;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@class[contains(.,'add_another_input_btn')]]") 
	private WebElement AddAnotherIputType;
	public WebElement getAddAnotherIputType() {
		return AddAnotherIputType;
	}
	
	@FindBy(how = How.CSS, using = ".group_btn.active") 
	private WebElement AddInputTypeDDL_AllTab;
	public WebElement getAddInputTypeDDL_AllTab() {
		return AddInputTypeDDL_AllTab;
		}
	
	@FindBy(how = How.XPATH, using = "//div[@class='pop_relative']//input[@placeholder[contains(.,'Search')]]") 
	private WebElement AddFormItemDDL_Search;
	public WebElement getDDL_Search() {
		return AddFormItemDDL_Search;
		}
	
	@FindBy(how = How.ID, using = "ItemTitle") 
	private WebElement ItemTitle_txtbox;
	public WebElement getItemTitle_txtbox() {
		return ItemTitle_txtbox;
	}
	}
	

