package Pages;


import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.BrowserFactory;
import Utilities.ConfigData;
import Utilities.ExcelDataProvider;
import Utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ConfigData config; 
	public ExcelDataProvider TestData;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetUpSuite() {
		
		Reporter.log("Test requirements are gathering and test is ready", true);
		config = new ConfigData();
		TestData = new ExcelDataProvider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/sc_"+Helper.getCurrentDate()+".html")); 
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void SetUp() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser() , config.getUrl());
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult Result) throws InterruptedException {
		Reporter.log("capturing sc", true);
		Thread.sleep(2000);
		if (Result.getStatus() == ITestResult.FAILURE ) {
			System.out.println("HI");
		}else if (Result.getStatus() == ITestResult.SUCCESS){
			System.out.println("Bye");
			logger.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Reports generated succssfully", true);
//		Helper.CaptureScreenshot(driver);
	}
	
	
}
