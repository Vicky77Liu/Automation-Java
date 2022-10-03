package com.vicky.imooc.testCase;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.business.HomePagePro;
import com.vicky.imooc.business.LoginPagePro;
import com.vicky.imooc.business.PersonFormPro;
import com.vicky.imooc.business.UserPagePro;
import com.vicky.imooc.utility.ProUtil;

public class ChangeUserDetail extends CaseBase{
	
	public DriverBase driver;
	public LoginPagePro lgpp;
	public HomePagePro hpp;
	public UserPagePro upp;
	public PersonFormPro pfp;
	public ProUtil pro;
	
	@BeforeClass
	public void openPage() {
		this.driver = initDriver("chrome");
		driver.waitLoad();
		lgpp = new LoginPagePro(driver);
		hpp = new HomePagePro(driver);
		upp = new UserPagePro(driver);
		pfp = new PersonFormPro(driver);
		pro = new ProUtil("test.properties");
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
	
	@Test
	public void testLogin() {
		driver.get(pro.getPro("url"));
		hpp.clickLoginButton();
		driver.sleep(2000);
		lgpp.login(pro.getPro("username"),pro.getPro("password"));
	}
	
	@Test(dependsOnMethods= {"testLogin"})
	public void testGoUserPage() {
		String homeWindow = driver.getCurrentWindow();
		hpp.goToPersonalPage();
		List<String> currentWindows = driver.getAllWindows();
		for(String window: currentWindows) {
			if(!window.equals(homeWindow)) {
				driver.switchWindowTo(window); //switch window to personal page window
			}
		}
		upp.openForm();
		driver.sleep(2000);
		pfp.fillOutForm();
	}

}
