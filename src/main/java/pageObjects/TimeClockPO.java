package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class TimeClockPO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getPageLocator()
	{
		return driver.findElementByAccessibilityId("TimeClockView");
	}
	
	public WebElement getMgrOverridePageLocator()
	{
		return driver.findElementByAccessibilityId("ManagerOverRideView");
	}
	
	public WebElement getUserIDLabel() {
		return driver.findElementByAccessibilityId("lblType");
	}
	
	public WebElement getUserIDInputField() {
		return driver.findElementByAccessibilityId("txtUserId");
	}
	
	public WebElement getPasswordLabel() {
		return driver.findElementByAccessibilityId("lblPassword");
	}
	
	public WebElement getPasswordInputField() {
		return driver.findElementByAccessibilityId("txtPassword");
	}
	
	public WebElement getCurrentDateLabel() {
		return driver.findElementByAccessibilityId("lblCurrentDate");
	}
	
	public WebElement getCurrentDateValue() {
		return driver.findElementByAccessibilityId("lblCurrentdateText");
	}
	
	public WebElement getCurrentTimeLabel() {
		return driver.findElementByAccessibilityId("lblCurrentTime");
	}
	
	public WebElement getCurrentTimeValue() {
		return driver.findElementByAccessibilityId("lblCurrentTimeText");
	}	
	
	public WebElement getInButton(){
		return driver.findElementByAccessibilityId("pbIn");
	}
	
	public WebElement getOutButton(){
		return driver.findElementByAccessibilityId("pbOut");
	}
	
	public WebElement getCancelButton(){
		// return driver.findElementByAccessibilityId("pbCancel");
		return driver.findElementByXPath("//Pane[@AutomationId='pbCancel'][1]");
	}
	
	public WebElement getManagerOverrideButton(){
		return driver.findElementByAccessibilityId("pbManagerOverride");
	}
	
	public WebElement getManagerUserIDLabel() {
		//return driver.findElementByAccessibilityId("lblType");
		return driver.findElementByName("Manager User ID");
	}
	
	public WebElement getManagerUserIDInputField() {
		return driver.findElementByAccessibilityId("txtUserId");
	}
	
	public WebElement getManagerPasswordLabel() {
		return driver.findElementByName("Manager Password");
	}
	
	public WebElement getManagerPasswordInputField() {
		return driver.findElementByAccessibilityId("txtPassword");
	}
	
	public WebElement getEmployeeUserIDLabel() {
		return driver.findElementByAccessibilityId("lblType");
	}
	
	public WebElement getEmployeeUserIDInputField() {
		return driver.findElementByAccessibilityId("txtEmployeeId");
	}
	
	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getManagerOverrideDateLabel() {
		return driver.findElementByAccessibilityId("lblCurrentTime");
	}

	public WebElement getManagerOverrideDateCombobox() {
		return driver.findElementByAccessibilityId("hfdtpTimeClockDate");
	}
	
	public WebElement getManagerOverrideDateCalendar() {
		return driver.findElementByXPath("//Edit[@LocalizedControlType='edit']");
	}
	
	public WebElement getManagerOverrideTimeLabel() {
		// return driver.findElementByAccessibilityId("label1");
		return driver.findElementByName("Time");
	}
	
	public WebElement getManagerOverrideTimeCombobox() {
		return driver.findElementByAccessibilityId("hfdtpTimeClockTime");
	}	
	
	public WebElement getManagerOverrideInButton(){
		//return driver.findElementByAccessibilityId("pbIn");
		return driver.findElementByXPath("//Pane[@AutomationId='pbIn'][2]");
	}
	
	public WebElement getManagerOverrideOutButton(){
		//return driver.findElementByAccessibilityId("pbOut");
		return driver.findElementByXPath("//Pane[@AutomationId='pbOut'][2]");
	}
	
	public WebElement getManagerOverrideCancelButton(){
		// return driver.findElementByAccessibilityId("pbCancel");
		return driver.findElementByXPath("//Pane[@AutomationId='pbCancel'][2]");
	}

	public WebElement getInvalidUserIDPWMessage() {
		return driver.findElementByAccessibilityId("lblIncorrectLogin");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
