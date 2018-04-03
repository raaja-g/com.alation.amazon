package com.alation.amazon.driverScript;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.alation.amazon.scripts.Browser;
import com.alation.amazon.scripts.Constant;
import com.alation.amazon.scripts.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class driverScript {

	public WebDriver driver = null;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void setUpSuite() throws Exception {

		// Initializing Extent Report and setting the Extent Report path
		extent = ExtentManager.getReporter(Constant.extentReportPath + "AutomationReport.html");

		// Initializing Browser
		// Browser will initialize the logger
		Browser br = new Browser(Constant.browserName);
		driver = br.initBrowser();

	}

	@AfterSuite
	public void tearDownbrowser() {

		// Closing the extent report
		extent.close();

		// Closing the driver / Browser.
		driver.quit();
	}

	@AfterMethod
	protected void afterMethod(ITestResult result) {

		// Getting the test status ie. Pass, Fail and Skip.
		// Logging the status in the extent report result
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed");
		}

		// Ending the Extent test after updating the status.
		extent.endTest(test);

		// Flushing the result to the extent report
		extent.flush();
	}

	// Start of the test and assigning the priority to the test case.
	@Test(priority = 1)
	public void Logon1() throws Exception {
		test = extent.startTest("Verification of Data catalog books in Books Category", "Data Catalog in Books");
		driver.get(Constant.URL);

	}

}
