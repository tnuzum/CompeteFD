package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class MyWaits extends base{
	
	WindowsDriver driver;
	
	public MyWaits(WindowsDriver driver) {
		
		//driver = driver;
	}

	public String waitForLoginPage(int duration) {
		
        WebDriverWait wait=new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Employee Login")));
        
		return null;
	}
	
}
