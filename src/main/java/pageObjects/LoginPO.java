package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class LoginPO extends base{
	
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("FrontDeskEmployeeLogin");
	}
	
	public WebElement getUserNameLabel() {
		return driver.findElementByAccessibilityId("lblUserID");
	}
	
	public WebElement getUserNameInputField(){
		return driver.findElementByAccessibilityId("txtBarcodeId");
	}
	
	public WebElement getPasswordLabel() {
		return driver.findElementByAccessibilityId("lblPassword");
	}
	
	public WebElement getPasswordInputField(){
		return driver.findElementByAccessibilityId("txtPassword");
	}
	
	public WebElement getPromptCheckbox() {
		return driver.findElementByAccessibilityId("pbPasswordChange");
	}
	
	public WebElement getPromptLabel() {
		return driver.findElementByAccessibilityId("labelPasswordChange");
	}
	
	public WebElement getLoginButton(){
		return driver.findElementByAccessibilityId("pbLogIn");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getErrorMessageBox() {
		return driver.findElementByAccessibilityId("FrontDeskMessageBox");
	}
	
	public WebElement getErrorMessageOKButton() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getErrorMessages() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
}
