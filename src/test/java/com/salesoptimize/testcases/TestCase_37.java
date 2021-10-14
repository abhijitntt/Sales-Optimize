package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_37 extends BaseClass{
	
	@Test(groups="SocialMedia", description="Verify Any of 'Youtube Views' or 'Youtube Subscribers' should exists")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void PresenceofYoutube(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.presenceofYoutube(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}