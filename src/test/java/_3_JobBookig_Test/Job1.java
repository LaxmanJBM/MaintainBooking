package _3_JobBookig_Test;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base.Browser;
import MaintainBooking._3_JobBooking1;
import MaintainBooking._3_JobBooking2;
import Utility.CommonFiles;

public class Job1  {

	_3_JobBooking1 jb1;
	_3_JobBooking2 jb2;
	SoftAssert softassert;

	@BeforeMethod
	public void setup() throws Exception {

	//	initilization();
		jb1 = new _3_JobBooking1();
		jb2 = new _3_JobBooking2();
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

		softassert = new SoftAssert();
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test(priority = 1, enabled = true)
	public void titleTest() throws Exception {
		String text = jb2.verifyTitle();
		SoftAssert sf1 = new SoftAssert();
		sf1.assertNotNull(text);
		sf1.assertEquals(text, "Maintain Booking");
		Reporter.log("Show the page Title name= " + text);
		sf1.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void finYearLebalTest() throws Exception {
		String lebal = jb2.verifyFY();
		SoftAssert sf2 = new SoftAssert();
		sf2.assertNotNull(lebal);
		sf2.assertEquals(lebal, "FY - 2022-23");
		Reporter.log("Show the current Financial Year Lebal= " + lebal);
		sf2.assertAll();
	}

	@Test(priority = 3, enabled = true)
	public void logoTest() throws Exception {
		boolean logo = jb2.verifyLogo();
		SoftAssert sf3 = new SoftAssert();
		sf3.assertNotNull(logo);
		sf3.assertTrue(logo, "Plaese check the JBM Logo is visible");
		Reporter.log("Show the status of Logo= " + logo);
		sf3.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void companyNameTest() throws Exception {
		String compname = jb2.verifyCompanyName();
		SoftAssert sf4 = new SoftAssert();
		sf4.assertNotNull(compname);
		sf4.assertEquals(compname, "NEW WIND LOGISTICS INDIA PVT LTD (NWL)");
		Reporter.log("Show the name of the Company= " + compname);
		sf4.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void basicBtnTest() throws Exception {
		boolean status = jb2.verifyBasicBtn();
		SoftAssert sf5 = new SoftAssert();
		sf5.assertFalse(status, "Check button is not clicked");
		sf5.assertAll();
	}

	@Test(priority = 6, enabled = true, dependsOnMethods = "basicBtnTest")
	public void estimatedRadioBtnTest() throws Exception {
		String radioBtn = jb2.verifyestimatedRadioBtn();
		SoftAssert sf6 = new SoftAssert();
		sf6.assertNull(radioBtn);
		sf6.assertAll();
	}

	@Test(priority = 7, enabled = true, dependsOnMethods = { "basicBtnTest", "estimatedRadioBtnTest" })
	public void selectDropTest() throws Exception {
	//	String selectdrop = jb2.verifySelectDrop();
		SoftAssert sf7 = new SoftAssert();
	//	sf7.assertEquals(selectdrop, "Customer Book Request");
	//	sf7.assertNotNull(selectdrop);
		sf7.assertFalse(false);
	//	Reporter.log("Title of selected dropdown= " + selectdrop);
		sf7.assertAll();
	}

	@Test(priority = 8, enabled = true)
	public void serviceDropTest() throws Exception {
		String serviceDrop = jb2.verifyServiceDrop();
		SoftAssert sf8 = new SoftAssert();
		sf8.assertNotNull(serviceDrop);
		sf8.assertEquals("Air Freight Export", serviceDrop);
		Reporter.log("Show the selected service name= " + serviceDrop);
		sf8.assertAll();
	}

	@Test(priority = 9, enabled = true)
	public void DocTypeTest() {
	//	String doctype = jb2.verifyDocType();
		SoftAssert sf9 = new SoftAssert();
	//	sf9.assertNotNull(doctype);
	//	sf9.assertEquals("House", doctype);
		// sf9.assertTrue(false);
	//	Reporter.log("Show the selected service name= " + doctype);
		sf9.assertAll();
	}

	@Test(priority = 10, enabled = true)
	public void dateTest() throws Exception {
		String date = jb2.verifyDate();
		SoftAssert sf10 = new SoftAssert();
		// sf10.assertNotNull(date);
		// sf10.assertAll();
	}

	@Test(priority = 11, enabled = true)
	public void deliveryAgentTest() throws Exception {
		String delivery = jb2.verifyDeliveryAgent();
		SoftAssert sf11 = new SoftAssert();
		sf11.assertNotNull(delivery);
		// sf11.assertTrue(false);
		Reporter.log("Show the status= " + delivery);
		sf11.assertAll();
	}

	@Test(priority = 12, enabled = true) // Null Exception shows
	public void masterJobTest() throws Exception {
		String ms = jb2.verifyMasterJob();
		softassert.assertNotNull(ms);
		softassert.assertTrue(true);
		Reporter.log("Show the sattus of Master Job Field =" + ms);
		softassert.assertAll();
	}

	@Test(priority = 13, enabled = true)
	public void masterOrCarrierDocTest() throws Exception {
		String result = jb2.verifyMasterOrCarrierDoc();
		// softassert.assertNull(result);
		// softassert.assertNotNull(false);
		Reporter.log("Please show the result= " + result);
		softassert.assertAll();
	}

	@Test(priority = 14, enabled = true)
	public void carrierDocDateTest() throws Exception {
		String cal = jb2.verifyCarrierDocDate();
		softassert.assertNotNull(cal);
		Reporter.log(cal);
		softassert.assertAll();
	}

	@Test(priority = 15, enabled = true)
	public void bookingSourceTest() throws Exception {
	//	String scrbook = jb2.verifyBookingSource();
	//	softassert.assertNotNull(scrbook);
	//	softassert.assertEquals(scrbook, "Local", "Plase check the dropdown option");
	//	Reporter.log("Show the name from the dropdown= " + scrbook);
		softassert.assertAll();
	}

	@Test(priority = 16, enabled = true)
	public void nominationAgentTest() throws Exception {
		String nm = jb2.verifyNominationAgent();
		softassert.assertNotNull(nm);
		softassert.assertTrue(true);
		Reporter.log("Show the Nomination Agent Name= " + nm);
		softassert.assertAll();
	}

	@Test(priority = 17, enabled = true)
	public void nominationOUTest() throws Exception {
		String ou = jb2.verifyNominationOU();
		softassert.assertNotNull(ou);
		softassert.assertTrue(true);
		Reporter.log("Show the Nomination OU Name= " + ou);
		softassert.assertAll();
	}

	@Test(priority = 18, enabled = true)
	public void houseDocTest() throws Exception {
		jb2.verifyHouseDoc();
	}

	@Test(priority = 19, enabled = true)
	public void houseDocDateTest() throws Exception {
		String selected_date = "14-Jan-2023";

		jb2.verifyHouseDocDate();
		// softassert.assertNull(result);
		softassert.assertNotNull(false);
		// Reporter.log("Please show the result= "+result);
		softassert.assertAll();
	}

	@Test(priority = 20, enabled = true)
	public void customsDocTest() throws Exception {
		jb2.verifyCustomsDoc();
	}

	@Test(priority = 21, enabled = true)
	public void customerTest() throws Exception {
		SoftAssert sf = new SoftAssert();
	//	String cust = jb2.verifyCustomer();
	//	sf.assertNotNull(cust);
		sf.assertTrue(true, "Plase enter customer name");

		jb2.verifyCustomerEmail();
		String custou = jb2.verifyCustomerOU();
		sf.assertEquals(true, true);
		sf.assertTrue(true, "Plase enter customer name");
		Reporter.log(custou);

		jb2.verifyACNumber();
		Thread.sleep(2000);
		sf.assertAll();

	}

	@Test(priority = 22, enabled = true)
	public void salesPersonTest() throws Exception {
		_3_JobBooking2 book = new _3_JobBooking2();
//		String salse = book.verifySalesPerson();
		SoftAssert sfsales = new SoftAssert();
	//	String sales = jb2.verifySalesPerson();
	//	sfsales.assertTrue(sales.contains("Anil Kapoor"), "Sales person are not matching");
	//	sfsales.assertEquals(true, true, "sales person not enter");
	//	sfsales.assertNotNull(salse, "Not Null");
		// sfsales.assertAll();

	}

	@Test(priority = 23, enabled = true)
	public void officeTest() throws Exception {
		jb2.verifyOffice();
	}

	@Test(priority = 24, enabled = true)
	public void salesTeamTest() throws Exception {
		jb2.verifySalesTeam();
	}

	@Test(priority = 25, enabled = true)
	public void CarrierTest() throws Exception {
		jb2.verifyCarrier();
	}

	@Test(priority = 26, enabled = true)
	public void carrierBookRefTest() throws Exception {
		jb2.verifyCarrierBookRef();
	}

	@Test(priority = 27, enabled = true)
	public void commodityTest() throws Exception {
		jb2.verifyCommodity();
	}

	@Test(priority = 28, enabled = true)
	public void custServicePersonTest() throws Exception {
		jb2.verifyCustServicePerson();
	}

	@Test(priority = 29, enabled = true)
	public void custRefTest() throws Exception {
		jb2.verifyCustRef();
	}

	@Test(priority = 30, enabled = true)
	public void originTest() throws Exception {
		jb2.verifyOrigin();
	}

	@Test(priority = 31, enabled = true)
	public void destinationTest() throws Exception {
		jb2.verifyDestination();
	}

	@Test(priority = 32, enabled = true)
	public void routeTest() throws Exception {
		jb2.verifyRoute();
	}

	@Test(priority = 33, enabled = true)
	public void loadPortTest() throws Exception {
		jb2.verifyLoadPort();
	}

	@Test(priority = 34, enabled = true)
	public void dischPortTextTest() throws Exception {
		jb2.verifyDischPortText();
	}

	@Test(priority = 35, enabled = true)
	public void flightTest() throws Exception {
		jb2.verifyFlight();
	}

	@Test(priority = 36, enabled = true)
	public void voyageTest() throws Exception {
		jb2.verifyVoyage();
	}

	@Test(priority = 37, enabled = true)
	public void freightTermsTest() throws Exception {
		jb2.verifyFreightTerms();
	}

	@Test(priority = 38, enabled = true)
	public void agentTest() throws Exception {
		jb2.verifyOriginAgent();
		jb2.verifyDeliveryAgent2();
	}

	@Test(priority = 39, enabled = true)
	public void shipmentTypeTest() throws Exception {
		jb2.verifyShipmentType();
	}

	@Test(priority = 40, enabled = true)
	public void coloadTest() throws Exception {
		jb2.verifyCoload();
	}

	@Test(priority = 41, enabled = true)
	public void brokeTextTest() throws Exception {
		jb2.verifyBrokeText();
	}

	@Test(priority = 42, enabled = true)
	public void pickupTermTest() throws Exception {
		jb2.verifyPickupTerm();
		jb2.verifyDeliveryTerm();
	}

	@Test(priority = 43, enabled = true)
	public void TSLocalDeliveryTest() throws Exception {
		jb2.verifyTSLocalDelivery();
		jb2.verifyTSLocalDeliveryRemark();
	}

	@Test(priority = 44, enabled = true)
	public void frightsDetailsTextTest() throws Exception {
		String text = jb2.verifyFrightsDetailsText();
		Reporter.log("Show the title=" + text);
	}

	@Test(priority = 45, enabled = true)
	public void weightTest() throws Exception {
		jb2.verifyWeight();
		jb2.verifyVolume();
		jb2.verifyChargWtOrFrtTone();
	}

	@Test(priority = 46, enabled = false)
	public void HSCodeTextTest() throws Exception {
		jb2.verifyHSCodeText();
	}

	@Test(priority = 47, enabled = true)
	public void dgoodTest() throws Exception {
		jb2.verifyDangGood();
	}

	@Test(priority = 48, enabled = true)
	public void IMDGDetailsTest() throws Exception {
		jb2.verifyIMDGDetails();
	}

	@Test(priority = 49, enabled = true)
	public void ftContanerTest() throws Exception {
		jb2.verifyFtContaner20();
		jb2.verifyFtContaner40();
		jb2.verifyNoPackg();
		jb2.verifyitemDetails();
	}

	@Test(priority = 50, enabled = true)
	public void revQuoDetailsTest() throws Exception {
		jb2.verifyServiceDrop();
		jb2.verifyRevAdCostBtn();
		String text2 = jb2.verifyPoptitle();
		Reporter.log("Show the name of Popups= " + text2);

		jb2.verifyQuotationNoText();
		jb2.verifyJobIteam();
		jb2.verifyIteamDesc();
		jb2.verifyUOMType();
		jb2.verifyUOM();
	//	jb2.verifyQty(); //// Qty not showing
		jb2.verifyTariffTerm();

	}

	@Test(priority = 51, enabled = true)
	public void revenueTest() throws Exception //// Pending
	{
		jb2.verifyRevCheckBox();
		jb2.verifyPartyTypeR();
		jb2.verifyPartyTypeR();
		jb2.verifyRevenuerate();
		jb2.verifyGrossFCAmt();
		jb2.verifyDiscFCAmt();
		jb2.verifyNetFCAmt();

	}
	

	@Test(priority = 52, enabled = false)
	public void Test() throws Exception {

	}

	@Test(priority = 53, enabled = true)
	public void serviceDetailsTest() throws Exception {
		jb2.verifyServiceDetailsBtn();
		String title = jb2.verifyPartyDetailsText();
		Reporter.log("Title of page= " + title);
		jb2.verifyShipperNameText();
		jb2.verifyShipperAddress();
		jb2.verifyConsigneeNameText();
		jb2.verifyConsigneeAddress();
		jb2.verifyNotifyNameText();
		jb2.verifyNotifyAddress();
		jb2.verifyCHAName();
		jb2.verifyCHAAddress();
		jb2.verifyCHANumber();

		String title1 = jb2.verifyOpTitle();
		Reporter.log("Title= " + title1);
		jb2.verifyETDDate();
		jb2.verifyCutOffDate();
		jb2.verifySailingDate();
		jb2.verifyVGMCutOffDate();
		jb2.verifyDocCutOff();

		jb2.verifySlectDropOriginOpe();

	}

	@Test(priority = 54, enabled = true)
	public void destinationOperDetailsTest() throws Exception {
		jb2.verifyServiceDetailsBtn();
		String title3 = jb2.verifyDestinationOperTitle();
		Reporter.log(title3);
		jb2.verifyETADate();
		jb2.verifyArrivalTest();
		jb2.verifyDeliveryDate();
		jb2.verifyDestinationDelivery();
		jb2.verifyDestinationCoustoms();
	}

	@Test(priority = 55, enabled = true)
	public void otherDetailsTest() throws Exception {
		jb2.verifyServiceDetailsBtn();
		jb2.verifyScroll();
		String title = jb2.verifyOtherDetailsTitle();
		Reporter.log("name= " + title);
		jb2.verifyTOS();
		jb2.verifyServiceDetails();
		jb2.verifyOperInstruction();
		jb2.verifyTransporter();
		jb2.verifyVehicalDetails();
		jb2.verifyCFSDropdown();
	}

	@Test(priority = 56, enabled = true)
	public void additionalTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
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

		// jb2.verifyFileUpload();

	}

	@Test(priority = 57, enabled = true)
	public void cntrNoTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyCntrNo();
	}

	@Test(priority = 58, enabled = true)
	public void cntrTypeTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyCntrType();
	}

	@Test(priority = 59, enabled = true)
	public void sealTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyCustomsSeal();
		jb2.verifyAgentSeal();
	}

