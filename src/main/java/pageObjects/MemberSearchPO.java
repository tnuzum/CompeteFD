package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class MemberSearchPO extends base{

	// ** Constructor **
	public void memberSearch(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
	public WebElement getMemberSearchPageLocator() {
		return driver.findElementByAccessibilityId("MemberQuickSearchView");
	}
	
	public WebElement getQuickSearchTab() {
		return driver.findElementByAccessibilityId("pbQuickSearch");
	}
	
	public WebElement getAdvancedSearchTab() {
		return driver.findElementByAccessibilityId("pbAdvSearch");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getOKButton() {
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getQSInputField() {
		return driver.findElementByAccessibilityId("txtSearch");
	}
	
	public WebElement getQSearchButton() {
		return driver.findElementByAccessibilityId("pbQuickSearchButton");
	}
	
	public WebElement getQSProspectsOnlyCheckbox() {
		return driver.findElementByAccessibilityId("pbQProspectsOnly");
	}
	
	public WebElement getQSProspectsOnlyLabel() {
		return driver.findElementByAccessibilityId("lblProspectsOnly");
	}
	
	public WebElement getQSSearchTypeCombobox() {
		return driver.findElementByAccessibilityId("cboSearchBy");
	}
	
	public WebElement getQSSearchTypeButton() {
		return driver.findElementByName("Open");
	}
	
	public WebElement getQSResultDownArrow() {
		return driver.findElementByName("Line down");
	}
	
	public WebElement getQSResultUpArrow() {
		return driver.findElementByName("Line up");
	}
	
	public WebElement getQSResultSlider() {
		return driver.findElementByName("Page down");
	}
	
	public WebElement getQSPreviousMemberArrow() {
		return driver.findElementByAccessibilityId("pbUp");
	}
	
	public WebElement getQSNextMemberArrow() {
		return driver.findElementByAccessibilityId("pbDown");
	}
	
	public WebElement getQSMemberIdLabel() {
		return driver.findElementByName("Member ID");
	}
	
	public WebElement getQSMemberNameLabel() {
		return driver.findElementByName("Member Name");
	}
	
	public WebElement getQSStatusLabel() {
		return driver.findElementByName("Status");
	}
	
	public WebElement getQSHomePhoneLabel() {
		return driver.findElementByName("Home Phone");
	}
	
	public WebElement getQSStreetAddressLabel() {
		return driver.findElementByName("Street Address");
	}
	
	public WebElement getQSResultsPane() {
		return driver.findElementByAccessibilityId("pbItems");
	}
	
	public WebElement getQSResult1MemberType() { // asterisk at far left of results pane
		return driver.findElementByName("MemberType Row 0, Not sorted");
	}
	
	public WebElement getQSResult1MemberId() {
		return driver.findElementByName("Barcode Row 0, Not sorted");
	}
	
	public WebElement getQSResult1MemberName() {
		return driver.findElementByName("DisplayName Row 0, Not sorted");
	}
	
	public WebElement getQSResult1Status() {
		return driver.findElementByName("StatusDescription Row 0, Not sorted");
	}
	
	public WebElement getQSResult1HomePhone() {
		return driver.findElementByName("HomePhone Row 0, Not sorted");
	}
	
	public WebElement getQSResult1StreetAddress() {
		return driver.findElementByName("Address1 Row 0, Not sorted");
	}
	
	public WebElement getQSResult2MemberType() { // asterisk at far left of results pane
		return driver.findElementByName("MemberType Row 1, Not sorted");
	}
	
	public WebElement getQSResult2MemberId() {
		return driver.findElementByName("Barcode Row 1, Not sorted");
	}
	
	public WebElement getQSResult2MemberName() {
		return driver.findElementByName("DisplayName Row 1, Not sorted");
	}
	
	public WebElement getQSResult2Status() {
		return driver.findElementByName("StatusDescription Row 1, Not sorted");
	}
	
	public WebElement getQSResult2HomePhone() {
		return driver.findElementByName("HomePhone Row 1, Not sorted");
	}
	
	public WebElement getQSResult2StreetAddress() {
		return driver.findElementByName("Address1 Row 1, Not sorted");
	}
	
	
	
	
	
	
}
