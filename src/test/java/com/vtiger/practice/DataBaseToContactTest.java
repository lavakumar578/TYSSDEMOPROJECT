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

import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseToContactTest {
	public static void main(String[] args) throws SQLException, InterruptedException  {
		String url=null,username=null,password=null,lastname=null;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select * from vcontact");
		while(result.next())
		{
		 url=result.getString("url");
		 username=result.getString("username");
		password=result.getString("password");
		lastname=result.getString("conatactname");
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
		driver1.findElement(By.linkText("Contacts")).click();
		driver1.findElement(By.cssSelector("[title='Create Contact...']")).click();
		driver1.findElement(By.name("lastname")).sendKeys(lastname);
		driver1.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		String expected=driver1.findElement(By.id("dtlview_Last Name")).getText();
		if(lastname.equals(expected))
		{
			System.out.println("Test case is passed");
		}
		else {
			System.out.println("Test case is failed");
		
		}
		Actions act =new Actions(driver1);
		WebElement s=driver1.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		act.moveToElement(s).perform();
		driver1.findElement(By.linkText("Sign Out")).click();
		driver1.quit();
}
}