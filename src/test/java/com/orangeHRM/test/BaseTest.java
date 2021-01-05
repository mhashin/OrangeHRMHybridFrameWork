package com.orangeHRM.test;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.orangeHRM.driverManager.DriverManager;
import com.orangeHRM.pages.BasePage;

public class BaseTest {
	
	
	@BeforeTest
	public void setUp() {
		
		BasePage.intialize();
	}
	
	@AfterTest
	public void tearDown() {
		DriverManager.getDriver().quit();
	}

}
