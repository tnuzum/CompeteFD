package frontDeskTests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.ChangePasswordPO;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;
import resources.MyActions;
import resources.base;

public class ChangePassword extends base {

	ChangePasswordPO cp;
	LandingPagePO lp;
	String natWinHandle;
	String nativeWindowHandle;
	static String barcodeId;
	static String password;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: "+getClass().getName());
		driver = initializeDriver();

		barcodeId = prop.getProperty("changeEmployeeBarcodeId");
		password = prop.getProperty("changeEmployeePassword");

		cp = new ChangePasswordPO();
		lp = new LandingPagePO();
		LoginPO l = new LoginPO();

		l.getPromptCheckbox().click();

		MyActions.loginEmployee(barcodeId, password);

	}

	@Test(priority = 1, description = "Validate Page Objects")
	public void ValidatePageObjects() throws Exception{
		
		
        WebDriverWait wait=new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Change Employee Password")));

		Assert.assertEquals(cp.getNewPasswordlabel().getText(), "Please enter the new password value");
		Assert.assertTrue(cp.getNewPasswordInputField().isEnabled());
		Assert.assertEquals(cp.getConfirmPasswordlabel().getText(), "Please enter the password again for confirmation");
		Assert.assertTrue(cp.getNewPasswordInputField().isEnabled());
		Assert.assertTrue(cp.getHelpButton().isEnabled());
		Assert.assertTrue(cp.getOKButton().isEnabled());
		Assert.assertTrue(cp.getCancelButton().isEnabled());
		
		cp.getCancelButton().click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));
		
		String nativeWindowHandle = lp.getLandingPageLocator().getAttribute("NativeWindowHandle");
		natWinHandle = MyActions.convertnativeWindowHandle(nativeWindowHandle);

		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);

		Assert.assertTrue(lp.getLandingPageLocator().isDisplayed()); // Employee logged in; landing page displayed
	}

	@Test(priority = 2, description = "Change Password", enabled = false)
	// disabled because employee cannot use same password as previous 5 or any used
	// in last 6 months
	public void changePassword() {
		cp.getNewPasswordInputField().sendKeys(password);
		cp.getConfirmPasswordInputField().sendKeys(password);
		cp.getOKButton().click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		Assert.assertTrue(lp.getLandingPageLocator().isDisplayed()); // Employee logged in; landing page displayed

	}

	@AfterClass()
	public void TearDown() {
		driver.close();
		driver.quit();
	}

}
