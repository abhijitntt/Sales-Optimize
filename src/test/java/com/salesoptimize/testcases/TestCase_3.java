package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_3 extends BaseClass{
	
	  @Test(groups="GlobalRegion", description="Verify if User is able to Select Global Region + Business Country + City + Zip Code + Timezone")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void SelectGlobalRegion(int rowNum,String dashboardSheet) {
		  
		try { 
			
				dashboard.selectBusinessCountry(rowNum, dashboardSheet);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}