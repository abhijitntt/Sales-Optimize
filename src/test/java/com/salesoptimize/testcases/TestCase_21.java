package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_21 extends BaseClass{
	
	  @Test(groups="ShippingCompanies", description="Verify Shipping Companies should contain 'An Post'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void IncludeShippingCompanies(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.includeShippingCompanies(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}