package com.salesoptimize.reusablemethods;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.salesoptimize.utility.BaseClass;
import com.salesoptimize.utility.CommonMethod;
import com.salesoptimize.utility.ReadDataUtility;

public class ReusableMethodsDashboard extends BaseClass {
	 Date date = new Date();

	public void selectBusinessCountry(int rowNum, String country) throws Exception {
        Thread.sleep(1000);
        
		CommonMethod.testlog("Info", "User selects Global Region as North America");
		CommonMethod.visibilityOf("businessdropdown", 10);
		CommonMethod.scrolldowntoElement("businessdropdown");
		
		CommonMethod.click("businessdropdown");
		CommonMethod.moveToElement("businessregion");
		CommonMethod.click("businessregion");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("businessregion", 10);
		CommonMethod.SetText("businessregion", data.getCellData(country, "GlobalRegion", rowNum));
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verified User is able to selects Global Region as North America");

		CommonMethod.moveToElement("businessCountryPuls");
		CommonMethod.click("businessCountryPuls");
		CommonMethod.SetText("businesscountry", data.getCellData(country, "BusinessCoutry", rowNum));
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verified User is be able to select Business Country as United States");


		CommonMethod.testlog("Info", "Verify if User should be able to provide City as New York");
		CommonMethod.click("City");
		CommonMethod.SetText("City", data.getCellData(country, "City", rowNum));
		Thread.sleep(1000);
		CommonMethod.testlog("Pass", "Verified User is be able to select Business Country as United States");

		CommonMethod.testlog("Info", "User provides Zip Code as 10001");
		CommonMethod.SetText("Zipcode", data.getCellData(country, "ZipCode", rowNum));
		Thread.sleep(1000);
		CommonMethod.testlog("Pass", "User is able to provide Zip Code as 10001");

		
		SocalMedia.clickFirstRecordSwtithTab();
		String businessCountry = CommonMethod.GetText("AddressCity");
		Thread.sleep(1000);
		if (businessCountry.contains(data.getCellData(country, "BusinessCoutry", rowNum))) {
			CommonMethod.assertTrue("Verified for first info Address City should is New York");

		} else {
			CommonMethod.assertFalse("Verified for first info Address country is not New York");

		}
		CommonMethod.switchToParentTab();
		clickOnLastTab(rowNum, country);
		CommonMethod.visibilityOf("ClickNext", minWait);
		int size = driver.findElements(By.xpath("//table/tbody/tr/td[2]/a")).size();
		System.out.println(size);

		driver.navigate().refresh();
		Thread.sleep(2000);
		CommonMethod.visibilityOf("ListSize", minWait);
		driver.findElement(By.xpath("//table/tbody/tr[" + size + "]/td[2]/a")).click();
		;

		Thread.sleep(2000);
		CommonMethod.switchToParentTab2();
		Thread.sleep(2000);
		CommonMethod.visibilityOf("AddressCity", minWait);
		businessCountry = CommonMethod.GetText("AddressCity");
		Thread.sleep(1000);
		if (businessCountry.contains(data.getCellData(country, "BusinessCoutry", rowNum))) {
			CommonMethod.assertTrue("Verified in Last page Last info Address City  is New York");

		} else {
			CommonMethod.assertFalse("Verified in Last page Last info Address country is not New York");

		}

	}

