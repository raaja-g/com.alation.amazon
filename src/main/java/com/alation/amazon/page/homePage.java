package com.alation.amazon.page;

import org.openqa.selenium.By;

import com.alation.amazon.scripts.Constant;
import com.alation.amazon.scripts.browserAction;

public class homePage extends browserAction {

	private final By signInButton = By.xpath("//span[.='Hello. Sign in']");

	public homePage() {
	}

	public void navigateToHomePage() {
		String url = Constant.URL;
		navigateToURL(url);
	}

	public void navigateToLoginPage() {
		navigateToURL(Constant.URL);
		boolean success = true;
		click(signInButton);
		String pageTitle = getPageTitle();
		if (pageTitle.equals("Amazon Sign In")) {
			success = true;
		} else {
			success = false;
		}
	}
}
