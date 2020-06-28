package com.mytravels.pagetest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mytravels.page.DashboardPage;
import com.mytravels.page.HomepagePage;
import com.mytravels.page.LoginPage;

public class LoginPageTest extends LoginPage{
	
	HomepagePage home;
	LoginPage login;
	DashboardPage dashboard;
	
	
	
	@BeforeMethod
	public void setUp() {
		openBrowser();
		maxiBrowserWindow();
		home=new HomepagePage();
		login=new LoginPage();
		dashboard=new DashboardPage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	// Usability Testing

	@Test(description = "To verify title of LoginPage", groups = "Usability Testing")
	public void verify_loginpage_Title() {
		
		home.clickOnLoginLink();
		String title=login.getLoginPageTitle();
		
		Assert.assertEquals(title, "CRM",
				"Loginpage Title not matched!!");
		
		
	}
	
	@Test(description = "To verify successful login", groups = "Usability Testing")
	public void verify_successful_login() {
		home.clickOnLoginLink();
		dashboard=login.loginsuccess("sushanttayade123@gmail.com", "sushant.123");
		
		Assert.assertEquals(dashboard.getUsername(), "Sushant Tayade", "Username not matching");
		
	}
	
	
	
	
	
	
	@AfterMethod
	public static void tearDown(){
		closeBrowserWindow();
		
	}

}
