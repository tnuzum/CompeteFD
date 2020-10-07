package frontDeskTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.BookingsPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class Bookings extends base {
	
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
	public void validatePageObjects(){

		softAssertion.assertEquals(b.getPageLabel().getText(), "Bookings : Service View");
		softAssertion.assertTrue(!b.getClearButton().isEnabled()); // not enabled because a member has not yet been selected
		softAssertion.assertEquals(b.getMemberInputLabel().getText(), "Member ID/ Last Name");
		softAssertion.assertTrue(b.getMemberInputField().isEnabled());
		softAssertion.assertTrue(b.getBrowseButton().isEnabled());
		softAssertion.assertEquals(b.getClubLabel().getText(), "Club");
		softAssertion.assertTrue(b.getClubCombobox().isEnabled());
		softAssertion.assertEquals(b.getServiceCategoryLabel().getText(), "Service Category");
		softAssertion.assertTrue(b.getServiceCategoryCombobox().isEnabled());
		softAssertion.assertEquals(b.getServiceLabel().getText(), "Service");
		softAssertion.assertTrue(b.getServiceCombobox().isEnabled());
		softAssertion.assertEquals(b.getResourcesLabel().getText(), "Resources");
		softAssertion.assertEquals(b.getResourceTypeHeader().getText(), "Resource Type");
		softAssertion.assertEquals(b.getBookHeader().getText(), "Book");
		softAssertion.assertTrue(b.getCalendarView().isDisplayed());
		softAssertion.assertTrue(!b.getShowCalendarButton().isEnabled());// not enabled because resources have not yet been selected
		softAssertion.assertTrue(b.getBookViewButton().isEnabled());
		softAssertion.assertTrue(b.getSearchAppointmentsButton().isEnabled());
		softAssertion.assertAll();
		
	}
	
	@Test(priority = 2, enabled = true)
	public void showCalendar(){

		
		b.getClubCombobox().click();
		
		b.getListItem(8).click(); // selects club "Jonas Sport-Plex"
		
		b.getServiceCategoryCombobox().click();
		
		b.getListItem(6).click(); // selects club "Personal Training"
		
		b.getServiceCombobox().click();
		
		b.getListItem(2).click(); // selects club "Club Demo"
		
		b.getResourceTypeValue(0);
		
		b.getShowCalendarButton().click();
		
		Assert.assertTrue(b.getBreadCrum().isDisplayed());
		Assert.assertTrue(b.getBreadCrum().getText().equals("Jonas Sports-Plex > Personal Training > CancelTraining"));
		
	}
	
	@Test(priority = 4, enabled = true)
	public void bookView(){
		
		b.getBookViewButton().click();
		
		Assert.assertEquals(b.getPageLabel().getText(), "Bookings : Book View");	
	}
	
	@AfterClass (enabled = true)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
			
		driver.close();
		
		driver.quit();
	}

}
