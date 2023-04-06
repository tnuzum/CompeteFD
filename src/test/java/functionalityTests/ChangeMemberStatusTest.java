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

public class ChangeMemberStatusTest extends base {

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
	private static String newStatus = "Terminate";
	private static String oldStatus = "OK";
	private static String status;
	private static String commentString = "Test";

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
	public void changeMemberStatus() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeStatus().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		int i = 0;
		
		do{status = mp.getStatusName(i).getText();
		
		if (status.equals(newStatus)) 
			
			mp.getStatusName(i).click();
		
		else i++;
			
		}
		while (!status.equals(newStatus));
						
		mp.getChangeStatusComment().sendKeys(commentString);;
		
		mp.getChangeStatusOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(newStatus, mp.getMemberStatus().getText());
		
	}
	
	@Test(priority = 2, enabled = true)
	public void changeMemberStatusBackToOriginal() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		mp.getChangeStatus().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		int i = 0;
		
		do{status = mp.getStatusName(i).getText();
		
		if (status.equals(oldStatus)) 
			
			mp.getStatusName(i).click();
		
		else i++;
			
		}
		while (!status.equals(oldStatus));
						
		mp.getChangeStatusComment().sendKeys(commentString);;
		
		mp.getChangeStatusOkButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
				
		Assert.assertEquals(oldStatus, mp.getMemberStatus().getText());
		
		mp.getCloseButton().click();
	}
		
	
	@AfterClass
	public void tearDown() {
		MyActions.focusByNativeWindowHandleIndex(0);

		driver.close();

		driver.quit();
	}

}
