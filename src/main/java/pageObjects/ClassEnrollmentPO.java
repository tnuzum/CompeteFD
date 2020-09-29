package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class ClassEnrollmentPO extends base {

	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
	// ** Objects **
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("SelectClassForEnrollmentView");
	}

	public WebElement getMemberInputLabel() {
		return driver.findElementByName("Member ID / Last Name");
	}

	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtMemberName");
	}

	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getClearButton() {
		return driver.findElementByAccessibilityId("pbClearButton");
	}

	public WebElement getClassDateLabel() {
		return driver.findElementByName("Class Date");
	}
	
	public WebElement getClassDateCombobox() {
		return driver.findElementByAccessibilityId("dtpClassDate");
	}

	public WebElement getClubLabel() {
		return driver.findElementByName("Club");
	}
	
	public WebElement getClubCombobox() {
		return driver.findElementByAccessibilityId("cboClub");
	}
	
	public WebElement getClassSearchInputField() {
		return driver.findElementByAccessibilityId("txtDescription");
	}
	
	public WebElement getGoButton() {
		return driver.findElementByAccessibilityId("btnGo");
	}
	
	public WebElement getAllClassesRadioButton() {
		return driver.findElementByAccessibilityId("rbtnShowAllClasses");
	}
	
	public WebElement getFreeClassesRadioButton() {
		return driver.findElementByAccessibilityId("rbtnShowFreeClasses");
	}
	
	public WebElement getChargedClassesRadioButton() {
		return driver.findElementByAccessibilityId("rbtnShowChargedClasses");
	}
	
	public WebElement getPriceHeader() {
		return driver.findElementByAccessibilityId("lblCharge");
	}
	
	public WebElement getDescriptionHeader() {
		return driver.findElementByAccessibilityId("lblDescribe");
	}
	
	public WebElement getEnrolledStandByHeader() {
		return driver.findElementByAccessibilityId("lblEnrolledStandBy");
	}
	
	public WebElement getStartHeader() {
		return driver.findElementByAccessibilityId("lblStart");
	}
	
	public WebElement getSundayHeader() {
		return driver.findElementByAccessibilityId("lblMonday");
	}
	
	public WebElement getMondayHeader() {
		return driver.findElementByAccessibilityId("lblTuesday");
	}
	
	public WebElement getTuesdayHeader() {
		return driver.findElementByAccessibilityId("lblWednesday");
	}
	
	public WebElement getWednesdayHeader() {
		return driver.findElementByAccessibilityId("lblThursday");
	}
	
	public WebElement getThursdayHeader() {
		return driver.findElementByAccessibilityId("lblFriday");
	}
	
	public WebElement getFridayHeader() {
		return driver.findElementByAccessibilityId("lblSaturday");
	}
	
	public WebElement getSaturdayHeader() {
		return driver.findElementByAccessibilityId("lblSunday");
	}
	
	public WebElement getResultPrice(int index) {
		return driver.findElementByName("Price Row "+index+"");
	}
	
	public WebElement getResultDescription(int index) {
		return driver.findElementByName("DESCRIPTION Row "+index+", Not sorted.");
	}
	
	public WebElement getResultEnrolledStandby(int index) {
		return driver.findElementByName("EnrolledStandBy Row "+index+", Not sorted.");
	}
	
	public WebElement getResultStart(int index) {
		return driver.findElementByName("ClassStartDate Row "+index+", Not sorted.");
	}
	
	public WebElement getResultDay(int index, String day) { // Day must be sent as mixed-case, ex. Monday
		return driver.findElementByName(""+day+" Row "+index+", Not sorted.");
	}

	public WebElement getGreenTextLabel() {
		return driver.findElementByAccessibilityId("label4");
	}

	public WebElement getItalicTextLabel() {
		return driver.findElementByAccessibilityId("label5");
	}
	
	public WebElement getUnenrollButton() {
		return driver.findElementByAccessibilityId("pbSelectUnenroll");
	}
	
	public WebElement getMsgUnenrollButton() {
		return driver.findElementByName("Unenroll");
	}
	
	public WebElement getEnrollButton() {
		return driver.findElementByAccessibilityId("pbSelectEnroll");
	}
	
	public WebElement getCloseButton() {
		return driver.findElementByAccessibilityId("pbClose");
	}
	
	public WebElement getClearAllButton() {
		return driver.findElementByAccessibilityId("pbClearAll");
	}
		
	public WebElement getClassCourseName(int i) {
		return driver.findElementByName("DESCRIPTION Row "+i+", Not sorted.");
				
	}
	
	public WebElement getOkButton() {
		return driver.findElementByAccessibilityId("pbOk");
	}
	
	public WebElement getNoButton() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	public WebElement getSendEmailOkBtn() {
		return driver.findElementByXPath("//Pane//Pane//Pane[@LocalizedControlType='pane'][2]");
	}
	
	public WebElement getSendEmailCancelBtn() {
		return driver.findElementByXPath("//Pane//Pane//Pane[@LocalizedControlType='pane'][1]");
	}
	
	public WebElement getWarningOkBtn() {
		return driver.findElementByName("OK");
	}
}
