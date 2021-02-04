package com.seleniummaven.pages;

import org.openqa.selenium.By;

import com.seleniummaven.util.ElementUtil;

public final class HomePage extends BasePage {

	public HomePage() {

	}

	private String welcome_xpath = "//span[text()='%replace%']";
	private String addIcon = "(//button[@class='ui mini basic icon button'])[%replace%]";
	private String menuItem = "//div//a/span[text()='%replace%']";

	private By linkLogout = By.xpath("//a[text()='Logout']");
	private By textSearch = By.xpath("//input[@placeholder='Search']");
	private By btnSettings = By.xpath("//div[@class='ui buttons']//div[@role='listbox']");
	private By logOut = By.xpath("//div[@class='menu transition visible']//span[text()='Log Out']");

	public String verifyWelcomeText(String value) {
		ElementUtil.waitForElementToBeVisible(textSearch);
		return ElementUtil.dynamicWebElement(welcome_xpath, value).getText();
	}

	public void clickSettingsIcon() {
		doClick(btnSettings, "settings icon");
	}

	public void clickLogOut() {
		doClick(logOut, "log out");
	}

	public ContactPage createContact() {
		ElementUtil.waitForElementToBeVisible(textSearch);
		ElementUtil.mousehoverToElement(menuItem, "Contacts");
		ElementUtil.dynamicWebElement(addIcon, "2").click();
		return new ContactPage();
	}

	public void clickContact() {
		ElementUtil.waitForElementToBeVisible(textSearch);
		ElementUtil.mousehoverClick(menuItem, "Contacts");
	}

	public LoginPage doLogout() {
		clickSettingsIcon();
		clickLogOut();
		return new LoginPage();
	}
}
