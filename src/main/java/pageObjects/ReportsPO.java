package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class ReportsPO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getPageLabel() {
		return driver.findElementByAccessibilityId("lblModule"); // upper left, below Compete logo
	}
	
	public WebElement getReportTypeLabel(){
		return driver.findElementByAccessibilityId("lblReportType");
	}
	
	public WebElement getReportType(int index) { // Left pane in Reports view
		//return driver.findElementByName("Text Row "+index+", Not sorted.");
		return driver.findElementByXPath("(//Edit[@Name='Text Row "+index+", Not sorted.'])[1]");
	}
	
	public WebElement getReport(int index) { // Right pane in Reports view
		return driver.findElementByXPath("(//Edit[@Name='Text Row "+index+", Not sorted.'])[2]");
	}
	
	public WebElement getReportTitleBarLabel() { // located in middle, above search criteria pane
		return driver.findElementByAccessibilityId("lblTitleBar");
	}
	
	public WebElement getDateRangeLabel() {
		return driver.findElementByAccessibilityId("pnlDateRange");
	}
	
	public WebElement getStartDateLabel() {
		return driver.findElementByAccessibilityId("lblStartDate");
	}
	
	public WebElement getStartDateCombobox() {
		return driver.findElementByAccessibilityId("dtpStartDate");
	}
	
	public WebElement getEndDateLabel() {
		return driver.findElementByAccessibilityId("lblEndDate");
	}	
	
	public WebElement getEndDateCombobox() {
		return driver.findElementByAccessibilityId("dtpEndDate");
	}
	
	public WebElement getClubFilterLabel() {
		return driver.findElementByAccessibilityId("gbClubFilter");
	}
	
	public WebElement getTaggedClubsOnlyCheckbox() {
		return driver.findElementByAccessibilityId("chkOne");
	}
	
	public WebElement getClubsSelectedCountLabel() {
		return driver.findElementByAccessibilityId("lblSelected");
	}
	
	public WebElement getSelectButton() {
		return driver.findElementByAccessibilityId("btnSelectClub");
	}
	
	public WebElement getSelectGroupsButton() {
		return driver.findElementByAccessibilityId("btnSelectGroups");
	}
	
	public WebElement getClubFilteringLabel() {
		return driver.findElementByAccessibilityId("gbRadioOptionTwo");
	}
	
	public WebElement getAssignedClubRadioButton() {
		return driver.findElementByAccessibilityId("rbtnOptionOne");
	}
	
	public WebElement getWherePaymentWasCancelledButton() {
		return driver.findElementByAccessibilityId("rbtnOptionTwo");
	}
	
	public WebElement getStationCountSectionLabel() {
		return driver.findElementByAccessibilityId("gbSpinCounter");
	}
	
	public WebElement getStationCountInputField() {
		return driver.findElementByName("Spinner");
	}
	
	public WebElement getStationCountArrowUp() {
		return driver.findElementByName("Up");
	}

	public WebElement getStationCountArrowDown() {
		return driver.findElementByName("Down");
	}
	
	public WebElement getHelpButton() {
		return driver.findElementByAccessibilityId("btnHelp");
	}
	
	public WebElement getAddToSavedReportsButton() {
		return driver.findElementByAccessibilityId("btnAddToSavedReports");
	}
	
	public WebElement getRunReportButton() {
		return driver.findElementByAccessibilityId("btnRun");
	}
	
	public WebElement getCloseButton() {
		return driver.findElementByAccessibilityId("btnClose");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
