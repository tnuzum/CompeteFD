package frontDeskTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckInPO;
import pageObjects.LandingPagePO;
import pageObjects.MemberSearchPO;
import resources.MyActions;
import resources.base;

public class CheckIn extends base {
	
	LandingPagePO la;
	CheckInPO ci;
	MemberSearchPO ms;

	@BeforeClass
	public void initialize() throws Throwable {

		System.out.println("Class: "+getClass().getName());
		driver = initializeDriver();
		
		la = new LandingPagePO();
		ci = new CheckInPO();
		ms = new MemberSearchPO();
	}

	@Test(priority = 1, enabled = true)
	public void launchCheckIn() throws Exception {

		String barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		String password = prop.getProperty("activeEmployeePassword");

		MyActions.loginEmployee(barcodeId, password);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

		la.getCheckInButton().click();

	}

	@Test(priority = 2)
	public void validatePageObjects() {

		Assert.assertTrue(ci.getCheckInModeLabel().isDisplayed());
		Assert.assertEquals(ci.getCheckInModeLabel().getText(), "Check In | Attended");
		Assert.assertTrue(ci.getMemberInputLabel().isDisplayed());
		Assert.assertEquals(ci.getMemberInputLabel().getText(), "Member ID / Last Name");
		Assert.assertTrue(ci.getMemberInputField().isEnabled());
		Assert.assertTrue(ci.getSearchButton().isEnabled());
		// Assert.assertEquals(ci.getSearchButton().getText(), "Search");
		Assert.assertTrue(ci.getClearMemberButton().isEnabled());
		//Assert.assertEquals(ci.getClearMemberButton().getText(), "Clear Member");
		Assert.assertTrue(!ci.getTakePictureButton().isEnabled()); //disabled prior to adding member
		//Assert.assertEquals(ci.getTakePictureButton().getText(), "Take Picture");
		Assert.assertTrue(!ci.getMemberInfoButton().isEnabled()); //disabled prior to adding member
		//Assert.assertEquals(ci.getMemberInfoButton().getText(), "Member Info");
		Assert.assertTrue(!ci.getMemberNotesButton().isEnabled()); //disabled prior to adding member
		//Assert.assertEquals(ci.getMemberNotesButton().getText(), "Member Notes");
		Assert.assertTrue(!ci.getChangeRequestButton().isEnabled()); //disabled prior to adding member
		//Assert.assertEquals(ci.getChangeRequestButton().getText(), "Change Request");
		Assert.assertTrue(ci.getTodaysCheckInsButton().isEnabled());
		//Assert.assertEquals(ci.getTodaysCheckInsButton().getText(), "Today's Check-ins");
		Assert.assertTrue(ci.getCheckInModeButton().isEnabled());
		//Assert.assertEquals(ci.getCheckInModeButton().getText(), "Check-In Mode");
		Assert.assertTrue(ci.getAddGuestButton().isEnabled());
		//Assert.assertEquals(ci.getAddGuestButton().getText(), "Add Guest");
		
	}
	
	@Test(priority = 3, enabled = true)
	public void searchMember() throws Exception {
		
		ci.getMemberInputField().sendKeys("Manny");
		ci.getSearchButton().click();
		
        WebDriverWait wait=new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Member Quick Search")));

		Assert.assertTrue(ms.getMemberSearchPageLocator().isDisplayed());
		ms.getOKButton().click();
	}
	@Test(priority = 4)
	public void clearMember() {
		
		ci.getMemberInputField().sendKeys("Manny");
		ci.getClearMemberButton().click();
		Assert.assertNotEquals(ci.getMemberInputField().getText(), "Manny");
	}

	@AfterClass
	public void TearDown() throws Exception{
		driver.close();
		driver.quit();
	}

}
