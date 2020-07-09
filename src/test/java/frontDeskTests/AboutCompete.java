package frontDeskTests;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.AboutCompetePO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class AboutCompete extends base {

	String natWinHandle;
	String nativeWindowHandle;

	@BeforeClass
	public void initialize() throws Throwable {

		driver = initializeDriver();
	}

	@Test(enabled = true)
	public void CompeteAboutView() throws Exception {

		String barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		String password = prop.getProperty("activeEmployeePassword");

		MyActions.loginEmployee(barcodeId, password);

		LandingPagePO la = new LandingPagePO(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		String nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");

		la.getCompeteInfoButton(nativeWindowHandle).click();

		AboutCompetePO a = new AboutCompetePO(driver);

		Assert.assertTrue(a.getAboutPageLocator().isDisplayed());
		a.getCloseButton().click();
	}

	@Test(priority = 2, enabled = false)
	public void PrivacyPolicy() throws InterruptedException, Exception {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		driver.findElementByName("Privacy Policy").click();
	}

	@AfterClass
	public void TearDown() throws Throwable {

		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);

		driver.close();
		driver.quit();
	}

}
