package functionalityTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberInfoPO;
import pageObjects.POS_EditItemPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_TaxDetailPO;
import resources.MyActions;
import resources.base;

public class ChangeMemberIdTest extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	POS_MainPagePO p;
	POS_EditItemPO ei;
	POS_TaxDetailPO td;
	LandingPagePO la;
	CheckInPO ci;
	MemberInfoPO mp;
	
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
				
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Auto, Corefmember1";
		
		MyActions.loginEmployee(barcodeId, password);
		
		la.getCheckInButton().click();
		
		ci.getMemberInputField().sendKeys(searchString);
		
		ci.getSearchButton().click();
		
		Thread.sleep(1000);
		
		ci.getMemberInfoButton().click();
		
		Thread.sleep(1000);
	}

	@Test(priority = 1, enabled = true)
	public void changeMemberId() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeMemberId().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getNewMemberIdField().clear();
		
		mp.getNewMemberIdField().sendKeys("Auto, Corefmember1");
		
		mp.getOkButon().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeMemberIdOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeMemberIdOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getCancelEmailButton().click();
		
		Assert.assertEquals("Auto, Corefmember1", mp.getMemberId().getText());
		
	}
	
	@Test(priority = 2, enabled = true)
	public void changeMemberIdBackToOriginal() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeMemberId().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getNewMemberIdField().clear();
		
		mp.getNewMemberIdField().sendKeys("1142552");
		
		mp.getOkButon().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeMemberIdOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeMemberIdOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getCancelEmailButton().click();
		
		Assert.assertEquals("1142552", mp.getMemberId().getText());
		
		mp.getCloseButton().click();
	}
		
	
	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
