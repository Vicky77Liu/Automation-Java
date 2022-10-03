package com.vicky.imooc.page;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.utility.GetByLocator;

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
