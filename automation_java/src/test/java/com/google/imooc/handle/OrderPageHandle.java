package com.google.imooc.handle;

import com.google.imooc.base.DriverBase;
import com.google.imooc.page.OrderPage;
import com.google.imooc.utility.ProUtil;

public class OrderPageHandle {
	public DriverBase driver;
	public OrderPage orderpage;
	public ProUtil pro;
	public OrderPageHandle(DriverBase driver) {
		this.driver=driver;
		orderpage = new OrderPage(driver);
	}
	
	
	/*** click the submit button ***/
	public void clickSubmit() {
		orderpage.click(orderpage.getSubmitButton());
	}

}
