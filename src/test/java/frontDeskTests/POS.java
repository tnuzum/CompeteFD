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
	
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {
		
		System.out.println("Class: "+getClass().getName());
		driver = initializeDriver();
		
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(enabled = true)
	public void launchPOS() throws Exception {

		MyActions.loginEmployee(barcodeId, password);

		LandingPagePO la = new LandingPagePO();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		la.getPOSButton().click();
	}

	@AfterClass
	public void TearDown() throws Throwable {
		driver.close();
		driver.quit();
	}

}
