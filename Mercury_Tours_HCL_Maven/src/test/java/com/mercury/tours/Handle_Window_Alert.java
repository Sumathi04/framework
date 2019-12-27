package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Handle_Window_Alert {
WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	    driver.get("https://netbanking.hdfcbank.com/netbanking/");
	    Thread.sleep(3000);
		driver.switchTo().frame("login_page");
	    driver.findElement(By.cssSelector("img[alt='continue")).click();
		String ActTest = driver.switchTo().alert().getText();
	    String ExpTest="Customer ID  cannot be left blank.";
	    Assert.assertEquals(ActTest, ExpTest);
	    driver.switchTo().alert().accept();
	   
	   
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
