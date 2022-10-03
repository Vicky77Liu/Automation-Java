package com.vicky.imooc.handle;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.UserPage;

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
