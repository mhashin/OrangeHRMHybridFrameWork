package com.orangeHRM.listener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangeHRM.util.TestUtil;


public final class ExtentReportListener implements ITestListener {
	
	
	private static final String OUTPUT_FOLDER = "./extendReport/";
	private static final String FILE_NAME = "MKPL_AutomationExecutionReport_"+TestUtil.getCurrentDateTime()+".html";
	private ExtentReports extent = init();
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	private ExtentReports init () {
		
		Path path=Paths.get(getOutputFolder());
		if(!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(getOutputFolder()+getFileName());
	spark.config().setDocumentTitle("Automation Test Report");
	spark.config().setReportName("Orange HRM Report");
	spark.config().setTheme(Theme.STANDARD);
	extent.attachReporter(spark);
	return extent;
	
	}
	
	public synchronized void onTestStart(ITestResult result) {
		System.out.println("Test Suite started!");
		
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		
		test.get().pass("Test passed");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		test.get().fail(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.getScreenshot(result)).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public static String getOutputFolder() {
		return OUTPUT_FOLDER;
	}

	public static String getFileName() {
		return FILE_NAME;
	}
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
