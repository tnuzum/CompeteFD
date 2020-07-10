package frontDeskTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

import pageObjects.AboutCompetePO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class AboutCompete extends base {

	LandingPagePO la;
	AboutCompetePO a;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {
		
		System.out.println("Class: "+getClass().getName());
		driver = initializeDriver();
		
		la = new LandingPagePO();
		a = new AboutCompetePO(driver);
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(enabled = true)
	public void CompeteAboutView() throws Exception {

		MyActions.loginEmployee(barcodeId, password);

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

			nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");

		la.getCompeteInfoButton().click();

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

		driver.close();
		driver.quit();
	}

}
