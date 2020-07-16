package frontDeskTests;

import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.BookingsPO;
import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import pageObjects.PaymentAmountPO;
import pageObjects.PointOfSalePO;
import pageObjects.TakePaymentPO;
import resources.MyActions;
import resources.base;

public class Bookings extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	BookingsPO b;
	LandingPagePO la;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		
		b = new BookingsPO();
		la = new LandingPagePO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");

	}

	@Test(priority = 1, enabled = true)
	public void launchBookings() throws Exception{

		MyActions.loginEmployee(barcodeId, password);

			MyActions.myWait(30, "deckWorkspace1");

		la.getMoreButton().click();
		
		la.getMoreButton2().click();
		
		Assert.assertTrue(b.getBookingsPageLabel().isDisplayed());
		
		b.getClubCombobox().click();
		
		b.getListItem(8).click(); // selects club "Jonas Sport-Plex"
		
		b.getServiceCategoryCombobox().click();
		
		b.getListItem(6).click(); // selects club "Personal Training"
		
		b.getServiceCombobox().click();
		
		b.getListItem(2).click(); // selects club "Club Demo"
		
		b.getResourceTypeValue(0);
		
//		Actions a = new Actions(driver);
//		a.sendKeys(Keys.TAB)
//		.sendKeys(Keys.TAB)
//		.sendKeys(Keys.TAB)
//		.sendKeys(Keys.ARROW_RIGHT)
//		.build()
//		.perform();
		driver.findElementByXPath("//DataItem[contains(@Name,'17,')]").click();
		
		//driver.findElementByName("Thursday, July 16, 2020").click();

//		String nativeWindowHandle = b.getCalendarView().getAttribute("NativeWindowHandle");
//		int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
//		String natWinHandleStr = Integer.toHexString(natWinHandleInt);
//		String natWinHandle = "0x" + natWinHandleStr;
//		DesiredCapabilities appCapabilities = new DesiredCapabilities();
//		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
//		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
//		b.getCalendarDateButton(0).click();
	}
	
	@Test(priority = 2, enabled = false)
	public void validatePageObjects(){

		softAssertion.assertEquals(b.getBookingsPageLabel().getText(), "Bookings");

		softAssertion.assertAll();
		
	}


	@AfterClass (enabled = false)
	public void TearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
