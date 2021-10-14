package com.salesoptimize.reusablemethods;

import java.util.concurrent.TimeUnit;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;

public class ReusableMethodsEvidence extends BaseClass {

	
	public void evidenceOfOnlinePayments(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("PaymentMethod", minWait);
	
		CommonMethod.moveToElement("OnlinePayment");
		CommonMethod.Click("OnlinePayment");
		CommonMethod.testlog("Pass","User should be able to select 'Online Payments' filter under 'Payment Add-on' filter. ");	
		CommonMethod.testlog("Info","Any of payment method or payment provider should exists");	
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("Fprovider", minWait);
		 String provider= CommonMethod.GetText("Fprovider");
		 String paymentPro= CommonMethod.GetText("paymentPro");
		 Thread.sleep(1000);
			        if (provider.contains(data.getCellData(sheetName,"PayMeymentmethod", rowNum))||(paymentPro!=null)){
			        CommonMethod.assertTrue("Any of payment method or payment provider should exists'");
			        }
			        else {
			     
			        CommonMethod.assertFalse("Any of payment method or payment provider is not exists'");
             }
		 	
		  
		  } 
		
	
	
	public void evidenceofMobileSite(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		
		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");
		CommonMethod.visibilityOf("PaymentMethod", minWait);
		CommonMethod.visibilityOf("plusPayment1", minWait);
		Thread.sleep(500);
		
		CommonMethod.moveToElement("webtog");
		CommonMethod.Click("webtog");
		CommonMethod.testlog("Pass","User should be able to select 'Mobile Site' filter under 'Payment Add-on' filter. ");	
		
			
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("yes", minWait);
		
					
		 String provider= CommonMethod.GetText("yes").trim();
		 Thread.sleep(1000);
		  if(provider.contains("Yes"))
	      {

		  CommonMethod.assertTrue("Verified Is 'Mobile Enabled is 'Yes'");
		  
		  } else { 
		  CommonMethod.assertFalse("Is 'Mobile Enabled not contains 'Yes");
		 
		  }
		  
	}
	
	public void evidenceOfMultipleCurrencies(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		
		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");
		CommonMethod.visibilityOf("PaymentMethod", minWait);
		Thread.sleep(500);
		
		CommonMethod.moveToElement("MulipleCon");
		CommonMethod.Click("MulipleCon");
		CommonMethod.testlog("Pass","User should be able to select 'Mobile Site' filter under 'Payment Add-on' filter. ");	
		
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("MultipleCurrency", minWait);
		
					
		 String provider= CommonMethod.GetText("MultipleCurrency");
		 Thread.sleep(1000);
		  if(provider.contains("Yes"))
	      {

		  CommonMethod.assertTrue("'Verified Has Multiple Currencies 'Yes'");
		  
		  } else { 
		  CommonMethod.assertFalse("'Has Multiple Currencies is not 'Yes'");
		 
		  }
		 
		
		
	}
	
