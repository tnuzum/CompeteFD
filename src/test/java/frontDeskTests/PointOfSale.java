package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LandingPagePO;
import pageObjects.PointOfSalePO;
import resources.MyActions;
import resources.base;

public class PointOfSale extends base {

	PointOfSalePO p;
	LandingPagePO la;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable{

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		p = new PointOfSalePO();
		la = new LandingPagePO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(priority = 1, enabled = true)
	public void launchPOS() throws Exception{

		MyActions.loginEmployee(barcodeId, password);

			MyActions.myWait(30, "deckWorkspace1");
		
		la.getPOSButton().click();

	}

	@Test(priority = 2, enabled = true)
	public void purchaseInventoryItem(){

		p.getPosChoice1().click();
		p.getTotalButton().click();
		p.getCategoryChoice2().click();

			MyActions.focusByNativeWindowHandleIndex(0);

		p.getPayAmt5DollarsButton().click();
		p.getOKButton().click();
			MyActions.focusByNativeWindowHandleIndex(0);
		p.getOKButton().click();
	}

	@AfterClass
	public void TearDown(){
			MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
