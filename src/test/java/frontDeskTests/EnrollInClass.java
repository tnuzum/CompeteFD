package frontDeskTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ClassEnrollmentPO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class EnrollInClass extends base {
	
	public static SoftAssert softAssertion= new SoftAssert();

	LandingPagePO la;
	ClassEnrollmentPO ce;
	String natWinHandle;
	String nativeWindowHandle;
	String barcodeId;
	String password;
	static String classToEnroll;
	static String memberToEnroll;
	//static Process p;

	@BeforeClass
	public void initialize() throws Throwable{
		
		System.out.println("Test Class: "+getClass().getName());
		
		MyActions.startWAD();
		
		/*String command = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
		ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
		p = builder.start();*/
		
		driver = initializeDriver();
		
		la = new LandingPagePO();
		ce = new ClassEnrollmentPO();
		barcodeId = prop.getProperty("activeEmployeeBarcodeId");
		password = prop.getProperty("activeEmployeePassword");
		classToEnroll = prop.getProperty("classToEnroll");
		memberToEnroll = prop.getProperty("memberToEnroll");
		
		MyActions.loginEmployee(barcodeId, password);
		la.getMoreButton().click();
		la.getMoreButtons(8).click();
	}
	
	@Test(priority = 1, enabled = true)
	public void enrollInClass() throws InterruptedException{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyActions.myWaitByAccessibilityId(30, "pbClearButton");
		
		ce.getMemberInputField().sendKeys(memberToEnroll);
		ce.getSearchButton().click();
		
		int i = 0;
		 String classCourseName;
		
		do {classCourseName =  ce.getClassCourseName(i).getText();
		
		if (classCourseName.equals(classToEnroll))
			ce.getClassCourseName(i).click();
		else
			i++;
		}
		while(!classCourseName.equals(classToEnroll));
		
		ce.getEnrollButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getOkButton().click();
		ce.getNoButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		ce.getSendEmailOkBtn().click();
				
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getWarningOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getCloseButton().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		
		
			
	}
	
	@Test(priority = 2, enabled = true)
	public void UnenrollFromClass(){
		
		ce.getUnenrollButton().click();
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getMsgUnenrollButton().click();
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getSendEmailOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getWarningOkBtn().click();
		
		MyActions.focusByNativeWindowHandleIndex(0);
		ce.getCloseButton().click();
		
		
		//Assert.assertTrue(ce.getPageLocator().isDisplayed());
	}
	
	
	  @AfterClass 
	  public void tearDown(){
	  MyActions.focusByNativeWindowHandleIndex(0); 
	  driver.close(); 
	  driver.quit(); 
	  //p.destroy();
	  }
	 
	 
}
