package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_35 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify 'Twitter page link should exists under 'Website Overview' section")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void PresenceOfTwitter(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.presenceOfTwitter(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}