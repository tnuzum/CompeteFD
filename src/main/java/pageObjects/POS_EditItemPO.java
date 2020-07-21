package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_EditItemPO extends base{
	
		// ** Constructor **
	public void getDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getEditItemPageLocator()
	{
		return driver.findElementByAccessibilityId("???");
	}
	
	public WebElement getCloseButton() throws Exception {
		return driver.findElementByXPath("//Button[@Name='Close'][1]");
	}
	
	
}
