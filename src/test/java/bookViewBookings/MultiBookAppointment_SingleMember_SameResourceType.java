package bookViewBookings;

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

public class MultiBookAppointment_SingleMember_SameResourceType extends base {
	
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
	String desiredResourceType;
	String desiredBook;
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
		desiredResourceType = prop.getProperty("resourceType1");
		desiredBook = prop.getProperty("book1");
		desiredServiceCategory = prop.getProperty("serviceCategory1");
		desiredService = prop.getProperty("service4");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(2).click();
		
	}
	
		
	@Test(priority = 1, enabled = true)
	public void bookappt() throws InterruptedException{
		
		if (b.getPageLabel().getText().contains("Service View")) {
			
			b.getBookViewButton().click();
			Thread.sleep(500);
		}
		
		int i = 1;
		int j = 1;
		int k = 1;
		int l = 1;
		int m = 1;
		
		b.getBookViewClubCombobox().click();
		
		String clubName;
		
		// selects club "Jonas Sports-Plex"
		
		do {clubName = b.getListItem(i).getText();
		
		if (clubName.equals(desiredClub)) 
			
			 b.getListItem(i).click();
				 
			 else
			 i++;
		
			
		}
		while(!clubName.equals(desiredClub));
		
  
		
		b.getBookViewResourceTypeCombobox().click();
		
	 // selects category "Personal Training"
		
		String resourceTypeName;
		
		do {resourceTypeName = b.getListItem(j).getText();
		
		if (resourceTypeName.equals(desiredResourceType)) 
			
			 b.getListItem(j).click();
				 
			 else
			 j++;
		
			
		}
		while(!resourceTypeName.equals(desiredResourceType));
		
		b.getBookViewBookCombobox().click();
		
		String BookName;
			
		// selects product "APT-Bookings1"
		
		do {BookName = b.getListItem(k).getText();
		
		if (BookName.equals(desiredBook)) 
			
			 b.getListItem(k).click();
				 
			 else
			 k++;
		
			
		}
		while(!BookName.equals(desiredBook));
		
					
		b.getShowCalendarButton().click();
		Thread.sleep(4000);
		
		b.getWeekView().click();
			
		
		
		String ToDay = ReusableDates.getToDayAndDate();
			
		Actions actions = new Actions(driver);	
				
		try {
		actions.doubleClick(b.getCalendarDateTimeSlots(ToDay, "9:30 AM")).perform();// selects appointment time
			
		}
		catch (org.openqa.selenium.NoSuchElementException ne) {
			
					b.getCalendarDates(ToDay).click();
													
			Thread.sleep(500);
			actions.doubleClick(b.getCalendarDateTimeSlots(ToDay, "9:30 AM")).perform(); // selects appointment time
		}
		MyActions.focusByNativeWindowHandleIndex(0);
		
		b.getBookViewServiceCategoryComboBox().click();
		
		 // selects category "Personal Training"
			
			String serviceCategoryName;
			
			do {serviceCategoryName = b.getListItem(l).getText();
			
						
			if (serviceCategoryName.equals(desiredServiceCategory)) 
				
				 actions.click(b.getListItem(l)).perform();
								 
				 else
				 l++;
					
			}
			while(!serviceCategoryName.equals(desiredServiceCategory));
			
			b.getBookViewServiceCombobox().click();
			
			String ServiceName;
				
			// selects product "APT-Bookings1"
			
			do {ServiceName = b.getListItem(m).getText();
			
			if (ServiceName.equals(desiredService)) 
				
				 actions.click(b.getListItem(m)).perform();
					 
				 else
				 m++;
			
				
			}
			while(!ServiceName.equals(desiredService));
		
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
		
		b.getCalendarDateTimeSlots(ToDay, "9:30 AM").click();
		
		Assert.assertTrue(b.getAppointment(prop.getProperty("ApptMember2")).isDisplayed());
	}
		
		@Test(priority = 2, enabled = true)
		public void cancelappt() throws InterruptedException{	
		
		b.getBookViewApptCancelBtn().click();
		
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

