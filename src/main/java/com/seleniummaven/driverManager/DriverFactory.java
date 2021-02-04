package com.seleniummaven.driverManager;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.seleniummaven.util.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	public static WebDriver getDriver() {
		
		WebDriver driver = null;
		String browser=ReadPropertyFile.get("browser").trim();
		String runMode = ReadPropertyFile.get("runMode").trim();

		if (browser.equalsIgnoreCase("chrome")) {

			if (runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName(BrowserType.CHROME);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} else if (browser.equalsIgnoreCase("ff")) {

			if (runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName(BrowserType.FIREFOX);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();	
			}

			DriverManager.setDriver(new FirefoxDriver());
		} else {
			System.out.println(browser + "not found.Please pass the correct browser");
		}
		return driver;
	}
	
	
	
}
