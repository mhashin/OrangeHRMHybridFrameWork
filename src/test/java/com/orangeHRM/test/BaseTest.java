package com.orangeHRM.test;


import org.testng.annotations.BeforeTest;
import com.orangeHRM.pages.BasePage;

public class BaseTest {
	
	
	@BeforeTest
	public void setUp() {
		
		BasePage.intialize();
	}

}
