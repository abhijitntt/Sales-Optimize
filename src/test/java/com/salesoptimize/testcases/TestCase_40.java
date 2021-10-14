package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;

public class TestCase_40 extends BaseClass{
	@Test(groups="TopLevelDomain", description="Verify Simple Url should end with '.com'")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void TopLevelDomain(int rowNum,String dashboardSheet){
		  
			try { 
				
				SocalMedia.topLevelDomain(rowNum, dashboardSheet);
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);

				} 
	}
}