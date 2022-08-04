package com.google.imooc.page;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.utility.GetByLocator;

public class CartPage extends BasePage{
	public CartPage(DriverBase driver) {
		super(driver);
	}
	
	/*** get checkall checkbox element***/
	public WebElement getCheckAllElement() {
		return findElement(GetByLocator.getLoactor("checkAll"));
	}
	
	
	/*** get go confirm button ***/
	public WebElement getGoConfirmButton() {
		return findElement(GetByLocator.getLoactor("goConfirm"));
	}

}
