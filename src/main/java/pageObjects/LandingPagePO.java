package pageObjects;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class LandingPagePO {

	WindowsDriver driver;

	// ** Constructor **
	public LandingPagePO(WindowsDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// ** Objects **
	public WebElement getLandingPageLocator() {
		return driver.findElementByAccessibilityId("ShellForm");
	}

	public WebElement getCompeteInfoButton(String natWinHandle) throws Exception {
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][1]");
	}

	public WebElement getCheckInButton(String natWinHandle) throws Exception {
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]");
	}

	public WebElement getPOSButton(String natWinHandle) throws Exception {
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]");
	}
	
	public WebElement getAgreementsButton(String natWinHandle) throws Exception {
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][4]");
	}
	
	public WebElement getInfoTrackerButton(String natWinHandle) throws Exception {
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][5]");
	}
	
	public WebElement getMoreButton(String natWinHandle) throws Exception {
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][6]");
	}
	
	
	

}
