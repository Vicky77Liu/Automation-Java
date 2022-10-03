package com.vicky.imooc.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.business.ConfirmPagePro;
import com.vicky.imooc.business.CoursePagePro;
import com.vicky.imooc.business.OrderPagePro;
import com.vicky.imooc.utility.HandleCookie;
import com.vicky.imooc.utility.ProUtil;

public class BuyFlow extends CaseBase{
	public DriverBase driver;
	public ProUtil getUrl;
	public CoursePagePro cpp;
	public OrderPagePro opp;
	public HandleCookie hc;
	public ConfirmPagePro confirmpp;
	
	
	@BeforeClass
	public void beforeClass() {
		this.driver = initDriver("chrome");
		driver.waitLoad();
		opp = new OrderPagePro(driver);
		cpp = new CoursePagePro(driver);
		confirmpp = new ConfirmPagePro(driver);
		getUrl = new ProUtil("test.properties");
		hc = new HandleCookie(driver);
	
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void openCoursePage(){
		driver.get(getUrl.getPro("courseurl"));
		hc.addCookie();
		driver.get(getUrl.getPro("courseurl"));

	}
	
	@Test(dependsOnMethods= {"openCoursePage"})
	public void testBuy() {
		cpp.getCourseName();
		cpp.clickBuyNow();
		opp.clickSubmit();
		confirmpp.confirmOrder();
	}
	
}
