package com.google.imooc.business;


import com.google.imooc.base.DriverBase;
import com.google.imooc.handle.ConfirmPageHandle;

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
