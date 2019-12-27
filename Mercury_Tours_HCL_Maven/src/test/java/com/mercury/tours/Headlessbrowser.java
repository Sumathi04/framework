package com.mercury.tours;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Headlessbrowser {
	ChromeDriver driver;
	ChromeOptions options;
	  @Test
	  public void f() {
		    driver.get("http://newtours.demoaut.com/mercurysignon.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("login")).click();
			driver.quit();
	  }
	  @BeforeTest
	  public void LaunchBrowser() {
		  options=new ChromeOptions();
		  options.setHeadless(true);
		  String absolutePath=System.getProperty("user.dir");
			//String filepath=absolutePath+"\\chromedriver.exe";
			String filepath=absolutePath+"\\Driver"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filepath);	
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
	  }

	  @AfterTest
	  public void CloseBrowser() {
	  }

	}
