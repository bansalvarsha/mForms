package rc25.mFormsAutomation.Actions_Library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Library.CreateLibrary_objects;
import rc25.mFormsAutomation.utility.Constant;
import rc25.mFormsAutomation.utility.ExcelUtils;
import rc25.mFormsAutomation.utility.Log;
import rc25.mFormsAutomation.utility.Utils;

public class Theme_Actions extends BaseClass {

	public Theme_Actions(WebDriver driver) {
		super(driver);
	}

	static CreateLibrary_objects CreateLibObj; 
	public static void pageFactory() {
		CreateLibObj= PageFactory.initElements(driver, CreateLibrary_objects.class);
	}
	
	public static void Add_theme(int row) throws Exception {
		WebElement getChooseThemeDDL= CreateLibObj.getChooseTheme_btn(); 
		Utils.waitForElementOnvisibilityOf(getChooseThemeDDL);
		getChooseThemeDDL.click();
		Log.info("Clicked on choose theme drop down list.");
		
		CreateLibObj.getAddTheme().click();
		CreateLibObj.getThemeName().clear();
		Thread.sleep(2000);
		String ThemeName= ExcelUtils.getCellData(row, Constant.Col_ThemeName);
		CreateLibObj.getThemeName().sendKeys(ThemeName);
		
		//Add back ground color
		CreateLibObj.getDivBGColor().click();
		String BackgroundColor_CodeR= ExcelUtils.getCellData(row, Constant.Col_BackgroundColor_CodeR);
		CreateLibObj.getr_color().clear();
		CreateLibObj.getr_color().sendKeys(BackgroundColor_CodeR);
		
		String BackgroundColor_CodeG= ExcelUtils.getCellData(row, Constant.Col_BackgroundColor_CodeG);
		CreateLibObj.getg_color().clear();
		CreateLibObj.getg_color().sendKeys(BackgroundColor_CodeG);
		
		String BackgroundColor_CodeB= ExcelUtils.getCellData(row, Constant.Col_BackgroundColor_CodeB);
		CreateLibObj.getb_color().clear();
		CreateLibObj.getb_color().sendKeys(BackgroundColor_CodeB);
		
		CreateLibObj.getcolpick_submit().click();
		
		//Add text color
		CreateLibObj.getDivTextColor().click();
		String TextColor_CodeR= ExcelUtils.getCellData(row, Constant.Col_TextColor_CodeR);
		CreateLibObj.getr_color().clear();
		CreateLibObj.getr_color().sendKeys(TextColor_CodeR);
		
		String TextColor_CodeG= ExcelUtils.getCellData(row, Constant.Col_TextColor_CodeG);
		CreateLibObj.getg_color().clear();
		CreateLibObj.getg_color().sendKeys(TextColor_CodeG);
		
		String TextColor_CodeB= ExcelUtils.getCellData(row, Constant.Col_TextColor_CodeB);
		CreateLibObj.getb_color().clear();
		CreateLibObj.getb_color().sendKeys(TextColor_CodeB);
		CreateLibObj.getcolpick_submit().click();
		
		//Add link color
		CreateLibObj.getDivLinkColor().click();
		String LinkColor_CodeR= ExcelUtils.getCellData(row, Constant.Col_LinkColor_CodeR);
		CreateLibObj.getr_color().clear();
		CreateLibObj.getr_color().sendKeys(LinkColor_CodeR);
		
		String LinkColor_CodeG= ExcelUtils.getCellData(row, Constant.Col_LinkColor_CodeG);
		CreateLibObj.getg_color().clear();
		CreateLibObj.getg_color().sendKeys(LinkColor_CodeG);
		
		String LinkColor_CodeB= ExcelUtils.getCellData(row, Constant.Col_LinkColor_CodeB);
		CreateLibObj.getb_color().clear();
		CreateLibObj.getb_color().sendKeys(LinkColor_CodeB);
		CreateLibObj.getcolpick_submit().click();
		
		//Add button back ground color
		CreateLibObj.getDivButtonBGColor().click();
		String ButtonBackgroundColor_CodeR= ExcelUtils.getCellData(row, Constant.Col_ButtonBackgroundColor_CodeR);
		CreateLibObj.getr_color().clear();
		CreateLibObj.getr_color().sendKeys(ButtonBackgroundColor_CodeR);
		
		String ButtonBackgroundColor_CodeG= ExcelUtils.getCellData(row, Constant.Col_ButtonBackgroundColor_CodeG);
		CreateLibObj.getg_color().clear();
		CreateLibObj.getg_color().sendKeys(ButtonBackgroundColor_CodeG);
		
		String ButtonBackgroundColor_CodeB= ExcelUtils.getCellData(row, Constant.Col_ButtonBackgroundColor_CodeB);
		CreateLibObj.getb_color().clear();
		CreateLibObj.getb_color().sendKeys(ButtonBackgroundColor_CodeB);
		CreateLibObj.getcolpick_submit().click();
		
		//Add button text color
		CreateLibObj.getDivButtonTextColor().click();
		String ButtonTextColor_CodeR= ExcelUtils.getCellData(row, Constant.Col_ButtonTextColor_CodeR);
		CreateLibObj.getr_color().clear();
		CreateLibObj.getr_color().sendKeys(ButtonTextColor_CodeR);
		
		String ButtonTextColor_CodeG= ExcelUtils.getCellData(row, Constant.Col_ButtonTextColor_CodeG);
		CreateLibObj.getg_color().clear();
		CreateLibObj.getg_color().sendKeys(ButtonTextColor_CodeG);
		
		String ButtonTextColor_CodeB= ExcelUtils.getCellData(row, Constant.Col_ButtonTextColor_CodeB);
		CreateLibObj.getb_color().clear();
		CreateLibObj.getb_color().sendKeys(ButtonTextColor_CodeB);
		CreateLibObj.getcolpick_submit().click();
		
		String PerformAction= ExcelUtils.getCellData(row, Constant.Col_PerformActions);
		if(PerformAction.equalsIgnoreCase("save"))
			CreateLibObj.getlookSaveBtn().click();
		else 
			CreateLibObj.getlookCancelBtn().click();
		
		Utils.getConfirmationMessage();
		
		String verifyNewTheme= CreateLibObj.getChooseThemeSpan().getText();
		System.out.println("New theme is created which is selected with the name of " + verifyNewTheme);
	}
	
