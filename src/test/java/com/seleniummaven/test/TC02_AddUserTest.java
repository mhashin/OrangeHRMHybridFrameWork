package com.seleniummaven.test;

import org.testng.annotations.Test;

import com.seleniummaven.pages.ContactPage;
import com.seleniummaven.pages.HomePage;
import com.seleniummaven.pages.LoginPage;
import com.seleniummaven.util.ReadPropertyFile;

public class TC02_AddUserTest extends BaseTest {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactpage;
	
	@Test(priority=1)
	public void addUser(){
		
		homePage=new HomePage();
		contactpage=new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.userLogin(ReadPropertyFile.get("userName"), ReadPropertyFile.get("password"));
		contactpage=homePage.createContact();
		
		
	}

}
