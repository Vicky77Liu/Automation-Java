package com.vicky.imooc.page;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.utility.GetByLocator;

public class CoursePage extends BasePage{

	public CoursePage(DriverBase driver) {
		super(driver);
	}
	
	/*** get element of course's name on left top ***/
	public WebElement getCourseNameElement() {
		return findElement(GetByLocator.getLoactor("courseName"));
	}

	/*** get buy now button ***/
	public WebElement getBuyNowButton() {
		return findElement(GetByLocator.getLoactor("buyNowButton"));
	}
	
	/*** get add cart button ***/
	public WebElement getAddCartButton() {
		return findElement(GetByLocator.getLoactor("addCartButton"));
	}
	
	/*** get shopping cart icon on right top ***/
	public WebElement getShopCartIcon() {
		return findElement(GetByLocator.getLoactor("addCartIcon"));
	}
	
	/*** get product already in cart modal box ***/
	public WebElement getModalBox() {
		return findElement(GetByLocator.getLoactor("modalBox"));
	}
	
	/*** get go to shoping cart page check out button in modal box ***/
	public WebElement getGoCartButton() {
		return findElement(GetByLocator.getLoactor("goCartButton"));
	}
	/*** get pop_up on top element***/
	public WebElement getPopUpElement() {
		return findElement(GetByLocator.getLoactor("courseFix"));
	}

	/*** get go to shoping cart page check out button in modal box ***/
	public WebElement getBuyOnPopButton() {
		WebElement pop = this.getPopUpElement();
		return pop.findElement(GetByLocator.getLoactor("buyOnPop"));
	}

}
