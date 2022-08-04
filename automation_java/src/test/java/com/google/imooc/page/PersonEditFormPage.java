package com.google.imooc.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.google.imooc.base.DriverBase;
import com.google.imooc.utility.GetByLocator;

public class PersonEditFormPage extends BasePage{
	public PersonEditFormPage(DriverBase driver) {
		super(driver);
	}
	
	private WebElement form;
	
	/*** get form element ***/
	public synchronized WebElement getFormElement() {
		if(this.form == null) {
			this.form =  findElement(GetByLocator.getLoactor("form"));
		}
		return this.form;
	}
	
	/*** get nick element ***/
	public WebElement getNickElement() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("nick"));
	}
	
	
	/*** get job droplist element ***/
	public WebElement getJobDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("job"));
	}
	
	/*** get radio list out box  element ***/
	public WebElement getRadio() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("radioBox"));
	}
	
	/*** get radio list ***/
	public List<WebElement> getRadioList(){
		WebElement radios = this.getRadio();
		return radios.findElements(GetByLocator.getLoactor("sex"));
	}
	
	/*** get province droplist element ***/
	public WebElement getProvinceDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("province"));
	}
	
	/*** get province droplist element ***/
	public WebElement getCityDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("city"));
	}
	
	/*** get province droplist element ***/
	public WebElement getDistrictDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("district"));
	}
	
	/*** get province droplist element ***/
	public WebElement getYearDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("year"));
	}
	
	/*** get province droplist element ***/
	public WebElement getMonthDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("month"));
	}
	
	/*** get province droplist element ***/
	public WebElement getDayDroplist() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("day"));
	}
	
	/*** get hobby textarea ***/
	public WebElement getHobbyElement() {
		WebElement form = this.getFormElement();
		return form.findElement(GetByLocator.getLoactor("hobby"));
	}
	
	
}
