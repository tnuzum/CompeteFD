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
import resources.ReusableDates;
import resources.base;

public class Endurance_TimeClock extends base {

	static String barcodeId = "Todd";
	 static String password = "111";
	//static String password = "Passw0rd!";

	public static void main(String[] args) throws Throwable {
			
		LandingPagePO la = new LandingPagePO();
		CheckInPO ci = new CheckInPO();
		MemberSearchPO ms = new MemberSearchPO();
		String item1BarcodeId = "autoItem1";
		String searchString = "Manny";

		MyActions.startWAD();
		
			Thread.sleep(10000);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\Program Files (x86)\\JonasFitness\\Compete\\Front Desk.exe");
		WindowsDriver Session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

		Session.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		DesiredCapabilities Appcapabilities = new DesiredCapabilities();
		Appcapabilities.setCapability("app", "Root");
		//Appcapabilities.setCapability("ms:experimental-webdriver", true); // performance improvement for XPath
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), Appcapabilities);
		
			Thread.sleep(5000);
		WebDriverWait waitForLogin = new WebDriverWait(driver, 30);
		waitForLogin.until(ExpectedConditions.visibilityOfElementLocated(By.name("Employee Login")));
		Thread.sleep(5000);
		MyActions.loginEmployee(barcodeId, password);
		
		int i = 1;
		while (i <= 500) {
			System.out.println(i);
			long sleepValue = MyActions.getSleepValue();
			System.out.println(sleepValue);
			TimeUnit.SECONDS.sleep(sleepValue); // pause between loops to randomize inputs
			System.out.println(ReusableDates.getCurrentDateTime());			
		// ** Member CheckIn **
			
			la.getCheckInButton().click();
			
			ci.getMemberInputField().sendKeys(searchString);
				
				Thread.sleep(5000);
				
			ci.getSearchButton().click();
			
				Thread.sleep(15000);

			MyActions.myWaitByName(30, "Member Quick Search");

			ms.getOKButton().click();

				Thread.sleep(10000);
	
			ci.getFamilyCheckInButton().click();

				Thread.sleep(10000);
			
			ci.getCheckInAllFamilyButton().click();

				Thread.sleep(12000);

			ci.getWarningYesButton().click();

				Thread.sleep(10000);
			
	// ** Purchase Item with Cash **		
			/*			
			la.getCheckInButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} */
			la.getPOSButton().click();

				Thread.sleep(10000);

			MyActions.purchaseItemWithCash(item1BarcodeId);
			
			i++;
			
		}
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		driver.close();
		
		driver.quit();

		return;
		
		
	}
}
