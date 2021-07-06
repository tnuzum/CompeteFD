package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class NurseryPO extends base {


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
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getMemberId() {
		return driver.findElementByAccessibilityId("lblMemberIDValue");
	}
	
	public WebElement getAddChildButton() {
		return driver.findElementByAccessibilityId("pbAddChild");
	}
	
	public WebElement getAddGuardianButton() {
		return driver.findElementByAccessibilityId("pbAddGuardian");
	}
	
	public WebElement getAddChildMemberInputField() {
		return driver.findElementByAccessibilityId("txtMemberID");
	}
	public WebElement getAddChildAddButton() {
		return driver.findElementByAccessibilityId("pbAdd");
	}
	
	public WebElement getAddChildSaveButton() {
		return driver.findElementByAccessibilityId("pbSave");
	}
	
	public WebElement getAddChildEmergencyContact() {
		return driver.findElementByAccessibilityId("txtEmergencyContact");
	}
	
	public WebElement getAddChildEmergencyPhone() {
		return driver.findElementByAccessibilityId("txtEmergencyPhone");
	}
	
	public WebElement getAddChildCancel() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getAddGuardianMemberInputField() {
		return driver.findElementByAccessibilityId("txtMemberID");
	}
	
	public WebElement getAddGaurdianCancel() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getCloseButton() {
		return driver.findElementByAccessibilityId("pbClose");
	}
	
	
	public WebElement getWarningYesButton() {
		return driver.findElementByAccessibilityId("btnOK");
		//return driver.findElementByName("Yes");
	}
	
	public WebElement getWarningNoButton() {
		return driver.findElementByAccessibilityId("btnCancel");
		//return driver.findElementByName("No");
	}
	
	
	public WebElement getTextMsg() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
	
	





















}
