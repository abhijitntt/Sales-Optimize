package com.salesoptimize.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.salesoptimize.reusablemethods.ReusableMethodsDashboard;
import com.salesoptimize.reusablemethods.ReusableMethodsEvidence;
import com.salesoptimize.reusablemethods.ReusableMethodsLogin;
import com.salesoptimize.reusablemethods.ReusableMethodsNavigation;
import com.salesoptimize.reusablemethods.ReusableMethodsSocalMedia;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Logger log;
	public static WebDriver driver;
	public static XlsReader data;
	public static Properties prop;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static String Environment;
	public static String TestNGTestName;
	public static String ReportName;
	public static String TestCaseName;
	public static ThreadLocal<ExtentTest> testlog;
	public static int rownumber = 2;
	public static File extentconfigfile = new File(
	System.getProperty("user.dir") + "/ObjectRepository/extent-config.xml");
	public static String downloadPath = System.getProperty("user.dir") + File.separator + "Downloads" + File.separator;
	public static String screenshot = System.getProperty("user.dir") + File.separator + "Reports" + File.separator +"Screenshots"+File.separator;

	public static String baseURL;
	public static String username;
	public static String password;
	public static String SuiteName;
	public static WebDriverWait wait;
	public static int minWait = 15;
	public static int avgWait = 30;
	public static int maxWait = 60;
	public static String environment;
	public static String browserName;
	public static String navURL;
	public static ReusableMethodsNavigation navigation = new ReusableMethodsNavigation();
	public static ReusableMethodsLogin login = new ReusableMethodsLogin();
	public static ReusableMethodsDashboard dashboard = new ReusableMethodsDashboard();
	public static ReusableMethodsEvidence evidence = new ReusableMethodsEvidence();
	
	public static ReusableMethodsSocalMedia SocalMedia = new ReusableMethodsSocalMedia();
	


	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() throws Exception {
		data = new XlsReader(System.getProperty("user.dir") + "/TestData/SalesTest.xlsx");
		prop = new Properties();

		System.out.println(System.getenv("agentName"));

		FileInputStream confi = new FileInputStream(System.getProperty("user.dir") + "/Env/Config.properties");
		prop.load(confi);

		if ((System.getenv("browserName") != null && !System.getenv("browserName").isEmpty())

				&& System.getenv("environment") != null && !System.getenv("environment").isEmpty()) {

			browserName = System.getenv("browserName");
			environment = System.getenv("environment");

			System.out.println(browserName);
			System.out.println(environment);
			System.out.println(System.getProperty("os.name"));
			

		} else {

			browserName = prop.getProperty("browserName");
			environment = prop.getProperty("environment");

			System.out.println(browserName);
			System.out.println(environment);
			System.out.println(System.getProperty("os.name"));

		}

		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

			FirefoxProfile profile = new FirefoxProfile();

			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir",
					System.getProperty("user.dir") + File.separator + "Downloads" + File.separator);
			profile.setPreference("browser.download.downloadDir", downloadPath);
			profile.setPreference("browser.download.defaultFolder", downloadPath);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/excel");
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.closeWhenDone", true);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);

			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			/* option.addArguments("-headless"); */
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			
		
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			
			
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe");
			//ChromeOptions options = new ChromeOptions();
			/*
			 * options.addArguments("headless");
			 * options.addArguments("window-size=1200x600");
			 */// driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		// driver.manage().window().setSize(new
		// org.openqa.selenium.Dimension(1366,1280));
		driver.manage().timeouts().implicitlyWait(avgWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(avgWait, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(avgWait, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, avgWait);

		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir") + "/Env/Preprod.properties");
		FileInputStream file2 = new FileInputStream(System.getProperty("user.dir") + "/Env/Qas.properties");

		if (environment.equalsIgnoreCase("Preprod")) {
			prop.load(file1);
			baseURL = prop.getProperty("env");
			driver.get(baseURL);
			username = prop.getProperty("userName");
			password = prop.getProperty("Password");
			navURL = prop.getProperty("navURL");
			

			
		} else if (environment.equalsIgnoreCase("qas")) {
			prop.load(file2);
			baseURL = prop.getProperty("env");
			driver.get(baseURL);
			username = prop.getProperty("userName");
			password = prop.getProperty("Password");
			navURL = prop.getProperty("navURL");
			
			
		
		}

		Thread.sleep(3000);
		Object className = this.getClass().getName();
		log = LogManager.getLogger((String) className);
		cleanup();
		
	}

	@BeforeMethod
	public static ExtentReports ExtentReportConfig(ITestContext context) throws IOException {
		if (extent == null) {
			SuiteName = context.getCurrentXmlTest().getSuite().getName();
			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/Reports/SalesOptimize" + SuiteName + ".html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			htmlReporter.setAppendExisting(true);
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			extent.setSystemInfo("Host Name", caps.getPlatform().toString());
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Environment", environment.toUpperCase());
			extent.setSystemInfo("BrowserName", caps.getBrowserName() + caps.getVersion());
			extent.setSystemInfo("Company", "Sales_Optimize");
			extent.setAnalysisStrategy(AnalysisStrategy.TEST);
			htmlReporter.config().setChartVisibilityOnOpen(false);
			htmlReporter.config().setDocumentTitle("SalesOptimize Automation Testing Report");
			htmlReporter.config().setReportName("SalesOptimize Reports");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.loadXMLConfig(extentconfigfile);
		}
		return extent;
	}
	
	@BeforeTest
	public void login() throws Exception {
		//LoginSalesOptimizeTest.LoginSalesOptimize();
	}

	@AfterClass
	public static void reset() throws Exception {
		CommonMethod.switchToParentTab1();
	
		driver.navigate().to(navURL);
		CommonMethod.waitForPageLoaded();
		Thread.sleep(3000);
	    CommonMethod.visibilityOf("includePur", minWait);
		CommonMethod.Click("includePur");
		Thread.sleep(5);
		System.out.println("After Class");
		
	}
		
	
	@AfterSuite(alwaysRun = true)
	public void end() {
		driver.quit();
		System.out.println("EndSuite");
	}

	
	public void cleanup() {
		File path = new File(downloadPath);
	    File[] files = path.listFiles();
	    for (File file : files) {
	        System.out.println("Deleted filename :"+ file.getName());
	        file.delete();
	    }
	     path = new File(screenshot);
	    files = path.listFiles();
	    for (File file : files) {
	        System.out.println("Deleted filename :"+ file.getName());
	        file.delete();
	    }
	}
}
