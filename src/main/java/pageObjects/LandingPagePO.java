package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.MyActions;
import resources.base;

public class LandingPagePO extends base {

	// ** Constructor **
	public void landPage(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	public WebElement getLandingPageLocator() {
		return driver.findElementByAccessibilityId("ShellForm");
	}

	public WebElement getCompeteInfoButton() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][1]");
	}

	public WebElement getCheckInButton() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]");
	}

	public WebElement getPOSButton() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]");
	}

	public WebElement getAgreementsButton() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][4]");
	}

	public WebElement getInfoTrackerButton() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][5]");
	}

	public WebElement getMoreButton() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][6]");
	}

	public WebElement getMoreButton1() throws Exception {
		//top button in list shown under the "More" top row button
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][1]");
	}
	
	public WebElement getMoreButton2() throws Exception {
		//second button from top of list shown under the "More" top row button
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]");
	}
	
	public WebElement getMoreButton3() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]");
	}
	
	public WebElement getMoreButton4() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][4]");
	}
	
	public WebElement getMoreButton5() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][5]");
	}
	
	public WebElement getMoreButton6() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][6]");
	}
	
	public WebElement getMoreButton7() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][7]");
	}
	
	public WebElement getMoreButton8() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][8]");
	}
	
	public WebElement getMoreButton9() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][9]");
	}
	
	public WebElement getMoreButton10() throws Exception {
		MyActions.focusOnLandingPage();
		return driver.findElementByXPath("//Button[@LocalizedControlType='button'][10]");
	}
}
