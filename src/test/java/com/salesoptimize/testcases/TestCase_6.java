package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class TestCase_6 extends BaseClass{
	
	  @Test(groups="SalesforceCRMExport", description="Verify User gets redirected to SalesOptimize crm export setup page")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void AddSalesforceCRMExport(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
				dashboard.addSalesforceCRMExport(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				CommonMethod.switchToParentTab();
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}