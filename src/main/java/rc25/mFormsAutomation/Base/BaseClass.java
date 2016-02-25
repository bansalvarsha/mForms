package rc25.mFormsAutomation.Base;


import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	public static String libraryName;
	
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
	}
	
	public BaseClass(String libraryName){
		BaseClass.libraryName= libraryName;
	}
	
}
