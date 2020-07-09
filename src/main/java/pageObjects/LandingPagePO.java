package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.MyActions;

public class LandingPagePO {

	WindowsDriver driver;

	// ** Constructor **
	public LandingPagePO(WindowsDriver driver) {
		this.driver = driver;
	}

	// ** Objects **
	public WebElement getLandingPageLocator() {
		return driver.findElementByAccessibilityId("ShellForm");
	}

	public WebElement getCompeteInfoButton(String nativeWindowHandle) throws Exception {
		MyActions.focusOnLandingPage(nativeWindowHandle);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][1]");
	}

	public WebElement getCheckInButton(String nativeWindowHandle) throws Exception {
		MyActions.focusOnLandingPage(nativeWindowHandle);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]");
	}

	public WebElement getPOSButton(String nativeWindowHandle) throws Exception {
		System.out.println("LandingPagePO: "+nativeWindowHandle);
		MyActions.focusOnLandingPage(nativeWindowHandle);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]");
	}

	public WebElement getAgreementsButton(String nativeWindowHandle) throws Exception {
		MyActions.focusOnLandingPage(nativeWindowHandle);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][4]");
	}

	public WebElement getInfoTrackerButton(String nativeWindowHandle) throws Exception {
		MyActions.focusOnLandingPage(nativeWindowHandle);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][5]");
	}

	public WebElement getMoreButton(String nativeWindowHandle) throws Exception {
		MyActions.focusOnLandingPage(nativeWindowHandle);
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][6]");
	}

}
