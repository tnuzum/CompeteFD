package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.MyActions;
import resources.base;

public class BookingsPO extends base{
	
		// ** Constructor **
	public void aboutCompete(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	
	public WebElement getBookingsPageLabel() {
		return driver.findElementByAccessibilityId("lblModule"); // upper left, below Compete logo
	}

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
		return driver.findElementByAccessibilityId("pnlBrowse");
	}

	public WebElement getClubLabel() {
		return driver.findElementByAccessibilityId("lblClub");
	}

	public WebElement getClubCombobox() {
		return driver.findElementByAccessibilityId("cmbClub");
	}
	
	public WebElement getListItem(int index) throws Exception {
		// *** This method is used to locate items in the 
		// Club, Service Category and Service drop down lists. ***
		return driver.findElementByXPath("//ListItem[@LocalizedControlType='list item']["+index+"]");
	}

	public WebElement getServiceCategoryLabel() {
		return driver.findElementByAccessibilityId("lblScheduleCategory");
	}

	public WebElement getServiceCategoryCombobox() {
		return driver.findElementByAccessibilityId("cmbServiceCategory");
	}

	public WebElement getServiceLabel() {
		return driver.findElementByAccessibilityId("lblScheduleBook");
	}

	public WebElement getServiceCombobox() {
		return driver.findElementByAccessibilityId("cmbResources");
	}

	public WebElement getResourcesLabel() {
		return driver.findElementByName("Resources");
		//return driver.findElementByAccessibilityId("label7");
	}
	
	public WebElement getResourceTypeHeader() {
		return driver.findElementByName("Resource Type");
	}
	
	public WebElement getBookHeader() {
		return driver.findElementByName("Book");
	}
	
	public WebElement getResourceTypeValue(int index) {
		return driver.findElementByName("Resource Type Row "+index);
	}
	
	public WebElement getBookValue(int index) {
		return driver.findElementByName("Book Row "+index);
	}
	
	public WebElement getCalendarView() {
		return driver.findElementByAccessibilityId("ultraMonthViewMulti");
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
	
	public WebElement getBookViewButton() {
		return driver.findElementByAccessibilityId("pbBookView");
	}
	
	public WebElement getSearchAppointmentsButton() {
		return driver.findElementByAccessibilityId("pbBookView");
	}
	
	public WebElement getBreadCrum() {
		// label at top of large calendar
		return driver.findElementByAccessibilityId("lblBreadCrum");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
