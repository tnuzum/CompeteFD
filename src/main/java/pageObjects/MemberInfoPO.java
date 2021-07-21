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
	
	public WebElement getPTRemainingTab(){
		return driver.findElementByName("P/T Remaining");
	}
	
	public WebElement getPTRemainingPanel(){
		return driver.findElementByAccessibilityId("pnlTrainingRemainingLayout");
	}
	
	public WebElement getPTHistoryTab(){
		return driver.findElementByName("P/T History");
	}
	
	public WebElement getPTHistoryPanel(){
		return driver.findElementByAccessibilityId("tpnlTrainingHistoryBaseLayout");
	}
	
	public WebElement getVisitisRemainingTab(){
		return driver.findElementByName("Visits Remaining");
	}
	
	public WebElement getVisitisRemainingPanel(){
		return driver.findElementByAccessibilityId("pnlVisitRemainingLayout");
	}
	
	public WebElement getVisitsHistoryTab(){
		return driver.findElementByName("Visits History");
	}
	
	public WebElement getVisitisHistoryPanel(){
		return driver.findElementByAccessibilityId("tabVisitsHistory");
	}
	
	public WebElement getBillingRelationshipView(){
		return driver.findElementByAccessibilityId("FamilyMembersView");
	}
	
	public WebElement getFamilyMembersTab(){
		return driver.findElementByName("Family Members");
	}
	
	public WebElement getFamilyMembersPanel(){
		return driver.findElementByAccessibilityId("pnlMainTimeRestriction");
	}
	
	public WebElement getOrganizationalMembersTab(){
		return driver.findElementByName("Organizational Members");
	}
	
	public WebElement getOrganizationalMembersPanel(){
		return driver.findElementByAccessibilityId("panel1");
	}
	
	public WebElement getClassInformationView(){
		return driver.findElementByAccessibilityId("ClassInformationView");
	}
	
	public WebElement getAttendanceTab(){
		return driver.findElementByName("Attendance");
	}
	
	public WebElement getAttendancePanel(){
		return driver.findElementByAccessibilityId("pnlAttendance");
	}
	
	public WebElement getEnrollmentab(){
		return driver.findElementByName("Enrollment");
	}
	
	public WebElement getEnrollmenPanel(){
		return driver.findElementByAccessibilityId("pnlEnrollment");
	}
	
	public WebElement getManageDocumentsView(){
		return driver.findElementByAccessibilityId("BrowseDocumentView");
	}
	
	public WebElement getAppointmentInformationView(){
		return driver.findElementByAccessibilityId("AppointmentInformationView");
	}
	
	public WebElement getCurrentViewTab(){
		return driver.findElementByName("Current");
	}
	
	public WebElement getCurrentViewPanel(){
		return driver.findElementByAccessibilityId("pnlCurrent");
	}
	
	public WebElement getHistoryTab(){
		return driver.findElementByName("History");
	}
	
	public WebElement getHistoryPanel(){
		return driver.findElementByAccessibilityId("pnlHistory");
	}
	
	public WebElement getManageAgreementView(){
		return driver.findElementByAccessibilityId("ManageAgreementView");
	}
	
	public WebElement getHelpButton(){
		return driver.findElementByAccessibilityId("btnHelp");
	}
	
	public WebElement getInvoicesButton(){
		return driver.findElementByAccessibilityId("btnInvoices");
	}
	
	public WebElement getModifyButton(){
		return driver.findElementByAccessibilityId("btnModify");
	}
	
	public WebElement getRewriteButton(){
		return driver.findElementByAccessibilityId("btnRewrite");
	}
	
	public WebElement getRenewButton(){
		return driver.findElementByAccessibilityId("btnRenew");
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
	
	public WebElement getCurrentEWaiverTab(){
		return driver.findElementByName("Current");
	}
	
	public WebElement getCurrentEWaiverPanel(){
		return driver.findElementByAccessibilityId("dgvEWaiverCurrent");
	}
	
	public WebElement getEWaiverHistoryTab(){
		return driver.findElementByName("History");
	}
	
	public WebElement getEWaiverHistoryPanel(){
		return driver.findElementByAccessibilityId("dgvEWaiverHistory");
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
	
	public WebElement getContinueCancelYes(){
		return driver.findElementByAccessibilityId("btnOK");
	}
}
