package com.salesoptimize.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class CustomTestNGReporter implements IReporter {
	
	//This is the customize emailabel report template file path.
	private static final String emailableReportTemplateFile = System.getProperty("user.dir")+"/src/test/java/com/salesoptimize/utility/Html-emailable-templete.html";
	private BufferedReader br;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		try
		{
			// Get content data in TestNG report template file.
			String customReportTemplateStr = this.readEmailabelReportTemplate();
			
			// Create custom report title.
			String customReportTitle = this.getCustomReportTitle("SalesOptimize_Report");
			
			// Create test suite summary data.
			String customSuiteSummary = this.getTestSuiteSummary(suites);
			
			// Create test methods summary data.
			String customTestMethodSummary = this.getTestMehodSummary(suites);
			
			// Replace report title place holder with custom title.
			customReportTemplateStr = customReportTemplateStr.replace("$TestNG_Custom_Report_Title$", customReportTitle);
			
			// Replace test suite place holder with custom test suite summary.
			customReportTemplateStr = customReportTemplateStr.replace("$Test_Case_Summary$", customSuiteSummary);
			
			// Replace test methods place holder with custom test method summary.
			
			customReportTemplateStr = customReportTemplateStr.replace("$Test_Case_Detail$", customTestMethodSummary);
			//customReportTemplateStr = customReportTemplateStr.replaceAll("\\$Test_Case_Detail\\$", customTestMethodSummary);
			
			// Write replaced test report content to custom-emailable-report.html.
			File targetFile = new File(System.getProperty("user.dir")+"/Reports/custom-emailable-report.html");
			FileWriter fw = new FileWriter(targetFile);
			fw.write(customReportTemplateStr);
			fw.flush();
			fw.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/* Read template content. */
	private String readEmailabelReportTemplate()
	{
		StringBuffer retBuf = new StringBuffer();
		
		try {
		
			File file = new File(CustomTestNGReporter.emailableReportTemplateFile);
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line!=null)
			{
				retBuf.append(line);
				line = br.readLine();
			}
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}finally
		{
			return retBuf.toString();
		}
	}
	
	/* Build custom report title. */
	private String getCustomReportTitle(String title)
	{
		StringBuffer retBuf = new StringBuffer();
		retBuf.append(title + " " + this.getDateInStringFormat(new Date()));
		return retBuf.toString();
	}
	
	/* Build test suite summary data. */

	private String getTestSuiteSummary(List<ISuite> suites)
	{
		StringBuffer retBuf = new StringBuffer();
		
		try
		{
			int totalTestCount = 0;
			int totalTestPassed = 0;
			int totalTestFailed = 0;
			int totalTestSkipped = 0;
			
			for(ISuite tempSuite: suites)
			{
				//retBuf.append("<tr><td colspan=11><center><b>" + tempSuite.getName() + "</b></center></td></tr>");
				
				Map<String, ISuiteResult> testResults = tempSuite.getResults();
				
				for (ISuiteResult result : testResults.values()) {
					
					retBuf.append("<tr>");
					
					ITestContext testObj = result.getTestContext();
					
					totalTestPassed = testObj.getPassedTests().getAllMethods().size();
					totalTestSkipped = testObj.getSkippedTests().getAllMethods().size();
					totalTestFailed = testObj.getFailedTests().getAllMethods().size();
					
					totalTestCount = totalTestPassed + totalTestSkipped + totalTestFailed;
					
					/* Test name. */
					/*retBuf.append("<td>");
					retBuf.append(testObj.getName());
					retBuf.append("</td>");
				*/	
					/* Total method count. */
					retBuf.append("<td bgcolor=d8fdd8>");
					retBuf.append(totalTestCount);
					retBuf.append("</td>");
					
					/* Passed method count. */
					retBuf.append("<td bgcolor=#90ee90>");
					retBuf.append(totalTestPassed);
					retBuf.append("</td>");
					
					/* Skipped method count. */
					retBuf.append("<td bgcolor=CCFF33>");
					retBuf.append(totalTestSkipped);
					retBuf.append("</td>");
					
					/* Failed method count. */
					retBuf.append("<td bgcolor=#ff7f7f>");
					retBuf.append(totalTestFailed);
					retBuf.append("</td>");
					
					FileInputStream confi = new FileInputStream(System.getProperty("user.dir")+"/Env/Config.properties");
					
					Properties prop = new Properties();		
					prop.load(confi);
					
					String environment = prop.getProperty("environment");
					String browserName = prop.getProperty("browserName");
					
					/* Get browser type. */
					/*String browserType = tempSuite.getParameter("browserType");
					if(browserName==null || browserType.trim().length()==0)
					{
						browserType = "Chrome";
					}*/
					
					/* Append browser type. */
					retBuf.append("<td bgcolor=d8fdd8>");
					retBuf.append(browserName.substring(0,6).toUpperCase());
					retBuf.append("</td>");
					
					retBuf.append("<td bgcolor=d8fdd8>");
					retBuf.append(environment.substring(0,7).toUpperCase());
					retBuf.append("</td>");
					
					
					/* Start Date*/
					Date startDate = testObj.getStartDate();
					retBuf.append("<td bgcolor=d8fdd8>");
					retBuf.append(this.getDateInStringFormat(startDate));
					retBuf.append("</td>");
					
					/* End Date*/
					Date endDate = testObj.getEndDate();
				
					retBuf.append("<td bgcolor=d8fdd8>");
					retBuf.append(this.getDateInStringFormat(endDate));
					retBuf.append("</td>");
					
					/* Execute Time */
					long deltaTime = endDate.getTime() - startDate.getTime();
					String deltaTimeStr = this.convertDeltaTimeToString(deltaTime);
					retBuf.append("<td bgcolor=d8fdd8>");
					retBuf.append(deltaTimeStr);
					retBuf.append("</td>");
					
					/* Include groups. */
					/*retBuf.append("<td>");
					retBuf.append(this.stringArrayToString(testObj.getIncludedGroups()));
					retBuf.append("</td>");
			*/		
					/* Exclude groups. */
				/*	retBuf.append("<td>");
					retBuf.append(this.stringArrayToString(testObj.getExcludedGroups()));
					retBuf.append("</td>");
		*/			
					retBuf.append("</tr>");
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			return retBuf.toString();
		}
	}

	/* Get date string format value. */
	private String getDateInStringFormat(Date date)
	{
		StringBuffer retBuf = new StringBuffer();
		if(date==null)
		{
			date = new Date();
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		retBuf.append(df.format(date));
		return retBuf.toString();
	}
	
	/* Convert long type deltaTime to format hh:mm:ss:mi. */
	private String convertDeltaTimeToString(long deltaTime)
	{
		StringBuffer retBuf = new StringBuffer();
		
		long milli = deltaTime;
		
		long seconds = deltaTime / 1000;
		
		long minutes = seconds / 60;
		
		long hours = minutes / 60;
		
		retBuf.append(hours + ":" + minutes + ":" + seconds);
		
		return retBuf.toString();
	}
	
	/* Get test method summary info. */

	private String getTestMehodSummary(List<ISuite> suites)
	{
		StringBuffer retBuf = new StringBuffer();
		
		try
		{
			for(ISuite tempSuite: suites)
			{
				//retBuf.append("<tr><td colspan=7><center><b>" + tempSuite.getName() + "</b></center></td></tr>");
				
				Map<String, ISuiteResult> testResults = tempSuite.getResults();
				
				for (ISuiteResult result : testResults.values()) {
					
					ITestContext testObj = result.getTestContext();

					String testName = testObj.getName();
					
					/* Get failed test method related data. */
					IResultMap testFailedResult = testObj.getFailedTests();
					String failedTestMethodInfo = this.getTestMethodReport(testName, testFailedResult, false, false);
					retBuf.append(failedTestMethodInfo);
					
					/* Get skipped test method related data. */
					IResultMap testSkippedResult = testObj.getSkippedTests();
					String skippedTestMethodInfo = this.getTestMethodReport(testName, testSkippedResult, false, true);
					retBuf.append(skippedTestMethodInfo);
					
					/* Get passed test method related data. */
					IResultMap testPassedResult = testObj.getPassedTests();
					Object passedTestMethodInfo = this.getTestMethodReport(testName, testPassedResult, true, false);
					retBuf.append(passedTestMethodInfo);
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			return retBuf.toString();
		}
	}
	
	/* Get failed, passed or skipped test methods report. */
	private String getTestMethodReport(String testName, IResultMap testResultMap, boolean passedReault, boolean skippedResult)
	{
		StringBuffer retStrBuf = new StringBuffer();
		
		String resultTitle ="";
		
		String color = "green";
		
		if(skippedResult)
		{
			resultTitle += "Skipped ";
			color = "yellow";
		}else
		{
			if(!passedReault)
			{
				resultTitle += "Failed ";
				color = "ffcccb";
			}else
			{
				resultTitle += "Passed ";
				color = "90ee90";
			}
		}
		
		//retStrBuf.append("<tr bgcolor=" + color + "><td colspan=7><center><b>" + resultTitle + "</b></center></td></tr>");
			
		Set<ITestResult> testResultSet = testResultMap.getAllResults();
			
		for(ITestResult testResult : testResultSet)
		{
			String testClassName = "";
			//String testMethodName = "";
			String startDateStr = "";
			String executeTimeStr = "";
			String paramStr = "";
			String reporterMessage = "";
			String description = "";
			String status = "";
			String exceptionMessage = "";
			testClassName = testResult.getMethod().getMethodName()+"Test";
			
			//Get testClassName
			//testClassName = testResult.getTestClass().getName();
				
			//Get testMethodName
			//testMethodName = testResult.getMethod().getMethodName();
			
			
				
			//Get startDateStr
			long startTimeMillis = testResult.getStartMillis();
			startDateStr = this.getDateInStringFormat(new Date(startTimeMillis));
				
			//Get Execute time.
			long deltaMillis = testResult.getEndMillis() - testResult.getStartMillis();
			executeTimeStr = this.convertDeltaTimeToString(deltaMillis);
			
			description = testResult.getMethod().getDescription();
				
			//Get parameter list.
			Object paramObjArr[] = testResult.getParameters();
			for(Object paramObj : paramObjArr)
			{
				paramStr += paramObj.toString();
				paramStr += " ";
			}
				
			//Get reporter message list.
			List<String> repoterMessageList = Reporter.getOutput(testResult);
			for(String tmpMsg : repoterMessageList)				
			{
				reporterMessage += tmpMsg;
				reporterMessage += " ";
			}
				
			//Get exception message.
			Throwable exception = testResult.getThrowable();
			if(exception!=null)
			{
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				//exception.printStackTrace(pw);
				
				exceptionMessage = sw.toString();
			}
			
			retStrBuf.append("<tr bgcolor= #C0C0C0>");
			
			/* Add test class name. */
			retStrBuf.append("<td>");
			retStrBuf.append(testClassName);
			retStrBuf.append("</td>");
			
			/* Add test method name. */
			/*retStrBuf.append("<td>");
			retStrBuf.append(testMethodName);
			retStrBuf.append("</td>");*/
			
	/*		retStrBuf.append("<td>");
			retStrBuf.append(testName );
			retStrBuf.append("</td>");*/
			
			retStrBuf.append("<td bgcolor="+color +">");
			retStrBuf.append(resultTitle );
			retStrBuf.append("</td>");
			
			/* Add start time. */
		/*	retStrBuf.append("<td>");
			retStrBuf.append(startDateStr);
			retStrBuf.append("</td>");*/
			
			/* Add execution time. */
			 
			retStrBuf.append("<td bgcolor=#DAF7A6>");
			retStrBuf.append(executeTimeStr);
			retStrBuf.append("</td>");
			
			/* Add parameter. 
			retStrBuf.append("<td>");
			retStrBuf.append(paramStr);
			retStrBuf.append("</td>");*/
			
		/*	 Add reporter message. 
			retStrBuf.append("<td>");
			retStrBuf.append(reporterMessage);
			retStrBuf.append("</td>");
	*/		
			retStrBuf.append("<td>");
			retStrBuf.append(description);
			retStrBuf.append("</td>");
		
			
			
			/* Add exception message.
			retStrBuf.append("<td>");
			retStrBuf.append(exceptionMessage);
			retStrBuf.append("</td>"); */
			
			retStrBuf.append("</tr>");

		}
		
		return retStrBuf.toString();
	}
	
	private String stringArrayToString(String strArr[])
	{
		StringBuffer retStrBuf = new StringBuffer();
		if(strArr!=null)
		{
			for(String str : strArr)
			{
				retStrBuf.append(str);
				retStrBuf.append(" ");
			}
		}
		return retStrBuf.toString();
	}

}
