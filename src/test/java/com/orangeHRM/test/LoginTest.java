package com.orangeHRM.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.listener.ExtentReportListener;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.util.ReadPropertyFile;

public final class LoginTest extends BaseTest {

	HomePage homePage;
	LoginPage loginPage;

	@Test
	public void userLogin() {
		loginPage = new LoginPage();
		homePage = loginPage.userLogin(ReadPropertyFile.get("userName"), ReadPropertyFile.get("password"));
		String actualWelcomeText=homePage.verifyWelcomeText("Welcome");
		Assert.assertEquals(actualWelcomeText,"Welcome Paul");
		ExtentReportListener.getExtentTest().info("Home page is displayed with logged in user : "+actualWelcomeText);
		
	}
}
