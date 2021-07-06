package rotatingBarCodeTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.AgreementSearchPO;
import pageObjects.AgreementsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class AgreementTests extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	AgreementsPO a;
	AgreementSearchPO as;
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
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenProspectId = prop.getProperty("tokenProspectId");

		la = new LandingPagePO();
		a = new AgreementsPO();
		as = new AgreementSearchPO();
		
		MyActions.loginEmployee(barcodeId, password);

		la.getAgreementsButton().click();

	}

	@Test(priority = 1)
	public void memberSearchWithToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		a.getNewAgreementButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		a.geSearchPlantOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		a.getMemberSearchCancel().click();
		
		a.getMemberInputField().sendKeys(token);
		
		a.getMemberSearchButton().click();
		
		Assert.assertEquals(tokenMemberId, a.getMemberInputField().getText());
		
		a.getMemberInputField().clear();

		
	}
	
	@Test(priority = 2)
	public void memberSearchWithExpiredToken(){
		
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		a.getMemberInputField().sendKeys(token);
		a.getMemberSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(a.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		a.getWarningYesButton().click();
			
	}
	
	@Test(priority = 3)
	public void memberSearchWithmodifiedToken() {
		
		newToken = "@544B4E123456@";
		
		a.getMemberInputField().sendKeys(newToken);
		a.getMemberSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(a.getTextMsg().getText(), "No Record Found.");
		
		a.getWarningYesButton().click();
				

	}
	
	@Test(priority = 4)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		newToken = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
						
		a.getMemberInputField().sendKeys(newToken);
		a.getMemberSearchButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(a.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		a.getWarningYesButton().click();


	}

	@AfterClass
	public void TearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}
