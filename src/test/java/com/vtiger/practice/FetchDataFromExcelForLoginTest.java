package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
import com.sdet34l1.genericUtlity.XlsxUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromExcelForLoginTest {
	
public static void main(String[] args) throws IOException {

	JavaLangUtility jlu=new JavaLangUtility();
	PropertiesUtility.openPropertyFile(ILocation.PROPERTYPATH);
	XlsxUtility.openExcel(ILocation.EXCELPATH);
	String timeout=PropertiesUtility.getDataFromProperty("timeOut");
	long longTimeOut=jlu.stringToLong(timeout);
	FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook book = WorkbookFactory.create(fis1);
	Sheet sh = book.getSheet("logincredentials");
	String[][] arr=new String[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=1;i<sh.getLastRowNum();i++)
	
	{
		for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
		{
			arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
		String username=arr[i][0];
		String password=arr[i][1];
			
	
	
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
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	if(driver.getTitle().contains("Home"))
	{
		WebElement a=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(a).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		book.close();
		driver.quit();
		System.out.println(username);
		System.out.println(password);
		System.out.println("logined succesfully");
		break;
	}	
	System.out.println(username);
	System.out.println(password);
	System.out.println("login failed");
	driver.quit();
	}
	
}

}
