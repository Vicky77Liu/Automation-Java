package com.vicky.imooc.business;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.handle.SearchPageHandle;

public class SearchPagePro {
	public DriverBase driver;
	public SearchPageHandle sph;
	public SearchPagePro(DriverBase driver) {
		this.driver = driver;
		sph = new SearchPageHandle(driver);
	}
	
	public void searchCourse() {
		sph.clickCourse();
		driver.sleep(1000);
		sph.checkCodeCourse();
		sph.clickLevel();
		driver.sleep(1000);
		sph.checkEnterLevel();
		sph.clearLevel();
		sph.clickSkillSelect();
		driver.sleep(1000);
		sph.checkPython();
		sph.clickCourse(0);
	}

}
