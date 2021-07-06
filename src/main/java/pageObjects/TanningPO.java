package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class TanningPO extends base {


	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **


	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtMemberName");
	}

	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getClearButton() {
		return driver.findElementByAccessibilityId("pbClearButton");
	}

	
	
	public WebElement getTextMsg() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
	
	public WebElement getWarningYesButton() {
		return driver.findElementByAccessibilityId("btnOK");
		//return driver.findElementByName("Yes");
	}
	

	public WebElement getClose() {
		return driver.findElementByAccessibilityId("pbClose");
	}
	
	





















}
