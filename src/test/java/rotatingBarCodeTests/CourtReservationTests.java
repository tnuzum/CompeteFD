package rotatingBarCodeTests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CourtReservationsPO;
import pageObjects.LandingPagePO;
import pageObjects.SearchAppointmentPO;
import resources.MyActions;
import resources.ReusableDates;
import resources.base;

public class CourtReservationTests extends base {
	
	/*
	 *  !! This test assumes the station is configured to show Service View by default
	 *  Compete Back Office > Configuration > Station > Bookings; test will return
	 *  Element Not Found exception if this is set to Book View
	 */
	
	public static SoftAssert softAssertion= new SoftAssert();

	CourtReservationsPO cp;
	LandingPagePO la;
	SearchAppointmentPO sa;
	String barcodeId;
	String password;
	String clubName;
	String courtType;
	String service;
	String book;
	String token;
	String newToken;
	String expirationTimeSpan = "00:10:00";
	String tokenMemberId;
	String tokenProspectId;
	String tomorrowsDayNDate;
	String modifiedToken; 
	String ToDay;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		cp = new CourtReservationsPO();
		la = new LandingPagePO();
		sa = new SearchAppointmentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		clubName = prop.getProperty("club1Name");
		courtType = prop.getProperty("courtType");
		service = prop.getProperty("service3");
		book = prop.getProperty("demoBookName");
		tokenMemberId = prop.getProperty("tokenMemberId");
		tokenProspectId = prop.getProperty("tokenProspectId");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(10).click();

	}
	
	@Test(priority = 1, enabled = true)
	public void memberSearchByExpiredToken() throws InterruptedException{
		
	
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		cp.getMemberInputField().sendKeys(token);
		cp.getBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(cp.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		cp.getOkBtn().click();
			
	}
	
	@Test(priority = 2)
	public void memberSearchWithmodifiedToken() {
		
		modifiedToken = "@544B4E123456@";
		cp.getMemberInputField().sendKeys(modifiedToken);
		cp.getBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(cp.getTextMsg().getText(), "No Record Found.");
		cp.getOkBtn().click();
		
	}
	
	@Test(priority = 3)
	public void validateExpirationWorks() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		token = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
		
//		cp.getMemberInputField().clear();
		
		cp.getMemberInputField().sendKeys(token);
		
		cp.getBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(cp.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		cp.getOkBtn().click();
		
	}
		
	@Test(priority = 4, enabled = true)
	public void reserveCourtByMemberTokenSearch() throws InterruptedException{
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);

		cp.getMemberInputField().sendKeys(token);
		
		cp.getBrowseButton().click();
		
		Assert.assertEquals(cp.getMemberId().getText(), tokenMemberId);

// Club Dropdown List		
		cp.getClubCombobox().click();
		
		int a = 1;
		 String clubListItem;
		
		do {clubListItem =  cp.getListItem(a).getText();
		
		if (clubListItem.equals(clubName))
			cp.getListItem(a).click();
		else
			a++;
		}
		
		while(!clubListItem.equals(clubName));
		
// Service Category Dropdown List		
		cp.getCourtTypeCombobox().click();
		
		int i = 1;
		 String courtTypeValue;
		
		do {courtTypeValue =  cp.getListItem(i).getText();
		
		if (courtTypeValue.equals(courtType))
			cp.getListItem(i).click();
		else
			i++;
		}
		
		while(!courtTypeValue.equals(courtType));

		cp.getShowCalendarButton().click();

		Thread.sleep(4000);
		
		ToDay = ReusableDates.getToDayAndDate();
					
		Actions actions = new Actions(driver);
		
		actions.doubleClick(cp.getCalendarDateTimeSlots(ToDay, "8:00 AM")).perform();  // selects Reservation time
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
//		cp.getAttendedChkBox().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
					
//		cp.getMessageYes().click();
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		cp.getOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
//		cp.getOkBtn().click();
		cp.getCancel().click();
		
		
	}
	
	@Test(priority = 5, enabled = true)
	
	public void searchReservationByToken() {
		
		token = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		cp.getSearchReservationsButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
			
		cp.getMemberSearch().sendKeys(token);
		
//		cp.getReservationTimeComboBox().click();
//		
//		
//		int i = 1;
//		 String timeBlock;
//		
//		do {timeBlock =  cp.getListItem(i).getText();
//		
//		System.out.println(timeBlock);
//		
//		if (timeBlock.equals("<All Time Slots>"))
//		{
//			System.out.println(timeBlock);
//			
//			cp.getListItem(i).sendKeys(Keys.ENTER);;
//			
//		}
//		else
//			i++;
//		}
//		
//		while(!timeBlock.equals("<All Time Slots>"));
//		
//		cp.getMemberBrowseButton().click();
//		
//		Assert.assertTrue(cp.getMemberInfo(0).getText().contains("Kalle, Bhagya"));
		
		cp.getMemberBrowseButton().click();
		
		Assert.assertTrue(cp.getMemberSearch().getText().contains("Kalle, Bhagya"));
		
		cp.getSearchClear().click();
	}
	
	@Test(priority = 6, enabled = true)
	
	public void searchReservationByExpiredToken() {
		
//		cp.getSearchReservationsButton().click();
		
		newToken = MyActions.getToken(tokenMemberId, expirationTimeSpan);
		
		cp.getMemberSearch().sendKeys(token);
		cp.getMemberBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(cp.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		cp.getOkBtn().click();
			
	}
	
	@Test(priority = 7)
	public void ReservationSearchWithmodifiedToken() {
		
		modifiedToken = "@544B4E123456@";
		
//		cp.getSearchClear().click();
		
		cp.getMemberSearch().sendKeys(modifiedToken);
		cp.getMemberBrowseButton().click();
		
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(cp.getTextMsg().getText(), "No Record Found.");
		cp.getOkBtn().click();
		
	}
	
	@Test(priority = 8)
	public void validateExpirationWorksForSearch() {
		
		String veryShortExpirationTimeSpan = "00:00:01";
		
		token = MyActions.getToken(tokenMemberId, veryShortExpirationTimeSpan);
		
//		cp.getSearchClear().click();
		
		cp.getMemberSearch().sendKeys(token);
		
		cp.getMemberBrowseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		Assert.assertEquals(cp.getTextMsg().getText(), "Your Token has expired. Please try again or Enter your Barcode ID.");
		
		cp.getOkBtn().click();
		
		cp.getSearchCancel().click();
		
	}
		
		
	@Test(priority = 9, enabled = true)
	public void cancelReservation() throws InterruptedException {
	
		
		cp.getCalendarDateTimeSlots(ToDay, "8:00 AM").click();

		cp.getCancelReservation().click();

		MyActions.focusByNativeWindowHandleIndex(0);

		cp.getOkBtn().click();
		Thread.sleep(2000);
		
		MyActions.focusByNativeWindowHandleIndex(0);

//		cp.getOkBtn().click();
		cp.getCancel().click();
	
	}		

	@AfterClass (enabled = true)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}

