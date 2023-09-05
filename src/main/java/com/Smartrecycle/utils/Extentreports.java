package com.Smartrecycle.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreports {
	
	public static ExtentReports genarateExtentreports() {
		ExtentReports er=new ExtentReports();
		File extentreportfile=new File("./test-output/ExtentReports/Extentreport.html");
		
		ExtentSparkReporter Sparkreporter=new ExtentSparkReporter(extentreportfile);
		Sparkreporter.config().setTheme(Theme.DARK);
		Sparkreporter.config().setReportName("AGS Automation");
		Sparkreporter.config().setDocumentTitle("SmartRecycle Automation");
		Sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		er.attachReporter(Sparkreporter);
		  
		Properties Configprop=new Properties();
		try {
		FileInputStream fis=new FileInputStream("./src/main/java/com/Smartrecycle/propertyfile/config.properties");
		Configprop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		er.setSystemInfo("Application URL", Configprop.getProperty("URL"));
		er.setSystemInfo("Author", Configprop.getProperty("Author"));
		er.setSystemInfo("Browsername", Configprop.getProperty("Browser"));
		er.setSystemInfo("Username", Configprop.getProperty("username"));
		er.setSystemInfo("password", Configprop.getProperty("password"));
		
		return er;
	}

}
