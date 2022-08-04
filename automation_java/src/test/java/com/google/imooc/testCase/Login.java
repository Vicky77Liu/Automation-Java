package com.google.imooc.testCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.imooc.base.DriverBase;
import com.google.imooc.business.HomePagePro;
import com.google.imooc.business.LoginPagePro;
import com.google.imooc.utility.ProUtil;

public class Login extends CaseBase{
	public DriverBase driver;
	public LoginPagePro lgpp;
	public HomePagePro hpp;
	public ProUtil pro;


	static Logger logger = LogManager.getLogger(Login.class);
	
	
	@BeforeClass
	public void startPage() {
		this.driver = initDriver("chrome");
		driver.waitLoad();
		lgpp = new LoginPagePro(driver);
		hpp = new HomePagePro(driver);
		pro = new ProUtil("test.properties");

		
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
	
	@Test
	public void testGetUrl() {
		driver.get(pro.getPro("url"));
	}
	
	@Test(dependsOnMethods= {"testGetUrl"})
	public void testGetLoginFrom() {
		hpp.clickLoginButton();
		lgpp.login(pro.getPro("username"),pro.getPro("password"));
	}

}
