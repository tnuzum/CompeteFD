package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class CheckIn extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;
	MemberInfoPO mi;
	String barcodeId;
	String password;
	String searchString;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";

		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		mi = new MemberInfoPO();
	}

	@Test(priority = 1, enabled = true)
	public void launchCheckIn() throws Exception {

		MyActions.loginEmployee(barcodeId, password);

		MyActions.myWait(30, "deckWorkspace1");

		la.getCheckInButton().click();

	}

	@Test(priority = 2)
	public void validatePageObjects() {

		// Button text is not available for these buttons, so it is not possible to
		// assert that the text is correct

		softAssertion.assertTrue(ci.getCheckInModeLabel().isDisplayed());
		softAssertion.assertEquals(ci.getCheckInModeLabel().getText(), "Check In | Attended");
		softAssertion.assertTrue(ci.getMemberInputLabel().isDisplayed());
		softAssertion.assertEquals(ci.getMemberInputLabel().getText(), "Member ID / Last Name");
		softAssertion.assertTrue(ci.getMemberInputField().isEnabled());
		softAssertion.assertTrue(ci.getSearchButton().isEnabled());
		softAssertion.assertTrue(ci.getClearMemberButton().isEnabled());
		softAssertion.assertTrue(!ci.getTakePictureButton().isEnabled()); // disabled prior to adding member
		softAssertion.assertTrue(!ci.getMemberInfoButton().isEnabled()); // disabled prior to adding member
		softAssertion.assertTrue(!ci.getMemberNotesButton().isEnabled()); // disabled prior to adding member
		softAssertion.assertTrue(!ci.getChangeRequestButton().isEnabled()); // disabled prior to adding member
		softAssertion.assertTrue(ci.getTodaysCheckInsButton().isEnabled());
		softAssertion.assertTrue(ci.getCheckInModeButton().isEnabled());
		softAssertion.assertTrue(ci.getAddGuestButton().isEnabled());
		softAssertion.assertAll();
	}

	@Test(priority = 3, enabled = true)
	public void searchMember() {

		ci.getMemberInputField().sendKeys(searchString);
		ci.getSearchButton().click();

		MyActions.myWait(30, "Member Quick Search");

		Assert.assertTrue(ms.getMemberSearchPageLocator().isDisplayed());
		ms.getOKButton().click();
	}

	@Test(priority = 4)
	public void clearMember() {

		ci.getMemberInputField().sendKeys(searchString);
		ci.getClearMemberButton().click();
		Assert.assertNotEquals(ci.getMemberInputField().getText(), searchString);
	}
	
	@Test(priority = 5)
	public void memberInfo() throws Exception {
		
		ci.getMemberInputField().sendKeys(searchString);
		ci.getSearchButton().click();
			MyActions.myWait(30, "Member Quick Search");
		ms.getOKButton().click();

		ci.getMemberInfoButton().click();
			Thread.sleep(2000);
			MyActions.focusByNativeWindowHandleIndex(0);
		Assert.assertTrue(mi.getMemberNameLabel().getText().contains(searchString));
		Assert.assertTrue(mi.getMemberPaneMemberNameValue().getText().contains(searchString));
		mi.getCloseButton().click();
	}

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
