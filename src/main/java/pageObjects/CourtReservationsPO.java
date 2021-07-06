package pageObjects;


import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.MyActions;
import resources.base;

public class CourtReservationsPO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	
	
	public WebElement getClearButton() {
		return driver.findElementByAccessibilityId("btnClearMember");
	}
	
	public WebElement getMemberInputLabel() {
		return driver.findElementByAccessibilityId("lblSeachValue");
	}

	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtSearchValue");
	}

	public WebElement getBrowseButton() {
		return driver.findElementByAccessibilityId("btnMemberBrowse");
	}
	
	public WebElement getMemberId() {
		return driver.findElementByAccessibilityId("lblMemberId");
	}

	public WebElement getClubLabel() {
		return driver.findElementByAccessibilityId("lblClub");
	}

	public WebElement getClubCombobox() {
		return driver.findElementByAccessibilityId("cmbClub");
	}
	
	public WebElement getCourtTypeCombobox() {
		return driver.findElementByAccessibilityId("cmbCourtType");
	}
		public WebElement getListItem(int index){
		// *** This method is used to locate items in the 
		// Club, Service Category and Service drop down lists. ***
				
		return driver.findElementByXPath("//ListItem[@LocalizedControlType='list item']["+index+"]");
	}


	public WebElement getCalendarPreviousButton() {
		return driver.findElementByName("Scroll Previous");
	}
	
	public WebElement getCalendarNextButton() {
		return driver.findElementByName("Scroll Previous");
	}
	
	public WebElement getCalendarDateButton(int date) {
		MyActions.focusByNativeWindowHandleIndex(0);
		//return driver.findElementByName("//DataItem[@LocalizedControlType='item']["+index+"]");
		return driver.findElementByXPath("//DataItem[contains(@Name,'"+date+",')]");
	}
	
	public WebElement getShowCalendarButton() {
		return driver.findElementByAccessibilityId("pbShowCalendar");
	}

	
	public WebElement getSearchReservationsButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}
	

	public WebElement getCalendarCloseBtn() {
		return driver.findElementByAccessibilityId("btnClose");
						
	}
	
	public WebElement getCalendarDateTimeSlots(String date, String time) {
		MyActions.focusByNativeWindowHandleIndex(0);
		//return driver.findElementByName("//DataItem[@LocalizedControlType='item']["+index+"]");
		return driver.findElementByXPath("//DataItem[contains(@Name,'"+date+" "+time+"')]");
	}
	
	public WebElement getAttendedChkBox() {
		return driver.findElementByAccessibilityId("pbAttendant");
						
	}
	
	public WebElement getMessageYes() {
		return driver.findElementByAccessibilityId("pbYes");
						
	}
	
	public WebElement getOkBtn() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getMemberSearch() {
		return driver.findElementByAccessibilityId("txtLastName");
	}
	
	public WebElement getMemberBrowseButton() {
		return driver.findElementByAccessibilityId("btnLastNameBrowse");
	}
	
	public WebElement getReservationTimeComboBox() {
		return driver.findElementByAccessibilityId("cmbStartTime");
	}
	
	public WebElement getMemberInfo(int i) {
		return driver.findElementByName("Members Row "+i+", Not sorted.");
				
	}
	
	public WebElement getSearchOk() {
		return driver.findElementByAccessibilityId("btnOK");
	}

	public WebElement getSearchCancel() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	public WebElement getSearchClear() {
		return driver.findElementByAccessibilityId("btnClear");
	}
	public WebElement getCancelReservation() {
		return driver.findElementByAccessibilityId("btnDeleteReservation");
	}
	
	public WebElement getMessageOk() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getTextMsg() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
	
}