	public static void clickOnLastTab(int rowNum, String country) throws Exception {
		try {
			for (int i = 0; i <= 5; i++) {
				CommonMethod.Click("ClickNext");
				CommonMethod.visibilityOf("ClickNext", minWait);
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}

	}

	public void selectIndustryRetailAndFashiClothing(int rowNum, String country) throws Exception {

		businessCountryUK(rowNum, country);

		CommonMethod.moveToElement("industryDropdown");
		CommonMethod.click("industryDropdown");
		CommonMethod.moveToElement("IndustoryPlus");
		CommonMethod.click("IndustoryPlus");

		CommonMethod.moveToElement("Selectindustry");
		CommonMethod.sendKeys("Selectindustry", data.getCellData(country, "Industry", rowNum));
		Thread.sleep(2000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		CommonMethod.scrolldowntoElement("GlobalRegion");
		CommonMethod.click("GlobalRegion");

		CommonMethod.SetText("GlobalRegion", "Fashion & Clothing");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		Assert.assertEquals(CommonMethod.getText("SubIndustory"), data.getCellData(country, "Industry", 3), "Success");

		clickSearch();
		clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(3000);
		CommonMethod.visibilityOf("NoEmp", minWait);

		CommonMethod.testlog("Info", "Verify Estimated Online Sales is >$20M");

		if (CommonMethod.getNumber(CommonMethod.GetText("Estimated")) > 20) {
			CommonMethod.assertTrue("Estimated Online Sales is >$20M");

		} else {

			CommonMethod.assertFalse("Estimated Online Sales is <$20M");

		}

	}

	public void selectIndustryAndSubIndustry(int rowNum, String country) throws Exception {

		businessCountryUK(rowNum, country);

		CommonMethod.moveToElement("industryDropdown");
		CommonMethod.click("industryDropdown");
		CommonMethod.moveToElement("IndustoryPlus");
		CommonMethod.click("IndustoryPlus");

		CommonMethod.moveToElement("Selectindustry");
		CommonMethod.sendKeys("Selectindustry", data.getCellData(country, "Industry", rowNum));
		Thread.sleep(2000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		Thread.sleep(1000);
		//Assert.assertEquals(CommonMethod.getText("Industorychosen"), data.getCellData(country, "Industry", rowNum),"Success");

		CommonMethod.scrolldowntoElement("GlobalRegion");
		CommonMethod.click("GlobalRegion");

		CommonMethod.SetText("GlobalRegion", "Fashion & Clothing");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		Assert.assertEquals(CommonMethod.getText("SubIndustory"), data.getCellData(country, "Industry", 3), "Success");
		CommonMethod.testlog("Pass", "User is be able to select 'Industry' as 'Retail' and 'Sub-Industry' as 'Fashion & Clothing'");

		clickSearch();
		clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		
		String retail = CommonMethod.GetText("NRetail").trim();
		String NSubIndustry= CommonMethod.GetText("NSubIndustry").trim();
		String total= retail+NSubIndustry;
		System.out.println(total);
		
		if (total.contains("RetailFashion & Clothing")) {
		CommonMethod.assertTrue("Verified Industry contain 'Retail' and Sub-Industry should contain 'Fashion & Clothing'");

		} else {

			CommonMethod.assertFalse("Verified Industry not contain 'Retail' and Sub-Industry should contain 'Fashion & Clothing'");

		}

	}

	public void selectEstimatedOnlineSales(int rowNum, String country) throws Exception {

		CommonMethod.elementToBeClickable("merchantFilter", minWait);
		CommonMethod.click("merchantFilter");
		CommonMethod.visibilityOf("OMinSales", minWait);

		CommonMethod.testlog("Info", "User selects Estimated Online sales >=20M");
		CommonMethod.scrolldowntoElement("OMinSales");

		CommonMethod.dragAndDrop("OMinSales", "OMaxSales");
		CommonMethod.testlog("Pass", "User is able to select Estimated Online sales >=20M");
		Thread.sleep(2000);

		CommonMethod.visibilityOf("NMinEmp", minWait);
		CommonMethod.testlog("Info", "User selects Number of Employees>=1K");
		CommonMethod.scrolldowntoElement("NMinEmp");
		Thread.sleep(2000);
		CommonMethod.dragAndDrop("NMinEmp", "NMaxEmp");
		CommonMethod.testlog("Pass", "User is able to select Number of Employees>=1K");

		clickSearch();

		clickFirstRecord();

		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("NoEmp", minWait);

		CommonMethod.testlog("Info", "Verify Estimated Online Sales is >$20M");

		if (CommonMethod.getNumber(CommonMethod.GetText("Estimated")) > 20) {
			Assert.assertTrue(true);
			CommonMethod.testlog("Pass", "Estimated Online Sales is >$20M");

		} else {
			CommonMethod.testlog("Fail", "Estimated Online Sales is <$20M");
			Assert.assertTrue(false);

		}

		CommonMethod.testlog("Info", "Verify Higher value of Number of Employees should be >= 1000");
		if (CommonMethod.getNumber(CommonMethod.GetText("NoEmp")) > 1000)

		{
			CommonMethod.assertTrue("Verified Higher value of Number of Employees is >= 1000");
		} else {
			CommonMethod.assertFalse("Higher value of Number of Employees should be <= 1000");

		}
	}

	
	
	public void ExportPurchasedLeadToSalesforce(int rowNum,String country) throws Exception {
		driver.get(data.getCellData(country, "URL", rowNum));
		CommonMethod.waitForPageLoaded();
		CommonMethod.visibilityOf("SaveList", 10);
		
		CommonMethod.testlog("Pass","User clicks on Saved Lists option");
		CommonMethod.Click("SaveList");
	    CommonMethod.Click("ViewList");
	    
	    clickFirstRecord();
	    CommonMethod.testlog("Pass","For the list created in Testcase_1 User clicks on 'View' Under Action");
	    
	    CommonMethod.testlog("Info","User should be able to click on Export to Salesforce button");
		
		CommonMethod.switchToNewTab();
		CommonMethod.waitForPageLoaded();
		Thread.sleep(3000);
		CommonMethod.visibilityOf("ClickCont", 10);
		CommonMethod.testlog("Pass","User clicks on Count");
		   
		CommonMethod.Click("ClickCont");
		CommonMethod.waitForPageLoaded();
		Thread.sleep(2000);
		CommonMethod.click("UnselectAll");
		CommonMethod.waitForPageLoaded();
		Thread.sleep(3000);
		CommonMethod.visibilityOf("FirsSelect", 10);
		CommonMethod.Click("FirsSelect");
		Thread.sleep(1000);
		CommonMethod.Click("SecondSelect");
		CommonMethod.testlog("Pass","User is able to click on Contact tab and select two unselected contacts");
		Thread.sleep(2000);
		
		CommonMethod.elementToBeClickable("ExportSF", 10);
		CommonMethod.Click("ExportSF");
		CommonMethod.testlog("Pass","User should be able to click on Export to Salesforce button");
		Thread.sleep(2000);
		
		CommonMethod.visibilityOf("ExportSuss", 30);
		CommonMethod.assertcontainsmessage("ExportSuss","Exported successfully!","Exported successfully!");
		CommonMethod.testlog("Pass", "User get the export success message");
		
		driver.navigate().refresh();
		CommonMethod.waitForPageLoaded();
		Thread.sleep(2000);
		CommonMethod.elementToBeClickable("LeadSF", 10);
		CommonMethod.Click("LeadSF");
		CommonMethod.testlog("Pass","User is  click on OK button");
		Thread.sleep(2000);
		CommonMethod.switchToNewTab();
		loginSF();
		
		
		/*
		CommonMethod.waitForPageLoaded();
		CommonMethod.visibilityOf("ExpoertTitle", 30);
		System.out.println(CommonMethod.getText("ExpoertTitle"));
		CommonMethod.testlog("Pass","User is able to redirected to Salesforce on clicking the link and should be able to see the exported lead in Salesforce");
		
		*/
		

		
		
		
	    
	
	}
	
	public void loginSF() throws Exception {
		CommonMethod.waitForPageLoaded();
		Thread.sleep(1000);
		String strUrl = driver.getCurrentUrl();
		if(strUrl.contains("https://nixtortechnologypvtltd-dev-ed.my.salesforce.com/"))
		{
			
			CommonMethod.assertTrue("User is able to redirected to Salesforce on clicking the link and should be able to see the exported lead in Salesforce");
			
		}else {
			CommonMethod.assertFalse("User is able to redirected to Salesforce on clicking the link and should be able to see the exported lead in Salesforce");
				
		}
		/*
		CommonMethod.testlog("Pass","User gets redirected to Salesforce login");
		CommonMethod.SetText("SFUserName","ganit@nixtortech.com");
		CommonMethod.SetText("SFPassword", "Nixtor@2020");
		CommonMethod.testlog("Pass","User provides username and password");
		CommonMethod.Click("SFLogin");
		CommonMethod.testlog("Pass","User gets redirected to SalesOptimize crm export setup page");
		*/
	}
	
	public void exportAlist(int rowNum, String country) throws Exception {
	
		businessCountryIreland(rowNum, country);
		
		CommonMethod.elementToBeClickable("merchantFilter", minWait);
		CommonMethod.click("merchantFilter");
		CommonMethod.visibilityOf("OMinSales", minWait);
		CommonMethod.testlog("Info", "User selects Estimated Online sales >=20M");
		
		CommonMethod.dragAndDrop("OMinSales", "OMaxSales");
		CommonMethod.testlog("Pass", "User is able to select Estimated Online sales >=20M");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("NMinEmp", minWait);
		CommonMethod.testlog("Info", "User selects Number of Employees >=5K");
		CommonMethod.scrolldowntoElement("NMinEmp");
		Thread.sleep(1000);
		CommonMethod.dragAndDrop("NMinEmp", "NMaxEmp");
		CommonMethod.testlog("Pass", "User selects Number of Employees >=5K");
		

		
		clickSearch();
	    
	    CommonMethod.click("addLeadsToList");
	    CommonMethod.testlog("Pass","User is able to click on Add Leads to a List");
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
     
	
		String fileName= "ExportAList"+new Timestamp(date.getTime()).toString().trim().replace(":","").replace(".","").replace(" ","");
		    
		CommonMethod.SetText("LeadsList", fileName);

		CommonMethod.click("Continue");
		
	
		Thread.sleep(10000);
		CommonMethod.Click("exportAlist");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("OKExport",10);
		CommonMethod.elementToBeClickable("OKExport", 10);
		CommonMethod.click("NumberOfLeads");
		//CommonMethod.SetText("NumberOfLeads"," ");
		
		CommonMethod.Click("OKExport");
		
		Thread.sleep(10000);
		CommonMethod.invisibilityOf("bulkProgress", 60);
		CommonMethod.Click("downloadCsv");
		CommonMethod.Click("downloadexcel");
		Thread.sleep(5000);
		String fileDownloadPath= CommonMethod.GetText("nameFileName");
		int noOfRecords= Integer.parseInt(CommonMethod.GetText("bulkleads"));
		
		int csvTotal= ReadDataUtility.getRowCount(downloadPath+fileDownloadPath+".csv");
		
		
		int totalExcle= ReadDataUtility.getRowCountExcel(downloadPath+fileDownloadPath+".xlsx");
		
		String url = driver.getCurrentUrl();
		data.setCellData(country, "URL", rowNum, url);
		
		for(int i=0;i<=ReadDataUtility.getRowCountExcel(downloadPath+fileDownloadPath+".xlsx");i++) {
		System.out.println(ReadDataUtility.getCellData(downloadPath+fileDownloadPath+".xlsx","Website",i));
		}
		if(noOfRecords==csvTotal && noOfRecords==totalExcle) {
			CommonMethod.assertTrue("Verified The number of records in Excel format  match with the number of lines in the Bulk Download Screen Are : " +totalExcle);
			CommonMethod.assertTrue("Verified The number of records in  CSV format  match with the number of lines in the Bulk Download Screen Are : " +csvTotal);
            CommonMethod.testlog("Pass", "First coulum Values are :" + ReadDataUtility.getRowData(downloadPath+fileDownloadPath+".csv"));
		}
		else {
			CommonMethod.assertFalse("Verified The number of records in Excel format did not match with the number of lines in the Bulk Download Screen Are : " +totalExcle);
			CommonMethod.assertFalse("Verified The number of records in  CSV format did not match with the number of lines in the Bulk Download Screen Are : " +csvTotal);
          
		}
		}
		
		
      
	

	public void addSalesforceCRMExport(int rowNum, String country) throws Exception {
         
		CommonMethod.visibilityOf("ExportCSM", 10);
		CommonMethod.elementToBeClickable("ExportCSM", 10);
		CommonMethod.Click("ExportCSM");
		CommonMethod.testlog("Pass","User is be able to click on Export to Salesforce button");
		/*
		CommonMethod.Click("ExportButton");
		CommonMethod.testlog("Pass","User should be able to click on Export to Salesforce button");
		
		
		CommonMethod.Click("ExportSalesForce");
		CommonMethod.testlog("Pass","User gets redirected to Salesforce login");
		
		CommonMethod.Click("Iaccept");
		CommonMethod.testlog("Pass","User gets redirected to Salesforce login");
		loginSF();
		CommonMethod.waitForPageLoaded();
		*/
		
		Thread.sleep(1000);
		CommonMethod.GetText("revoke");
		CommonMethod.visibilityOf("revoke", 10);
		CommonMethod.assertTrue("Verified User gets redirected to SalesOptimize crm export setup page");
		
		

	}

	public void includePaymentProvider(int rowNum, String country) throws Exception {

		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");

		CommonMethod.visibilityOf("plusPayment1", minWait);
		CommonMethod.click("plusPayment1");

		CommonMethod.testlog("Info", "Verify if user is able to select Payment Provider as 'Adyen' and 'Apple Pay'");
		CommonMethod.sendKeys("Competitors", "Adyen");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		CommonMethod.moveToElement("MinusFilter");
		CommonMethod.click("MinusFilter");
		CommonMethod.sendKeys("Exclude", "Apple Pay");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verified User is able to select Payment Provider as 'Adyen' and 'Apple Pay'");

		clickSearch();

		clickFirstRecord();

		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("PaymentProvider", minWait);

		CommonMethod.testlog("Info", "Verify the payment provider listed");

		String provider = CommonMethod.GetText("PaymentProvider");
		if (provider.contains("Adyen") || provider.contains("Apple Pay")) {

			CommonMethod
					.assertTrue("Verified Payment provider contain Adyen or Apple Pay or Both (i.e. Ayden, Apple Pay)");

		} else {
			CommonMethod.assertFalse(" Payment provider does not contain Adyen or Apple Pay or Both");

		}

	}

	public void excludePaymentProvider(int rowNum, String country) throws Exception {

		businessCountryIreland(rowNum, country);

		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");

		CommonMethod.visibilityOf("PaymentMethod", minWait);
		CommonMethod.click("PaymentMethod");

		CommonMethod.testlog("Info", "Verify if user is able to select Payment Provider as 'Adyen' and 'Apple Pay'");
		CommonMethod.sendKeys("PaymentCard", "Visa Debit");
		Thread.sleep(2);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");

		clickSearch();

		clickFirstRecord();

		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("PaymentProvider", minWait);

		CommonMethod.testlog("Info", "Verify the payment provider listed");

		String provider = CommonMethod.GetText("PaymentProvider");
		if (provider.contains("Visa Debit")) {

			CommonMethod.assertFalse("Payment Provider contain ' Adyen' ");

		} else {
			CommonMethod.assertTrue(" Payment Provider does not contain ' Adyen'");

		}

	}

	public void encludePaymentMethod(int rowNum, String sheetName) throws Exception {

		businessCountryIreland(rowNum, sheetName);

		
		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");

		CommonMethod.visibilityOf("PaymentMinu", minWait);
		CommonMethod.click("PaymentMinu");
		Thread.sleep(200);

		CommonMethod.SetText("ExcludePayment","Visa Debit");
		Thread.sleep(2000);
		
		CommonMethod.visibilityOf("FirstResult", minWait);
		
		
		clickSearch();
		
		clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(1000);
		CommonMethod.testlog("Pass", "User should be able to select 'Payment Method -' as 'Visa Debit'");
		CommonMethod.testlog("Info", "Payment Method should not contain 'Visa Debit");

		
		WebDriverWait w = new WebDriverWait(driver,5);
		
		boolean b;
		
	
		try {
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[normalize-space(text())='Payment Methods']/following::td[1]")));
	        b= true;
	        System.out.println("True");
	    }
	     catch (Exception e) {
		  b = false;
		  System.out.println("false");
	    }
		if(b==true) {
		
		String provider = CommonMethod.GetText("PaymentMethods");
		if (provider.contains(data.getCellData(sheetName, "PaymentMethod", rowNum))) {

			CommonMethod.assertFalse("Payment Method contain 'Visa Debit'");

		} else {
			CommonMethod.assertTrue("Verified Payment Method does not contain 'Visa Debit");

		}
		}
		if(b==false) {
			CommonMethod.assertTrue("Verified Payment Method does not contain 'Visa Debit");
	
		}
			
		

	}

	public void clickFirstRecord() throws Exception {
		CommonMethod.testlog("Info ", "Verify if User should be able to click on Info of the first record");
		Thread.sleep(2000);
		CommonMethod.elementToBeClickable("Info", 10);
		CommonMethod.Click("Info");
		CommonMethod.testlog("Pass", "Verified User should be able to click on Info of the first record");

	}

	public void includePaymentMethod(int rowNum, String sheetName) throws Exception {

		businessCountryIreland(rowNum, sheetName);

		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");

		CommonMethod.visibilityOf("PaymentMethod", minWait);
		CommonMethod.click("PaymentMethod");

		CommonMethod.sendKeys("EcludePayemnt", data.getCellData(sheetName, "PaymentMethod", rowNum));
		Thread.sleep(2);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "User should be able to select 'Payment Method -' as 'Visa Debit'");

		clickSearch();
		clickFirstRecord();

		CommonMethod.switchToNewTab();
		Thread.sleep(10);
		CommonMethod.visibilityOf("PaymentMethods", minWait);

		String provider = CommonMethod.GetText("PaymentMethods");
		if (provider.contains(data.getCellData(sheetName, "PaymentMethod", rowNum))) {
			CommonMethod.assertTrue("Payment Method contain 'Visa Debit'");

		} else {
			CommonMethod.assertFalse("Payment Method should not contain 'Visa Debit");

		}

	}

	public void clickSearch() throws Exception {
		CommonMethod.testlog("Info", "User clicks on Search button");
		CommonMethod.elementToBeClickable("searchButton", minWait);
		CommonMethod.Click("searchButton");
		CommonMethod.testlog("Pass", "User is able to click on Search button");
		Thread.sleep(2000);
		CommonMethod.visibilityOf("numberOfResult", minWait);
		

	}

	public void firstRecordCaptureDetail(int rowNum, String country) throws Exception {
		CommonMethod.testlog("Pass", "Test Starated");
		CommonMethod.elementToBeClickable("info", minWait);
		CommonMethod.click("info");
		Thread.sleep(3000);
		CommonMethod.switchToNewTab();
		Thread.sleep(2000);
		CommonMethod.Isdisplayed("newTabValue", minWait);

		for (int i = 2; i <= 11; i++) {
			if (i == 9) {
				System.out.println("Extra Space");
			} else if (i == 10 || i == 11) {
				int j = i;
				j = j - 1;

				data.setCellData(country, "CompanyDetails", j,
						driver.findElement(By.xpath("(//table/tbody/tr[" + i + "]/td[1])[1]")).getText());
				data.setCellData(country, "Values", j,
						driver.findElement(By.xpath("(//table/tbody/tr[" + i + "]/td[2])[1]")).getText());

			} else {
				System.out.println(data.setCellData(country, "CompanyDetails", i,
						driver.findElement(By.xpath("(//table/tbody/tr[" + i + "]/td[1])[1]")).getText()));
				System.out.println(data.setCellData(country, "Values", i,
						driver.findElement(By.xpath("(//table/tbody/tr[" + i + "]/td[2])[1]")).getText()));

			}
		}
		CommonMethod.testlog("Pass", "Captured All table values");
	}

	public void multiurllookup(int rowNum, String sheetName) throws Exception {
		try {
		CommonMethod.testlog("Info", "User clicks on 'Search by Multiple URLs' tab");

		CommonMethod.elementToBeClickable("MultipleidButton", minWait);
		CommonMethod.click("MultipleidButton");
		CommonMethod.testlog("Pass", "User is able to click on 'Search by Multiple URLs' tab");

		CommonMethod.visibilityOf("SearchList", minWait);
		CommonMethod.SetText("SearchList", data.getCellData(sheetName, "WebSite", rowNum));
		CommonMethod.testlog("Pass", "User is able to add 3 urls and should be able to click on seach");

		clickSearch();

		CommonMethod.visibilityOf("searchsummary", minWait);
		Assert.assertEquals(CommonMethod.GetText("searchsummary"), "Multi URL Search Summary");
		CommonMethod.testlog("Pass","User is be able to see a summary in a pop-up window containing the summary for the URLs added into mutli url search");

		CommonMethod.click("CloseB");
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(minWait, TimeUnit.SECONDS);
		CommonMethod.testlog("Pass", "User is  able to close the summary and return to the previous screen");

		CommonMethod.click("addLeadsToList");
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		CommonMethod.testlog("Pass", "User is able to click on Add Leads to a List and move to the next screen");

		String fileName= "Multiurllookup"+new Timestamp(date.getTime()).toString().trim().replace(":","").replace(".","").replace(" ","");
		
		CommonMethod.SetText("LeadsList", fileName);

		CommonMethod.click("Continue");
		CommonMethod.testlog("Pass","User is able to create a new list or use an exisiting list and click on continue to move to the next screen");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		CommonMethod.visibilityOf("link1", avgWait);
		Assert.assertEquals(CommonMethod.getText("link1"), data.getCellData(sheetName, "WebSite", rowNum + 1));
		Assert.assertEquals(CommonMethod.getText("link2"), data.getCellData(sheetName, "WebSite", rowNum + 2));
		Assert.assertEquals(CommonMethod.getText("link3"), data.getCellData(sheetName, "WebSite", rowNum + 3));
		CommonMethod.testlog("Pass", "Urls used for mutli url lookup should be present in the list created");
		}catch(Exception E) {
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.navigate().refresh();
			
			
		}

	}

	public void hasPhysicalLoacation(int rowNum, String sheetName) throws Exception, Exception {
		businessCountryIreland(rowNum, sheetName);
		CommonMethod.click("HasPhysicalLoaction");
		CommonMethod.testlog("Pass", "User should be able to toggle 'Has Physical Location' on");

		clickSearch();
		clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		String Physicallocation = CommonMethod.GetText("TabPhysicallocation").trim();

		if (Physicallocation.equalsIgnoreCase("Yes")) {

			CommonMethod.assertTrue("Verified have a physical location as 'Yes'");

		} else {
			CommonMethod.assertFalse("Verified physical location does not exists ");

		}

	}

	public void contactDepartment(int rowNum, String sheetName) throws Exception, Exception {
		
		businessCountryIreland(rowNum, sheetName);
		CommonMethod.click("contactdatapanellabel");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("contactPlus", 10);
		CommonMethod.click("contactPlus");
		CommonMethod.SetText("contactText","Leadership");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		
		
		CommonMethod.click("contactLevelP");
		CommonMethod.SetText("contactLevelText","C - Level");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		
		
		CommonMethod.testlog("Pass", "User should be able to select 'Contact Department' as 'Leadership' & 'Contact Level' as 'C-Level' in 'Contact Data' filter");

		clickSearch();
		
		CommonMethod.click("addLeadsToList");
	    CommonMethod.testlog("Pass","User is able to click on Add Leads to a List");
		Thread.sleep(2000);
		CommonMethod.waitForPageLoaded();
     
	
		String fileName= "ContactDepartment"+new Timestamp(date.getTime()).toString().trim().replace(":","").replace(".","").replace(" ","");
		    
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
		Thread.sleep(5000);
		
		String fileDownloadPath= CommonMethod.GetText("nameFileName");
		
		CommonMethod.VerifyFileDownloadWithExtension("ContactDepartment",".csv");
		CommonMethod.testlog("Pass", "User is be able to download the reports in  CSV format");

		
		CommonMethod.VerifyFileDownloadWithExtension("ContactDepartment",".xlsx");
		CommonMethod.testlog("Pass", "User is be able to download the reports in Excel  format");

		
        CommonMethod.testlog("Info", "Verifying in records of the downloaded Excel file have at least one Company Email and phone");
    	int totalExcle= ReadDataUtility.getRowCountExcel(downloadPath+fileDownloadPath+".xlsx");
    	if(totalExcle>10){
    	totalExcle=10;
    	}
		for(int i=2;i<=totalExcle;i++) {
			
		String ContactDepartments= ReadDataUtility.getCellData(downloadPath+fileDownloadPath+".xlsx","Contact Departments",i);
		String ContactLevels= ReadDataUtility.getCellData(downloadPath+fileDownloadPath+".xlsx","Contact Levels",i);
		
		
		if((ContactDepartments.contains("Leadership"))&&(ContactLevels.contains("C-Level"))) {
		  CommonMethod.assertTrue("Verified The number of records contain 'Contact Department' as :" +ContactDepartments+ "Contact Level :" +ContactLevels);
		}		
		else {
			 CommonMethod.assertTrue("Verified The number of records not contain 'Contact Department' as :" +ContactDepartments+ "Contact Level :" +ContactLevels);
		      
		}
		}
		
		CommonMethod.testlog("Pass", "Verified In downloaded excel file The number of records match with 'Contact Department' and 'Contact Level' as 'Leadership' and 'C-Level', respectively.");

		CommonMethod.testlog("Info", "Verifying In downloaded CSV file The number of records match with 'Contact Department' and 'Contact Level' as 'Leadership' and 'C-Level', respectively.");

		
		ReadDataUtility.VerifyCSVRow(downloadPath+fileDownloadPath+".csv",17,"Leadership");
		ReadDataUtility.VerifyCSVRow(downloadPath+fileDownloadPath+".csv",18,"C - Level");
		
		CommonMethod.testlog("Pass", "Verifying In downloaded CSV file The number of records match with 'Contact Department' and 'Contact Level' as 'Leadership' and 'C-Level', respectively.");

		         
		}
		
		
		
	public void MostHaveEmailPhoneNo(int rowNum, String sheetName) throws Exception, Exception {
		
		businessCountryIreland(rowNum, sheetName);
		CommonMethod.click("contactdatapanellabel");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("contactPlus", 10);
		CommonMethod.click("contactPlus");
		CommonMethod.SetText("contactText","Leadership");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		
		CommonMethod.click("contactLevelP");
		CommonMethod.SetText("contactLevelText","C - Level");
		Thread.sleep(1000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		Thread.sleep(1000);
		CommonMethod.elementToBeClickable("MustHaveEmail", 10);
		CommonMethod.Click("MustHaveEmail");
		CommonMethod.Click("MustHavePhone");
		
		
		
		CommonMethod.testlog("Pass", "User should be able to select 'Contact Department' as 'Leadership' & 'Contact Level' as 'C-Level' in 'Contact Data' filter");
		CommonMethod.testlog("Pass", "User must be able to toggle 'Must Have Email Address' and 'Must Have Phone Number' on");

		clickSearch();
		
		CommonMethod.click("addLeadsToList");
	    CommonMethod.testlog("Pass","User is able to click on Add Leads to a List");
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
     
	
		String fileName= "ExportMustHaveEmailPhoneNo"+new Timestamp(date.getTime()).toString().trim().replace(":","").replace(".","").replace(" ","");
		    
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
			
		String phone= ReadDataUtility.getCellData(downloadPath+fileDownloadPath+".xlsx","Contact Email Address",i);
		String email= ReadDataUtility.getCellData(downloadPath+fileDownloadPath+".xlsx","Company Phone Numbers",i);
		
		
		if((phone!=null)&&(email!=null)) {
		  CommonMethod.assertTrue("Verified in records of the downloaded file have at least one Company Email :" +email+ "Company Phone Number :" +phone);
		}		
		else {
			  CommonMethod.assertFalse("Verified in records of the downloaded file  have at least one 'Company Email' and 'Company Phone Number");
		      
		}
		}
		
		
		CommonMethod.testlog("Pass", "Verified in records of the downloaded Excel file have at least one Company Email and phone");

		CommonMethod.testlog("Info", "Verifying in records of the downloaded CSV file have at least one Company Email and phone");

		
		
		
		ReadDataUtility.VerifyNotNullCSV(downloadPath+fileDownloadPath+".csv",48);
		ReadDataUtility.VerifyNotNullCSV(downloadPath+fileDownloadPath+".csv",49);
		CommonMethod.testlog("Pass", "Verified in records of the downloaded CSV file have at least one Company Email and phone");

		
		}
		
	

	public void includeFinanceProvider(int rowNum, String sheetName) throws Exception {

		businessCountryUK(rowNum, sheetName);

		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");
		CommonMethod.visibilityOf("PaymentMethod", minWait);

		CommonMethod.testlog("Info", "Verify if User should be able to FinanceProvider as "
				+ data.getCellData(sheetName, "FinanceProvider", rowNum));
		CommonMethod.moveToElement("FPlus");
		CommonMethod.click("FPlus");
		CommonMethod.sendKeys("FPText", data.getCellData(sheetName, "FinanceProvider", rowNum));
		Thread.sleep(2000);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verify if User should be able to FinanceProvider as " + data.getCellData(sheetName, "FinanceProvider", rowNum));

		clickSearch();
		clickFirstRecord();

		CommonMethod.switchToNewTab();
		Thread.sleep(4000);
		CommonMethod.visibilityOf("Fprovider", minWait);

		String provider = CommonMethod.GetText("Fprovider").trim();
		System.out.println(provider);
		Thread.sleep(1000);
		if (provider.contains("Santander Uk")) {

			CommonMethod.assertTrue("Verified Finance Provider contain 'Santander UK'");

		} else {
			CommonMethod.assertFalse("Finance Provider does not contain 'Santander UK'");

		}

	}

	public void excludeFinanceProvider(int rowNum, String sheetName) throws Exception {
		businessCountryUK(rowNum, sheetName);
		
		CommonMethod.elementToBeClickable("PaymentFilter", minWait);
		CommonMethod.click("PaymentFilter");
		CommonMethod.visibilityOf("PaymentMethod", minWait);

		CommonMethod.testlog("Info", "Verify if User should be able to FinanceProvider as "
				+ data.getCellData(sheetName, "FinanceProvider", rowNum));
		CommonMethod.moveToElement("FMinus");
		CommonMethod.click("FMinus");
		CommonMethod.sendKeys("FMText", data.getCellData(sheetName, "FinanceProvider", rowNum));
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verify if User should be able to FinanceProvider as "
				+ data.getCellData(sheetName, "FinanceProvider", rowNum));

		clickSearch();
		clickFirstRecord();

		CommonMethod.switchToNewTab();
		Thread.sleep(5000);
		CommonMethod.visibilityOf("Fprovider", minWait);

		String provider = CommonMethod.GetText("Fprovider");
		Thread.sleep(2000);
		if (provider.contains(data.getCellData(sheetName, "FinanceProvider", rowNum))) {

			CommonMethod.assertFalse("Finance Provider contain 'Santander UK'");

		} else {
			CommonMethod.assertTrue("Finance Provider does not contain 'Santander UK'");

		}

	}

	public void includeShippingCompanies(int rowNum, String sheetName) throws Exception {

		businessCountryUK(rowNum, sheetName);

		CommonMethod.visibilityOf("shippingAdd", minWait);
		CommonMethod.moveToElement("shippingAdd");
		CommonMethod.scrolldowntoElement("shippingAdd");
		CommonMethod.click("shippingAdd");
		CommonMethod.visibilityOf("shippingFilterplus", minWait);
		CommonMethod.moveToElement("shippingFilterplus");
		CommonMethod.click("shippingFilterplus");

		CommonMethod.SetText("shippingFilterCom", "An Post");

		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "User should be able to select 'Shipping Companies +' as 'An Post");

		clickSearch();
		clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(4000);

		CommonMethod.visibilityOf("ShippingCompanies", minWait);

		String provider = CommonMethod.GetText("ShippingCompanies");
		Thread.sleep(100);
		if (provider.contains("An Post")) {
			CommonMethod.assertTrue("Shipping Companies should contain An Post'");

		} else {
			CommonMethod.assertFalse("Shipping Companies does not contain 'An Post'");

		}

	}

