package winAppDriverResearch;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import pageObjects.CheckInPagePO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class CheckInTest extends base {

	// public MyActions ma;

	@BeforeClass
	public void initialize() throws Throwable {

		driver = initializeDriver();
	}

	@Test(priority = 1, enabled = true)
	public void launchCheckIn() throws Exception {

		String barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		String password = prop.getProperty("activeEmployeePassword");

		MyActions ma = new MyActions(driver);
		ma.loginEmployee(barcodeId, password);

		LandingPagePO la = new LandingPagePO(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		String NativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		String natWinHandle = MyActions.convertNativeWindowHandle(NativeWindowHandle);

		la.getCheckInButton(natWinHandle).click();
		
		CheckInPagePO ci = new CheckInPagePO(driver);
		ci.getMemberInputField().sendKeys("Manny");
		ci.getSearchButton().click();

	}

	@Test(priority = 2, enabled = true)
	public void searchMember() throws Exception {

		CheckInPagePO ci = new CheckInPagePO(driver);
		
		String NativeWindowHandle = ci.getCheckInViewLocator().getAttribute("NativeWindowHandle");
		String natWinHandle = MyActions.convertNativeWindowHandle(NativeWindowHandle);

//        String NativeWindowHandle = ci.getToolBar().getAttribute("NativeWindowHandle");
//        	System.out.println(NativeWindowHandle);
//        String natWinHandle = MyActions.convertNativeWindowHandle(NativeWindowHandle);
//        	System.out.println(natWinHandle);
//        DesiredCapabilities appCapabilities = new DesiredCapabilities();
//        appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
//        driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), appCapabilities);
		//driver.switchTo().frame(ci.getToolBar());
		//ci.getMemberInputField(natWinHandle).sendKeys("Manny");
		//driver.findElementByAccessibilityId("txtBarcodeId").sendKeys("Manny");

	}

	@AfterClass
	public void TearDown(){
		driver.close();
		driver.quit();
	}

}
