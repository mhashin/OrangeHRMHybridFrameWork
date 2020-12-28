package com.orangeHRM.pages;

import com.orangeHRM.util.ElementUtil;

public final class HomePage  {
	
	private String welcome_xpath="//a[contains(text(),'%replace%')]";
	

	
	public String verifyWelcomeText(String value) {
		return ElementUtil.dynamicWebElement(welcome_xpath, value).getText();
	}
	
	

}
