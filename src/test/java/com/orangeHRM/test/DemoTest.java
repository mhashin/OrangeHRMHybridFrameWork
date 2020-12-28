package com.orangeHRM.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.orangeHRM.util.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase(ReadPropertyFile.get("browser"))) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase(ReadPropertyFile.get("browser2"))) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			throw new Exception("incorrect browser");
		}
		
		driver.get("http://google.com");
	}
	

}
