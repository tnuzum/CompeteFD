package winAppDriverResearch;


import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.AboutPagePO;
import pageObjects.LandingPagePO;
import resources.MyActions;
import resources.base;

public class CheckInTest extends base {
	
    String natWinHandle;
    String natWinHandle2;
    String NativeWindowHandle;
    String NativeWindowHandle2;
    //public MyActions ma;
        
    @BeforeClass
    public void initialize() throws Throwable {
    	
			driver = initializeDriver();
    }
 
    @Test (enabled = true)
    public void launchCheckIn() throws Exception{
    	
			String barcodeId = prop.getProperty("Employee1UserName");
			String password = prop.getProperty("Employee1Password");
    	
			MyActions ma = new MyActions(driver);
			ma.loginEmployee(barcodeId, password);
	
    		LandingPagePO la = new LandingPagePO(driver);
    	      
	        WebDriverWait wait=new WebDriverWait(driver, 60);
	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));
	        
	        String NativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
	        //String NativeWindowHandle = driver.findElementByAccessibilityId("ShellForm").getAttribute("NativeWindowHandle");
	        natWinHandle = MyActions.convertNativeWindowHandle(NativeWindowHandle);
	        
	        DesiredCapabilities appCapabilities = new DesiredCapabilities();
	        appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
	        driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), appCapabilities);
	        //System.out.println(driver.getTitle());
	        
	        //la.getCompeteInfoButton().click();
        	driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]").click();
    }
    
    @Test (priority = 2, enabled = true)
    public void CheckIn() throws Exception{
    	
		String barcodeId = prop.getProperty("Employee1UserName");
		String password = prop.getProperty("Employee1Password");
	
		MyActions ma = new MyActions(driver);
		ma.loginEmployee(barcodeId, password);
    	      
	        WebDriverWait wait=new WebDriverWait(driver, 60);
	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));
	        
	        String NativeWindowHandle = driver.findElementByAccessibilityId("ShellForm").getAttribute("NativeWindowHandle");
	        natWinHandle = MyActions.convertNativeWindowHandle(NativeWindowHandle);
	        
	        DesiredCapabilities appCapabilities = new DesiredCapabilities();
	        appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
	        driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), appCapabilities);
	        System.out.println(driver.getTitle());

        	driver.findElementByXPath("//Button[@LocalizedControlType='button'][2]").click();// click CheckIn
        
		    String NativeWindowHandle2 = driver.findElementByAccessibilityId("ShellForm").getAttribute("NativeWindowHandle");
		  	int natWinHandleInt2 = Integer.parseInt(NativeWindowHandle2);
		  	String natWinHandleStr2 = Integer.toHexString(natWinHandleInt2);
		  	natWinHandle = "0x"+natWinHandleStr2;
	
	        DesiredCapabilities appCapabilities2 = new DesiredCapabilities();
	        appCapabilities2.setCapability("appTopLevelWindow", natWinHandle);
	        driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), appCapabilities2);
	        Thread.sleep(3000);
	        driver.findElementByAccessibilityId("txtBarcodeId").sendKeys("Manny");

    }
 
    @AfterClass
    public void TearDown() throws Throwable
    {
    	Thread.sleep(10000);
    	driver.close();

    }
    
}

