package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_16 extends BaseClass{
	
	  @Test(groups="PaymentProvider", description="Finance Provider should not contain 'Santander' UK")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExcludeFinanceProvider(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.excludeFinanceProvider(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}