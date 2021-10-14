package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_23 extends BaseClass{
	
	  @Test(groups="ShippingCompanies", description="Verify Shipping companies should contains 'Free Shipping', 'Same/Next Day Shipping', 'Returns")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void EvidenceofFreeShipping(int rowNum,String dashboardSheet) {
		  
		try { 
			
				evidence.evidenceofFreeShipping(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}