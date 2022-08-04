package com.google.imooc.testCase;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.imooc.base.DriverBase;
import com.google.imooc.business.HomePagePro;
import com.google.imooc.business.SearchPagePro;
import com.google.imooc.utility.ProUtil;

public class Search extends CaseBase{
	public DriverBase driver;
	public HomePagePro hpp;
	public SearchPagePro spp;
	public ProUtil pro;

	
	
	@BeforeClass
	public void beforeClass() {
		driver = initDriver("chrome");
		driver.waitLoad();
		hpp = new HomePagePro(driver);
		spp = new SearchPagePro(driver);
		pro = new ProUtil("test.properties");
		driver.get(pro.getPro("url"));

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void testSearch() {
		hpp.search(pro.getPro("searchContent"));
		spp.searchCourse();
	}

}
