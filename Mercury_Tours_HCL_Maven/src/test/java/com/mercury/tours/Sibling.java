package com.mercury.tours;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sibling {
	ChromeDriver driver;
	@Test
	//This is for Sign on Functionality
	public void Sign_On_Successful_Login() throws InterruptedException
	{
		
		 driver.navigate().to("http://newtours.demoaut.com/mercurysignon.php");	
		 driver.findElement(By.xpath("//td[@width='67']//following-sibling::td[1]/a")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//td[@width='77']//preceding-sibling::td[1]/a")).click();
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
