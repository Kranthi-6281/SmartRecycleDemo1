package com.SmartRecycle.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.internal.thread.ThreadExecutionException;

import com.Smartrecycle.utils.Utiliteis;

public class BaseClass 
{
	 public   WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public BaseClass() {
		dataprop=new Properties();
		try {
		FileInputStream fis2=new FileInputStream("./src/main/java/com/Sr/testdata/testdata.properties");
		dataprop.load(fis2);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		prop=new Properties();
		try {
		FileInputStream fis=new FileInputStream("./src/main/java/com/Smartrecycle/propertyfile/config.properties");
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
			
	}
	public WebDriver StartApplication(String BrowserName) 
	{
		if(BrowserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if(BrowserName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utiliteis.IMPLICIT_Wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utiliteis.Page_Load));
		driver.get(prop.getProperty("URL"));
		return driver;
	
	}
}


