package com.mercury.tours;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class UploadFile {
ChromeDriver driver;
//String filePath="C:\\Selenium Training\\workspace\\Mercury_Tours_HCL_Maven\\ScreenShot";
  @Test
  public void testUpload() throws InterruptedException {
	    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\Images\\download.jpg";
		System.out.println(filepath);
		driver.findElement(By.id("btnChooseFiles")).click();
		uploadFile(filepath);
		Thread.sleep(10);
  }
  public static void uploadFile(String fileLocation) {
	  try{
	  StringSelection ss=new StringSelection(fileLocation);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  Robot robot=new Robot();
	  robot.delay(1000);
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.delay(1000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  robot.delay(1000);
	  }catch(Exception exp){
		  exp.printStackTrace();
	  }}
}
 