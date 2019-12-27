package com.mercury.tours;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	ChromeDriver driver;
	@Test(priority=2)
	//This is for Sign on Functionality
	public void Sign_On_Successful_Login()
	{
		test = extent.createTest("Test case 2","Login to Mercury Web Application");
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElementByPartialLinkText("SIGN").click();		
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
			
	}
	@Test(priority=1)
public void LaunchBrowser()
{
	test = extent.createTest("Test case 2","Login to Mercury Web Application");
	System.setProperty("webdriver.chrome.driver","C:\\Selenium Training\\workspace\\HCL_Mercury_Tours\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://newtours.demoaut.com/mercurysignon.php");
}
	@BeforeTest
	
public void StartReport()
{
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("OS","Window 10");
	extent.setSystemInfo("Browser","Firefx 60+");
	//htmlReporter.config().setchartVisibilityonopen(true);
	htmlReporter.config().setDocumentTitle("Extent document demo");
	htmlReporter.config().setReportName("Test Report");
	htmlReporter.config().setTheme(Theme.STANDARD);
	htmlReporter.config().setTimeStampFormat("EEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	
}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED",ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED",ExtentColor.GREEN));
		}
		else{
				test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED",ExtentColor.ORANGE));	
				test.fail(result.getThrowable());
		}
			}

	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
		extent.flush();
	}
	
}
