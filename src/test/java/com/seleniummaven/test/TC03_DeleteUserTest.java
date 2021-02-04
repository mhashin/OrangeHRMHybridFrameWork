package com.seleniummaven.test;

import org.testng.annotations.Test;

import com.seleniummaven.pages.ContactPage;
import com.seleniummaven.pages.HomePage;
import com.seleniummaven.pages.LoginPage;
import com.seleniummaven.util.ReadPropertyFile;

public class TC03_DeleteUserTest extends BaseTest {
	
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;
	
	@Test
	public void verifyDeleteUser() {
	
	loginPage = new LoginPage();
	homePage = loginPage.userLogin(ReadPropertyFile.get("userName"), ReadPropertyFile.get("password"));
	
	homePage.clickContact();
	contactpage.selectCheckbox("Test Hashin");
	
	}

}
