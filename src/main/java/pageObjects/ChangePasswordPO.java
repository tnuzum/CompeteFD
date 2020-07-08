package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class ChangePasswordPO {

	WindowsDriver driver;

	// ** Constructor **
	public ChangePasswordPO(WindowsDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// ** Objects **
	public WebElement getChangePasswordPageLocator() {
		return driver.findElementByAccessibilityId("ChangeEmployeePasswordView");
	}

	public WebElement getNewPasswordlabel() {
		return driver.findElementByAccessibilityId("lblNewPassword");
	}
	
	public WebElement getNewPasswordInputField() {
		return driver.findElementByAccessibilityId("txtNewPassword");
	}

	public WebElement getConfirmPasswordlabel() {
		return driver.findElementByAccessibilityId("lblConfirmPassword");
	}
	
	public WebElement getConfirmPasswordInputField() {
		return driver.findElementByAccessibilityId("txtConfirmPassword");
	}
	
	public WebElement getHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getOKButton() {
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByXPath("//Pane[@AutomationId='pbCancel'][1]");
	}

}