	public static void reset() throws Exception {
		CommonMethod.switchToParentTab();
		//CommonMethod.click("Reset");
		driver.navigate().to(navURL);
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void AllSitesShipping(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		CommonMethod.click("businessdropdown");
		Thread.sleep(1000);
		
		CommonMethod.visibilityOf("shippingAdd", minWait);
		CommonMethod.moveToElement("shippingAdd");
		CommonMethod.scrolldowntoElement("shippingAdd");
		CommonMethod.click("shippingAdd");
		CommonMethod.visibilityOf("AllSiteShipp", minWait);
		CommonMethod.moveToElement("AllSiteShipp");
		CommonMethod.Click("AllSiteShipp");
		CommonMethod.testlog("Pass","User should be able to select 'Multiple Currencies' filter under 'All Sites Shipping' filter. ");	
		
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		
		CommonMethod.visibilityOf("ShippingCompanies", minWait);
		CommonMethod.visibilityOf("ShippingPageLink", minWait);
		
					
		 String ShippingCompanies= CommonMethod.GetText("ShippingCompanies");
		 Thread.sleep(1000);
		 String ShippingPageLink= CommonMethod.GetText("ShippingPageLink");
		 
		  if((ShippingCompanies!=null)||(ShippingPageLink!=null))
	      {

		  CommonMethod.assertTrue("Any one of 'Shipping Companies' or 'Shipping Page Link' should exist");
		  
		  } else { 
		  CommonMethod.assertFalse("Any one of 'Shipping Companies' or 'Shipping Page Link' does not exist");
		 
		  }
		 
	}
	
	
	public void evidenceofFreeShipping(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		
		CommonMethod.click("businessdropdown");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("shippingAdd", minWait);
		CommonMethod.moveToElement("shippingAdd");
		CommonMethod.scrolldowntoElement("shippingAdd");
		CommonMethod.click("shippingAdd");
		CommonMethod.visibilityOf("AllSiteShipp", minWait);
		
		CommonMethod.click("freelab");
		CommonMethod.click("samenextdaylab");
		CommonMethod.click("returnslab");
	
		CommonMethod.testlog("Pass","User should be able to select 'Free Shipping', 'Same/Next Day Shipping', 'Returns Shipping' from 'Shipping Add-on' tab.");
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(6000);
		CommonMethod.visibilityOf("ShippingCompanies", minWait);
		
					
		 String ShippingCompanies= CommonMethod.GetText("ShippingCompanies");
		 
		 Thread.sleep(2000);
		  if((ShippingCompanies.contains("Free Shipping"))&&(ShippingCompanies.contains("Same/Next Day"))&&(ShippingCompanies.contains("Returns")))
	      {
		  CommonMethod.assertTrue("Verified the shipping companies contains 'Free Shipping', 'Same/Next Day Shipping', 'Returns ");
		 
		  } else { 
		  CommonMethod.assertFalse("Verified the shipping companies does not contains 'Free Shipping', 'Same/Next Day Shipping', 'Returns");
		  
		  }
		 
	}
	
	
	
	
	
	
	public void visitorTrafficRegionCountry(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		
		
		CommonMethod.click("international");
		Thread.sleep(2000);
		CommonMethod.moveToElement("plusTraf");
		CommonMethod.scrolldowntoElement("plusTraf");
		CommonMethod.click("plusTraf");
		CommonMethod.sendKeys("visitorTraf","EMEA");
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		
		CommonMethod.moveToElement("MinusTraf");
		CommonMethod.scrolldowntoElement("MinusTraf");
		CommonMethod.click("MinusTraf");
		CommonMethod.sendKeys("visitorCoun","Germany");
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass","Verified User is able to select 'Visitor Traffic Region' as 'EMEA' and 'Visitor Traffic Country' as 'Germany' under 'International Add-on' tab.");	

			
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(7000);
					
		 String ShippingCountry= CommonMethod.GetText("Germany").trim();
		 System.out.println(ShippingCountry);
		 
		 if(ShippingCountry.contains("Germany")){
		 
		  CommonMethod.assertTrue("verified Alexa Traffic Information' shoud contain country Germany");
		
		  } else { 
			  CommonMethod.assertFalse("verified Alexa Traffic does not contain country Germany");
				
		  }
		 
	}
	
	public void evidenceofInternationalPresence(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		CommonMethod.click("international");
		Thread.sleep(2000);
		CommonMethod.moveToElement("interpreslab");
		CommonMethod.scrolldowntoElement("interpreslab");
		CommonMethod.click("interpreslab");
		CommonMethod.testlog("Pass","User must be able to select 'Evidence of International Presence' under 'International Add-on' tab. ");	
		
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(7000);
					
		 String ShippingCountry= CommonMethod.GetText("HasInterD").trim();
		 System.out.println(ShippingCountry);
		 
		 if(ShippingCountry.equalsIgnoreCase("Yes")){
		 
		  CommonMethod.assertTrue("Verified 'Has International Domains' value is 'Yes'");
		
		  } else { 
			  CommonMethod.assertFalse("Verified 'Has International Domains' value is not 'Yes'");
				
		  }
		
	}
	
	public void evidenceOfInternationalShipping(int rowNum,String sheetName) throws Exception {
		selectUnitedKindom(rowNum,sheetName);
		
		CommonMethod.click("international");
		Thread.sleep(2000);
		CommonMethod.moveToElement("interlab");
		CommonMethod.scrolldowntoElement("interlab");
		CommonMethod.click("interlab");
		CommonMethod.testlog("Pass","User must be able to select 'Evidence of International Shipping' under 'International Add-on' tab. ");	
		
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
			
		CommonMethod.switchToNewTab();
		Thread.sleep(7000);
					
		 String ShippingCompanies= CommonMethod.GetText("ShippingCompanies");
		 System.out.println(ShippingCompanies);
		 
		 if(ShippingCompanies.contains("International Delivery")){
		 
		  CommonMethod.assertTrue("Verified Shipping companies contain 'International Delivery'");
		
		  } else { 
			  CommonMethod.assertFalse("Verified Shipping companies does not contain 'International Delivery");
				
		  }
		
	}
	
	
	public static void selectUnitedKindom(int rowNum,String SheetName) throws Exception {
		CommonMethod.visibilityOf("businessdropdown", 10);
		CommonMethod.scrolldowntoElement("businessdropdown");
		CommonMethod.elementToBeClickable("businessdropdown", 10);
		CommonMethod.click("businessdropdown");
		Thread.sleep(800);
		CommonMethod.testlog("Info","Verify if User should be able to select Business Country as United Kingdom");	
		CommonMethod.moveToElement("businessCountryPuls");
		CommonMethod.click("businessCountryPuls");
		CommonMethod.sendKeys("businesscountry", data.getCellData(SheetName, "BusinessCoutry", 4));
		Thread.sleep(1500);
		CommonMethod.elementToBeClickable("FirstResult", 10);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass","Verified User should be able to select Business Country as United Kingdom");	
	}
	
	public void includeWebsiteTechnology(int rowNum,String sheetName) throws Exception {
		
		selectUnitedKindom(rowNum,sheetName);
		
		CommonMethod.click("webtech");
		Thread.sleep(2000);
		CommonMethod.moveToElement("webtechcollapseP");
		CommonMethod.scrolldowntoElement("webtechcollapseP");
		CommonMethod.click("webtechcollapseP");
		
		CommonMethod.sendKeys("includeecommerceselect_chosen","Magento");
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass","User should be able to select 'Website Technology +' as 'Magento'");	
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(7000);
		
		 String ShippingCompanies= CommonMethod.GetText("WebsiteTech");
		 System.out.println(ShippingCompanies);
		 Thread.sleep(2000);
		 if(ShippingCompanies.equalsIgnoreCase("Magento")){
		 
		  CommonMethod.assertTrue("Verified Website Technology contain 'Magento'");
		
		  } else { 
			  CommonMethod.assertFalse("Verified Website Technology not contain 'Magento'");
				
		  }
		  
	}
public void excludeWebsiteTechnology(int rowNum,String sheetName) throws Exception {
		
		selectUnitedKindom(rowNum,sheetName);
		
		CommonMethod.click("webtech");
		Thread.sleep(2000);
		CommonMethod.moveToElement("webtechcollapseM");
		CommonMethod.scrolldowntoElement("webtechcollapseM");
		CommonMethod.click("webtechcollapseM");
		
		CommonMethod.sendKeys("excludeecommerceselect","Magento");
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass","User should be able to select 'Website Technology -' as 'Magento'");	
		
		dashboard.clickSearch();
		dashboard.clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(7000);
		
		
		 String ShippingCompanies= CommonMethod.GetText("WebsiteTech");
		 System.out.println(ShippingCompanies);
		 Thread.sleep(2000);
		 if(ShippingCompanies!="Magento"){
		 
		  CommonMethod.assertTrue("Verified Website Technology should not contain 'Magento'");
		
		  } else { 
			  CommonMethod.assertFalse("Verified Website Technology contain 'Magento'");
				
		  }
		
	}
	
	}
	

