package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Mercury_RadioButton {
ChromeDriver driver;
  @Test
  public void SignOn() {
	    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.xpath("//input[@value='oneway']")).click();
		/*WebElement RadioElement =  driver.findElement(By.xpath("//input[@value='oneway']"));
		RadioElement.click();
		boolean res= RadioElement.isSelected();
		System.out.println(res);
		//driver.quit();
*/  
		String str = driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if(str.equalsIgnoreCase("true"))
		{
			System.out.println("Round trip is selected");
		}
		WebElement element= driver.findElement(By.xpath("//input[@value='roundtrip']"));
		Assert.assertEquals(element.isSelected(),true);
		WebElement element1=driver.findElement(By.cssSelector("input[value='Business']"));
		element1.click();
		boolean res=element1.isSelected();
		System.out.println(res);
   
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
