package rc25.mFormsAutomation.Actions_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import rc25.mFormsAutomation.Base.BaseClass;
import rc25.mFormsAutomation.OR_Home.Home_objects;
import rc25.mFormsAutomation.utility.Log;

public class Home_Action extends BaseClass {
	static Home_objects HomeObj;
	
	public Home_Action(WebDriver driver) {
		super(driver);
	}
	
	private static  ExtentReports extent= ExtentReports.get(Home_Action.class);
	
	public static  void Home_content_Verification() throws Exception {
		HomeObj= PageFactory.initElements(driver, Home_objects.class);
		
		if(HomeObj.getAppLogo().isDisplayed()) {
			Log.info("Header logo is found");
			System.out.println("Header logo is found");
			extent.log(LogStatus.PASS, "Header logo is found");
		}else {
			Log.info("No logo is found");
			System.out.println("No logo is found");
			extent.log(LogStatus.PASS, "No logo is found");
		}
		
		
		String banner_text= HomeObj.getbanner_text().getText();
		Log.info(banner_text);
		System.out.println(banner_text);
		extent.log(LogStatus.PASS, banner_text);
		
		String copyrights_text= HomeObj.getcopyrights().getText();
		String Version= HomeObj.getversion().getText();
		Log.info(copyrights_text + " " + Version);
		System.out.println(copyrights_text + " " + Version);
		extent.log(LogStatus.PASS, copyrights_text + " " + Version);
		
		String Copyrights_image= HomeObj.getCopyrights_image().getAttribute("src");
		Log.info("Copy right image source is '" + Copyrights_image + "'");
		System.out.println("Copy right image source is '" + Copyrights_image + "'");
		extent.log(LogStatus.PASS, "Copy right image source is '" + Copyrights_image + "'");
	}
}

