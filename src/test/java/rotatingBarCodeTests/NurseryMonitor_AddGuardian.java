package rotatingBarCodeTests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import pageObjects.NurseryPO;
import resources.MyActions;
import resources.base;

public class NurseryMonitor_AddGuardian extends base{
	
	LandingPagePO la;
	NurseryPO n;
	CheckInPO ci;
	MemberSearchPO ms;
	String barcodeId;
	String password;
	String token;
	String newToken;
	String expirationTimeSpan = "00:10:00";
	String tokenMemberId;
	String tokenGuardianId;
	
	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();

		la = new LandingPagePO();
		n = new NurseryPO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenGuardianId = prop.getProperty("tokenGuardianId");
		
		MyActions.loginEmployee(barcodeId, password);

		la.getMoreButton().click();
		la.getMoreButtons(7).click();
		
	}
	
	@Test(priority = 1)
	public void guardianSearchWithToken() throws IOException {
		
//		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
//		n.getMemberInputField().sendKeys(token);
		
//		n.getSearchButton().click();
		
//		MyActions.focusByNativeWindowHandleIndex(0);
				
//		Assert.assertTrue(n.getMemberId().getText().contains(tokenMemberId));
		
		n.getAddGuardianButton().click();
		
		token = MyActions.getToken(tokenGuardianId, expirationTimeSpan);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		n.getAddGuardianMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		Assert.assertTrue(n.getAddGuardianMemberInputField().getText().contains(tokenGuardianId));
		
		
		
	}
	@Test(priority = 2)
	public void guardianSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenGuardianId, expirationTimeSpan);
		
		n.getAddGuardianMemberInputField().clear();
		
		n.getAddGuardianMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		n.getWarningYesButton().click();
		

	}
	
		
	@Test(priority = 3)
	public void guardianSearchWithmodifiedToken() {
		
		newToken = "@544B4E123456@";
		
		n.getAddChildMemberInputField().clear();
		
		n.getAddGuardianMemberInputField().sendKeys(newToken);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "No Record Found.");
		
		n.getWarningYesButton().click();
				

	}
	
	@Test(priority = 4)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		newToken = MyActions.getToken(tokenGuardianId, veryShortExpirationTimeSpan);
		
		n.getAddGuardianMemberInputField().clear();
							
		n.getAddGuardianMemberInputField().sendKeys(newToken);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		
		n.getWarningYesButton().click();
		
		n.getAddGaurdianCancel().click();
					

	}
	

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
