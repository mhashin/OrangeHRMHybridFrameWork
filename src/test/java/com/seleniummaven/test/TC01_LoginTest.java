package com.seleniummaven.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniummaven.pages.ContactPage;
import com.seleniummaven.pages.HomePage;
import com.seleniummaven.pages.LoginPage;
import com.seleniummaven.reports.ExtentLogger;
import com.seleniummaven.util.DataProviderUtil;

public final class TC01_LoginTest extends BaseTest {

	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactpage;

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtil.class)
	public void userValidLoginTest(Map<String, String> data) {
		loginPage = new LoginPage();
		homePage = loginPage.userLogin(data.get("UserName"), data.get("Password"));
		String actualWelcomeText = homePage.verifyWelcomeText("Hashin PK");
		softassert.assertEquals(actualWelcomeText, "Hashin PK");
		homePage.doLogout();		
	}

	/*@Test(priority=2,dataProvider = "getData", dataProviderClass = DataProviderUtil.class)
	public void userInvalidLoginTest(Map<String, String> data) {
		loginPage = new LoginPage();
		homePage = loginPage.userLogin(data.get("UserName"), data.get("Password"));
		String actualErrorText=loginPage.errorTextInvalidLogin();
		Assert.assertEquals(actualErrorText,"Invalid credentials","Invalid credentials text not matched");
		ExtentLogger.info("Error text is displayed as :"+actualErrorText);
	}*/
	
	
	
}
