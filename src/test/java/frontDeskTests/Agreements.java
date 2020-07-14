package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AgreementSearchPO;
import pageObjects.AgreementsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class Agreements extends base {

	LandingPagePO la;
	AgreementsPO a;
	AgreementSearchPO as;
	String barcodeId;
	String password;
	String searchString;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		searchString = "Manny";

		la = new LandingPagePO();
		a = new AgreementsPO();
		as = new AgreementSearchPO();
	}

	@Test(priority = 1, enabled = true)
	public void launchAgreements() throws Exception {

		MyActions.loginEmployee(barcodeId, password);

		MyActions.myWait(30, "deckWorkspace1");

		la.getAgreementsButton().click();

	}

	@Test(priority = 2)
	public void validatePageObjects() {

		// Button text is not available for these buttons, so it is not possible to
		// assert that the text is correct

		Assert.assertEquals(a.getAgreementsPageHeaderLabel().getText(), "Agreements");
		Assert.assertTrue(a.getSearchAgreementsButton().isEnabled());
		Assert.assertTrue(a.getNewAgreementButton().isEnabled());
		Assert.assertTrue(a.getModifyAgreementButton().isEnabled());
		Assert.assertTrue(a.getRewriteAgreementButton().isEnabled());
		Assert.assertTrue(a.getRenewAgreementButton().isEnabled());
		Assert.assertTrue(a.getAddGuestButton().isEnabled());
		Assert.assertEquals(a.getSellClubLabel().getText(), "Sell Club");
		Assert.assertTrue(a.getSellClubComboBox().isEnabled());

	}
	
	@Test(priority = 3)
	public void searchAgreements() throws InterruptedException, Exception {
		
		a.getSearchAgreementsButton().click();
		
			MyActions.myWait(30, "Search Agreements");
			
		as.getQSSearchAgreementsInput().sendKeys(searchString);
		
		as.getQSSearchButton().click();
		
		as.getQSOKButton().click();

		a.getCloseButton().click();
		
	}

	@AfterClass
	public void TearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}
