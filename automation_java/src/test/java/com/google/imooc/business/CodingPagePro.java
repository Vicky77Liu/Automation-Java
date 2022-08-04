package com.google.imooc.business;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.handle.CodingPageHandle;

public class CodingPagePro {
	public DriverBase driver;
	public CodingPageHandle codingpagehandle;
	public CodingPagePro(DriverBase driver) {
		this.driver = driver;
		codingpagehandle = new CodingPageHandle(driver);
		
	}
	
		
//	/*** change windows from course_page to coding_page ***/
//	public void closeNewOpenWindows() {
//		String homeWindow = codingpagehandle.getWindow();
//		System.out.println(homeWindow);
//		List<String> allWindows = codingpagehandle.getAllWindows();
//		for(String window:allWindows) {
//			if(!window.equals(homeWindow)) {
//				driver.switchWindowTo(window);
//				driver.close();
//				driver.switchWindowTo(homeWindow);
//			}
//		}
//	}

	/*** click every course ***/
	public void clickCourse() {
		String homeWindow = codingpagehandle.getWindow();
		List<String> courseNames = codingpagehandle.getCourseNameList();
		for(int i=0 ;i<courseNames.size();i++) {
			System.out.println(i+":"+courseNames.get(i));
			WebElement everyCourse = driver.findElement(By.xpath("//*[contains(text(),'"+courseNames.get(i)+"')]"));
			everyCourse.click();
			driver.sleep(1000);
			List<String> allWindows = codingpagehandle.getAllWindows();			
			for(String window:allWindows) {
				if(!window.equals(homeWindow)) {
					driver.switchWindowTo(window);
					driver.close();
					driver.switchWindowTo(homeWindow);
				}
			}
			courseNames = codingpagehandle.getCourseNameList();
			}
		}
	}
