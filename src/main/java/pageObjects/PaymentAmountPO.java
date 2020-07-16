package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class PaymentAmountPO extends base {

	// ** Constructor **
	public void POS(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
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
