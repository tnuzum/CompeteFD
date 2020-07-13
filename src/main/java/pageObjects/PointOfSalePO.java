package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class PointOfSalePO extends base {

	// ** Constructor **
	public void POS(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	public WebElement getAboutPageLocator() {
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
		return driver.findElementByAccessibilityId("lblCategories");
	}

	public WebElement getCategoryChoice1() {
		return driver.findElementByAccessibilityId("pbCategoryChoice1");
	}

	public WebElement getCategoryChoice2() {
		return driver.findElementByAccessibilityId("pbCategoryChoice2");
	}

	public WebElement getCategoryChoice3() {
		return driver.findElementByAccessibilityId("pbCategoryChoice3");
	}

	public WebElement getCategoryChoice4() {
		return driver.findElementByAccessibilityId("pbCategoryChoice4");
	}

	public WebElement getCategoryChoice5() {
		return driver.findElementByAccessibilityId("pbCategoryChoice5");
	}

	public WebElement getCategoryChoice6() {
		return driver.findElementByAccessibilityId("pbCategoryChoice6");
	}

	public WebElement getCategoryChoice7() {
		return driver.findElementByAccessibilityId("pbCategoryChoice7");
	}

	public WebElement getCategoryChoice8() {
		return driver.findElementByAccessibilityId("pbCategoryChoice8");
	}

	public WebElement getCategoryChoice9() {
		return driver.findElementByAccessibilityId("pbCategoryChoice9");
	}

	public WebElement getCategoryChoice10() {
		return driver.findElementByAccessibilityId("pbCategoryChoice10");
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

	public WebElement getPosChoice1() {
		return driver.findElementByAccessibilityId("pbPosChoice1");
	}

	public WebElement getPosChoice2() {
		return driver.findElementByAccessibilityId("pbPosChoice2");
	}

	public WebElement getPosChoice3() {
		return driver.findElementByAccessibilityId("pbPosChoice3");
	}

	public WebElement getPosChoice4() {
		return driver.findElementByAccessibilityId("pbPosChoice4");
	}

	public WebElement getPosChoice5() {
		return driver.findElementByAccessibilityId("pbPosChoice5");
	}

	public WebElement getPosChoice6() {
		return driver.findElementByAccessibilityId("pbPosChoice6");
	}

	public WebElement getPosChoice7() {
		return driver.findElementByAccessibilityId("pbPosChoice7");
	}

	public WebElement getPosChoice8() {
		return driver.findElementByAccessibilityId("pbPosChoice8");
	}

	public WebElement getPosChoice9() {
		return driver.findElementByAccessibilityId("pbPosChoice9");
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
	
	public WebElement getPayAmtPageLocator() {
		return driver.findElementByName("Enter Payment Amount");
		//return driver.findElementByAccessibilityId("CashPaymentView");
	}
	
	public WebElement getPayAmt1Button() {
		return driver.findElementByAccessibilityId("pb1");
	}
	
	public WebElement getPayAmt2Button() {
		return driver.findElementByAccessibilityId("pb2");
	}
	
	public WebElement getPayAmt3Button() {
		return driver.findElementByAccessibilityId("pb3");
	}
	
	public WebElement getPayAmt4Button() {
		return driver.findElementByAccessibilityId("pb4");
	}
	
	public WebElement getPayAmt5Button() {
		return driver.findElementByAccessibilityId("pb5");
	}
	
	public WebElement getPayAmt6Button() {
		return driver.findElementByAccessibilityId("pb6");
	}
	
	public WebElement getPayAmt7Button() {
		return driver.findElementByAccessibilityId("pb7");
	}
	
	public WebElement getPayAmt8Button() {
		return driver.findElementByAccessibilityId("pb8");
	}
	
	public WebElement getPayAmt9Button() {
		return driver.findElementByAccessibilityId("pb9");
	}
	
	public WebElement getPayAmt0Button() {
		return driver.findElementByAccessibilityId("pb0");
	}
	
	public WebElement getPayAmtDecimalButton() {
		return driver.findElementByAccessibilityId("pbdp");
	}
	
	public WebElement getPayAmt1DollarButton() {
		return driver.findElementByAccessibilityId("pb1d");
	}
	
	public WebElement getPayAmt5DollarsButton() {
		return driver.findElementByAccessibilityId("pb5d");
	}
	
	public WebElement getPayAmt10DollarsButton() {
		return driver.findElementByAccessibilityId("pb10d");
	}
	
	public WebElement getPayAmt20DollarsButton() {
		return driver.findElementByAccessibilityId("pb20d");
	}
	
	public WebElement getBackspace() {
		return driver.findElementByAccessibilityId("pbBackspace");
	}
	
	public WebElement getClear() {
		return driver.findElementByAccessibilityId("pbClear");
	}
	
	public WebElement getChangeDueLabel() {
		return driver.findElementByAccessibilityId("lblChangeDue");
	}
	
	
	
	
	
	
	
	
}
