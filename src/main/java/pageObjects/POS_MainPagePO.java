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
	
	public WebElement getYesButton() {
		return driver.findElementByAccessibilityId("pbButton1");
	}
	
	public WebElement getYesCashRefundButton() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getNoCashRefundButton() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	public WebElement getNoButton() {
		return driver.findElementByAccessibilityId("pbButton2");
	}
	
	public WebElement getReturnReasonInputField() {
		return driver.findElementByAccessibilityId("rtbReturnReason");
	}
	
	public WebElement getSubmitButton() {
		return driver.findElementByAccessibilityId("btnSubmit");
	}
	
	public WebElement getChangeDueAmount() {
		return driver.findElementByAccessibilityId("lblChange");
	}
	
	public WebElement getTotalDueAmount() {
		return driver.findElementByAccessibilityId("lblTotalDueAmount");
	}
	
	public WebElement getZOStartingBalanceLabel() {
		return driver.findElementByAccessibilityId("lblStartingBalance");
	}
	
	public WebElement getZOStartingBalanceAmout() {
		return driver.findElementByAccessibilityId("txtStartingBalance");
	}
	
	public WebElement getZOCashInDrawerLabel() {
		return driver.findElementByAccessibilityId("lblCash");
	}
	
	public WebElement getZOCashInDrawerAmout() {
		return driver.findElementByAccessibilityId("txtCash");
	}
	
	public WebElement getZOCashOutLabel() {
		return driver.findElementByAccessibilityId("lblCashOut");
	}
	
	public WebElement getZOCashOutAmout() {
		return driver.findElementByAccessibilityId("txtCashOut");
	}
	
	public WebElement getZOAmountLabel() {
		return driver.findElementByName("Amount");
	}
	
	public WebElement getZONotesLabel() {
		return driver.findElementByAccessibilityId("lblNote");
	}
	
	public WebElement getZONotesTextBox() {
		return driver.findElementByAccessibilityId("txtNotes");
	}
	
	public WebElement getZOCloseShiftLabel() {
		return driver.findElementByAccessibilityId("lblCloseShift");
	}
	
	public WebElement getZOCloseShiftCheckbox() {
		return driver.findElementByAccessibilityId("pbCloseShift");
	}	
	
	public WebElement getZOSendSettlementLabel() {
		return driver.findElementByAccessibilityId("lblSendSettlement");
	}
	
	public WebElement getZOSendSettlementCheckbox() {
		return driver.findElementByAccessibilityId("pbSendSettlement");
	}	
	
	public WebElement getZOHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getZOPrintButton() {
		return driver.findElementByAccessibilityId("pbPrint");
	}
	
	public WebElement getZODetailsButton() {
		return driver.findElementByAccessibilityId("pbDetails");
	}
	
	public WebElement getZOOkButton() {
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getZOCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getZOContinuePromptYesButton() { 
		return driver.findElementByAccessibilityId("pbButton1");
	}
	
	public WebElement getZOContinuePromptNoButton() {
		return driver.findElementByAccessibilityId("pbButton2");
	}
	
	public WebElement getCashDrawerSearchFromComboBox() {
		return driver.findElementByXPath("//ComboBox[@LocalizedControlType='combo box'][1]");
	}
	
	public WebElement getCashDrawerSearchToComboBox() {
		return driver.findElementByXPath("//ComboBox[@LocalizedControlType='combo box'][2]");
	}
	
	public WebElement getCashDrawerClubDropDownButton() {
		return driver.findElementByAccessibilityId("cboClubs");
	}
	
	public WebElement getCashDrawerSearchButton() {
		return driver.findElementByAccessibilityId("btnSearch");
	}
	
	public WebElement getCashDrawerStationHeader() {
		return driver.findElementByName("Station");
	}
	
	public WebElement getCashDrawerStationDescriptionHeader() {
		return driver.findElementByName("Station Description");
	}
	
	public WebElement getCashDrawerStationDateHeader() {
		return driver.findElementByName("Date");
	}
	
	public WebElement getCashDrawerStationTimeHeader() {
		return driver.findElementByName("Time");
	}
	
	public WebElement getCashDrawerStationEmployeeHeader() {
		return driver.findElementByName("Employee");
	}
	
	public WebElement getCashDrawerStationTotalIncomeHeader() {
		return driver.findElementByName("Total Income");
	}
	
	public WebElement getCashDrawerStationValue(int index){
		return driver.findElementByName("Station Row "+index+", Not sorted.");
	}
	
	public WebElement getCashDrawerStationDescriptionValue(int index){
		return driver.findElementByName("Station Description Row "+index+", Not sorted.");
	}
	
	public WebElement getCashDrawerDateValue(int index){
		return driver.findElementByName("Date Row "+index+", Sorted descending.");
	}
	
	public WebElement getCashDrawerTimeValue(int index){
		return driver.findElementByName("Time Row "+index+", Sorted descending.");
	}
	
	public WebElement getCashDrawerEmployeeValue(int index){
		return driver.findElementByName("Employee Row "+index+", Not sorted.");
	}
	
	public WebElement getCashDrawerTotalIncomeValue(int index){
		return driver.findElementByName("Total Income Row "+index+", Not sorted.");
	}
	
	public WebElement getCashDrawerChangeButton() {
		return driver.findElementByAccessibilityId("btnChange");
	}
	
	public WebElement getCashDrawerDeleteButton() {
		return driver.findElementByAccessibilityId("btnDelete");
	}
	
	public WebElement getCashDrawerZOutButton() {
		return driver.findElementByAccessibilityId("btnRunZOut");
	}
	
	public WebElement getCashDrawerHelpButton() {
		return driver.findElementByAccessibilityId("btnHelp");
	}	
	
	public WebElement getCashDrawerCloseButton() {
		return driver.findElementByAccessibilityId("btnClose");
	}
	
	public WebElement getHistoryTransactionDateLabel() {
		return driver.findElementByAccessibilityId("lblTransactionDate");
	}
	
	public WebElement getHistoryTransactionDateDropdown() {
		return driver.findElementByName("Text area");
	}
	
	public WebElement getHistoryTimeLabel() {
		return driver.findElementByAccessibilityId("lblTime");
	}
	
	public WebElement getHistoryDateValue(int index) {
		return driver.findElementByXPath("//*[@Name='Date']["+index+"]");
	}
	
	public WebElement getHistoryCustomerLabel() {
		return driver.findElementByAccessibilityId("lblCustomer");
	}
	
	public WebElement getHistoryCustomerName(int index) {
		return driver.findElementByXPath("//*[@Name='Customer']["+index+"]");
	}
	
	public WebElement getHistoryReceiptLabel() {
		return driver.findElementByAccessibilityId("lblReceipt");
	}
	
	public WebElement getHistoryReceiptNumber(int index) {
		return driver.findElementByXPath("//*[@Name='ReceiptNum']["+index+"]");
	}
	
	public WebElement getHistoryDetailsLabel() {
		return driver.findElementByAccessibilityId("lblDetails");
	}
	
	public WebElement getHistoryItemDescription(int index) {
		//return driver.findElementByName("Description");
		return driver.findElementByXPath("//*[@Name='Description']["+index+"]");
	}
	
	public WebElement getHistoryAmount(int index) {
		return driver.findElementByXPath("//*[@Name='Amount']["+index+"]");
	}
	
	public WebElement getHistoryQuantity(int index) {
		return driver.findElementByXPath("//*[@Name='Quantity']["+index+"]");
	}
	
	public WebElement getHistoryUnitCost(int index) {
		return driver.findElementByXPath("//*[@Name='Unit Cost']["+index+"]");
	}
	
	public WebElement getHistoryPrintButton() {
		return driver.findElementByAccessibilityId("pbPrint");
	}
	
	public WebElement getHistoryVoidButton() {
		return driver.findElementByAccessibilityId("pbVoid");
	}	
	
	public WebElement getHistoryCloseButton() {
		return driver.findElementByAccessibilityId("pbClose");
	}
	
	public WebElement getHistoryEmailButton() {
		return driver.findElementByAccessibilityId("pbEmail");
	}
	
	public WebElement getHistoryHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getHistoryThisStationCheckbox() {
		return driver.findElementByAccessibilityId("pbThisStationOnly");
	}
	
	public WebElement getHistoryThisStationLabel() {
		return driver.findElementByAccessibilityId("lblThisStationOnly");
	}
	
	public WebElement getHistoryTransactionUpButton() {
		return driver.findElementByAccessibilityId("pbUpInvoiceHeader");
	}
	
	public WebElement getHistoryTransactionDownButton() {
		return driver.findElementByAccessibilityId("pbDownInvoiceHeader");
	}	
	
	public WebElement getHistoryTransactionDetailsUpButton() {
		return driver.findElementByAccessibilityId("pbUpInvoiceDetails");
	}
	
	public WebElement getHistoryTransactionDetailsDownButton() {
		return driver.findElementByAccessibilityId("pbDownInvoiceDetails");
	}
	
	public WebElement getHistoryAttendantLabel() {
		return driver.findElementByAccessibilityId("lblAttendant");
	}
	
	public WebElement getHistoryAttendantName() {
		return driver.findElementByAccessibilityId("txtAttendant");
	}
	
	public WebElement getHistoryStationLabel() {
		return driver.findElementByAccessibilityId("lblStation");
	}
	
	public WebElement getHistoryStationNumber() {
		return driver.findElementByAccessibilityId("txtStationNo");
	}
	
	public WebElement getHistorySubtotalLabel() {
		return driver.findElementByAccessibilityId("lblSubtotal");
	}
	
	public WebElement getHistorySubtotalAmount() {
		return driver.findElementByAccessibilityId("txtSubtotal");
	}
	
	public WebElement getHistoryTaxLabel() {
		return driver.findElementByAccessibilityId("lblTax");
	}
	
	public WebElement getHistoryTaxAmount() {
		return driver.findElementByAccessibilityId("txtTax");
	}
	
	public WebElement getHistoryTotalLabel() {
		return driver.findElementByAccessibilityId("lblTotal");
	}
	
	public WebElement getHistoryTotalAmount() {
		return driver.findElementByAccessibilityId("txtTotal");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
