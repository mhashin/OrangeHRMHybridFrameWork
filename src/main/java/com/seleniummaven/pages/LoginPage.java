package com.seleniummaven.pages;

import org.openqa.selenium.By;

import com.seleniummaven.util.ElementUtil;

public final class LoginPage extends BasePage {

	private By txtboxUsername = By.xpath("//input[@name='email' and @type='text']");
	private By txtboxPassword = By.xpath("//input[@name='password' and @type='password']");
	private By btnLogin = By.xpath("//div[text()='Login']");
	private By txtErrorLogin = By.xpath("//div[@class='ui negative message']//p[text()='Invalid login']");

	public LoginPage enterUsername(String username) {
		ElementUtil.waitForElementToBeVisible(txtboxUsername);
		doSendKeys(txtboxUsername, username, "username");
		return this;
	}

	public LoginPage enterPassword(String password) {
		doSendKeys(txtboxPassword, password, "password");
		return this;
	}

	public LoginPage clickLogin() {
		doClick(btnLogin, "login");
		return this;
	}

	public String errorTextInvalidLogin() {
		return getText(txtErrorLogin);
	}

	public HomePage userLogin(String un, String pwd) {
		enterUsername(un).enterPassword(pwd).clickLogin();
		return new HomePage();
	}

}
