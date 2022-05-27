package com.vtiger.practice;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sdet34l1.genericUtlity.DriverUtility;
import com.sdet34l1.genericUtlity.JavaLangUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorTest {
	static JavaLangUtility jlu=new JavaLangUtility();
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	DriverUtility.intializeJavaScriptExecutor(driver);
	DriverUtility.navigateThroughApplicationByJavaScript("http://localhost:8888");
	driver.manage().window().maximize();
	DriverUtility.findElementThroughJavaScript(driver.findElement(By.name("user_name")),"admin");
	DriverUtility.findElementThroughJavaScript(driver.findElement(By.name("user_password")),"root");
	DriverUtility.clickThroughJavaScript(driver.findElement(By.id("submitButton")));
	DriverUtility.scrollTillElement(driver.findElement(By.xpath("//b[contains(.,'Top Quotes')]")));
	String fileName=new JavaScriptExecutorTest().getClass().getName();
	try {
		DriverUtility.takeScreenShot(fileName,driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
