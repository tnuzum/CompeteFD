package resources;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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

		MyActions.myWaitByName(30, "deckWorkspace1");

		return null;
	}

	public static void myWaitByName(int duration, String locatorName) {

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
	
	public static String purchaseItemWithCash(String item1BarcodeId) {

			MyActions.focusByNativeWindowHandleIndex(0);

			p.getProductSearchInputField().sendKeys(item1BarcodeId);

			p.getProductSearchSearchButton().click();

			p.getTotalButton().click();

			p.getCategoryChoice(2).click();

			MyActions.focusByNativeWindowHandleIndex(0);

			pa.getPayAmt20DollarsButton().click();

			p.getOKButton().click();
			
			MyActions.focusByNativeWindowHandleIndex(0);

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
	
	public static String getToken(String barcodeId, String expirationTimeSpan ) {
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		//barcodeId = "99959";// prop.getProperty("availableUserName");
//		String expirationTimeSpan = "00:10:00";

		Response res =
				
			given()
				.log().all()
				.header("X-Api-Key", prop.getProperty("aPIKey"))
				.header("X-CompanyId", prop.getProperty("X-CompanyId"))
				.header("X-ClubId", prop.getProperty("club1Id"))
				.header("Content-Type", "application/json")
			.when()
				.body(MyActions.getMemberToken(barcodeId, expirationTimeSpan))
				.post("/api/v3/member/getcustomertoken").
			then()
				.log().all()
				.assertThat().statusCode(200)
				.extract().response();	
		
			JsonPath js = MyActions.rawToJson(res);
			String token = js.get("Result");
			
			return token;
	}
	
		
	public static String getMemberToken(String barcodeId, String expirationTimeSpan) {
	

		String payload = "{\r\n"
		+ "  \"BarcodeId\": \""+barcodeId+"\",\r\n"
		+ "  \"ExpirationTimeSpan\": \""+expirationTimeSpan+"\"\r\n"
		+ "}";
		return payload;	
		}
	

}
