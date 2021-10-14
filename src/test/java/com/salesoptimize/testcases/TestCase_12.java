package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_12 extends BaseClass{
	
	  @Test(groups="PaymentProvider", description="Verify Payment Provider should not contain ' Adyen'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExcludePaymentProvider(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.excludePaymentProvider(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}