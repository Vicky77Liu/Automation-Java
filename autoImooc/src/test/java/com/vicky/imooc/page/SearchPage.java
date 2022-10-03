package com.vicky.imooc.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.utility.GetByLocator;

public class SearchPage extends BasePage{
	public SearchPage(DriverBase driver) {
		super(driver);
	}
	
	/* get dropdown list */
	public WebElement getDropDownList() {
		return findElement(GetByLocator.getLoactor("dropCourse"));
	}
	
	/* get course select element */
	public WebElement getCourseSelect() {
		return findElement(GetByLocator.getLoactor("course"));
	}
	
	/* get coding course element after clicking course select */
	public WebElement getCodeCourse() {
		WebElement dropCourse = this.getDropDownList();
		return dropCourse.findElement(GetByLocator.getLoactor("codeCourse"));
	} 
	
	/* get  course level element  */
	public WebElement getCourseLevel() {
		return findElement(GetByLocator.getLoactor("level"));
	} 
	
	/* get  entry level element after clicking course level */
	public WebElement getEntryLevel() {
		return findElement(GetByLocator.getLoactor("entryLevel"));
	} 
	
	/* get  clear button */
	public WebElement getClearButton() {
		return findElement(GetByLocator.getLoactor("clear"));
	} 
	
	/* get skill select element */
	public WebElement getSkillSelect() {
		return findElement(GetByLocator.getLoactor("skill"));
	} 
	
	/* get python element as option*/
	public WebElement getPythonOption() {
		return findElement(GetByLocator.getLoactor("python"));
	} 
	
	/* get the list of course */
	public List<WebElement> getCourses() {
		WebElement courseBox = findElement(GetByLocator.getLoactor("courseBox"));
		List<WebElement> courseList = courseBox.findElements(GetByLocator.getLoactor("listCourse"));
		return courseList;
	}
}
