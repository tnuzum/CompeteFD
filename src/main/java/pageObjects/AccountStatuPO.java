package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class AccountStatuPO extends base{
	
	// ** Constructor **
	
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
	// ** Objects **
	
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("MemberAccountSummaryView");
	}
	
	public WebElement getInvoicesButton() {
		return driver.findElementByAccessibilityId("btnInvoices");
	}
	
	public WebElement getPaymentsButton() {
		return driver.findElementByAccessibilityId("btnPayments");
	}
	
	public WebElement getTakePaymentButton() {
		return driver.findElementByAccessibilityId("btnGetPayment");
	}
	
	public WebElement getAddInvoiceButton() {
		return driver.findElementByAccessibilityId("btnAddInvoice");
	}
	
	public WebElement getCreditMemoButton() {
		return driver.findElementByAccessibilityId("btnCreditMemo");
	}
	
	public WebElement getBIllingButton() {
		return driver.findElementByAccessibilityId("btnBilling");
	}
	
	public WebElement getAccountActivityButton() {
		return driver.findElementByAccessibilityId("btnAccountActivity");
	}
	
	public WebElement getNegativePaymentButton() {
		return driver.findElementByAccessibilityId("btnNegativePayment");
	}
	
	public WebElement getTransferAccountTransactionsButton() {
		return driver.findElementByAccessibilityId("btnTransferAccountTransactions");
	}
	
	public WebElement getPrintButton() {
		return driver.findElementByAccessibilityId("btnPrint");
	}
	
	public WebElement getViewDetailButton() {
		return driver.findElementByAccessibilityId("btnDetails");
	}
	
	public List getCloseButtons() {
		return driver.findElementsByAccessibilityId("btnCancel");
	}
	
	public WebElement getInvoicesView() {
		return driver.findElementByAccessibilityId("InvoicesView");
	}
	
	public WebElement getMemberPaymentsView() {
		return driver.findElementByAccessibilityId("MemberPaymentsView");
	}
	
	public WebElement getTakepaymentView() {
		return driver.findElementByAccessibilityId("GetPaymentsDetailView");
	}
	
	public WebElement getAddInvoiceView() {
		return driver.findElementByAccessibilityId("AddInvoiceDetailsView");
	}
	
	public WebElement getCreditMemoView() {
		return driver.findElementByAccessibilityId("CreditMemoView");
	}
	
	public WebElement getBillingView() {
		return driver.findElementByAccessibilityId("BillingView");
	}
	
	public WebElement getAccountActivityView() {
		return driver.findElementByAccessibilityId("MemberAccountActivityView");
	}
	
	public WebElement getAccountActivityCloseButton() {
		return driver.findElementByAccessibilityId("btnClose");
	}
	
	public WebElement getAddNegativePaymentView() {
		return driver.findElementByAccessibilityId("GetPaymentsDetailView");
	}
	
	public WebElement getTransferAccountTransferView() {
		return driver.findElementByAccessibilityId("TransferAccountTransView");
	}
	
	public WebElement getMemberCharges() {
		return driver.findElementByAccessibilityId("gbCharges");
	}

}
