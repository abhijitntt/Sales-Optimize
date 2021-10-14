package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class TestCase_7 extends BaseClass{
	
	  @Test(groups="PaymentProvider", description="Verify Payment provider should contain Adyen or Apple Pay or Both (i.e. Ayden, Apple Pay)")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void Multiurllookup(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
				dashboard.multiurllookup(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				CommonMethod.switchToParentTab();
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}