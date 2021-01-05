package com.orangeHRM.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.driverManager.DriverManager;

public final class ElementUtil {

	public static WebElement getWebElement(By locator) {
		WebElement ele=null;
		try {
		ele=DriverManager.getDriver().findElement(locator);
		}
		catch(Exception e){
			System.out.println("element could not be created..." + locator);
		}
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
	
	public static void waitForElementToBeVisible(By locator) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Constants.getExplicitwait());
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitForWebElementToVisible(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Constants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static WebElement dynamicWebElement(String xpath,String value) {
		WebElement ele=DriverManager.getDriver().findElement(By.xpath(xpath.replace("%replace%", value)));
		waitForWebElementToVisible(ele);
		return ele;
	}
	
	public static String isTextPresent(By locator) {
		return getWebElement(locator).getText();
	}
}
