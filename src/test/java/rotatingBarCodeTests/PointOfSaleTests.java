package rotatingBarCodeTests;

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

public class PointOfSaleTests extends base {

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
	String token;
	String newToken;

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

	@Test(priority = 1)
	public void searchMemberWithToken() {

		token = MyActions.getToken(prop.getProperty("tokenMemberId"));
		
		p.getMemberInputField().sendKeys(token);
		
		p.getSearchButton().click();

		Assert.assertEquals(p.getMemberIDValue().getText(), prop.getProperty("tokenMemberId"));

		p.getClearMemberButton().click();

		Assert.assertNotEquals(p.getMemberInputField().getText(), searchString);
	}

	@Test(priority = 2)
	public void TakePaymentWithToken() {
			

		MyActions.focusByNativeWindowHandleIndex(0);

		p.getMemberInputField().sendKeys(token);

		p.getSearchButton().click();
	
		p.getTakePaymentButton().click();

		MyActions.myWaitByName(30, "Payment");

		tp.getAmountInput().sendKeys("0.01");

		tp.getCashRadioButton().click();

		tp.getOKButton().click();

		tp.getConfirmPayOKButton().click();

	}
	
	@Test(priority = 3)
	public void memberSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(prop.getProperty("tokenMemberId"));
		
		p.getMemberInputField().sendKeys(token);

		p.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(p.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		p.getWarningYesButton().click();
		

	}
	
	@Test(priority = 4)
	public void memberSearchWithmodifiedToken() {
		
		newToken = newToken+"1";
		p.getMemberInputField().sendKeys(newToken);

		p.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(p.getTextMsg().getText(), "No Record Found.");
		
		p.getWarningYesButton().click();
		
		MyActions.myWaitByName(30, "Member Quick Search");

		Assert.assertTrue(ms.getPageLocator().isDisplayed());
		
		ms.getCancelButton().click();
		

	}

	
	
	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
