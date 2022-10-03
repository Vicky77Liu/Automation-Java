package com.vicky.imooc.testCase;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.business.CartPagePro;
import com.vicky.imooc.business.ConfirmPagePro;
import com.vicky.imooc.business.CoursePagePro;
import com.vicky.imooc.business.OrderPagePro;
import com.vicky.imooc.utility.HandleCookie;
import com.vicky.imooc.utility.ProUtil;

public class CartBuyFlow extends CaseBase{
	public DriverBase driver;
	public ProUtil pro;
	public HandleCookie hc;
	public CoursePagePro cpp;
	public CartPagePro cartpp;
	public ConfirmPagePro confirmpp;
	public OrderPagePro opp;
	
	@BeforeClass
	public void openPage() {
		this.driver = initDriver("chrome");
		driver.waitLoad();
		pro = new ProUtil("test.properties");
		hc = new HandleCookie(driver);
		cpp = new CoursePagePro(driver);
		cartpp = new CartPagePro(driver);
		confirmpp = new ConfirmPagePro(driver);
		opp = new OrderPagePro(driver);
		driver.get(pro.getPro("courseurl"));
		hc.addCookie();
		driver.get(pro.getPro("courseurl"));
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void testBuyFromCart() {
		String courseWindow = cpp.getWindow();
		cpp.getCourseName();
		cpp.addCourseToCart();
		List<String> currentWindows = cpp.getWindows();
		for(String window:currentWindows) {
			if(!window.equals(courseWindow)) {
				driver.switchWindowTo(window);
				cartpp.goConfirm();
				driver.sleep(2000);
				opp.clickSubmit();
				driver.sleep(2000);
				confirmpp.confirmOrder();
				driver.sleep(1000);
			}
		}		
	}
}
