package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class CheckIn extends base {

	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");

		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
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

		Assert.assertTrue(ci.getCheckInModeLabel().isDisplayed());
		Assert.assertEquals(ci.getCheckInModeLabel().getText(), "Check In | Attended");
		Assert.assertTrue(ci.getMemberInputLabel().isDisplayed());
		Assert.assertEquals(ci.getMemberInputLabel().getText(), "Member ID / Last Name");
		Assert.assertTrue(ci.getMemberInputField().isEnabled());
		Assert.assertTrue(ci.getSearchButton().isEnabled());
		Assert.assertTrue(ci.getClearMemberButton().isEnabled());
		Assert.assertTrue(!ci.getTakePictureButton().isEnabled()); // disabled prior to adding member
		Assert.assertTrue(!ci.getMemberInfoButton().isEnabled()); // disabled prior to adding member
		Assert.assertTrue(!ci.getMemberNotesButton().isEnabled()); // disabled prior to adding member
		Assert.assertTrue(!ci.getChangeRequestButton().isEnabled()); // disabled prior to adding member
		Assert.assertTrue(ci.getTodaysCheckInsButton().isEnabled());
		Assert.assertTrue(ci.getCheckInModeButton().isEnabled());
		Assert.assertTrue(ci.getAddGuestButton().isEnabled());

	}

	@Test(priority = 3, enabled = true)
	public void searchMember() {

		ci.getMemberInputField().sendKeys("Manny");
		ci.getSearchButton().click();

		MyActions.myWait(30, "Member Quick Search");

		Assert.assertTrue(ms.getMemberSearchPageLocator().isDisplayed());
		ms.getOKButton().click();
	}

	@Test(priority = 4)
	public void clearMember() {

		ci.getMemberInputField().sendKeys("Manny");
		ci.getClearMemberButton().click();
		Assert.assertNotEquals(ci.getMemberInputField().getText(), "Manny");
	}

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
