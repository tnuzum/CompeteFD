package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class ClassEnrollmentPO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getAboutPageLocator()
	{
		return driver.findElementByAccessibilityId("SelectClassForEnrollmentView");
	}
	
	public WebElement getMemberInputLabel() throws Exception {
		return driver.findElementByName("Member ID / Last Name");
	}
	
	
}
