package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_39 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify 'Marketing Analytics +' should not contain 'Doofinder'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void TwitterFollowers(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.ExcludeMarketingAnalytics(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}