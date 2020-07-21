package pageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class POS_PaymentAmountPO extends base {

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

	public WebElement getCCSwipeMessageCancelButton() {
		return driver.findElementByName("pbCancel");
	}
	
	public WebElement getCCChargeLabelLine1() { //returns text "Charge"
		return driver.findElementByAccessibilityId("lblChargeAmount");
	}
	
	public WebElement getCCChargeLabelLine2() { //returns text "Amount"
		return driver.findElementByAccessibilityId("lblAmount");
	}
	
	public WebElement getCCChargeAmount() {
		return driver.findElementByAccessibilityId("txtChargeAmount");
	}
	
	public WebElement getCCTypeLabelLine1() { // returns text "Card"
		return driver.findElementByAccessibilityId("lblCCType");
	}
	
	public WebElement getCCTypeLabelLine2() { // returns text "Type"
		return driver.findElementByAccessibilityId("lblType");
	}
	
	public WebElement getCCTypeDropdownButton() {
		return driver.findElementByName("pbCardType");
	}
	
	public WebElement getCCCardTypeDropdownList(int index) {
		// must call getCCDropdownButton() method first so this element is visible
		return driver.findElementByXPath("//ListItem[@LocalizedControlType='list item']["+index+"]");
	}
	
	public WebElement getCCNumberLabelLine1() { // returns text "Card"
		return driver.findElementByAccessibilityId("lblCard");
	}
	
	public WebElement getCCNumberLabelLine2() { // returns text "Number"
		return driver.findElementByAccessibilityId("lblNumber");
	}
	
	public WebElement getCCNumberInputField() {
		return driver.findElementByAccessibilityId("InputBox");
	}
	
	public WebElement getCCExpLabelLine1() { // returns text "Expiration"
		return driver.findElementByAccessibilityId("lblExpiration");
	}
	
	public WebElement getCCExpLabelLine2() { // returns text "Date"
		return driver.findElementByAccessibilityId("lblDate"); 
	}
	
	public WebElement getCCExpMonthDropdownButton() {
		return driver.findElementByAccessibilityId("pbExpMonth");
	}	
	
	public WebElement getCCExpMonthDropdownList(int index) {
		// must call getCCExpMonthDropdownButton() method first so this element is visible
		return driver.findElementByXPath("//ListItem[@LocalizedControlType='list item']["+index+"]");
	}
	
	public WebElement getCCExpYearDropdownButton() {
		return driver.findElementByAccessibilityId("pbExpYear");
	}
	
	public WebElement getCCExpYearDropdownList(int index) {
		// must call getCCExpYearDropdownButton() method first so this element is visible
		return driver.findElementByXPath("//ListItem[@LocalizedControlType='list item']["+index+"]");
	}
	
	public WebElement getCCZipLabel() {
		return driver.findElementByAccessibilityId("lblZipCode");
	}
	
	public WebElement getCCZipInputField() {
		return driver.findElementByAccessibilityId("txtZip");
	}
	
	public WebElement getCCSwipCardButton() {
		return driver.findElementByAccessibilityId("pbSwipeCard");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