	public static void Edit_theme() throws Exception {
		WebElement getChooseThemeDDL= CreateLibObj.getChooseTheme_btn(); 
		Utils.waitForElementOnvisibilityOf(getChooseThemeDDL);
		
		getChooseThemeDDL.click();
		Log.info("Clicked on choose theme drop down list.");
		
		
	}
	
	public static void View_theme(int row) throws Exception {
		Thread.sleep(2000);
		WebElement getChooseThemeDDL= CreateLibObj.getChooseTheme_btn(); 
		Utils.waitForElementOnvisibilityOf(getChooseThemeDDL);
		
		getChooseThemeDDL.click();
		
		Log.info("Clicked on choose theme drop down list.");
		
		driver.findElement(By.xpath(CreateLibrary_objects.View_Btn(row))).click();
		CreateLibObj.getThemeName();
		
		Utils.waitForElementOnvisibilityOf(CreateLibObj.getDivBGColor());
		String getBackGroundColor = CreateLibObj.getDivBGColor().getAttribute("style");
		Pattern pattern = Pattern.compile("rgb\\((.*?)\\)");
		Matcher matcher = pattern.matcher(getBackGroundColor);
		if (matcher.find()){
		    System.out.println("Background Color is= " + matcher.group(0));
		}
		
		String getTextColor = CreateLibObj.getDivTextColor().getAttribute("style");
		Matcher matcher1 = pattern.matcher(getTextColor);
		if (matcher1.find()){
		    System.out.println("Text color is= " + matcher1.group(0));
		}
		
		String getLinkColor= CreateLibObj.getDivLinkColor().getAttribute("style");
		Matcher matcher2= pattern.matcher(getLinkColor);
		if(matcher2.find()){
			System.out.println("Link color is= " + matcher2.group(0));
		}
		
		String getBtn_BackgroundColor= CreateLibObj.getDivButtonBGColor().getAttribute("style");
		Matcher matcher3= pattern.matcher(getBtn_BackgroundColor);
		if(matcher3.find()){
			System.out.println("Button back ground color is= " + matcher3.group(0));
		}
		
		String getBtn_TextColor= CreateLibObj.getDivButtonTextColor().getAttribute("style");
		Matcher matcher4= pattern.matcher(getBtn_TextColor);
		if(matcher4.find()){
			System.out.println("Button text color is= " + matcher4.group(0));
		}
	}

	
	public static void Delete_theme() {
		
	}
	
}
