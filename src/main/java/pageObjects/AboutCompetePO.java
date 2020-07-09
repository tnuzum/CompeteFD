package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class AboutCompetePO{
	
	WindowsDriver driver;
		// ** Constructor **
	public AboutCompetePO(WindowsDriver driver) {
		this.driver = driver;
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
