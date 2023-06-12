package MaintainBooking;



import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Browser;

public class Revenue extends Browser {
	
	
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_img_rev_jobitem']")private WebElement jobitembox;
	@FindBy(xpath = "//input[@placeholder='Name']")private WebElement job;
	@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_rev_desc']")private WebElement iteamDesc;
	@FindBy(xpath = "//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_uom_type_rev']")private WebElement uomT;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_uom']")private WebElement UOM;
	@FindBy(xpath = "//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_Rev_stat']")private WebElement tariffTerm;
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ChkRevenue']")private WebElement revCheckBox;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_Acc_Type']")private WebElement partyTypeR;
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imgrev_AccName']")private WebElement partyBtn;
	@FindBy(xpath = "//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement party1;
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_rate']")private WebElement revenuerate;
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_Discfcamt']")private WebElement discFCAmt;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_cur']")private WebElement currencyR;
	@FindBy(xpath = "//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_rem']")private WebElement remarksR;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$btnSubmit']")private WebElement submitBtn;
	@FindBy(xpath = "(//a[text()='Close'])[2]")private WebElement closeBtn;
	
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_Grossfcamt']")private WebElement grossText;
/*	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;
	@FindBy(xpath = "")private WebElement ;*/
	
	
	
	public Revenue() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void verifyCostRevenue() throws Exception {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("CostRevenue");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(3).getLastCellNum();
		System.out.println("rowcount:"+rowcount+"colcount"+colcount);
		
		WebDriverWait wait=new WebDriverWait(driver, 30);

		
		for(int i=3;i<=rowcount;i++)
		{
			Thread.sleep(1000);
			XSSFRow celldata= sheet.getRow(i);
			
		
			
			
			
//JOB ITEAM	
			
			Thread.sleep(2000);
	//		WebElement jobitembox = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_img_rev_jobitem']"));
			
			try { 
				String jobItm = celldata.getCell(2).getStringCellValue();
			jobitembox.click();
			WebElement job = driver.findElement(By.xpath("//input[@placeholder='Name']"));
			job.sendKeys(jobItm);
			job.sendKeys(Keys.ENTER);
			List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr"));
			List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td"));
			System.out.println("Total row Size in jobiteam table= "+row.size());
			System.out.println("Total size of col in jobiteam table= "+col.size());
			
			for(int a=0;a<col.size();a++)
			{
				if(col.get(a).getText().contains(jobItm))
				{
					col.get(a).click();
					Thread.sleep(1500);
					break;
				}
			}}
			catch(StaleElementReferenceException e)
			{
				Thread.sleep(1000);
				System.out.println("Exception of Job iteam ="+e);
			}
			
			
			
//ITEAM DESCRIPTION	
			Thread.sleep(2000);
		//	WebElement iteamDesc = driver.findElement(By.xpath("//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txt_rev_desc']"));
			try {
				iteamDesc.clear();
			iteamDesc.sendKeys(readExcelFile(16, 3));
			}catch(Exception a){
				System.out.println(a);
			}			
		
			
			
//UOM TYPE
			Thread.sleep(2000);
		//	WebElement uomT = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_uom_type_rev']"));
				try {
					String oumType = celldata.getCell(3).getStringCellValue();
				Select se4 = new Select(uomT);
				se4.selectByVisibleText(oumType);}
				catch(Exception r) {
					System.out.println("Exception of UOM Type ="+r);}
			
				
//UOM
			Thread.sleep(2000);
			//	WebElement UOM = driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_uom']"));
				try {
					String oum1 = celldata.getCell(4).getStringCellValue();
			//	wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(UOM));
				Thread.sleep(1000);
			     
				Select se=new Select(UOM);
				se.selectByVisibleText(oum1);}
				catch(Exception b) {
					System.out.println("Exception of UOM ="+b);}
				
//TARIFF ITEAM
				Thread.sleep(2000);
			//	WebElement tariffTerm = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ddl_Rev_stat']"));
				try {
					String tariff1 = celldata.getCell(5).getStringCellValue();
				Select se5 = new Select(tariffTerm);
				se5.selectByVisibleText(tariff1);}
				catch(Exception c) {
					System.out.println("Exception of Tariff Iteam ="+c);}
				
				
//REVENUE CHECK BOX	
				
				
			//	WebElement revCheckBox = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_ChkRevenue']"));
			//		Actions action=new Actions(driver);
			//		action.moveToElement(revCheckBox).click().build().perform();
					
					boolean click = revCheckBox.isSelected();
					System.out.println("REVENUE CHECK BOX STATUS ="+click);
				
					if(click==false) {
						revCheckBox.click();}
				
						
					
				
					
//REVENUE PARTY TYPE
				Thread.sleep(2000);
			//	WebElement partyTypeR = driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_Acc_Type']"));
					try {
						String partyDrop1 = celldata.getCell(6).getStringCellValue();
					//	wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(partyTypeR));
						
					Select se1=new Select(partyTypeR);
					se1.selectByVisibleText(partyDrop1);}
					catch(StaleElementReferenceException e) {
						Thread.sleep(2000);}
		
		
//REVENUE PARTY	
				Thread.sleep(2000);
			//		WebElement partyBtn = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Imgrev_AccName']"));
		try {
			String revenueParty=celldata.getCell(7).getStringCellValue();
				partyBtn.click();
				WebElement party1 = driver.findElement(By.xpath("//input[@id='amp_common_search_lookup_textbox_control__0']"));
				party1.sendKeys(Keys.ENTER);
				party1.sendKeys(revenueParty);
				party1.sendKeys(Keys.ENTER);	
				
				List<WebElement> row = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr"));
				List<WebElement> col = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/table/tbody//tr//td"));
				System.out.println("No of row in Revenue Party ="+row);
				System.out.println("Np of col in Revenue Party ="+col);
				for(int b=0;b<col.size();b++)
				{
					if(col.get(b).getText().contains(revenueParty))
					{
						col.get(b).click();
						Thread.sleep(1500);
						break;
					}}
				}
				catch(org.openqa.selenium.StaleElementReferenceException e)
				{
					System.out.println("Exception of Revenue Party ="+e);
				}
					
			
			
//REVENUE RATE
					Thread.sleep(2000);
	          //  	WebElement revenuerate = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_rate']"));
				try {
					double rateR = celldata.getCell(8).getNumericCellValue();
					System.out.println("status of text= "+revenuerate.isEnabled());
					FileInputStream filen=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");
					Sheet excelSheet = WorkbookFactory.create(filen).getSheet("CostRevenue");
				//	revenuerate.click();
				//	wait.until(ExpectedConditions.elementToBeClickable(revenuerate));
				//	Actions ac=new Actions(driver);
				//	ac.moveToElement(revenuerate).click().build().perform();
					
					revenuerate.clear();
					System.out.println("actual value of Revenue Rate= "+rateR);
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					Thread.sleep(800);
					js1.executeScript("arguments[0].value='"+ rateR +"'", revenuerate);
		            Thread.sleep(1000);
				//	driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Label18']")).sendKeys(Keys.ENTER);
					
					}
					catch(org.openqa.selenium.ElementNotInteractableException b) {
						 revenuerate = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_rate']"));
						 revenuerate.click();
						System.out.println("Exception of Revenue rate ="+b);
					}
				
//GROSS 	
				try {
		//		grossText.clear();
				Thread.sleep(1000);
				grossText.sendKeys(Keys.ENTER);}
				catch(Exception e) {Thread.sleep(1500);}
	            	
	          
							
//DISC FC AMT
	            	Thread.sleep(2000);
			//	WebElement discFCAmt = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_Discfcamt']"));
				try {
					double disfcAmt = celldata.getCell(9).getNumericCellValue();
				FileInputStream fileD=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");
				Sheet excelSheet = WorkbookFactory.create(fileD).getSheet("CostRevenue");
			//	discFCAmt.click();
				wait.until(ExpectedConditions.elementToBeClickable(discFCAmt));
				Actions ac=new Actions(driver);
				ac.moveToElement(discFCAmt).click().build().perform();
				discFCAmt.clear();
				Thread.sleep(1000);
				System.out.println("actual value= "+disfcAmt);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].value='"+ disfcAmt +"'", discFCAmt);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_Label20']")).sendKeys(Keys.ENTER);
				}
				catch(org.openqa.selenium.ElementNotInteractableException e) {
				//	 discFCAmt = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_IFFBookBasic_txtrev_Discfcamt']"));
				//	 discFCAmt.click();
					System.out.println("Exception of Disc amt ="+e);
				}
				
				
			
