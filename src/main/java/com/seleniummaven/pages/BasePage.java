package com.seleniummaven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.seleniummaven.driverManager.DriverManager;
import com.seleniummaven.util.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	private WebDriver initBrowserLocal() {

		String browser = ReadPropertyFile.get("browser").trim();
		if(DriverManager.getDriver()==null) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			DriverManager.setDriver(new FirefoxDriver());
		} else {
			System.out.println(browser + "not found.Please pass the correct browser");
		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		
		return DriverManager.getDriver();
		}
		else {
		return DriverManager.getDriver();
}
		}

	public static void intialize() {
		if (DriverManager.getDriver() == null) {
			new BasePage();
		}
	}

	public BasePage() {

		if (ReadPropertyFile.get("runMode").equalsIgnoreCase("local")) {
			initBrowserLocal();
		} else if (ReadPropertyFile.get("runMode").equalsIgnoreCase("remote")) {
			initBrowserRemote();
		}
		else {
			try {
				throw new Exception("please pass correct runmode in properties file");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private void initBrowserRemote() {

	}

}
