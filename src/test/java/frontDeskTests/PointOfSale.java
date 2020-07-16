package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import pageObjects.PaymentAmountPO;
import pageObjects.PointOfSalePO;
import pageObjects.TakePaymentPO;
import resources.MyActions;
import resources.base;

public class PointOfSale extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	PointOfSalePO p;
	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;
	PaymentAmountPO pa;
	TakePaymentPO tp;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	String searchString;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		p = new PointOfSalePO();
		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		pa = new PaymentAmountPO();
		tp = new TakePaymentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";
	}

	@Test(priority = 1, enabled = true)
	public void launchPOS() throws Exception{

		MyActions.loginEmployee(barcodeId, password);

			MyActions.myWait(30, "deckWorkspace1");

		la.getPOSButton().click();
		
		Assert.assertTrue(p.getPOSPageLabel().isDisplayed());

	}
	
	@Test(priority = 2, enabled = true)
	public void validatePageObjects() throws Exception{

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
		softAssertion.assertTrue(p.getCategoryChoice1().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice2().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice3().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice4().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice5().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice6().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice7().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice8().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice9().isEnabled());
		softAssertion.assertTrue(p.getCategoryChoice10().isEnabled());
		softAssertion.assertEquals(p.getCategoryPageNumberLabel().getText(), "1 / 3");
		softAssertion.assertEquals(p.getPaymentSectionLabel().getText(), "Point of Sale:  Fees");
		softAssertion.assertTrue(p.getPosChoice1().isEnabled());
		softAssertion.assertTrue(p.getPosChoice2().isEnabled());
		softAssertion.assertTrue(p.getPosChoice3().isEnabled());
		softAssertion.assertTrue(p.getPosChoice4().isEnabled());
		softAssertion.assertTrue(p.getPosChoice5().isEnabled());
		softAssertion.assertTrue(p.getPosChoice6().isEnabled());
		softAssertion.assertTrue(p.getPosChoice7().isEnabled());
		softAssertion.assertTrue(p.getPosChoice8().isEnabled());
		softAssertion.assertTrue(p.getPosChoice9().isEnabled());
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
	public void purchaseInventoryItem() throws InterruptedException {

		p.getPosChoice1().click();
		
		p.getTotalButton().click();
		
		p.getCategoryChoice2().click();

			MyActions.focusByNativeWindowHandleIndex(0);

		pa.getPayAmt5DollarsButton().click();
		
		p.getOKButton().click();
		
			Thread.sleep(2000); 
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getOKButton().click();
	}

	@Test(priority = 4, enabled = true)
	public void takePayment() throws InterruptedException {
		
			MyActions.focusByNativeWindowHandleIndex(0);

		ci.getMemberInputField().sendKeys(searchString);
		ci.getSearchButton().click();

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
	public void TearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
