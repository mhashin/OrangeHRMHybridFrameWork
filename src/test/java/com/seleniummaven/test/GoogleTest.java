package com.seleniummaven.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;


	@Test
	public void localTest() {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
				try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://google.co.in");
		System.out.println("Title is : "+driver.getTitle());
		driver.quit();
	}
}
