package com.google.imooc.page;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.utility.GetByLocator;

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
