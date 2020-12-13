package TestReport;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCasesReports {
	
	ExtentTest test;
	ExtentReports reports;
	ExtentSparkReporter sparkreports;
	
	@BeforeMethod
	
	public void intitialization()
	{
	 reports = new ExtentReports();
	 sparkreports = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\");
	 test = reports.createTest("TestCasesReports");
	}
	
	@AfterMethod
	public void quit()
	{
		reports.flush(); //Generate the Report
	}
	
	@Test
	public void loginTest()
	
	{
		sparkreports.config().setReportName("Regression Test Results");
		sparkreports.config().setDocumentTitle("Automation Reports");
		sparkreports.config().setTheme(Theme.DARK);
		sparkreports.config().setEncoding("utf-8");
		
		reports.attachReporter(sparkreports);
		
		test.log(Status.INFO, "Starting the Test Case");
		test.log(Status.INFO, "Opening the Browser");
		test.log(Status.INFO, "Login the Application");
		Assert.fail("400 error encountered");
		test.log(Status.PASS, "Test Case got passed");
		
	}

}
