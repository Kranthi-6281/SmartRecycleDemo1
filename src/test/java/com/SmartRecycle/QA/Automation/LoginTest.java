package com.SmartRecycle.QA.Automation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SmartRecycle.Base.BaseClass;
import com.Sr.qa.pom.DashboardPage;
import com.Sr.qa.pom.LoginPage;

public class LoginTest extends BaseClass
{
	LoginPage l;
	DashboardPage d;
	public LoginTest() {
		super();
	}
	public  WebDriver driver;
	@BeforeMethod
	public void Setup() {
		driver=StartApplication(prop.getProperty("Browser"));
	}
	@AfterMethod
	public void tearDown()  {
		try{
			driver.quit();
			}catch(Exception e) {
				
			}
	}
	@Test(priority=1)
	public void verifywithValiddata() {
		 l=new LoginPage(driver);
		 l.login(prop.getProperty("username"), prop.getProperty("password"));
		 d=new DashboardPage(driver);
		 Assert.assertTrue(d.checkStatus(),"Dashboard page is not displaying");
	}
	@Test(priority = 3)
	public void verifywithNodata() {
		l=new LoginPage(driver);
		l.withNodata();
		Assert.assertEquals(l.Usernameerrormsg(), dataprop.getProperty("usernameermsg"));
		Assert.assertEquals(l.Pwderrortext(), dataprop.getProperty("passworderrmsg"));
	}
	@Test(priority = 4)
	public void verifyemptyUNwithvalidPw() throws InterruptedException {
		l=new LoginPage(driver);
		l.login(dataprop.getProperty("Nousername"), prop.getProperty("password"));
		Assert.assertEquals(l.Usernameerrormsg(), dataprop.getProperty("usernameermsg"));
	}
	@Test(priority = 5)
	public void verifywithEmptypassword() throws InterruptedException {
		l=new LoginPage(driver);
		l.login(prop.getProperty("username"), dataprop.getProperty("Nopwd"));
		Assert.assertEquals(l.Pwderrortext(), dataprop.getProperty("passworderrmsg"));
	}
	@Test(priority=2, dependsOnMethods= {"verifywithEmptypassword"} )
	public void verifyCompanyrights() {
		l=new LoginPage(driver);
	Assert.assertEquals(l.RightsCompany(),dataprop.getProperty("rightsmsg"));
	}
}
