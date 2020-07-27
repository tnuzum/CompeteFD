package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.MemberMgmtPO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class MemberMgmt extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	MemberMgmtPO mm;
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
		mm = new MemberMgmtPO();
		ms = new MemberSearchPO();
		mi = new MemberInfoPO();
	}

	@Test(priority = 1, enabled = true)
	public void launchCheckIn() throws Exception {

		MyActions.loginEmployee(barcodeId, password);

		MyActions.myWait(30, "deckWorkspace1");

		la.getMoreButton().click();
		
		la.getMoreButtons(9).click();
		
		Assert.assertTrue(mm.getMemberMgmtLabel().isDisplayed());

	}

	@Test(priority = 2)
	public void validatePageObjects() {

		// Button text is not available for these buttons, so it is not possible to
		// assert that the text is correct

		softAssertion.assertTrue(mm.getMemberMgmtLabel().isDisplayed());
		softAssertion.assertEquals(mm.getMemberMgmtLabel().getText(), "Member Management");
		softAssertion.assertTrue(mm.getMemberInputLabel().isDisplayed());
		softAssertion.assertEquals(mm.getMemberInputLabel().getText(), "Member ID / Last Name");
		softAssertion.assertTrue(mm.getMemberInputField().isEnabled());
		softAssertion.assertTrue(mm.getSearchButton().isEnabled());
		softAssertion.assertTrue(mm.getMemberInfoButton().isEnabled()); // disabled prior to adding member
		softAssertion.assertTrue(mm.getChangeRequestButton().isEnabled()); // disabled prior to adding member

		softAssertion.assertAll();
	}

	@Test(priority = 3, enabled = true)
	public void searchMember() {

		mm.getMemberInputField().sendKeys(searchString);
		mm.getSearchButton().click();

		MyActions.myWait(30, "Member Quick Search");

		Assert.assertTrue(ms.getPageLocator().isDisplayed());
		ms.getOKButton().click();
	}

	@Test(priority = 4, enabled = true)
	public void clearMember() {

		mm.getCancelButton().click();
		Assert.assertNotEquals(mm.getMemberInputField().getText(), searchString);
	}
	
	@Test(priority = 5)
	public void memberInfo() throws Exception {
		
		mm.getMemberInputField().sendKeys(searchString);
		mm.getSearchButton().click();
			MyActions.myWait(30, "Member Quick Search");
		ms.getOKButton().click();

		mm.getMemberInfoButton().click();
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
