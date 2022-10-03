package com.vicky.imooc.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DriverBase {
	public WebDriver driver;
	public DriverBase(String browserName) {
		SelectDriver selectdriver = new SelectDriver();
		this.driver = selectdriver.getDriver(browserName);
	}
	
	/*** close the window ***/
	public void close() {
		driver.close();
	}

	/*** stop the driver ***/
	public void quit() {
		System.out.println("Webdriver stops");
		driver.close();
	}
	
	/*** locate element ***/
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	/*** locate a list of elements ***/
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	
	/*** get url ***/
	public void get(String url) {
		driver.get(url);
	}
	
	/*** back to previous page ***/
	public void back() {
		driver.navigate().back();
	}
	
	/*** get current window list ***/
	public List<String> getAllWindows(){
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>(windowHandles);
		return allWindows;
	}
	
	/*** get current window ***/
	public String getCurrentWindow() {
		return driver.getWindowHandle();
	}
	
	/*** switch windows ***/
	public void switchWindowTo(String name) {
		driver.switchTo().window(name);
	}
	
	/*** get cookies ***/
	public Set<Cookie> getCookies(){
		return driver.manage().getCookies();
	}
	
	/*** add cookies ***/
	public void addCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	/*** switch to modal window ***/
	public void switchToModalBox() {
		driver.switchTo().activeElement();
		
	}
	
	/*** hover on element ***/
	public void hoverOn(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/*** wait for loading */
	public void waitLoad(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	/*** sleep ***/
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*** js function ***/
	public void jsAction(String actionScript){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(actionScript);
	}

	/*** js function  need element ***/
	public void scrollDown(String scollDown){
		((JavascriptExecutor) driver).executeScript(scollDown);
	}
}
	

