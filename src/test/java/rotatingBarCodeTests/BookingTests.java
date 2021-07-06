package rotatingBarCodeTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.BookingsPO;
import pageObjects.LandingPagePO;
import pageObjects.SearchAppointmentPO;
import resources.MyActions;
import resources.ReusableDates;
import resources.base;

public class BookingTests extends base {
	
	/*
	 *  !! This test assumes the station is configured to show Service View by default
	 *  Compete Back Office > Configuration > Station > Bookings; test will return
	 *  Element Not Found exception if this is set to Book View
	 */
	
	public static SoftAssert softAssertion= new SoftAssert();

	BookingsPO b;
	LandingPagePO la;
	SearchAppointmentPO sa;
	String barcodeId;
	String password;
	String clubName;
	String serviceCategory;
	String service;
	String book;
	String token;
	String newToken;
	String expirationTimeSpan = "00:10:00";
	String tokenMemberId;
	String tokenProspectId;
	String tomorrowsDayNDate;
	String modifiedToken; 

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		b = new BookingsPO();
		la = new LandingPagePO();
		sa = new SearchAppointmentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		clubName = prop.getProperty("club1Name");
		serviceCategory = prop.getProperty("serviceCategory1");
		service = prop.getProperty("service3");
		book = prop.getProperty("demoBookName");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenProspectId = prop.getProperty("tokenProspectId");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(2).click();

	}
	
	@Test(priority = 1, enabled = true)
	public void memberSearchByExpiredToken() throws InterruptedException{
		
	if (b.getPageLabel().getText().contains("Book View")) {
			
			b.getServiceViewButton().click();
			Thread.sleep(500);
					
		}
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		b.getMemberInputField().sendKeys(token);
		b.getBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		b.getOkBtn().click();
			
	}
	
	@Test(priority = 2)
	public void memberSearchWithmodifiedToken() {
		
		modifiedToken = "@544B4E123456@";
		
//		b.getMemberInputField().clear();
		
		b.getMemberInputField().sendKeys(modifiedToken);
		
		b.getBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getTextMsg().getText(), "No Record Found.");
		b.getOkBtn().click();
		
	}
	
	@Test(priority = 3)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		token = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
		
//		b.getMemberInputField().clear();
		
		b.getMemberInputField().sendKeys(token);
		
		b.getBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		b.getOkBtn().click();
		
	}
		
	@Test(priority = 4, enabled = true)
	public void bookapptByMemberTokenSearch() throws InterruptedException{
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
//		b.getMemberInputField().clear();

		b.getMemberInputField().sendKeys(token);
		b.getBrowseButton().click();
		
		Assert.assertEquals(b.getMemberId().getText(), tokenMemberId);

// Club Dropdown List		
//		b.getClubCombobox().click();
//		
//		int a = 1;
//		 String clubListItem;
//		
//		do {clubListItem =  b.getListItem(a).getText();
//		
//		if (clubListItem.equals(clubName))
//			b.getListItem(a).click();
//		else
//			a++;
//		}
//		
//		while(!clubListItem.equals(clubName));
		
// Service Category Dropdown List		
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

// Service Dropdown List		
		b.getServiceCombobox().click();
	
		int x = 1;
		 String serviceListItem;
		
		do {serviceListItem =  b.getListItem(x).getText();
		
		if (serviceListItem.equals(service))
			b.getListItem(x).click();
		else
			x++;
		}
		
		while(!serviceListItem.equals(service));

		b.getShowCalendarButton().click();

		Thread.sleep(4000);
		
		b.getWeekView().click();

		tomorrowsDayNDate = ReusableDates.getTomorrowsDayAndDate();
					
		Actions actions = new Actions(driver);
		
		actions.doubleClick(b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM")).perform();  // selects appointment time
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getMemberIdValue().getText(), tokenMemberId);
				
		b.getOkBtn().click();
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertTrue(b.getTextMsg().getText().contains("has been booked"));
		
		b.getOkBtn().click();

		b.getCancel().click();
		Thread.sleep(2000);
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM").click();
		
		Assert.assertTrue(b.getAppointment(prop.getProperty("tokenMember")).isDisplayed());
	}
	
	@Test(priority = 5, enabled = true)
	
	public void searchAppointmentByToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		b.getSearchAppointmentsButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
			
		sa.getMemberInputField().sendKeys(token);
		
		sa.getMemberInputField().sendKeys(Keys.ENTER);
		
//		sa.getBrowseButton().click();
		
//		sa.getSearchButton().click();
		
		System.out.println(sa.getMemberInfo(0).getText());
		
		Assert.assertTrue(sa.getMemberInfo(0).getText().contains(tokenMemberId));
		sa.getClearButton().click();
	}
	
	@Test(priority = 6, enabled = true)
	
	public void searchAppointmentByExpiredToken() {
				
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		sa.getMemberInputField().clear();
		
		sa.getMemberInputField().sendKeys(token);
		
		sa.getMemberInputField().sendKeys(Keys.ENTER);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		
		b.getOkBtn().click();
		sa.getClearButton().click();
			
	}
	
	@Test(priority = 7)
	public void ApptSearchWithmodifiedToken() {
		
		modifiedToken = "@544B4E123456@";
		
		sa.getMemberInputField().sendKeys(modifiedToken);
		
		sa.getMemberInputField().sendKeys(Keys.ENTER);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getTextMsg().getText(), "No Record Found.");
		
		b.getOkBtn().click();
		sa.getClearButton().click();
		
	}
	
	@Test(priority = 8)
	public void validateExpirationWorksForSearch() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		token = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
		
		sa.getMemberInputField().sendKeys(token);
		
		sa.getMemberInputField().sendKeys(Keys.ENTER);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(b.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		
		b.getOkBtn().click();
		sa.getClearButton().click();
		
		sa.getCloseButton().click();
		
	}
		
		
	@Test(priority = 9, enabled = true)
	public void cancelappt() throws InterruptedException {
		
		b.getCalendarDateTimeSlots(tomorrowsDayNDate, "9:00 AM").click();

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

