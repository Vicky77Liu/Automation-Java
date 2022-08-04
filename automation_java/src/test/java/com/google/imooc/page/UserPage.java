package com.google.imooc.page;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.utility.GetByLocator;

public class UserPage extends BasePage{
	public UserPage(DriverBase driver) {
		super(driver);
	}
	
	
	/*** get personal information element ***/
	public WebElement getPersonElement() {
		return findElement(GetByLocator.getLoactor("person"));
	}
	
	/*** get change information button ***/
	public WebElement getChangeButton() {
		return findElement(GetByLocator.getLoactor("change"));
	} 
}
