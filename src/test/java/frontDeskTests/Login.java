package frontDeskTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;
import resources.MyActions;
import resources.base;

public class Login extends base {

	static WindowsDriver driver;
	static String barcodeId;
	static String password;
	public LoginPO l;
	
	@BeforeTest
	public void initialize() throws Throwable {

		System.out.println("Class: "+getClass().getName());
		driver = initializeDriver();
		l = new LoginPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(priority = 1, description = "Validate Page Objects")
	public void ValidatePageObjects() {

		Assert.assertEquals(l.getUserNameLabel().getText(), "User ID");
		Assert.assertTrue(l.getUserNameInputField().isEnabled());

		Assert.assertEquals(l.getPasswordLabel().getText(), "Password");
		Assert.assertTrue(l.getPasswordInputField().isEnabled());

		Assert.assertTrue(l.getPromptCheckbox().isEnabled());
		Assert.assertTrue(!l.getPromptCheckbox().isSelected());
		Assert.assertEquals(l.getPromptLabel().getText(), "Prompt for password change");

		Assert.assertTrue(l.getLoginButton().isEnabled());
		Assert.assertTrue(l.getCancelButton().isEnabled());

	}

	@Test(priority = 2, description = "Validate Input Required Error Message")
	public void ValidateInputRequiredErrorMessage() {

		l.getLoginButton().click();

		Assert.assertTrue(!l.getLoginPageLocator().isEnabled()); // login page is disabled while box is open
		Assert.assertTrue(l.getErrorMessageBox().isDisplayed());
		Assert.assertTrue(l.getErrorMessages().getText().contains("Password is required"));
		Assert.assertTrue(l.getErrorMessages().getText().contains("User Id is required"));

		l.getErrorMessageOKButton().click();

		Assert.assertTrue(l.getLoginPageLocator().isEnabled()); // login page is enabled after box is closed

		try {
			Assert.assertTrue(l.getErrorMessageBox().isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

		}

	}

	@Test(priority = 3, description = "Validate Input Invalid Error Message")
	public void ValidateInputInvalidErrorMessage() {

		l.getUserNameInputField().sendKeys("99999");
		l.getPasswordInputField().sendKeys("99999");
		l.getLoginButton().click();

		Assert.assertTrue(!l.getLoginPageLocator().isEnabled()); // login page is disabled while box is open
		Assert.assertTrue(l.getErrorMessageBox().isDisplayed());
		Assert.assertTrue(l.getErrorMessages().getText().contains("Invalid User ID or Password"));

		l.getErrorMessageOKButton().click();

		Assert.assertTrue(l.getLoginPageLocator().isEnabled()); // login page is enabled after box is closed

		try {
			Assert.assertTrue(l.getErrorMessageBox().isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

		}
		l.getUserNameInputField().clear();
		l.getPasswordInputField().clear();

	}

	@Test(priority = 4, description = "Validate Successful Login")
	public void validateSuccessfulLogin() {

		MyActions.loginEmployee(barcodeId, password);

			LandingPagePO la = new LandingPagePO();

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		Assert.assertTrue(la.getLandingPageLocator().isDisplayed()); // Employee logged in; landing page displayed

		driver.findElementByName("Close").click();
	}

	@Test(priority = 5, description = "Validate Cancel Login")
	public void validateCancelLogin() throws Throwable {

			driver = initializeDriver();

		l.getUserNameInputField().sendKeys(barcodeId);
		l.getPasswordInputField().sendKeys(password);
		l.getCancelButton().click();

		try {
			Assert.assertTrue(l.getLoginPageLocator().isDisplayed()); // Employee not logged in; login page closed
		} catch (org.openqa.selenium.NoSuchElementException e) {

		}
	}

	
	@AfterTest()
	public void TearDown() {
		
//		** driver.close() not needed if last test is validateCancelLogin because that test closes that window
		
		driver.quit();
	}

}
