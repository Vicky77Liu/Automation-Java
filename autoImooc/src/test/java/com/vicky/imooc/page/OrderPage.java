package com.vicky.imooc.page;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.utility.GetByLocator;

public class OrderPage extends BasePage{
	public OrderPage(DriverBase driver) {
		super(driver);
	}
	
	/*** get name element ***/
	public WebElement getCourseNameElement() {
		return findElement(GetByLocator.getLoactor("orderPageCourseName"));
	}
	
	/*** get pay submit button ***/
	public WebElement getSubmitButton() {
		return findElement(GetByLocator.getLoactor("submit"));
	}
}
