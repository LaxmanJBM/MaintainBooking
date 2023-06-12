package Invoices;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Browser;

public class IFFInvoice_2 extends Browser{
	
	@FindBy(xpath = "//img[@id='ctl00_btnNew']")
	private WebElement newBtn;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$img_book']")private WebElement jobNoD;
	@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement bookRefText;
	@FindBy(xpath="//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td")private List<WebElement> allRef;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlOffice']")private WebElement office;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtimpCode']")private WebElement inportCode;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtinvStat']")private WebElement status;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlparty_type']")private WebElement partyType;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$Imgrev_AccName']")private WebElement partyD;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtsalepr']")private WebElement salesPerson;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlcustOu']")private WebElement partyOU;
	@FindBy(xpath="ctl00$ContentPlaceHolder1$txtRegion")private WebElement partyGST;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ctl00']")private WebElement placeOfSupplyD;
	@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement regionNameText;
	@FindBy(xpath="//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td")private List<WebElement> regionName;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtservice']")private WebElement service;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtshipper']")private WebElement shiperName;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtconsig']")private WebElement consigneeName;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtcustref']")private WebElement customerRef;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$txtremarks']")private WebElement remarks;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnAddOptions']")private WebElement additionalOptions;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txt_OS_amt']")private WebElement osAmount;;
	@FindBy(xpath="/input[@name='ctl00$ContentPlaceHolder1$txtinvref1']")private WebElement invoiceRef;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtinvDt']")private WebElement invDate;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtdueDt']")private WebElement dueDate;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtFARef']")private WebElement FAVoucher;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtorigin']")private WebElement origin;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtdest']")private WebElement destination;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtroute']")private WebElement route;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddl_del_agst']")private WebElement deliveryAgaint;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlTaxType']")private WebElement taxType;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$lblOfficeGST']")private WebElement GSToffice;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_chk_gstbyPOS']")private WebElement POSCheckBox;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtcravailable']")private WebElement crAvailable;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtcrAvailed']")private WebElement crAvailed;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtcrdays']")private WebElement crDay;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$txtattndet']")private WebElement attnDetails;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtHouseDoc']")private WebElement houseDocRef;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlInvType']")private WebElement invoiceType;
	
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnAddNewEntry']")private WebElement addBtn;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txt_slno']")private WebElement slNo;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$Img_tariff']")private WebElement jobNameD;
	@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement nameText;
	@FindBy(xpath="//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td")private List<WebElement> allTariffName;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$txtg_dis']")private WebElement description;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlg_uom']")private WebElement uom;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtg_qty']")private WebElement qty;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtg_rate']")private WebElement rate;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlg_Cur']")private WebElement currency;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$txtg_rem']")private WebElement tariffRemarks;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnAdd1']")private WebElement addBtnT;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$Button9']")private WebElement closeBtn;
/*	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;	
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;
	@FindBy(xpath="")private WebElement;*/
	
	public IFFInvoice_2() {
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
	
	
	public void basicDetails() {
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
