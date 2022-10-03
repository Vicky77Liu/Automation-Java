package com.vicky.imooc.business;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.handle.HomePageHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePagePro {
	public DriverBase driver;
	public HomePageHandle homepagehandle;
	public HomePagePro(DriverBase driver) {
		this.driver = driver;
		homepagehandle = new HomePageHandle(driver);
	}
	
	/*** click the login button on right top***/
	public void clickLoginButton() {
		homepagehandle.clickLoginButton();
	}
	
	/*** click coding page and directed to coding page ***/
	public void clickCodingCourse() {
		homepagehandle.clickCodeElement();
	}
	
	/*** go to personal page ***/
	public void goToPersonalPage() {
		homepagehandle.hoverOnAvator();
		driver.sleep(1000);
		homepagehandle.clickPersonal();
	}
	
	/*** search information ****/
	public void search(String value) {
		homepagehandle.inputSearch(value);
		homepagehandle.enterSearch();
	}


	/*** click imooc logo back to home page ****/
	public void goBackHomePage() {
		homepagehandle.clickImoocLogo();
	}

	/*** click each item on header nav itmes ***/
	public void clickEachNavItems(){
		List<WebElement> itemsList = homepagehandle.getAllNavItems();
		for(int i = 1; i< itemsList.size() - 1; i++) {
			System.out.println(itemsList.get(i).getText());
			itemsList.get(i).click();
			//go back home page via imooc logo in each page
			driver.findElement(By.xpath("//a[contains(text(),'慕课网首页')]"));
			driver.sleep(2000);
			itemsList = homepagehandle.getAllNavItems();
		}
	}

	/*** loop top menu box ****/
	public void loopTopMenu() {
		String homeWindow = driver.getCurrentWindow();
		List<WebElement> topMenu = homepagehandle.getTopMenuList();
		for(int i = 0; i < topMenu.size(); i ++){
			driver.hoverOn(topMenu.get(i));
			List<WebElement> subMenuList = homepagehandle.getSubMenuList();
			WebElement innerTopMenu = subMenuList.get(i).findElement(By.className("lores"));
			List<WebElement> subCourseMenu = innerTopMenu.findElements(By.tagName("a"));
			for(WebElement sub : subCourseMenu){
				System.out.println(sub.getText());
				sub.click();
				List<String> currentWindows = driver.getAllWindows();
				for(String window:currentWindows){
					if( ! window.equals(homeWindow)){
						driver.switchWindowTo(window);
						driver.close();
						driver.switchWindowTo(homeWindow);
					}
					driver.hoverOn(topMenu.get(i));
				}
			}
		}
	}
}
