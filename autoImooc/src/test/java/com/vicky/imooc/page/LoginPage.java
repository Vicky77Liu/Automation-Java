package com.vicky.imooc.page;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.utility.GetByLocator;

public class LoginPage extends BasePage{
	public LoginPage(DriverBase driver) {
		super(driver);
	}
	
	/*** get username textfield ***/
	public WebElement getUsernameElement() {
		return findElement(GetByLocator.getLoactor("username"));
	}
	
	/*** get password textfield ***/
	public WebElement getPasswordElement() {
		return findElement(GetByLocator.getLoactor("userpass"));
	}
	
	
	/*** get login button ***/
	public WebElement getLoginButton() {
		return findElement(GetByLocator.getLoactor("loginbutton"));
	}
	
	/*** get auto login check box ***/
	public WebElement getAutoLogin() {
		return findElement(GetByLocator.getLoactor("autoSignin"));
	}
	
	

}
