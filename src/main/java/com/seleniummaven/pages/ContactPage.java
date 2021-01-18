package com.seleniummaven.pages;

import org.openqa.selenium.By;

import com.seleniummaven.util.ElementUtil;

public final class ContactPage {

	
	public ContactPage() {}
	
	private By textFirstName=By.name("first_name");
	private By textLastName=By.name("last_name");
	private By ddCategory=By.xpath("//div[@name='category' and @role='listbox']");
	private By categoryListOptions=By.xpath("//div[@name='category' and @role='listbox']//div[@name='category']");
	private By btnSave=By.xpath("//button[text()='Save']");
	
	public ContactPage enterFirstName(String fName) {
		ElementUtil.doSendKeys(textFirstName, fName, "first name");
		return this;
	}
	
	public ContactPage enterLastName(String lName) {
		ElementUtil.doSendKeys(textLastName, lName, "last name");
		return this;
	}
	
	public ContactPage clickCategory() {
		ElementUtil.doClick(ddCategory, "category");
		return this;
	}
	
	public ContactPage selectCategoryOption(String category) {
		clickCategory();
		ElementUtil.getDropDownoptions(categoryListOptions, category, "category");
		return this;
	}
	
	
	public ContactPage clickSave() {
		ElementUtil.doClick(btnSave, "save");
		return this;
	}
}
