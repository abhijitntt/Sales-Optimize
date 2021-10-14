package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_2 extends BaseClass{
	
	  @Test(groups="ExportData", description="Verify User should be redirected to Salesforce on clicking the link and should be able to see the exported lead in Salesforce")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExportPurchasedLeadToSalesforce(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.ExportPurchasedLeadToSalesforce(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}