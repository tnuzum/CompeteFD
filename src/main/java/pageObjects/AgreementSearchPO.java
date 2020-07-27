package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class AgreementSearchPO extends base{

	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
	public WebElement getQuickSearchTab() {
		return driver.findElementByName("Quick Search");
	}
	
	public WebElement getAdvancedSearchTab() {
		return driver.findElementByName("Advanced Search");
	}
	
	public WebElement getQSSearchAgreementsLabel() {
		return driver.findElementByAccessibilityId("lblSearchAgreements");
	}
	
	public WebElement getQSSearchAgreementsInput() {
		return driver.findElementByAccessibilityId("txtSearchCriteria");
	}
	
	public WebElement getQSNameComboBox() {
		return driver.findElementByAccessibilityId("cboSearchType");
	}
	
	public WebElement getQSSearchButton() {
		return driver.findElementByAccessibilityId("btnSearchQuick");
	}
	
	public WebElement getQSClearButton() {
		return driver.findElementByAccessibilityId("btnClearQuick");
	}
	
	public WebElement getQSMemberIDHeader() {
		return driver.findElementByName("Member ID");
	}
	
	public WebElement getQSMemberLastNameHeader() {
		return driver.findElementByName("Last Name");
	}
	
	public WebElement getQSMemberFirstNameHeader() {
		return driver.findElementByName("First Name");
	}
	
	public WebElement getQSPlanActiveHeader() {
		return driver.findElementByName("PA");
	}
	
	public WebElement getQSPlanDescriptionHeader() {
		return driver.findElementByName("Plan Description");
	}
	
	public WebElement getQSExpirationDateHeader() {
		return driver.findElementByName("Exp. Description");
	}
	
	public WebElement getQSStatusHeader() {
		return driver.findElementByName("Status");
	}
	
	public WebElement getQSSaleDateHeader() {
		return driver.findElementByName("Sale Date");
	}
	
	public WebElement getQSAgreementNumberHeader() {
		return driver.findElementByName("Agreement Number");
	}
	
	public WebElement getQSResultMemberID(int index) {
		return driver.findElementByName("Member ID Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultLastName(int index) {
		return driver.findElementByName("Last Name Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultFirstName(int index) {
		return driver.findElementByName("First Name Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultPlanActive(int index) {
		return driver.findElementByName("PA Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultPlanDescription(int index) {
		return driver.findElementByName("Plan Description Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultExpirationDate(int index) {
		return driver.findElementByName("Exp. Date Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultStatus(int index) {
		return driver.findElementByName("Status Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultSaleDate(int index) {
		return driver.findElementByName("Sale Date Row "+index+", Not sorted.");
	}
	
	public WebElement getQSResultAgreementNumber(int index) {
		return driver.findElementByName("Agreement Number Row "+index+", Not sorted.");
	}
	
	public WebElement getQSMemberClubLabel() {
		return driver.findElementByAccessibilityId("lblMemberClub");
	}
	
	public WebElement getQSMemberClubValue() {
		return driver.findElementByAccessibilityId("txtMemberClub");
	}
	
	public WebElement getQSPlanTypeLabel() {
		return driver.findElementByAccessibilityId("lblPlanType");
	}
	
	public WebElement getQSPlanTypeValue() {
		return driver.findElementByAccessibilityId("lblPlanTypeValue");
	}
	
	public WebElement getQSSalesDateLabel() {
		return driver.findElementByAccessibilityId("lblSalesDate");
	}
	
	public WebElement getQSSalesDateValue() {
		return driver.findElementByAccessibilityId("lblSalesDateValue");
	}
	
	public WebElement getQSSalespersonLabel() {
		return driver.findElementByAccessibilityId("lblDisplaySalesPerson");
	}
	
	public WebElement getQSSalespersonValue() {
		return driver.findElementByAccessibilityId("txtSalesPersonValue");
	}
	
	public WebElement getQSRecurringDuesLabel() {
		return driver.findElementByAccessibilityId("lblRecurringDuesAmount");
	}
	
	public WebElement getQSRecurringDuesValue() {
		return driver.findElementByAccessibilityId("txtRecurringDuesAmount");
	}
	
	public WebElement getQSPrintAgreementButton() {
		return driver.findElementByAccessibilityId("btnPrintAgreement");
	}
	
	public WebElement getQSOKButton() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getQSCancelButton() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
