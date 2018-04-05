package com.alation.amazon.pages;

import org.openqa.selenium.By;

import com.alation.amazon.scripts.browserAction;

public class loginPage extends browserAction {

	// All the objects related to the page.
	// Any changes to the object we change it here.

	private final By userName = By.xpath("//*[@id='ap_email']");
	private final By password = By.xpath("//*[@id='ap_password']");
	private final By continueButton = By.xpath("//*[@id='continue']/span");
	private final By signInButton = By.className("a-button-primary");

	public loginPage() {
	}

	// We enter Username with this method.

	public void setuserName(String username) {
		sendKeys(userName, username);
	}

	// We enter Password with this method.

	public void setpassword(String Password) {
		sendKeys(password, Password);
	}
	// We Click on Continue button with this method.

	public void performcontinue() {
		click(continueButton);
	}

	// We Click on Sign In button with this method.

	public void performsignIn() {
		click(signInButton);
	}

}
