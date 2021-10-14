package com.salesoptimize.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;

public class ReadDataUtility {
	public static  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row   =null;
	public static XSSFCell cell = null;
	public static String sActionKeyword=null;
	public static int value=10;
	public static int getRowCount(String csvread) throws IOException 
	   {
		CSVReader reader = new CSVReader(new FileReader(csvread));
	     String [] nextLine;
	      int lineNumber = 0;
	      while ((nextLine = reader.readNext()) != null) {
	        lineNumber++;
	     
	     
	        System.out.println(nextLine[0]);
	        
	      }
	      return lineNumber-1;
	   }
	public static String getRowData(String csvread) throws IOException 
	   {
		CSVReader reader = new CSVReader(new FileReader(csvread));
	     String [] nextLine;
	     String data=null;
	      while ((nextLine = reader.readNext()) != null) {
	       
	    	data = nextLine[0];
	        System.out.println(nextLine[0]);
	        
	      }
	     
		return data;
	   }
	
	
	public static void VerifyNotNullCSV(String csvread,int rowIndex) throws Exception 
	   {
		CSVReader reader = new CSVReader(new FileReader(csvread));
	     String [] nextLine;
	     int lineNumber = 0;
	      while ((nextLine = reader.readNext()) != null) {
	    	  lineNumber++;
	    	String data = nextLine[rowIndex];
	    	
	        System.out.println(nextLine[rowIndex]);
	        

			if(data!=null) {
			  CommonMethod.assertTrue("Verified downloaded file have records : "+data);
			}		
			else {
				  CommonMethod.assertFalse("Verified downloaded file have no records : "+data);
			      
			}
			 if(lineNumber==value) {
		        	break;
		        }
	      }
	     

	        
	      }
	     
	
	
	
	public static void VerifyCSVRow(String csvread,int rowIndex,String text) throws Exception 
	   {
		CSVReader reader = new CSVReader(new FileReader(csvread));
	     String [] nextLine;
	     
	       
	      int lineNumber = 0;
	      while ((nextLine = reader.readNext()) != null) {
	        lineNumber++;
	        
	        String data = nextLine[rowIndex] ;
	        System.out.println(data);
	        if(lineNumber>1) {
				if(data.contains(text)) {
				  CommonMethod.assertTrue("Verified downloaded csv file have records : "+data);
				}		
				else {
					  CommonMethod.assertFalse("Verified downloaded file have no records : "+data);
				      
				}
		      }
	        
	        
	        if(lineNumber==value) {
	        	break;
	        }

	        
		      
	      
	       
	      }
	        
	      }
		
	public static void VerifyComCSV(String csvread,int rowIndex) throws Exception 
	   {
		
		CSVReader reader = new CSVReader(new FileReader(csvread));
	     String [] nextLine;
	     int lineNumber = 0;
	      while ((nextLine = reader.readNext()) != null) {
	          lineNumber++;
	    	String data = nextLine[rowIndex];
	    	
	        System.out.println(nextLine[rowIndex]);
	        
            if(lineNumber>1) {
			if(data.contains(".com")) {
			  CommonMethod.assertTrue("Verified records of the downloaded CSV file contain Url end with .com  : "+data);
			}		
			else {
				  CommonMethod.assertFalse("Verified records of the downloaded CSV file does not contain Url end with .com : : "+data);
	      
			}
			if(lineNumber==value) {
	        	break;
	        }
	      }
	      
	      }
	      }
	     
	   
	
	public static int getRowCountExcel(String path) throws IOException
	
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		int number=sheet.getLastRowNum();
		return number;
		}
		
	
	
	public static String getCellData(String path,String colName,int rowNum) throws IOException
	{
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		try
		{
			if(rowNum <=0)
				return "";
		
	    int index = workbook.getActiveSheetIndex();
		int col_Num=-1;
		if(index==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "";
		//System.out.println(cell.getCellType());
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  return cell.getStringCellValue();
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA )
		{
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell))
			  {
		           // format in form of M/D/YY
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		          cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		          cellText = cal.get(Calendar.MONTH)+1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
		           //System.out.println(cellText);
		         }
	  
		return cellText;
		  }
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		      return ""; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
}