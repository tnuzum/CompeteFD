package resources;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;

public class MyActions extends base {

	public static LandingPagePO la = new LandingPagePO();

	public void setDriver(WindowsDriver driver) {

		base.driver = driver;
	}

	public static String loginEmployee(String barcodeId, String password) {

		LoginPO l = new LoginPO();

		l.getUserNameInputField().sendKeys(barcodeId);

		l.getPasswordInputField().sendKeys(password);

		l.getLoginButton().click();

		MyActions.myWaitByName(30, "deckWorkspace1");

		return null;
	}

	public static void myWaitByName(int duration, String locatorName) {

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locatorName)));

	}

	public static void myWaitByAccessibilityId(int duration, String accessibilityId) {

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByAccessibilityId(accessibilityId)));

	}

	public static String convertnativeWindowHandle(String nativeWindowHandle) {

		String natWinHandle;

		/*
		 * Use this in test class to get nativeWindowHandle: String nativeWindowHandle =
		 * la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		 */
		int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
		String natWinHandleStr = Integer.toHexString(natWinHandleInt);
		natWinHandle = "0x" + natWinHandleStr;
		// System.out.println(natWinHandle);

		return natWinHandle;
	}

	public static String focusOnLandingPage() {

		/*
		 * Use this in test class to get nativeWindowHandle: String nativeWindowHandle =
		 * la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		 */

		String nativeWindowHandle = la.getPageLocator().getAttribute("NativeWindowHandle");
		int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
		String natWinHandleStr = Integer.toHexString(natWinHandleInt);
		String natWinHandle = "0x" + natWinHandleStr;
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		try {
			driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Native Window Handle: "+natWinHandle);
		return null;
	}

	public static String focusByNativeWindowHandleIndex(int index) {

		/*
		 * Use this method when WinAppDriver can find the NativeWindowHandle
		 * 
		 * use this in test class to get all Native Window Handles,
		 * System.out.println("WindowHandles: "+driver.getWindowHandles());
		 */
		try {
			Thread.sleep(2000);// this allows time for the window focus to finalize
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Object[] wh = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) wh[index]);

		return null;
	}

	public static void getWindowInformation() {

		System.out.println("AllSessionDetails: " + driver.getAllSessionDetails());
		System.out.println("SessionDetails: " + driver.getSessionDetails());
		System.out.println("SessionId: " + driver.getSessionId());
		System.out.println("WindowHandle: " + driver.getWindowHandle());
		System.out.println("WindowHandles: " + driver.getWindowHandles());
		System.out.println("Page Source: " + driver.getPageSource());

		return;
	}

	public static void performanceTestLoop() {
		// STRESS TEST EXAMPLE
		int i = 1;
		while (i <= 2) {
			la.getCheckInButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			la.getPOSButton().click();
		}

		return;
	}

}
