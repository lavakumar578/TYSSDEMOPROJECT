package com.vtiger.practice;

import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sdet34l1.genericUtlity.DriverUtility;
import com.sdet34l1.genericUtlity.ILocation;
import com.sdet34l1.genericUtlity.JavaLangUtility;
import com.sdet34l1.genericUtlity.MySqlUtility;
import com.sdet34l1.genericUtlity.PropertiesUtility;
import com.sdet34l1.genericUtlity.XlsxUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectGuiWrtDataBaseTest {
	public static void main(String[] args) throws SQLException, Throwable, Throwable  {
		JavaLangUtility jlu=new JavaLangUtility();
		
		PropertiesUtility.openPropertyFile(ILocation.DATABASEPATH);
		XlsxUtility.openExcel(ILocation.EXCELPATHFORDATABASE);
		WebDriver driver=null;
		long timeOut=jlu.stringToLong(PropertiesUtility.getDataFromProperty("timeout"));
		String url=PropertiesUtility.getDataFromProperty("dbUrl");
	String projectname="TESTYANTRA132"+jlu.getRandomNumber(1000);
	String projectid="TY_PROJ_107"+jlu.getRandomNumber(1000);
	String input="insert into  project values('"+projectid+"','LAVA','27/04/2022','"+projectname+"','ON GOING','5')";
	
	MySqlUtility.openDataFromDatabaseConnection(ILocation.DATABASEURL+PropertiesUtility.getDataFromProperty("dbName"), PropertiesUtility.getDataFromProperty("dbUserName"), PropertiesUtility.getDataFromProperty("dbPassword"));
	MySqlUtility.setDataIntoDataBase(input);
	MySqlUtility.closeDataBase();
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	DriverUtility.navigateApp(url, driver);
	DriverUtility.browserSetting(driver, timeOut);
	driver.findElement(By.id("usernmae")).sendKeys(PropertiesUtility.getDataFromProperty("rmgUserName"));
	driver.findElement(By.id("inputPassword")).sendKeys(PropertiesUtility.getDataFromProperty("rmgPassword"));
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.linkText("Projects")).click();
	List<WebElement> contacts=driver.findElements(By.xpath("//tbody/tr/td"));
	for(WebElement project:contacts)
	{
		if(project.getText().equalsIgnoreCase(projectname))
		{
			jlu.printStatement("passed");
			jlu.printStatement("project name is visible in gui");
			break;
		}
		
	}
	DriverUtility.quitBrowser(driver);
	}
	}
