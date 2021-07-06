package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class SearchAppointmentPO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtMemberID");
	}
	
	public WebElement getBrowseButton() {
		return driver.findElementByAccessibilityId("btnMemberBrowse");
	}
	public WebElement getAppointmentDetails(int i) {
		return driver.findElementByName("Appointment Details Row "+i+", Not sorted.");
				
	}
	
	public WebElement getMemberInfo(int i) {
		return driver.findElementByName("Member Info Row "+i+", Not sorted.");
				
	}
	
	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("btnSearch");
	}
	
	public WebElement getCloseButton() {
		return driver.findElementByAccessibilityId("btnClose");
	}
	
	public WebElement getClearButton() {
		return driver.findElementByAccessibilityId("btnClear");
	}
	
	
}
