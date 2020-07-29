package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pageObjects.LandingPagePO;
import pageObjects.ReportsPO;
import resources.MyActions;
import resources.base;

public class Reports extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	ReportsPO r;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;

	@BeforeClass
	public void initialize() throws Throwable{
		
		System.out.println("Test Class: "+getClass().getName());
		driver = initializeDriver();
		
		la = new LandingPagePO();
		r = new ReportsPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
	}

	@Test(priority = 1, enabled = true)
	public void launchReports(){

		MyActions.loginEmployee(barcodeId, password);

		la.getMoreButton().click();
		
		la.getMoreButtons(4).click();

		Assert.assertTrue(r.getPageLabel().isDisplayed());
	}
	
	@Test(priority = 2, enabled = true)
	public void validatePageObjects(){
		
		softAssertion.assertEquals(r.getPageLabel().getText(), "Reports");
		softAssertion.assertTrue(r.getReportTypeLabel().isDisplayed());
		softAssertion.assertEquals(r.getReportType(0).getText(), "Accounting");
		softAssertion.assertEquals(r.getReportType(1).getText(), "Agreements");
		softAssertion.assertEquals(r.getReportType(2).getText(), "Bookings");
		softAssertion.assertEquals(r.getReportType(3).getText(), "Employee");
		softAssertion.assertEquals(r.getReportType(4).getText(), "Members");
		softAssertion.assertEquals(r.getReportType(5).getText(), "Nursery");
		softAssertion.assertEquals(r.getReportType(6).getText(), "Products");
		softAssertion.assertEquals(r.getReportType(7).getText(), "Prospects");
		softAssertion.assertEquals(r.getReportType(8).getText(), "Tracking");
		softAssertion.assertTrue(r.getReport(0).isDisplayed());
		softAssertion.assertTrue(r.getReport(1).isDisplayed());
		softAssertion.assertTrue(r.getReport(2).isDisplayed());
		softAssertion.assertTrue(r.getReport(3).isDisplayed());
		softAssertion.assertTrue(r.getReport(4).isDisplayed());
		softAssertion.assertTrue(r.getReport(6).isDisplayed());
		softAssertion.assertTrue(r.getReport(7).isDisplayed());
		softAssertion.assertAll();
	}
	
	@Test(priority = 3, enabled = false)
	public void validateReportHeaders(){
		
		// !! Work In Progress -- Compete Unhandled exception when report is clicked
		
//		String reportName;
		Actions a = new Actions(driver);
		//a.click(r.getReport(0)).perform();
		
		a.moveToElement(r.getReport(0)).sendKeys(Keys.ENTER).build().perform();
//		r.getReportType(1).click();
//		r.getReport(0).click();
//		reportName = r.getReport(0).getText();
//		Assert.assertEquals(r.getReportTitleBarLabel().getText(), reportName);
//		Assert.assertTrue(r.getReportTypeLabel().getText().contains(reportName));

//		r.getReport(1).click();
//		reportName = r.getReport(1).getText();
//		Assert.assertEquals(r.getReportTitleBarLabel().getText(), reportName);
//		Assert.assertTrue(r.getReportTypeLabel().getText().contains(reportName));
		
		

	}
	
	
	@Test(priority = 4, enabled = false)
	public void accountingCancelledPaymentsByDate(){
		
		// !! Work In Progress -- Compete Unhandled exception when report is clicked
		
		r.getReport(0).click();

		softAssertion.assertEquals(r.getDateRangeLabel().getText(), "Date Range");
		softAssertion.assertEquals(r.getStartDateLabel().getText(), "Start Date");
		softAssertion.assertTrue(r.getStartDateCombobox().isEnabled());
		softAssertion.assertEquals(r.getEndDateLabel().getText(), "End Date");
		softAssertion.assertTrue(r.getEndDateCombobox().isEnabled());
		
		softAssertion.assertAll();
	}

	@AfterClass (enabled = true)
	public void tearDown(){
		driver.close();
		driver.quit();
	}

}
