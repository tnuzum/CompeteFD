package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class ItemDiscountPO extends base {

	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("DiscountView");
	}

	public WebElement getDiscountHeader() {
		return driver.findElementByAccessibilityId("lblDiscount");
	}

	public WebElement getPercentHeader() {
		return driver.findElementByName("Percent");
	}
	
	public WebElement getDiscountDescription(int index) {
		return driver.findElementByName("Description Row "+index+", Not sorted.");
	}
	
	public WebElement getDiscountPercent(int index) {
		return driver.findElementByName("Percent Row "+index+", Not sorted.");
	}
	
	public WebElement getUpButton() {
		return driver.findElementByAccessibilityId("pbUp");
	}
	
	public WebElement getDownButton() {
		return driver.findElementByAccessibilityId("pbDown");
	}
	
	public WebElement getHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getApplyToItemButton() {
		return driver.findElementByAccessibilityId("pbApplyToItem");
	}
	
	public WebElement getApplyToInvoiceButton() {
		return driver.findElementByAccessibilityId("pbApplyToInvoice");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}


}
