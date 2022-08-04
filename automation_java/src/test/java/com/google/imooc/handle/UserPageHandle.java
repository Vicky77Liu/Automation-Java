package com.google.imooc.handle;

import com.google.imooc.base.DriverBase;
import com.google.imooc.page.UserPage;

public class UserPageHandle {
	public DriverBase driver;
	public UserPage userpage;
	public UserPageHandle(DriverBase driver) {
		this.driver = driver;
		userpage = new UserPage(driver);
	}
	
	/*** click personal information button ***/
	public void clickPersonElement() {
		userpage.click(userpage.getPersonElement());
	}
	
	/*** click change information button ***/
	public void clickChangeButton() {
		userpage.click(userpage.getChangeButton());
	}

}
