package rotatingBarCodeTests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.LockerManagementPO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class LockerManagementTests extends base{
	
	LandingPagePO la;
	LockerManagementPO lm;
	CheckInPO ci;
	MemberSearchPO ms;
	String barcodeId;
	String password;
	String token;
	String newToken;
	String expirationTimeSpan = "00:10:00";
	String tokenMemberId;
	String tokenProspectId;
	
	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();

		la = new LandingPagePO();
		lm = new LockerManagementPO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenProspectId = prop.getProperty("tokenProspectId");
		
		MyActions.loginEmployee(barcodeId, password);

		la.getMoreButton().click();
		la.getMoreButtons(6).click();
		
	}
	
	@Test(priority = 1)
	public void memberSearchWithToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		lm.getMemberInputField().sendKeys(token);
		
		lm.getSearchButton().click();
				
		Assert.assertTrue(lm.getMemberId().getText().contains(tokenMemberId));
		lm.getClose().click();
	
		
	}
	@Test(priority = 2)
	public void memberSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		lm.getMemberInputField().sendKeys(token);
		
		lm.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(lm.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		lm.getWarningYesButton().click();
		

	}
	
		
	@Test(priority = 3)
	public void memberSearchWithmodifiedToken() {
		
		newToken = "@544B4E123456@";
		
		lm.getMemberInputField().sendKeys(newToken);
		
		lm.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(lm.getTextMsg().getText(), "No Record Found.");
		
		lm.getWarningYesButton().click();
				

	}
	
	@Test(priority = 4)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		newToken = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
							
		lm.getMemberInputField().sendKeys(newToken);
		
		lm.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(lm.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		lm.getWarningYesButton().click();
		

	}
	

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
