package com.orangeHRM.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.driverManager.DriverManager;

public class ElementUtil {
	


	public static WebElement getWebElement(By locator) {
		
		WebElement ele=DriverManager.getDriver().findElement(locator);
		return ele;
	}
	
	public static void doSendKeys(By locator,String value) {
		getWebElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getWebElement(locator).click();
	}
	
	public static String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static String getText(By locator) {
		return getWebElement(locator).getText();
	}
	
	public static void waitForElementToBeVisible(By locator,int time) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitForWebElementToVisible(WebElement ele,int time) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),time);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static WebElement dynamicWebElement(String xpath,String value) {
		WebElement ele=DriverManager.getDriver().findElement(By.xpath(xpath.replace("%replace%", value)));
		waitForWebElementToVisible(ele,20);
		return ele;
	}
}
