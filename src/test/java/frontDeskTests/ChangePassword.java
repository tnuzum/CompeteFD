package frontDeskTests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.ChangePasswordPO;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;
import resources.MyActions;
import resources.base;

public class ChangePassword extends base {

	String natWinHandle;
	String nativeWindowHandle;
	static String barcodeId;
	static String password;

	@BeforeTest
	public void initialize() throws Throwable {

		driver = initializeDriver();

		barcodeId = prop.getProperty("changeEmployeeBarcodeId");
		password = prop.getProperty("changeEmployeePassword");

		LoginPO l = new LoginPO(driver);

		l.getPromptCheckbox().click();

		l.getUserNameInputField().sendKeys(barcodeId);
		l.getPasswordInputField().sendKeys(password);
		l.getLoginButton().click();

	}

	@Test(priority = 1, description = "Validate Page Objects")
	public void ValidatePageObjects() throws Exception{

		ChangePasswordPO cp = new ChangePasswordPO(driver);

		Assert.assertEquals(cp.getNewPasswordlabel().getText(), "Please enter the new password value");
		Assert.assertTrue(cp.getNewPasswordInputField().isEnabled());
		Assert.assertEquals(cp.getConfirmPasswordlabel().getText(), "Please enter the password again for confirmation");
		Assert.assertTrue(cp.getNewPasswordInputField().isEnabled());
		Assert.assertTrue(cp.getHelpButton().isEnabled());
		Assert.assertTrue(cp.getOKButton().isEnabled());
		Assert.assertTrue(cp.getCancelButton().isEnabled());
		
		cp.getCancelButton().click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));
		
		LandingPagePO la = new LandingPagePO(driver);
		String nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		natWinHandle = MyActions.convertnativeWindowHandle(nativeWindowHandle);

		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);

		Assert.assertTrue(la.getLandingPageLocator().isDisplayed()); // Employee logged in; landing page displayed
	}

	@Test(priority = 2, description = "Change Password", enabled = false)
	// disabled because employee cannot use same password as previous 5 or any used
	// in last 6 months
	public void changePassword() {

		ChangePasswordPO cp = new ChangePasswordPO(driver);
		cp.getNewPasswordInputField().sendKeys(password);
		cp.getConfirmPasswordInputField().sendKeys(password);
		cp.getOKButton().click();

		LandingPagePO la = new LandingPagePO(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		Assert.assertTrue(la.getLandingPageLocator().isDisplayed()); // Employee logged in; landing page displayed

	}

	@AfterTest()
	public void TearDown() {
		driver.close();
		driver.quit();
	}

}
