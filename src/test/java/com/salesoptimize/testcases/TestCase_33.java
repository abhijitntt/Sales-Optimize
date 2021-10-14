package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsSocalMedia;
import com.salesoptimize.utility.BaseClass;

public class TestCase_33 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify 'YouTube Subscribers' should be '>1M'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void YouTubeSubscribers(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
				ReusableMethodsSocalMedia.youTubeSubscribers(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}