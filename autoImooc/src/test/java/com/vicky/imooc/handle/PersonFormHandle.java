package com.vicky.imooc.handle;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.page.PersonEditFormPage;
import com.vicky.imooc.utility.ProUtil;

public class PersonFormHandle {
	public DriverBase driver;
	public PersonEditFormPage pefp;
	public ProUtil pro;
	public PersonFormHandle(DriverBase driver) {
		this.driver = driver;
		pefp = new PersonEditFormPage(driver);
	}
	
	
	/*** clear the nickname text field ***/
	public void clearNickField() {
		pefp.clear(pefp.getNickElement());
	}
	/*** change nickname ***/
	public void inputNickName() {
		pro = new ProUtil("test.properties");
		pefp.sendKeys(pefp.getNickElement(), pro.getPro("nick"));
	}
	
	/*** select job ***/
	public void selectJob() {
		Select jobList = new Select(pefp.getJobDroplist());
		jobList.selectByVisibleText(pro.getPro("job"));
	}
	
	/*** select sex ***/
	public void selectGender() {
		List<WebElement> genderList = pefp.getRadioList();
		for(WebElement gender:genderList) {
			if(!gender.isSelected()) {
				gender.click();
				break;
			}
		}
	}
	
	/*** select province ***/
	public void selectProvince() {
		Select elementList = new Select(pefp.getProvinceDroplist());
		elementList.selectByIndex(Integer.parseInt(pro.getPro("provinceIndex")));
	}
	
	/*** select city ***/
	public void selectCity() {
		Select elementList = new Select(pefp.getCityDroplist());
		elementList.selectByValue(pro.getPro("cityValue"));
	}
	
	/*** select district ***/
	public void selectDistrict() {
		Select elementList = new Select(pefp.getDistrictDroplist());
		elementList.selectByValue(pro.getPro("districtValue"));
	}
	
	/*** select year ***/
	public void selectYear() {
		Select elementList = new Select(pefp.getYearDroplist());
		elementList.selectByValue(pro.getPro("yearValue"));
	}
	
	/*** select year ***/
	public void selectMonth() {
		Select elementList = new Select(pefp.getMonthDroplist());
		elementList.selectByValue(pro.getPro("monthValue"));
	}
	
	/*** select year ***/
	public void selectDay() {
		Select elementList = new Select(pefp.getDayDroplist());
		elementList.selectByValue(pro.getPro("dayValue"));
	}
	
	/*** input hobby ***/
	public void inputHobby() {
		pefp.sendKeys(pefp.getHobbyElement(),pro.getPro("hobby"));
		
		
	}

}
