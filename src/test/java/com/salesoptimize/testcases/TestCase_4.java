package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_4 extends BaseClass{
	
	  @Test(groups="TurnOver", description="Verify if User is able to select Company Turnover as 1M and above")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void selectEstimatedOnlineSales(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.selectEstimatedOnlineSales(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}