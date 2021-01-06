package com.orangeHRM.pages;

import org.openqa.selenium.By;

import com.orangeHRM.util.ElementUtil;

public final class HomePage  {
	
	private String welcome_xpath="//a[contains(text(),'%replace%')]";
	private By linkLogout=By.xpath("//a[text()='Logout']");

	
	public String verifyWelcomeText(String value) {
		return ElementUtil.dynamicWebElement(welcome_xpath, value).getText();
	}
	
	public HomePage clickWelcomeLink() {
		ElementUtil.dynamicWebElement(welcome_xpath, "Welcome").click();
		return this;
	}
	
	public LoginPage clickLogOut() {
		clickWelcomeLink();
		ElementUtil.waitForElementToBeVisible(linkLogout);
		ElementUtil.doClick(linkLogout);
		return new LoginPage();
	}
	

}
