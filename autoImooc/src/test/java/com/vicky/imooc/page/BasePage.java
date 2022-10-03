package com.vicky.imooc.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vicky.imooc.base.DriverBase;

public class BasePage {
	public DriverBase driver;
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	/*** find element ***/
	public WebElement findElement(By by) {
		return driver.findElement(by);
		
	}
	
	/*** find a list of elements ***/
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	
	/*** click element ***/
	public void click(WebElement element) {
		if (element != null) {
			element.click();
		}else {
			System.out.println("Clicking Fail! Can't find" + element);
		}
	}
	
	/*** sendkeys in element ***/
	public void sendKeys(WebElement element, String value) {
		if (element != null) {
			element.sendKeys(value);
		}else {
			System.out.println("Inputing Fail! Can't find" + element);
		}
	}
	
	/* enter the text field after fill out */
	public void enter(WebElement element) {
		element.sendKeys(Keys.RETURN);
	}
	
	/* clear text in element */
	public void clear(WebElement element) {
			element.clear();
	}
	
	/*** verify if element is exist ***/
	public boolean ifDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	
	/*** get text ***/
	public String getText(WebElement element) {
		return element.getText();
	}
	
	/*** get all windows ***/
	public List<String> getAllWindows(){
		return driver.getAllWindows();
	}
	
	/*** get current windows ***/
	public String getCurrentWindow() {
		return driver.getCurrentWindow();
	}

}
