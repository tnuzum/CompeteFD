package winAppDriverResearch;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.AboutPagePO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class POSTest extends base {

	String natWinHandle;
	String natWinHandle2;
	String NativeWindowHandle;
	String NativeWindowHandle2;
	// public MyActions ma;

	@BeforeClass
	public void initialize() throws Throwable {

		driver = initializeDriver();
	}

	@Test(enabled = true)
	public void launchPOS() throws Exception {

		String barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		String password = prop.getProperty("activeEmployeePassword");

		MyActions ma = new MyActions(driver);
		ma.loginEmployee(barcodeId, password);

		LandingPagePO la = new LandingPagePO(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		String NativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		// String NativeWindowHandle =
		// driver.findElementByAccessibilityId("ShellForm").getAttribute("NativeWindowHandle");
		natWinHandle = MyActions.convertNativeWindowHandle(NativeWindowHandle);

		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		System.out.println(driver.getTitle());

		// la.getCompeteInfoButton().click();
		driver.findElementByXPath("//Button[@LocalizedControlType='button'][3]").click();
	}

	@AfterClass
	public void TearDown() throws Throwable {
		Thread.sleep(10000);
		driver.close();

	}

}
