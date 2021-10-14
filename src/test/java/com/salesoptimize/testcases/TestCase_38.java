package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_38 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify 'Marketing Analytics +' should contain 'Doofinder'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void IncludeMarketingAnalytics(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.includeMarketingAnalytics(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}