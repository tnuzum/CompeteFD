package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ClassEnrollmentPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class ClassEnrollment extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	ClassEnrollmentPO ce;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable{
		
		System.out.println("Test Class: "+getClass().getName());
		
		MyActions.startWAD();
		
		driver = initializeDriver();
		
		la = new LandingPagePO();
		ce = new ClassEnrollmentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(8).click();
	}
	
	@Test(priority = 1, enabled = true)
	public void validatePageObjects(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyActions.myWaitByAccessibilityId(30, "pbClearButton");

		softAssertion.assertTrue(ce.getClearButton().isDisplayed(),"Clear Button is Enabled");
		softAssertion.assertEquals(ce.getMemberInputLabel().getText(), "Member ID / Last Name");
		softAssertion.assertTrue(ce.getMemberInputField().isEnabled(), "Member Input Field is Enabled");
		softAssertion.assertTrue(ce.getSearchButton().isEnabled(), "Search Button is Enabled");
		softAssertion.assertEquals(ce.getClassDateLabel().getText(), "Class Date");
		softAssertion.assertTrue(ce.getClassDateCombobox().isEnabled(), "Class Date Combobox is Enabled");
		softAssertion.assertEquals(ce.getClubLabel().getText(), "Club");
		softAssertion.assertTrue(ce.getClubCombobox().isEnabled(), "Club Combobox is Enabled");
		softAssertion.assertTrue(ce.getClassSearchInputField().isEnabled(), "Search Field is Enabled");
		softAssertion.assertTrue(ce.getGoButton().isEnabled());
		softAssertion.assertTrue(ce.getAllClassesRadioButton().isSelected(), "All Classes Radio Button is Selected");
		softAssertion.assertTrue(!ce.getFreeClassesRadioButton().isSelected(), "Free Classes Radio Button is Not Selected");
		softAssertion.assertTrue(!ce.getChargedClassesRadioButton().isSelected(), "Charged Classes Radio Button is Not Selected");
		softAssertion.assertEquals(ce.getPriceHeader().getText(), "Price");
		softAssertion.assertEquals(ce.getDescriptionHeader().getText(), "Description");
		softAssertion.assertEquals(ce.getEnrolledStandByHeader().getText(), "Enrolled / Standby");
		softAssertion.assertEquals(ce.getStartHeader().getText(), "Start");
		softAssertion.assertEquals(ce.getSundayHeader().getText(), "S");
		softAssertion.assertEquals(ce.getMondayHeader().getText(), "M");
		softAssertion.assertEquals(ce.getTuesdayHeader().getText(), "T");
		softAssertion.assertEquals(ce.getWednesdayHeader().getText(), "W");
		softAssertion.assertEquals(ce.getThursdayHeader().getText(), "T");
		softAssertion.assertEquals(ce.getFridayHeader().getText(), "F");
		softAssertion.assertEquals(ce.getSaturdayHeader().getText(), "S");
		softAssertion.assertTrue(ce.getResultDay(0, "Sunday").isDisplayed());
		softAssertion.assertTrue(ce.getResultDay(0, "Monday").isDisplayed());
		softAssertion.assertTrue(ce.getResultDay(0, "Tuesday").isDisplayed());
		softAssertion.assertTrue(ce.getResultDay(0, "Wednesday").isDisplayed());
		softAssertion.assertTrue(ce.getResultDay(0, "Thursday").isDisplayed());
		softAssertion.assertTrue(ce.getResultDay(0, "Friday").isDisplayed());
		softAssertion.assertTrue(ce.getResultDay(0, "Saturday").isDisplayed());
		softAssertion.assertEquals(ce.getGreenTextLabel().getText(), "Green text indicates current enrollment");
		softAssertion.assertEquals(ce.getItalicTextLabel().getText(), "Italic text indicates standby enrollment");
		softAssertion.assertTrue(!ce.getUnenrollButton().isEnabled(), "Unenroll Button is Not Enabled");
		softAssertion.assertTrue(ce.getEnrollButton().isEnabled(), "Enroll Button is Enabled");
		softAssertion.assertTrue(ce.getCloseButton().isEnabled(), "Close Button is Enabled");
		softAssertion.assertTrue(ce.getClearAllButton().isEnabled(), "Clear All Button is Enabled");
		softAssertion.assertAll();
			
	}
	
	@Test(priority = 2, enabled = true)
	public void closeWindow(){
		
		ce.getCloseButton().click();
		
		//Assert.assertTrue(ce.getPageLocator().isDisplayed());
	}
	
	  @AfterClass
	  public void tearDown(){
	  MyActions.focusByNativeWindowHandleIndex(0); 
	  driver.close(); 
	  driver.quit(); 
	  }
	 
}
