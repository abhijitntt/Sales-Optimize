package com.salesoptimize.reusablemethods;

import org.testng.Assert;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {

public void login() throws Exception {
	    CommonMethod.testlog("Pass", "User navigate to this URL"+CommonMethod.baseURL );
		CommonMethod.elementToBeClickable("Email", minWait);
		CommonMethod.SetText("Email", username);
		CommonMethod.testlog("Pass", "User entered the Password"+password);
		CommonMethod.SetText("Password", password);
		CommonMethod.Click("LoginButton");
		CommonMethod.waitForPageLoaded();
		CommonMethod.testlog("Pass", "User clicked on Sign In Button");
		CommonMethod.isElementsExist("Profile", minWait);
		Assert.assertEquals(CommonMethod.getText("Profile"),username );
		CommonMethod.testlog("Pass", "Verified After login profile name is visible"+username);
		
	}
	
	}
