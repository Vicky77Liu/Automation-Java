package com.vicky.imooc.business;

import java.util.List;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.handle.CoursePageHandle;

public class CoursePagePro {
	public DriverBase driver;
	public CoursePageHandle courseph;

	public CoursePagePro(DriverBase driver) {
		this.driver = driver;
		courseph = new CoursePageHandle(driver);
}	
	
	
	/*** get course name and write into file ***/
	public void getCourseName() {
		String courseName = courseph.getCourseName();
		courseph.writeNameIntoPro("courseName",courseName);
	}
	
	/*** get name, write into file, click buy now button ***/
	public void clickBuyNow() {		
		courseph.clickBuyNow();
	}	
	
	
	/*** get name, write in to file ***/
	public void addCourseToCart(){

		courseph.clickAddCart();

		try {
			driver.switchToModalBox();
			courseph.clickGoCart();
		}catch (Exception e) {
			System.out.println("No modal box");
		}
		courseph.clickShopCartIcon();

	}
	
	/*** get window ***/
	public String getWindow() {
		return driver.getCurrentWindow();
	}

	/*** get all windows list ***/
	public List<String> getWindows() {
		return driver.getAllWindows();
	}

	/*** window scroll down when pop-up visible  and click buy now on pop-up***/
	public void clickBuyOnPopup(String script) {
		driver.scrollDown(script);
		driver.sleep(1000);
		courseph.clickBuyOnPop();
	}

}
