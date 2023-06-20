package resources;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pageObjects.BookingsPO;
import pageObjects.LandingPagePO;
import pageObjects.LoginPO;
import pageObjects.POS_MainPagePO;
import pageObjects.POS_PaymentAmountPO;

public class MyActions extends base {
	
	//public WindowsDriver driver;

	public static LandingPagePO la = new LandingPagePO();
	public static POS_MainPagePO p = new POS_MainPagePO();
	public static POS_PaymentAmountPO pa = new POS_PaymentAmountPO();
	static String projectPath = System.getProperty("user.dir");
	

	public void setDriver(WindowsDriver driver) {

		base.driver = driver;
	}

	public static String loginEmployee(String barcodeId, String password) {

		LoginPO l = new LoginPO();
		
		WebDriverWait waitForLogin = new WebDriverWait(driver, 30);
		waitForLogin.until(ExpectedConditions.visibilityOfElementLocated(By.name("Employee Login")));

		l.getUserNameInputField().sendKeys(barcodeId);

		l.getPasswordInputField().sendKeys(password);

		l.getLoginButton().click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MyActions.myWaitByName(30, "deckWorkspace1");

		return null;
	}

	public static void myWaitByName(int duration, String locatorName) {
		try {
			Thread.sleep(5000);// this allows time for the window focus to finalize
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorName)));

	}

	public static void myWaitByAccessibilityId(int duration, String accessibilityId) {

		try {
			Thread.sleep(2000);// this allows time for the window focus to finalize
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			WebDriverWait wait = new WebDriverWait(driver, duration);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByAccessibilityId(accessibilityId)));


	}

	public static String convertnativeWindowHandle(String nativeWindowHandle) {

		String natWinHandle;

		/*
		 * Use this in test class to get nativeWindowHandle: String nativeWindowHandle =
		 * la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		 */
		int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
		String natWinHandleStr = Integer.toHexString(natWinHandleInt);
		natWinHandle = "0x" + natWinHandleStr;
		// System.out.println(natWinHandle);

		return natWinHandle;
	}

	public static String focusOnLandingPage() {

		/*
		 * Use this in test class to get nativeWindowHandle: String nativeWindowHandle =
		 * la.getLandingPageLocator().getAttribute("NativeWindowHandle");
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nativeWindowHandle = la.getPageLocator().getAttribute("NativeWindowHandle");
		int natWinHandleInt = Integer.parseInt(nativeWindowHandle);
		String natWinHandleStr = Integer.toHexString(natWinHandleInt);
		String natWinHandle = "0x" + natWinHandleStr;
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("appTopLevelWindow", natWinHandle);
		try {
			driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Native Window Handle: "+natWinHandle);
		return null;
	}
	
	public static String focusByNativeWindowHandleIndex(int index) {

		/*
		 * Use this method when WinAppDriver can find the NativeWindowHandle
		 * 
		 * use this in test class to get all Native Window Handles,
		 * System.out.println("WindowHandles: "+driver.getWindowHandles());
		 */

		try {
			Thread.sleep(2000);
			Object[] wh = driver.getWindowHandles().toArray();
			driver.switchTo().window((String) wh[index]);
		} catch (Exception e) {
			focusByNativeWindowHandleIndex(index);
		}

		return null;
	}
	
	public static void getWindowInformation() {

		System.out.println("AllSessionDetails: " + driver.getAllSessionDetails());
		System.out.println("SessionDetails: " + driver.getSessionDetails());
		System.out.println("SessionId: " + driver.getSessionId());
		System.out.println("WindowHandle: " + driver.getWindowHandle());
		System.out.println("WindowHandles: " + driver.getWindowHandles());
		System.out.println("Page Source: " + driver.getPageSource());

		return;
	}
	
	public static void performanceTestLoop() {
		// STRESS TEST EXAMPLE
		int i = 1;
		while (i <= 2) {
			la.getCheckInButton().click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			la.getPOSButton().click();
		}

		return;
	}
	
	public static void startWAD() {
		
		String wad = (projectPath +"\\src\\main\\java\\WAD\\startWAD.bat");
		
		try {
			Runtime.getRuntime().exec(wad);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return;
	}
	
	public static <WebElement> void getListItem(String ItemToSelect) {
		
		BookingsPO b = new BookingsPO();
		int i = 1;
		
		String ItemName;
		
		do {ItemName =  b.getListItem(i).getText();
		System.out.println(ItemName);
		
		if (ItemName.equals(ItemToSelect))
			b.getListItem(i).click();
		else
			i++;
		}
		while(!ItemName.equals(ItemToSelect));
		 
		
		
		
	}
	
	public static String purchaseItemWithCash(String item1BarcodeId) throws InterruptedException {
		
		Thread.sleep(10000);
			MyActions.focusByNativeWindowHandleIndex(0);

			p.getProductSearchInputField().sendKeys(item1BarcodeId);
			Thread.sleep(10000);
			p.getProductSearchSearchButton().click();
			Thread.sleep(10000);
			p.getTotalButton().click();
			Thread.sleep(10000);
			p.getCategoryChoice(2).click();
			Thread.sleep(10000);
			MyActions.focusByNativeWindowHandleIndex(0);
			Thread.sleep(5000);
			pa.getPayAmt20DollarsButton().click();
			Thread.sleep(10000);
			p.getOKButton().click();
			Thread.sleep(10000);
			MyActions.focusByNativeWindowHandleIndex(0);
			Thread.sleep(10000);
			MyActions.myWaitByName(30, "Change Due");

			p.getOKButton().click();
			
			return null;
	}

	public static JsonPath rawToJson(Response r) {

		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return x;
	}
	
	public static String getToken(String barcodeId) {
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://compete-api-future.test-jfisoftware.com:8251";//prop.getProperty("baseURI");
		
		barcodeId = "99959";// prop.getProperty("availableUserName");
		String expirationTimeSpan = "00:00:01";

		Response res =
				
			given()
//				.log().all()
				.header("X-Api-Key", prop.getProperty("aPIKey"))
				.header("X-CompanyId", "101")//.header("X-CompanyId", companyId)
				.header("X-ClubId", prop.getProperty("club1Id"))
				.header("Content-Type", "application/json")
			.when()
				.body("{\"BarcodeId\": \""+barcodeId+"\",\r\n"
						+ "  \"ExpirationTimeSpan\": \""+expirationTimeSpan+"\"\r\n"
						+ "}")
				.post("/api/v3/member/getcustomertoken").
			then()
//				.log().all()
				.extract().response();	
		
			JsonPath js = MyActions.rawToJson(res);
			String token = js.get("Result");
			
			return token;
	}
	
	public static long getSleepValue() {
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Date sv = new Date();
		String sv2 = dateFormat.format(sv);
		long sleepValue = Long.parseLong(sv2);
		return sleepValue;
		//return dateFormat.format(sv);
	}

}
