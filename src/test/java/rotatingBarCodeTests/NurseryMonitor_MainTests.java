package rotatingBarCodeTests;


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

public class NurseryMonitor_MainTests extends base{
	
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
	String tokenChildId;
	
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
		tokenChildId = prop.getProperty("tokenChildId");
		
		MyActions.loginEmployee(barcodeId, password);

		la.getMoreButton().click();
		la.getMoreButtons(7).click();
		
	}
	
	@Test(priority = 1)
	public void memberSearchWithToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		n.getMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertTrue(n.getMemberId().getText().contains(tokenMemberId));
		n.getCloseButton().click();
	
		
	}
	@Test(priority = 2)
	public void memberSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		n.getMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		n.getWarningYesButton().click();
		

	}
	
		
	@Test(priority = 3)
	public void memberSearchWithmodifiedToken() {
		
		newToken = "@544B4E123456@";
		
		n.getMemberInputField().sendKeys(newToken);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "No Record Found.");
		
		n.getWarningYesButton().click();
				

	}
	
	@Test(priority = 4)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		newToken = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
							
		n.getMemberInputField().sendKeys(newToken);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		n.getWarningYesButton().click();
		

	}
	
	@Test(priority = 5)
	public void childSearchWithToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		n.getMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertTrue(n.getMemberId().getText().contains(tokenMemberId));
		
		n.getAddChildButton().click();
		
		token = MyActions.getToken(tokenChildId, expirationTimeSpan);
		
		n.getAddChildMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		Assert.assertTrue(n.getAddChildMemberInputField().getText().contains(tokenChildId));
		
		
		
	}
	@Test(priority = 6)
	public void childSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenChildId, expirationTimeSpan);
		
		n.getAddChildMemberInputField().clear();
		
		n.getAddChildMemberInputField().sendKeys(token);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		n.getWarningYesButton().click();
		

	}
	
		
	@Test(priority = 7)
	public void childSearchWithmodifiedToken() {
		
		newToken = "@544B4E123456@";
		
		n.getAddChildMemberInputField().clear();
		
		n.getAddChildMemberInputField().sendKeys(newToken);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "No Record Found.");
		
		n.getWarningYesButton().click();
				

	}
	
	@Test(priority = 8)
	public void validateExpirationWorksForChildSearch() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		newToken = MyActions.getToken(tokenChildId, veryShortExpirationTimeSpan);
		
		n.getAddChildMemberInputField().clear();
							
		n.getAddChildMemberInputField().sendKeys(newToken);
		
		n.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(n.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		
		n.getWarningYesButton().click();
		
		n.getCloseButton().click();
		
		n.getAddChildCancel().click();
		
		n.getCloseButton().click();
		

	}
	

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
