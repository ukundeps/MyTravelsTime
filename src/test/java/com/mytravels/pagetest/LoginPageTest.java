package com.mytravels.pagetest;

import java.io.IOException;

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
import com.mytravels.page.DashboardPage;
import com.mytravels.page.HomepagePage;
import com.mytravels.page.LoginPage;

@Listeners(com.mytravels.listener.Listener.class)
public class LoginPageTest extends LoginPage{
	
	HomepagePage home;
	LoginPage login;
	DashboardPage dashboard;
	
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
		home=new HomepagePage();
		login=new LoginPage();
		dashboard=new DashboardPage();
		launchURL();

	}

	// Usability Testing

	@Test(description = "To verify title of LoginPage", groups = "Usability Testing")
	public void verify_loginpage_Title() {
		extentLog = extent.createTest("VerifyLoginpage Title");
		home.clickOnLoginLink();
		String title=login.getLoginPageTitle();
		
		Assert.assertEquals(title, "CRM",
				"Loginpage Title not matched!!");
		
		
	}
	
	@Test(description = "To verify successful login", groups = "Usability Testing")
	public void verify_successful_login() {
		extentLog = extent.createTest("Verify Successfull Login");
		home.clickOnLoginLink();
		dashboard=login.loginsuccess("sushanttayade123@gmail.com", "sushant.123");
		
		Assert.assertEquals(dashboard.getUsername(), "Sushant Tayade", "Username not matching");
		
	}
	
	
	
	
	
	
	@AfterMethod
	public static void tearDown(ITestResult result) throws IOException{
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
