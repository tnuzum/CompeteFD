package ServiceViewBookings;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.BookingsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.ReusableDates;
import resources.base;

public class MultiBookAppointment_MultiMember_DiifrntResourceType_Recurring extends base {
	
	/*
	 *  !! This test assumes the station is configured to show Service View by default
	 *  Compete Back Office > Configuration > Station > Bookings; test will return
	 *  Element Not Found exception if this is set to Book View
	 */
	
	//public static SoftAssert softAssertion= new SoftAssert();
	private static String tomorrowsDayNDate;

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
	public void bookMultiMemberRecurringappt() throws InterruptedException{

		
		b.getClubCombobox().click();
		
		b.getListItem(10).click();  // selects club "Jonas Sports-Plex"
		
		b.getServiceCategoryCombobox().click();
		
		b.getListItem(7).click(); // selects category "Personal Training1"
		
		b.getServiceCombobox().click();
			
		b.getListItem(3).click(); // selects product "APT-GrpBookings3"
		
			
		b.getShowCalendarButton().click();
		Thread.sleep(4000);
		
		b.getWeekView().click();
		
		tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
		
		Actions actions = new Actions(driver);		
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "10:00 AM")).perform();  // selects appointment time
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys(prop.getProperty("ApptMember2"));
		
		b.getSearchBtn().click();
		
		b.getOk().click();
		Thread.sleep(2000);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys(prop.getProperty("ApptMember3"));
		
		b.getSearchBtn().click();
		
		b.getOk().click();
		Thread.sleep(2000);
		
		b.getRecurrenceBtn().click();
		b.getRBDaily().click();
		b.getMaxOccurrences().sendKeys("2");
		
		
		WebElement OK =  (WebElement) b.getOKs().get(0);
		OK.click();
		
		Assert.assertEquals(b.getRecurringAppointmentDate(0).getText(), ReusableDates.getCurrentDateFormatPlusOne());
		Assert.assertEquals(b.getRecurringAppointmentDate(1).getText(), ReusableDates.getCurrentDateFormatPlusTwo());
							
		b.getOkBtn().click();
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(b.getTextMsg().getText().contains("have been booked"));
		
		b.getOkBtn().click();

		b.getCancel().click();
		Thread.sleep(2000);
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "10:00 AM").click();
		
		Assert.assertTrue(b.getAppointment(prop.getProperty("ApptMember2")).isDisplayed());
		
	}
	@Test(priority = 2, enabled = true)
	public void EditAppt() throws InterruptedException {
		
		b.getApptEditBtn().click();
		Thread.sleep(8000);
		MyActions.focusByNativeWindowHandleIndex(0);
		b.getEditApptsBtn().click();
		Thread.sleep(2000);
		MyActions.focusByNativeWindowHandleIndex(0);
		b.getSelectAll().click();
		b.getRemoveAppts().click();
		/*
		 * b.getOkBtn().click(); Thread.sleep(2000);
		 */
		MyActions.focusByNativeWindowHandleIndex(0);
		Assert.assertTrue(b.getTextMsg().getText().contains("Do you want to remove selected appointments?"));
		
		WebElement OK =  (WebElement) b.getOKs().get(0);
		OK.click();
		MyActions.focusByNativeWindowHandleIndex(0);
		Assert.assertTrue(b.getTextMsg().getText().contains("have been cancelled."));
		
		OK =  (WebElement) b.getOKs().get(0);
		OK.click();
		
		b.getCancel().click();
		Thread.sleep(2000);
		
		
	}
		
		@Test(priority = 3, enabled = true)
		public void VerifyAppointmentscancelled() throws InterruptedException{	
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "10:00 AM").click();
		
		Assert.assertFalse(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "10:00 AM").getText().contains(prop.getProperty("ApptMember2")));
		
		b.getCalendarDateTimeSlots(ReusableDates.getDayAfterTomorrowsDayAndDate(), "10:00 AM").click();
		
		Assert.assertFalse(b.getCalendarDateTimeSlots(ReusableDates.getDayAfterTomorrowsDayAndDate(), "10:00 AM").getText().contains(prop.getProperty("ApptMember2")));
		
		}		
	

	@AfterClass (enabled = true)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}

