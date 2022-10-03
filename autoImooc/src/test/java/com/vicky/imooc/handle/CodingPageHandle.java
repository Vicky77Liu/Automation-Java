package com.vicky.imooc.handle;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.CodingPage;

public class CodingPageHandle {
	public DriverBase driver;
	public CodingPage codingpage;
	public CodingPageHandle(DriverBase driver) {
		this.driver = driver;
		codingpage = new CodingPage(driver);
	}
	
	/*** get course box***/
	public WebElement getCourseBox(){
		return codingpage.getCourseBoxElement();
	}
	
	/*** get coursename ***/
	public List<String> getCourseNameList() {
		List<String> courseNames = new ArrayList<String>();
		List<WebElement> courseList = codingpage.getCourseNameElement();
		for(WebElement course: courseList) {
			courseNames.add(course.getText());			
		}
		return courseNames;
		
	}
	
	/*** get current window ***/
	public String getWindow() {
		return driver.getCurrentWindow();
	}

	/*** get all windows ***/
	public List<String> getAllWindows() {
		return driver.getAllWindows();
	}
}
