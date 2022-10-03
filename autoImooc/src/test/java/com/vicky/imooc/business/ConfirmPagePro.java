package com.vicky.imooc.business;


import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.handle.ConfirmPageHandle;

public class ConfirmPagePro {
	public DriverBase driver;
	public ConfirmPageHandle confirmpp;
	public ConfirmPagePro(DriverBase driver) {
		this.driver = driver;
		confirmpp = new ConfirmPageHandle(driver);
	}
	
	/***cilck buy now ***/
	public void confirmOrder() {
		if (confirmpp.getOrderText() != null){
			confirmpp.checkAlipay();
			confirmpp.clickBuyNow();
		}
	}
	

}
