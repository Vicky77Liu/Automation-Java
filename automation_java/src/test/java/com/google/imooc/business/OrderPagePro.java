package com.google.imooc.business;

import com.google.imooc.base.DriverBase;
import com.google.imooc.handle.OrderPageHandle;

public class OrderPagePro {
	public DriverBase driver;
	public OrderPageHandle orderph;
	public OrderPagePro(DriverBase driver) {
		this.driver = driver;
		orderph = new OrderPageHandle(driver);
	}
	
	/*** click the submit button ***/
	public void clickSubmit() {
		orderph.clickSubmit();
	}
}
