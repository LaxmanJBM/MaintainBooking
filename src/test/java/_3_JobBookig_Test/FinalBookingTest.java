package _3_JobBookig_Test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import Base.Browser;
import MaintainBooking._3_BookingFinal;
import MaintainBooking._3_FinalBooking;
import MaintainBooking._3_JobBooking1;

public class FinalBookingTest extends Browser{
	
	
	_3_JobBooking1 jb1;
	_3_FinalBooking jb2;
	
	_3_BookingFinal fb;
	

	@BeforeMethod
	public void setup() throws Exception {

		initilization();
		jb1 = new _3_JobBooking1();
		jb2 = new _3_FinalBooking();
		
		fb=new _3_BookingFinal();
		jb1.verifyLoginApp();
		Thread.sleep(2000);

		jb1.verifyIFFBtn();
		Thread.sleep(2000);
		jb1.verifySalesBtn();
		Thread.sleep(2000);
		jb1.verifyBookingBtn();
		Thread.sleep(2000);
		jb2.verifyNewBtn();
	//	jb2.verifyestimatedRadioBtn();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
	}


	
	@Test( enabled =true)
	public void data() throws Exception {
		
		
		
		for(int exec=1;exec<=7;exec++) {
			Thread.sleep(2000);
		jb2.verifyBasicDetails(exec);
		
		jb2.verifyServiceDetails(exec);
		
		jb2.verifyAdditionalDetails(exec);
		
		jb2.allContanerDetails(exec);
		
		jb2.allVehiPackingList(exec);
		
	//	jb2.verifyCostRevenue(exec);
		
		jb2.costRevenuePop(exec);
		
	//	jb2.verifySaveBtn();
		jb2.verifyBookingSave();
	//	jb2.jobSave();
	}
	
		
	
	/*	fb.verifyBasicDetails();
		fb.verifyServiceDetails();
		fb.verifyAdditionalDetails();
		fb.allContanerDetails();
		fb.allVehiPackingList();
		fb.verifyCostRevenue();
		fb.verifySaveBtn(); */
	
		
		
		
		
		
		
		
	/*	 jb2.verifyBasicBtn();
		 jb2.verifyestimatedRadioBtn();
		 jb2.verifySelectDrop();
		 jb2.verifyServiceDrop();
		 Thread.sleep(800);
		 jb2.verifyDocType();
		 jb2.verifyDate();
		 jb2.verifyDeliveryAgent();
		 jb2.verifyMasterJob();
		 jb2.verifyMasterOrCarrierDoc();
		 jb2.verifyCarrierDocDate();
		 jb2.verifyBookingSource();
		 jb2.verifyNominationAgent();
	 //  jb2.verifyNominationOU();  Auto filled
		 jb2.verifyHouseDoc();
		 jb2.verifyHouseDocDate();
		 jb2.verifyCustomsDoc();
		 jb2.verifyCustomer();     
		 jb2.verifyCustomerEmail();
	//	 jb2.verifyCustomerOU();//  Auto filled
		 jb2.verifyACNumber();
		 jb2.verifySalesPerson();// Auto filled
	//	 jb2.verifyOffice();//      Auto filled
	//	 jb2.verifySalesTeam();//   Auto filled
		 jb2.verifyCarrier();
		 jb2.verifyCarrierBookRef();
		 jb2.verifyCommodity();
		 jb2.verifyCustServicePerson();
		 jb2.verifyCustRef();
		 jb2.verifyOrigin();
		 jb2.verifyDestination();
		 jb2.verifyRoute();
	//	 jb2.verifyLoadPort();    Auto filled
		 jb2.verifyDischPortText();
		 jb2.verifyFlight();
		 jb2.verifyVoyage();
		 jb2.verifyFreightTerms();
		 jb2.verifyOriginAgent();
		 jb2.verifyDeliveryAgent2();
		 jb2.verifyShipmentType();
		 jb2.verifyCoload();
		 jb2.verifyBrokeText();
		 jb2.verifyPickupTerm();
		 jb2.verifyDeliveryTerm();
		 Thread.sleep(2000);
		 jb2.verifyLoadType();
		 jb2.verifyTSLocalDelivery();
		 jb2.verifyTSLocalDeliveryRemark();
	//	 jb2.verifyWeight();    Auto filled
	//	 jb2.verifyVolume();    Auto filled
		 jb2.verifyChargWtOrFrtTone();
		 jb2.verifyHSCodeText();
		 jb2.verifyDangGood();
		 jb2.verifyIMDGDetails();
		 jb2.verifyFtContaner20();
		 jb2.verifyFtContaner40();
	//	 jb2.verifyNoPackg();    Auto filled
		 jb2.verifyitemDetails();
	//	 jb2.verifyServiceDrop();*/
		
		 
//Service Details		 
	/*	 jb2.verifyServiceDetailsBtn();
		 jb2.verifyShipperNameText();
		 jb2.verifyShipperAddress();
		 jb2.verifyConsigneeNameText();
		 jb2.verifyConsigneeAddress();
		 jb2.verifyNotifyNameText();
		 jb2.verifyNotifyAddress();
		 jb2.verifyCHAName();
		 jb2.verifyCHAAddress();
		 jb2.verifyCHANumber(); 
		 jb2.verifyETDDate();
		 jb2.verifyCutOffDate();
		 jb2.verifySailingDate();
		 jb2.verifyVGMCutOffDate();
		 jb2.verifyDocCutOff();
		 jb2.verifySlectDropOriginOpe();
		 jb2.verifyETADate();
		 jb2.verifyArrivalTest();
		 jb2.verifyDeliveryDate();
		 jb2.verifyDestinationDelivery();
		 jb2.verifyDestinationCoustoms();
		 jb2.verifyScroll();
		 jb2.verifyTOS();
		 jb2.verifyServiceDetails();
		 jb2.verifyOperInstruction();
		 jb2.verifyTransporter();
		 jb2.verifyVehicalDetails();
		 jb2.verifyCFSDropdown();*/

//Additional Details		 
	/*	 jb2.verifyAdditionalDetailsBtn();
		 jb2.verifyMarksAndNumber();
		 jb2.verifyCargoDesc();
		 jb2.verifyIMGNo();
		 jb2.verifyIMGDateText();
		 jb2.verifyItemNo();
		 jb2.verifyItemType();
		 jb2.verifyStuffingText();
		 jb2.verifyCIRef();
		 jb2.verifyCIDate();
		 jb2.verifyCICurrency();
		 jb2.verifyCIValue();
		 jb2.verifyAttributes();
		
		 jb2.allContanerDetails();        //Trial 
    	 jb2.allVehiPackingList();        //Trial
   // 	 jb2.allVehiPackingListIF();
 //*   	 jb2.verifyFinalRemarks();
		 
//COST AND REVENUE DETAILS	
		 jb2.verifyRevAdCostBtn();
		 jb2.verifyQuotationNoText();
		 jb2.verifyRemarksC();
	//	 jb2.verifySubmitBtn();///
		 jb2.verifyCostRevenue();     //Trial
		 
		 jb2.verifySaveBtn();
		 jb2.verifyReports();  */
	}
	

	@AfterMethod
	
	public void exit()
	{
	//	driver.quit();
	}
	
	
	
	
	
	

}
