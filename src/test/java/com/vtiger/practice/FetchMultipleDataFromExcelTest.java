package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtlity.ILocation;
import com.sdet34l1.genericUtlity.XlsxUtility;

public class FetchMultipleDataFromExcelTest{
	@Test(dataProvider="loginData")
	public void loignTest(String username,String password) 
 {
	Reporter.log(username+"========================> "+password,true);
	
 }
	@DataProvider
	public String[][] loginData() throws EncryptedDocumentException, IOException
	
	 {
		XlsxUtility.openExcel(ILocation.EXCELPATH);
		return XlsxUtility.getMutlipleDataFromExcel("logincredentials");
		
	 }
}