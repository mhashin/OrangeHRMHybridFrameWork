package com.seleniummaven.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniummaven.driverManager.DriverManager;
import com.seleniummaven.reports.ExtentLogger;

public final class ElementUtil {

	public static WebElement getWebElement(By locator) {
		WebElement ele = null;
		try {
			ele = DriverManager.getDriver().findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}
		return ele;
	}

	public static void doSendKeys(By locator, String value, String elementname) {
		getWebElement(locator).sendKeys(value);
		ExtentLogger.info("enter the " + elementname + " : " + value);
	}

	public static void doClick(By locator, String elementname) {
		getWebElement(locator).click();
		ExtentLogger.info("click the button : " + elementname);
	}

	public static String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static String getText(By locator) {
		return getWebElement(locator).getText();
	}

	public static void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForWebElementToVisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static WebElement dynamicWebElement(String xpath, String value) {
		WebElement ele = DriverManager.getDriver().findElement(By.xpath(xpath.replace("%replace%", value)));
		return ele;
	}

	public static String isTextPresent(By locator) {
		return getWebElement(locator).getText();
	}

	public static void selectByName(By locator, String value) {
		Select select = new Select(getWebElement(locator));
		select.selectByVisibleText(value);
	}

	public static boolean elementIsDisplayed(By locator) {
		return getWebElement(locator).isDisplayed();
	}

	public static void clickElementByJS(By locator) {	
		JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
		js.executeScript("arguments[0].click()", getWebElement(locator));
	}
	
	public static void dynamicElementByJS(String xpath, String value) {	
		JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
		js.executeScript("arguments[0].click()", dynamicWebElement(xpath, value));
	}
	

	public static void mousehoverToElement(String xpath, String value) {
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement element = DriverManager.getDriver().findElement(By.xpath(xpath.replace("%replace%", value)));
		actions.moveToElement(element).build().perform();
	}

	public static void mousehoverClick(String xpath, String value) {
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement element = DriverManager.getDriver().findElement(By.xpath(xpath.replace("%replace%", value)));
		actions.moveToElement(element).click().build().perform();
		
	}
	
	public static void moveToElement(By locator) {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(getWebElement(locator)).build().perform();
	}
	
	public static void waitForDynamicWebElement(String xpath, String value) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOf(dynamicWebElement(xpath, value)));
	}

	public static void getDropDownoptions(By locator, String text, String elementName) {

		List<WebElement> list = DriverManager.getDriver().findElements(locator);

		for (WebElement ele : list) {
			String optionsText = ele.getText();
			if (optionsText.equalsIgnoreCase(text)) {
				ele.click();
				break;
			}
		}
		ExtentLogger.info("enter the " + elementName + " : " + text);

	}
}
