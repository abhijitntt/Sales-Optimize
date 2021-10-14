package com.salesoptimize.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class TestCase_10 extends BaseClass{
	
	  @Test(groups="ContactDepartment", description="Verify The number of records must contain 'Contact Department' and 'Contact Level' as 'Leadership' and 'C-Level', respectively.")
	  @Parameters({"rowNum","dashboardSheet"})
	  public void ContactDepartment(int rowNum,String dashboardSheet) throws Exception {
		  
		try { 
			
				dashboard.contactDepartment(rowNum, dashboardSheet);
				

			} catch (Exception e) {
				CommonMethod.switchToParentTab();
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}