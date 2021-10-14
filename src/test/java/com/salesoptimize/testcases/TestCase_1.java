package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_1 extends BaseClass{
	
	  @Test(groups="ExportData", description="Verify The number of records in Excel and CSV format should match with the number of lines in the Bulk Download Screen")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExportAList(int rowNum,String dashboardSheet) {
		  
		try { 
			
			
				dashboard.exportAlist(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}