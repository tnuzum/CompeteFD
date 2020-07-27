package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_EditItemPO extends base{
	
		// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getEditItemPageLocator()
	{
		return driver.findElementByAccessibilityId("EditItemView");
	}
	
	public WebElement getProductLabel() {
		return driver.findElementByAccessibilityId("lblProduct");
		//return driver.findElementByName("Product");
	}
	
	public WebElement getProductNameInputField() {
		return driver.findElementByAccessibilityId("txtProduct");
	}
	
	public WebElement getQuantityLabel() {
		return driver.findElementByAccessibilityId("lblQuantity");
	}
	
	public WebElement getQuantityInputField() {
		return driver.findElementByAccessibilityId("txtQuantity");
	}
	
	public WebElement getQuantityDownButton() {
		return driver.findElementByAccessibilityId("pbQuantityDown");
	}
	
	public WebElement getQuantityUpButton() {
		return driver.findElementByAccessibilityId("pbQuantityUp");
	}
	
	public WebElement getUnitPriceLabel() {
		return driver.findElementByAccessibilityId("lblUnitPrice");
	}
	
	public WebElement getUnitPriceInputField() {
		return driver.findElementByAccessibilityId("txtUnitPrice");
	}
	
	public WebElement getAmountLabel() {
		return driver.findElementByAccessibilityId("lblAmount");
	}
	
	public WebElement getAmountInputField() {
		return driver.findElementByAccessibilityId("txtAmount");
	}
	
	public WebElement getPricingMethodLabel() { // returns text "Pricing based on Membership discount"
		return driver.findElementByAccessibilityId("txtPricingMethod");
	}
	
	public WebElement getTaxExemptCheckbox() {
		return driver.findElementByAccessibilityId("pbIsTaxExempt");
	}
	
	public WebElement getTaxExemptLabel() {
		return driver.findElementByAccessibilityId("lblTaxExempt");
	}
	
	public WebElement getHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getRemoveItemButton() {
		return driver.findElementByAccessibilityId("pbRemoveItem");
	}
	
	public WebElement getOKButton() {
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
