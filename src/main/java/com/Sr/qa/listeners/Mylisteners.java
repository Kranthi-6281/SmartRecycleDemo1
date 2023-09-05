package com.Sr.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Smartrecycle.utils.Extentreports;
import com.Smartrecycle.utils.Utiliteis;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Mylisteners  implements ITestListener{
	ExtentReports extentReport;
	ExtentTest extentTest;
	String text;
	
	@Override
	public void onStart(ITestContext context) {
		 extentReport = Extentreports.genarateExtentreports();
	
	}
	@Override
	public void onTestStart(ITestResult result) {
		 text=result.getName();
		extentTest = extentReport.createTest(text);
		extentTest.log(Status.INFO, text+" got started succesfully");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS,text+" got successsfully executed" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		  
		     extentTest.log(Status.INFO, result.getThrowable());
		     extentTest.log(Status.FAIL, text+" got failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, text+" got Skipped");
		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		
	}
	

}
