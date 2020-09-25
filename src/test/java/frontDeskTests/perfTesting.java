package frontDeskTests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class perfTesting extends base {

	static String barcodeId = "Todd";
	static String password = "111";

	public static void main(String[] args) throws Throwable {

		LandingPagePO la = new LandingPagePO();
		CheckInPO ci = new CheckInPO();
		MemberSearchPO ms = new MemberSearchPO();
		String searchString = "Manny";
		
		MyActions.startWAD();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\Program Files (x86)\\JonasFitness\\Compete\\Front Desk.exe");
		WindowsDriver Session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

		Session.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		DesiredCapabilities Appcapabilities = new DesiredCapabilities();
		Appcapabilities.setCapability("app", "Root");
		Appcapabilities.setCapability("ms:experimental-webdriver", true); // performance improvement for XPath
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), Appcapabilities);
		
		WebDriverWait waitForLogin = new WebDriverWait(driver, 30);
		waitForLogin.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Employee Login")));

		MyActions.loginEmployee(barcodeId, password);
		
		int i = 1;
		while (i <= 2) {
			
			la.getCheckInButton().click();
			
			ci.getMemberInputField().sendKeys(searchString);
			
			ci.getSearchButton().click();

			MyActions.myWaitByName(30, "Member Quick Search");

			ms.getOKButton().click();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			ci.getFamilyCheckInButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ci.getCheckInAllFamilyButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ci.getWarningYesButton().click();
			try {
				Thread.sleep(120000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			/*
			la.getCheckInButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			la.getPOSButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

		return;
	}
}
