package rotatingBarCodeTests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import pageObjects.TanningPO;
import resources.MyActions;
import resources.base;

public class TanningTests extends base{
	
	LandingPagePO la;
	TanningPO t;
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
		t = new TanningPO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenProspectId = prop.getProperty("tokenProspectId");
		
		MyActions.loginEmployee(barcodeId, password);

		la.getMoreButton().click();
		la.getMoreButtons(11).click();
		
	}
	
	@Test(priority = 1)
	public void memberSearchWithToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		t.getMemberInputField().sendKeys(token);
		
		t.getSearchButton().click();
				
		Assert.assertTrue(t.getMemberInputField().getText().contains(tokenMemberId));
		t.getClearButton().click();
	
		
	}
	@Test(priority = 2)
	public void memberSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		t.getMemberInputField().sendKeys(token);
		
		t.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(t.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		t.getWarningYesButton().click();
		

	}
	
		
	@Test(priority = 3)
	public void memberSearchWithmodifiedToken() {
		
		newToken = "@544B4E123456@";
		
		t.getMemberInputField().sendKeys(newToken);
		
		t.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(t.getTextMsg().getText(), "No Record Found.");
		
		t.getWarningYesButton().click();
				

	}
	
	@Test(priority = 4)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		newToken = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
							
		t.getMemberInputField().sendKeys(newToken);
		
		t.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(t.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		t.getWarningYesButton().click();
		
		t.getClose().click();
		

	}
	

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
