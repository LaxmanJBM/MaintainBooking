package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonFiles {
	
public static WebDriver driver;
	
	public static String readExcelFile(int row,int col) throws Exception
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
	 	return value;
	}
	
	
	
	public static void captureScreenshotFaildTC(WebDriver driver, String nameOfMethod) throws Throwable
	{
		Date d=new Date();
		String date = d.toString().replace(" ", "-").replace(":", "-");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Failed_Screenshot\\ "+ nameOfMethod +","+date+".png");
		FileHandler.copy(source, destination);
	}
	
	
	
	public static String readExcelFileFinal(int row,int col) throws Exception
	{
		FileInputStream fileF=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx");
		Sheet excelSheet = WorkbookFactory.create(fileF).getSheet("basicDetail");
		String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
	 	return value;
	}
	
	
	
	
/*	public static double readNumericExcelFile(int row,int col) throws Exception
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\IFF TEST DATA.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("IFF");
		double value = excelSheet.getRow(row).getCell(col).getNumericCellValue();
	 	return value;
	}
	
	
//Trial 
	
	
	public static String readExcelFile1(int row,int col) throws Exception
	{
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\IFF_Project\\\\Test_Data\\\\sample_Test.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("CostRevenue");
		String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
	 	return value;
	}
	
	public static String readExcelFileMul(int row,int col) throws Exception
	{
		
	 	 String filePath="C:\\Users\\Admin\\eclipse-workspace\\IFF_Project\\Test_Data\\sample_Test.xlsx";// file path
	     FileInputStream file=new FileInputStream(filePath);
	     Workbook wb=WorkbookFactory.create(file);
	     Sheet sh=wb.getSheet("BasicDetails"+"CostRevenue");
	//     ArrayList<String> ls=new ArrayList<String>();
	     for(int k=0; k<=2;k++)//k =sheet no
	     {
	         
	         System.out.println("1st Sheet Number ="+sh);
//	       int count=0;
	         for(int row1=0;row1<=sh.getLastRowNum();row1++)
	         {
	             System.out.println("row no:"+row1);
	             for(int col1=0; col1<=15;col1++)//j=column no
	             {
	                 try {
	                  String value11=sh.getRow(row).getCell(col).getStringCellValue();
	                  System.out.print(value11 +"       ");
	         //         return value11;
	
	                  }catch(Exception e){
	                	 
	                  }}
	             System.out.println("");}
	     }
	     return null;
		}
	
	 //condetions

    /* if(values.contains("condtn1"))
        {
            System.out.println("Value of cell "+values+" ith row "+(i+1));
            ls.add(values);
            count++;
        }   
     if(values.contains("condn2"))
        {
            System.out.println("Value of cell "+values+" ith row "+(i+1));
            ls.add(values);
            count++;
        }*/ 
}
