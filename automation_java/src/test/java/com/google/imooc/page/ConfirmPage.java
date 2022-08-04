package com.google.imooc.page;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.utility.GetByLocator;

public class ConfirmPage extends BasePage{
	public ConfirmPage(DriverBase driver) {
		super(driver);
	}
	
	/*** get order element***/
	public WebElement getOrderElement() {
		WebElement titleAll = findElement(GetByLocator.getLoactor("titieAll"));
		return titleAll.findElement(GetByLocator.getLoactor("order"));
	}
	
	/*** get order number element ***/
	public WebElement getOrderNumElement() {
		WebElement titleAll = findElement(GetByLocator.getLoactor("titieAll"));
		return titleAll.findElement(GetByLocator.getLoactor("num"));
	}
	
	/*** get Alipay element ***/
	public WebElement getAlipayElement() {
		return findElement(GetByLocator.getLoactor("alipay"));
	}
	
	/*** get WechatPay element ***/
	public WebElement getWechatpayElement() {
		return findElement(GetByLocator.getLoactor("wechat"));
	}
	
	/*** get buynow button ***/
	public WebElement getBuyNowButton() {
		return findElement(GetByLocator.getLoactor("buyNowConfimPage"));
	}
}
