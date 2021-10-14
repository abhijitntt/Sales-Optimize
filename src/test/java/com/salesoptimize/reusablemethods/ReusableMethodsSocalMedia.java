package com.salesoptimize.reusablemethods;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;
import com.salesoptimize.utility.ReadDataUtility;

public class ReusableMethodsSocalMedia extends BaseClass {
	 Date date = new Date();
	
public static void FacebookLikes(int rowNum,String sheetName) throws Exception {
		
	    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
	    OpenSocalMediaTab();
		
		CommonMethod.dragAndDrop("sfacebookSliderSelectionContainer","dfacebookSliderSelectionContainer");
		CommonMethod.testlog("Pass","User should be able to select 'Facebook Likes' as '>1M' under 'Social Media' tab.");	
		
		SocalMedia.clickFirstRecordSwtithTab();
		CommonMethod.visibilityOf("flike", 30);
		Thread.sleep(2000);
		
		 String ShippingCompanies= CommonMethod.GetText("flike");
		 int num =(int) CommonMethod.getNumber(ShippingCompanies);
		 System.out.println(num);
		 Thread.sleep(2000);
		 if(num>1000000){
		 
		  CommonMethod.assertTrue("Verified Facebook Likes is > 1M - "+ShippingCompanies);
		
		  } else { 
			  CommonMethod.assertFalse("Verified Verified Facebook likes is <1M -"+ShippingCompanies);
				
		  }
		
	}

public void twitterFollowers(int rowNum,String sheetName) throws Exception {
	

    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenSocalMediaTab();
	
	CommonMethod.dragAndDrop("stwitterSliderSelectionContainer","dtwitterSliderSelectionContainer");
	CommonMethod.testlog("Pass","User should be able to select 'Twitter Followers' as '>1M' under 'Social Media' tab.");	
	
	clickFirstRecordSwtithTab();
	CommonMethod.visibilityOf("flike", 30);
	Thread.sleep(2000);
	 String ShippingCompanies= CommonMethod.GetText("flike1");
	 int num =(int) CommonMethod.getNumber(ShippingCompanies);
	 System.out.println(num);
	 Thread.sleep(3000);
	 if(num>1000000){
	 
	  CommonMethod.assertTrue("Verified 'Twitter Followers' should be '>1M - "+ShippingCompanies);
	
	  } else { 
		  CommonMethod.assertFalse("Verified 'Twitter Followers' should be '>1M - "+ShippingCompanies);
		  
		  
			
	  }
	// ReusableMethodsEvidence.reset();
	}
	




public void instagramFollowers(int rowNum,String sheetName) throws Exception {
	
    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenSocalMediaTab();
	
	CommonMethod.dragAndDrop("sinstagramSliderSelectionContainer","dinstagramSliderSelectionContainer");
	CommonMethod.testlog("Pass","User should be able to select 'Instagram Followers' as '>1M' under 'Social Media' tab.");	
	
	clickFirstRecordSwtithTab();
	CommonMethod.visibilityOf("flike", 30);
	Thread.sleep(2000);
	 String ShippingCompanies= CommonMethod.GetText("flike2");
	 int num =(int) CommonMethod.getNumber(ShippingCompanies);
	 System.out.println(num);
	 Thread.sleep(3000);
	 if(num>1000000){
	 
	  CommonMethod.assertTrue("Verified 'Instagram Followers' are >1M : "+ShippingCompanies);
	
	  } else { 
		  CommonMethod.assertFalse("Instagram Followers are less than 1M : "+ShippingCompanies);
			
	  }
	 
}

public static void youTubeViews(int rowNum,String sheetName) throws Exception {
	
    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenSocalMediaTab();
	
	CommonMethod.dragAndDrop("youtubeViewsSliderSelectionContainer","dyoutubeViewsSliderSelectionContainer");
	CommonMethod.testlog("Pass","User should be able to select 'YouTube Views' as '>1M' under 'Social Media' tab.");	
	
	SocalMedia.clickFirstRecordSwtithTab();
	CommonMethod.visibilityOf("flike", 30);
	Thread.sleep(2000);
	 String ShippingCompanies= CommonMethod.GetText("flike3");
	 int num =(int) CommonMethod.getNumber(ShippingCompanies);
	 System.out.println(num);
	 Thread.sleep(3000);
	 if(num>1000000){
	 
	  CommonMethod.assertTrue("Verified 'YouTube Views' is >1M : "+ShippingCompanies);
	
	  } else { 
		  CommonMethod.assertFalse("YouTube Views is less than 1M : "+ShippingCompanies);
			
	  }
	// ReusableMethodsEvidence.reset();
}
public static void youTubeSubscribers(int rowNum,String sheetName) throws Exception {
	
    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenSocalMediaTab();
	
	CommonMethod.dragAndDrop("youtubeSubscribersSliderSelectionContainer","dyoutubeSubscribersSliderSelectionContainer");
	CommonMethod.testlog("Pass","User should be able to select 'YouTube Subscribers' as '>1M' under 'Social Media' tab.");	
	
	SocalMedia.clickFirstRecordSwtithTab();
	CommonMethod.visibilityOf("flike", 30);
	Thread.sleep(2000);
	 String ShippingCompanies= CommonMethod.GetText("flike4");
	 int num =(int) CommonMethod.getNumber(ShippingCompanies);
	 System.out.println(num);
	 Thread.sleep(3000);
	 if(num>1000000){
	 
	  CommonMethod.assertTrue("Verified 'YouTube Subscribers' should be '>1M : "+ShippingCompanies);
	
	  } else { 
		  CommonMethod.assertFalse("YouTube Subscribers is less than 1M : "+ShippingCompanies);
			
	  }
	 ReusableMethodsEvidence.reset();
}
public  void PresenceOfFacebook(int rowNum,String sheetName) throws Exception {
	
    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenSocalMediaTab();
	CommonMethod.Click("facebooklab");
    CommonMethod.testlog("Pass","User should be able to select 'Presence of Twitter' under 'Social Media' tab");	
	
	clickFirstRecordSwtithTab();
	
	CommonMethod.visibilityOf("Facebook", 30);
	Thread.sleep(2000);
	 String link= CommonMethod.GetText("Facebook");
	 Thread.sleep(2000);
	 
	 if(link.contains("https://www.facebook.com/")){
	 
	  CommonMethod.assertTrue("Verified Facebook page link should exists under 'Website Overview' section: "+link);
	
	  } else { 
		  CommonMethod.assertFalse("Verified Facebook page link does not exists under 'Website Overview' section :" +link);
			
	  }
	
}

public void presenceOfTwitter(int rowNum,String sheetName) throws Exception {
	
	 ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
	    OpenSocalMediaTab();
		CommonMethod.Click("twitterlab");
	    CommonMethod.testlog("Pass","'Instagram page link should exists under 'Website Overview' section");	
		
		clickFirstRecordSwtithTab();
		
		 
		 String link= CommonMethod.GetText("Twitter");
		 Thread.sleep(2000);
		 
		 if(link.contains("https://www.twitter.com/")){
		 
		  CommonMethod.assertTrue("Verified 'Instagram page link should exists under 'Website Overview' section :" +link);
		
		  } else { 
			  CommonMethod.assertFalse("Verified 'Instagram page link should not exists under 'Website Overview' section Instagram page link not exists under 'Website Overview' section :"+link);
				
		  }
		// ReusableMethodsEvidence.reset();
	}
public void presencOfInstagram(int rowNum,String sheetName) throws Exception {
	
	    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
	    OpenSocalMediaTab();
		CommonMethod.Click("instagramlab");
	    CommonMethod.testlog("Pass","User should be able to select 'Presence of Instagram' under 'Social Media' tab.");	
		
		clickFirstRecordSwtithTab();
		
		 
		 String link= CommonMethod.GetText("Instagram");
		 Thread.sleep(2000);
		 
		 if(link.contains("https://www.instagram.com/")){
		 
		  CommonMethod.assertTrue("Verified Instagram page link should exists under 'Website Overview' section :" +link);
		
		  } else { 
			  CommonMethod.assertFalse("Verified 'Instagram page link does not exists under 'Website Overview' section :"+link);
				
		  }
		
	}
public  void presenceofYoutube(int rowNum,String sheetName) throws Exception {
	
	    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
	    OpenSocalMediaTab();
	    CommonMethod.scrolldowntoElement("youtubelab1");
	    //CommonMethod.visibilityOf("youtubelab1", 10);
		CommonMethod.Click("youtubelab1");
	    CommonMethod.testlog("Pass","User should be able to select 'Presence of Youtube' under 'Social Media' tab.");	
		
		clickFirstRecordSwtithTab();
		 String link= CommonMethod.GetText("YoutubeViews");
		 Thread.sleep(500);
		 String link1= CommonMethod.GetText("Subscribers");
		 
		 Thread.sleep(1000);
		 
		 if(link.contains("Youtube Views")||link1.contains("Youtube Subscribers")){
		 
		  CommonMethod.assertTrue("Verified 'Any of 'Youtube Views' or 'Youtube Subscribers' should exists :" +link +link1);
		
		  } else { 
			  CommonMethod.assertFalse("Verified 'Any of 'Youtube Views' or 'Youtube Subscribers' does not exists :");
				
		  }
		
	}
public void includeMarketingAnalytics(int rowNum,String sheetName) throws Exception {
	
    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenMarketing();
    CommonMethod.click("topPlus");
	CommonMethod.sendKeys("PlusText","Google Ads");
	Thread.sleep(2000);
	CommonMethod.visibilityOf("FirstResult", minWait);
	CommonMethod.click("FirstResult");

	
	CommonMethod.testlog("Pass","User should be able to select 'Marketing Analytics +' as Google Ads under Marketing Analytics tab.");	
	
	SocalMedia.clickFirstRecordSwtithTab();
	CommonMethod.testlog("Info","Verifying Marketing Analytics + contain Google Ads");	
	
	 CommonMethod.visibilityOf("MarketingAnalyis", 30);
	 Thread.sleep(7000); 
	 String ShippingCompanies= CommonMethod.GetText("MarketingAnalyis").trim();
	 System.out.println(ShippingCompanies);
	 Thread.sleep(1000); 
	  if (ShippingCompanies.contains("Google Ads")){
	        CommonMethod.assertTrue("Verified Marketing Analytics + contain Google Ads");
	        }
	        else {
	     
	        CommonMethod.assertFalse("Verified Marketing Analytics + not contain Google Ads");
   }
	
	
}
public  void ExcludeMarketingAnalytics(int rowNum,String sheetName) throws Exception {
	
    ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
    OpenMarketing();
	CommonMethod.click("topMinu");
	CommonMethod.sendKeys("MinuText","Doofinder");
	Thread.sleep(1000);
	CommonMethod.visibilityOf("FirstResult", minWait);
	CommonMethod.click("FirstResult");

    CommonMethod.testlog("Pass","User must be able to select 'Marketing Analytics -' as 'Doofinder'");	
	
    SocalMedia.clickFirstRecordSwtithTab();
      
    //String ShippingCompanies= CommonMethod.GetText("MarketingAnalyis");
    
    if(driver.getPageSource().contains("Doofinder")){
    	 CommonMethod.assertFalse("Verified Marketing Analytics contain 'Doofinder'");
    	}else{
    		 CommonMethod.assertTrue("Verified Marketing Analytics - not contain 'Doofinder'");
	 
	 
	        
 }
	
	
	
}




