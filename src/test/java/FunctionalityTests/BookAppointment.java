package FunctionalityTests;

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
	String clubName;
	String serviceCategory;
	String service;
	String book;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		b = new BookingsPO();
		la = new LandingPagePO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		clubName = prop.getProperty("club1Name");
		serviceCategory = prop.getProperty("serviceCategory1");
		service = prop.getProperty("service1");
		book = prop.getProperty("demoBookName");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(2).click();

	}
		
	@Test(priority = 1, enabled = true)
	public void bookappt() throws InterruptedException{

		
		b.getClubCombobox().click();
		
		int a = 1;
		 String clubListItem;
		
		do {clubListItem =  b.getListItem(a).getText();
		
		if (clubListItem.equals(clubName))
			b.getListItem(a).click();
		else
			a++;
		}
		while(!clubListItem.equals(clubName));
		
		b.getServiceCategoryCombobox().click();
		
		int i = 1;
		 String serviceCategoryListItem;
		
		do {serviceCategoryListItem =  b.getListItem(i).getText();
		
		if (serviceCategoryListItem.equals(serviceCategory))
			b.getListItem(i).click();
		else
			i++;
		}
		while(!serviceCategoryListItem.equals(serviceCategory));
		
		b.getServiceCombobox().click();
			
		b.getListItem(13).click(); // selects product "Free Training Auto"
	
		int x = 1;
		 String serviceListItem;
		
		do {serviceListItem =  b.getListItem(x).getText();
		
		if (serviceListItem.equals(service))
			b.getListItem(x).click();
		else
			x++;
		}
		while(!serviceListItem.equals(service));
		
		System.out.println(b.getBookValue(0).getText());
		
		int y = 0;
		 String bookListItem;
		
		do {bookListItem =  b.getBookValue(y).getText();
		
		if (bookListItem.equals(book))
			b.getBookValue(y).click();
		else
			y++;
		}
		while(!bookListItem.equals(book));

		b.getShowCalendarButton().click();

		Thread.sleep(4000);
		
		b.getWeekView().click();

		String tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
					
		Actions actions = new Actions(driver);
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM")).perform();  // selects appointment time
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		b.getAddMbrButton().click();
		
		b.getMbrSearch().sendKeys(prop.getProperty("ApptMember1"));
		
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
		
		Assert.assertTrue(b.getAppointment(prop.getProperty("ApptMember1")).isDisplayed());
	}
		
	@Test(priority = 2, enabled = true)
	public void cancelappt() throws InterruptedException {

		b.getApptCancelBtn().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		Assert.assertTrue(b.getTextMsg().getText().contains("Do you want to cancel this appointment?"));

		b.getOkBtn().click();
		Thread.sleep(2000);

		Assert.assertTrue(b.getTextMsg().getText().contains("has been cancelled"));

		b.getOkBtn().click();

		b.getCancel().click();

	}		

	@AfterClass (enabled = false)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}

