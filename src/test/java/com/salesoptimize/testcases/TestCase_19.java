package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.utility.BaseClass;

public class TestCase_19 extends BaseClass{
	
	  @Test(groups="Evidence", description="Verify if Has Multiple Currencies' should be 'Yes'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void EvidenceOfMultipleCurrencies(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
			evidence.evidenceOfMultipleCurrencies(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				ReusableMethodsEvidence.reset();
				throw new RuntimeException(e);
				

			} 
				
}
}