package com.Sr.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath="//p[text()='Dashboard']")
	private WebElement DahboardHeading;
	  
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean checkStatus() {
		
		boolean Heading = DahboardHeading.isDisplayed();
		return Heading;
	
	}

}
