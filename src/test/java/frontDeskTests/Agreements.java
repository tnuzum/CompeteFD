package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AgreementSearchPO;
import pageObjects.AgreementsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class Agreements extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

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
		
		MyActions.loginEmployee(barcodeId, password);

		la.getAgreementsButton().click();

	}

	@Test(priority = 1)
	public void validatePageObjects() {

		// Button text is not available for these buttons, so it is not possible to
		// assert that the text is correct

		softAssertion.assertEquals(a.getAgreementsPageHeaderLabel().getText(), "Agreements");
		softAssertion.assertTrue(a.getSearchAgreementsButton().isEnabled());
		softAssertion.assertTrue(a.getNewAgreementButton().isEnabled());
		softAssertion.assertTrue(a.getModifyAgreementButton().isEnabled());
		softAssertion.assertTrue(a.getRewriteAgreementButton().isEnabled());
		softAssertion.assertTrue(a.getRenewAgreementButton().isEnabled());
		softAssertion.assertTrue(a.getAddGuestButton().isEnabled());
		softAssertion.assertEquals(a.getSellClubLabel().getText(), "Sell Club");
		softAssertion.assertTrue(a.getSellClubComboBox().isEnabled());
		softAssertion.assertAll();
	}
	
	@Test(priority = 2)
	public void searchAgreements(){
		
		a.getSearchAgreementsButton().click();
		
			MyActions.myWaitByName(30, "Search Agreements");
			
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
