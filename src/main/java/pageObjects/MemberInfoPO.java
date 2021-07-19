package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import resources.base;

public class MemberInfoPO extends base{

	// ** Constructor **
	public void setDriver(WindowsDriver driver) {
		base.driver = driver;
	}

	// ** Objects **
	
	public WebElement getPageLocator() {
		return driver.findElementByAccessibilityId("MemberInfoView");
	}
	
	public WebElement getMemberNameLabel() {
		// upper left corner
		return driver.findElementByAccessibilityId("lblMemberNameValue");
	}

	public WebElement getMemberPaneMemberNameValue() {
		// inside Member section
		return driver.findElementByAccessibilityId("lblNameValue");
	}
	
	public WebElement getCloseButton(){
		return driver.findElementByXPath("//Button[@Name='Close'][1]");
	}
	
	public WebElement getChangeMemberId(){
		return driver.findElementByAccessibilityId("pbChangeBarcode");
	}
	
	public WebElement getChangeStatus(){
		return driver.findElementByAccessibilityId("pbChangeStatus");
	}
	
	public WebElement getTakePicture(){
		return driver.findElementByAccessibilityId("pbTakePicture");
	}
	
	public WebElement getMemberNotes(){
		return driver.findElementByAccessibilityId("pbMemberNotes");
	}
	
	public WebElement getManageDocuments(){
		return driver.findElementByAccessibilityId("pbManageDocuments");
	}
	
	public WebElement getEWaivers(){
		return driver.findElementByAccessibilityId("pbEWaiver");
	}
	
	public WebElement getChangeRequestHistory(){
		return driver.findElementByAccessibilityId("pbChangeRequestHistory");
	}
	
	public WebElement getAccountStatus(){
		return driver.findElementByAccessibilityId("pbAccountStatus");
	}
	
	
	public WebElement getCheckInHistory(){
		return driver.findElementByAccessibilityId("pbCheckInHistory");
	}
	
	public WebElement getPersonalTraining(){
		return driver.findElementByAccessibilityId("pbPersonalTraining");
	}
	
	public WebElement getBillingRelationship(){
		return driver.findElementByAccessibilityId("pbBillingRelationship");
	}
	
	public WebElement getClassInformation(){
		return driver.findElementByAccessibilityId("pbClassInformation");
	}
	
	public WebElement getAppointments(){
		return driver.findElementByAccessibilityId("pbAppointments");
	}
	
	public WebElement getAgreements(){
		return driver.findElementByAccessibilityId("pbAgreements");
	}
	
	public WebElement getFamilyMember(){
		return driver.findElementByAccessibilityId("pbFamilyMember");
	}
	
	public WebElement getActionItems(){
		return driver.findElementByAccessibilityId("pbActionItems");
	}
	
	public WebElement getBiometrics(){
		return driver.findElementByAccessibilityId("pbBiometrics");
	}
	
		
	public WebElement getMembershipType(){
		return driver.findElementByAccessibilityId("lblTypeValue");
	}
	
	public WebElement getViewWindowClose1(){
		return driver.findElementByAccessibilityId("btnCancel");
	}
	
	public WebElement getViewWindowClose2(){
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getViewWindowClose3(){
		return driver.findElementByAccessibilityId("btnClose");
	}
	
	public WebElement getViewWindowClose4(){
		return driver.findElementByAccessibilityId("pbClose");
	}
	
	public WebElement getMemberAccountSummaryView(){
		return driver.findElementByAccessibilityId("MemberAccountSummaryView");
	}
	
	public WebElement getMemberCheckInHistoryView(){
		return driver.findElementByAccessibilityId("MemberCheckInHistoryView");
	}
	
	public WebElement getTrainingVisitHistoryView(){
		return driver.findElementByAccessibilityId("TrainingVisitHistoryView");
	}
	
	public WebElement getBillingRelationshipView(){
		return driver.findElementByAccessibilityId("FamilyMembersView");
	}
	
	public WebElement getClassInformationView(){
		return driver.findElementByAccessibilityId("ClassInformationView");
	}
	
	public WebElement getManageDocumentsView(){
		return driver.findElementByAccessibilityId("BrowseDocumentView");
	}
	
	public WebElement getAppointmentInformationView(){
		return driver.findElementByAccessibilityId("AppointmentInformationView");
	}
	
	public WebElement getManageAgreementView(){
		return driver.findElementByAccessibilityId("ManageAgreementView");
	}
	
	public WebElement getFamilyMembersView(){
		return driver.findElementByAccessibilityId("FamilyMemberView");
	}
	
	public WebElement getActionItemsView(){
		return driver.findElementByAccessibilityId("ActionItemsView");
	}
	
	public WebElement getMemberNotesView(){
		return driver.findElementByAccessibilityId("BaseNotesHistory");
	}
	
	public WebElement getChangeRequestHistoryView(){
		return driver.findElementByAccessibilityId("ChangeRequestsHistoryView");
	}
	
	public WebElement getManageEWaiverView(){
		return driver.findElementByAccessibilityId("ManageEWaiverView");
	}
	
	public WebElement getNewMemberIdField(){
		return driver.findElementByAccessibilityId("txtNewBarcode");
	}
	
	public WebElement getNewButon(){
		return driver.findElementByAccessibilityId("pbNew");
	}
	
	public WebElement getOkButon(){
		return driver.findElementByAccessibilityId("pbOK");
	}
	
	public WebElement getCancelButon(){
		return driver.findElementByAccessibilityId("pbCancel");
	}
	
	public WebElement getStatusName(int index){
		return driver.findElementByName("Status Row "+index+", Not sorted.");
	}
	
	public WebElement getChangeStatusOkButton(){
		return driver.findElementByAccessibilityId("btnOk");
	}
	
	public WebElement getChangeStatusComment(){
		return driver.findElementByAccessibilityId("txtComments");
	}
	
	public WebElement getMemberStatus(){
		return driver.findElementByAccessibilityId("lblStatusValue");
	}
	
	public WebElement getMemberId(){
		return driver.findElementByAccessibilityId("lblBarcodeValue");
	}
	
	public WebElement getChangeMemberIdOkButton(){
		return driver.findElementByAccessibilityId("btnOK");
	}
	
	public WebElement getCancelEmailButton(){
		return driver.findElementByAccessibilityId("btnCancel");
	}
}
