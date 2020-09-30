package resources;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import pageObjects.UpdateFoundPO;

public class base {

	public static WindowsDriver driver;
	public static Properties prop;
	static String projectPath = System.getenv("CompeteFD_HOME");

	public static UpdateFoundPO uf = new UpdateFoundPO();

	public static WindowsDriver initializeDriver() throws Throwable {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getenv("user.dir") + "\\src\\main\\java\\resources\\properties");
		prop.load(fis);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\Program Files (x86)\\JonasFitness\\Compete\\Front Desk.exe");
		
		Thread.sleep(5000); // This wait helps avoid a SessionNotCreatedException
		
		WindowsDriver Session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

		Session.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		DesiredCapabilities Appcapabilities = new DesiredCapabilities();
		Appcapabilities.setCapability("app", "Root");
		Appcapabilities.setCapability("ms:experimental-webdriver", true); // performance improvement for XPath
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), Appcapabilities);

		try {

			WebDriverWait waitForUpdateFound = new WebDriverWait(driver, 5);
			waitForUpdateFound.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Update Found")));

			if (uf.getPageLocator().isDisplayed()) {
				System.out.println("INFO: Update Found");
				uf.getOKButton().click();
				WebDriverWait waitForCancelButton = new WebDriverWait(driver, 30);
				waitForCancelButton.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Cancel")));
				uf.getNextButton().click();

				try {
					while (uf.getInstallingUpdatesLabel().isDisplayed()) {
						Thread.sleep(1000);
					}
				} catch (NoSuchElementException e) {

				}
				System.out.println("INFO: Update Complete");
				initializeDriver(); // launch Front Desk again after update is complete
			}

		} catch (TimeoutException to) {

		}

		WebDriverWait waitForLogin = new WebDriverWait(driver, 30);
		waitForLogin.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("Employee Login")));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

}
