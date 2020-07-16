package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class AgreementSearchPO extends base{

	// ** Constructor **
	public void agreements(WindowsDriver driver) {
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
	
	public WebElement getQSResult1MemberID() {
		return driver.findElementByName("Member ID Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1LastName() {
		return driver.findElementByName("Last Name Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1FirstName() {
		return driver.findElementByName("First Name Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1PlanActive() {
		return driver.findElementByName("PA Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1PlanDescription() {
		return driver.findElementByName("Plan Description Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1ExpirationDate() {
		return driver.findElementByName("Exp. Date Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1Status() {
		return driver.findElementByName("Status Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1SaleDate() {
		return driver.findElementByName("Sale Date Row 0, Not sorted.");
	}
	
	public WebElement getQSResult1AgreementNumber() {
		return driver.findElementByName("Agreement Number Row 0, Not sorted.");
	}
	
	public WebElement getQSResult2MemberID() {
		return driver.findElementByName("Member ID Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2LastName() {
		return driver.findElementByName("Last Name Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2FirstName() {
		return driver.findElementByName("First Name Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2PlanActive() {
		return driver.findElementByName("PA Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2PlanDescription() {
		return driver.findElementByName("Plan Description Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2ExpirationDate() {
		return driver.findElementByName("Exp. Date Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2Status() {
		return driver.findElementByName("Status Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2SaleDate() {
		return driver.findElementByName("Sale Date Row 1, Not sorted.");
	}
	
	public WebElement getQSResult2AgreementNumber() {
		return driver.findElementByName("Agreement Number Row 1, Not sorted.");
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
