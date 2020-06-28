package com.mytravels.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mytravels.base.Base;


public class LoginPage extends Base {
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[text()=\"Sign In\"]")
	WebElement LoginBtn;
	

	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String getLoginPageTitle() {
		return driver.getTitle();

	}
	
	public DashboardPage loginsuccess(String mail,String pswrd) {
	email.sendKeys(mail);
	password.sendKeys(pswrd);
	LoginBtn.click();
	return new DashboardPage();
	}


}
