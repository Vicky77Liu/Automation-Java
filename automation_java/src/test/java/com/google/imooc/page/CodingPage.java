package com.google.imooc.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.utility.GetByLocator;

public class CodingPage extends BasePage{
	public DriverBase driver;
	public CodingPage(DriverBase driver) {
		super(driver);
	}
	
	/***find the course box***/
	public WebElement getCourseBoxElement(){
		return findElement(GetByLocator.getLoactor("courseList"));
		
	}
	
	/*** find all course's name element***/
	public List<WebElement> getCourseNameElement() {
		WebElement courseBox = this.getCourseBoxElement();
		return courseBox.findElements(GetByLocator.getLoactor("courseNameCodePage"));
	}
	


}
