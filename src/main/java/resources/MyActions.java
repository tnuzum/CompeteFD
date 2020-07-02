package resources;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.LoginPO;

public class MyActions{
	
		WindowsDriver driver;
	
	public MyActions(WindowsDriver driver) {
			// TODO Auto-generated constructor stub
		
			this.driver = driver;
		}
	
	public String loginEmployee(String barcodeId, String password) {
		
    	LoginPO l = new LoginPO(driver);
    	l.getUserNameInputField().sendKeys(barcodeId);
    	l.getPasswordInputField().sendKeys(password);
    	l.getLoginButton().click(); 
    	return null;
	}

	public static String convertNativeWindowHandle(String NativeWindowHandle){
		
		String natWinHandle;
		
        //String NativeWindowHandle = driver.findElementByAccessibilityId("ShellForm").getAttribute("NativeWindowHandle");
    	int natWinHandleInt = Integer.parseInt(NativeWindowHandle);
    	String natWinHandleStr = Integer.toHexString(natWinHandleInt);
    	natWinHandle = "0x"+natWinHandleStr;
		System.out.println(natWinHandle);
        
		return natWinHandle;
	}
	
	public void focusOnLandingPage(String NativeWindowHandle) throws Exception {
		
		//String NativeWindowHandle = driver.findElementByAccessibilityId("ShellForm").getAttribute("NativeWindowHandle");
    	int natWinHandleInt = Integer.parseInt(NativeWindowHandle);
    	String natWinHandleStr = Integer.toHexString(natWinHandleInt);
    	String natWinHandle = "0x"+natWinHandleStr;
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
        driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), appCapabilities);
	}
	
	
}
