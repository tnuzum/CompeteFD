package winAppDriverResearch;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class LoginPage extends base {
	
    static WindowsDriver driver;

    
    @BeforeClass
    public static void initialize() {
    	try {
			driver = initializeDriver();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}  	
    }
    
    @Test 
    public void ValidateElements(){

        Assert.assertEquals("User ID", driver.findElementByAccessibilityId("lblUserID").getText());
        Assert.assertEquals("Password", driver.findElementByAccessibilityId("lblPassword").getText());
        Assert.assertEquals("Prompt for password change", driver.findElementByAccessibilityId("labelPasswordChange").getText());
        Assert.assertTrue(driver.findElementByAccessibilityId("txtBarcodeId").isEnabled());
        Assert.assertTrue(driver.findElementByAccessibilityId("txtPassword").isEnabled());
        Assert.assertTrue(driver.findElementByAccessibilityId("pbPasswordChange").isEnabled());
        Assert.assertTrue(driver.findElementByAccessibilityId("pbLogIn").isEnabled());
    }
    
   
    @AfterClass
    public static void TearDown() throws Throwable
    {
    	Thread.sleep(3000);
    	driver.quit();
    }
    
}

