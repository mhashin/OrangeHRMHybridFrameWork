package com.seleniummaven.driverManager;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driver) {
		dr.set(driver);
	}

}
