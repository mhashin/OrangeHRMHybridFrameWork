package com.orangeHRM.pages;

import org.openqa.selenium.By;

import com.orangeHRM.listener.ExtentReportListener;
import com.orangeHRM.util.ElementUtil;

public final class LoginPage {

	private By txtboxUsername = By.xpath("//input[@id='txtUsername' and @type='text']");
	private By txtboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private By btnLogin = By.id("btnLogin");
	private By txtErrorLogin = By.xpath("//span[text()='Invalid credentials']");

	public LoginPage enterUsername(String username) {
		ElementUtil.doSendKeys(txtboxUsername, username);
		ExtentReportListener.getExtentTest().info("enter the username :" + username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		ElementUtil.doSendKeys(txtboxPassword, password);
		ExtentReportListener.getExtentTest().info("enter the password :" + password);
		return this;
	}

	public LoginPage clickLogin() {
		ElementUtil.doClick(btnLogin);
		ExtentReportListener.getExtentTest().info("click sign in button");
		return this;
	}

	public String errorTextInvalidLogin() {
		return ElementUtil.getText(txtErrorLogin);
	}

	public HomePage userLogin(String un, String pwd) {
		enterUsername(un).enterPassword(pwd).clickLogin();
		return new HomePage();
	}

}
