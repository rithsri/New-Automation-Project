package com.hibu.hppd.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	
	public WebDriver driver;
	
  @Test
  public void f() {
  }
  
  @BeforeClass
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D://Softwares/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hibu--config03.cs15.my.salesforce.com/001e000000wzbsM"); //001e000000wzbsM  001e000000xDPza
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
  }
  
  @BeforeMethod
  public void login() throws InterruptedException {
	  driver.findElement(By.id("username")).sendKeys("hemalatha.bondalapati@hibu.com.config03");
	  driver.findElement(By.name("pw")).sendKeys("Hemalatha@123");
	  WebElement login = driver.findElement(By.id("Login"));
	  login.click(); 
	  /*		driver.findElement(By.id("emc")).sendKeys("73364");
		driver.findElement(By.id("save")).click();*/
	  Thread.sleep(1000); 
	  driver.findElement(By.name("customer_dashboard")).click();
	  Thread.sleep(30000);
	  ArrayList<String> newWindowHandle = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(newWindowHandle.get(1));	    
	  String title = driver.getTitle();
	  System.out.println("switched to ----"+title);
  }

  @AfterMethod
  public void logout() {
  }



  @AfterClass
  public void quitBrowser() {
  }

}
