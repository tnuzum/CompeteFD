package pageObjects;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CheckInPagePO{
	
	WindowsDriver driver;
		// ** Constructor **
	public CheckInPagePO(WindowsDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
		// ** Objects ** 
	
	public WebElement getCheckInViewLocator() throws Exception {
		return driver.findElementByAccessibilityId("pnlToolBar");
	}
	public WebElement getMemberInputField() throws Exception
	{
		return driver.findElementByAccessibilityId("txtBarcode");
	}
	
	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}
	
}
