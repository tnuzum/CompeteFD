package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import pageObjects.PaymentAmountPO;
import pageObjects.PointOfSalePO;
import pageObjects.TakePaymentPO;
import resources.MyActions;
import resources.base;

public class PointOfSale extends base {

	PointOfSalePO p;
	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;
	PaymentAmountPO pa;
	TakePaymentPO tp;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	String searchString;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		p = new PointOfSalePO();
		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
		pa = new PaymentAmountPO();
		tp = new TakePaymentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";
	}

	@Test(priority = 1, enabled = true)
	public void launchPOS() throws Exception{

		MyActions.loginEmployee(barcodeId, password);

			MyActions.myWait(30, "deckWorkspace1");

		la.getPOSButton().click();

	}

	@Test(priority = 2, enabled = true)
	public void purchaseInventoryItem() {

		p.getPosChoice1().click();
		
		p.getTotalButton().click();
		
		p.getCategoryChoice2().click();

			MyActions.focusByNativeWindowHandleIndex(0);

		pa.getPayAmt5DollarsButton().click();
		
		p.getOKButton().click();
		
			MyActions.focusByNativeWindowHandleIndex(0);
		
		p.getOKButton().click();
	}

	@Test(priority = 3)
	public void takePayment() {
		
			MyActions.focusByNativeWindowHandleIndex(0);

		ci.getMemberInputField().sendKeys(searchString);
		ci.getSearchButton().click();

			MyActions.myWait(30, "Member Quick Search");

		ms.getOKButton().click();

		p.getTakePaymentButton().click();

		tp.getAmountInput().sendKeys("0.01");

		tp.getCashRadioButton().click();

		tp.getOKButton().click();

		tp.getConfirmPayOKButton().click();

	}

	@AfterClass
	public void TearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
