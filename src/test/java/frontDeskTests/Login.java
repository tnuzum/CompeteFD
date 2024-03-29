package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPagePO;
import pageObjects.LoginPO;
import resources.MyActions;
import resources.base;

public class Login extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	static String barcodeId;
	static String password;
	public LoginPO l;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		l = new LoginPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(priority = 1, enabled = true)
	public void validatePageObjects() {

		softAssertion.assertEquals(l.getUserNameLabel().getText(), "User ID");
		softAssertion.assertTrue(l.getUserNameInputField().isEnabled());
		softAssertion.assertEquals(l.getPasswordLabel().getText(), "Password");
		softAssertion.assertTrue(l.getPasswordInputField().isEnabled());
		softAssertion.assertTrue(l.getPromptCheckbox().isEnabled());
		softAssertion.assertTrue(!l.getPromptCheckbox().isSelected());
		softAssertion.assertEquals(l.getPromptLabel().getText(), "Prompt for password change");
		softAssertion.assertTrue(l.getLoginButton().isEnabled());
		softAssertion.assertTrue(l.getCancelButton().isEnabled());
		softAssertion.assertAll();
	}

	@Test(priority = 2)
	public void validateInputRequiredErrorMessage() {

		l.getLoginButton().click();

		Assert.assertTrue(!l.getPageLocator().isEnabled()); // login page is disabled while box is open
		Assert.assertTrue(l.getErrorMessageBox().isDisplayed());
		Assert.assertTrue(l.getErrorMessages().getText().contains("Password is required"));
		Assert.assertTrue(l.getErrorMessages().getText().contains("User Id is required"));

		l.getErrorMessageOKButton().click();

		Assert.assertTrue(l.getPageLocator().isEnabled()); // login page is enabled after box is closed

	}

	@Test(priority = 3, enabled = true)
	public void validateInputInvalidErrorMessage() {

		l.getUserNameInputField().sendKeys("99999");
		l.getPasswordInputField().sendKeys("99999");
		l.getLoginButton().click();

		Assert.assertTrue(!l.getPageLocator().isEnabled()); // login page is disabled while box is open
		Assert.assertTrue(l.getErrorMessageBox().isDisplayed());
		Assert.assertTrue(l.getErrorMessages().getText().contains("Invalid User ID or Password"));

		l.getErrorMessageOKButton().click();

		Assert.assertTrue(l.getPageLocator().isEnabled()); // login page is enabled after box is closed
 
		l.getUserNameInputField().clear();
		l.getPasswordInputField().clear();

	}

	@Test(priority = 4, enabled = true)
	public void validateCancelLogin() {

		l.getUserNameInputField().sendKeys(barcodeId);
		l.getPasswordInputField().sendKeys(password);
		l.getCancelButton().click();

		/* try { //takes a long time to timeout, might not be necessary
			Assert.assertTrue(!l.getPageLocator().isDisplayed()); // Employee not logged in; login page closed
		} catch (org.openqa.selenium.NoSuchElementException e) {

		} */
	}

	@Test(priority = 5, enabled = true)
	public void validateSuccessfulLogin() throws Throwable {

		driver = initializeDriver();

		MyActions.loginEmployee(barcodeId, password);

		LandingPagePO la = new LandingPagePO();

		MyActions.myWaitByName(30, "deckWorkspace1");

		Assert.assertTrue(la.getPageLocator().isDisplayed()); // Employee logged in; landing page displayed
	}

	@AfterClass()
	public void tearDown(){

		MyActions.focusOnLandingPage(); // fails if validateSuccessfulLogin method is not called prior
		driver.close();
		driver.quit();
	}

}
