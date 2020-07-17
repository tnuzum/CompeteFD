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
	
	public static SoftAssert softAssertion= new SoftAssert();

	BookingsPO b;
	LandingPagePO la;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Test Class: " + getClass().getName());
		driver = initializeDriver();
		
		b = new BookingsPO();
		la = new LandingPagePO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");

	}

	@Test(priority = 1, enabled = true)
	public void launchBookings() throws Exception{

		MyActions.loginEmployee(barcodeId, password);

			MyActions.myWait(30, "deckWorkspace1");

		la.getMoreButton().click();
		
		la.getMoreButton2().click();
		
		Assert.assertTrue(b.getBookingsPageLabel().isDisplayed());

	}
	
	@Test(priority = 2, enabled = true)
	public void validatePageObjects(){

		softAssertion.assertEquals(b.getBookingsPageLabel().getText(), "Bookings : Service View");
		softAssertion.assertTrue(!b.getClearButton().isEnabled(),"Clear Button is Enabled"); // not enabled because a member has not yet been selected
		softAssertion.assertEquals(b.getMemberInputLabel().getText(), "Member ID/ Last Name");
		softAssertion.assertTrue(b.getMemberInputField().isEnabled(), "Member Input Field is Enabled");
		softAssertion.assertTrue(b.getBrowseButton().isEnabled(), "Browse Button is Enabled");
		softAssertion.assertEquals(b.getClubLabel().getText(), "Club");
		softAssertion.assertTrue(b.getClubCombobox().isEnabled(), "Club Combobox is Enabled");
		softAssertion.assertEquals(b.getServiceCategoryLabel().getText(), "Service Category");
		softAssertion.assertTrue(b.getServiceCategoryCombobox().isEnabled(), "Service Category Combobox is Enabled");
		softAssertion.assertEquals(b.getServiceLabel().getText(), "Service");
		softAssertion.assertTrue(b.getServiceCombobox().isEnabled(), "Service Combobox is Enabled");
		softAssertion.assertEquals(b.getResourcesLabel().getText(), "Resources");
		softAssertion.assertEquals(b.getResourceTypeHeader().getText(), "Resource Type");
		softAssertion.assertEquals(b.getBookHeader().getText(), "Book");
		softAssertion.assertTrue(b.getCalendarView().isDisplayed(), "Calendar is Displayed");
		softAssertion.assertTrue(!b.getShowCalendarButton().isEnabled(), "Show Calendar Button is Enabled");// not enabled because resources have not yet been selected
		softAssertion.assertTrue(b.getBookViewButton().isEnabled(), "Bookview Button is Enabled");
		softAssertion.assertTrue(b.getSearchAppointmentsButton().isEnabled(), "Search Appointment Button is Enabled");
		softAssertion.assertAll();
		
	}
	
	@Test(priority = 3, enabled = true)
	public void showCalendar() throws Exception{

		
		b.getClubCombobox().click();
		
		b.getListItem(8).click(); // selects club "Jonas Sport-Plex"
		
		b.getServiceCategoryCombobox().click();
		
		b.getListItem(6).click(); // selects club "Personal Training"
		
		b.getServiceCombobox().click();
		
		b.getListItem(2).click(); // selects club "Club Demo"
		
		b.getResourceTypeValue(0);
		
		b.getShowCalendarButton().click();
		
		Assert.assertTrue(b.getBreadCrum().isDisplayed());
		
		// ** In progress - click on small calendar
		//driver.findElementByXPath("//DataItem[contains(@Name,'17,')]").click();
		//driver.findElementByName("Thursday, July 16, 2020").click(); this works but not sustainable
		//b.getCalendarDateButton(0).click();
		
	}
	
	@Test(priority = 4, enabled = true)
	public void bookView() throws Exception{
		
		b.getBookViewButton().click();
		
		Assert.assertEquals(b.getBookingsPageLabel().getText(), "Bookings : Book View");	
	}
	


	@AfterClass (enabled = true)
	public void tearDown() {
			MyActions.focusByNativeWindowHandleIndex(0);
		driver.close();
		driver.quit();
	}

}
