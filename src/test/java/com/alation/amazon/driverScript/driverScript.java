package com.alation.amazon.driverScript;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.alation.amazon.actions.bookSearch;
import com.alation.amazon.actions.signIn;
import com.alation.amazon.scripts.Browser;
import com.alation.amazon.scripts.Constant;
import com.alation.amazon.scripts.ExtentManager;
import com.alation.amazon.scripts.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class driverScript {

	public static WebDriver driver = null;
	protected static ExtentReports extent;
	protected ExtentTest test;

	public static WebDriver getDriver() {
		if (driver == null) {
			Browser br = new Browser(Constant.browserName);
			driver = br.initBrowser();
		}
		return driver;
	}

	public static ExtentReports getExtent() {
		if (extent == null) {
			extent = ExtentManager.getReporter(Constant.extentReportPath + "AutomationReport.html");
		}
		return extent;
	}

	@BeforeSuite
	public void setUpSuite() throws Exception {

		// Initializing Extent Report and setting the Extent Report path

		// Initializing the driver
		driver = driverScript.getDriver();
		extent = driverScript.getExtent();
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
	public void searchBook() throws Exception {
		test = extent.startTest("Verification of Data catalog books in Books Category", "Data Catalog in Books");
		bookSearch newBookSearch = new bookSearch();
		newBookSearch.navigateToHomePage();
		newBookSearch.searchBook("Books", "Data catalog");
		newBookSearch.loadbookInformation();
		Log.endTestCase("End of Test case");

	}

	@Test(priority = 2)
	public void loginAndSearchBook() throws Exception {
		Log.startTestCase("Login and verification of Data catalog books in Books Category");
		test = extent.startTest("Login and verification of Data catalog books in Books Category", "Data Catalog in Books");
		bookSearch newSearch = new bookSearch();
		newSearch.navigateToHomePage();
		newSearch.navigateToLoginPage();;
		signIn newlogin = new signIn();
		newlogin.performLogin("testamazon123@mailinator.com", "AmazonTest@1");
		newSearch.searchBook("Books", "Data catalog");
		newSearch.loadbookInformation();

	}

}
