package com.seleniummaven.driverManager;

import java.util.Objects;

import com.seleniummaven.util.ReadPropertyFile;

public final class Driver {

	public static void initDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverManager.setDriver(DriverFactory.getDriver());
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
		}
	}

}
