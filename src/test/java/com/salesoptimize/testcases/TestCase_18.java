package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.utility.BaseClass;

public class TestCase_18 extends BaseClass{
	
	  @Test(groups="Evidence", description="Verify Is 'Mobile Enabled should' be 'Yes")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void EvidenceofMobileSite(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
			evidence.evidenceofMobileSite(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				ReusableMethodsEvidence.reset();
				throw new RuntimeException(e);

			} 
				
}
}