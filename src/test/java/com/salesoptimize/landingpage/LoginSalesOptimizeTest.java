package com.salesoptimize.landingpage;

import org.testng.annotations.Test;

import com.salesoptimize.utility.BaseClass;



public class LoginSalesOptimizeTest extends BaseClass{
	
	  @Test(groups="Login", description="Verify if User was able to login successfully")
	  public static void LoginSalesOptimize() {
		  
		try { 
		
				login.login();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);

			} 
				
}
}