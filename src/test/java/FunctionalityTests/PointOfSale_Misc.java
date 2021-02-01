package FunctionalityTests;

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
import resources.ReusableDates;
import resources.base;

public class PointOfSale_Misc extends base {

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
	String item1BarcodeId;
	String barcodeId;
	String password;
	String searchString;

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
		
		item1BarcodeId = prop.getProperty("item1BarcodeId");
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";
		
		MyActions.loginEmployee(barcodeId, password);
		la.getPOSButton().click();
		
	}

	@Test
	public void ClearMember() {

		p.getMemberInputField().sendKeys(searchString);

		p.getSearchButton().click();

		MyActions.myWaitByName(30, "Member Quick Search");

		ms.getOKButton().click();

		p.getClearMemberButton().click();

		Assert.assertNotEquals(p.getMemberInputField().getText(), searchString);
	}

	@Test
	public void TakePayment() {

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getMemberInputField().sendKeys(searchString);

		p.getSearchButton().click();

		MyActions.myWaitByName(30, "Member Quick Search");

		ms.getOKButton().click();

		p.getTakePaymentButton().click();

		MyActions.myWaitByName(30, "Payment");

		tp.getAmountInput().sendKeys("0.01");

		tp.getCashRadioButton().click();

		tp.getOKButton().click();

		tp.getConfirmPayOKButton().click();

	}

	@Test
	public void ZOut() {
		
		p.getZOutButton().click();
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getZOOkButton().click();
		
		p.getZOContinuePromptYesButton().click();

		MyActions.purchaseItemWithCash(item1BarcodeId);
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getZOutButton().click();
		
			MyActions.focusByNativeWindowHandleIndex(0);

		Assert.assertEquals(p.getZOCashInDrawerAmout().getText(), "$        "+prop.getProperty("item1DefaultPrice"));
		
		p.getZOOkButton().click();
		
		p.getZOContinuePromptYesButton().click();
		
		p.getZOutButton().click();
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(p.getZOCashInDrawerAmout().getText(), "$        0.00");
		
		p.getZODetailsButton().click();

		Assert.assertEquals(p.getCashDrawerSearchFromComboBox().getText(), ReusableDates.getCurrentDateFormat3());
		Assert.assertEquals(p.getCashDrawerDateValue(0).getText(), ReusableDates.getCurrentDateFormat4());
		Assert.assertEquals(p.getCashDrawerTotalIncomeValue(0).getText(), "$"+prop.getProperty("item1DefaultPrice"));
			
		p.getCashDrawerCloseButton().click();
		
		p.getZOCancelButton().click();

	}
	
	@Test
	public void TransactionHistory() {
		
		MyActions.purchaseItemWithCash(item1BarcodeId);
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getHistoryButton().click();
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		try {
			Assert.assertEquals(p.getHistoryTransactionDateDropdown().getText(), ReusableDates.getCurrentDateFormat3());
			Assert.assertEquals(p.getHistoryItemDescription(1).getText(), prop.getProperty("item1Description"));
			Assert.assertEquals(p.getHistoryAmount(1).getText(), "$"+prop.getProperty("item1DefaultPrice"));
			Assert.assertEquals(p.getHistoryTotalAmount().getText(), "$"+prop.getProperty("item1DefaultPrice"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("[INFO] No Transaction History Found");
		}

		p.getHistoryCloseButton().click();

	}
	
	
	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
