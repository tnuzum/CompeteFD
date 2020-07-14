package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class AgreementsPO extends base{

	// ** Constructor **
	public void agreements(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	

	public WebElement getAgreementsPageHeaderLabel() {
		return driver.findElementByAccessibilityId("lblModule");
	}
	
	public WebElement getSearchAgreementsButton() {
		return driver.findElementByAccessibilityId("pbSearchAgreements");
	}
	
	public WebElement getNewAgreementButton() {
		return driver.findElementByAccessibilityId("pbNewAgreement");
	}
	
	public WebElement getModifyAgreementButton() {
		return driver.findElementByAccessibilityId("pbAddOn");
	}
	
	public WebElement getRewriteAgreementButton() {
		return driver.findElementByAccessibilityId("pbRewriteAgreement");
	}
	
	public WebElement getRenewAgreementButton() {
		return driver.findElementByAccessibilityId("pbRenewalAgreement");
	}
	
	public WebElement getAddGuestButton() {
		return driver.findElementByAccessibilityId("pbAddAGuest");
	}
	
	public WebElement getSellClubLabel() {
		return driver.findElementByAccessibilityId("lblSellClub");
	}
	
	public WebElement getSellClubComboBox() {
		return driver.findElementByAccessibilityId("cmbSellClub");
	}
	
	public WebElement getAgreementTypeLabel() {
		return driver.findElementByAccessibilityId("lblAgreementType");
	}
	
	public WebElement getAgreementTypeValue() {
		return driver.findElementByAccessibilityId("lblDisplayAgreementType");
	}
	
	public WebElement getMemberInfoLabel() {
		return driver.findElementByAccessibilityId("lblMember");
	}
	
	public WebElement getManageDocumentsButton() {
		return driver.findElementByAccessibilityId("btnManageDocuments");
	}
	
	public WebElement getMemberIDLabel() {
		return driver.findElementByAccessibilityId("lblMemberID");
	}
	
	public WebElement getMemberIDValue() {
		return driver.findElementByAccessibilityId("lblDisplayMemberID");
	}
	
	public WebElement getPersonalTab() {
		return driver.findElementByName("Personal");
	}
	
	public WebElement getOtherTab() {
		return driver.findElementByName("Other");
	}
	
	public WebElement getResponsibilityTab() {
		return driver.findElementByName("Responsibility");
	}
	
	public WebElement getPrintButton() {
		return driver.findElementByAccessibilityId("btnPrint");
	}
	
	public WebElement getAddSignatureButton() {
		return driver.findElementByAccessibilityId("btnAddSignature");
	}
	
	public WebElement getCloseButton() {
		
		//return driver.findElementByAccessibilityId("btnClose");
		return driver.findElementByXPath("//Button[@Name='Close'][1]");
	}
	
	
	
	
	
	
	
		
}
