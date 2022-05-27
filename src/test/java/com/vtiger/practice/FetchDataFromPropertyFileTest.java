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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import com.sdet34l1.genericUtlity.ILocation;
import com.sdet34l1.genericUtlity.JavaLangUtility;
import com.sdet34l1.genericUtlity.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPropertyFileTest {
	public static void main(String[] args) throws IOException {
		JavaLangUtility jlu=new JavaLangUtility();
		PropertiesUtility.openPropertyFile(ILocation.PROPERTYPATH);
		String timeout=PropertiesUtility.getDataFromProperty("timeOut");
		long longTimeOut=jlu.stringToLong(timeout);
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("contacts");
		Row row = sh.getRow(2);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue();
		String actual=data;
	
		WebDriver driver1=null;
		switch(PropertiesUtility.getDataFromProperty("browser"))
		{
		case "chrome":
			{
			WebDriverManager.chromedriver().setup();
			driver1=new ChromeDriver();
			break;
			}
		case "Edge":
			{
			WebDriverManager.edgedriver().setup();
			driver1=new EdgeDriver();
			break;
			}
		}
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
		//testScript1 
		driver1.get(PropertiesUtility.getDataFromProperty("url"));
		driver1.findElement(By.name("user_name")).sendKeys(PropertiesUtility.getDataFromProperty("userName"));
		driver1.findElement(By.name("user_password")).sendKeys(PropertiesUtility.getDataFromProperty("password"));
		driver1.findElement(By.id("submitButton")).click();
		if(driver1.getTitle().contains("Home"))
		{
			book.getSheet("contacts").getRow(10).createCell(6).setCellValue("Home page is Displayed");
			book.getSheet("contacts").getRow(10).createCell(7).setCellValue("pass");
		}
			//testScript2 
			
		driver1.findElement(By.linkText("Contacts")).click();
		if(driver1.getTitle().contains("Contacts"))
		{
			book.getSheet("contacts").getRow(11).createCell(6).setCellValue("contact page is Displayed");
			book.getSheet("contacts").getRow(11).createCell(7).setCellValue("pass");
		}
		//testScript3
		driver1.findElement(By.cssSelector("[title='Create Contact...']")).click();
		String  res=driver1.findElement(By.className("dvtSelectedCell")).getText();
		if(res.contains("Contact Information"))
		{
			book.getSheet("contacts").getRow(12).createCell(6).setCellValue("create contact page is Displayed");
			book.getSheet("contacts").getRow(12).createCell(7).setCellValue("pass");
		}
		//testScript4
		driver1.findElement(By.name("lastname")).sendKeys(actual);
		driver1.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		String  res1=driver1.findElement(By.className("dvHeaderText")).getText();
		if(res1.contains("Contact Information"))
		{
			book.getSheet("contacts").getRow(13).createCell(6).setCellValue("contact info page is Displayed");
			book.getSheet("contacts").getRow(13).createCell(7).setCellValue("pass");
		}
		//testScript5
		String expected=driver1.findElement(By.id("dtlview_Last Name")).getText();
		if(actual.equals(expected))
		{
			System.out.println("Test case is passed");
		}
		else {
			System.out.println("Test case is failed");
		
		}
		if(res1.contains("Contact Information")&& (actual.equals(expected)) )
		{
			book.getSheet("contacts").getRow(14).createCell(6).setCellValue("validation is Done successfully");
			book.getSheet("contacts").getRow(14).createCell(7).setCellValue("pass");
		}
		Actions act =new Actions(driver1);
		WebElement s=driver1.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		act.moveToElement(s).perform();
		//testScript6 
		driver1.findElement(By.linkText("Sign Out")).click();
		if(driver1.getTitle().contains("vtiger"))
		{
			book.getSheet("contacts").getRow(15).createCell(6).setCellValue("Login page is Displayed");
			book.getSheet("contacts").getRow(15).createCell(7).setCellValue("pass");
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		book.write(fos);
		book.close();
		driver1.quit();
	}
}
