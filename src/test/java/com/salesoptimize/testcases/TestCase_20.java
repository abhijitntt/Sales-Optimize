package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.utility.BaseClass;

public class TestCase_20 extends BaseClass{
	
	  @Test(groups="ShippingCompanies", description="Verify if Any one of 'Shipping Companies' or 'Shipping Page Link' should exist")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void AllSitesShipping(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
			   evidence.AllSitesShipping(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				ReusableMethodsEvidence.reset();
				throw new RuntimeException(e);

			} 
				
}
}