//CURRENCY
				Thread.sleep(2000);
			//	WebElement currencyR = driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$ddlrev_cur']"));
				try {
				Select s6=new Select(currencyR);
				s6.selectByVisibleText("AED");}
				catch(Exception q) {
					System.out.println("Exception of Currency ="+q);
				}
				
				
//REMARKS
				Thread.sleep(2000);
				try {
			//	WebElement remarksR = driver.findElement(By.xpath("//textarea[@name='ctl00$ContentPlaceHolder1$IFFBookBasic$txtrev_rem']"));
				remarksR.clear();
				Thread.sleep(1500);
				remarksR.sendKeys(readExcelFile(21, 10));}
				catch(Exception w) {System.out.println("Exception of Remark Text ="+w);}
							
//SUBMIT
				Thread.sleep(2000);
				try {
					submitBtn.click();}
				catch(Exception e) {
					System.out.println("Exception of submit button "+e);
				}

			
//CLOSE
				Thread.sleep(1500);
				
			//	WebElement closeBtn = driver.findElement(By.xpath("(//a[text()='Close'])[2]"));
				
				boolean close = closeBtn.isDisplayed();
				System.out.println("CLOSE BUTTON STATUS ="+close);
				
				if(close==true) {
				closeBtn.click();}
				
				
		



		}

}
}