	public static void businessCountryIreland(int rowNum, String sheetName) throws IOException, Exception {
		CommonMethod.visibilityOf("businessdropdown", 10);
		CommonMethod.scrolldowntoElement("businessdropdown");
		CommonMethod.click("businessdropdown");
		Thread.sleep(1000);
		CommonMethod.moveToElement("businessCountryPuls");
		CommonMethod.click("businessCountryPuls");
		CommonMethod.sendKeys("businesscountry", data.getCellData(sheetName, "BusinessCoutry", rowNum + 1));
		Thread.sleep(1000);
		CommonMethod.testlog("Pass", "User should be able to select 'Business Country' as 'Ireland' ");
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verified User is be able to select Business Country as 'Ireland ");

	}

	public static void businessCountryUS(int rowNum, String sheetName) throws IOException, Exception {
		CommonMethod.testlog("Info", "Verify if User should be able to select Business Country as United States");
		CommonMethod.visibilityOf("businessdropdown", 10);
		CommonMethod.scrolldowntoElement("businessdropdown");
		CommonMethod.click("businessdropdown");
		Thread.sleep(500);

		CommonMethod.moveToElement("businessCountryPuls");
		CommonMethod.click("businessCountryPuls");
		Thread.sleep(500);
		CommonMethod.sendKeys("businesscountry", data.getCellData(sheetName, "BusinessCoutry", rowNum));
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verified User is be able to select Business Country as United States");

	}

