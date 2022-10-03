package com.vicky.imooc.handle;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.HomePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageHandle {
	public DriverBase driver;
	public HomePage homepage;
	public HomePageHandle(DriverBase driver) {
		this.driver = driver;
		homepage = new HomePage(driver);
	}
	
	/*** click login button on right top ***/
	public void clickLoginButton() {
		homepage.click(homepage.getLoginButton());
	}
	
	/*** click codingCourse ***/
	public void clickCodeElement() {
		homepage.click(homepage.getCodingElement());
	}
	
	/*** hover on avator ***/
	public void hoverOnAvator() {
		driver.hoverOn(homepage.getAvator());
	}
	
	/*** click personal config ***/
	public void clickPersonal() {
		homepage.click(homepage.getPersonalElement());
	}
	
	/*** input search text field ***/
	public void inputSearch(String value) {
		homepage.sendKeys(homepage.getSearchElement(),value);
	}
	
	/*** enter the text field ***/
	public void enterSearch() {
		homepage.enter(homepage.getSearchElement());
	}

	/*** click imooc logo and fresh page ***/
	public void clickImoocLogo() {
		homepage.enter(homepage.getImoocLogoElement());
	}

	/*** get nav itmes list ***/
	public List<WebElement> getAllNavItems(){
		return homepage.getAllNavElements();
	}

	/*** get submenu itmes list ***/
	public List<WebElement> getTopMenuList(){
		return homepage.getTopMenuList();
	}

	/*** get menu list ***/
	public List<WebElement> getSubMenuList(){
		return homepage.getSubMenuList();
	}
}
