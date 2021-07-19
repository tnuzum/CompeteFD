package pageLayoutTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountStatuPO;
import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.MemberMgmtPO;
import pageObjects.POS_EditItemPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_TaxDetailPO;
import resources.MyActions;
import resources.base;

public class MemberAccountStatusTests extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	CheckInPO ci;
	MemberInfoPO mp;
	MemberMgmtPO mmp;
	AccountStatuPO ap;
	
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	String searchString;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		la = new LandingPagePO();
		ci = new CheckInPO();
		ei = new POS_EditItemPO();
		td = new POS_TaxDetailPO();
		mp = new MemberInfoPO();
		mmp = new MemberMgmtPO();
		ap = new AccountStatuPO();
				
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny, Cindy";
		
		MyActions.loginEmployee(barcodeId, password);
		
		la.getCheckInButton().click();
		
		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();
		
		Thread.sleep(1000);
		
		ci.getMemberInfoButton().click();
		
		Thread.sleep(1000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getAccountStatus().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getMemberAccountSummaryView().isDisplayed());
	}

	@Test(priority = 1, enabled = true)
	public void validatePageObjects() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		softAssertion.assertTrue(ap.getPageLocator().isDisplayed());
		softAssertion.assertTrue(ap.getInvoicesButton().isEnabled());
		softAssertion.assertTrue(ap.getTakePaymentButton().isEnabled());
		softAssertion.assertTrue(ap.getAddInvoiceButton().isEnabled());
		softAssertion.assertTrue(ap.getCreditMemoButton().isEnabled());
		softAssertion.assertTrue(ap.getBIllingButton().isEnabled());
		softAssertion.assertTrue(ap.getAccountActivityButton().isEnabled());
		softAssertion.assertTrue(ap.getNegativePaymentButton().isEnabled());
		softAssertion.assertTrue(ap.getTransferAccountTransactionsButton().isEnabled());
		softAssertion.assertTrue(ap.getPrintButton().isEnabled());
		softAssertion.assertTrue(ap.getViewDetailButton().isEnabled());
//		softAssertion.assertTrue(ap.getCloseButton().isEnabled());
			
		softAssertion.assertAll();

		
	}
	
	@Test(priority = 2, enabled = true)
	public void navigateToAccountStatusView() {
		
		ap.getInvoicesButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(ap.getInvoicesView().isDisplayed());
				
		MyActions.focusByNativeWindowHandleIndex(0);
				
		System.out.println(ap.getCloseButtons().size());
		((WebElement) ap.getCloseButtons().get(1)).click();
	}
		
		@Test(priority = 3, enabled = true)
		public void navigateToPaymentsView() {
		
		ap.getPaymentsButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getMemberPaymentsView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		}
		
		@Test(priority = 4, enabled = true)
		public void navigateToTakePaymentView() {
		
		ap.getTakePaymentButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getTakepaymentView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		
		}
		
		@Test(priority = 5, enabled = true)
		public void navigateToAddInvoiceView() {
		
		ap.getAddInvoiceButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getAddInvoiceView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		
		}
		
		@Test(priority = 6, enabled = true)
		public void navigateToCreditMemoView() {
		
		ap.getCreditMemoButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getCreditMemoView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		
		}
		
		@Test(priority = 7, enabled = true)
		public void navigateToBillingView() {
		
		ap.getBIllingButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getBillingView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		}
		
		@Test(priority = 8, enabled = true)
		public void navigateToAccountActivityView() {
		
		ap.getAccountActivityButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getAccountActivityView().isDisplayed());
				
		ap.getAccountActivityCloseButton().click();
		}
		
		@Test(priority = 9, enabled = true)
		public void navigateToAddNegativePaymentView() {
		
		ap.getNegativePaymentButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getAddNegativePaymentView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		
		}
		
		@Test(priority = 10, enabled = true)
		public void navigateToTransferAccountTransactionsView() {
		
		ap.getTransferAccountTransactionsButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getTransferAccountTransferView().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(1)).click();
		
		}
		
		@Test(priority = 11, enabled = true)
		public void navigateToDetailsView() {
		
		ap.getViewDetailButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(ap.getMemberCharges().isDisplayed());
		
		((WebElement) ap.getCloseButtons().get(0)).click();
					
		mp.getCloseButton().click();
		
	}
		
	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
