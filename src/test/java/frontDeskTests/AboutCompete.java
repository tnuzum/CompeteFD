package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

import pageObjects.AboutCompetePO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class AboutCompete extends base {

	LandingPagePO la;
	AboutCompetePO a;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {
		
		System.out.println("Test Class: "+getClass().getName());
		driver = initializeDriver();
		
		la = new LandingPagePO();
		a = new AboutCompetePO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(enabled = true)
	public void CompeteAboutView() throws Exception {

		MyActions.loginEmployee(barcodeId, password);

		MyActions.myWait(30, "deckWorkspace1");

		la.getCompeteInfoButton().click();

		Assert.assertTrue(a.getAboutPageLocator().isDisplayed());
		a.getCloseButton().click();
	}

	@AfterClass
	public void TearDown(){
		MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
