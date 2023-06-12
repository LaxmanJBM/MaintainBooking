package MaintainBooking;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;                //Notpad Copy
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.Browser;

public class _3_BookingFinal extends Browser {                         //Notpad Copy
	
	
	
		
		@FindBy(xpath = "//img[@id='ctl00_btnNew']")
		private WebElement newBtn;
		@FindBy(xpath = "//td[text()='Maintain Booking']")
		private WebElement title;
		@FindBy(xpath = "//td[text()='NEW WIND LOGISTICS INDIA PVT LTD (NWL)']")
		private WebElement companyName;
		@FindBy(xpath = "//td[text()='FY - 2022-23 ']")
		private WebElement FY;
		@FindBy(xpath = "//img[@id='imgJupLogo']")
		private WebElement logo;

	//************************ Basic Details*****************************//

		@FindBy(xpath = "//a[text()='Basic']")
		private WebElement basicBtn;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_rdbestimate']")
		private WebElement estimatedRadioBtn;
		@FindBy(xpath = "(//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Check'])[2]")
		private WebElement confirmedRadioBtn;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlBook_Pre_Request']")
		private WebElement selectDrop;
//		@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlsvc']//option")private WebElement serviceDrop;
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookBasic_ddlsvc\"]")
		private WebElement serviceDrop;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddldoctype']")
		private WebElement docType;

	//Calendar	
		@FindBy(xpath = "//img[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_imgFrmDt']")
		private WebElement calendarBtn;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtdate']")
		private WebElement calendarText;
		@FindBy(xpath = "//select[@id='scwMonths']")
		private WebElement monthBtn;
		@FindBy(xpath = "//select[@id='scwYears']")
		private WebElement yearBtn;
		@FindBy(xpath = "//input[@id='scwHeadLeft']")
		private WebElement backBtn;
		@FindBy(xpath = "//table[@class='scwCells']")
		private WebElement allDate;

		@FindBy(xpath = "//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddlDeliveryAgainst']")
		private WebElement deliveryAgent;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtmastjob']")         
		private WebElement masterJob;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgMastjob']")private WebElement mastJob;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement bookRefName;
		
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcarrierdoc']")
		private WebElement masterOrCarrierDoc; // Also this is for Carrier Doc
		@FindBy(xpath = "//img[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imgcdocdt']")
		private WebElement carrierDocDate; // This Calendar for both Master doc and Carrier doc
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcarrdocdt']")
		private WebElement dateText1;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$chkCarrDocDate']")
		private WebElement checkBox;
		@FindBy(xpath = "//select[@id='scwYears']")
		private WebElement yearBtn2;
		@FindBy(xpath = "//select[@id='scwMonths']")
		private WebElement monthBtn2;
		@FindBy(xpath = "//input[@id='scwHeadLeft']")
		private WebElement backBtn2;
		@FindBy(xpath = "//input[@id='scwHeadRight']")
		private WebElement nextBtn2;

		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$dllbooksrc']")
		private WebElement bookingSource;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_nominagent']")
		private WebElement nominationAgent;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txt_NominOU']")
		private WebElement nominationOU;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtnombkng']")
		private WebElement nominiBooking;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Imgnbkng']")private WebElement nomBook;       
		@FindBy(xpath="//input[@placeholder='Book Ref']")private WebElement bookRef;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txthousedoc']")
		private WebElement houseDoc;
		@FindBy(xpath = "//img[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imghdate']")
		private WebElement houseDocDate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txthdocdate']")
		private WebElement dateText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$chkHDDate']")
		private WebElement checkBox2;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcustomsdoc']")
		private WebElement customsDoc;

	//Customer	
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgCust']")
		private WebElement customer;// 3 Dots checkbox(...)
		@FindBy(xpath = "//input[@placeholder='Customer']")
		private WebElement customerName;// After clicking on 3 dots.
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcustomer']")
		private WebElement customerText;
		@FindBy(xpath="//a[text()='Next']")private WebElement nextBtnCust;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txt_cust_email']")
		private WebElement customerEmail;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_CustomerOU']")
		private WebElement customerOU;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcacno']")
		private WebElement acNumber;

	//Sales Person	
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookBasic_txt_SalesPerson\"]")
		private WebElement salesPerson;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlOffice']")
		private WebElement office;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_SalesTeam']")
		private WebElement salesTeam;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img_carrier']")
		private WebElement carrierD;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_carrier']")          
		private WebElement carrierText;
		@FindBy(xpath="//input[@placeholder='Name']")private WebElement carrierName;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtCarr_book_ref']")
		private WebElement carrierBookRef;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcommodity']")
		private WebElement commodity;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlcustSerPer']")
		private WebElement custServicePerson;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcustref']")
		private WebElement custRef;

	//	
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgOrigin']")
		private WebElement origin;// 3 dots checkbox
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement originName;
		@FindBy(xpath = "//input[@placeholder='Name']")
		private WebElement name1;// After clicking 3 dots.
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtorigin']")
		private WebElement originText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgDest']")         
		private WebElement destination;// 3 dots checkbox
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement destiName;
		@FindBy(xpath = "//input[@placeholder='Name']")
		private WebElement name2;// After clicking 3 dots.
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtdestination']")
		private WebElement destText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_Route']")
		private WebElement route;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgLoad']")
		private WebElement loadPort;// 3 dots checkbox
		@FindBy(xpath = "//input[@placeholder='Name']")
		private WebElement name3;// After clicking 3 dots.
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtloadport']")
		private WebElement loarPortText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgDisch']")
		private WebElement dischPort;// 3 dots checkbox
		@FindBy(xpath = "//input[@id='amp_common_search_lookup_textbox_control__0']")
		private WebElement name4;// After clicking 3 dots.
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtdischport']")
		private WebElement dischPortText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtvslveh']")
		private WebElement flightText;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img_vessel']")private WebElement vessel;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement vesselName;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtvoy']")
		private WebElement voyage;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlFRTTerms']")
		private WebElement freightTerms;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_orginAgnt']")
		private WebElement originAgent;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_orginAgnt']")private WebElement originAgentD; 
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement originAgentName;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_delvagent']")
		private WebElement deliveryAgent2;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_delvagent']")private WebElement deliveryAgentD;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement deliAgentName;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlshpmnt_type']")
		private WebElement shipmentType;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlCoload']")
		private WebElement coload;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_brokParty']")
		private WebElement brokeParty;// 3 dots  
		@FindBy(xpath = "//input[@placeholder='Party']")
		private WebElement party;// After 3 dots
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_brokParty']")
		private WebElement brokeText;

		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlPickUPTerm']")
		private WebElement pickupTerm;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlDeliveryTerm']")
		private WebElement deliveryTerm;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlloadtype']")
		private WebElement loadType; // This element not found in screen
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgLoad']")private WebElement loadPortD;       
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement loadPName;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgDisch']")private WebElement dishPortD;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement dishPName;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$btnimpbook']")
		private WebElement importBooking; // This element not found in screen
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlTSLocDelv']")
		private WebElement TSLocalDelivery;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtTSDelvRmks']")
		private WebElement TSLocalDeliveryRemark;

	//********************************Freight Details*************************************//

		@FindBy(xpath = "//span[text()='Freight Details']")
		private WebElement frightsDetailsText;
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookBasic_txtwt\"]")
		private WebElement weight;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtvol']")
		private WebElement volume;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtfrtone']")
		private WebElement chargWtOrFrtTone;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txthscd']")
		private WebElement HSCodeText;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img100']")private WebElement hsD;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement hsName;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddldanggud']")
		private WebElement dangGood;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtimgdet']")
		private WebElement IMDGDetails;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt20ftctr']")
		private WebElement ftContaner20;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt40ftctr']")
		private WebElement ftContaner40;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtpkg']")
		private WebElement noPackg;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlpkg']")
		private WebElement itemDetails;

	//*************************Revenue and Cost Details*****************************// 	

		@FindBy(xpath = "//span[text()='Revenue/Cost Details']")
		private WebElement poptitle;
		@FindBy(xpath = "//input[@value='Add Revenue And Cost Details']")
		private WebElement revAdCostBtn;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_quotref']")
		private WebElement quotationNoText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_rev_jobitem']")
		private WebElement jobIteam;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_rev_desc']")
		private WebElement iteamDesc;
		@FindBy(xpath = "//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_uom_type_rev']")
		private WebElement UOMType;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_uom']")
		private WebElement UOM;
		
