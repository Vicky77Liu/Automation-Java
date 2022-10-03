package com.vicky.imooc.handle;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.LoginPage;

public class LoginPageHandle {
	public DriverBase driver;
	public LoginPage loginpage;
	public LoginPageHandle(DriverBase driver) {
		this.driver = driver;
		loginpage = new LoginPage(driver);
	}
	
	
	/*** input username ***/
	public void inputUsername(String username) {
		loginpage.sendKeys(loginpage.getUsernameElement(), username);
	}
	
	/*** input password ***/
	public void inputPassword(String password) {
		loginpage.sendKeys(loginpage.getPasswordElement(), password);
	}
	
	/*** click auto login check box ***/
	public void clickAutoLogin() {
		loginpage.click(loginpage.getAutoLogin());
	}
	
	/*** click login button ***/
	public void clickLoginButton() {
		loginpage.click(loginpage.getLoginButton());
	}
	
	/*** verify if the username textfield is displayed ***/
	public boolean assertLoginPage() {
		return loginpage.ifDisplayed(loginpage.getUsernameElement());
	}
	
	/*** click right top login button then get login form ***/
	
}
