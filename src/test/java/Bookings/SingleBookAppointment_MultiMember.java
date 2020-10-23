package Bookings;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.BookingsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.ReusableDates;
import resources.base;

public class SingleBookAppointment_MultiMember extends base {
	
	/*
	 *  !! This test assumes the station is configured to show Service View by default
	 *  Compete Back Office > Configuration > Station > Bookings; test will return
	 *  Element Not Found exception if this is set to Book View
	 */
	
	public static SoftAssert softAssertion= new SoftAssert();
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
	public void bookMultiMemberappt() throws InterruptedException{

		
		b.getClubCombobox().click();
		
		b.getListItem(8).click();  // selects club "Jonas Sports-Plex"
		
		b.getServiceCategoryCombobox().click();
		
		b.getListItem(7).click(); // selects category "Personal Training"
		
		b.getServiceCombobox().click();
			
		b.getListItem(1).click(); // selects product "APT-Bookings1"
		
			
		b.getShowCalendarButton().click();
		Thread.sleep(4000);
		
		b.getWeekView().click();
		
		tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
		
		Actions actions = new Actions(driver);		
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM")).perform();  // selects appointment time
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys("Auto, BookingsParty");
		
		b.getSearchBtn().click();
		
		b.getOk().click();
		Thread.sleep(2000);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys("Auto, CCmember");
		
		b.getSearchBtn().click();
		
		b.getOk().click();
		Thread.sleep(2000);
	}
	@Test(priority = 2, enabled = true)
	public void VerifyCapacity() throws InterruptedException{
				
		b.getAddMbrButton().click();
				  
		MyActions.focusByNativeWindowHandleIndex(0);
		  
		softAssertion.assertTrue(b.getTextMsg().getText().contains("Appointment has reached maximum permissible count."));
						 
		WebElement OK =  (WebElement) b.getOKs().get(0);
		OK.click();
				
		b.getOkBtn().click();
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		softAssertion.assertTrue(b.getTextMsg().getText().contains("has been booked"));
		
		b.getOkBtn().click();

		b.getCancel().click();
		Thread.sleep(2000);
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM").click();
		
		softAssertion.assertTrue(b.getAppointment("Auto, Bookingsparty").isDisplayed());
		softAssertion.assertAll();
	}
		
		@Test(priority = 2, enabled = true)
		public void cancelappt() throws InterruptedException{	
		
		b.getApptCancelBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);

		softAssertion.assertTrue(b.getTextMsg().getText().contains("Do you want to cancel this appointment?"));
		
		b.getOkBtn().click();
		Thread.sleep(2000);

		softAssertion.assertTrue(b.getTextMsg().getText().contains("has been cancelled"));
		
		b.getOkBtn().click();

		b.getCancel().click();
		softAssertion.assertAll();
		
		}		
	

	@AfterClass (enabled = true)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}

