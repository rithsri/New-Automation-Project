/**
 * 
 */
package com.hibu.hppd.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author IB1429
 *
 */
public class HelpText {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		Properties OR;
		// LOAD OR
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"+ File.separator + "resources" + File.separator + "OR.properties");
		OR.load(fs);
		System.setProperty("webdriver.chrome.driver", "D://Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hibu--config03.cs15.my.salesforce.com/001e000000wzbsM");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		driver.findElement(By.id("username")).sendKeys("hemalatha.bondalapati@hibu.com.config03");  //aakash.preetam@hibu.com.config03 //hemalatha.bondalapati@hibu.com.config03
		driver.findElement(By.name("pw")).sendKeys("Hemalatha@123"); //Office$101 //Hemalatha@123
		WebElement login = driver.findElement(By.id("Login"));
		login.click();		
		driver.findElement(By.id("emc")).sendKeys("39540");
		driver.findElement(By.id("save")).click();

	    long startTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

		driver.findElement(By.name("customer_dashboard")).click();

		long endTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

		int totaltime = (int) (endTime - startTime);

		System.out.println("Total loading time for OverView Page is " + totaltime + "Secs");

		Thread.sleep(30000);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		String title = driver.getTitle();
		System.out.println("switched" + title);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 500)", "");
		// website analytics
		//long startTimeWebsite = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		driver.findElement(By.xpath("//*[@id='overview-wrapper']/div/div[3]/div[1]/div/div[1]/div[1]/a/span")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.cssSelector("#header > nav.navbar-inverse > div.container > div:nth-Child(2) > ul.navbar-nav > li:nth-Child(3) > a.active")).click();
		Thread.sleep(4000);
		
		//jse.executeScript("window.scrollBy(0, 00)", "");
		driver.findElement(By.xpath("//*[@id='website-wrapper']/div[3]/div[1]/div/button")).click();
		File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType.FILE);	
		FileUtils. copyFile(src, new File("D:/Selenium/KPI.png"));		
		Thread.sleep(6000);
		
		jse.executeScript("window.scrollBy(0, 600)", "");
		driver.findElement(By.xpath("//*[@id='website-wrapper']/div[4]/div[1]/div[2]/button")).click();
		File src1= ((TakesScreenshot)driver). getScreenshotAs(OutputType.FILE);	
		FileUtils. copyFile(src1, new File("D:/Selenium/CrossProductUplift.png"));		
		Thread.sleep(6000);
		
		jse.executeScript("window.scrollBy(0, 600)", "");
		driver.findElement(By.xpath("//*[@id='website-wrapper']/div[5]/div[1]/div[2]/button[2]")).click();
		File src2= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);	
		FileUtils. copyFile(src2, new File("D:/Selenium/MonthlyActivity.png"));		
		Thread.sleep(6000);
		
		jse.executeScript("window.scrollBy(0, 600)", "");
		driver.findElement(By.xpath("//*[@id='performance_detail']/div[1]/div[2]/button[2]")).click();
		File src3= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);	
		FileUtils. copyFile(src3, new File("D:/Selenium/WebsitePerformance.png"));		
		Thread.sleep(6000);
		
		jse.executeScript("window.scrollBy(0, 600)", "");
		driver.findElement(By.xpath("//*[@id='website-wrapper']/div[7]/div[1]/div[2]/button[2]")).click();
		File src4= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);	
		FileUtils. copyFile(src4, new File("D:/Selenium/MostVisited.png"));		
		Thread.sleep(6000);
		jse.executeScript("window.scrollBy(0, 600)", "");
		driver.findElement(By.xpath("//*[@id='website-wrapper']/div[8]/div[1]/div[2]/button[2]")).click();
		File src5= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);	
		FileUtils. copyFile(src5, new File("D:/Selenium/ReferringSites.png"));		
		Thread.sleep(6000);
	}

}
