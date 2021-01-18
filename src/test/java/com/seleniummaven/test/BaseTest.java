package com.seleniummaven.test;


import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.seleniummaven.pages.BasePage;

public class BaseTest {
	
	public SoftAssert softassert;
	
	@BeforeTest
	public void setUp() {
		
		BasePage.intialize();
		softassert=new SoftAssert();
		
	}
	
	/*@AfterTest
	public void tearDown() {
		DriverManager.getDriver().quit();
	}
*/
}
