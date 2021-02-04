package com.seleniummaven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.seleniummaven.driverManager.DriverManager;
import com.seleniummaven.reports.ExtentLogger;

public class BasePage {

	protected static void doSendKeys(By locator, String value, String elementname) {
		getWebElement(locator).sendKeys(value);
		ExtentLogger.info("enter the " + elementname + " : " + value);
	}

	protected static void doClick(By locator, String elementname) {
		getWebElement(locator).click();
		ExtentLogger.info("click the button : " + elementname);
	}

	protected static String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected static String getText(By locator) {
		return getWebElement(locator).getText();
	}

	protected static WebElement getWebElement(By locator) {
		WebElement ele = null;
		try {
			ele = DriverManager.getDriver().findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}
		return ele;
	}

}
