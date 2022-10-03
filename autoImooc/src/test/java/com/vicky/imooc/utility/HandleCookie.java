package com.vicky.imooc.utility;

import java.util.Set;

import org.openqa.selenium.Cookie;

import com.vicky.imooc.base.DriverBase;

public class HandleCookie {
	public DriverBase driver;
	public ProUtil pro;
	public HandleCookie(DriverBase driver) {
		this.driver = driver;
		pro = new ProUtil("cookie.properties");
	}
	
	/*** get cookies and find the one then write to file ***/	
	public void writeCookie() {
		Set<Cookie> cookies = driver.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("apsid")) {
				pro.writePro(c.getName(), c.getValue());
			}
		}
		
	}
	
	/*** add cookie ***/
	public void addCookie() {
		String value = pro.getPro("apsid");
		Cookie cookie = new Cookie("apsid", value, "imooc.com","/",null);
		driver.addCookie(cookie);
	}
		
}
