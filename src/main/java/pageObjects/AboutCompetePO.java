package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class AboutCompetePO extends base{
	
		// ** Constructor **
	public void aboutCompete(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getAboutPageLocator()
	{
		return driver.findElementByAccessibilityId("AboutView");
	}
	
	public WebElement getCloseButton() throws Exception {
		return driver.findElementByXPath("//Button[@Name='Close'][1]");
	}
	
	
}
