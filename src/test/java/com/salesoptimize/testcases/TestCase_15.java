package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_15 extends BaseClass{
	
	  @Test(groups="PaymentProvider", description="Verify Finance Provider should contain 'Santander UK'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void IncludeFinanceProvider(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.includeFinanceProvider(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}