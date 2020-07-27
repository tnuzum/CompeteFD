package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class CheckInPO extends base {


	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **

	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("pnlToolBar");
	}

	public WebElement getCheckInModeLabel() {
		return driver.findElementByAccessibilityId("lblModule");
	}

	public WebElement getMemberInputLabel() {
		return driver.findElementByAccessibilityId("lblBarcodeID");
	}

	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtBarcode");
	}

	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getClearMemberButton() {
		return driver.findElementByAccessibilityId("pbClearMember");
	}

	public WebElement getTakePictureButton() {
		return driver.findElementByAccessibilityId("pbTakePicture");
	}

	public WebElement getMemberInfoButton() {
		return driver.findElementByAccessibilityId("pbMemberInfo");
	}

	public WebElement getMemberNotesButton() {
		return driver.findElementByAccessibilityId("pbAddNote");
	}

	public WebElement getChangeRequestButton() {
		return driver.findElementByAccessibilityId("pbChangeRequest");
	}

	public WebElement getTodaysCheckInsButton() {
		return driver.findElementByAccessibilityId("pbCheckinReports");
	}

	public WebElement getCheckInModeButton() {
		return driver.findElementByAccessibilityId("pbCheckInMode");
	}

	public WebElement getAddGuestButton() {
		return driver.findElementByAccessibilityId("pbAddGuest");
	}
}
