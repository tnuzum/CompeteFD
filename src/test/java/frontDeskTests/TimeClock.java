package frontDeskTests;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPagePO;
import pageObjects.TimeClockPO;
import resources.MyActions;
import resources.ReusableDates;
import resources.base;

public class TimeClock extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	TimeClockPO tc;
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
		tc = new TimeClockPO();
	
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(1).click();

	}

	@Test(priority = 1, enabled = true)
	public void validateTimeClockPageObjects() {
		
		String cd = ReusableDates.getCurrentDateFormat2();

		softAssertion.assertEquals(tc.getUserIDLabel().getText(), "User ID");
		softAssertion.assertTrue(tc.getUserIDInputField().isDisplayed());
		softAssertion.assertEquals(tc.getPasswordLabel().getText(), "Password");
		softAssertion.assertTrue(tc.getPasswordInputField().isDisplayed());
		softAssertion.assertEquals(tc.getCurrentDateLabel().getText(), "Current Date");
		softAssertion.assertEquals(tc.getCurrentDateValue().getText(), cd);
		softAssertion.assertEquals(tc.getCurrentTimeLabel().getText(), "Current Time");
		softAssertion.assertTrue(tc.getCurrentDateValue().isDisplayed());
		softAssertion.assertTrue(tc.getManagerOverrideButton().isEnabled());
		softAssertion.assertTrue(tc.getInButton().isEnabled());
		softAssertion.assertTrue(tc.getOutButton().isEnabled());
		softAssertion.assertTrue(tc.getCancelButton().isEnabled());
		softAssertion.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void validateManagerOverridePageObjects() {
		
		tc.getManagerOverrideButton().click();
		
		String cd = ReusableDates.getCurrentDateFormat3();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		softAssertion.assertEquals(tc.getManagerUserIDLabel().getText(), "Manager User ID");
		softAssertion.assertTrue(tc.getManagerUserIDInputField().isDisplayed());
		softAssertion.assertEquals(tc.getManagerPasswordLabel().getText(), "Manager Password");
		softAssertion.assertTrue(tc.getManagerPasswordInputField().isDisplayed());
		softAssertion.assertEquals(tc.getEmployeeUserIDLabel().getText(), "Employee User ID");
		softAssertion.assertTrue(tc.getEmployeeUserIDInputField().isEnabled());
		softAssertion.assertTrue(tc.getSearchButton().isEnabled());
		softAssertion.assertEquals(tc.getManagerOverrideDateLabel().getText(), "Date");
		softAssertion.assertEquals(tc.getManagerOverrideDateCombobox().getText(), cd);
		softAssertion.assertEquals(tc.getManagerOverrideTimeLabel().getText(), "Time");
		softAssertion.assertTrue(tc.getManagerOverrideDateCombobox().isDisplayed());
		softAssertion.assertTrue(tc.getInButton().isEnabled());
		softAssertion.assertTrue(tc.getOutButton().isEnabled());
		softAssertion.assertTrue(tc.getCancelButton().isEnabled());
		softAssertion.assertAll();
		
		tc.getManagerOverrideCancelButton().click(); // return to Time Clock
	}
	
	@Test(priority = 3, enabled = true)
	public void clockIn() {
		
		String cd = ReusableDates.getCurrentDateFormat2();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		tc.getUserIDInputField().sendKeys(barcodeId);
		
		tc.getPasswordInputField().sendKeys(password);
		
		tc.getInButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(tc.getConfirmationMessage().getText().contains("IN at "+cd));
		
		tc.getConfirmationOKButton().click();
	}
	
	@Test(priority = 4, enabled = false)
	public void clockINError() {
		
		la.getMoreButton().click();
		
		la.getMoreButtons(1).click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		tc.getUserIDInputField().sendKeys(barcodeId);
		
		tc.getPasswordInputField().sendKeys(password);
		
		tc.getInButton().click();
		
		tc.getConfirmationOKButton().click();
		
		Assert.assertTrue(tc.getErrorMessage().getText().contains(""));
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		tc.getErrorMessageOkButton().click();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		tc.getCancelButton().click();
	}
	
	
	@Test(priority = 5, enabled = true)
	public void clockOut() {
		
		String cd = ReusableDates.getCurrentDateFormat2();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		la.getMoreButton().click();
		
		la.getMoreButtons(1).click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		tc.getUserIDInputField().sendKeys(barcodeId);
		
		tc.getPasswordInputField().sendKeys(password);
		
		tc.getOutButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(tc.getConfirmationMessage().getText().contains("OUT at "+cd));
		
		tc.getConfirmationOKButton().click();
		
		
	}

	@AfterClass
	public void TearDown() {
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		driver.close();
		
		driver.quit();
	}

}
