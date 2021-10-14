package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsSocalMedia;
import com.salesoptimize.utility.BaseClass;

public class TestCase_32 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify YouTube Views' should be '>1M'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void YouTubeViews(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
				ReusableMethodsSocalMedia.youTubeViews(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}