package pageLayoutTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.MemberMgmtPO;
import pageObjects.POS_EditItemPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_TaxDetailPO;
import resources.MyActions;
import resources.base;

public class MemberInfoLayoutAndNavigationTest extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	CheckInPO ci;
	MemberInfoPO mp;
	MemberMgmtPO mmp;
	
	
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
	}

	@Test(priority = 1, enabled = true)
	public void validatePageObjects() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		softAssertion.assertTrue(mp.getPageLocator().isDisplayed());
		softAssertion.assertEquals(mp.getMemberNameLabel().getText(), "Manny, Cindy");
		softAssertion.assertEquals(mp.getMemberPaneMemberNameValue().getText(), "Manny, Cindy");
		softAssertion.assertEquals(mp.getMembershipType().getText(), "Corporate Member");
		softAssertion.assertTrue(mp.getChangeMemberId().isEnabled());
		softAssertion.assertTrue(mp.getChangeStatus().isEnabled());
		softAssertion.assertTrue(mp.getTakePicture().isEnabled());
		softAssertion.assertTrue(mp.getMemberNotes().isEnabled());
		softAssertion.assertTrue(mp.getManageDocuments().isEnabled());
		softAssertion.assertTrue(mp.getEWaivers().isEnabled());
		softAssertion.assertTrue(mp.getChangeRequestHistory().isEnabled());
		softAssertion.assertTrue(mp.getAccountStatus().isEnabled());
		softAssertion.assertTrue(mp.getCheckInHistory().isEnabled());
		softAssertion.assertTrue(mp.getPersonalTraining().isEnabled());
		softAssertion.assertTrue(mp.getBillingRelationship().isEnabled());
		softAssertion.assertTrue(mp.getClassInformation().isEnabled());
		softAssertion.assertTrue(mp.getAppointments().isEnabled());
		softAssertion.assertTrue(mp.getAgreements().isEnabled());
		softAssertion.assertTrue(mp.getFamilyMember().isEnabled());
		softAssertion.assertTrue(mp.getActionItems().isEnabled());
		softAssertion.assertFalse(mp.getBiometrics().isEnabled());
		softAssertion.assertTrue(mp.getCloseButton().isEnabled());
		
		softAssertion.assertAll();

		
	}
	
	@Test(priority = 2, enabled = true)
	public void navigateToAccountStatus() {
		
		mp.getAccountStatus().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getMemberAccountSummaryView().isDisplayed());
		
		mp.getViewWindowClose1().click();
	}
		
		@Test(priority = 3, enabled = true)
		public void navigateToCheckInHistory() {
		
		mp.getCheckInHistory().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getMemberCheckInHistoryView().isDisplayed());
		
		mp.getViewWindowClose2().click();
		}
		
		@Test(priority = 4, enabled = true)
		public void navigateToPersonalTraining() {
		
		mp.getPersonalTraining().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getTrainingVisitHistoryView().isDisplayed());
		
		Assert.assertTrue(mp.getPTRemainingPanel().isDisplayed());
		
		mp.getPTHistoryTab().click();
		
		Assert.assertTrue(mp.getPTHistoryPanel().isDisplayed());
		
		mp.getVisitisRemainingTab().click();
		
		Assert.assertTrue(mp.getVisitisRemainingPanel().isDisplayed());
		
		mp.getVisitsHistoryTab().click();
		
		Assert.assertTrue(mp.getVisitisHistoryPanel().isDisplayed());
		
		mp.getViewWindowClose2().click();
		
		}
		
		@Test(priority = 5, enabled = true)
		public void navigateToBillingRelationship() {
		
		mp.getBillingRelationship().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getBillingRelationshipView().isDisplayed());
		
		Assert.assertTrue(mp.getFamilyMembersPanel().isDisplayed());
		
		mp.getOrganizationalMembersTab().click();
		
		Assert.assertTrue(mp.getOrganizationalMembersPanel().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		}
		
		@Test(priority = 6, enabled = true)
		public void navigateToClasses() {
		
		mp.getClassInformation().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getClassInformationView().isDisplayed());
		
		Assert.assertTrue(mp.getAttendancePanel().isDisplayed());
		
		mp.getEnrollmentab().click();
		
		Assert.assertTrue(mp.getEnrollmenPanel().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		}
		
		@Test(priority = 7, enabled = true)
		public void navigateToAppointments() {
		
		mp.getAppointments().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getAppointmentInformationView().isDisplayed());
		
		Assert.assertTrue(mp.getCurrentViewPanel().isDisplayed());
		
		mp.getHistoryTab().click();
		
		Assert.assertTrue(mp.getHistoryPanel().isDisplayed());
		
		mp.getViewWindowClose3().click();
		}
		
		@Test(priority = 8, enabled = true)
		public void navigateToAgreements() {
		
		mp.getAgreements().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getManageAgreementView().isDisplayed());
		Assert.assertTrue(mp.getHelpButton().isDisplayed());
		Assert.assertTrue(mp.getInvoicesButton().isDisplayed());
		Assert.assertTrue(mp.getModifyButton().isDisplayed());
		Assert.assertTrue(mp.getRewriteButton().isDisplayed());
		Assert.assertTrue(mp.getRenewButton().isDisplayed());
		
		mp.getViewWindowClose1().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getViewWindowClose2().click();
		}
		
		@Test(priority = 9, enabled = true)
		public void navigateToFamilyMember() {
		
		mp.getFamilyMember().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getFamilyMembersView().isDisplayed());
		
		mp.getViewWindowClose1().click();
		
		}
		
		@Test(priority = 10, enabled = true)
		public void navigateToActionItems() {
		
		mp.getActionItems().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getActionItemsView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		}
		
		@Test(priority = 11, enabled = false)
		public void navigateToMemberNotes() {
		
		mp.getMemberNotes().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getMemberNotesView().isDisplayed());
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getViewWindowClose4().click();  // Selenium is thinking that the Close button is clicked but it is not being clicked. Therefore I commented this part
		
		}
		
		@Test(priority = 12, enabled = true)
		public void navigateToManageDocuments() {
		
		mp.getManageDocuments().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getManageDocumentsView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		}
		
		@Test(priority = 13, enabled = true)
		public void navigateToChangeRequestHistory() {
		
		mp.getChangeRequestHistory().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getChangeRequestHistoryView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		}
		
		@Test(priority = 14, enabled = true)
		public void navigateToeWaivers() {
		
		mp.getEWaivers().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(mp.getManageEWaiverView().isDisplayed());
		
		Assert.assertTrue(mp.getCurrentEWaiverPanel().isDisplayed());
		
		mp.getEWaiverHistoryTab().click();
		
		Assert.assertTrue(mp.getEWaiverHistoryPanel().isDisplayed());
		
		mp.getViewWindowClose3().click();
			
		mp.getCloseButton().click();
		
	}
		@Test(priority = 15, enabled = true, description = "Access Member Info page from More drop down")
		public void accessMemberInfoFromMore() throws InterruptedException {
			
			MyActions.focusByNativeWindowHandleIndex(0);
			
			la.getMoreButton().click();
			la.getMoreButtons(9).click();
			mmp.getMemberInputField().sendKeys(searchString);
			mmp.getSearchButton().click();
			mmp.getMemberInfoButton().click();
			Thread.sleep(2000);
			
			MyActions.focusByNativeWindowHandleIndex(0);
			Assert.assertTrue(mmp.getPageLocator().isDisplayed());
			mp.getCloseButton().click();
		}

	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
