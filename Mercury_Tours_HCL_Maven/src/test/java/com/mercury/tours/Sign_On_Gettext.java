package com.mercury.tours;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sign_On_Gettext {
	@Test
	//This is for Sign on Functionality
	public void Sign_On_Successful_Login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Training\\workspace\\HCL_Mercury_Tours\\chromedriver.exe");
  ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		
		WebElement element=driver.findElement(By.linkText("SIGN-OFF"));
		String ActValue=element.getText();
		String ExpValue="SIGN-OFF";
		System.out.println(ActValue);
		Assert.assertEquals(ActValue, ExpValue);
		String ExpUrl="http://newtours.demoaut.com/mercuryreservation.php";
		String ActUrl=driver.getCurrentUrl();
		System.out.print(driver.getCurrentUrl());
		Assert.assertEquals(ExpUrl, ActUrl);
		String ExpTitle="Find a Flight: Mercury Tours:";
		String ActTitle=driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(ActTitle, ExpTitle);
		element.click();
		driver.quit();
		
	}

}
