package com.mytravels.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mytravels.base.Base;

public class DashboardPage extends Base{
	
	@FindBy(xpath="//a[@id=\"navbarDropdown\"]")
	WebElement username;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	


	public String getUsername() {
		
		return username.getText();
	}
}
