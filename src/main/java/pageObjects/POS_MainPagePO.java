package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_MainPagePO extends base {

	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	public WebElement getPageLocator() {
		//return driver.findElementByAccessibilityId("PointOfSaleMainView");
		return driver.findElementByName("Point Of Sale");
	}

	public WebElement getPOSPageLabel() {
		return driver.findElementByAccessibilityId("lblModule"); // upper left, below Compete logo
	}

	public WebElement getMemberInputLabel() {
		return driver.findElementByAccessibilityId("lblBarcodeID"); // displayed Member ID / Last Name
	}

	public WebElement getMemberInputField() {
		return driver.findElementByAccessibilityId("txtBarcode");
	}

	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getTakePaymentButton() {
		return driver.findElementByAccessibilityId("pbTakePayment");
	}

	public WebElement getClearMemberButton() {
		return driver.findElementByAccessibilityId("pbClearMember");
	}

	public WebElement getReceiptLabel() {
		return driver.findElementByAccessibilityId("lblReceipt");
	}

	public WebElement getReceiptUpButton() {
		return driver.findElementByAccessibilityId("pbReceiptUp");
	}

	public WebElement getReceiptDownButton() {
		return driver.findElementByAccessibilityId("pbReceiptDown");
	}

	public WebElement getSoldByButton() {
		return driver.findElementByAccessibilityId("pbSoldBy");
	}

	public WebElement getEditButton() {
		return driver.findElementByAccessibilityId("pbEdit");
	}

	public WebElement getReturnButton() {
		return driver.findElementByAccessibilityId("pbReturn");
	}

	public WebElement getZOutButton() {
		return driver.findElementByAccessibilityId("pbZOut");
	}

	public WebElement getDrawerButton() {
		return driver.findElementByAccessibilityId("pbDrawer");
	}

	public WebElement getCategoriesLabel() {
		return driver.findElementByAccessibilityId("lbCategories");
	}

	public WebElement getCategoryChoice(int index) {
		return driver.findElementByAccessibilityId("pbCategoryChoice"+index);
	}

	public WebElement getCategoryPreviousButton() {
		return driver.findElementByAccessibilityId("pbPrevTop");
	}

	public WebElement getCategoryNextButton() {
		return driver.findElementByAccessibilityId("pbNextTop");
	}

	public WebElement getCategoryPageNumberLabel() {
		return driver.findElementByAccessibilityId("lblCategoryPage");
	}

	public WebElement getPaymentSectionLabel() { // label for lower right section
		return driver.findElementByAccessibilityId("lblPointOfSalePayment");
	}

	public WebElement getPosChoice(int index) {
		return driver.findElementByAccessibilityId("pbPosChoice"+index);
	}

	public WebElement getPosChoicePreviousButton() {
		return driver.findElementByAccessibilityId("pbPrevBottom");
	}
	
	public WebElement getPosChoiceNextButton() {
		return driver.findElementByAccessibilityId("pbNextBottom");
	}
	
	public WebElement getPosChoicePageNumberLabel() {
		return driver.findElementByAccessibilityId("lblOptionsPage");
	}
	
	public WebElement getProductSearchLabel() {
		return driver.findElementByAccessibilityId("lblProductSearch");
	}
	
	public WebElement getProductSearchInputField() {
		return driver.findElementByAccessibilityId("txtSearchCategory");
	}
	
	public WebElement getProductSearchSearchButton() {
		return driver.findElementByAccessibilityId("pbSearchCategory");
	}
	
	public WebElement getSubTotalLabel() {
		return driver.findElementByAccessibilityId("lblSubTotal");
	}
	
	public WebElement getSubTotalAmount() {
		return driver.findElementByAccessibilityId("lblSubTotalAmount");
	}
	
	public WebElement getTaxesButton() {
		return driver.findElementByAccessibilityId("pbTaxes");
	}
	
	public WebElement getTaxesAmount() {
		return driver.findElementByAccessibilityId("lblTaxesAmount");
	}
	
	public WebElement getTotalLabel() {
		return driver.findElementByAccessibilityId("lblTotal");
	}
	
	public WebElement getTotalAmount() {
		return driver.findElementByAccessibilityId("lblTotalAmount");
	}
	
	public WebElement getHistoryButton() {
		return driver.findElementByAccessibilityId("pbHistory");
	}
	
	public WebElement getDiscountButton() {
		return driver.findElementByAccessibilityId("pbDiscount");
	}
	
	public WebElement getClearButton() {
		return driver.findElementByAccessibilityId("pbClear");
	}
	
	public WebElement getTotalButton() {
		return driver.findElementByAccessibilityId("pbTotal");
	}
	
	public WebElement getPaymentTotalDueLabel() {
		return driver.findElementByAccessibilityId("lblTotalDue");
	}
	
	public WebElement getPaymentTotalDueAmount() {
		return driver.findElementByAccessibilityId("lblTotalDueAmount");
	}
	
	public WebElement getPaymentRemainingLabel() {
		return driver.findElementByAccessibilityId("lblRemaining");
	}
	
	public WebElement getPaymentRemainingAmount() {
		return driver.findElementByAccessibilityId("lblRemainingAmount");
	}
	
	public WebElement getPrintReceiptCheckbox() {
		return driver.findElementByAccessibilityId("pbPrintReceiptCheck");
	}
	
	public WebElement getPrintReceiptLabel() {
		return driver.findElementByAccessibilityId("lblPrintReceipt");
	}
	
	public WebElement getEmailReceiptCheckbox() {
		return driver.findElementByAccessibilityId("pbEmailReceiptCheck");
	}
	
	public WebElement getEmailReceiptLabel() {
		return driver.findElementByAccessibilityId("lblEmailReceipt");
	}
	
	public WebElement getOKButton() {
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}

	public WebElement getMemberNameLabel() {
		return driver.findElementByAccessibilityId("lblMemberName");
	}
	
	public WebElement getMemberNameValue() {
		return driver.findElementByAccessibilityId("lblName");
	}
	
	public WebElement getMemberIDLabel() {
		return driver.findElementByAccessibilityId("lblMemberID");
	}
	
	public WebElement getMemberIDValue() {
		return driver.findElementByAccessibilityId("lblMemberBarcode");
	}
	
	public WebElement getMembershipTypeLabel() {
		return driver.findElementByAccessibilityId("MemberShipTypelbl");
	}
	
	public WebElement getMembershipTypeValue() {
		return driver.findElementByAccessibilityId("lblMembershipType");
	}
	
	public WebElement getMemberStatusLabel() {
		return driver.findElementByAccessibilityId("lblStatus");
	}
	
	public WebElement getMemberStatusValue() {
		return driver.findElementByAccessibilityId("lblMemberStatus");
	}
	
	public WebElement getMemberCurrentBalanceLabel() {
		return driver.findElementByAccessibilityId("lblAccountBal");
	}
	
	public WebElement getMemberCurrentBalanceValue() {
		return driver.findElementByAccessibilityId("lblBalanceDue");
	}
	
	public WebElement getMemberAddressLabel() {
		return driver.findElementByAccessibilityId("lblAddresses");
	}
	
	public WebElement getMemberAddressValue() {
		return driver.findElementByAccessibilityId("lblAddress");
	}
	
	public WebElement getMemberCityStateLabel() {
		return driver.findElementByAccessibilityId("lblCityState");
	}
	
	public WebElement getMemberCityStateValue() {
		return driver.findElementByAccessibilityId("lblMemberCityState");
	}
	
	public WebElement getMemberZipCodeLabel() {
		return driver.findElementByAccessibilityId("lblZip");
	}
	
	public WebElement getMemberZipCodeValue() {
		return driver.findElementByAccessibilityId("lblMemberZip");
	}
	
	public WebElement getMemberHomePhoneLabel() {
		return driver.findElementByAccessibilityId("lblHomePhone");
	}
	
	public WebElement getMemberHomePhoneValue() {
		return driver.findElementByAccessibilityId("lblPhone");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
