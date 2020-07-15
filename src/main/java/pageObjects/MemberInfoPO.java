package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class MemberInfoPO extends base{

	// ** Constructor **
	public void memberInfo(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
	public WebElement getMemberInfoPageLocator() {
		return driver.findElementByAccessibilityId("MemberInfoView");
	}
	
	public WebElement getMemberNameLabel() {
		// upper left corner
		return driver.findElementByAccessibilityId("lblMemberNameValue");
	}

	public WebElement getMemberPaneMemberNameValue() {
		// inside Member section
		return driver.findElementByAccessibilityId("lblNameValue");
	}
	
	public WebElement getCloseButton() throws Exception {
		return driver.findElementByXPath("//Button[@Name='Close'][1]");
	}
	
	
}
