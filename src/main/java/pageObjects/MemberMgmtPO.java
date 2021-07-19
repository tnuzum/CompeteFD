package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class MemberMgmtPO extends base {


	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("MemberInfoView");
	}
	
	public WebElement getMemberMgmtLabel() {
		return driver.findElementByAccessibilityId("lblModule");
	}

	public WebElement getMemberInputLabel() {
		return driver.findElementByAccessibilityId("lblBarcodeID");
	}


	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtBarcode");
	}

	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getMemberId() {
		return driver.findElementByAccessibilityId("lblBarcodeIDValue");
	}
	
	public WebElement getTextMsg() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
	
	public WebElement getWarningYesButton() {
		return driver.findElementByAccessibilityId("btnOK");
		//return driver.findElementByName("Yes");
	}
	
	public WebElement getMemberInfoButton() {
		return driver.findElementByAccessibilityId("pbMemberInfo");
	}
	
	public WebElement getChangeRequestButton() {
		return driver.findElementByAccessibilityId("pbChangeRequest");
	}

	public WebElement getClose() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	





















}
