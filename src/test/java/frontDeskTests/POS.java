package frontDeskTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class POS extends base {

	String natWinHandle;
	String nativeWindowHandle;

	@BeforeClass
	public void initialize() throws Throwable {

		driver = initializeDriver();
	}

	@Test(enabled = true)
	public void launchPOS() throws Exception {

		String barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		String password = prop.getProperty("activeEmployeePassword");

		MyActions.loginEmployee(barcodeId, password);

		LandingPagePO la = new LandingPagePO(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		String nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		System.out.println("POS Test: "+nativeWindowHandle);
		la.getPOSButton(nativeWindowHandle).click();
	}

	@AfterClass
	public void TearDown() throws Throwable {
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
