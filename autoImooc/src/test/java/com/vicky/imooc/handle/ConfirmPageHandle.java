package com.vicky.imooc.handle;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.ConfirmPage;

public class ConfirmPageHandle {
	public DriverBase driver;
	public ConfirmPage confirmpage;
	public ConfirmPageHandle(DriverBase driver) {
		this.driver = driver;
		confirmpage = new ConfirmPage(driver);
	}
	
	/*** get order Text ***/
	public String getOrderText() {
		return confirmpage.getOrderElement().getText();
	}
	
	/*** get order number ***/
	public String getOrderNum() {
		return confirmpage.getOrderNumElement().getText();
	}
	
	/*** check alipay ***/
	public void checkAlipay() {
		confirmpage.click(confirmpage.getAlipayElement());
	}
	
	/*** check wechatpay ***/
	public void checkWechatpay() {
		confirmpage.click(confirmpage.getWechatpayElement());
	}
	
	/*** click buy now button ***/
	public void clickBuyNow() {
		confirmpage.click(confirmpage.getBuyNowButton());
	}
	
}
