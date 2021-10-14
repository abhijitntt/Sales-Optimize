package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_17 extends BaseClass{
	
	  @Test(groups="Evidence", description="Verify if Any of payment method or payment provider should exists")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void EvidenceOfOnlinePayments(int rowNum,String dashboardSheet) {
		  
		try { 
			
			evidence.evidenceOfOnlinePayments(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}