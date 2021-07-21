package pageLayoutTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AgreementsPO;
import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.MemberMgmtPO;
import pageObjects.POS_EditItemPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_TaxDetailPO;
import resources.MyActions;
import resources.base;

public class MemberInfo_AgreementModify extends base{
	
	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	CheckInPO ci;
	MemberInfoPO mp;
	MemberMgmtPO mmp;
	AgreementsPO ap;
	
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	String searchString;
	
	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		la = new LandingPagePO();
		ci = new CheckInPO();
		ei = new POS_EditItemPO();
		td = new POS_TaxDetailPO();
		mp = new MemberInfoPO();
		mmp = new MemberMgmtPO();
		ap = new AgreementsPO();
				
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny, Cindy";
		
		MyActions.loginEmployee(barcodeId, password);
		
		la.getCheckInButton().click();
		
		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();
		
		Thread.sleep(1000);
		
		ci.getMemberInfoButton().click();
		
		Thread.sleep(1000);
	}
	@Test
	public void verifyModifyButtonNavigation() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getAgreements().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getModifyButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getContinueCancelYes().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(ap.getAgreementsPageHeaderLabel().getText().contains("Agreements"));
		
		ap.getCancelButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(ci.getCheckInModeLabel().getText().contains("Check In"));
	}
	
	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
