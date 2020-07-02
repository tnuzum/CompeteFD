package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class AboutPagePO{
	
	WindowsDriver driver;
		// ** Constructor **
	public AboutPagePO(WindowsDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getAboutPageLocator()
	{
		return driver.findElementByAccessibilityId("AboutView");
	}
	
}
