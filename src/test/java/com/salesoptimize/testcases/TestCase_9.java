package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class TestCase_9 extends BaseClass{
	
	  @Test(groups="Location", description="Verify physical location should exists")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void HasPhysicalLocation(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
				dashboard.hasPhysicalLoacation(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				CommonMethod.switchToParentTab();
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}