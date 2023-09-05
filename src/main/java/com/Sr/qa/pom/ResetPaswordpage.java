package com.Sr.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPaswordpage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='RESET PASSWORD']")
	private WebElement Resetpasswordtext;
	@FindBy(xpath="//span[text()='OTP Successfully send to va******@adventglobal.com']")
	private WebElement sendotpTo;
	@FindBy(id="Otp")
	private WebElement OtptextFeild;
	@FindBy(id="NewPassword")
	private WebElement Newpaswordfeild;
	@FindBy(id="ConfirmPassword")
	private WebElement ConfirmpasswordFeild;
	
	public ResetPaswordpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyResetHeadingText() {
		String Headtext=Resetpasswordtext.getText();
		return Headtext;
	}
	public boolean OtpDisplayed() {
		boolean otpdisplay = OtptextFeild.isDisplayed();
		return otpdisplay;
	}
	public boolean Newpasswordfeild() {
		boolean newpwddisplay = Newpaswordfeild.isDisplayed();
		return newpwddisplay;
	}
	public boolean Confirmdisplay() {
		boolean Confirmpwddisply = ConfirmpasswordFeild.isDisplayed();
		return Confirmpwddisply;
	}
		
	

}
