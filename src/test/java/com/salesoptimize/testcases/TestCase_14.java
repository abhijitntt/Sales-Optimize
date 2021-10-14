package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_14 extends BaseClass{
	
	  @Test(groups="PaymentMethod", description="Verify Payment Method does not contain 'Visa Debit'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExcludePaymentMethod(int rowNum,String dashboardSheet) {
		  
		try { 
			
			
				dashboard.encludePaymentMethod(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}