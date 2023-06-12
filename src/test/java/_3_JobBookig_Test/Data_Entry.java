package _3_JobBookig_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Browser;
import MaintainBooking.Revenue;
import MaintainBooking._3_JobBooking1;
import MaintainBooking._3_JobBooking2;
import Utility.CommonFiles;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Entry extends Browser{
	
	_3_JobBooking1 jb1;
	_3_JobBooking2 jb2;
	Revenue rv;
	

	@BeforeMethod
	public void setup() throws Exception {

		initilization();
		jb1 = new _3_JobBooking1();
		jb2 = new _3_JobBooking2();
		rv=new Revenue();
		jb1.verifyLoginApp();
		Thread.sleep(3000);

		jb1.verifyIFFBtn();
		Thread.sleep(2000);
		jb1.verifySalesBtn();
		Thread.sleep(2000);
		jb1.verifyBookingBtn();
		Thread.sleep(2000);
		jb2.verifyNewBtn();
		jb2.verifyestimatedRadioBtn();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	
	@Test( enabled =true)
	public void data() throws Exception {
		 jb2.verifyBasicBtn();
		 jb2.verifyestimatedRadioBtn();
		 jb2.verifySelectDrop();
		 jb2.verifyServiceDrop();
		 Thread.sleep(1500);
		 jb2.verifyDocType();
		 jb2.verifyDate();
		 jb2.verifyDeliveryAgent();
		 jb2.verifyMasterJob();
		 jb2.verifyMasterOrCarrierDoc();
		 jb2.verifyCarrierDocDate();
		 jb2.verifyBookingSource();
	

//Additional Details		 
		 jb2.verifyAdditionalDetailsBtn();
	/*	 jb2.verifyMarksAndNumber();
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
		 jb2.verifyAttributes();*/
		
		 jb2.verifyCntrNo();
		 jb2.verifyCntrType();
		 jb2.verifyCustomsSeal();
		 jb2.verifyAgentSeal();
	//	 jb2.verifyTareWt();
		 jb2.verifyCargoWt();
	//	 jb2.verifyVGMWt();     
		 jb2.verifyNetWt();
		 jb2.verifyConVolume();
		 jb2.verifyPkgType();
		 jb2.verifyNoOfUnits();
		 jb2.verifyRemarks();
		 jb2.verifyaddBtn();
	//	 jb2.verifyAddBtn1();
		// jb2.verifyVehiclePackingList();
		// jb2.verifyFinalRemarks(); 
		 
//COST AND REVENUE DETAILS	
		 jb2.verifyRevAdCostBtn();
		 jb2.verifyQuotationNoText();
	/*	 jb2.verifyJobIteam();
		 jb2.verifyIteamDesc();
		 jb2.verifyUOMType();
		 jb2.verifyUOM();
	//	 jb2.verifyQuentity();
	//	 jb2.verifyQty(); //// 
		 jb2.verifyTariffTerm();
//Revenue		
		 jb2.verifyrevCheckBoxDataEntry();
		 jb2.verifyPartyTypeR();
		 jb2.verifyPartyTextR();
		 jb2.verifyRevenuerate();
	//	 jb2.verifyGrossFCAmt();
		 jb2.verifyDiscFCAmt();
	//	 jb2.verifyNetFCAmt();
		 jb2.verifyCurrencyR();
	//	 jb2.verifyExRateR();
	//	 jb2.verifyLCAmtR();
		 jb2.verifyRemarksR();
//Cost		 
		 jb2.verifyCostCheckBox();
		 jb2.verifyBuyingRate();
		 jb2.verifyPartyTypeC();
		 jb2.verifyPartyTextC();
		 jb2.verifyCostrate();
	//	 jb2.verifyNetFCAmtC();
		 jb2.verifyCurrencyC();
	//	 jb2.verifyExRateC();
	//	 jb2.verifyLCAmtC();
		 jb2.verifyRemarksC();
		 jb2.verifySubmitBtn();///*/
		rv.verifyCostRevenue();
		 
	//	 jb2.verifySaveBtn();
	//	 jb2.verifyReports();
	}
	

	@AfterMethod
	
	public void exit()
	{
	//	driver.quit();
	}
	}
	


