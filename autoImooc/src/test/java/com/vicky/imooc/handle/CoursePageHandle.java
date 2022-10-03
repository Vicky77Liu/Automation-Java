package com.vicky.imooc.handle;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.CoursePage;
import com.vicky.imooc.utility.ProUtil;
import org.openqa.selenium.WebElement;

public class CoursePageHandle {
	public DriverBase driver;
	public CoursePage coursepage;
	public ProUtil pro;
	public CoursePageHandle(DriverBase driver) {
		this.driver = driver;
		coursepage = new CoursePage(driver);
	}
	
	/*** get text of name ***/
	public String getCourseName() {
		return coursepage.getCourseNameElement().getText();
	}
	
	
	/*** write the name into file ***/
	public void writeNameIntoPro(String key,String value) {
		pro = new ProUtil("courseName.Properties");
		pro.writePro(key, value);
	}
	
	/*** click buy not button ***/
	public void clickBuyNow() {
		coursepage.click(coursepage.getBuyNowButton());
	}
	
	
	/*** click add to cart button ***/
	public void clickAddCart() {
		coursepage.click(coursepage.getAddCartButton());
	}
	
	/*** click shoping cart icor on right top ***/
	public void clickShopCartIcon() {
		coursepage.click(coursepage.getShopCartIcon());
	}
	
	/*** switch to modal box ***/
	public boolean assertModal(){
		return coursepage.ifDisplayed(coursepage.getModalBox());
	}
	
	/*** click go buy button on modal box ***/
	public void clickGoCart() {
		coursepage.click(coursepage.getGoCartButton());
	}

	/*** get pop-up element ***/
	public WebElement getPopUpElement(){
		return coursepage.getPopUpElement();
	}

	/*** click buy on pop_up***/
	public void clickBuyOnPop() {
		coursepage.click(coursepage.getBuyOnPopButton());
	}
	
}
