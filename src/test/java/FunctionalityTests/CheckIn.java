package FunctionalityTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class CheckIn extends base{
	
	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;
	String searchString;
	String barcodeId;
	String password;
	
	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();

		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";

		MyActions.loginEmployee(barcodeId, password);

		la.getCheckInButton().click();
		
	}
	
	@Test
	public void memberCheckIn() {

		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();

		MyActions.myWaitByName(30, "Member Quick Search");

		Assert.assertTrue(ms.getPageLocator().isDisplayed());
		
		ms.getOKButton().click();
		
		ci.getCheckInButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ci.getCheckInButton().click(); //button on Check-In Options page


	}

	@Test
	public void familyCheckIn() {
		
		MyActions.myWaitByAccessibilityId(30, "txtBarcode");

		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();

		MyActions.myWaitByName(30, "Member Quick Search");

		Assert.assertTrue(ms.getPageLocator().isDisplayed());
		
		ms.getOKButton().click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyActions.myWaitByAccessibilityId(30, "pbFamilyCheckIn");
		
		ci.getFamilyCheckInButton().click();
		
		ci.getCheckInAllFamilyButton().click();
		
		ci.getWarningYesButton().click();

	}

	@Test(enabled = false)
	public void checkInWithToken() {
	
		String t = MyActions.getToken("99959");
		
		ci.getMemberInputField().sendKeys(t);
		
		ci.getSearchButton().click();
		
		// !! assertion needed once feature is merged into Future2, currently only works in Future
	}
	
	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
