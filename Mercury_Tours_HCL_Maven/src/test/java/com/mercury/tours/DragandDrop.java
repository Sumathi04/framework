package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DragandDrop {
ChromeDriver driver;
  @Test
  public void f() throws InterruptedException {
	   driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
	   Thread.sleep(5000);
	   Actions action=new Actions(driver);
	   WebElement drag=driver.findElementById("draggable");
	   WebElement drop=driver.findElementById("droppable");
	   action.dragAndDrop(drag,drop).build().perform();
	  Thread.sleep(5000);
	  // driver.quit();
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