//		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_qty\"]")
//		private WebElement qty;
		@FindBy(xpath = "//input[@tabindex='206']")
		private WebElement quentity;
		
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddl_Rev_stat']")
		private WebElement tariffTerm;

		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ChkRevenue']")
		private WebElement revCheckBox;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ChkRevenue']")
		private WebElement revCheckBoxDataEntry;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_Acc_Type']")
		private WebElement partyTypeR;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Imgcst_accname']")private WebElement partyBtn;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_accname']")
		private WebElement partyTextR;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement party2;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_rate']")
		private WebElement revenuerate;
		@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Label18']")private WebElement revText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_Grossfcamt']")
		private WebElement grossFCAmt;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_Discfcamt']")
		private WebElement discFCAmt;
		@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Label20']")private WebElement disamt;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_fcamt']")
		private WebElement netFCAmt;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_cur']")
		private WebElement currencyR;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_exchrt']")
		private WebElement exRateR;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_lcamt']")
		private WebElement LCAmtR;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_rem']")
		private WebElement remarksR;

		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ChkCost']")
		private WebElement costCheckBox;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcost_quotref']")
		private WebElement buyingRate;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlCost_Acc_Type']")
		private WebElement partyTypeC;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcst_accname']")
		private WebElement partyTextC;
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookBasic_txtcst_rate\"]")
		private WebElement costrate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcst_fcamt']")
		private WebElement netFCAmtC;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlcst_cur']")
		private WebElement currencyC;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcst_exchrt']")
		private WebElement exRateC;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcst_lcamt']")
		private WebElement LCAmtC;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtcst_rem']")
		private WebElement remarksC;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$btnSubmit']")
		private WebElement submitBtn;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$btnCancel']")
		private WebElement cancelBtn;
		@FindBy(xpath = "//span[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txt_netlc']")
		private WebElement FinalNetLCAmt;

		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txttotrev']")
		private WebElement totalRevenue;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txttotcost']")
		private WebElement totalCost;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtnettot']")
		private WebElement netAmount;

	////********************************Service/Ops Details***************************************////	

		@FindBy(xpath = "//a[text()='Service/Ops Details']")
		private WebElement serviceDetailsBtn;
		@FindBy(xpath = "//span[text()='Party Details']")
		private WebElement partyDetailsText;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_chknewshipper']")               
		private WebElement shipperCheckBox;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtshipname']")
		private WebElement shipperNameText;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtshipadd']")
		private WebElement shipperAddress;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_chknewcons']")
		private WebElement consigneeCheckBox;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtconsname']")
		private WebElement consigneeNameText;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtconsadd']")
		private WebElement consigneeAddress;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_chknewnotify']")
		private WebElement notifyCheckBox;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtnotify']")
		private WebElement notifyNameText;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtnotifyadd']")
		private WebElement notifyAddress;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_chkcha_name']")
		private WebElement CHACheckBox;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtcha_name']")
		private WebElement CHAName;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtcha_address']")
		private WebElement CHAAddress;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtcha_no']")
		private WebElement CHANumber;
		@FindBy(xpath="//div[@id='closeBtn']")private WebElement closeB;

		@FindBy(xpath = "//span[text()='Origin Operation Details']")
		private WebElement opTitle;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtetd']")
		private WebElement ETDDate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtcutdt']")
		private WebElement cutOffDate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$imgCut_time']")
		private WebElement time1;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtsaildt']")
		private WebElement sailingDate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtVGM_date']")
		private WebElement VGMCutOffDate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$imgVGM_time']")
		private WebElement time2;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtDoc_date']")
		private WebElement docCutOff;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$imgDoc_time']")
		private WebElement time3;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlorgpick']")
		private WebElement originPickUp;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlorgcust']")
		private WebElement originCustoms;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddldelvto']")
		private WebElement deliveryBy;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtSI_date']")
		private WebElement SICutOffDate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$imgSI_time']")
		private WebElement SITime4;

		@FindBy(xpath = "//span[text()='Destination Operation Details']")
		private WebElement destinationOperTitle;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txteta']")
		private WebElement ETADate;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtarrdt']")
		private WebElement arrivalTest;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtdelvdt']")
		private WebElement deliveryDate;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddldestdelv']")
		private WebElement destinationDelivery;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddldestcust']")
		private WebElement destinationCoustoms;

		@FindBy(xpath = "//span[text()='Other Details']")
		private WebElement otherDetailsTitle;
		@FindBy(xpath = "//label[text()='Create New Shipper']")
		private WebElement scrollText;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddltos']")
		private WebElement TOS;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtsvcdet']")
		private WebElement serviceDetails;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtoprinstr']")
		private WebElement operInstruction;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txt_transport']")
		private WebElement transporter;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$img_transport']")private WebElement transportBtn;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement transName;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$txtvehdet']")
		private WebElement vehicalDetails;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlCFS']")                 
		private WebElement CFSDropdown;

	////*************************************Additional Details****************************************//////	

		@FindBy(xpath = "//a[text()='Additional Details']")
		private WebElement additionalDetailsBtn;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtmarkno']")
		private WebElement marksAndNumber;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtcargodesc']")
		private WebElement cargoDesc;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtIgmNo']")
		private WebElement IMGNo;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtigmdt']")
		private WebElement IMGDateText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtitemno']")
		private WebElement itemNo;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtitem_type']")
		private WebElement itemType;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtstuffing']")
		private WebElement stuffingText;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtciRef']")
		private WebElement CIRef;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtciDate']")
		private WebElement CIDate;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ddlCiCurr']")
		private WebElement CICurrency;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtciValue']")
		private WebElement CIValue;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookAddDet_txtAttribute1']")
		private WebElement attribute1;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookAddDet_txtAttribute2']")
		private WebElement attribute2;
		@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookAddDet_txtAttribute3']")
		private WebElement attribute3;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$uploadXL$FileUpload1']")
		private WebElement browse;

	//Container List	
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtcontno']")
		private WebElement cntrNo;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$lbltype']")
		private WebElement cntrType;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtsealno']")
		private WebElement customsSeal;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtagentsealno']")
		private WebElement agentSeal;
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookAddDet_txttareWt\"]")
		private WebElement tareWt;
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookAddDet_txtcargoWt\"]")
		private WebElement cargoWt;
		@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookAddDet_txtVGMWt\"]")
		private WebElement VGMWt;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtnetWt']")
		private WebElement netWt;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvolume']")
		private WebElement conVolume;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ddlPkgtype']")
		private WebElement pkgType;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtnounits']")
		private WebElement noOfUnits;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtcntr_remarks']")
		private WebElement remarks;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ImgAdd']")
		private WebElement addBtn1;

	//Vehicle Packing List	
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ddlvehindicator']")
		private WebElement vehicleEquipInd;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ddlvehused']")
		private WebElement usedOrNew;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehChasis']")
		private WebElement chassiNo;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehCase']")
		private WebElement caseNo;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehMake']")
		private WebElement make;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehmod']")
		private WebElement model;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehEngine']")
		private WebElement engineNo;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehyr']")
		private WebElement yearBuilt;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehColor']")
		private WebElement colour;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ddlvehroll']")
		private WebElement rollingOrStatic;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehdescgd']")
		private WebElement descOfGood;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehAccess']")
		private WebElement addAccessories;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehWT']")
		private WebElement weight1;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehvolum']")
		private WebElement volume1;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtvehRem']")
		private WebElement remarks1;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$btnvehAdd']")
		private WebElement addBtn2;
		@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtremark']")
		private WebElement finalRemarks;
		
		@FindBy(xpath="//img[@title='Save (Alt + Ctrl + S)']")private WebElement saveBtn;
		
		@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rdbSummary']")private WebElement summeryReport;
		@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rdbFinIndvdl']")private WebElement financeReport;
		@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rdbSaleIndvdl']")private WebElement salesReport;
		@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rdbOprIndvdl']")private WebElement operationReport;
		@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_rdbCust']")private WebElement customerReport;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnRepOK']")private WebElement okBtn;
		
		@FindBy(xpath="(//a[text()='Close'])[2])")private WebElement closeBtn;
		
	//REVENUE AND COST DETAILS
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_rev_jobitem']")private WebElement jobitembox;
		@FindBy(xpath="//input[@placeholder='Name']")private WebElement job;
		@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_uom_type_rev']")private WebElement uomT;
		@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imgrev_AccName']")private WebElement partyBtnR;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement party1;
		@FindBy(xpath="(//span[text()='Net FC Amount'])[2]")private WebElement netFcamtlabel;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$imgRCclosediv']")private WebElement closeBtnRC;
		@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img_nominagnt']")private WebElement nomPartyType;
		@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement nomName;
		
		public _3_BookingFinal() {
			PageFactory.initElements(driver, this);
		}
		

		public void verifyNewBtn() throws Exception {
			Set<String> window = driver.getWindowHandles();

			Iterator<String> it = window.iterator();

			String mainpage = driver.getWindowHandle();
			while (it.hasNext()) {
				String str = it.next();
				if (!mainpage.equals(str)) {
					driver.switchTo().window(str);
				}
			}

			newBtn.click();
		}

		
		public void verifyBasicDetails() throws Exception {
		
		  FileInputStream file5=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
			
			
				XSSFWorkbook workbook=new XSSFWorkbook(file5);
				XSSFSheet sheet = workbook.getSheet("basicDetail");
				int rowcount = sheet.getLastRowNum();
				int colcount = sheet.getRow(7).getLastCellNum();
				System.out.println("BasicDet rowcount:"+rowcount+"BasicDe colcount"+colcount);

				for(int i=7;i<=rowcount;i++)
				{
					XSSFRow celldata = sheet.getRow(i);	
					try {
					double idNo = celldata.getCell(1).getNumericCellValue();
					if(idNo == 1) {

	//CLICK ON BASIC TEXT	
					try {
			 basicBtn.click();}
					catch(ElementClickInterceptedException p) {
						System.out.println("Exception of Basic Button ="+p);
					}

	//RADIO BUTTON	
			 Thread.sleep(1000);
			 try {
			if (basicBtn.isEnabled() == true) {
				confirmedRadioBtn.click();}}
			 catch(Exception b) {
				 System.out.println("Exception of Confirmed Radio Button ="+b);
			 }
			
	//SELECT DROPDOWN
			Thread.sleep(800);
			FileInputStream file6=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");
			Sheet excelSheet = WorkbookFactory.create(file6).getSheet("basicDetail");
			String drop = excelSheet.getRow(4).getCell(5).getStringCellValue();
			Select se = new Select(selectDrop);
			se.selectByVisibleText(drop);


	//SELECT SERVICE NAME
			Thread.sleep(1000);
		/*	                                     
			try {
				String serviceDropdown =celldata.getCell(2).getStringCellValue();    
			Select se1 = new Select(serviceDrop);
			Thread.sleep(800);
			se1.selectByVisibleText(serviceDropdown);}
			catch(NoSuchElementException e) {
				System.out.println("EXCEPTION OF SERVICE NAME ="+e);
				e.printStackTrace();
			}
			
			*/
			
			
				
				Actions as=new Actions(driver);
				as.moveToElement(serviceDrop).click().build().perform();
				try {
					String serviceDropdown1 =celldata.getCell(2).getStringCellValue();    
				Select se1 = new Select(serviceDrop);
				Thread.sleep(800);
				se1.selectByVisibleText(serviceDropdown1);}
				catch(NoSuchElementException e) {
					System.out.println("EXCEPTION OF SERVICE NAME ="+e);
					e.printStackTrace();
				}
				
			

			
	//DOC TYPE
		//    Thread.sleep(1000);
		    try {
			String docTy = celldata.getCell(4).getStringCellValue();
			Select s1 = new Select(docType);
			s1.selectByVisibleText(docTy);}
		    catch(Exception a) {
		    	System.out.println("EXCEPTION OF DOC TYPE"+a);
		    }
			
			
	//BOOKING DATE
		//	Thread.sleep(800);
			try {
			calendarText.clear();
			String bookDate=celldata.getCell(5).getStringCellValue();
			calendarText.sendKeys(bookDate);}
			catch(Exception b) {
				System.out.println("EXCEPTION OF BOOKING DATE ="+b);
			}
				
	//DELIVERY AGENT

		//	Thread.sleep(1000);
		//	deliveryAgent.click();
			try {
			if (deliveryAgent.isEnabled()){
				for (int i1 = 0; i1 < 2; i1++) {
					Thread.sleep(1000);
					deliveryAgent.sendKeys(Keys.DOWN);}
				deliveryAgent.sendKeys(Keys.ENTER);}
			 else {
				System.out.println("Plase click on Delieviry Agent Button");
			}}
			catch(Exception w) {
				
				System.out.println("EXCEPTION OF DELIVERY AGENT ="+w);
			}
			
		
	//MASTER JOB
		//	Thread.sleep(1000);
			
			
			if (mastJob.isEnabled()) {
			try {
				String msJob =celldata.getCell(7).getStringCellValue();
				mastJob.click();
				bookRefName.sendKeys(msJob);
				bookRefName.sendKeys(Keys.ENTER);	
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				for(int i1=0;i1<col.size();i1++)
				{		
					if(col.get(i1).getText().contains(msJob))
					{
	     				col.get(i1).click();
	     				break;}}
			}
			catch(ElementClickInterceptedException e) {
				System.out.println("destination exception= "+e);}
			       

			}
			
	//MASTER/CARRIER DOC	
		//	Thread.sleep(1000);
			try {
			if (masterOrCarrierDoc.isEnabled()) {
				masterOrCarrierDoc.clear();
				String mastAndcarr=celldata.getCell(8).getStringCellValue();
				masterOrCarrierDoc.sendKeys(mastAndcarr);
			}}
			catch(Exception q) {
				System.out.println("EXCEPTION OF MASTER/CARRIER DOC ="+q);
			}
			
	//CARRIER DOC DATE
		//	Thread.sleep(1000);
			try {
			if (checkBox.isEnabled()) {
				checkBox.click();
				Thread.sleep(800);
				dateText1.clear();
				dateText1.sendKeys(celldata.getCell(10).getStringCellValue());}
			}
			catch(InvalidElementStateException e) {
				Thread.sleep(1000);
			}


	//BOOKING SOURCE
		//	Thread.sleep(1000);
			String sourceBtn =celldata.getCell(9).getStringCellValue();
			try {
			Select source = new Select(bookingSource);
			source.selectByVisibleText(sourceBtn);}
			catch(NoSuchElementException e) {
				System.out.println("EXCEPTION OF BOOKING SOURCE ="+e);
			}
				
		

	//NOMINATION AGENT	
		//	Thread.sleep(1000);
			if (nominationAgent.isEnabled()) {
				
				try {
					
					nomPartyType.click();
					nomName.sendKeys(Keys.ENTER);
						
					String val = celldata.getCell(11).getStringCellValue();
					List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
					List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
					System.out.println("Total size of row  in Nomination Agent table= "+row.size());
					System.out.println("Total col size in Nomination Agent table= "+col.size());
						
					
					for(int i1=0;i1<col.size();i1++)
					{
						String value = col.get(i1).getText();
						if(value.equalsIgnoreCase(val))
						{
							Thread.sleep(1500);
		     				col.get(i1).click();
		     				break;}	
					}
				}
				catch(Exception e) {
					System.out.println("Nomination Agent Exception ="+e);}
			}
			
	//HOUS DOC
				//	Thread.sleep(800);
		            	houseDoc.clear();
						houseDoc.sendKeys(celldata.getCell(12).getStringCellValue());
						

	//NOMINATION OU
		//	Thread.sleep(800);
			if (nominationOU.isEnabled()) {
				nominationOU.sendKeys(celldata.getCell(13).getStringCellValue());}
			
	//HOUS DOC DATE
				//	Thread.sleep(800);
					try {
					if(checkBox2.isEnabled()) {
					checkBox2.click();
					dateText.clear();
					dateText.sendKeys(celldata.getCell(14).getStringCellValue());}}
					catch(Exception e) {
						System.out.println("EXCEPTION OF HOUS DOC DATE");
					}
			
	//NOMINATION BOOKING
		//	Thread.sleep(800);
			try {
			if(nominiBooking.isEnabled()==true) {
				String nombook = celldata.getCell(15).getStringCellValue();
				nomBook.click();
				bookRef.sendKeys(nombook);
				Thread.sleep(800);
				bookRef.sendKeys(Keys.ENTER);       //proper code is pending
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
			for(int i1=0;i1<col.size();i1++)
			{
				if(col.get(i).getText().contains(nombook)) {
					col.get(i).click();
				}}
			}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("EXCEPTION OF NOMINATION BOOKING ="+e);
			}	

	//CUSTOM DOC
		//	Thread.sleep(1000);
			customsDoc.clear();
			customsDoc.sendKeys(celldata.getCell(16).getStringCellValue());
		

	//CUSTOMER	
		//	Thread.sleep(1000);
		try {
			    String val = celldata.getCell(17).getStringCellValue();
				customer.click();
				customerName.sendKeys(val);
				customerName.sendKeys(Keys.ENTER);
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//td"));	
				
				for(int i1=0;i1<col.size();i1++)
				{
					String value = col.get(i1).getText();
					if(value.equalsIgnoreCase(val))
					{
	     				col.get(i1).click();
	     				break;}	}
			}
			catch(Exception e) {
				System.out.println("Customer Exception ="+e);}
		
		
	//CUSTOMER MAIL	
			
		//	customerEmail.sendKeys(celldata.getCell(18).getStringCellValue());                  Auto Filled
		
	//CUSTOMER OU
		
		//customerOU.sendKeys(celldata.getCell(19).getStringCellValue());                        Auto Filled      
			
	//CUSTOMER A/C NO
//		Thread.sleep(1000);
			acNumber.sendKeys(celldata.getCell(20).getStringCellValue());
		

	//SALSE PERSON
//		Thread.sleep(1000);
			String selsePer =celldata.getCell(20).getStringCellValue();       
		try {
			if(bookingSource.getText().equals("Svc Partner"))
			{
				salesPerson.sendKeys(selsePer);}}
			catch(Exception s) {
				System.out.println("EXCEPTION OF SALSE PERSON ="+s);
			}
			
			
	//OFFICE
	/*	Thread.sleep(1000);
			office.click();
			try {
			Select select = new Select(office);                                      Auto Filled
			select.selectByIndex(1);}
			catch(Exception e) {
				System.out.println("EXCEPTION OF OFFICE ="+e);}*/
		

	//SALSE TEAM
			Thread.sleep(1000);
		//	salesTeam.sendKeys(celldata.getCell(25).getStringCellValue());           Auto Filled


	//CARRIER
		//	Thread.sleep(1000);           * Booking updation failed. Please refer the error details.       /html/body/div[2]/a       ////////////////////
			
			try {
				String val =celldata.getCell(22).getStringCellValue();                
				if(carrierD.isEnabled()) {
				carrierD.click();
				carrierName.sendKeys(val);
				carrierName.sendKeys(Keys.ENTER);	
				List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr//td"));
				for(int i1=0;i1<col.size();i1++)
				{
					if(col.get(i1).getText().contains(val))
					{
						Thread.sleep(2000);
	     				col.get(i1).click();
	     				break;}
				}}}
			catch(NoSuchElementException e) {
				System.out.println("carrier exception= "+e);}
			

	//CARRIER BOOK REF
		//	Thread.sleep(1000);
			carrierBookRef.sendKeys(celldata.getCell(24).getStringCellValue());
		

	//COMMODITY
		//	Thread.sleep(1000);
			commodity.sendKeys(celldata.getCell(26).getStringCellValue());
		

	//CUSTOMER SERVICE PERSON
		//	Thread.sleep(800);
	    	String sp =celldata.getCell(27).getStringCellValue();
			Select s=new Select(custServicePerson);
			s.selectByVisibleText(sp);
			
	//CUSTOMER REF
		//    Thread.sleep(800);
			String custReferance =celldata.getCell(29).getStringCellValue();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='"+ custReferance +"'" , custRef);
			
		
	//Origin
		//      Thread.sleep(1000);	
			try {
				String val =celldata.getCell(31).getStringCellValue();                    
				origin.click();
				originName.sendKeys(val);
				originName.sendKeys(Keys.ENTER);	
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));	
				for(int i1=0;i1<col.size();i1++)
				{
					if(col.get(i1).getText().contains(val))
					{
						Thread.sleep(2000);
	     				col.get(i1).click();
	     				break;}}
			}
			catch(Exception e) {
				System.out.println("Origin exception= "+e);}
		

	//DESTINATION
//		Thread.sleep(1000);
			try {
				String val =celldata.getCell(32).getStringCellValue();
				destination.click();
				destiName.sendKeys(val);
				destiName.sendKeys(Keys.ENTER);		
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				for(int i1=0;i1<col.size();i1++)
				{		
					if(col.get(i1).getText().contains(val))
					{
	     				col.get(i1).click();
	     				break;}}
			}
			catch(ElementClickInterceptedException e) {
				System.out.println("destination exception= "+e);}
		

	//ROUTE
			try {
			route.sendKeys(celldata.getCell(36).getStringCellValue());}
			catch(Exception a) {
				Thread.sleep(1000);
			}
		
	//LOAD PORT
			try {
			String loadP = celldata.getCell(37).getStringCellValue();       
			if(loadPortD.isEnabled()) {
			loadPortD.click();
			loadPName.sendKeys(loadP);
			loadPName.sendKeys(Keys.ENTER);		
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
			for(int i1=0;i1<col.size();i1++)
			{		
				if(col.get(i1).getText().contains(loadP))
				{
	 				col.get(i1).click();
	 				break;}}
			}}
			catch(ElementNotInteractableException e) {
				System.out.println("EXCEPTION OF LOAD PORT ="+e);
			}
		

	//DISCHARGE PORT
			try {
			String dischP = celldata.getCell(40).getStringCellValue();
			if(dishPortD.isEnabled()) {
			dishPortD.click();
			dishPName.sendKeys(dischP);
			dishPName.sendKeys(Keys.ENTER);		
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
			for(int i1=0;i1<col.size();i1++)
			{		
				if(col.get(i1).getText().contains(dischP))
				{
	 				col.get(i1).click();
	 				break;}}
			}}
			catch(ElementNotInteractableException e) {
				System.out.println("EXCEPTION OF DISCHARGE PORT ="+e);
			}
			
	//TENTATIVE VEHICLE/FLIGHT NO/VESSEL/TRUCK NO                     
			
			String flightno = celldata.getCell(28).getStringCellValue();
			WebElement text = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_lblvehvsl']"));
			String flight ="Flight / No";
			String truck="Truck / No";
			String tentative="Tentative Vehicle";
			String vesselText="Vessel";
			Thread.sleep(1000);
		try {	
			if(text.getText().contains(flight)){
				Thread.sleep(800);
				JavascriptExecutor js2=(JavascriptExecutor)driver;
				js2.executeScript("arguments[0].value='"+ flightno +"'" , flightText);}       
				//flightText.sendKeys(flightno);}
			
			else if(text.getText().equals(truck)) {
			    flightText.sendKeys(flightno);}
			
			else if(text.getText().equals(tentative)) {
				flightText.sendKeys(flightno);}
			
			else if(text.getText().equals(vesselText))
				 {
					vessel.click();
					vesselName.sendKeys(flightno);
					vesselName.sendKeys(Keys.ENTER);
					List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
					for(int i1=0;i1<col.size();i1++) {
						if(col.get(i1).getText().equals(flightno)) {
							col.get(i).click();
							break;}
						}}}
		catch(Exception a) {
			System.out.println("Excption of Flight/Tentative/Vessel ="+a);
		}
			
			
		/*	try {
				
				if(vessel.isEnabled()) {
					vessel.click();
					vesselName.sendKeys(flightno);
					vesselName.sendKeys(Keys.ENTER);
					List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
					for(int i1=0;i1<col.size();i1++) {
						if(col.get(i1).getText().contains(flightno)) {
							col.get(i).click();
							break;
						}}
				}}
				catch(StaleElementReferenceException e) {
					System.out.println("Exception of flight no/vessel ="+e);
				}
	*/
	//VOYAGE
			if(voyage.isEnabled()) {
			voyage.sendKeys(celldata.getCell(30).getStringCellValue());
			}
		

	//FREIGHT TERM
			Thread.sleep(800);
			String freightTer = celldata.getCell(33).getStringCellValue();
			Select se1 = new Select(freightTerms);
			se1.selectByVisibleText(freightTer);
		

	//ORIGIN AGENT
			Thread.sleep(800);
			if(originAgent.isEnabled()) {
				String originAgent1 =celldata.getCell(34).getStringCellValue();
				
				try {
					originAgentD.click();
					originAgentName.sendKeys(originAgent1);
					originAgentName.sendKeys(Keys.ENTER);		
					
					List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
					for(int i1=0;i1<col.size();i1++)
					{	
						if(col.get(i1).getText().contains(originAgent1))
						{
		     				col.get(i1).click();
		     				break;}}
				}
				catch(Exception e) {
					System.out.println("Delivery Agent exception= "+e);}
			}
		
	//DELIVERY AGENT 2
			Thread.sleep(800);
			if(deliveryAgent2.isEnabled()) {
			String deliAgent =celldata.getCell(35).getStringCellValue();
			
			try {
				deliveryAgentD.click();
				deliAgentName.sendKeys(deliAgent);
				deliAgentName.sendKeys(Keys.ENTER);		
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				for(int i1=0;i1<col.size();i1++)
				{	
					if(col.get(i1).getText().contains(deliAgent))
					{
	     				col.get(i1).click();
	     				break;}}
			}
			catch(Exception e) {
				System.out.println("Delivery Agent exception= "+e);}
			}
		

	//SHIPMENT TYPE
			shipmentType.click();
			String shipment =celldata.getCell(38).getStringCellValue();
			try {
			Select ship=new Select(shipmentType);
			ship.selectByVisibleText(shipment);}
			catch(Exception e) {
				System.out.println("Exception of Shipment Type ="+e);}
		

	//COLOAD
			String coload1 =celldata.getCell(39).getStringCellValue();
			if(coload.isEnabled()) {
			Select se3 = new Select(coload);
			se3.selectByVisibleText(coload1);}
		

	//BROKERAGE PARTY
			Thread.sleep(800);
	    	if(brokeText.isEnabled()) {
	    		String broker =celldata.getCell(41).getStringCellValue();
				try {
					brokeParty.click();
					party.sendKeys(Keys.ENTER);		
					party.sendKeys(broker);
					party.sendKeys(Keys.ENTER);		
					List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
					for(int i1=0;i1<col.size();i1++)
					{	
						if(col.get(i1).getText().equalsIgnoreCase(broker))
						{
		     				col.get(i1).click();
		     				break;}}
				}
				catch(StaleElementReferenceException e) {
					System.out.println("Brokarage Party exception= "+e);}
				
	    	}
			

	//PICKUP TERM
	    	Thread.sleep(800);
	    	try {
			pickupTerm.click();
			String pickup =celldata.getCell(42).getStringCellValue();
			Select pickupTer=new Select(pickupTerm);
			pickupTer.selectByVisibleText(pickup);}
			catch(ElementClickInterceptedException w) {
				System.out.println("Exception of PickUp Term ="+w);
			}
		

	//DELEVERY TERM
	    	Thread.sleep(500);
			String delivery =celldata.getCell(43).getStringCellValue();
			try {
			deliveryTerm.click();
			Select deliveryTer=new Select(deliveryTerm);
			deliveryTer.selectByVisibleText(delivery);}
			catch(ElementClickInterceptedException e) {
				System.out.println("Excption of Delevery Term ="+e);
			}
		

	//LOAD TYPE
			Thread.sleep(1000);
			
			//boolean status = loadType.isEnabled();
		try {
			if(loadType.isEnabled()) {
				String loadtp =celldata.getCell(44).getStringCellValue();
			Select loadtype = new Select(loadType);
			Thread.sleep(800);
			loadtype.selectByVisibleText(loadtp);}}
			catch(NoSuchElementException a) {
				System.out.println("Exception of Load Type ="+a);
			}

	//IMPORT BOOKING
		    try {
			if(importBooking.isEnabled()) {
			importBooking.sendKeys(celldata.getCell(47).getStringCellValue());}	}
		    catch(Exception e) {
		    	System.out.println("Exception of IMPORT BOOKING ="+e);
		    }

	//TS LOCALLY DELIVERED
			String localDeli =celldata.getCell(46).getStringCellValue();
			try {
			if(TSLocalDelivery.isEnabled()) {
			Select localdele = new Select(TSLocalDelivery);
			localdele.selectByVisibleText(localDeli);}}
			catch(Exception f) {
				System.out.println("Exception of TS LOCALLY DELIVERY ="+f);
			}

	//TS LOCALLY DELIVERED REMARKS
			try {
			if(TSLocalDeliveryRemark.isEnabled()) {
			TSLocalDeliveryRemark.sendKeys(celldata.getCell(45).getStringCellValue());}}
			catch(Exception t) {
				System.out.println("Exception of TS Remark ="+t);
			}
			
			
	//Scrolling
			Thread.sleep(1000);
			try {
				JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scrolling up to element
				js1.executeScript("arguments[0].scrollIntoView();", frightsDetailsText);
				
				js1.executeScript("window.scrollBy(0,-450)");
			//	OR,
			//	jse.executeScript("scroll(0, -250);");
			}
			catch(Exception e) {
				System.out.println("Exception of Scroll= "+e);
			}

	//WEIGHT
			/*	try {
				
				weight.click();
				double value1 = celldata.getCell(48).getNumericCellValue();
				JavascriptExecutor js2=(JavascriptExecutor)driver;
				js2.executeScript("arguments[0].value='"+ value1 +"'" , weight);                          Auto Filled
				System.out.println("After value of weight= "+value1);
				}
				catch(Exception e) {
					System.out.println("weight value wrong shows= "+e);}
			*/

	//VOLUME
			
			/*	volume.click();
				Thread.sleep(2000);
				double value1 = celldata.getCell(50).getNumericCellValue();                               Auto Filled
				
				JavascriptExecutor js2=(JavascriptExecutor)driver;
				js2.executeScript("arguments[0].value='"+ value1 +"'" , volume);*/

	//CARGO WT/FRT.TONES
				Thread.sleep(800);
				try {
				chargWtOrFrtTone.click();
				double value1 = celldata.getCell(52).getNumericCellValue();
				System.out.println("Before value of weight= "+value1);
				
				JavascriptExecutor js2=(JavascriptExecutor)driver;
				js2.executeScript("arguments[0].value='"+ value1 +"'" , chargWtOrFrtTone);
				System.out.println("After value of weight= "+value1);}
				catch(ElementClickInterceptedException r) {
					System.out.println("Exception of CARGO WT/TONES ="+r);
				}

	//HS CODE
			//   Thread.sleep(1000);
		/*		String code = celldata.getCell(49).getStringCellValue();
				HSCodeText.sendKeys(code);*/
				 try {
						
					    String code = celldata.getCell(49).getStringCellValue();
					    hsD.click();
					    hsName.sendKeys(code);
					    hsName.sendKeys(Keys.ENTER);		
						
						List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr//td"));
						for(int i1=0;i1<col.size();i1++)
						{	
							if(col.get(i1).getText().equalsIgnoreCase(code))
							{
			     				col.get(i1).click();
			     				break;}}
					}
					catch(Exception e) {
						System.out.println("HS Code Exception= "+e);}
					
			

	//DANGEROUS GOODS
			
				String goods =celldata.getCell(51).getStringCellValue();
				Select dgood = new Select(dangGood);
				dgood.selectByVisibleText(goods);
			

	//IMDG DETAILS
				
				IMDGDetails.sendKeys(celldata.getCell(53).getStringCellValue());
			

	//CONTAINER 20
			
		//		ftContaner20.sendKeys(celldata.getCell(54).getStringCellValue());               Auto Filled
			

	//CONTAINER 40
				
		//		ftContaner40.sendKeys(celldata.getCell(57).getStringCellValue());               Auto Filled
			

	//NO PAKG 
				
		//		noPackg.sendKeys(celldata.getCell(55).getStringCellValue());                   Auto Filled

			

	//PKG TYPE
			String pkgtype = celldata.getCell(56).getStringCellValue();
				Select pkg=new Select(itemDetails);
				pkg.selectByVisibleText(pkgtype);
				
				
	//Scroll upto top 
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-450)");
		//		OR,
		//		jse.executeScript("scroll(0, -250);");
				Thread.sleep(1000);
				Actions as1=new Actions(driver);
				as1.moveToElement(serviceDetailsBtn).click().build().perform();
			//	serviceDetailsBtn.click();
				
		
				}
				}
					catch(NullPointerException e) {
						Thread.sleep(500);}
				
				}
		
		}
		

		public void verifyServiceDetails() throws Exception {                 
			
			 FileInputStream file7=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
				
				
				XSSFWorkbook workbook=new XSSFWorkbook(file7);
				XSSFSheet sheet1 = workbook.getSheet("serviceDetails");
				int rowcount = sheet1.getLastRowNum();
				int colcount = sheet1.getRow(6).getLastCellNum();
				System.out.println("serviceDetails rowcount:"+rowcount+"ServiceDetails colcount"+colcount);

				for(int i=6;i<=rowcount;i++)
				{
					XSSFRow celldata = sheet1.getRow(i);
					try {
					double idNo = celldata.getCell(1).getNumericCellValue();
					if(idNo == 1) {
			
	//Service Details Btn
	/*				WebElement servicetitle = driver.findElement(By.xpath("//a[text()='Service/Ops Details']"));
				JavascriptExecutor jse = (JavascriptExecutor)driver;
			//	jse.executeScript("arguments[0].scrollIntoView();", servicetitle);
				jse.executeScript("window.scrollBy(0,-450)");
		//		OR,
		//		jse.executeScript("scroll(0, -250);");
		//		Actions as=new Actions(driver);
		//		as.moveToElement(serviceDetailsBtn).click().build().perform();
				serviceDetailsBtn.click();
			*/	

	//SHIPPER NAME AND ADDRESS
						
						serviceDetailsBtn.click();
				    shipperCheckBox.click();
				    closeB.click();
					shipperNameText.sendKeys(celldata.getCell(2).getStringCellValue());
					shipperAddress.sendKeys(celldata.getCell(3).getStringCellValue());              

	//CONSIGNEE NAME AND ADDRESS
				consigneeCheckBox.click();
				closeB.click();
				consigneeNameText.sendKeys(celldata.getCell(4).getStringCellValue());
				consigneeAddress.sendKeys(celldata.getCell(5).getStringCellValue());
			

	//NOTIFY NAME AND ADDRESS
				notifyCheckBox.click();
				closeB.click();
				notifyNameText.sendKeys(celldata.getCell(6).getStringCellValue());
				notifyAddress.sendKeys(celldata.getCell(7).getStringCellValue());
		

	//CHAN NAME AND ADDRESS
				CHACheckBox.click();
				closeB.click();
				CHAName.sendKeys(celldata.getCell(8).getStringCellValue());
				CHAAddress.sendKeys(celldata.getCell(9).getStringCellValue());
				CHANumber.sendKeys(celldata.getCell(10).getStringCellValue());
				
	//ETD DATE
				ETDDate.clear();
				ETDDate.sendKeys(celldata.getCell(11).getStringCellValue());
			

	//CUT OFF DATE AND TIME
				cutOffDate.clear();
				cutOffDate.sendKeys(celldata.getCell(12).getStringCellValue());
				
				time1.click();
				try {
				String hh =celldata.getCell(13).getStringCellValue();
				WebElement hour = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlHH']"));
				hour.click();
				Select hh1 = new Select(hour);
				hh1.selectByVisibleText(hh);
				
				String mm =celldata.getCell(14).getStringCellValue();
				WebElement min = driver
						.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlMM']"));
				Thread.sleep(800);
				Select mm1 = new Select(min);
				mm1.selectByVisibleText(mm);
				driver.findElement(By.xpath("//a[text()='Apply']")).click();
				}
				catch(Exception e) {
					System.out.println("Exception of cut off date and time ="+e);
				}
			

	//SAILING DATE AND TIME
				sailingDate.clear();
				sailingDate.sendKeys(celldata.getCell(15).getStringCellValue());
			

	//VGM CUT OFF DATE AND TIME
				VGMCutOffDate.clear();
				VGMCutOffDate.sendKeys(celldata.getCell(16).getStringCellValue());
				time2.click();
				try {
				String hh2 =celldata.getCell(17).getStringCellValue();
				WebElement hour1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlHH"));
				Thread.sleep(800);
				Select h = new Select(hour1);
				h.selectByVisibleText(hh2);
				
				String mm2 =celldata.getCell(18).getStringCellValue();
				WebElement min1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlMM"));
				Thread.sleep(800);
				Select m = new Select(min1);
				m.selectByVisibleText(mm2);
				driver.findElement(By.xpath("//a[text()='Apply']")).click();}
				catch(Exception a) {
					System.out.println("Exception of VGM cut off date and time ="+a);
				}
			

	//DOC CUT OFF DATE AND TIME
				docCutOff.clear();
				docCutOff.sendKeys(celldata.getCell(19).getStringCellValue());
				time3.click();
				try {
				String hh3 =celldata.getCell(20).getStringCellValue();
				WebElement hour2 = driver
						.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlHH']"));
				Thread.sleep(1000);
				Select h2 = new Select(hour2);
				h2.selectByVisibleText(hh3);
				String mm3 =celldata.getCell(21).getStringCellValue();
				WebElement min2 = driver
						.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlMM']"));
				Thread.sleep(800);
				Select m2 = new Select(min2);
				m2.selectByVisibleText(mm3);
				driver.findElement(By.xpath("//a[text()='Apply']")).click();}
				catch(Exception a) {
					System.out.println("Exception of Doc cut off date and time ="+a);
				}
		

	//ORIGIN PICKUP BY
				String pickup =celldata.getCell(22).getStringCellValue();
				Select pickUp = new Select(originPickUp);
				pickUp.selectByVisibleText(pickup);

	//ORIGIN CUSTOMS BY			
				String cust =celldata.getCell(23).getStringCellValue();
				Select custom = new Select(originCustoms);
				custom.selectByVisibleText(cust);

	//DELIVERY TO			
				String deli =celldata.getCell(24).getStringCellValue();
				Select delivery = new Select(deliveryBy);
				delivery.selectByVisibleText(deli);

	//SI CUT OFF DATE	
				SICutOffDate.clear();
				SICutOffDate.sendKeys(celldata.getCell(25).getStringCellValue());
				try {
				driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$imgSI_time")).click();
				String hh4 =celldata.getCell(26).getStringCellValue();
				WebElement hour3 = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlHH']"));
				hour3.click();
				Select h3 = new Select(hour3);
				h3.selectByVisibleText(hh4);
				
				String mm4 =celldata.getCell(27).getStringCellValue();
				WebElement min3 = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlMM']"));
				min3.click();
				Select m3 = new Select(min3);
				m3.selectByVisibleText(mm4);
				driver.findElement(By.xpath("//a[text()='Apply']")).click();}
				catch(Exception a) {
					System.out.println("Exception of SI cut off date and time ="+a);
				}
		

		
	//ETA DATE
				ETADate.clear();
				ETADate.sendKeys(celldata.getCell(28).getStringCellValue());
			

	//ARRIVAL DATE
				arrivalTest.clear();
				arrivalTest.sendKeys(celldata.getCell(29).getStringCellValue());
			

	//DELIVERY DATE
				deliveryDate.clear();
				deliveryDate.sendKeys(celldata.getCell(30).getStringCellValue());
			

	//DESTINATION DELIVERY BY
				String destDeli =celldata.getCell(31).getStringCellValue();
				Select destDeliv = new Select(destinationDelivery);
				destDeliv.selectByVisibleText(destDeli);
			

	//DESTINATION CUSTOMS
				String destCust =celldata.getCell(32).getStringCellValue();
				Select custom1 = new Select(destinationCoustoms);
				custom1.selectByVisibleText(destCust);
			

	//SCROLL
				JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling up to element
				js.executeScript("arguments[0].scrollIntoView();", scrollText);
				Thread.sleep(2000);
			

	//TOS
				String tos1 =celldata.getCell(33).getStringCellValue();
				Select tos = new Select(TOS);
				tos.selectByVisibleText(tos1);
			

	//SERVICE DETAILS
				serviceDetails.sendKeys(celldata.getCell(34).getStringCellValue());
			

	//OPERATION INSTRUCTIONS
				operInstruction.sendKeys(celldata.getCell(35).getStringCellValue());
			

	//TRANSPORTER
				if(transporter.isEnabled()) {
					
					
					try {
						
						transportBtn.click();
						transName.sendKeys(Keys.ENTER);
							
						String transpo =celldata.getCell(36).getStringCellValue();
						List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
						for(int i1=0;i1<col.size();i1++)
						{					
							if(col.get(i1).getText().contains(transpo))
							{
			     				col.get(i1).click();
			     				break;}	}
					}
					catch(Exception e) {
						System.out.println("Nomination Agent Exception ="+e);}
				
				}

	//VEHICAL DETAILS
				if(vehicalDetails.isEnabled()) {
				vehicalDetails.sendKeys(celldata.getCell(37).getStringCellValue());}
				
			

	//CFS
				String cfsDrop = celldata.getCell(38).getStringCellValue();
				Select cfs = new Select(CFSDropdown);
				cfs.selectByVisibleText(cfsDrop);
		}	
					}	
					
					catch(NullPointerException e) {
						System.out.println("Exception of loop ="+e);}			
		}
		}
		
		
		
		public void verifyAdditionalDetails() throws Exception {                 
			
			 FileInputStream file8=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
				
				
				XSSFWorkbook workbook=new XSSFWorkbook(file8);
				XSSFSheet sheet2 = workbook.getSheet("additionalDetails");
				int rowcount = sheet2.getLastRowNum();
				int colcount = sheet2.getRow(5).getLastCellNum();
				System.out.println("serviceDetails rowcount:"+rowcount+"ServiceDetails colcount"+colcount);

				for(int i=5;i<=rowcount;i++)
				{
					XSSFRow celldata = sheet2.getRow(i);
					try {
					double idNo = celldata.getCell(1).getNumericCellValue();
					if(idNo == 1) {
						
	//ADDITIONAL BUTTON
							JavascriptExecutor jse = (JavascriptExecutor)driver;
							jse.executeScript("window.scrollBy(0,300)");
							Thread.sleep(1000);
							Actions as=new Actions(driver);
							as.moveToElement(additionalDetailsBtn).click().build().perform();
							

	//MARKS AND NUMBERS
							marksAndNumber.sendKeys(celldata.getCell(2).getStringCellValue());
						

	//CARGO DESCRIPTION
							cargoDesc.sendKeys(celldata.getCell(3).getStringCellValue());
						

	//IMG NO
							IMGNo.sendKeys(celldata.getCell(4).getStringCellValue());
						

	//IMG DATE
							IMGDateText.clear();
							IMGDateText.sendKeys(celldata.getCell(5).getStringCellValue());
						

	//ITEAM NO
							itemNo.sendKeys(celldata.getCell(6).getStringCellValue());
						

	//ITEAM TYPE
							itemType.sendKeys(celldata.getCell(7).getStringCellValue());
						

	//STUFFING/DESTUFFING POINT
							stuffingText.sendKeys(celldata.getCell(8).getStringCellValue());
						

	//CI REF
							CIRef.sendKeys(celldata.getCell(9).getStringCellValue());
						

	//CI DATE
							CIDate.sendKeys(celldata.getCell(10).getStringCellValue());
						

	//CI CURRENCY
							WebElement ciCurrency = driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$ddlCiCurr']"));
							String currency = celldata.getCell(11).getStringCellValue();
							Select curr=new Select(ciCurrency);
							curr.selectByVisibleText(currency);
						

	//CI VALUE
							CIValue.sendKeys(celldata.getCell(12).getStringCellValue());
						

	//ATTRIBUTS 1,2,3
							attribute1.sendKeys(celldata.getCell(13).getStringCellValue());
							attribute2.sendKeys(celldata.getCell(14).getStringCellValue());
							attribute3.sendKeys(celldata.getCell(15).getStringCellValue());
						
	//FILE UPLOAD
						//	driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$uploadXL$txtUcxFileName']")).sendKeys("C:\\Users\\Admin\\Desktop");
							// browse.click();
							
							
	//FINAL REMARK
							
							WebElement remar = driver.findElement(By.xpath("//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtremark']"));
							remar.sendKeys( celldata.getCell(16).getStringCellValue()); 
					}
					
					
					}
					catch(Exception e) {
						System.out.println("Exception of Additional Method ="+e);
					}
					}
		}

		
		public void allContanerDetails() throws Exception {
	//Scrolling		
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-450)");
			Thread.sleep(1000);
			
			FileInputStream file1=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
					
					
					XSSFWorkbook workbook=new XSSFWorkbook(file1);
					XSSFSheet sheet = workbook.getSheet("containerDetails");
					int rowcount = sheet.getLastRowNum();
					int colcount = sheet.getRow(3).getLastCellNum();
					System.out.println("Cntr List rowcount:"+rowcount+"Cntr List colcount"+colcount);
						

					for(int i=3;i<=rowcount;i++)
					{
						XSSFRow celldata = sheet.getRow(i);   
						try {
						double idNo = celldata.getCell(1).getNumericCellValue();
						
						
						if(idNo == 1) {
				
			//CONTAINER NO
						Thread.sleep(800);
						String contNo = celldata.getCell(2).getStringCellValue();
						cntrNo.clear();
						try {
						cntrNo.sendKeys(contNo);}
						catch(java.lang.NullPointerException e) {
							System.out.println("Exception of CONTAINER NO ="+e);
						}
					
					
			//CONTAINER TYPE
						Thread.sleep(800);
						String contTy = celldata.getCell(3).getStringCellValue();
					//	cntrType.click();
						Select cntrType1 = new Select(cntrType);
						cntrType1.selectByVisibleText(contTy);
					
					
			//CUSTOMS SEAL
						Thread.sleep(800);
						String custSeal = celldata.getCell(4).getStringCellValue();
						customsSeal.clear();
						customsSeal.sendKeys(custSeal);
						
			//AGENT SEAL
						Thread.sleep(1000);
						String ageSeal = celldata.getCell(5).getStringCellValue();
						agentSeal.clear();
						agentSeal.sendKeys(ageSeal);
						
					
			//CARGO WT
						Thread.sleep(1000);
						try
						{
						cargoWt.click();
						cargoWt.clear();
						Thread.sleep(800);
						double value = celldata.getCell(7).getNumericCellValue();
						System.out.println("actual value of cargo= "+value);
						JavascriptExecutor js2=(JavascriptExecutor)driver;
						js2.executeScript("arguments[0].value='"+ value +"'" , cargoWt);
						Thread.sleep(1000);
						cargoWt.sendKeys(Keys.ENTER);}
						catch(Exception e) {
							System.out.println("cargo value is wrong="+e);
						}
						
						
			//VGM
						Thread.sleep(800);
						try {
						VGMWt.sendKeys(Keys.ENTER);}
						catch(ElementNotInteractableException e) {
							System.out.println("Exception of VGM text ="+e);
						}
						
			//NET WT
						Thread.sleep(1000);
						try {
						netWt.click();
						netWt.clear();
						double value = celldata.getCell(9).getNumericCellValue();               	
						JavascriptExecutor js2=(JavascriptExecutor)driver;
						js2.executeScript("arguments[0].value='"+ value +"'" , netWt);           
						System.out.println("After passing value of Net Wait= "+value);}
						catch(ElementClickInterceptedException e) {
							System.out.println("Exceptio of Net wt ="+e);
						}
						
					
			//VOLUME
						Thread.sleep(1000);
						try {
						conVolume.click();
						conVolume.clear();
						double value1 = celldata.getCell(10).getNumericCellValue();
						System.out.println("actual value of the cotainer volume= "+value1);
						JavascriptExecutor jb=(JavascriptExecutor)driver;
						jb.executeScript("arguments[0].value='"+ value1 +"'" , conVolume);}
						catch(Exception q) {
							System.out.println("Excepion of volume in CNTR details ="+q);
						}
					
			//PKG TYPE
						Thread.sleep(800);
						String pakgTy = celldata.getCell(11).getStringCellValue();
						try {
						pkgType.click();
						Select pkg = new Select(pkgType);
						pkg.selectByVisibleText(pakgTy);}
						catch(Exception e) {
							System.out.println("Exception of Pkg Type ="+e);
						}
						
			//NO OF UNITS
						Thread.sleep(800);
						try {
						noOfUnits.click();
							noOfUnits.clear();
							double value11 = celldata.getCell(12).getNumericCellValue();
							JavascriptExecutor jc=(JavascriptExecutor)driver;
							jc.executeScript("arguments[0].value='"+ value11 +"'" , noOfUnits);}
						catch(Exception e) {
							System.out.println("Exception of No of Units ="+e);
						}
							
			//CNTR REMARKS
							Thread.sleep(800);
							remarks.sendKeys(celldata.getCell(13).getStringCellValue()); 
							
							
			//ADD BUTTON
							Thread.sleep(800);
							addBtn1.click();
							try {
							driver.switchTo().alert().accept();}
							catch(NoAlertPresentException e) {System.out.println("Exception of add button ="+e);}	
					}
						
				
					}
						catch(NullPointerException e) {
							Thread.sleep(500);
						}
					}
			}

				
				
			//WE CAN ADD MULTIPLE PACKING MATERIAL IN SINGLE BOOKING 	
				
				public void allVehiPackingList() throws Exception         
				{
					
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(300,0)");
					
			        FileInputStream file4=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
					
					
					XSSFWorkbook workbook=new XSSFWorkbook(file4);
					XSSFSheet sheet = workbook.getSheet("vehPackingList");
					int rowcount = sheet.getLastRowNum();
					int colcount = sheet.getRow(4).getLastCellNum();
					System.out.println("Packing rowcount:"+rowcount+"Packing colcount"+colcount);

					for(int i=4;i<=rowcount;i++)
					{
						XSSFRow celldata = sheet.getRow(i);
						try {
						double idNo = celldata.getCell(1).getNumericCellValue();           
					if(idNo == 1) {
					
			//VEHICLE EQUIP
						
						Thread.sleep(800);
						String equipment1 = celldata.getCell(2).getStringCellValue();
						try {
						Select equ = new Select(vehicleEquipInd);
						equ.selectByVisibleText(equipment1);}
						catch(java.lang.NullPointerException a) {
							Thread.sleep(2000);
						}
						
			//USED/NEW
						Thread.sleep(800);
						String newUsed = celldata.getCell(3).getStringCellValue();
						Select used = new Select(usedOrNew);
						used.selectByVisibleText(newUsed);
						
			//CHASSIS NO

						chassiNo.clear();
						Thread.sleep(800);
						String chassNo = celldata.getCell(4).getStringCellValue();
						chassiNo.sendKeys(chassNo);
						
						caseNo.clear();
						Thread.sleep(800);
						String casNo = celldata.getCell(5).getStringCellValue();
						caseNo.sendKeys(casNo);
						
						make.clear();
						Thread.sleep(800);
						String mak = celldata.getCell(6).getStringCellValue();
						make.sendKeys(mak);
						
						model.clear();
						Thread.sleep(800);
						String mod = celldata.getCell(7).getStringCellValue();
						model.sendKeys(mod);
						
						engineNo.clear();
						Thread.sleep(800);
						String engNo = celldata.getCell(8).getStringCellValue();
						engineNo.sendKeys(engNo);
						
						yearBuilt.clear();
						Thread.sleep(800);
						double yearB = celldata.getCell(9).getNumericCellValue();
					//	String nuericString1 = Double.toString(yearB);		
					//	yearBuilt.sendKeys(nuericString1);
						JavascriptExecutor jb=(JavascriptExecutor)driver;
						jb.executeScript("arguments[0].value='"+ yearB +"'" , yearBuilt);
						
						colour.clear();
						Thread.sleep(800);
						String colr = celldata.getCell(10).getStringCellValue();                
						colour.sendKeys(colr);
						
			//ROLLING/STATIC DROPDOWN
						
						Thread.sleep(800);
						String rolling = celldata.getCell(11).getStringCellValue();
						Select roll = new Select(rollingOrStatic);
						roll.selectByVisibleText(rolling);
						
			//GOODS 
						descOfGood.clear();
						Thread.sleep(800);
						String goods = celldata.getCell(12).getStringCellValue();
						descOfGood.sendKeys(goods);
						
			//ACCESSORIES
						Thread.sleep(800);
						addAccessories.clear();
						String accssories = celldata.getCell(13).getStringCellValue();
						addAccessories.sendKeys(accssories);
						
			//WEIGHT
						Thread.sleep(800);
						weight1.clear();
						double wt = celldata.getCell(14).getNumericCellValue();
						JavascriptExecutor jf=(JavascriptExecutor)driver;
						jf.executeScript("arguments[0].value='"+ wt +"'" , weight1);
						
			//VOLUME			
						Thread.sleep(800);
						volume1.clear();
						double vol = celldata.getCell(15).getNumericCellValue();
						JavascriptExecutor javae=(JavascriptExecutor)driver;
						javae.executeScript("arguments[0].value='"+ vol +"'" , volume1);
					
			//REMARKS
						Thread.sleep(800);
						remarks1.clear();
						String remk = celldata.getCell(16).getStringCellValue();
						remarks1.sendKeys(remk);
					
			//ADD BUTTON
						Thread.sleep(800);
						addBtn2.click();	
					}	
						}
						catch(NullPointerException e) {
							Thread.sleep(500);
						}
				}
					
				}
		
				public void verifyCostRevenue() throws Exception {
					
					
					
					//Scrolling						
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,350)");
					Thread.sleep(1000);
					Actions as=new Actions(driver);
					as.moveToElement(basicBtn).click().build().perform();
					Thread.sleep(800);
					jse.executeScript("window.scrollBy(0,300)");
					try {
					revAdCostBtn.click();}
					catch(ElementClickInterceptedException a) {
						Thread.sleep(800);
					}
					
					FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
					
					
					XSSFWorkbook workbook=new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheet("CostRevenue");
					int rowcount = sheet.getLastRowNum();
					int colcount = sheet.getRow(3).getLastCellNum();
					System.out.println("RC rowcount:"+rowcount+"RC colcount"+colcount);

					for(int i=3;i<=rowcount;i++)
					{
						XSSFRow celldata = sheet.getRow(i);
						
					try {	
						String oum = celldata.getCell(5).getStringCellValue();
						String tariff = celldata.getCell(6).getStringCellValue();
						String partyDrop = celldata.getCell(7).getStringCellValue();
						String partyR = celldata.getCell(8).getStringCellValue();
						
						double disfcAmt = celldata.getCell(10).getNumericCellValue();             
						double idNo = celldata.getCell(1).getNumericCellValue();
						if(idNo == 1) {
							

				
			//JOB ITEAM		
						
						Thread.sleep(450);
						try {   
							String jobItm = celldata.getCell(2).getStringCellValue();
						jobitembox.click();
						job.sendKeys(jobItm);
						Thread.sleep(800);
						job.sendKeys(Keys.ENTER);	
						
						List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
						System.out.println("Total size of col in jobiteam table= "+col.size());
						
						for(int i1=0;i1<col.size();i1++)
						{
							if(col.get(i1).getText().contains(jobItm))
							{
								col.get(i1).click();}
						}
						}
						catch(StaleElementReferenceException e) {
							System.out.println(e);}              
						
					
			//ITEAM DESCRIPTION	
						Thread.sleep(450);
							try {
								iteamDesc.clear();	
							iteamDesc.sendKeys(celldata.getCell(3).getStringCellValue());      
							}catch(Exception a){
								System.out.println(a);
							}
					
			//UOM TYPE
					Thread.sleep(450);
					try {
						String oumType = celldata.getCell(4).getStringCellValue();
					Select se4 = new Select(UOMType);
					se4.selectByVisibleText(oumType);}
					catch(Exception r) {
						System.out.println("Exception of UOM Type ="+r);
					}
					
			//UOM
					Thread.sleep(450);
					try {
					Select se=new Select(UOM);
					se.selectByVisibleText(oum);}
					catch(Exception b) {
						System.out.println("Exception of UOM ="+b);
					}
					
			//TARIFF ITEAM
					Thread.sleep(500);
					try {
					Select se5 = new Select(tariffTerm);
					se5.selectByVisibleText(tariff);}
					catch(Exception c) {
						System.out.println("Exception of Tariff Iteam ="+c);
					}
					
			//REVENUE CHECK BOX
					Thread.sleep(500);
					if(revCheckBox.isSelected()) {
						System.out.println("Revenue check box status ="+revCheckBox.isSelected());
					}
					else {
						Actions action=new Actions(driver);
						action.moveToElement(revCheckBox).click().build().perform();
					//	revCheckBox.click();}
					}
				
					
			//REVENUE PARTY TYPE
					Thread.sleep(500);
					try {
					Select se1=new Select(partyTypeR);
					se1.selectByVisibleText(partyDrop);}
					catch(Exception d) {
						System.out.println("Exception of Revenue Prty Type ="+d);            
					}
					
			//REVENUE PARTY
					Thread.sleep(500);
					try {
					
						partyBtnR.click();
						Thread.sleep(800);
						party1.sendKeys(partyR);
						party1.sendKeys(Keys.ENTER);	
						List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
						System.out.println("Np of col in Revenue Party ="+col);
						for(int b=0;b<col.size();b++)
						{
							if(col.get(b).getText().contains(partyR)) {
								col.get(b).click();}}
						}
						catch(StaleElementReferenceException e) {
							System.out.println("EXCEPTION OF REVENUE PARTY ="+e);}

			//REVENUE RATE
					Thread.sleep(500);
					try {
						
						revenuerate.click();
						Thread.sleep(800);
						double rateR = celldata.getCell(9).getNumericCellValue();
						System.out.println("actual value of Revenue Rate= "+rateR);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						js1.executeScript("arguments[0].value='"+ rateR +"'", revenuerate);                         
						Thread.sleep(1000);
						revText.click();//CLICK ON GROSS FC AMT LEBAL
						
						}
						catch(InvalidElementStateException b) {
							System.out.println("EXCEPTION OF REVENUE RATE ="+b);
						}
					
			//GROSSS BUTTON
				/*	Thread.sleep(1500);
					try {
						grossFCAmt.click();
					  } catch (Exception e) {
					     JavascriptExecutor executor = (JavascriptExecutor) driver;
					     executor.executeScript("arguments[0].click();", grossFCAmt);
					  }*/
					
			//DISC FC AMT
					Thread.sleep(500);
					try {
						discFCAmt.click();
					Thread.sleep(800);
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					js1.executeScript("arguments[0].value='"+ disfcAmt +"'", discFCAmt);
					Thread.sleep(1000);
					disamt.click();
					}
					catch(Exception e) {
						System.out.println("EXCEPTION OF DISC FC AMT ="+e);
					}
					
			//CURRENCY OF REVENUE
					Thread.sleep(500);
					try {
					String currecy = celldata.getCell(11).getStringCellValue();	
					Select s6=new Select(currencyR);
					s6.selectByVisibleText(currecy);}
					catch(Exception q) {
						System.out.println("EXCEPTION OF REVENUE CURRENCY ="+q);
					}
					
			//REMARKS
					Thread.sleep(500);
					remarksR.clear();
					Thread.sleep(1000);
					remarksR.sendKeys(celldata.getCell(12).getStringCellValue());
					
					
			//CLICK ON COST CHECK BOX	
					Thread.sleep(500);
					costCheckBox.click();   
					if(costCheckBox.isSelected()) {
								System.out.println("Revenue check box status ="+costCheckBox.isSelected());
							}
							else {
								Thread.sleep(1000);
								Actions action=new Actions(driver);
								action.moveToElement(costCheckBox).click().build().perform();
							}  

			//BUYING RATE
					
					boolean buy = buyingRate.isEnabled();
					try {
					if(buy==true) {
						buyingRate.clear();
						Thread.sleep(800);
					buyingRate.sendKeys(celldata.getCell(13).getStringCellValue());}}
					catch(InvalidElementStateException t) {
						Thread.sleep(1000);}
					
			//COST PARTY TYPE
					Thread.sleep(800);
					try{
						String partyType1 = celldata.getCell(14).getStringCellValue();
					    Select se7=new Select(partyTypeC);
					    se7.selectByVisibleText(partyType1);}
					catch(Exception x) {
						System.out.println("EXCEPTION OF COST PARTY TYPE ="+x);
					}
					
			//COST PARTY
					Thread.sleep(800);
					try {
						String val = celldata.getCell(15).getStringCellValue();
						partyBtn.click();  
						party2.sendKeys(val);              
						party2.sendKeys(Keys.ENTER);
						Thread.sleep(800);
						List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table//tr//td"));
						System.out.println("Total col size in Cost party table= "+col.size());
						
						for(int f=0;f<col.size();f++)
						{
							if(col.get(f).getText().contains(val)) {
								col.get(f).click();}}
						}
						catch(StaleElementReferenceException e) {
							System.out.println("EXCEPTION OF COST PARTY ="+e);}
					
			//COST RATE
					Thread.sleep(800);
					try {
						costrate.click();
						Thread.sleep(800);
						double value1 = celldata.getCell(16).getNumericCellValue();
						JavascriptExecutor js2=(JavascriptExecutor)driver;
						js2.executeScript("arguments[0].value='"+ value1 +"'" , costrate);
						Thread.sleep(1000);
						netFcamtlabel.click();}
						catch(InvalidElementStateException s) {
							System.out.println("EXCEPTION OF COST RATE ="+s);}
					
					
			//CURRENCY COST
					Thread.sleep(500);
					try {
					String currcyC = celldata.getCell(17).getStringCellValue();
					Select se8=new Select(currencyC);     
					se8.selectByVisibleText(currcyC);}
					catch(Exception s) {
						System.out.println("EXCEPTION OF COST CURRENCY ="+s);
					}
					
			//REMARK
					Thread.sleep(500);
					try {
						remarksC.sendKeys(celldata.getCell(18).getStringCellValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
			//CLICK ON SUBMIT BUTTON
					Thread.sleep(500);
					submitBtn.click();
					
			//CLOSE
				/*	Thread.sleep(1000);
					try {
						closeBtnRC.click();}
					catch(InvalidSelectorException p) {System.out.println("EXCEPTION OF CLOSE BUTTON ="+p);}*/
					}
					}
					catch(NullPointerException e) {
						Thread.sleep(200);;
					}
				}	
			}
				
			public void verifySaveBtn() throws Exception {	
				closeBtnRC.click();
				   Thread.sleep(1000);
				
					saveBtn.click();
					try {
					Thread.sleep(2500);
					driver.switchTo().alert().accept();
					Thread.sleep(1500);
					if(driver.switchTo().alert().getText().contains("Another booking already exists with the same Carr Doc Ref#. Continue (Y/N) ?")) {
						driver.switchTo().alert().accept();
					}
					WebElement text2 = driver.findElement(By.xpath("//div[@id='fmBox']"));
					String mass1 = text2.getText();
					System.out.println("What is the text2 +"+mass1);
					String text1 = " Booking Saved Successfully";
					Thread.sleep(2000);
					if(mass1.contains(text1)) {
						driver.findElement(By.xpath("(//a[text()='Close'])[2]")).click();
					}
		
						WebElement text3 = driver.findElement(By.xpath("/html/body/div[2]"));
				//		String errormass = text3.getText();
				//		System.out.println("What is the text3 mass ="+errormass);
						String errMass = "*   Booking updation failed. Please refer the error details.           ";
						
				    if(text3.getText().contains(errMass)) {
							driver.findElement(By.xpath("//*[@id=\"fmBox\"]/a")).click();
							Thread.sleep(1500);
							driver.findElement(By.xpath("//img[@id='ctl00_ImgErrVal']")).click();}
					
					 
				//	 if(driver.switchTo().alert().getText().contains("Do you want to continue editing?Y/N")) {
				//		 driver.switchTo().alert().accept();}
					
					}
					catch(NoAlertPresentException e) {
						System.out.println("Alert massage ="+e);
					}
			
			
			
		
			}
			

	}



