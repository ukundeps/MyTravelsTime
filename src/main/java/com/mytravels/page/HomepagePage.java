package com.mytravels.page;

import org.openqa.selenium.support.PageFactory;

import com.mytravels.keyword.Keyword;

public class HomepagePage extends Keyword {
	public HomepagePage() {
		PageFactory.initElements(driver, this);
	}
}
