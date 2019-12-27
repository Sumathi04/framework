package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HdfcNetbanking {
ChromeDriver driver;
  @Test
  public void f() throws InterruptedException {
	    driver.get("https://netbanking.hdfcbank.com/netbanking/");
	    Thread.sleep(3000);
		//WebElement value=driver.findElementByName("fldLoginUserId");
	    driver.switchTo().frame("login_page");
	    driver.findElementByName("fldLoginUserId").sendKeys("1000");
	   // driver.findElement(By.xpath("//img[@alt='continue']")).click();
	    driver.findElement(By.cssSelector("img[alt='continue")).click();
	    
	    driver.switchTo().defaultContent();
		//driver.findElement(By.name("login")).click();
		//driver.quit();
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
