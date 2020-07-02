package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class LoginPO{
	
	WindowsDriver driver;
		// ** Constructor **
	public LoginPO(WindowsDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getUserNameInputField()
	{
		return driver.findElementByAccessibilityId("txtBarcodeId");
	}
	
	public WebElement getPasswordInputField()
	{
		return driver.findElementByAccessibilityId("txtPassword");
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElementByAccessibilityId("pbLogIn");
	}

}
