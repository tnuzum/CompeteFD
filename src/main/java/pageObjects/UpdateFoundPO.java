package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class UpdateFoundPO extends base{
	
		// ** Constructor **
	public void updateFound(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getUpdateFoundPageLocator()
	{
		return driver.findElementByName("Update Found");
//		return driver.findElementByAccessibilityId("HFMessageBox;") // Alternative locator
	}
	
	public WebElement getOKButton() {
		return driver.findElementByName("OK");
//		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getNextButton(){
		
		return driver.findElementByName("Next");
//		return driver.findElementByAccessibilityId("nextbutton"); // Alternative locator
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByName("Cancel");
//		return driver.findElementByAccessibilityId("cancelbutton");
	}
	
	public WebElement getInstallingUpdatesLabel() {
		return driver.findElementByName("Installing Updates");
	}
	
}
