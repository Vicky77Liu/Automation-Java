package com.vicky.imooc.utility;

import org.openqa.selenium.By;

public class GetByLocator {
	public static By getLoactor(String key) {
		ProUtil pro = new ProUtil("element.properties");
		String locator = pro.getPro(key);
		String[] locatorContent = locator.split(":");
		String locatorType = locatorContent[0];
		String locatorValue = locatorContent[1];
		if(locatorType.equals("id")) {
			return By.id(locatorValue);
		}else if(locatorType.equals("name")) {
			return By.name(locatorValue);
		}else if(locatorType.equals("className")) {
			return By.className(locatorValue);
		}else if(locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		}else if(locatorType.equals("xpath")) {
			return By.xpath(locatorValue);
		}else {
			return By.linkText(locatorValue);
		}
	}
	
//	public static void main(String[] args) {
//		GetByLocator gbl = new GetByLocator();
//		System.out.println(gbl.getLoactor("courseName"));
//	}

}
