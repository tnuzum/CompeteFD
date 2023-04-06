package functionalityTests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ItemDiscountPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import pageObjects.POS_EditItemPO;
import pageObjects.POS_PaymentAmountPO;
import pageObjects.POS_ProductSearchPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_TakePaymentPO;
import pageObjects.POS_TaxDetailPO;
import resources.MyActions;
import resources.base;

public class PurchaseInventoryItems extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	MemberSearchPO ms;
	POS_ProductSearchPO ps;
	POS_PaymentAmountPO pa;
	POS_TakePaymentPO tp;
	ItemDiscountPO id;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	String searchString;
	String item1BarcodeId;
	String item1DefaultPrice;
	String item2BarcodeId;
	String item2DefaultPrice;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();

		driver = initializeDriver();
		
		p = new POS_MainPagePO();
		la = new LandingPagePO();
		ei = new POS_EditItemPO();
		td = new POS_TaxDetailPO();
		ms = new MemberSearchPO();
		ps = new POS_ProductSearchPO();
		pa = new POS_PaymentAmountPO();
		tp = new POS_TakePaymentPO();
		id = new ItemDiscountPO();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";
		item1BarcodeId = prop.getProperty("item1BarcodeId");
		item1DefaultPrice = prop.getProperty("item1DefaultPrice");
		item2BarcodeId = prop.getProperty("item2BarcodeId");
		item2DefaultPrice = prop.getProperty("item2DefaultPrice");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getPOSButton().click();
		
	}
	
	@Test(testName = "Item Quantity Change")
	public void itemQuantityChange() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();

		p.getEditButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		ei.getQuantityInputField().sendKeys("5");
		
		ei.getUnitPriceInputField().sendKeys("1.00");
		
		ei.getTaxExemptCheckbox().click();

		ei.getOKButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(p.getTotalAmount().getText(), item1DefaultPrice);

		p.getTotalButton().click();

		p.getCategoryChoice(2).click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(pa.getAmountDueAmount().getText(), item1DefaultPrice);

		pa.getPayAmt20DollarsButton().click();

		p.getOKButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWaitByName(30, "Change Due");

		p.getOKButton().click();
	}

	@Test(testName = "Product Search")
	public void productSearch() {

		String searchString = "auto";
		
		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(searchString);

		p.getProductSearchSearchButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		MyActions.myWaitByAccessibilityId(30, "txtSearch");

		ps.getSearchInputField().sendKeys(searchString);

		ps.getSearchButton().click();

		Assert.assertEquals(ps.getSearchInputField().getText(), searchString);

		ps.getOKButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(p.getTotalAmount().getText(), item1DefaultPrice);

		p.getTotalButton().click();

		p.getCategoryChoice(2).click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(pa.getAmountDueAmount().getText(), item1DefaultPrice);

		pa.getPayAmt20DollarsButton().click();

		p.getOKButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWaitByName(30, "Change Due");

		p.getOKButton().click();
	}

	@Test(testName = "Purchase With Credit Card")
	public void purchaseWithCreditCard() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();
		
		Assert.assertEquals(p.getTotalAmount().getText(), item1DefaultPrice);

		p.getTotalButton().click();

		p.getCategoryChoice(1).click();

		MyActions.focusByNativeWindowHandleIndex(0);

		pa.getCCSwipeMessageCancelButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(pa.getCCChargeAmount().getText(), item1DefaultPrice);

		pa.getCCNumberInputField().sendKeys(prop.getProperty("changeCCMember1AccountNumber"));

		pa.getCCExpMonthDropdownButton().click();
		
		Actions a= new Actions(driver);
		a.moveToElement(pa.getCCExpMonthDropdownList(4)).click().build().perform();

		pa.getCCExpYearDropdownButton().click();

		a.moveToElement(pa.getCCExpYearDropdownList(3)).click().build().perform();

		pa.getCCZipInputField().sendKeys("43215");

		pa.getOKButton().click();

		p.getOKButton().click(); // Click Ok button on Change Due prompt
	}
	
	@Test(testName = "Multiple Items Purchased")
	public void multipleItemsPurchased() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();
		
		p.getProductSearchInputField().sendKeys(item2BarcodeId);

		p.getProductSearchSearchButton().click();
		
			double i1 = Double.parseDouble(item1DefaultPrice);
			double i2 = Double.parseDouble(item2DefaultPrice);
			double total = i1 + i2;
			
		Assert.assertEquals(p.getTotalAmount().getText(), total+"0"); // a 0 is appended to end because total returns 10.0

		p.getTotalButton().click();

		p.getCategoryChoice(2).click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(pa.getAmountDueAmount().getText(), total+"0");

		pa.getPayAmt20DollarsButton().click();

		p.getOKButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWaitByName(30, "Change Due");

		p.getOKButton().click();
	}
	
	@Test(testName = "Item Returned")
	public void itemReturned() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();
		
		p.getReturnButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getYesButton().click();
		
		p.getTotalButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getReturnReasonInputField().sendKeys("Automated testing in progress -- example return reason");
		
		p.getSubmitButton().click();
		
		Assert.assertEquals(p.getTotalDueAmount().getText(), "-"+item1DefaultPrice);
		
		MyActions.focusByNativeWindowHandleIndex(0);		

		p.getCategoryChoice(2).click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getOKButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getYesCashRefundButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWaitByName(30, "Change Due");
		
		Assert.assertEquals(p.getChangeDueAmount().getText(), "$"+item1DefaultPrice);

		p.getOKButton().click();
	}
	
	@Test(testName = "Item Discount")
	public void itemDiscount() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();
		
		Assert.assertEquals(p.getTotalAmount().getText(), item1DefaultPrice);
		
		p.getDiscountButton().click();
		
		id.getApplyToItemButton().click();
		
		Assert.assertTrue(!p.getTotalAmount().getText().equals(item1DefaultPrice)); // Assert price does not equal default price because of discount applied

		p.getTotalButton().click();

		p.getCategoryChoice(2).click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(!pa.getAmountDueAmount().getText().contains(item1DefaultPrice));

		pa.getPayAmt20DollarsButton().click();

		p.getOKButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWaitByName(30, "Change Due");

		p.getOKButton().click();
	}
	
	@Test(testName = "Invoice Discount")
	public void invoiceDiscount() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();
		
		Assert.assertEquals(p.getTotalAmount().getText(), item1DefaultPrice);
		
		p.getDiscountButton().click();
		
		id.getApplyToInvoiceButton().click();
		
		Assert.assertTrue(!p.getTotalAmount().getText().equals(item1DefaultPrice)); // Assert price does not equal default price because of discount applied

		p.getTotalButton().click();

		p.getCategoryChoice(2).click();

		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(!pa.getAmountDueAmount().getText().contains(item1DefaultPrice));

		pa.getPayAmt20DollarsButton().click();

		p.getOKButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWaitByName(30, "Change Due");

		p.getOKButton().click();
	}
	
	@Test(testName = "Clear Item")
	public void clearItem() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getProductSearchInputField().sendKeys(item1BarcodeId);

		p.getProductSearchSearchButton().click();
		
		Assert.assertEquals(p.getTotalAmount().getText(),item1DefaultPrice);
		
		p.getClearButton().click();
		
		Assert.assertEquals(p.getTotalAmount().getText(), "0.00");

	}

	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
