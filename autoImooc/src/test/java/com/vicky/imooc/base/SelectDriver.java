package com.vicky.imooc.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SelectDriver {
	public WebDriver getDriver(String browserName) {
		if(browserName.equalsIgnoreCase("Safari")) {
			return new SafariDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "/Users/kurt/Desktop/study/seleniumTest/chromedriver");
			return new ChromeDriver();
		}
	}
	
	public static void main (String[] args) {
		SelectDriver dr = new SelectDriver();
		dr.getDriver("safari");
		
	}

}
