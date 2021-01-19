package com.seleniummaven.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;
import com.seleniummaven.util.ElementUtil;

public final class ContactPage {

	public ContactPage() {
	}

	private String chkboxContactName = "//td/a[text()='%replace%']/parent::td/preceding-sibling::td/div//input[@name='id' and @type='checkbox']";
	private String chkboxContactNames="//td/a[text()='Test Hashin']/parent::td/preceding-sibling::td/div/input[@name='id']";
	private String contactName="//td/a[text()='%replace%']";

	private By textFName=By.name("first_name");
	private By textLName=By.name("last_name");
	private By dropDownCategory=By.xpath("//div[@name='category' and @role='listbox']");
	private By listCategoryOptions=By.xpath("//div[@name='category' and @role='option']/span");
	private By btnSave=By.xpath("//button[text()='Save']");
	private By btnNew=By.xpath("//button[text()='New']");

	public ContactPage enterFirstName(String fName) {
		ElementUtil.doSendKeys(textFName, fName, "first name");
		return this;
	}

	public ContactPage enterLastName(String lName) {
		ElementUtil.doSendKeys(textLName, lName, "last name");
		return this;
	}

	public ContactPage clickCategory() {
		ElementUtil.doClick(dropDownCategory, "category");
		return this;
	}

	public ContactPage selectCategoryOption(String category) {
		clickCategory();
		ElementUtil.getDropDownoptions(listCategoryOptions, category, "category");
		return this;
	}

	public ContactPage clickSave() {
		ElementUtil.doClick(btnSave, "save");
		return this;
	}
	
	public void selectCheckbox(String contact) {
		ElementUtil.moveToElement(btnNew);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		ElementUtil.dynamicElementByJS(chkboxContactNames, contact);
	}
	
	public String verifyCreatedUser(String contact) {
		ElementUtil.moveToElement(btnNew);
		return ElementUtil.dynamicWebElement(contactName, contact).getText();
	}
}
