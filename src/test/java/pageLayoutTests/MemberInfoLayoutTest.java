package pageLayoutTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.POS_EditItemPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_TaxDetailPO;
import resources.MyActions;
import resources.base;

public class MemberInfoLayoutTest extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	CheckInPO ci;
	MemberInfoPO mp;
	
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
	public void validateButtonViews() {
		
		mp.getAccountStatus().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getMemberAccountSummaryView().isDisplayed());
		
		mp.getViewWindowClose1().click();
		
		mp.getCheckInHistory().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getMemberCheckInHistoryView().isDisplayed());
		
		mp.getViewWindowClose2().click();
		
		mp.getPersonalTraining().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getTrainingVisitHistoryView().isDisplayed());
		
		mp.getViewWindowClose2().click();
		
		mp.getBillingRelationship().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getBillingRelationshipView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		mp.getClassInformation().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getClassInformationView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		mp.getAppointments().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getAppointmentInformationView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		mp.getAgreements().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getManageAgreementView().isDisplayed());
		
		mp.getViewWindowClose1().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getViewWindowClose2().click();
		
		mp.getFamilyMember().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getFamilyMembersView().isDisplayed());
		
		mp.getViewWindowClose1().click();
		
		mp.getActionItems().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getActionItemsView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
//		mp.getMemberNotes().click();
//		
//		MyActions.focusByNativeWindowHandleIndex(0);
//		
//		softAssertion.assertTrue(mp.getMemberNotesView().isDisplayed());
//		
//		MyActions.focusByNativeWindowHandleIndex(0);
//		
//		mp.getViewWindowClose4().click();  // Selenium is thinking that the Close button is clicked but it is not being clicked. Therefore I commented this part
		
		mp.getManageDocuments().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getManageDocumentsView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		mp.getChangeRequestHistory().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getChangeRequestHistoryView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		mp.getEWaivers().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(mp.getManageEWaiverView().isDisplayed());
		
		mp.getViewWindowClose3().click();
		
		
		mp.getCloseButton().click();
		
		
	}

	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
