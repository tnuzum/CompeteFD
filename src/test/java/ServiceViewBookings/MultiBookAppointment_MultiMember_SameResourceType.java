package ServiceViewBookings;


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

public class MultiBookAppointment_MultiMember_SameResourceType extends base {
	
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
	String desiredClub;
	String desiredServiceCategory;
	String desiredService;

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
		desiredClub = prop.getProperty("club1Name");
		desiredServiceCategory = prop.getProperty("serviceCategory2");
		desiredService = prop.getProperty("service7");

	}
	
		
	@Test(priority = 1, enabled = true)
	public void bookMultiMemberapptWithTwoBooksSameResourcetype() throws InterruptedException{

		int i = 1;
		int j = 1;
		int k = 1;
		
		b.getClubCombobox().click();
		
		String clubName;
		
		// selects club "Jonas Sports-Plex"
		
		do {clubName = b.getListItem(i).getText();
		
		if (clubName.equals(desiredClub)) 
			
			 b.getListItem(i).click();
				 
			 else
			 i++;
		
			
		}
		while(!clubName.equals(desiredClub));
		
  
		
		b.getServiceCategoryCombobox().click();
		
	 // selects category "Personal Training 1"
		
		String serviceCategoryName;
		
		do {serviceCategoryName = b.getListItem(j).getText();
		
		if (serviceCategoryName.equals(desiredServiceCategory)) 
			
			 b.getListItem(j).click();
				 
			 else
			 j++;
		
			
		}
		while(!serviceCategoryName.equals(desiredServiceCategory));
		
		b.getServiceCombobox().click();
		
		String ServiceName;
			
		// selects product "APT-GrpBookings2"
		
		do {ServiceName = b.getListItem(k).getText();
		
		if (ServiceName.equals(desiredService)) 
			
			 b.getListItem(k).click();
				 
			 else
			 k++;
		
			
		}
		while(!ServiceName.equals(desiredService));
		
			
		b.getShowCalendarButton().click();
		Thread.sleep(4000);
		
		b.getWeekView().click();
		
		tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
		
		Actions actions = new Actions(driver);		
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "6:30 AM")).perform();  // selects appointment time
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
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "6:30 AM").click();
		
		softAssertion.assertTrue(b.getAppointment(prop.getProperty("ApptMember2")).isDisplayed());
		softAssertion.assertAll();
	}
		
		@Test(priority = 3, enabled = true)
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