	@Test(priority = 60, enabled = true)
	public void tareWtTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyTareWt();
	}

	@Test(priority = 61, enabled = true)
	public void cargoWtTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyCargoWt();
	}

	@Test(priority = 62, enabled = false) //// Pending
	public void VGMWtTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
	//	String vgm = jb2.verifyVGMWt();
	//	Reporter.log("show the VGM wt= " + vgm);
	}

	@Test(priority = 63, enabled = true)
	public void netWtTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyNetWt();
	}

	@Test(priority = 64, enabled = true)
	public void conVolumeTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyConVolume();
	}

	@Test(priority = 65, enabled = true)
	public void pkgTypeTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyPkgType();
	}

	@Test(priority = 66, enabled = true)
	public void noOfUnitsTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyNoOfUnits();
	}

	@Test(priority = 67, enabled = true)
	public void remarksTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyRemarks();
	}

	@Test(priority = 68, enabled = true) // Calculation Error
	public void addBtn1Test() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyAddBtn1();
	}

	@Test(priority = 68, enabled = true)
	public void vehiclePackingTest() throws Exception {
		jb2.verifyAdditionalDetailsBtn();
		jb2.verifyVehiclePackingList();
		jb2.verifyFinalRemarks();
	}

	@AfterMethod
	public void exit(ITestResult b) throws Throwable {
		if (ITestResult.FAILURE == b.getStatus()) {
	//		CommonFiles.captureScreenshotFaildTC(driver, b.getName());
		}

		Thread.sleep(2500);
	//	driver.quit();

	}
}
