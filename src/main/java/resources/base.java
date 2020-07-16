package resources;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import junit.framework.Assert;

public class base {

	public static WindowsDriver driver;
	public static Properties prop;
	static String projectPath = System.getenv("CompeteFD_HOME");

	public WindowsDriver initializeDriver() throws Throwable {
		
		prop = new Properties();
		FileInputStream fis=new FileInputStream(projectPath + "\\src\\main\\java\\resources\\properties");
		prop.load(fis);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\Program Files (x86)\\JonasFitness\\Compete\\Front Desk.exe");
		WindowsDriver Session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

		Assert.assertNotNull(Session);
		Session.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		DesiredCapabilities Appcapabilities = new DesiredCapabilities();
		Appcapabilities.setCapability("app", "Root");
		Appcapabilities.setCapability("ms:experimental-webdriver", true); //this is supposed to make XPath lookups faster
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), Appcapabilities);
		
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Employee Login")));
        

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

}
