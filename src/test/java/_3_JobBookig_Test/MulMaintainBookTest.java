package _3_JobBookig_Test;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Browser;
import MaintainBooking.MulMaintainBook;
import MaintainBooking._3_FinalBooking;
import MaintainBooking._3_JobBooking1;

public class MulMaintainBookTest extends Browser{
	
	
	_3_JobBooking1 jb1;
	_3_FinalBooking jb2;
	
	MulMaintainBook MB;
	

	@BeforeMethod
	public void setup() throws Exception {

		initilization();
		jb1 = new _3_JobBooking1();
		jb2 = new _3_FinalBooking();
		
		MB=new MulMaintainBook();
		jb1.verifyLoginApp();
		Thread.sleep(2000);

		jb1.verifyIFFBtn();
		Thread.sleep(2000);
		jb1.verifySalesBtn();
		Thread.sleep(2000);
		jb1.verifyBookingBtn();
		Thread.sleep(2000);
		jb2.verifyNewBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}


	
	@Test( enabled =true)
	public void data() throws Exception {
		 FileInputStream file1=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");	
			
			
			XSSFWorkbook workbook=new XSSFWorkbook(file1);
			XSSFSheet sheet = workbook.getSheet("basicDetail");
			int rowcount = sheet.getLastRowNum();
			int row= rowcount - 6;
			int colcount = sheet.getRow(7).getLastCellNum();
			System.out.println("rowcount in test:"+row+" colcount in test:"+colcount);
	
		System.out.println("ROW COUNT IN FINAL TEST ="+row);	
		
		for(int exec=1;exec<=row;exec++) {
			Thread.sleep(2000);
		
		MB.verifyBasicDetails(exec);
		
		MB.verifyServiceDetails(exec);
		
		MB.verifyAdditionalDetails(exec);
		
		MB.allContanerDetails(exec);
		
		MB.allVehiPackingList(exec);
		
		MB.verifyCostRevenue(exec);
		
		MB.saveBtn();
	
	}
	
	}
	

	@AfterMethod
	
	public void exit()
	{
	//	driver.quit();
	}
	
	

}
