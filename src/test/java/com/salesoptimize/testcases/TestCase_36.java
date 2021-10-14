package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_36 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify 'Instagram page link should exists under 'Website Overview' section'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void PresencOfInstagram(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.presencOfInstagram(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}