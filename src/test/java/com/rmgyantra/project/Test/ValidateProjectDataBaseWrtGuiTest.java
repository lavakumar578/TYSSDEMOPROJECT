package com.rmgyantra.project.Test;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.sdet34l1.genericUtlity.DriverUtility;
import com.sdet34l1.genericUtlity.ILocation;
import com.sdet34l1.genericUtlity.JavaLangUtility;
import com.sdet34l1.genericUtlity.MySqlUtility;
import com.sdet34l1.genericUtlity.PropertiesUtility;
import com.sdet34l1.genericUtlity.XlsxUtility;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ValidateProjectDataBaseWrtGuiTest {

	public static void main(String[] args) throws IOException, SQLException {
		JavaLangUtility jlu=new JavaLangUtility();
	PropertiesUtility.openPropertyFile(ILocation.DATABASEPATH);
	XlsxUtility.openExcel(ILocation.EXCELPATHFORDATABASE);
	WebDriver driver=null;
	long timeOut=jlu.stringToLong(PropertiesUtility.getDataFromProperty("timeout"));
	String url=PropertiesUtility.getDataFromProperty("dbUrl");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	DriverUtility.navigateApp(url, driver);
	DriverUtility.browserSetting(driver, timeOut);

		String actual=XlsxUtility.getDataFromExcelSheet("database", 1, 1)+jlu.getRandomNumber(1000);
		String projectName=PropertiesUtility.getDataFromProperty("dbName")+jlu.getRandomNumber(1000);
		driver.findElement(By.id("usernmae")).sendKeys(PropertiesUtility.getDataFromProperty("rmgUserName"));
		driver.findElement(By.id("inputPassword")).sendKeys(PropertiesUtility.getDataFromProperty("rmgPassword"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.className("btn-success")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys(actual);
		WebElement dropdown=driver.findElement(By.xpath("(//div[@class='form-group']/select[@class='form-control'])[2]"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("On Goging");
		driver.findElement(By.cssSelector("[value='Add Project']")).click();
		
		MySqlUtility.openDataFromDatabaseConnection(ILocation.DATABASEURL+PropertiesUtility.getDataFromProperty("dbName"), PropertiesUtility.getDataFromProperty("dbUserName"), PropertiesUtility.getDataFromProperty("dbPassword"));
		MySqlUtility.validateDataInDatabase("Select * from project;", "project_name", "projects");
		MySqlUtility.closeDataBase();
		DriverUtility.quitBrowser(driver);
		
	}
		}