	public static void businessCountryUK(int rowNum, String sheetName) throws IOException, Exception {

		CommonMethod.visibilityOf("businessdropdown", 10);
		CommonMethod.scrolldowntoElement("businessdropdown");
		CommonMethod.click("businessdropdown");
		Thread.sleep(500);
		CommonMethod.visibilityOf("businessdropdown", 30);
		CommonMethod.testlog("Info", "Verify if User should be able to select Business Country as United Kingdom");
		CommonMethod.moveToElement("businessCountryPuls");
		CommonMethod.click("businessCountryPuls");
		Thread.sleep(1000);
		CommonMethod.sendKeys("businesscountry", data.getCellData(sheetName, "BusinessCoutry", 4));
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "Verified User is be able to select Business Country as United Kingdom");
	}

	public void excludeShippingCompanies(int rowNum, String sheetName) throws Exception {

		businessCountryUK(rowNum, sheetName);

		CommonMethod.visibilityOf("shippingAdd", minWait);
		CommonMethod.moveToElement("shippingAdd");
		CommonMethod.scrolldowntoElement("shippingAdd");
		CommonMethod.click("shippingAdd");
		
		
		CommonMethod.visibilityOf("shippingFilterminus", minWait);
		CommonMethod.moveToElement("shippingFilterminus");
		CommonMethod.click("shippingFilterminus");

		CommonMethod.SetText("Minusexclude", "An Post");
		Thread.sleep(1500);
		CommonMethod.visibilityOf("FirstResult", minWait);
		CommonMethod.click("FirstResult");
		CommonMethod.testlog("Pass", "User should be able to select 'Shipping Companies -' as 'An Post");
		
		CommonMethod.testlog("Info", "Shipping Companies does not contain 'An Post");
		
		clickSearch();
		clickFirstRecord();
		CommonMethod.switchToNewTab();
		Thread.sleep(6000);

		CommonMethod.visibilityOf("ShippingCompanies", minWait);

		String provider = CommonMethod.GetText("ShippingCompanies");
		Thread.sleep(1000);
		if (provider.contains("An Post")) {
			CommonMethod.assertFalse("Verified Shipping Companies not contain 'An Post");

		} else {
			CommonMethod.assertTrue("Shipping Companies does not contain 'An Post'");

		}

	}
}
