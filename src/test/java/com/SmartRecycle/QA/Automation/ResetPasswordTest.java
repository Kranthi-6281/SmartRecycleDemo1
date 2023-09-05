package com.SmartRecycle.QA.Automation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SmartRecycle.Base.BaseClass;
import com.Sr.qa.pom.ForgetPWPage;
import com.Sr.qa.pom.LoginPage;
import com.Sr.qa.pom.ResetPaswordpage;

public class ResetPasswordTest extends BaseClass{
	LoginPage l;
	ForgetPWPage fwp;
	ResetPaswordpage Reset;
	public ResetPasswordTest() {
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=StartApplication(prop.getProperty("Browser"));
	}
	@AfterMethod
	public void tearDown() {
		try{
		driver.quit();
		}catch(Exception e) {
			
		}
	}
	@Test(priority=1)
	public void verifyOtpFeild() {
		l=new LoginPage(driver);
		l.ForPwdlink();
		fwp=new ForgetPWPage(driver);
		 Reset = fwp.Verifywithemail(prop.getProperty("username"));
		Assert.assertTrue(Reset.OtpDisplayed());
	}
	@Test(priority=2)
	public void verifyNewpasswordfeild() {
		l=new LoginPage(driver);
		l.ForPwdlink();
		fwp=new ForgetPWPage(driver);
		Reset = fwp.Verifywithemail(prop.getProperty("username"));
		Assert.assertTrue(Reset.Newpasswordfeild());
    }
	@Test(priority=3)
	public void verifyConfirmpwd() {
		l=new LoginPage(driver);
		l.ForPwdlink();
		fwp=new ForgetPWPage(driver);
		Reset = fwp.Verifywithemail(prop.getProperty("username"));
		Assert.assertTrue(Reset.Confirmdisplay());
	}
}