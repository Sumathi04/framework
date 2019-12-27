package com.mercury.tours;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignOn_Readpropertiesfiles {
	ChromeDriver driver;
	@Test
	//This is for Sign on Functionality
	public void Sign_On_Successful_Login() throws IOException
	{
		File file=new File("C:\\Selenium Training\\workspace\\Mercury_Tours_HCL_Maven\\Mercury_Tours.properties");
		Properties prop=new Properties();
		FileInputStream fileInput=new FileInputStream(file);
		prop.load(fileInput);
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.findElement(By.linkText(prop.getProperty("Isignon"))).click();
		driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Iuserpass"))).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		//driver.quit();
		
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
