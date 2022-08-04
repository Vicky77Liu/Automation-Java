package com.google.imooc.handle;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.page.SearchPage;
import com.google.imooc.utility.GetByLocator;

public class SearchPageHandle {
	public DriverBase driver;
	public SearchPage searchpage;
	public SearchPageHandle(DriverBase driver) {
		this.driver = driver;
		searchpage = new SearchPage(driver);
	}
	
	/* click course select */
	public void clickCourse() {
		searchpage.click(searchpage.getCourseSelect());
	}
	
	/* check code course */
	public void checkCodeCourse() {
		searchpage.click(searchpage.getCodeCourse());
	}
	
	/* check code course */
	public void clickLevel() {
		searchpage.click(searchpage.getCourseLevel());
	}
	
	/* check entry level */
	public void checkEnterLevel() {
		searchpage.click(searchpage.getEntryLevel());
	}
	
	/* click clear */
	public void clearLevel() {
		searchpage.click(searchpage.getClearButton());
	}
	
	/* click skill select */
	public void clickSkillSelect() {
		searchpage.click(searchpage.getSkillSelect());
	}
	
	/* check python */
	public void checkPython() {
		searchpage.click(searchpage.getPythonOption());
	}
	
	/* click class with index*/
	public void clickCourse(int index) {
		List<WebElement> courseList = searchpage.getCourses();
		for(int i=0; i<courseList.size(); i++) {
			if(i == index) {
				courseList.get(i).findElement(GetByLocator.getLoactor("everyCourse")).click();;
			}
		}		
	}
}
