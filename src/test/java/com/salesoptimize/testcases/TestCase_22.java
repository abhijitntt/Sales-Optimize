package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_22 extends BaseClass{
	
	  @Test(groups="ShippingCompanies", description="Verify Shipping Companies not contain 'An Post'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExcludeShippingCompanies(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.excludeShippingCompanies(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}