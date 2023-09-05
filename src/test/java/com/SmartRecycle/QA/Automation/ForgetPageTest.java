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

public class ForgetPageTest extends BaseClass
{
	
	LoginPage l;
	ForgetPWPage fwp;
	ResetPaswordpage resetpwd;
	public ForgetPageTest() {
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
public void verifyForgetpasswordLink() {
	l=new LoginPage(driver);
	l.ForPwdlink();
	fwp=new ForgetPWPage(driver);
	Assert.assertEquals(fwp.verifytheForgetpasswordtext(), dataprop.getProperty("forgetpasswordheading"));
}
@Test(priority=2)
public void Verifyfrpwwithvalidemail() {
	l=new LoginPage(driver);
	l.ForPwdlink();
	fwp=new ForgetPWPage(driver);
	resetpwd = fwp.Verifywithemail(prop.getProperty("username"));
	Assert.assertEquals(resetpwd.VerifyResetHeadingText(), dataprop.getProperty("resetpwdHedtext"));
}
@Test(priority=3)
public void VerifyFrpwdwithInvalidata() {
	l=new LoginPage(driver);
	l.ForPwdlink();
	fwp=new ForgetPWPage(driver);
	fwp.Verifywithemail(dataprop.getProperty("Inavalidusername"));
	Assert.assertTrue(fwp.getWarningText());
}
@Test(priority=4)
public void VerifySigninbtn() {
	l=new LoginPage(driver);
	l.ForPwdlink();
	fwp=new ForgetPWPage(driver);
	Assert.assertTrue(fwp.Signinbtndisplay());
}
}
