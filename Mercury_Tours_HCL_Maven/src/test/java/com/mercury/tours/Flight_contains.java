package com.mercury.tours;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight_contains {
	ChromeDriver driver;
	@Test
	//This is for Sign on Functionality
	public void Sign_On_Successful_Login()
	{
		
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		//driver.quit();
		driver.findElement(By.name("findFlights")).click();
		String depart=driver.findElement(By.xpath("//td[@class='title']//font[contains(text(),DEPART')]")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART",depart);
	}
	@BeforeTest
public void LaunchBrowser()
{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium Training\\workspace\\HCL_Mercury_Tours\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://newtours.demoaut.com/mercurysignon.php");
}
	@AfterTest
public void CloseBrowser()
{
	
}
}
