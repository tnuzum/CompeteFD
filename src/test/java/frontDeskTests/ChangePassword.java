package frontDeskTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ChangePasswordPO;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;
import resources.MyActions;
import resources.base;

public class ChangePassword extends base {

	public static SoftAssert softAssertion = new SoftAssert();

	ChangePasswordPO cp;
	LandingPagePO lp;
	LoginPO l;
	String natWinHandle;
	String nativeWindowHandle;
	static String barcodeId;
	static String password;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();

		barcodeId = prop.getProperty("changeEmployeeBarcodeId");
		password = prop.getProperty("changeEmployeePassword");

		cp = new ChangePasswordPO();
		lp = new LandingPagePO();
		l = new LoginPO();

	}

	@Test(priority = 1)
	public void launchChangePassword() throws Exception {

		l.getPromptCheckbox().click();

		l.getUserNameInputField().sendKeys(barcodeId);

		l.getPasswordInputField().sendKeys(password);

		l.getLoginButton().click();

		MyActions.myWaitByName(20, "Change Employee Password");

	}

	@Test(priority = 2)
	public void validatePageObjects() {

		softAssertion.assertEquals(cp.getNewPasswordlabel().getText(), "Please enter the new password value");
		softAssertion.assertTrue(cp.getNewPasswordInputField().isEnabled());
		softAssertion.assertEquals(cp.getConfirmPasswordlabel().getText(),"Please enter the password again for confirmation");
		softAssertion.assertTrue(cp.getNewPasswordInputField().isEnabled());
		softAssertion.assertTrue(cp.getHelpButton().isEnabled());
		softAssertion.assertTrue(cp.getOKButton().isEnabled());
		softAssertion.assertTrue(cp.getCancelButton().isEnabled());
		softAssertion.assertAll();
	}

	@Test(priority = 3)
	public void cancelChange() {

		cp.getCancelButton().click();

		MyActions.myWaitByName(30, "deckWorkspace1");

		MyActions.focusOnLandingPage();

		Assert.assertTrue(lp.getPageLocator().isDisplayed()); // Employee logged in; landing page displayed
	}

	@Test(priority = 2, enabled = false)
	// disabled because employee cannot use same password as previous 5 or any used
	// in last 6 months
	public void changePassword() {
		cp.getNewPasswordInputField().sendKeys(password);
		cp.getConfirmPasswordInputField().sendKeys(password);
		cp.getOKButton().click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		Assert.assertTrue(lp.getPageLocator().isDisplayed()); // Employee logged in; landing page displayed

	}

	@AfterClass()
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
