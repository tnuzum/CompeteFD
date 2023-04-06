package rotatingBarCodeTests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ClassEnrollmentPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class ClassEnrollmentTests extends base{
	
	LandingPagePO la;
	ClassEnrollmentPO ce;
	MemberSearchPO ms;
	String barcodeId;
	String password;
	static String classToEnroll;
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
		ce = new ClassEnrollmentPO();
		ms = new MemberSearchPO();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		classToEnroll = prop.getProperty("classToEnroll");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenProspectId = prop.getProperty("tokenProspectId");
		
		MyActions.loginEmployee(barcodeId, password);

		la.getMoreButton().click();
		la.getMoreButtons(8).click();
		
	}
	
	@Test(priority = 1)
	public void memberSearchWithToken() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		MyActions.myWaitByAccessibilityId(30, "pbClearButton");
		
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
				
		Assert.assertEquals(ce.getMemberInputField().getText(), tokenMemberId);
				
		ce.getClassSearchInputField().sendKeys(classToEnroll);
		
		int i = 0;
		 String classCourseName;
		
		do {classCourseName =  ce.getClassCourseName(i).getText();
		
		if (classCourseName.equals(classToEnroll))
			ce.getClassCourseName(i).click();
		else
			i++;
		}
		while(!classCourseName.equals(classToEnroll));
		
		ce.getEnrollButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getOkButton().click();
		ce.getNoButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ce.getSendEmailOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getWarningOkBtn().click();
				
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getCloseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ce.getUnenrollButton().click();
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getMsgUnenrollButton().click();
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getSendEmailOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getWarningOkBtn().click();
				
		
	}
	@Test(priority = 2)
	public void memberSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ce.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		ce.getWarningOkBtn().click();
		

	}
	
	@Test(priority = 3)
	public void memberSearchClear() {
		
				
		ce.getMemberInputField().sendKeys(newToken);
		
		ce.getSearchButton().click();
				
		ce.getClearButton().click();
		
		Assert.assertNotEquals(ce.getMemberInputField().getText(), tokenMemberId);
		

	}
	
	@Test(priority = 4)
	public void memberSearchWithmodifiedToken() {
		
		token = "@544B4E123456@";
		

		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ce.getTextMsg().getText(), "No Record Found.");
		ce.getWarningOkBtn().click();
		
		
	}
	
	@Test(priority = 5)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		token = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
						
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ce.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		ce.getWarningOkBtn().click();
		

	}
	
	@Test(priority = 6)
	public void prospectSearchWithToken() {
					
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		token = MyActions.getToken(tokenProspectId, expirationTimeSpan);
		
		MyActions.myWaitByAccessibilityId(30, "pbClearButton");
		
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
				
		Assert.assertEquals(ce.getMemberInputField().getText(), tokenProspectId);
				
		ce.getClassSearchInputField().sendKeys(classToEnroll);
		
		int i = 0;
		 String classCourseName;
		
		do {classCourseName =  ce.getClassCourseName(i).getText();
		
		if (classCourseName.equals(classToEnroll))
			ce.getClassCourseName(i).click();
		else
			i++;
		}
		while(!classCourseName.equals(classToEnroll));
		
		ce.getEnrollButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getOkButton().click();
		ce.getNoButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ce.getSendEmailOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getWarningOkBtn().click();
			
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getCloseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ce.getUnenrollButton().click();
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getMsgUnenrollButton().click();
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getSendEmailOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getWarningOkBtn().click();
	}
	
	@Test(priority = 7)
	public void prospectSearchWithExpiredToken() {
		
		newToken = MyActions.getToken(tokenProspectId, expirationTimeSpan);
		
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ce.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		ce.getWarningOkBtn().click();
		

	}
	
	@Test(priority = 8)
	public void prospectSearchClear() {
		
				
		ce.getMemberInputField().sendKeys(newToken);
		
		ce.getSearchButton().click();
				
		ce.getClearButton().click();
		
		Assert.assertNotEquals(ce.getMemberInputField().getText(), tokenProspectId);

	}
	
	@Test(priority = 9)
	public void prospectSearchWithmodifiedToken() {
		
		token = "@544B4E123456@";
		
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ce.getTextMsg().getText(), "No Record Found.");
		ce.getWarningOkBtn().click();
		
		
	}
	
	@Test(priority = 10)
	public void validateExpirationWorksForProspect() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
						
		token = MyActions.getToken(tokenProspectId, veryShortExpirationTimeSpan);
						
		ce.getMemberInputField().sendKeys(token);
		ce.getSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(ce.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		ce.getWarningOkBtn().click();
		
		ce.getCloseButton().click();
		

	}

	@AfterClass
	public void TearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