    public static void OpenSocalMediaTab() throws Exception {
  
    	CommonMethod.scrolldowntoElement("socialmedia");
    	CommonMethod.visibilityOf("socialmedia", avgWait);
    	CommonMethod.moveToElement("socialmedia");
		CommonMethod.click("socialmedia");
		Thread.sleep(2000);
		
    	
    }
    
    public static void openTopLevelDoman() throws Exception {
    	CommonMethod.visibilityOf("toplevel", avgWait);
    	CommonMethod.scrolldowntoElement("toplevel");
    	
    	CommonMethod.moveToElement("socialmedia");
		CommonMethod.click("toplevel");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("topplus", avgWait);
		CommonMethod.click("topplus");
		
    	
    }
    
    
    public static void OpenMarketing() throws Exception {
    	  
    	CommonMethod.scrolldowntoElement("marketing");
    	CommonMethod.visibilityOf("marketing", avgWait);
    	CommonMethod.moveToElement("marketing");
		CommonMethod.click("marketing");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("PlusText", avgWait);
		
		
		
    	
    }
    public void clickFirstRecordSwtithTab() throws Exception {
    	dashboard.clickSearch();
		dashboard.clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(1000);
		CommonMethod.waitForPageLoaded();
		Thread.sleep(8000);
		CommonMethod.visibilityOf("LinkPre", avgWait);
		
    	
    }
	
    
    
