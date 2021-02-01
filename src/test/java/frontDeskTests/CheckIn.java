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
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";

		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		mi = new MemberInfoPO();
		
		MyActions.loginEmployee(barcodeId, password);

		la.getCheckInButton().click();
	}

	@Test(priority = 1, enabled = true)
	public void validatePageObjects() {

		// Button text is not available for these buttons, so it is not possible to
		// assert that the text is correct
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	@Test(priority = 4)
	public void clearMember() {

		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();

		MyActions.myWaitByName(30, "Member Quick Search");

		Assert.assertTrue(ms.getPageLocator().isDisplayed());
		
		ms.getOKButton().click();
		
		ci.getClearMemberButton().click();
		
		Assert.assertNotEquals(ci.getMemberInputField().getText(), searchString);
	}
	
	@Test(priority = 5, enabled = true)
	public void memberInfo(){
		
		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();
		
			MyActions.myWaitByName(30, "Member Quick Search");
			
		ms.getOKButton().click();

		ci.getMemberInfoButton().click();
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			
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
