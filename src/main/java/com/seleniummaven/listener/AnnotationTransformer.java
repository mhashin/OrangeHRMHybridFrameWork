package com.seleniummaven.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.seleniummaven.util.DataProviderUtil;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
		annotation.setDataProviderClass(DataProviderUtil.class);
	//	annotation.setRetryAnalyzer(RetryFailedTests.class);
		
	}

}
