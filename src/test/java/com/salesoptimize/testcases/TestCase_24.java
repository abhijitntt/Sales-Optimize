package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_24 extends BaseClass{
	
	  @Test(groups="Alexa", description="Verify Alexa Traffic Information' shoud contain country Germany")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void VisitorTrafficRegionCountry(int rowNum,String dashboardSheet) {
		  
		try { 
			
				evidence.visitorTrafficRegionCountry(rowNum, dashboardSheet);
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}