package com.Sr.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPWPage 
{
	 WebDriver driver;
    @FindBy(xpath="//span[text()='FORGOT PASSWORD']")
    private WebElement frpwd;
    @FindBy(id="UserName")
    private WebElement Usernamefeild;
    @FindBy(linkText="Login")
    private WebElement Loginlink;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement signinbtn;
	 @FindBy(xpath="//div[@class='modal-body']/label[text()=' Details not found']")
	 private WebElement Errmsg;
    
    public ForgetPWPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    public String verifytheForgetpasswordtext() {
    	String text=frpwd.getText();
    	return text;
    }
    public ResetPaswordpage Verifywithemail(String username) {
    	Usernamefeild.sendKeys(username);
    	signinbtn.click();
    	return new ResetPaswordpage(driver);
    }
    public boolean getWarningText() {
    	boolean Warning =Errmsg.isDisplayed();
         return Warning;
    }
    public boolean Signinbtndisplay() {
    	boolean sgnin=signinbtn.isDisplayed();
    	return sgnin;
    }
}
