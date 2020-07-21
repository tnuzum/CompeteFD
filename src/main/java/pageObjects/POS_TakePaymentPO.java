package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_TakePaymentPO extends base {

	// ** Constructor **
	public void POS(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
	public WebElement getPageLocator() {
		return driver.findElementByName("GetPaymentsDetailView");
	}
	
	public WebElement getPaymentSectionLabel() {
		return driver.findElementByName("Payment");
	}
	
	public WebElement getAmountLabel() {
		return driver.findElementByAccessibilityId("lblAmount");
	}
	
	public WebElement getAmountInput() {
		return driver.findElementByAccessibilityId("txtAmount");
		//return driver.findElementByName("Text Area");
	}
	
	public WebElement getReferenceLabel() {
		return driver.findElementByAccessibilityId("lblReferenceNo");
	}
	
	public WebElement getReferenceInput() {
		return driver.findElementByAccessibilityId("txtReferenceNo");
	}
	
	public WebElement getEmployeeLabel() {
		return driver.findElementByAccessibilityId("lblEmployee");
	}
	
	public WebElement getEmployeeInput() {
		return driver.findElementByAccessibilityId("txtEmployeeBarcode");
	}
	
	public WebElement getEmployeeBrowseButton() {
		return driver.findElementByAccessibilityId("btnBrowseEmployee");
	}
	
	public WebElement getCashRadioButton() {
		return driver.findElementByAccessibilityId("rbtnCash");
	}
	
	public WebElement getCheckRadioButton() {
		return driver.findElementByAccessibilityId("rbtnCheck");
	}
	
	public WebElement getCreditCardRadioButton() {
		return driver.findElementByAccessibilityId("rbtnCharge");
	}
	
	public WebElement getGiftCardRadioButton() {
		return driver.findElementByAccessibilityId("rbtnGiftCard");
	}
	
	public WebElement getCustomFOP1RadioButton() {
		return driver.findElementByAccessibilityId("rbtnCustomFOP1");
	}
	
	public WebElement getCustomFOP2RadioButton() {
		return driver.findElementByAccessibilityId("rbtnCustomFOP2");
	}
	
	public WebElement getCustomFOP3RadioButton() {
		return driver.findElementByAccessibilityId("rbtnCustomFOP3");
	}
	
	public WebElement getEmailReceiptCheckbox() {
		return driver.findElementByAccessibilityId("cbEmailReciept");
	}
	
	public WebElement getPrintReceiptCheckbox() {
		return driver.findElementByAccessibilityId("cbPrintReciept");
	}
	
	public WebElement getAdvancedButton() {
		return driver.findElementByAccessibilityId("btnAdvance");
	}
	
	public WebElement getOKButton() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	public WebElement getConfirmPayMessage() {
		return driver.findElementByAccessibilityId("txtErrorMessages");
	}
	
	public WebElement getConfirmPayOKButton() {
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getConfirmPayCancelButton() {
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
