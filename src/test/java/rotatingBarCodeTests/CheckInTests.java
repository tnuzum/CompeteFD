package rotatingBarCodeTests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class CheckInTests extends base{
	
	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;
	String barcodeId;
	String password;
	String token;
	String newToken;
	
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
		
		MyActions.loginEmployee(barcodeId, password);

		la.getCheckInButton().click();
		
	}
	
	@Test(priority = 1)
	public void memberCheckinWithToken() {
		
		token = MyActions.getToken(prop.getProperty("tokenMemberId"));
		
		ci.getMemberInputField().sendKeys(token);
		
		ci.getSearchButton().click();
				
		Assert.assertEquals(ci.getMemberId().getText(), prop.getProperty("tokenMemberId"));
		Assert.assertEquals(ci.getMembershipType().getText(), "Athletic");
		
		ci.getCheckInButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ci.getCheckInButton().click(); //button on Check-In Options page
		
	}
	@Test(priority = 2)
	public void memberSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(prop.getProperty("tokenMemberId"));
		
		ci.getMemberInputField().sendKeys(token);
		
		ci.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ci.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		ci.getWarningYesButton().click();
		

	}
	
	@Test(priority = 3)
	public void memberCheckinDecline() {
		
				
		ci.getMemberInputField().sendKeys(newToken);
		
		ci.getSearchButton().click();
				
		ci.getDeclineButton().click();
		
//No Record Found.
	}
	
	@Test(priority = 4)
	public void memberSearchWithmodifiedToken() {
		
		newToken = newToken+"1";
		
		ci.getMemberInputField().sendKeys(newToken);
		
		ci.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ci.getTextMsg().getText(), "No Record Found.");
		
		ci.getWarningYesButton().click();
		
		MyActions.myWaitByName(30, "Member Quick Search");

		Assert.assertTrue(ms.getPageLocator().isDisplayed());
		
		ms.getCancelButton().click();
		

	}

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
