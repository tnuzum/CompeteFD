package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class LandingPagePO{
	
	WindowsDriver driver;
		// ** Constructor **
	public LandingPagePO(WindowsDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getLandingPageLocator()
	{
		return driver.findElementByAccessibilityId("ShellForm");
	}
	
	public WebElement getCompeteInfoButton()
	{
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][1]");
	}
	
	public WebElement getCheckInButton()
	{
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]");
	}
	
	public WebElement getPOSButton()
	{
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]");
	}

}
