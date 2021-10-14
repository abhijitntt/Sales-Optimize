package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.utility.BaseClass;

public class TestCase_25 extends BaseClass{
	
	  @Test(groups="Domains", description="Verify Has International Domains value should be 'Yes'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void EvidenceofInternationalPresence(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
					evidence.evidenceofInternationalPresence(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					ReusableMethodsEvidence.reset();
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
				
}
}