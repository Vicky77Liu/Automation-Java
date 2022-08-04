package com.google.imooc.handle;

import com.google.imooc.base.DriverBase;
import com.google.imooc.page.CartPage;

public class CartPageHandle {
	public DriverBase driver;
	public CartPage cartpage;
	public CartPageHandle(DriverBase driver) {
		this.driver = driver;
		cartpage = new CartPage(driver);
	}
	
	/*** check the checkall checkbox ***/
	public void clickCheckAll() {
		cartpage.click(cartpage.getCheckAllElement());
	}
	
	/*** click goconfirm button ***/
	public void clickGoConfirm() {
		cartpage.click(cartpage.getGoConfirmButton());
	}

}
