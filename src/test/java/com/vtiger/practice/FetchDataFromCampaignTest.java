package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.sdet34l1.genericUtlity.ILocation;
import com.sdet34l1.genericUtlity.JavaLangUtility;
import com.sdet34l1.genericUtlity.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromCampaignTest {
public static void main(String[] args) throws IOException {

	JavaLangUtility jlu=new JavaLangUtility();
	PropertiesUtility.openPropertyFile(ILocation.PROPERTYPATH);
	String timeout=PropertiesUtility.getDataFromProperty("timeOut");
	long longTimeOut=jlu.stringToLong(timeout);
	
	FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook book = WorkbookFactory.create(fis1);
	Sheet sh = book.getSheet("campaign");
	Row row = sh.getRow(2);
	Cell cell = row.getCell(1);
	int randomNum=jlu.getRandomNumber(1000);
	String data = cell.getStringCellValue()+randomNum;
	String actual=data;
	WebDriver driver=null;
	switch(PropertiesUtility.getDataFromProperty("browser"))
	{
	case "chrome":
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		}
	case "Edge":
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		}
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	driver.get(PropertiesUtility.getDataFromProperty("url"));
	driver.findElement(By.name("user_name")).sendKeys(PropertiesUtility.getDataFromProperty("userName"));
	driver.findElement(By.name("user_password")).sendKeys(PropertiesUtility.getDataFromProperty("password"));
	driver.findElement(By.id("submitButton")).click();
	if(driver.getTitle().contains("Home"))
	{
		book.getSheet("campaign").getRow(10).createCell(6).setCellValue("Home page is Displayed");
		book.getSheet("campaign").getRow(10).createCell(7).setCellValue("pass");
	}
	driver.findElement(By.xpath("//a[text()='More']")).click();
	driver.findElement(By.name("Campaigns")).click();
	if(driver.getTitle().contains("Campaigns"))
	{
		book.getSheet("campaign").getRow(11).createCell(6).setCellValue("Campaigns page is Displayed");
		book.getSheet("campaign").getRow(11).createCell(7).setCellValue("pass");
	}
	driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
	String res=driver.findElement(By.className("lvtHeaderText")).getText();
	if(res.contains("Creating New Campaign"))
	{
		book.getSheet("campaign").getRow(12).createCell(6).setCellValue("create Campaigns page is Displayed");
		book.getSheet("campaign").getRow(12).createCell(7).setCellValue("pass");
	}
	driver.findElement(By.name("campaignname")).sendKeys(actual);
	driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
	String res1=driver.findElement(By.className("dvHeaderText")).getText();
	if(res1.contains("Campaign Information"))
	{
		book.getSheet("campaign").getRow(13).createCell(6).setCellValue("Campaigns info page is Displayed");
		book.getSheet("campaign").getRow(13).createCell(7).setCellValue("pass");
	}
	String expected=driver.findElement(By.id("dtlview_Campaign Name")).getText();
	expected=expected.trim();
	if(actual.equals(expected))
	{
		System.out.println("Test case is passed");
	}
	else
	{
		System.out.println(expected);
		System.out.println("Test case is Failed");
	}
	if(res1.contains("Campaign Information")&&(actual.equals(expected)))
	{
		book.getSheet("campaign").getRow(14).createCell(6).setCellValue("Campaigns validation is completed successfully");
		book.getSheet("campaign").getRow(14).createCell(7).setCellValue("pass");
	}
	
	driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();

driver.findElement(By.linkText("Sign Out")).click();
if(driver.getTitle().contains("vtiger"))
{
	book.getSheet("campaign").getRow(15).createCell(6).setCellValue("login page is Displayed");
	book.getSheet("campaign").getRow(15).createCell(7).setCellValue("pass");
}
FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
book.write(fos);
book.close();
	
	driver.quit();
}
}
