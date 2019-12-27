package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Sign_On_InternetExplorer {
WebDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
	    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		driver.quit();
  }
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutePath=System.getProperty("user.dir");
		//String filepath=absolutePath+"\\IEDriverServer.exe.exe";
		String filepath=absolutePath+"\\Driver"+"\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filepath);	
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
  }

}
