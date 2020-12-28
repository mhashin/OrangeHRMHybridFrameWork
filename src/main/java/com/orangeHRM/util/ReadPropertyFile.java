package com.orangeHRM.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
	
	public static String get(String key) {
		
		String propertyValue=null;
		Properties prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);
			propertyValue=prop.getProperty(key);
			if(propertyValue==null) {
				throw new Exception("Property named "+propertyValue+ "not found");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return propertyValue;
			
		} 
}
