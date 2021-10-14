package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class TestCase_11 extends BaseClass{
	
	  @Test(groups="ExportData", description="Verify All records in the downloaded file should have at least one 'Company Email' and 'Company Phone Number'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExportMustHaveEmailAddressPhoneNumber(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
				dashboard.MostHaveEmailPhoneNo(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				CommonMethod.switchToParentTab();
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}