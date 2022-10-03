package com.vicky.imooc.handle;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.OrderPage;
import com.vicky.imooc.utility.ProUtil;

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
