package com.orangeHRM.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangeHRM.listener.ExtentReportListener;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.util.DataProviderUtil;

public final class LoginTest extends BaseTest {

	HomePage homePage;
	LoginPage loginPage;

	@Test(priority=1,dataProvider = "getData", dataProviderClass = DataProviderUtil.class)
	public void userValidLoginTest(Map<String, String> data) {
		loginPage = new LoginPage();
		homePage = loginPage.userLogin(data.get("UserName"), data.get("Password"));
		String actualWelcomeText = homePage.verifyWelcomeText("Welcome");
		Assert.assertEquals(actualWelcomeText, "Welcome Paul");
		ExtentReportListener.getExtentTest().info("Home page is displayed with logged in user : " + actualWelcomeText);
		homePage.clickWelcomeLink();
		homePage.clickLogOut();
	}

	@Test(priority=2,dataProvider = "getData", dataProviderClass = DataProviderUtil.class)
	public void userInvalidLoginTest(Map<String, String> data) {
		loginPage = new LoginPage();
		homePage = loginPage.userLogin(data.get("UserName"), data.get("Password"));
		String actualErrorText=loginPage.errorTextInvalidLogin();
		Assert.assertEquals(actualErrorText,"Invalid credentials","Invalid credentials text not matched");
		ExtentReportListener.getExtentTest().info("Error text is displayed as :"+actualErrorText);
	}
}
