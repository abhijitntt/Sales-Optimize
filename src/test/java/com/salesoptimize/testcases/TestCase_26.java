package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.utility.BaseClass;

public class TestCase_26 extends BaseClass{
	
	@Test(groups="ShippingCompanies", description="Verify Shipping companies' value should contain 'International Delivery'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void EvidenceOfInternationalShipping(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
					evidence.evidenceOfInternationalShipping(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					ReusableMethodsEvidence.reset();
					throw new RuntimeException(e);

				} 
	}
}