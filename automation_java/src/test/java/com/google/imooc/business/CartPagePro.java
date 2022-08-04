package com.google.imooc.business;

import java.util.List;

import com.google.imooc.base.DriverBase;
import com.google.imooc.handle.CartPageHandle;

public class CartPagePro {
	public DriverBase driver;
	public CartPageHandle cartpagehandle;
	public CartPagePro(DriverBase driver) {
		this.driver = driver;
		cartpagehandle = new CartPageHandle(driver);
	}
	
	
	private void checkCourse() {
		cartpagehandle.clickCheckAll();
	}
	
	/*** check course and go confirm ***/
	public void goConfirm() {
		this.checkCourse();
		cartpagehandle.clickGoConfirm();
		
	}


	public List<String> getWindows() {
		return driver.getAllWindows();
	}
}
