package com.alation.amazon.actions;

import com.alation.amazon.page.*;

public class signIn {

	public void performLogin(String userName, String password) {
		loginPage login = new loginPage();
		login.setuserName(userName);
		login.performcontinue();
		login.setpassword(password);
		login.performsignIn();
	}

}
