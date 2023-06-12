package MaintainBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import Base.Browser;

public class _3_JobBooking2 extends Browser {
	
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
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_rdbconfirm']")
	private WebElement confirmedRadioBtn;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlBook_Pre_Request']")
	private WebElement selectDrop;
//	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlsvc']//option")private WebElement serviceDrop;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlsvc']")
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
	private WebElement carrier;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_carrier']")
	private WebElement carrierText;
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
	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement name1;// After clicking 3 dots.
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtorigin']")
	private WebElement originText;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgDest']")
	private WebElement destination;// 3 dots checkbox
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
	private WebElement flight;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtvoy']")
	private WebElement voyage;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlFRTTerms']")
	private WebElement freightTerms;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_orginAgnt']")
	private WebElement originAgent;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_delvagent']")
	private WebElement deliveryAgent2;
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
	
//	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_qty\"]")
//	private WebElement qty;
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
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtAttribute1']")
	private WebElement attribute1;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtAttribute2']")
	private WebElement attribute2;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$txtAttribute3']")
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
	
	@FindBy(xpath="(//a[text()='Close'])[2]\"))")private WebElement closeBtn;
	
//REVENUE AND COST DETAILS
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_rev_jobitem']")private WebElement jobitembox;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement job;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_uom_type_rev']")private WebElement uomT;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imgrev_AccName']")private WebElement partyBtnR;
	@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement party1;
	@FindBy(xpath="(//span[text()='Net FC Amount'])[2]")private WebElement netFcamtlabel;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$imgRCclosediv']")private WebElement closeBtnRC;
	

	public _3_JobBooking2() {
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
		Thread.sleep(2000);
	}

	public String verifyTitle() throws Exception {
		return title.getText();
	}

	public String verifyFY() throws Exception {
		return FY.getText();
	}

	public boolean verifyLogo() {
		return logo.isDisplayed();
	}

	public String verifyCompanyName() {
		return companyName.getText();
	}

	public boolean verifyBasicBtn() {
		basicBtn.click();
		// boolean status = basicBtn.isDisplayed();
		return false; // If you need to click on Estimated Radio button then change as a true.
	}

	public String verifyestimatedRadioBtn() {
		if (verifyBasicBtn() == true) {
			estimatedRadioBtn.click();
		} else {
			confirmedRadioBtn.click();
		}
		return null;
	}

	public void verifySelectDrop() throws Exception {
		verifyestimatedRadioBtn();
		Thread.sleep(1000);
		String selectDropdown = readExcelFile(3, 7);
		Select se = new Select(selectDrop);
		se.selectByVisibleText(selectDropdown);
	//	return se.getFirstSelectedOption().getText();
	}

	public String verifyServiceDrop() throws Exception {
		
		String serviceDropdown = readExcelFile(6, 1);                                         
		Select se1 = new Select(serviceDrop);
		se1.selectByVisibleText(serviceDropdown);

		return se1.getFirstSelectedOption().getText();

	}

	public void verifyDocType() throws Exception {
		
		String docTy = readExcelFile(6, 3);
		Select s1 = new Select(docType);
		s1.selectByVisibleText(docTy);
		
	}

	public String verifyDate() throws Exception // Pending
	{
		calendarText.clear();
		calendarText.sendKeys(readExcelFile(6, 4));
		return null;

	}

	public String verifyDeliveryAgent() throws Exception {
		deliveryAgent.click();
		if (deliveryAgent.isEnabled()) {
			for (int i = 0; i < 2; i++) {
				Thread.sleep(1000);
				deliveryAgent.sendKeys(Keys.DOWN);
			}
			deliveryAgent.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Plase click on Delieviry Agent Button");
		}
		return null;
	}

	public String verifyMasterJob() {
		if (masterJob.isSelected()) {
			masterJob.sendKeys("12345");
		} else {
			System.out.println("Please select master job text box.");
		}
		return "Please select master job text box.";
	}

	public String verifyMasterOrCarrierDoc() throws Exception {
		if (masterOrCarrierDoc.isEnabled()) {
			masterOrCarrierDoc.sendKeys(readExcelFile(6, 7));
		}
		Thread.sleep(1000);
		return masterOrCarrierDoc.getText();
	}

	public String verifyCarrierDocDate() throws Exception {
		checkBox.click();
		Thread.sleep(1000);
		dateText1.clear();
		if (checkBox.isEnabled()) {
			dateText1.sendKeys(readExcelFile(6, 9)); // pending for proper way
		}

		return dateText1.getText();
	}

	public void verifyBookingSource() throws Exception {
		
		String sourceBtn = readExcelFile(6, 8);
		Select source = new Select(bookingSource);
		source.selectByVisibleText(sourceBtn);
		Thread.sleep(2000);		
	}

	public String verifyNominationAgent() throws Exception {
		verifyBookingSource();
		if (nominationAgent.isEnabled()) {
		//	nominationAgent.sendKeys(readExcelFile(6, 10));
			
			try {
				WebElement partyBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img_nominagnt']"));
				partyBtn.click();
				driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']")).sendKeys(Keys.ENTER);
					
				String val = readExcelFile(6, 10);
				List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				System.out.println("Total size of row  in Nomination Agent table= "+row.size());
				System.out.println("Total col size in Nomination Agent table= "+col.size());
					
				
				for(int i=0;i<col.size();i++)
				{
					String value = col.get(i).getText();
				//	System.out.println(value);
					
					if(value.equalsIgnoreCase(val))
					{
						Thread.sleep(1500);
	     				col.get(i).click();
	     				break;}	
				}
			}
			catch(Exception e)
			{
				System.out.println("Nomination Agent Exception ="+e);
			}
		}

		return nominationAgent.getText(); // valid data not shown in log report

		// return "Please select valid Agent";


	}

	public String verifyNominationOU() throws Exception {
		verifyBookingSource();
		if (nominationOU.isEnabled()) {
			nominationOU.sendKeys(readExcelFile(6, 12));
			
		}
		return nominationOU.getText(); // valid data not shown in log report
		// return "Please select valid OU";

	}

	public void verifyNominiBooking() throws Exception {
		nominiBooking.sendKeys(readExcelFile(6, 14));
		Thread.sleep(2000);
	}

	public void verifyHouseDoc() throws Exception {
		houseDoc.sendKeys(readExcelFile(6, 11));
		Thread.sleep(2000);
	}

	public void verifyHouseDocDate() throws Exception {
		checkBox2.click();
		Thread.sleep(1500);
		dateText.clear();
		dateText.sendKeys(readExcelFile(6, 13));
	}

	public void verifyCustomsDoc() throws Exception {
		Thread.sleep(2000);
		customsDoc.sendKeys(readExcelFile(6, 15));
	}

	public void verifyCustomer() throws Exception {
	/*	String custName = readExcelFile(6, 16);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ custName +"'" , customerText);*/	
		
		
		
	try {
		    String val = readExcelFile(6, 16);
			WebElement partyBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgCust']"));
			partyBtn.click();
			WebElement custText = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
			custText.sendKeys(val);
			custText.sendKeys(Keys.ENTER);
				
			
			List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr"));
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//td"));
			System.out.println("Total size of row  in customer table= "+row.size());
			System.out.println("Total col size in customer table= "+col.size());
				
			
			for(int i=0;i<col.size();i++)
			{
				String value = col.get(i).getText();
			//	System.out.println(value);
				
				if(value.equalsIgnoreCase(val))
				{
					Thread.sleep(1500);
     				col.get(i).click();
     				break;}	
			}
		}
		catch(Exception e)
		{
			System.out.println("Customer Exception ="+e);
		}
	
	}
	
	public void verifyCustomerEmail() throws Exception {
		
		customerEmail.sendKeys(readExcelFile(6, 17));
	}

	public String verifyCustomerOU() throws Exception {
		customerOU.sendKeys(readExcelFile(6, 18));
		if (customerOU.getText() == null) {
			return "Please enter the customer OU";
		}
		return customerOU.getText();
	}

	public void verifyACNumber() throws Exception {
		acNumber.sendKeys(readExcelFile(6, 19));
	}

	public boolean verifySalesPerson() throws Exception {
	
	/*	String selsePer = readExcelFile(6, 20);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ selsePer +"'" , salesPerson);
		Thread.sleep(1000);
		return salesPerson.getText();
*/
		if(!bookingSource.getText().equals("Svc Partner"))
		{
			salesPerson.isEnabled();
		}
		return false;
		
	}

	public void verifyOffice() throws Exception {
		office.click();
		Select select = new Select(office);
		select.selectByIndex(1);
		Thread.sleep(2000);
	}

	public void verifySalesTeam() throws Exception {
		Thread.sleep(1000);
		salesTeam.sendKeys(readExcelFile(6, 24));
	}

	public void verifyCarrier() throws Exception {
		//carrierText.sendKeys(readExcelFile(6, 21));
		
		try {
			String val = readExcelFile(6, 21);
			WebElement originBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img_carrier']"));
			originBtn.click();
			WebElement carriName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
			carriName.sendKeys(val);
			carriName.sendKeys(Keys.ENTER);	
			
			List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr"));
			List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr//td"));
			System.out.println("Total size of row  in carrier table= "+row.size());
			System.out.println("Total col size in carrier table= "+col.size());
			
			
			for(int i=0;i<col.size();i++)
			{
			//	String value = col.get(i).getText();
			//	System.out.println(value);
				
				if(col.get(i).getText().equalsIgnoreCase(val))
				{
					Thread.sleep(2000);
     				col.get(i).click();
     				break;
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("carrier exception= "+e);
		}
		
	}

	public void verifyCarrierBookRef() throws Exception {
		carrierBookRef.sendKeys(readExcelFile(6, 23));
	}

	public void verifyCommodity() throws Exception {
		commodity.sendKeys(readExcelFile(6, 25));
	}

	public void verifyCustServicePerson() throws Exception {
		
	//	custServicePerson.click();
    	String sp = readExcelFile(6, 26);
		Select s=new Select(custServicePerson);
		s.selectByVisibleText(sp);
		
		System.out.println("Ststus of service person="+custServicePerson.isSelected());
	}
	

	public void verifyCustRef() throws Exception {
		//custRef.sendKeys(readExcelFile(6, 28));
		String custReferance = readExcelFile(6, 28);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+ custReferance +"'" , custRef);
		
	}

	public void verifyOrigin() throws Exception {
	//	originText.sendKeys(readExcelFile(6, 30));
		
		try {
			String val = readExcelFile(6, 30);
			WebElement originBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgOrigin']"));
			originBtn.click();
			WebElement origintex = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
			origintex.sendKeys(val);
			origintex.sendKeys(Keys.ENTER);	
			
			List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr"));
			List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table//tr//td"));
			System.out.println("Total size of row  in origin table= "+row.size());
			System.out.println("Total col size in origin table= "+col.size());
			
			
			for(int i=0;i<col.size();i++)
			{
			//	String value = col.get(i).getText();
			//	System.out.println(value);
				
				if(col.get(i).getText().contains(val))
				{
					Thread.sleep(2000);
     				col.get(i).click();
     				break;
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Origin exception= "+e);
		}
	}

	public void verifyDestination() throws Exception {
	//	destText.sendKeys(readExcelFile(6, 31));
		
		try {
			String val = readExcelFile(6, 31);
			WebElement originBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ImgDest']"));
			originBtn.click();
			WebElement destname = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
			destname.sendKeys(val);
			destname.sendKeys(Keys.ENTER);		
			
			List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
			System.out.println("Total size of row  in destination table= "+row.size());
			System.out.println("Total col size in destination table= "+col.size());
			
			
			for(int i=0;i<col.size();i++)
			{
			//	String value = col.get(i).getText();
			//	System.out.println(value);
				
				if(col.get(i).getText().contains(val))
				{
					Thread.sleep(2000);
     				col.get(i).click();
     				break;
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("destination exception= "+e);
		}
	}

	public void verifyRoute() throws Exception {
		route.sendKeys(readExcelFile(6, 35));
	}

	public void verifyLoadPort() throws Exception {
		loarPortText.sendKeys(readExcelFile(6, 36));
	}

	public void verifyDischPortText() throws Exception {
		dischPortText.sendKeys(readExcelFile(6, 39));
	}

	public void verifyFlight() throws Exception {
		flight.sendKeys(readExcelFile(6, 27));
	}

	public void verifyVoyage() throws Exception {
		if(voyage.isEnabled()) {
		voyage.sendKeys(readExcelFile(6, 29));
		}
	}

	public void verifyFreightTerms() throws Exception {
		// freightTerms.click();
		String freightTer = readExcelFile(6, 32);
		Select se = new Select(freightTerms);
		se.selectByVisibleText(freightTer);
	}

	public void verifyOriginAgent() throws Exception {
		if(originAgent.isEnabled()) {
			String originAgent1 = readExcelFile(6, 33);
			
			try {
				
				WebElement originAgentbtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_orginAgnt']"));
				originAgentbtn.click();
				WebElement deliname = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
				deliname.sendKeys(originAgent1);
				deliname.sendKeys(Keys.ENTER);		
				
				List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				System.out.println("Total size of row  in destination table= "+row.size());
				System.out.println("Total col size in destination table= "+col.size());
				
				
				for(int i=0;i<col.size();i++)
				{	
					if(col.get(i).getText().contains(originAgent1))
					{
						Thread.sleep(2000);
	     				col.get(i).click();
	     				break;}
				}
			}
			catch(Exception e)
			{
				System.out.println("Delivery Agent exception= "+e);
			}
			
			}
	}

	public void verifyDeliveryAgent2() throws Exception {
		if(deliveryAgent2.isEnabled()) {
		String deliAgent = readExcelFile(6, 34);
		
		try {
			
			WebElement deliAgentbtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_delvagent']"));
			deliAgentbtn.click();
			WebElement deliname = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
			deliname.sendKeys(deliAgent);
			deliname.sendKeys(Keys.ENTER);		
			
			List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
			System.out.println("Total size of row  in destination table= "+row.size());
			System.out.println("Total col size in destination table= "+col.size());
			
			
			for(int i=0;i<col.size();i++)
			{	
				if(col.get(i).getText().contains(deliAgent))
				{
					Thread.sleep(2000);
     				col.get(i).click();
     				break;
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Delivery Agent exception= "+e);
		}
		
		}
	}

	public void verifyShipmentType() throws Exception {
		shipmentType.click();
		String shipment = readExcelFile(6, 37);
		Select se=new Select(shipmentType);
		se.selectByVisibleText(shipment);
	}

	public void verifyCoload() throws Exception {
		String coload1 = readExcelFile(6, 38);
		if(coload.isEnabled()) {
		Select se3 = new Select(coload);
		se3.selectByVisibleText(coload1);
		}
	}

	public void verifyBrokeText() throws Exception {
		
		
    	if(brokeText.isEnabled()) {
    		String broker = readExcelFile(6, 40);
			try {
				
				WebElement brokerPartyBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_brokParty']"));
				brokerPartyBtn.click();
				WebElement partyText = driver.findElement(By.xpath("//input[@placeholder='Party']"));
				partyText.sendKeys(broker);
				partyText.sendKeys(Keys.ENTER);		
				
				List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				System.out.println("Total size of row  in brokerage party table= "+row.size());
				System.out.println("Total col size in brokerage party table= "+col.size());
				
				
				for(int i=0;i<col.size();i++)
				{	
					if(col.get(i).getText().contains(broker))
					{
						Thread.sleep(2000);
	     				col.get(i).click();
	     				break;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("Brokarage Party exception= "+e);
			}
			
			}
		
	}

	public void verifyPickupTerm() throws Exception {
		pickupTerm.click();
		String pickup = readExcelFile(6, 41);
		Select se=new Select(pickupTerm);
		se.selectByVisibleText(pickup);
	}

	public void verifyDeliveryTerm() throws Exception {
		deliveryTerm.click();
		String delivery = readExcelFile(6, 42);
		Select se=new Select(deliveryTerm);
		se.selectByVisibleText(delivery);
	}

	public void verifyLoadType() throws Exception // This element not found on screen
	{
		String loadtp = readExcelFile(6, 43);
		if(loadType.isEnabled()) {
		Select se1 = new Select(loadType);
		se1.selectByVisibleText(loadtp);
		}

	}

	public void verifyImportBooking() throws Exception //// This element not found on screen
	{
		if(importBooking.isEnabled()) {
		importBooking.sendKeys(readExcelFile(3, 43));}
	}

	public void verifyTSLocalDelivery() throws Exception {
		String localDeli = readExcelFile(6, 45);
		if(TSLocalDelivery.isEnabled()) {
		Select se2 = new Select(TSLocalDelivery);
		se2.selectByVisibleText(localDeli);}
	}

	public void verifyTSLocalDeliveryRemark() throws Exception {
		if(TSLocalDeliveryRemark.isEnabled()) {
		TSLocalDeliveryRemark.sendKeys(readExcelFile(6, 45));}
	}
	

	///// *************Freight Details*******************//////

	public String verifyFrightsDetailsText() throws Exception {
		return frightsDetailsText.getText();
	}

	public void scroll() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling up to element
		js.executeScript("arguments[0].scrollIntoView();", frightsDetailsText);
		Thread.sleep(2000);
	}

	public void verifyWeight() throws Exception {
		scroll();
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		weight.click();
		Thread.sleep(2000);
		double value1 = excelSheet.getRow(11).getCell(1).getNumericCellValue();//For Weight
		System.out.println("Before value of weight= "+value1);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value1 +"'" , weight);
		System.out.println("After value of weight= "+value1);
		}
		catch(Exception e) {
			System.out.println("weight value wrong shows= "+e);
		}
	}

	public void verifyVolume() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		volume.click();
	//	quentity.sendKeys(Keys.ENTER);
	//	volume.clear();
		Thread.sleep(2000);
		double value1 = excelSheet.getRow(11).getCell(3).getNumericCellValue();
		System.out.println("Before value of weight= "+value1);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value1 +"'" , volume);
		System.out.println("After value of weight= "+value1);
	//	volume.sendKeys(readExcelFile(11, 3));
	}

	public void verifyChargWtOrFrtTone() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		chargWtOrFrtTone.click();
	//	quentity.sendKeys(Keys.ENTER);
	//	chargWtOrFrtTone.clear();
		Thread.sleep(2000);
		double value1 = excelSheet.getRow(11).getCell(5).getNumericCellValue();
		System.out.println("Before value of weight= "+value1);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value1 +"'" , chargWtOrFrtTone);
		System.out.println("After value of weight= "+value1);
		//chargWtOrFrtTone.sendKeys(readExcelFile(11, 5));HSCodeText
	}

	public void verifyHSCodeText() throws Exception {
		scroll();
		HSCodeText.sendKeys(readExcelFile(11, 2));
/*	//	String hscode = readExcelFile(11, 2);
		double hscode = readNumericExcelFile(11, 2);
	//	String nuericString = Double.toString(hscode);
		
		 
		 try {
				
				WebElement hs = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Img100']"));
				hs.click();
				WebElement hsText = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
				JavascriptExecutor js2=(JavascriptExecutor)driver;
				double a = (Double) js2.executeScript("arguments[0].value='"+ hscode +"'" , hsText);
				String nuericString = Double.toString(a);
			//	hsText.sendKeys(a);
				hsText.sendKeys(Keys.ENTER);		
				
				List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr"));
				List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr//td"));
				System.out.println("Total size of row  in HS code table= "+row.size());
				System.out.println("Total col size in HS code table= "+col.size());
				
				for(int i=0;i<col.size();i++)
				{	
					if(col.get(i).getText().equalsIgnoreCase(nuericString))
					{
	     				col.get(i).click();
	     				break;}
				}
			}
			catch(Exception e)
			{
				System.out.println("HS Code Exception= "+e);}*/
			}
	

	public void verifyDangGood() throws Exception {
		scroll();
		String goods = readExcelFile(11, 4);
		Select dgood = new Select(dangGood);
		dgood.selectByVisibleText(goods);
	}

	public void verifyIMDGDetails() throws Exception {
		scroll();
		IMDGDetails.sendKeys(readExcelFile(11, 6));
	}

	public void verifyFtContaner20() throws Exception {
		scroll();
		ftContaner20.sendKeys(readExcelFile(11, 7));
	}

	public void verifyFtContaner40() throws Exception {
		scroll();
		ftContaner40.sendKeys(readExcelFile(11, 10));
	}

	public void verifyNoPackg() throws Exception {
		scroll();
		noPackg.sendKeys(readExcelFile(11, 8));

	}

	public void verifyitemDetails() throws Exception {
		scroll();
		itemDetails.click();
		for (int i = 0; i < 7; i++) {
			Thread.sleep(1000);
			itemDetails.sendKeys(Keys.DOWN);
		}
		itemDetails.sendKeys(Keys.ENTER);

	}

	public String verifyPoptitle() throws Exception ///////////// Today Start
	{
		scroll();
		return poptitle.getText();

	}
	
	public void verifyScrollUp() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
	}

	public void verifyRevAdCostBtn() throws Exception {
		Actions act =  new Actions(driver);
		act.moveToElement(basicBtn).click().build().perform();
		Thread.sleep(1500);
		scroll();
		revAdCostBtn.click();
	}

	public void verifyQuotationNoText() throws Exception {
		quotationNoText.sendKeys(readExcelFile(16, 1));
	}

	public void verifyJobIteam() throws Exception {
		
		try {   
			String val = readExcelFile(16, 2);
		WebElement jobitembox = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_rev_jobitem']"));
		jobitembox.click();
		WebElement job = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		job.sendKeys(val);
		job.sendKeys(Keys.ENTER);	
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
		System.out.println("Total row Size in jobiteam table= "+row.size());
		System.out.println("Total size of col in jobiteam table= "+col.size());
		
		for(int i=0;i<col.size();i++)
		{
			if(col.get(i).getText().contains(val))
			{
				col.get(i).click();
				Thread.sleep(1500);
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
	}

	public void verifyIteamDesc() throws Exception {                    
		try {
			iteamDesc.clear();	
		iteamDesc.sendKeys(readExcelFile(16, 3));
		}catch(Exception a){
			System.out.println(a);
		}
	}

	public void verifyUOMType() throws Exception {
		UOMType.click();
		String oumType = readExcelFile(16, 4);
		Select se4 = new Select(UOMType);
		se4.selectByVisibleText(oumType);
	}

	public void verifyUOM() throws Exception {
		UOM.click();
		String oum = readExcelFile(16, 5);
		Select se=new Select(UOM);
		se.selectByVisibleText(oum);

	}
	
	public void verifyQuentity() throws Exception
	{
		System.out.println("status of text= "+quentity.isEnabled());
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		quentity.click();
	//	quentity.sendKeys(Keys.ENTER);
	//	quentity.clear();
		Thread.sleep(2000);
		double value = excelSheet.getRow(16).getCell(6).getNumericCellValue();
		System.out.println("actual value= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , quentity);
		}

	public void verifyQty() throws Exception //// Qty Not Showing
	{
			
/*		try {
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		double value = excelSheet.getRow(16).getCell(6).getNumericCellValue();
		System.out.println("Numeric value= "+value);
		String nuericString = Double.toString(value);                             //Convert value from double to string format
	//	System.out.println("Change value= "+value);
		qty1.clear();
		Thread.sleep(2000);
		qty1.sendKeys(value);
		if(!qty1.equals("weight"+"volume"+"chargWtOrFrtTone"))
		{
		qty1.sendKeys(nuericString);
		}
		}
		catch(Exception e)
		{
			System.out.println("Please check your Qty list= "+e);
		}*/


		
	}

	public void verifyTariffTerm() throws Exception {
		String tariff = readExcelFile(16, 7);
		Select se5 = new Select(tariffTerm);
		se5.selectByVisibleText(tariff);
	}

	public void verifyrevCheckBoxDataEntry()
	{
		revCheckBoxDataEntry.click();
	}
	public void verifyRevCheckBox() throws Exception {
		verifyRevAdCostBtn();
		Thread.sleep(1000);
		revCheckBox.click();
	}

	public void verifyPartyTypeR() throws Exception {
		
		String partyDrop = readExcelFile(21, 1);
		Select se=new Select(partyTypeR);
		se.selectByVisibleText(partyDrop);
		
	}

	public void verifyPartyTextR() throws Exception {
	//	partyTextR.sendKeys(readExcelFile(21, 2));
		
		try {
			String val = readExcelFile(21, 2);
			WebElement partyBtn = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imgrev_AccName']"));
			partyBtn.click();
			WebElement party1 = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
			party1.sendKeys(val);
			party1.sendKeys(Keys.ENTER);	
			
			List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table//tr"));
			List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table//tr//td"));
			System.out.println("Total size of row  in party table= "+row.size());
			System.out.println("Total col size in party table= "+col.size());
			
			for(int i=0;i<col.size();i++)
			{
			//	String value = col.get(i).getText();
			//	System.out.println(value);
				if(col.get(i).getText().contains(val))
				{
					col.get(i).click();
					Thread.sleep(1500);
				}
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

	public void verifyRevenuerate() throws Exception {
		
		try {
		System.out.println("status of text= "+revenuerate.isEnabled());
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		revenuerate.click();
	//	revenuerate.sendKeys(Keys.ENTER);
	//	Thread.sleep(2000);
		double value = excelSheet.getRow(21).getCell(3).getNumericCellValue();                
		System.out.println("actual value= "+value);
	
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value='"+ value +"'", revenuerate);
		}
		catch(Exception b) {
			System.out.println(b);
		}
	}

	public void verifyGrossFCAmt() throws Exception     
	{
		
		/*  double num1 =Double.parseDouble(driver.findElement(By.xpath(
		  "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_qty']")).
		  getText()) ;
		  double num2 = Double.parseDouble(driver.findElement(By.xpath(
		  "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_rate']")).
		  getText());
		  WebElement gross = driver.findElement(By.xpath(
		  "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_Grossfcamt']"))
		  ; double mul;
		  mul=num1*num2;
		  String nuericString = Double.toString(mul);
		gross.sendKeys(nuericString);
		  
		  
		  
		 * 
		 * JavascriptExecutor js2=(JavascriptExecutor)driver;
		 * //js2.executeScript("arguments[0].value='"+ qty +"'" , grossFCAmt);
		 * 
		 * String exm = revenuerate.getText(); int searchValue =
		 * Integer.parseUnsignedInt(qty) * Integer.parseUnsignedInt(exm);
		 * js.executeScript("document.getElementById('"+grossFCAmt+"').value=\'"+
		 * searchValue+"\';");
		 * 
	
		 
		 
		 

		// String b = verifyQty();

		WebElement input1 = driver
				.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_qty']"));
		WebElement input2 = driver
				.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_rate']"));*/
	//	WebElement gross = driver
			//	.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_Grossfcamt']"));
		// input1.clear();
		Thread.sleep(1000);

	  //  input1.sendKeys("100");
	//	input2.sendKeys("1.5");
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
//    	gross.sendKeys((CharSequence[]) js.executeScript("return arguments[0].value*arguments[1].value", qty, revenuerate));
	  //  js.executeScript("return arguments[0].value*arguments[1].value", qty, revenuerate);
		// gross.sendKeys(b);
		// return a;
		
		
		
		
	//	String qty_1 =qty.toString();
		
/*		int qty_9 = Integer.parseInt(driver.findElement(By.id("ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_qty")).getText());
		System.out.println("value of qty_1= "+qty_9);
		String revenuerate_1 =revenuerate.getText();
		System.out.println("value of revenuerate_1= "+revenuerate_1);
		double qty_2 = Double.parseDouble(qty_1);
		double revenuerate_2 = Double.parseDouble(revenuerate_1);
		double gross_1=qty_2*revenuerate_2;
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value='"+ gross_1 +"'", grossFCAmt);*/
		
	/*	catch(Exception c)
		{
			//c.getStackTrace();
			System.out.println("Show the Exception="+c);
		}
		
	*/	
		
		
		
	/*	public void sendKeysINTByJS(WebDriver driver, WebElement element, int attributeValue){
		    JavascriptExecutor js = ((JavascriptExecutor) driver);
		    js.executeScript("arguments[0].setAttribute('gross_1','"+attributeValue+"');", grossFCAmt);
		}
		
	*/	
		
		
		
		
		
/*		
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\IFF_Project\\\\Test_Data\\\\IFF TEST DATA.xlsx");
	//	Sheet excelSheet = WorkbookFactory.create(fis).getSheet("IFF");
	//	String value = excelSheet.getRow(row).getCell(col).getStringCellValue();

		// Create a Workbook object using the FileInputStream
		Workbook workbook = new XSSFWorkbook(fis);

		// Get the first sheet in the workbook
		Sheet sheet = workbook.getSheet("IFF");

		// Get the values of the first two cells in the first row
		double num1 =  sheet.getRow(16).getCell(7).getNumericCellValue();
		double num2 =  sheet.getRow(21).getCell(3).getNumericCellValue();

		// Create a JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Execute the Javascript code to add the two numbers
		String result = (String)js.executeScript("return arguments[0] * arguments[1];", num1, num2);

		gross.sendKeys(result);
		
		
		// Get the cell object for the specified row and column
		Cell cell = sheet.getRow(16).getCell(7);

		// Check if the cell value is a string or a character sequence
		if (cell.getCellType() == CellType.STRING) {
		    // Read the cell value as a string using the getStringCellValue() method
		    String cellValue = cell.getStringCellValue();
		    System.out.println("**********="+cellValue);
		    // Use the cell value as needed
		} else {
		    // Handle the case where the cell value is not a string or a character sequence
		}
*/
	}
	public void verifyDiscFCAmt() throws Exception{
		
		System.out.println("status of text= "+discFCAmt.isEnabled());
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		discFCAmt.click();
		System.out.println("status of text is selected After click= "+discFCAmt.isSelected());
	
	//	Thread.sleep(2000);
		double value = excelSheet.getRow(21).getCell(5).getNumericCellValue();
		System.out.println("actual value= "+value);
	
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value='"+ value +"'", discFCAmt);
		String rate = discFCAmt.getText();
		System.out.println(rate);
	
	}
	
	public void verifyNetFCAmt() throws Exception {        
	//	netFCAmt.sendKeys(readExcelFile(21, 6));
	//	verifyRevenuerate();
	//	netFCAmt.sendKeys("");
		JavascriptExecutor js4=(JavascriptExecutor)driver;
		netFCAmt.sendKeys( (CharSequence[]) js4.executeScript("return arguments[0].value - arguments[1].value", grossFCAmt,discFCAmt));
	//	js4.executeScript("return arguments[0].value - arguments[1].value", grossFCAmt,discFCAmt,netFCAmt);
	}
	
	public void verifyCurrencyR()
	{
		
		Select s6=new Select(currencyR);
		s6.selectByVisibleText("AED");
	}
	public void verifyExRateR() throws Exception
	{
		exRateR.clear();
		exRateR.sendKeys(readExcelFile(21, 8));
	}
	public void verifyLCAmtR() throws Exception{
		LCAmtR.getText();
		LCAmtR.sendKeys(readExcelFile(21, 9));
	}
	public void verifyRemarksR() throws Exception
	{
		remarksR.sendKeys(readExcelFile(21, 10));
	}
	public void verifyCostCheckBox()               
	{
		costCheckBox.click();
	}
	public void verifyBuyingRate() throws Exception
	{
		buyingRate.sendKeys(readExcelFile(26, 1));
	}
	public void verifyPartyTypeC() throws Exception
	{
		String partyType1 = readExcelFile(26, 2);        
		Select se7=new Select(partyTypeC);
		se7.selectByVisibleText(partyType1);
	}
	public void verifyPartyTextC() throws Exception
	{
	//	partyTextC.sendKeys(readExcelFile(26, 3));
		
		try {
			String val = readExcelFile(26, 3);
			WebElement partyBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$Imgcst_accname']"));
			partyBtn.click();
			WebElement party2 = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
			party2.sendKeys(val);
			party2.sendKeys(Keys.ENTER);		
			
			List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table//tr"));
			List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table//tr//td"));
			System.out.println("Total size of row  in Cost party table= "+row.size());
			System.out.println("Total col size in Cost party table= "+col.size());
			
			for(int i=0;i<col.size();i++)
			{
			//	String value = col.get(i).getText();
			//	System.out.println(value);
				if(col.get(i).getText().contains(val))
				{
					col.get(i).click();
					Thread.sleep(1500);
				}
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public void verifyCostrate() throws Exception
	{
		try {
		System.out.println("status of text= "+costrate.isEnabled());
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		costrate.click();
	//	quentity.sendKeys(Keys.ENTER);
	//	costrate.clear();
		
		double value = excelSheet.getRow(26).getCell(4).getNumericCellValue();
		System.out.println("actual value= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , costrate);
	
	//	driver.findElement(By.xpath("(//span[text()='Net FC Amount'])[2]")).click();
		}
		catch(Exception s)
		{
			System.out.println("Cost rate ="+s);            
		}
		
		
	}
	public void verifyNetFCAmtC() throws Exception
	{
		
		System.out.println("status of text= "+netFCAmtC.isEnabled());
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		netFCAmtC.click();
	//	quentity.sendKeys(Keys.ENTER);
		netFCAmtC.clear();
		double value = excelSheet.getRow(26).getCell(5).getNumericCellValue();
		System.out.println("actual value= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , netFCAmtC);
	}
	public void verifyCurrencyC()
	{
		Select se8=new Select(currencyC);     //
		se8.selectByVisibleText("USD");
	}
	public void verifyExRateC() throws Exception
	{
		exRateC.sendKeys(readExcelFile(26, 7));          
	}
	public void verifyLCAmtC()
	{
		try {
			LCAmtC.sendKeys(readExcelFile(26, 8));       
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void verifyRemarksC() throws Exception
	{
		try {
			remarksC.sendKeys(readExcelFile(26, 9));
		} catch (ElementNotInteractableException e) {
			System.out.println("Exception of cost remark ="+e);
		}
	}
	public void verifySubmitBtn() throws InterruptedException
	{
		Thread.sleep(1500);
		submitBtn.click();
		driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$imgRCclosediv']")).click();
		WebElement container20 = driver.findElement(By.xpath("//td[normalize-space()='20ft Container']"));
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling up to element
		js.executeScript("arguments[0].scrollIntoView();", container20);
		Thread.sleep(2000);

	//	driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$btnCancel']")).click();
	//	System.out.println("Massage Display on Screen = "+driver.switchTo().alert().getText());
	//	driver.switchTo().alert().accept();
	}

//***************+++++++++++Service/Ops Details++++++++++****************//	

	public void verifyServiceDetailsBtn() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1500);
		Actions as=new Actions(driver);
		as.moveToElement(serviceDetailsBtn).click().build().perform();
		//serviceDetailsBtn.click();
	}

	public String verifyPartyDetailsText() throws Exception {
		return partyDetailsText.getText();
	}

	public void verifyShipperNameText() throws Exception {
		shipperNameText.sendKeys(readExcelFile(31, 1));
	}

	public void verifyShipperAddress() throws Exception {
		shipperAddress.sendKeys(readExcelFile(31, 2));
	}

	public void verifyConsigneeNameText() throws Exception {
		consigneeNameText.sendKeys(readExcelFile(31, 3));
	}

	public void verifyConsigneeAddress() throws Exception {
		consigneeAddress.sendKeys(readExcelFile(31, 4));
	}

	public void verifyNotifyNameText() throws Exception {
		notifyNameText.sendKeys(readExcelFile(31, 5));
	}

	public void verifyNotifyAddress() throws Exception {
		notifyAddress.sendKeys(readExcelFile(31, 6));
	}

	public void verifyCHAName() throws Exception {
		CHAName.sendKeys(readExcelFile(31, 7));
	}

	public void verifyCHAAddress() throws Exception {
		CHAAddress.sendKeys(readExcelFile(31, 8));
	}

	public void verifyCHANumber() throws Exception {
		CHANumber.sendKeys(readExcelFile(31, 9));
	}

	public String verifyOpTitle() throws Exception {
		return opTitle.getText();
	}

	public void verifyETDDate() throws Exception {
		ETDDate.sendKeys(readExcelFile(31, 10));
	}

	public void verifyCutOffDate() throws Exception {
		cutOffDate.sendKeys(readExcelFile(31, 11));
		
		time1.click();
		String hh = readExcelFile(31, 12);
		WebElement hour = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlHH']"));
		hour.click();
		Select hh1 = new Select(hour);
		hh1.selectByVisibleText(hh);
		
		String mm = readExcelFile(32, 12);
		WebElement min = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlMM']"));
		Select mm1 = new Select(min);
		mm1.selectByVisibleText(mm);
		driver.findElement(By.xpath("//a[text()='Apply']")).click();
	}

	public void verifySailingDate() throws Exception {
		sailingDate.sendKeys(readExcelFile(31, 13));
	}

	public void verifyVGMCutOffDate() throws Exception {
		VGMCutOffDate.sendKeys(readExcelFile(31, 14));
		time2.click();
		String hh = readExcelFile(31, 15);
		WebElement hour1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlHH"));
		Thread.sleep(1000);
		Select h = new Select(hour1);
		h.selectByVisibleText(hh);
		
		String mm = readExcelFile(32, 15);
		WebElement min1 = driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$ddlMM"));
		Thread.sleep(1000);
		Select m = new Select(min1);
		m.selectByVisibleText(mm);
		driver.findElement(By.xpath("//a[text()='Apply']")).click();
	}

	public void verifyDocCutOff() throws Exception {
		docCutOff.sendKeys(readExcelFile(31, 16));
		time3.click();
		String hh = readExcelFile(31, 17);
		WebElement hour2 = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlHH']"));
		Thread.sleep(1000);
		Select h2 = new Select(hour2);
		h2.selectByVisibleText(hh);
		String mm = readExcelFile(32, 17);
		WebElement min2 = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlMM']"));
		Thread.sleep(1000);
		Select m2 = new Select(min2);
		m2.selectByVisibleText(mm);
		driver.findElement(By.xpath("//a[text()='Apply']")).click();
	}

	public void verifySlectDropOriginOpe() throws Exception {
		String pickup = readExcelFile(31, 18);
		Select pickUp = new Select(originPickUp);
		pickUp.selectByVisibleText(pickup);
		
		String cust = readExcelFile(31, 19);
		Select custom = new Select(originCustoms);
		custom.selectByVisibleText(cust);
		
		String deli = readExcelFile(31, 20);
		Select delivery = new Select(deliveryBy);
		delivery.selectByVisibleText(deli);

		SICutOffDate.sendKeys(readExcelFile(31, 21));
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$imgSI_time")).click();
		String hh = readExcelFile(31, 22);
		WebElement hour3 = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlHH']"));
		hour3.click();
		Select h3 = new Select(hour3);
		h3.selectByVisibleText(hh);
		
		String mm = readExcelFile(32, 22);
		WebElement min3 = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookSvcOpsDet_ddlMM']"));
		min3.click();
		Select m3 = new Select(min3);
		m3.selectByVisibleText(mm);
		driver.findElement(By.xpath("//a[text()='Apply']")).click();

	}

	public String verifyDestinationOperTitle() throws Exception {
		return destinationOperTitle.getText();
	}

	public void verifyETADate() throws Exception {
		ETADate.sendKeys(readExcelFile(31, 23));
	}

	public void verifyArrivalTest() throws Exception {
		arrivalTest.sendKeys(readExcelFile(31, 24));
	}

	public void verifyDeliveryDate() throws Exception {
		deliveryDate.sendKeys(readExcelFile(31, 25));
	}

	public void verifyDestinationDelivery() throws Exception {
		String destDeli = readExcelFile(31, 26);
		Select delivery = new Select(destinationDelivery);
		delivery.selectByVisibleText(destDeli);
	}

	public void verifyDestinationCoustoms() throws Exception {
		String destCust = readExcelFile(31, 27);
		Select custom = new Select(destinationCoustoms);
		custom.selectByVisibleText(destCust);
	}

	public void verifyScroll() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling up to element
		js.executeScript("arguments[0].scrollIntoView();", scrollText);
		Thread.sleep(2000);
	}

	public String verifyOtherDetailsTitle() throws Exception {
		return otherDetailsTitle.getText();
	}

	public void verifyTOS() throws Exception {
		String tos1 = readExcelFile(31, 28);
		Select tos = new Select(TOS);
		tos.selectByVisibleText(tos1);
	}

	public void verifyServiceDetails() throws Exception {
		serviceDetails.sendKeys(readExcelFile(31, 29));
	}

	public void verifyOperInstruction() throws Exception {
		operInstruction.sendKeys(readExcelFile(31, 30));
	}

	public void verifyTransporter() throws Exception {
		if(transporter.isEnabled()) {
			
			
			try {
				WebElement transportBtn = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookSvcOpsDet$img_transport']"));
				transportBtn.click();
				driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']")).sendKeys(Keys.ENTER);
					
				String transpo = readExcelFile(31, 31);
				List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
				List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
				System.out.println("Total size of row  in Nomination Agent table= "+row.size());
				System.out.println("Total col size in Nomination Agent table= "+col.size());
					
				
				for(int i=0;i<col.size();i++)
				{					
					if(col.get(i).getText().equalsIgnoreCase(transpo))
					{
						Thread.sleep(1500);
	     				col.get(i).click();
	     				break;}	
				}
			}
			catch(Exception e)
			{
				System.out.println("Nomination Agent Exception ="+e);
			}
		}
	}

	public void verifyVehicalDetails() throws Exception {
		if(vehicalDetails.isEnabled()) {
		vehicalDetails.sendKeys(readExcelFile(31, 32));
		}
	}

	public void verifyCFSDropdown() throws Exception {
		String cfsDrop = readExcelFile(31, 33);
		Select cfs = new Select(CFSDropdown);
		cfs.selectByVisibleText(cfsDrop);
	}

//*************************************Additional Details****************************************//

	public void verifyAdditionalDetailsBtn() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1500);
		Actions as=new Actions(driver);
		as.moveToElement(additionalDetailsBtn).click().build().perform();
		
	//	additionalDetailsBtn.click();
	}

	public void verifyMarksAndNumber() throws Exception {
		marksAndNumber.sendKeys(readExcelFile(36, 1));
	}

	public void verifyCargoDesc() throws Exception {
		cargoDesc.sendKeys(readExcelFile(36, 2));
	}

	public void verifyIMGNo() throws Exception {
		IMGNo.sendKeys(readExcelFile(36, 3));
	}

	public void verifyIMGDateText() throws Exception {
		IMGDateText.clear();
		IMGDateText.sendKeys(readExcelFile(36, 4));
	}

	public void verifyItemNo() throws Exception {
		itemNo.sendKeys(readExcelFile(36, 5));
	}

	public void verifyItemType() throws Exception {
		itemType.sendKeys(readExcelFile(36, 6));
	}

	public void verifyStuffingText() throws Exception {
		stuffingText.sendKeys(readExcelFile(36, 7));
	}

	public void verifyCIRef() throws Exception {
		CIRef.sendKeys(readExcelFile(36, 8));
	}

	public void verifyCIDate() throws Exception {
		CIDate.sendKeys(readExcelFile(36, 9));
	}

	public void verifyCICurrency() throws Exception {
		CICurrency.click();
		for (int i = 0; i < 5; i++) {
			Thread.sleep(300);
			CICurrency.sendKeys(Keys.ARROW_DOWN);
		}
		CICurrency.sendKeys(Keys.ENTER);
	}

	public void verifyCIValue() throws Exception {
		CIValue.sendKeys(readExcelFile(36, 11));
	}

	public void verifyAttributes() throws Exception {
		attribute1.sendKeys(readExcelFile(36, 12));
		attribute2.sendKeys(readExcelFile(36, 13));
		attribute3.sendKeys(readExcelFile(36, 14));
	}

	public void verifyFileUpload() throws Exception {
		driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookAddDet$uploadXL$txtUcxFileName']"))
				.sendKeys("C:\\Users\\Admin\\Desktop");
		// browse.click();

	}

//Container List	
	public void verifyCntrNo() throws Exception {
		cntrNo.sendKeys(readExcelFile(40, 01));
	}

	public void verifyCntrType() throws Exception {
		cntrType.click();
		Select cntrType1 = new Select(cntrType);
		cntrType1.selectByIndex(5);
	}

	public void verifyCustomsSeal() throws Exception {
		customsSeal.sendKeys(readExcelFile(40, 3));                   
	}

	public void verifyAgentSeal() throws Exception {
		agentSeal.sendKeys(readExcelFile(40, 4));
	}

	public void verifyTareWt() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		tareWt.click();
	//	quentity.sendKeys(Keys.ENTER);
	//	tareWt.clear();
		Thread.sleep(2000);
		double value = excelSheet.getRow(40).getCell(5).getNumericCellValue();
		System.out.println("actual value of Tare Wt= "+value);
	//	String nuericString = Double.toString(value);
	//	tareWt.sendKeys(nuericString);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , tareWt);
		
	//	tareWt.clear();
	//	tareWt.sendKeys(readExcelFile(40, 5));
		
	/*	System.out.println("***** Tare *******");
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		tareWt.click();
	//	quentity.sendKeys(Keys.ENTER);
		tareWt.clear();
		Thread.sleep(1000);
		String value = excelSheet.getRow(40).getCell(5).getStringCellValue();
		System.out.println("before value of Tare Wt= "+value);
		
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		Object a = js2.executeScript("arguments[0].value='"+ value +"'" , tareWt);
		System.out.println("show the Actual/After value of Tare Wt="+tareWt.getText());
		
		*/
	}

	public void verifyCargoWt() throws Exception {
		try
		{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		cargoWt.click();
	//	quentity.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		double value = excelSheet.getRow(40).getCell(6).getNumericCellValue();
		System.out.println("actual value of cargo= "+value);
	//	cargoWt.clear();
	//	String nuericString1 = Double.toString(value);
	//	cargoWt.sendKeys(nuericString1);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , cargoWt);
		}
		catch(Exception e) {
			System.out.println("cargo value is wrong="+e);
		}
		
		
	//	tareWt.clear();
	//	cargoWt.sendKeys(readExcelFile(40, 6));
	/*	System.out.println("***** cargo *******");
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		cargoWt.click();
	//	quentity.sendKeys(Keys.ENTER);
		cargoWt.clear();
		Thread.sleep(1000);
		String value = excelSheet.getRow(40).getCell(6).getStringCellValue();
		System.out.println("Before value of cargo= "+value);
		
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , cargoWt);
		System.out.println("show the Actual/After value of cargo Wt="+cargoWt.getText());*/
	
	}

	public void verifyVGMWt() throws Exception //// Pending for addition
	{
	/*	FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		VGMWt.click();
	//	quentity.sendKeys(Keys.ENTER);
		VGMWt.clear();
		Thread.sleep(2000);
		double value = excelSheet.getRow(40).getCell(7).getNumericCellValue();
		System.out.println("actual value of Net Wait= "+value);*/
		System.out.println("***** VGM *******");
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		VGMWt.click();
	//	quentity.sendKeys(Keys.ENTER);
		VGMWt.clear();
		Thread.sleep(1000);
		String value = excelSheet.getRow(40).getCell(7).getStringCellValue();
		System.out.println("Before value of VGM Wt= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].removeAttribute('disabled').value='"+ value +"'",VGMWt);
		System.out.println("After value of VGM Wt= "+VGMWt.getText());
	//	VGMWt.sendKeys(readExcelFile(40, 7));
		 
		
	}

	public void verifyNetWt() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		netWt.click();
	//	quentity.sendKeys(Keys.ENTER);
		netWt.clear();
		Thread.sleep(2000);
		double value = excelSheet.getRow(40).getCell(8).getNumericCellValue();                
		System.out.println("Before pass value of Net Wait= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , netWt);
		System.out.println("After passing value of Net Wait= "+value);
		
		
	}

	public void verifyConVolume() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		conVolume.click();
	//	quentity.sendKeys(Keys.ENTER);
		conVolume.clear();
		Thread.sleep(2000);
		double value = excelSheet.getRow(40).getCell(9).getNumericCellValue();
		System.out.println("actual value of the cotainer volume= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , conVolume);
	//	conVolume.sendKeys(readExcelFile(40, 9));
		System.out.println("After value of no of Units= "+conVolume.getText());
	}

	public void verifyPkgType() throws Exception {
		String pkgT = readExcelFile(11, 9);
		Select pkg = new Select(pkgType);
		pkg.selectByVisibleText(pkgT);
	}

	public void verifyNoOfUnits() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		noOfUnits.click();
	//	quentity.sendKeys(Keys.ENTER);
		noOfUnits.clear();
		Thread.sleep(2000);
		double value = excelSheet.getRow(40).getCell(11).getNumericCellValue();
		System.out.println("Before value of no of Units= "+value);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='"+ value +"'" , noOfUnits);
	//	noOfUnits.sendKeys(readExcelFile(40, 11));
		System.out.println("After value of no of Units= "+noOfUnits.getText());
	}

	public void verifyRemarks() throws Exception {
		remarks.sendKeys(readExcelFile(40, 12));                   
	}

	public void verifyAddBtn1() throws Exception //// calculation Error
	{
		verifyCntrNo();
		verifyCntrType();
		verifyCustomsSeal();
		verifyAgentSeal();
		verifyTareWt();
		verifyCargoWt();
//		verifyVGMWt();     //This value wrong showing
		verifyNetWt();
		verifyConVolume();
		verifyPkgType();
		verifyNoOfUnits();
		verifyRemarks();
		addBtn1.click();
		driver.switchTo().alert().accept();

	}
	public void verifyaddBtn() throws Exception
	{
		addBtn1.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	
	}

//Vehicle Packing
	public void verifyVehicleEquipInd() throws Exception {                
		String equipment = readExcelFile(45, 1);
		Select equ = new Select(vehicleEquipInd);
		equ.selectByVisibleText(equipment);
	}

	public void verifyUsedOrNew() throws Exception {
		String newUsed = readExcelFile(45, 2);
		Select used = new Select(usedOrNew);
		used.selectByVisibleText(newUsed);
	}

	public void verifyVehicleDetails() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(300,0)");
		Thread.sleep(1500);
		
		chassiNo.sendKeys(readExcelFile(45, 3));
		caseNo.sendKeys(readExcelFile(45, 4));
		make.sendKeys(readExcelFile(45, 5));
		model.sendKeys(readExcelFile(45, 6));
		engineNo.sendKeys(readExcelFile(45, 7));
		colour.sendKeys(readExcelFile(45, 9));
		yearBuilt.sendKeys(readExcelFile(45, 8));
	}

	public void verifyRollingOrStatic() throws Exception {
		String rolling = readExcelFile(45, 10);
		Select roll = new Select(rollingOrStatic);
		roll.selectByVisibleText(rolling);
	}

	public void verifyDescOfGood() throws Exception {
		descOfGood.sendKeys(readExcelFile(45, 11));
	}

	public void verifyAddAccessories() throws Exception {
		addAccessories.sendKeys(readExcelFile(45, 12));
	}

	public void verifyweight1Andvolume1() throws Exception {
		
		weight1.sendKeys(readExcelFile(45, 13));
		volume1.sendKeys(readExcelFile(45, 14));                    
	}

	public void verifyRemarks1() throws Exception {
		remarks1.sendKeys(readExcelFile(45, 15));
	}

	public void verifyVehiclePackingList() throws Exception {
		verifyVehicleEquipInd();
		verifyUsedOrNew();
		verifyVehicleDetails();
		verifyRollingOrStatic();
		verifyDescOfGood();
		verifyAddAccessories();
		verifyweight1Andvolume1();
		verifyRemarks1();
		addBtn2.click();
	}
	public void verifyaddBtn2()
	{
		addBtn2.click();
	}

	public void verifyFinalRemarks() throws Exception {
		finalRemarks.sendKeys(readExcelFile(45, 16));
	}
	public void verifySaveBtn() throws Exception
	{
		   closeBtnRC.click();
		   Thread.sleep(1000);
		
			saveBtn.click();
			try {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
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
			
			WebElement text3 = driver.findElement(By.xpath("//div[@class='fmBox err']"));
			String errormass = text3.getText();
			System.out.println("What is the text3 mass ="+errormass);
			String errMass = "Booking updation failed. Please refer the error details.";
			
			 if(errormass.contains(errMass)) {
				driver.findElement(By.xpath("(//a[text()='Close'])[2]")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//img[@id='ctl00_ImgErrVal']")).click();}
			
			}
			catch(Exception e) {
				System.out.println("Alert massage ="+e);
			}
			
			
	/*	driver.switchTo().alert().accept();
		Thread.sleep(2500);
	//	driver.switchTo().alert().accept();
		WebElement massage = driver.findElement(By.xpath("//div[text()='*   Booking Saved Successfully MUM/BKG/AFE/00066/2022           ']"));
		Thread.sleep(3000);
		String status = massage.getText();
		System.out.println("Show the result ="+status);
		driver.findElement(By.xpath("//*[@id=\"fmBox\"]/a")).click();//Close the massage
		*/
		
		
	}
	public void verifyReports() throws Exception
	{
		
		WebElement pop = driver.findElement(By.xpath("//td[normalize-space (text())='Select Report Type']"));
		try {
		if(pop.isEnabled()) {
		summeryReport.click();
		okBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		financeReport.click();
		okBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		salesReport.click();
		okBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		operationReport.click();
		okBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		customerReport.click();
		okBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$imgclosediv']")).click();}
		
		
	}
		catch(Exception e) {
		System.out.println("Exception of Reports ="+e);}
		} 

	
	
	
	
	
	
	
	
	
//WE CAN ADD MULTIPLE COST AND REVENUE IN SINGLE BOOKING	
	
	public void verifyCostRevenue() throws Exception {
		
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
			
			Thread.sleep(1000);
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
			Thread.sleep(1000);
				try {
					iteamDesc.clear();	
				iteamDesc.sendKeys(celldata.getCell(3).getStringCellValue());      
				}catch(Exception a){
					System.out.println(a);
				}
		
//UOM TYPE
		Thread.sleep(1000);
		try {
			String oumType = celldata.getCell(4).getStringCellValue();
		Select se4 = new Select(UOMType);
		se4.selectByVisibleText(oumType);}
		catch(Exception r) {
			System.out.println("Exception of UOM Type ="+r);
		}
		
//UOM
		Thread.sleep(1000);
		try {
		Select se=new Select(UOM);
		se.selectByVisibleText(oum);}
		catch(Exception b) {
			System.out.println("Exception of UOM ="+b);
		}
		
//TARIFF ITEAM
		Thread.sleep(1000);
		try {
		Select se5 = new Select(tariffTerm);
		se5.selectByVisibleText(tariff);}
		catch(Exception c) {
			System.out.println("Exception of Tariff Iteam ="+c);
		}
		
//REVENUE CHECK BOX
		Thread.sleep(1000);
		if(revCheckBox.isSelected()) {
			System.out.println("Revenue check box status ="+revCheckBox.isSelected());
		}
		else {
			Actions action=new Actions(driver);
			action.moveToElement(revCheckBox).click().build().perform();
		//	revCheckBox.click();}
		}
	
		
//REVENUE PARTY TYPE
		Thread.sleep(1000);
		try {
		Select se1=new Select(partyTypeR);
		se1.selectByVisibleText(partyDrop);}
		catch(Exception d) {
			System.out.println("Exception of Revenue Prty Type ="+d);            
		}
		
//REVENUE PARTY
		Thread.sleep(1000);
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
		Thread.sleep(1000);
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
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		try {
		String currecy = celldata.getCell(11).getStringCellValue();	
		Select s6=new Select(currencyR);
		s6.selectByVisibleText(currecy);}
		catch(Exception q) {
			System.out.println("EXCEPTION OF REVENUE CURRENCY ="+q);
		}
		
//REMARKS
		Thread.sleep(1000);
		remarksR.clear();
		Thread.sleep(1000);
		remarksR.sendKeys(celldata.getCell(12).getStringCellValue());
		
		
//CLICK ON COST CHECK BOX	
		Thread.sleep(1000);
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
			Thread.sleep(1000);
		buyingRate.sendKeys(celldata.getCell(13).getStringCellValue());}}
		catch(Exception t) {
			System.out.println(t);}
		
//COST PARTY TYPE
		Thread.sleep(1000);
		try{
			String partyType1 = celldata.getCell(14).getStringCellValue();
		    Select se7=new Select(partyTypeC);
		    se7.selectByVisibleText(partyType1);}
		catch(Exception x) {
			System.out.println("EXCEPTION OF COST PARTY TYPE ="+x);
		}
		
//COST PARTY
		Thread.sleep(1000);
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
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		try {
		String currcyC = celldata.getCell(17).getStringCellValue();
		Select se8=new Select(currencyC);     
		se8.selectByVisibleText(currcyC);}
		catch(Exception s) {
			System.out.println("EXCEPTION OF COST CURRENCY ="+s);
		}
		
//REMARK
		Thread.sleep(1000);
		try {
			remarksC.sendKeys(celldata.getCell(18).getStringCellValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//CLICK ON SUBMIT BUTTON
		Thread.sleep(1000);
		submitBtn.click();
		
//CLOSE
		Thread.sleep(2000);
		try {
			closeBtn.click();}
		catch(InvalidSelectorException p) {System.out.println("EXCEPTION OF CLOSE BUTTON ="+p);}
		}
		}
		catch(NullPointerException e) {
			Thread.sleep(200);;
		}
	}	
}
	
	
	
//WE CAN ADD MULTIPLE CONTAINER LIST IN SINGLE BOOKING 	
	
	public void allContanerDetails() throws Exception {
		
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
			Thread.sleep(1000);
			String contNo = celldata.getCell(2).getStringCellValue();
			cntrNo.clear();
			try {
			cntrNo.sendKeys(contNo);}
			catch(java.lang.NullPointerException e) {
				System.out.println("Exception of CONTAINER NO ="+e);
			}
		
		
//CONTAINER TYPE
			Thread.sleep(1000);
			String contTy = celldata.getCell(3).getStringCellValue();
		//	cntrType.click();
			Select cntrType1 = new Select(cntrType);
			cntrType1.selectByVisibleText(contTy);
		
		
//CUSTOMS SEAL
			Thread.sleep(1000);
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
		//	quentity.sendKeys(Keys.ENTER);
			cargoWt.clear();
			Thread.sleep(800);
			double value = celldata.getCell(7).getNumericCellValue();
			System.out.println("actual value of cargo= "+value);
			JavascriptExecutor js2=(JavascriptExecutor)driver;
			js2.executeScript("arguments[0].value='"+ value +"'" , cargoWt);
			Thread.sleep(1000);
			cargoWt.sendKeys(Keys.ENTER);
			
			}
			catch(Exception e) {
				System.out.println("cargo value is wrong="+e);
			}
			
			
//VGM
			Thread.sleep(1000);
			try {
			VGMWt.sendKeys(Keys.ENTER);}
			catch(ElementNotInteractableException e) {
				System.out.println("Exception of VGM text ="+e);
			}
			
//NET WT
			Thread.sleep(1000);
			netWt.click();
		//	quentity.sendKeys(Keys.ENTER);
			netWt.clear();
			
			double value = celldata.getCell(9).getNumericCellValue();               
			System.out.println("Before pass value of Net Wait= "+value);
			
			JavascriptExecutor js2=(JavascriptExecutor)driver;
			js2.executeScript("arguments[0].value='"+ value +"'" , netWt);           
			System.out.println("After passing value of Net Wait= "+value);
			
		
//VOLUME
			Thread.sleep(1000);
			conVolume.click();
		//	quentity.sendKeys(Keys.ENTER);
			conVolume.clear();
			
			double value1 = celldata.getCell(10).getNumericCellValue();
			System.out.println("actual value of the cotainer volume= "+value1);
			
			JavascriptExecutor jb=(JavascriptExecutor)driver;
			jb.executeScript("arguments[0].value='"+ value1 +"'" , conVolume);
		//	conVolume.sendKeys(readExcelFile(40, 9));
			System.out.println("After value of no of Units= "+conVolume.getText());
		
//PAG TYPE
			Thread.sleep(1000);
			String pakgTy = celldata.getCell(11).getStringCellValue();
			pkgType.click();
			Select pkg = new Select(pkgType);
			pkg.selectByVisibleText(pakgTy);
			
//NO OF UNITS
			Thread.sleep(1000);
			noOfUnits.click();
			//	quentity.sendKeys(Keys.ENTER);
				noOfUnits.clear();
				
				double value11 = celldata.getCell(12).getNumericCellValue();
				System.out.println("Before value of no of Units= "+value11);
				
				JavascriptExecutor jc=(JavascriptExecutor)driver;
				jc.executeScript("arguments[0].value='"+ value11 +"'" , noOfUnits);
			//	noOfUnits.sendKeys(readExcelFile(40, 11));
				System.out.println("After value of no of Units= "+noOfUnits.getText());
				
//CNTR REMARKS
				Thread.sleep(800);
				remarks.sendKeys(celldata.getCell(13).getStringCellValue()); 
				
				
//ADD BUTTON
				Thread.sleep(1000);
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
	
	

	
	public void verifyJobIteam1() throws Exception
	{
		revAdCostBtn.click();
		WebElement jobitembox = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_rev_jobitem']"));
		jobitembox.click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Keys.ENTER);
	/*	String val = readExcelFile(10, 12);
	
		List<WebElement> allData = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
		System.out.println(allData.size());
	//	WebElement text = driver.findElement(By.name("ctl00$ContentPlaceHolder1$IFFBookBasic$txt_rev_jobitem"));
	//	text.sendKeys(" FRAIREIGHT");
	
		for(int i=0;i<=allData.size();i++)
		{
			System.out.println(allData.get(i).getText());
			String value = allData.get(i).getText();
			if(allData.get(i).getText().equalsIgnoreCase("Container Monitoring Charges"))
			{
				allData.get(i).click();
			//	driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();
				break;
			}
			
			System.out.print(" ");
		}	*/
		
		
		
		
		
	/*	jobitembox.click(); 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Keys.ENTER);
		List<WebElement> allData = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]//tr"));
		System.out.println("Size of all data ="+allData.size());
		  
		  for(WebElement option:allData) {
			  
		  if(option.getText().equalsIgnoreCase("Container Monitoring Charges")) {
			  
		  Thread.sleep(1000); 
		  option.click();
		  driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();
		  break; 
		  }}
		*/
		

		
//Proper Correct
	/*	revAdCostBtn.click();
		WebElement jobitembox = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$img_rev_jobitem']"));
		jobitembox.click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Keys.ENTER);
		
		String val = readExcelFile(10, 12);
		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]//tr"));
		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]//tr//td"));
		System.out.println("Total Size row in table= "+row.size());
		System.out.println("Total size of col in table= "+col.size());
		
		for(int i=0;i<col.size();i++)
		{
			String value = col.get(i).getText();
		//	System.out.println(value);
			if(col.get(i).getText().equalsIgnoreCase(val))
			{
				col.get(i).click();
				
			}
		}
			*/
	}
	}
	
	
	
	
	
	 
		
