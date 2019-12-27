package com.mercury.tours;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ApplicationTestData {
	@DataProvider(name="Login")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]{
			
			{"http://newtours.demoaut.com/mercurysignon.php","testing","testing"},
			{"http://newtours.demoaut.com/mercurysignon.php","dixit","dixit"},
			{"http://newtours.demoaut.com/mercurysignon.php","testabhi","testabhi"}
	};
	}
	@DataProvider(name="LoginDataXLS")
	public Object[][] ExcelXLS() throws IOException{
		Readexcel_xls excel=new Readexcel_xls();
		Object[][] testObjArray=excel.getExcelData("C:\\Selenium Training\\workspace\\Mercury_Tours_HCL_Maven\\Excel\\Mercury_Tours.xls", "Sign_On");
		return testObjArray;
	}
	@DataProvider(name="LoginDataXLSX")
	public Object[][] ExcelXLSX() throws IOException{
		Readexcel_XLSX excel=new Readexcel_XLSX();
		Object[][] testObjArray=excel.getExcelData("url", "C:\\Selenium Training\\workspace\\Mercury_Tours_HCL_Maven\\Excel\\Mercury_Tours.xlsx", "Sign_On");
		return testObjArray;
      }
}
