package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_8 extends BaseClass{
	
	  @Test(groups="Retail", description="Verify if User is able to select Industry as Retail and Sub Industry as Fashion & Clothing")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void SelectIndustryAndSubIndustry(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.selectIndustryAndSubIndustry(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}