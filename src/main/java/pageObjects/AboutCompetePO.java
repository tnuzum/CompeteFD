package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class AboutCompetePO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getPageLocator()
	{
		return driver.findElementByAccessibilityId("AboutView");
	}
	
	public WebElement getCloseButton(){
		return driver.findElementByXPath("//Button[@Name='Close'][1]");
	}
	
	
}
