package winAppDriverResearch;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import junit.framework.Assert;

public class workingBkp {
	
  //  private static WindowsDriver<WindowsElement> Session = null;
  //  private static WebElement CalculatorResult = null;
    
    @Test

    public void LoginPage() throws Throwable {
    //public static void main(String args[])  
     //                      throws MalformedURLException, InterruptedException 
    	//{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\JonasFitness\\Compete\\Front Desk.exe");
        WindowsDriver Session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

        Assert.assertNotNull(Session);
        Session.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        DesiredCapabilities Appcapabilities = new DesiredCapabilities();
        Appcapabilities.setCapability("app", "Root");
        WindowsDriver AppSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), Appcapabilities);
        Thread.sleep(10000);

        // WebDriverWait wait=new WebDriverWait(AppSession, 30);
       
        System.out.println(AppSession.findElementByName("User ID").getText());
        AppSession.findElementByAccessibilityId("txtBarcodeId").sendKeys("todd");
        AppSession.findElementByAccessibilityId("txtPassword").sendKeys("111");
        AppSession.findElementByAccessibilityId("pbLogIn").click();
    }


}
