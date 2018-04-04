package com.alation.amazon.page;

import org.openqa.selenium.By;

import com.alation.amazon.scripts.browserAction;

public class loginPage extends browserAction {

	private final By userName = By.xpath("//*[@id='ap_email']");
	private final By password = By.xpath("//*[@id='ap_password']");
	private final By continueButton = By.xpath("//*[@id='continue']/span");
	private final By signInButton = By.className("a-button-primary");

	public loginPage() {
	}

	public void setuserName(String username) {
		sendKeys(userName, username);
	}

	public void setpassword(String Password) {
		sendKeys(password, Password);
	}

	public void performcontinue() {
		click(continueButton);
	}

	public void performsignIn() {
		click(signInButton);
	}

}
