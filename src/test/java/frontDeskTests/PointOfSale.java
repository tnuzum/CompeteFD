package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class PointOfSale extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	MemberSearchPO ms;
	POS_ProductSearchPO ps;
	POS_PaymentAmountPO pa;
	POS_TakePaymentPO tp;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	String searchString;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		p = new POS_MainPagePO();
		la = new LandingPagePO();
		ei = new POS_EditItemPO();
		td = new POS_TaxDetailPO();
		ms = new MemberSearchPO();
		ps = new POS_ProductSearchPO();
		pa = new POS_PaymentAmountPO();
		tp = new POS_TakePaymentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";
	}

	@Test(priority = 1, enabled = true)
	public void launchPOS(){

		MyActions.loginEmployee(barcodeId, password);

		MyActions.myWait(30, "deckWorkspace1");

		la.getPOSButton().click();

		Assert.assertTrue(p.getPOSPageLabel().isDisplayed());

	}

	@Test(priority = 2, enabled = true)
	public void validatePageObjects() {

		softAssertion.assertEquals(p.getPOSPageLabel().getText(), "Point Of Sale");
		softAssertion.assertEquals(p.getMemberInputLabel().getText(), "Member ID / Last Name");
		softAssertion.assertTrue(p.getMemberInputField().isEnabled());
		softAssertion.assertTrue(p.getSearchButton().isEnabled());
		softAssertion.assertTrue(p.getTakePaymentButton().isEnabled());
		softAssertion.assertTrue(p.getClearMemberButton().isEnabled());
		softAssertion.assertEquals(p.getReceiptLabel().getText(), "Receipt");
		softAssertion.assertTrue(p.getReceiptDownButton().isEnabled());
		softAssertion.assertTrue(p.getReceiptUpButton().isEnabled());
		softAssertion.assertTrue(p.getSoldByButton().isEnabled());
		softAssertion.assertTrue(p.getEditButton().isEnabled());
		softAssertion.assertTrue(p.getReturnButton().isEnabled());
		softAssertion.assertTrue(p.getZOutButton().isEnabled());
		softAssertion.assertTrue(p.getDrawerButton().isEnabled());
		softAssertion.assertEquals(p.getCategoriesLabel().getText(), "Categories");
		softAssertion.assertTrue(p.getCategoryPreviousButton().isEnabled());
		softAssertion.assertTrue(p.getCategoryNextButton().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(1).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(2).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(3).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(4).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(5).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(6).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(7).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(8).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(9).isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice(10).isEnabled());
		softAssertion.assertEquals(p.getCategoryPageNumberLabel().getText(), "1 / 3");
		softAssertion.assertEquals(p.getPaymentSectionLabel().getText(), "Point of Sale:  Fees");
		softAssertion.assertTrue(p.getPosChoice(1).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(2).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(3).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(4).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(5).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(6).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(7).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(8).isEnabled());
		softAssertion.assertTrue(p.getPosChoice(9).isEnabled());
		softAssertion.assertTrue(p.getPosChoicePreviousButton().isEnabled());
		softAssertion.assertTrue(p.getPosChoiceNextButton().isEnabled());
		softAssertion.assertEquals(p.getPosChoicePageNumberLabel().getText(), "1 / 1");
		softAssertion.assertEquals(p.getProductSearchLabel().getText(), "Product Search");
		softAssertion.assertTrue(p.getProductSearchInputField().isEnabled());
		softAssertion.assertTrue(p.getProductSearchSearchButton().isEnabled());
		softAssertion.assertEquals(p.getSubTotalLabel().getText(), "Sub Total:");
		softAssertion.assertEquals(p.getSubTotalAmount().getText(), "0.00");
		softAssertion.assertTrue(p.getTaxesButton().isEnabled());
		softAssertion.assertEquals(p.getTaxesAmount().getText(), "0.00");
		softAssertion.assertEquals(p.getTotalLabel().getText(), "Total:");
		softAssertion.assertEquals(p.getTotalAmount().getText(), "0.00");
		softAssertion.assertTrue(p.getHistoryButton().isEnabled());
		softAssertion.assertTrue(p.getDiscountButton().isEnabled());
		softAssertion.assertTrue(p.getClearButton().isEnabled());
		softAssertion.assertTrue(p.getTotalButton().isEnabled());
		softAssertion.assertAll();

	}

	@Test(priority = 3, enabled = true)
	public void clearMember() {

		p.getMemberInputField().sendKeys(searchString);

		p.getSearchButton().click();

		MyActions.myWait(30, "Member Quick Search");

		ms.getOKButton().click();

		p.getClearMemberButton().click();

		Assert.assertNotEquals(p.getMemberInputField().getText(), searchString);
	}

	@Test(priority = 4, enabled = true)
	public void purchaseWithCash() {

		String searchString = "water";

		p.getProductSearchInputField().sendKeys(searchString);

		p.getProductSearchSearchButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		ps.getSearchInputField().sendKeys(searchString);

		ps.getSearchButton().click();

		Assert.assertEquals(ps.getSearchInputField().getText(), searchString);

		ps.getOKButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getTotalButton().click();

		p.getCategoryChoice(2).click();

		MyActions.focusByNativeWindowHandleIndex(0);

		pa.getPayAmt5DollarsButton().click();

		p.getOKButton().click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWait(30, "Change Due");

		p.getOKButton().click();
	}

	@Test(priority = 5, enabled = true)
	public void purchaseWithCreditCard() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getPosChoice(1).click();

		// Edit Item to match amount needed for CSIPay to approve transaction
		p.getEditButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		ei.getQuantityInputField().sendKeys("5");

		ei.getTaxExemptCheckbox().click();

		ei.getOKButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getTotalButton().click();

		p.getCategoryChoice(1).click();

		MyActions.focusByNativeWindowHandleIndex(0);

		pa.getCCSwipeMessageCancelButton().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		pa.getCCTypeDropdownButton().click();

		pa.getCCCardTypeDropdownList(3).click();

		pa.getCCNumberInputField().sendKeys(prop.getProperty("changeCCMember1AccountNumber"));

		pa.getCCExpMonthDropdownButton().click();

		pa.getCCExpMonthDropdownList(4).click();

		pa.getCCExpYearDropdownButton().click();

		pa.getCCExpYearDropdownList(3).click();

		pa.getCCZipInputField().sendKeys("43215");

		p.getOKButton().click();
		
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		MyActions.focusByNativeWindowHandleIndex(0);

		MyActions.myWait(30, "Change Due");

		p.getOKButton().click();
	}

	@Test(priority = 6, enabled = true)
	public void takePayment() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getMemberInputField().sendKeys(searchString);

		p.getSearchButton().click();

		MyActions.myWait(30, "Member Quick Search");

		ms.getOKButton().click();

		p.getTakePaymentButton().click();

		MyActions.myWait(30, "Payment");

		tp.getAmountInput().sendKeys("0.01");

		tp.getCashRadioButton().click();

		tp.getOKButton().click();

		tp.getConfirmPayOKButton().click();

	}

	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
