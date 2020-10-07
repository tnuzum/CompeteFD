package FunctionalityTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.BookingsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.ReusableDates;
import resources.base;

public class BookAppointment extends base {
	
	/*
	 *  !! This test assumes the station is configured to show Service View by default
	 *  Compete Back Office > Configuration > Station > Bookings; test will return
	 *  Element Not Found exception if this is set to Book View
	 */
	
	public static SoftAssert softAssertion= new SoftAssert();

	BookingsPO b;
	LandingPagePO la;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		b = new BookingsPO();
		la = new LandingPagePO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(2).click();

	}
	
		
	@Test(priority = 1, enabled = true)
	public void bookappt() throws InterruptedException{

		
		b.getClubCombobox().click();
		
		b.getListItem(8).click();
		
		b.getServiceCategoryCombobox().click();
		
		b.getListItem(6).click(); // selects club "Personal Training"
		
		b.getServiceCombobox().click();
		
		b.getListItem(10).click(); // selects club "Club Demo"
				
		b.getBookValue(0).click();
		
		Actions actions = new Actions(driver);
		
		actions.doubleClick(b.getBookValue(0)).perform();
		Thread.sleep(2000);
		
		b.getListItem(3).click();
		
		b.getShowCalendarButton().click();
		Thread.sleep(2000);
		
		String tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
					
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM")).perform();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys("Auto, Apptmember2");
		
		b.getSearchBtn().click();
		
		b.getOk().click();
		Thread.sleep(2000);

		b.getOkBtn().click();
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(b.getTextMsg().getText().contains("has been booked"));
		
		b.getOkBtn().click();

		b.getCancel().click();
		Thread.sleep(2000);
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM").click();
		
		Assert.assertTrue(b.getAppointment("Auto, ApptMember2").isDisplayed());
	}
		
		@Test(priority = 2, enabled = true)
		public void cancelappt() throws InterruptedException{	
		
		b.getApptCancelBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		Assert.assertTrue(b.getTextMsg().getText().contains("Do you want to cancel this appointment?"));
		
		b.getOkBtn().click();
		Thread.sleep(2000);

		Assert.assertTrue(b.getTextMsg().getText().contains("has been cancelled"));
		
		b.getOkBtn().click();

		b.getCancel().click();
		
		}		
	

	@AfterClass (enabled = true)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}

