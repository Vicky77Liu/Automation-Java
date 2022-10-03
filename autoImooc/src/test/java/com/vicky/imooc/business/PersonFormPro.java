package com.vicky.imooc.business;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.handle.PersonFormHandle;

public class PersonFormPro {
	public DriverBase driver;
	public PersonFormHandle pfh;

	public PersonFormPro(DriverBase driver) {
		this.driver = driver;
		pfh = new PersonFormHandle(driver);
	}
	
	
	/*** fill out form ***/
	public void fillOutForm() {
		pfh.clearNickField();
		pfh.inputNickName();
		pfh.selectJob();
		pfh.selectGender();
		pfh.selectProvince();
		pfh.selectCity();
		pfh.selectDistrict();
		pfh.selectYear();
		pfh.selectMonth();
		pfh.selectDay();
		pfh.inputHobby();
	}

}
