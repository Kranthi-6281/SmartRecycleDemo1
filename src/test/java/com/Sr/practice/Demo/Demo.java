package com.Sr.practice.Demo;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo  {
	 static WebDriver driver;
	
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://182.74.225.102:5589/smartrecycle");
	
		driver.findElement(By.id("UserID")).sendKeys("mgr123");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String dashboard = driver.findElement(By.xpath("//p[text()='Dashboard']")).getText();
		if(dashboard.equals("Dashboard")) {
			System.out.println("test case passed");
		}else {
			System.out.println("test case is failed");
		}
		
		
		driver.quit();
		
	}
	
	

}
