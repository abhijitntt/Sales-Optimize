package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_13 extends BaseClass{
	
	  @Test(groups="PaymentMethod", description="Verify Payment Method should contain 'Visa Debit'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void IncludePaymentMethod(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.includePaymentMethod(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}