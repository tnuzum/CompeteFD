package serviceViewBookings;

import org.openqa.selenium.JavascriptExecutor;
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

public class MultiBookAppointment_SingleMember_DiffrntResourceType extends base {
	
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
		desiredClub = prop.getProperty("club1Name");
		desiredServiceCategory = prop.getProperty("serviceCategory1");
		desiredService = prop.getProperty("service5");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(2).click();
		
	}


	
		
	@Test(priority = 1, enabled = true)
	public void BookSingleMemberApptWithTwoBooksDifferentResourcetype() throws InterruptedException{
		
		if (b.getPageLabel().getText().contains("Book View")) {
			
			b.getServiceViewButton().click();
			Thread.sleep(500);
		}

		
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
		
	 // selects category "Personal Training"
		
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
			
		// selects product "APT-Bookings3"
		
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
		
		String tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
		
		Actions actions = new Actions(driver);		
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "8:30 AM")).perform();  // selects appointment time
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys(prop.getProperty("ApptMember2"));
		
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
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "8:30 AM").click();
		
		Assert.assertTrue(b.getAppointment(prop.getProperty("ApptMember2")).isDisplayed());
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



