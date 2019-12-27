package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Mousehover_Example {
ChromeDriver driver;
  @Test
  public void f() throws InterruptedException {
	   driver.get("https://www.yatra.com");
	   WebElement element=driver.findElementByXPath("//a[contains(text(),'My Account')]");
	   Actions action=new Actions(driver);
	   action.moveToElement(element).build().perform();
	   driver.findElementById("signInBtn").click();
	   }
 
  
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutePath=System.getProperty("user.dir");
		//String filepath=absolutePath+"\\chromedriver.exe";
		String filepath=absolutePath+"\\Driver"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
  }}