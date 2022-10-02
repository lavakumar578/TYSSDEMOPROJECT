package com.tyss.demo.testScript;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.demo.baseutil.BaseClass;
import com.tyss.demo.pages.HomePage;
import com.tyss.demo.pages.LoginPage;
import com.tyss.demo.pages.TaskListPage;
import com.tyss.demo.data.XlsxUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCustomerTest extends BaseClass{

	@Test
	public void createNewCustomerTest() {
		LoginPage loginPage=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		TaskListPage	taskListPage=new TaskListPage(driver);
		String act=homePage.tasks();
		String []actual=act.substring(0, 4).split(" ");
		String []expected=driver.getTitle().split(" ");		
		Assert.assertTrue(actual[0].contains(expected[2]), actual+" is not validated");
		logger.info("Task page is displayed");
		String actName=taskListPage.addCustomer(XlsxUtility.getDataFromExcelSheet("sheet1", 0, 0)+randomNum,XlsxUtility.getDataFromExcelSheet("sheet1", 0, 1)+randomNum);
		logger.info(actName+" customer has been created");
	}
	
	
}
