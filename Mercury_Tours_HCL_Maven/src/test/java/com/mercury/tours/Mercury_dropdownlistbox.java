package com.mercury.tours;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_dropdownlistbox {
	ChromeDriver driver;
	@Test(priority=1)
	//This is for Sign on Functionality
	public void Sign_On_Successful_Login()
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Selenium Training\\workspace\\HCL_Mercury_Tours\\chromedriver.exe");
  //ChromeDriver driver=new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		//driver.quit();
		//driver.findElement(By.xpath("//input[@value='oneway']")).click();
	}
	//To search flight
	@Test(priority=2)
	public void Searchflight(){
		WebElement RadioElement =  driver.findElement(By.xpath("//input[@value='oneway']"));
		RadioElement.click();
		boolean res= RadioElement.isSelected();
		System.out.println(res);
		Select SelectPass=new Select(driver.findElement(By.name("passCount")));
		SelectPass.selectByValue("4");
		Select oSelect=new Select(driver.findElement(By.name("fromPort")));
		oSelect.selectByValue("London");
		driver.findElementByXPath("//input[@value='Business']").click();
		driver.findElementByName("findFlights").click();	
		String depart=driver.findElement(By.xpath("//td[@class='title']//font[contains(text(),DEPART')]")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART",depart);
		
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
