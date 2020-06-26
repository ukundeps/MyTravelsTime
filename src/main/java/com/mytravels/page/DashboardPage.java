package com.mytravels.page;

import org.openqa.selenium.support.PageFactory;

import com.mytravels.keyword.Keyword;

public class DashboardPage extends Keyword{
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
