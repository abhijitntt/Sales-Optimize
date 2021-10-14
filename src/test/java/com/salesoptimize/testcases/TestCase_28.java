package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.utility.BaseClass;

public class TestCase_28 extends BaseClass{
	
	@Test(groups="Technology", description="Verify Website Technology should not contain 'Magento'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExcludeWebsiteTechnology(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
					evidence.excludeWebsiteTechnology(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					ReusableMethodsEvidence.reset();
					throw new RuntimeException(e);

				} 
	}
}