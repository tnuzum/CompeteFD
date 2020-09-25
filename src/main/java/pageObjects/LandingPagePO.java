package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.MyActions;
import resources.base;

public class LandingPagePO extends base {

	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("ShellForm");
	}

	public WebElement getCompeteInfoButton() {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][1]");
	}

	public WebElement getCheckInButton() {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]");
	}

	public WebElement getPOSButton() {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]");
	}

	public WebElement getAgreementsButton() {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][4]");
	}

	public WebElement getInfoTrackerButton() {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][5]");
	}

	public WebElement getMoreButton(){
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][6]");
	}

	public WebElement getMoreButtons(int index) {
		//buttons in list shown under the "More" top row button
		return driver.findElementByXPath("//Button[@LocalizedControlType='button']["+index+"]");
	}

}
