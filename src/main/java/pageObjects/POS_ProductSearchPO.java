package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_ProductSearchPO extends base{
	
		// ** Constructor **
	public void getDriver(WindowsDriver driver) {
		base.driver = driver;
	}
	
		// ** Objects ** 
	public WebElement getPageLocator()
	{
		return driver.findElementByAccessibilityId("ProductSearchView");
	}
	
	public WebElement getSearchInputField() {
		return driver.findElementByAccessibilityId("txtSearch");
	}
	
	public WebElement getSearchByDropdownButton() {
		return driver.findElementByXPath("//Button[@Name='Open'][1]");
	}
	
	public WebElement getProductTypeDropdownButton() {
		return driver.findElementByXPath("//Button[@Name='Open'][2]");
	}
	
	public WebElement getListItem(int index){
		// *** This method is used to locate items in the 
		// Search By and Product Type drop down lists. ***
		return driver.findElementByXPath("//ListItem[@LocalizedControlType='list item']["+index+"]");
	}
	
	public WebElement getSearchButton() {
		return driver.findElementByAccessibilityId("pbSearch");
	}

	public WebElement getBarcodeHeader() {
		return driver.findElementByAccessibilityId("lblCategory");
	}
	
	public WebElement getDescriptionHeader() {
		return driver.findElementByAccessibilityId("lblDescription");
	}

	public WebElement getPriceHeader() {
		return driver.findElementByAccessibilityId("lblPrice");
	}
	
	public WebElement getResultBarcode(int index) {
		return driver.findElementByName("BarcodeID Row "+index+", Not sorted.");
	}
	
	public WebElement getResultDescription(int index) {
		return driver.findElementByName("Description Row "+index+", Sorted ascending.");
	}
	
	public WebElement getResultPrice(int index) {
		return driver.findElementByName("Price Row "+index+", Not sorted.");
	}
	
	public WebElement getUpArrowButton() {
		return driver.findElementByAccessibilityId("pbUp");
	}
	
	public WebElement getDownArrowButton() {
		return driver.findElementByAccessibilityId("pbDown");
	}

	public WebElement getHelpButton() {
		return driver.findElementByAccessibilityId("pbHelp");
	}
	
	public WebElement getOKButton() {
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getCancelButton() {
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	
	
	
	
	
	
	
	
	
	
}
