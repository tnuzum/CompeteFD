package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class POSPO{
	
	WindowsDriver driver;
		// ** Constructor **
	public POSPO(WindowsDriver driver) {
		this.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getAboutPageLocator()
	{
		return driver.findElementByAccessibilityId("PointOfSaleMainView");
	}
	
	public WebElement getPointOfSaleLabel() {
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
	
	
	
	
	
	
	
	
	
	
}
