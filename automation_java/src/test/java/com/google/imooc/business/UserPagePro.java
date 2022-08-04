package com.google.imooc.business;

import com.google.imooc.base.DriverBase;
import com.google.imooc.handle.UserPageHandle;

public class UserPagePro {
	public DriverBase driver;
	public UserPageHandle userpagehandle;

	
	public UserPagePro(DriverBase driver) {
		this.driver = driver;
		userpagehandle = new UserPageHandle(driver);
	}
	
	
	/*** open change information form ***/
	public void openForm() {
		userpagehandle.clickPersonElement();
		driver.sleep(2000);
		userpagehandle.clickChangeButton();
	}

}
