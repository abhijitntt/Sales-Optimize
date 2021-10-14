package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_30 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify 'Twitter Followers' should be '>1M''")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void TwitterFollowers(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.twitterFollowers(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}