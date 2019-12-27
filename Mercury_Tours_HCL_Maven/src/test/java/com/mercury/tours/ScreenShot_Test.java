package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ScreenShot_Test {
ChromeDriver driver;
String filePath="C:\\Selenium Training\\workspace\\Mercury_Tours_HCL_Maven\\ScreenShot";
  @Test
  public void f() {
	    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("logins")).click();
		
  }
  @AfterMethod
  public void teardown(ITestResult result) throws IOException
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  File Browserscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //FileUtils.copyFile(Browserscreenshot,new File("C:\\Selenium Training\\workspace\\Mercury_Tours_HCL_Maven\\ScreenShot\\login.png"));
		  FileUtils.copyFile(Browserscreenshot, new File(filePath +"/"+result.getName()+"_"+System.nanoTime()+".png"));
	  }
  }
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutePath=System.getProperty("user.dir");
		//String filepath=absolutePath+"\\chromedriver.exe";
		String filepath=absolutePath+"\\Driver"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
  }

}
