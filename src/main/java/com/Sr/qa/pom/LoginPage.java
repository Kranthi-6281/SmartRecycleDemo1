package com.Sr.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="UserID")
	private WebElement UserName;
	
	@FindBy(id="Password")
	private WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement lgbtn;
	
	@FindBy(xpath="//div[@id='username-field']/label[text()='Please provide Username']")
	private WebElement UnErrmsg;
	
	@FindBy(xpath="//div[@id='password-field']/label[text()='Please provide password']")
	private WebElement PwdErrmsg;
	@FindBy(xpath="//span[text()='© 2023. Smart Recycle. All Rights Reserved.']")
	private WebElement RightsStatement;
	
	@FindBy(linkText="Forgot password?")
	private WebElement Forgetpassword;
	
	@FindBy(xpath="//span[text()='SIGN IN']")
	private WebElement signintext;
	
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un ,String pwd) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		lgbtn.click();
		
	}
	public void withNodata() {
		lgbtn.click();
	
	}
	public String Usernameerrormsg() {
		String unerrtext = UnErrmsg.getText();
		return unerrtext;
	}
	public String Pwderrortext() {
		String pwderrtext = PwdErrmsg.getText();
		return pwderrtext;
	}
	public String RightsCompany() {
		String Companyrights=RightsStatement.getText();
		return Companyrights;
		
	}
	public void ForPwdlink() {
		Forgetpassword.click();
		
	}
	

}
