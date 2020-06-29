package com.mytravels.pagetest;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mytravels.page.HomepagePage;

@Listeners(com.mytravels.listener.Listener.class)
public class HomepagePageTest extends HomepagePage {

	HomepagePage home;
	Logger log = Logger.getLogger(HomepagePageTest.class);
	
	@BeforeTest
	public void extendReportConfig() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/MyTravelsExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Priya PC");
		extent.setSystemInfo("User Name", "Priya Ukunde");
		extent.setSystemInfo("Environment", "QA");
	}
	@BeforeMethod
	public void setUp() {
		openBrowserAnConfigure();
		home = new HomepagePage();
		launchURL();

	}

	// Usability Testing

	@Test(description = "To verify title of homepage", groups = "Usability Testing")
	public void verify_Homepage_Title() {
		extentLog = extent.createTest("Verify Homepage Title");
		Assert.assertEquals(getTitle(), "My Travels Time - CRM2" ,"Homepage Title not matched!!");

	}

	@AfterMethod
	public static void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentLog.log(Status.FAIL, "Failed TestCase: " + result.getName());
			String failedTCScreenshotPath = screenshotforExtentReport(driver, result.getName());
			extentLog.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(failedTCScreenshotPath).build());
		}	else if (result.getStatus() == ITestResult.SUCCESS) {
				extentLog.log(Status.PASS, "Passed TestCase: " + result.getName());
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentLog.log(Status.PASS, "Skipped  TestCase: " + result.getName());
			
		}
		extent.flush();
	closeBrowserWindow();
	}

}
