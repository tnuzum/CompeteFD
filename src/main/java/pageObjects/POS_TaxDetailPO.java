package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_TaxDetailPO extends base{
	
		// ** Constructor **
	public void getDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getEditItemPageLocator()
	{
		return driver.findElementByAccessibilityId("TaxDetailView");
	}
	
	public WebElement getTaxTypeHeader() {
		return driver.findElementByAccessibilityId("lblTaxType");
		//return driver.findElementByName("Tax Type");
	}
	
	public WebElement getPercentageHeader() {
		return driver.findElementByAccessibilityId("lblPercent");
	}

	public WebElement getTaxAmountHeader() {
		return driver.findElementByAccessibilityId("lblTax");
	}
	
	public WebElement getTaxDescription(int index) { // located inside of datagrid
		return driver.findElementByName("TaxDescription Row "+index+", Not sorted");
	}
	
	public WebElement getTaxRate(int index) { // located inside of datagrid
		return driver.findElementByName("TaxRate Row "+index+", Not sorted");
	}
	
	public WebElement getTaxAmountPerLine(int index) { // located inside of datagrid
		return driver.findElementByName("Total Row "+index+", Not sorted");
	}
	
	public WebElement getTaxTotal() {
		return driver.findElementByAccessibilityId("lblTaxTotal");
	}
	
	public WebElement getHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getCloseButton() {
		return driver.findElementByAccessibilityId("pbClose");
	}
	
	
	
	
	
	
	
	
	
	
	
}
