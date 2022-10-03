package com.vicky.imooc.testCase;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.business.CodingPagePro;
import com.vicky.imooc.business.HomePagePro;
import com.vicky.imooc.utility.ProUtil;

public class CodingPageCourseList extends CaseBase{
	public DriverBase driver;
	public HomePagePro hpp;
	public CodingPagePro cpp;
	public ProUtil pro;
	
	@BeforeClass
	public void startPage(){
		this.driver = initDriver("chrome");
		driver.waitLoad();
		hpp = new HomePagePro(driver);
		cpp = new CodingPagePro(driver);
		pro = new ProUtil("test.properties");
	}

	@AfterClass
	public void closePage(){
		driver.quit();
	}
	
	
	@Test
	public void testCourseList() {
		driver.get(pro.getPro("codingpageurl"));
		cpp.clickCourse();
	}
}
