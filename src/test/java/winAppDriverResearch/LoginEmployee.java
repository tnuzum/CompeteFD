package winAppDriverResearch;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class LoginEmployee extends base {
	
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
    public void LoginEmployee1() throws InterruptedException{
    	
    	String barcodeId = prop.getProperty("Employee1UserName");
    	String password = prop.getProperty("Employee1Password");
    	
        driver.findElementByAccessibilityId("txtBarcodeId").sendKeys(barcodeId);
        driver.findElementByAccessibilityId("txtPassword").sendKeys(password);
        driver.findElementByAccessibilityId("pbLogIn").click();
        
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("deckWorkspace1")));

        Assert.assertTrue(driver.findElementByName("Privacy Policy").isDisplayed());
        // I'm not able to locate the top row buttons, I tried the following but it didn't work
//        System.out.println(driver.findElementByXPath("(//button)[1]").getText());
    }
    
   
    @AfterClass
    public static void TearDown() throws Throwable
    {
    	Thread.sleep(2000);
    	driver.quit();

    }
    
}

