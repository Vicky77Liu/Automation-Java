package com.vicky.imooc.business;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.handle.LoginPageHandle;

public class LoginPagePro {
	public LoginPageHandle loginpagehandle;
	public LoginPagePro(DriverBase driver) {
		loginpagehandle = new LoginPageHandle(driver);
	}
	/*** login process ***/
	public void login(String username, String password) {
		if (loginpagehandle.assertLoginPage()) {
			loginpagehandle.inputUsername(username);
			loginpagehandle.inputPassword(password);
			loginpagehandle.clickAutoLogin();
			loginpagehandle.clickLoginButton();
		}else {
			System.out.println("Page is not exist or can't find username textfield");
		}
	}
}
