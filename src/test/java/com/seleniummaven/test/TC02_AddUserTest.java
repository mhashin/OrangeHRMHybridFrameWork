package com.seleniummaven.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniummaven.pages.ContactPage;
import com.seleniummaven.pages.HomePage;
import com.seleniummaven.pages.LoginPage;
import com.seleniummaven.util.ReadPropertyFile;

public class TC02_AddUserTest extends BaseTest {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactpage;

	
	
	/*@Test(priority=1,dataProvider="createContact",dataProviderClass=DataProviderUtil.class)
	public void addUser(Map<String,String> data){
		
		homePage=new HomePage();
		contactpage=new ContactPage();
		loginPage = new LoginPage();
		createcontact=new CreateNewContactPage();
		
		homePage = loginPage.userLogin(ReadPropertyFile.get("userName"), ReadPropertyFile.get("password"));
		contactpage=homePage.createContact();
		contactpage.enterFirstName(data.get("Fname"));
		contactpage.enterLastName(data.get("Lname"));
		createcontact.selectCategory(data.get("Category"));
		createcontact.clickSave();
		
	}*/
	
	@Test
	public void verifyUserIsCreated() throws InterruptedException {
		homePage=new HomePage();
		contactpage=new ContactPage();
		loginPage = new LoginPage();
	
		homePage = loginPage.userLogin(ReadPropertyFile.get("userName"), ReadPropertyFile.get("password"));
		homePage.clickContact();
		contactpage.selectCheckbox("Test Hashin");
		String actualUser=contactpage.verifyCreatedUser("Test Hashin");
		Assert.assertEquals(actualUser, "Test Hashin","created contact is not displayed");
	}

}
