package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CrossBrowser_Example extends ApplicationTestData{
  
  WebDriver driver;
  @Test(dataProvider="Login")
  public void Login(String baseurl,String uname,String password) throws InterruptedException {
	       // driver.get("http://newtours.demoaut.com/mercurysignon.php");
	  		driver.get(baseurl);
	  		driver.manage().window().maximize();
	  		Thread.sleep(3000);
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			Thread.sleep(1000);
			driver.findElement(By.name("password")).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.name("login")).click();
			Thread.sleep(3000);
  }
  @BeforeTest
  @Parameters("browser")
  public void setup(String browser) throws InterruptedException {
	  if(browser.equalsIgnoreCase("firefox")){
		  String absolutePath=System.getProperty("user.dir");
			//String filepath=absolutePath+"\\IEDriverServer.exe.exe";
			String filepath=absolutePath+"\\Driver"+"\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", filepath);	
			driver=new FirefoxDriver();
			Thread.sleep(3000);
			//driver.manage().window().maximize();
			//driver.get("http://newtours.demoaut.com/mercurysignon.php");
	  }
	  else if(browser.equalsIgnoreCase("chrome")){
		    String absolutePath=System.getProperty("user.dir");
			//String filepath=absolutePath+"\\chromedriver.exe";
			String filepath=absolutePath+"\\Driver"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filepath);	
			driver=new ChromeDriver();  
			Thread.sleep(3000);
			//driver.manage().window().maximize();
			//driver.get("http://newtours.demoaut.com/mercurysignon.php");
	  }
	  else if(browser.equalsIgnoreCase("ie")){
		  String absolutePath=System.getProperty("user.dir");
			//String filepath=absolutePath+"\\chromedriver.exe";
			String filepath=absolutePath+"\\Driver"+"\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", filepath);	
			driver=new InternetExplorerDriver(); 
			Thread.sleep(3000);
			//driver.manage().window().maximize();
			//driver.get("http://newtours.demoaut.com/mercurysignon.php");
	  }
		//driver.manage().window().maximize();
		//driver.get("http://newtours.demoaut.com/mercurysignon.php");
  
  }}
