package com.mytravels.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mytravels.base.Base;


public class HomepagePage extends Base {
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	
	public HomepagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnLoginLink() {
		login.click();
		return new LoginPage();
		 
	}
}
