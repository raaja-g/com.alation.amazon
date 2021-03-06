package com.alation.amazon.pages;

import org.openqa.selenium.By;

import com.alation.amazon.scripts.Constant;
import com.alation.amazon.scripts.Log;
import com.alation.amazon.scripts.browserAction;

public class homePage extends browserAction {

	// Object added for sign-in button.
	// Change only the xpath, if there are changes to the objects.
	private final By signInButton = By.xpath("//span[.='Hello. Sign in']");

	public homePage() {
	}

	// Navigating to the Home page URL
	public void navigateToHomePage() {
		boolean success = false;
		String url = Constant.URL;
		navigateToURL(url);

		// Getting current URL to validate the navigated URL
		// Used currentUL from the browser to assert
		String navigatedURL = getCurrentURL();

		if (navigatedURL.equals(url)) {
			success = true;
			Log.info("Successfully Navigated to the Home Page");
		} else {
			success = false;
			Log.info("NOT Navigated to the Home Page");
		}
	}

	// Navigating to the Login page URL
	public void navigateToLoginPage() {
		navigateToURL(Constant.URL);
		boolean success = false;
		click(signInButton);

		// Getting page title to Assert the Login screen.
		String pageTitle = getPageTitle();

		// Checking whether we are navigating to the home page.
		// Used page title to assert.
		if (pageTitle.equals("Amazon Sign In")) {
			success = true;
			Log.info("Successfully Navigated to the Login Page");
		} else {
			success = false;
			Log.info("NOT Navigated to the Login Page");
		}
	}

}
