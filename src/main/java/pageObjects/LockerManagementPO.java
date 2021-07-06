package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class LockerManagementPO extends base {


	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **


	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtBarcode");
	}

	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	
	public WebElement getMemberId() {
		return driver.findElementByAccessibilityId("lblCustomerValue");
	}
	
	public WebElement getTextMsg() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
	
	public WebElement getWarningYesButton() {
		return driver.findElementByAccessibilityId("btnOK");
		//return driver.findElementByName("Yes");
	}
	

	public WebElement getClose() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	





















}
