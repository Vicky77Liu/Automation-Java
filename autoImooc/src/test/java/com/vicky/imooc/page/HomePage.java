package com.vicky.imooc.page;

import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.utility.GetByLocator;

import java.util.List;

public class HomePage extends BasePage{
	
	public HomePage(DriverBase driver) {
		super(driver);
	}
	
	/*** find login button then get login form ***/
	public WebElement getLoginButton() {
		return findElement(GetByLocator.getLoactor("getloginform"));
	}
	
	/*** find coding course element "实战课"***/
	public WebElement getCodingElement() {
		return findElement(GetByLocator.getLoactor("codingCourse"));
	}
	
	/*** find avator on right top***/
	public WebElement getAvator() {
		return findElement(GetByLocator.getLoactor("avator"));
	}
	
	/*** find personal configuration element ***/
	public WebElement getPersonalElement() {
		return findElement(GetByLocator.getLoactor("personal"));
	}
	
	/*** find search text field element ***/
	public WebElement getSearchElement() {
		return findElement(GetByLocator.getLoactor("search"));
	}

	/*** find header element ***/
	public WebElement getHeaderElement() {
		return findElement(GetByLocator.getLoactor("headerHome"));
	}

	/*** find imooc logo element on left top***/
	public WebElement getImoocLogoElement() {
		WebElement header = this.getHeaderElement();
		return header.findElement(GetByLocator.getLoactor("imoocLogo"));
	}

	/*** find nav itmes element***/
	public WebElement getNavElement() {
		return findElement(GetByLocator.getLoactor("nav"));
	}

	/*** get all nav itmes elements***/
	public List<WebElement> getAllNavElements() {
		WebElement navItmes = this.getNavElement();
		return navItmes.findElements(GetByLocator.getLoactor("navItems"));
	}

	/*** get top menu elements***/
	public WebElement getTopMenuBox() {
		return findElement(GetByLocator.getLoactor("topMenuBox"));
	}

	/*** get top menu list element***/
	public List<WebElement> getTopMenuList() {
		WebElement topMenu = this.getTopMenuBox();
		return topMenu.findElements(GetByLocator.getLoactor("menuList"));
	}

	/*** find submenu element***/
	public WebElement getSubMenuBox() {
		return findElement(GetByLocator.getLoactor("subMenuBox"));
	}

	/*** get submenu list elements***/
	public List<WebElement> getSubMenuList() {
		WebElement subMenu = this.getSubMenuBox();
		return subMenu.findElements(GetByLocator.getLoactor("subMenu"));

	}

}
