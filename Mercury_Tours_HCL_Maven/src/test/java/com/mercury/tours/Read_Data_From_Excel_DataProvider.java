package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Read_Data_From_Excel_DataProvider extends ApplicationTestData{
ChromeDriver driver;
  @Test(dataProvider="LoginDataXLS")
  public void Sign_On(String uname,String password) 
  {
	    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.name("SIGN-OFF")).click();
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
