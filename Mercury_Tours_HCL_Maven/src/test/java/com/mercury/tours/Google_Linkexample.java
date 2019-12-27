package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Google_Linkexample {
ChromeDriver driver;
  @Test
public void navigateToAllLinks() throws InterruptedException{
driver.manage().window().maximize();
driver.navigate().to("http://www.google.co.in/");
List<WebElement> linksize=driver.findElements(By.tagName("a"));
int linkCount=linksize.size();
System.out.println("Total no of links Available:" +linkCount);
String[] links=new String[linkCount];
System.out.println("List of links Available");
for(int i=0;i<linkCount;i++){
	links[i]=linksize.get(i).getAttribute("href");
	System.out.println(linksize.get(i).getAttribute("href"));
}
for(int i=0;i<linkCount;i++){
	driver.navigate().to(links[i]);
}
	  
	 Thread.sleep(3000); 
	  
	  
	  
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