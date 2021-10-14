package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_31 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify Instagram Followers' should be '>1M'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void InstagramFollowers(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
				SocalMedia.instagramFollowers(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}