package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_34 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify Facebook page link should exists under 'Website Overview' section")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void PresenceOfFacebook(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.PresenceOfFacebook(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}