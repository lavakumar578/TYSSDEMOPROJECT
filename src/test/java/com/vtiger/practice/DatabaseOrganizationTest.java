package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericUtlity.JavaLangUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseOrganizationTest {
	public static void main(String[] args) throws SQLException, InterruptedException  {
		JavaLangUtility jul=new JavaLangUtility();
		int randomNum=jul.getRandomNumber(1000);
		String url=null,username=null,password=null,organizationname=null;
		
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select * from vorganization");
		while(result.next())
		{
		 url=result.getString("url");
		 username=result.getString("username");
		password=result.getString("password");
		organizationname=result.getString("organization")+randomNum;
		}
		connection.close();
		WebDriverManager.chromedriver().setup();
		WebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver1.get(url);
		driver1.findElement(By.name("user_name")).sendKeys(username);
		driver1.findElement(By.name("user_password")).sendKeys(password);
		driver1.findElement(By.id("submitButton")).click();
		driver1.findElement(By.linkText("Organizations")).click();
		driver1.findElement(By.cssSelector("[title='Create Organization...']")).click();
		driver1.findElement(By.name("accountname")).sendKeys(organizationname);
		driver1.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		
		String expected=driver1.findElement(By.id("dtlview_Organization Name")).getText();
		if(organizationname.equals(expected))
		{
			System.out.println("Test case is passed");
		}
		else {
			System.out.println("Test case is failed");
		
		}
		Actions act =new Actions(driver1);
		WebElement s=driver1.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		WebDriverWait wait=new WebDriverWait(driver1,10);
		Thread.sleep(2000);
		act.moveToElement(s).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign Out")));
		driver1.findElement(By.linkText("Sign Out")).click();
		driver1.quit();
	
	}
}