    public void topLevelDomain(int rowNum,String sheetName) throws Exception {
    	
    	
        ReusableMethodsEvidence.selectUnitedKindom(rowNum,sheetName);
        openTopLevelDoman();
        CommonMethod.SetText("topText",".com");
        Thread.sleep(1000);
    	CommonMethod.visibilityOf("FirstResult", minWait);
    	CommonMethod.click("FirstResult");

    	CommonMethod.testlog("Pass","User must be able to select 'Top Level Domain' as '.com'");	
    	
    	dashboard.clickSearch();
    	
    	CommonMethod.click("addLeadsToList");
	    CommonMethod.testlog("Pass","User is able to click on Add Leads to a List");
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
     
		String fileName= "TopLevelDomain"+new Timestamp(date.getTime()).toString().trim().replace(":","").replace(".","").replace(" ","");
		    
		CommonMethod.SetText("LeadsList", fileName);

		CommonMethod.click("Continue");
		
		Thread.sleep(10000);
		CommonMethod.Click("exportAlist");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("OKExport",10);
		CommonMethod.elementToBeClickable("OKExport", 10);
		CommonMethod.click("NumberOfLeads");
		
		CommonMethod.Click("OKExport");
		
		Thread.sleep(10000);
		CommonMethod.invisibilityOf("bulkProgress", 60);
		
		
		
		CommonMethod.Click("downloadCsv");
		CommonMethod.Click("downloadexcel");
		Thread.sleep(10000);
		String fileDownloadPath= CommonMethod.GetText("nameFileName");
		
		
		
		CommonMethod.VerifyFileDownloadWithExtension("MostHaveEmailPhoneNo",".csv");
		CommonMethod.testlog("Pass", "User is be able to download the reports in  CSV format");

		
		CommonMethod.VerifyFileDownloadWithExtension("MostHaveEmailPhoneNo",".xlsx");
		CommonMethod.testlog("Pass", "User is be able to download the reports in Excel  format");

	
		int totalExcle= ReadDataUtility.getRowCountExcel(downloadPath+fileDownloadPath+".xlsx");
		totalExcle=totalExcle+1;
		System.out.println(totalExcle);
		CommonMethod.testlog("Info", "Verifying in records of the downloaded Excel file have at least one Company Email and phone");
        if(totalExcle>10) {
        	totalExcle=10;
        }
		
		for(int i=2;i<=totalExcle;i++) {
			
		String website= ReadDataUtility.getCellData(downloadPath+fileDownloadPath+".xlsx","Website",i);
		
		
		if(website.contains(".com")) {
		  CommonMethod.assertTrue("Verified in records of the downloaded file contain Url end with .com : "+ website);
		}		
		else {
			  CommonMethod.assertFalse("Verified in records of the downloaded file contain Url should end with .com : "+ website);
	      
		}
		}
		
		CommonMethod.testlog("Pass", "Verified All records of the downloaded Excel file contain Url end with .com");
		

		CommonMethod.testlog("Info", "Verified All records of the downloaded CSV file contain Url end with .com");

		ReadDataUtility.VerifyComCSV(downloadPath+fileDownloadPath+".csv",0);
	
		CommonMethod.testlog("Pass", "Verified All records of the downloaded CSV file contain Url end with .com");

		
		}
		
}

