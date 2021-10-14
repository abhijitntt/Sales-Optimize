package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.reusablemethods.ReusableMethodsSocalMedia;
import com.salesoptimize.utility.BaseClass;

public class TestCase_29 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify Facebook Likes' should be '>1M'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ExcludeWebsiteTechnology(int rowNum,String dashboardSheet) throws Exception {
		  
			try { 
				
				ReusableMethodsSocalMedia.FacebookLikes(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					ReusableMethodsEvidence.reset();
					throw new RuntimeException(e);

				} 
	}
}