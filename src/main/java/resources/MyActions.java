package resources;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;

public class MyActions extends base{
	
	public void setDriver(WindowsDriver driver) {
		
			base.driver = driver;
		}
	
	public static String loginEmployee(String barcodeId, String password) {
		
    	LoginPO l = new LoginPO();
    	l.getUserNameInputField().sendKeys(barcodeId);
    	l.getPasswordInputField().sendKeys(password);
    	l.getLoginButton().click(); 
    	return null;
	}

	public static String convertnativeWindowHandle(String nativeWindowHandle){
		
		String natWinHandle;
		
		/* Use this in test class to get nativeWindowHandle:
		   String nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		*/
		int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
    	String natWinHandleStr = Integer.toHexString(natWinHandleInt);
    	natWinHandle = "0x"+natWinHandleStr;
		//System.out.println(natWinHandle);
        
		return natWinHandle;
	}
	
	public static String focusOnLandingPage() throws MalformedURLException{
		
		/* Use this in test class to get nativeWindowHandle:
		   String nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		*/
		LandingPagePO la = new LandingPagePO();
		String nativeWindowHandle = la.getLandingPageLocator().getAttribute("NativeWindowHandle");
    	int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
    	String natWinHandleStr = Integer.toHexString(natWinHandleInt);
    	String natWinHandle = "0x"+natWinHandleStr;
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
        driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), appCapabilities);
		return null;
	}
	
	
}
