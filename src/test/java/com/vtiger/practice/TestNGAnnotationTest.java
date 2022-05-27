package com.vtiger.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestNGAnnotationTest {

	@BeforeMethod
	public void beforeMethodTest()
	{
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	public void afterMethodTest()
	{
		System.out.println("AfterMethod");
	}
	
	@BeforeSuite
	public void beforeSuiteTest()
	{
		System.out.println("BeforeSuite");
	}
	@AfterSuite
	public void afterSuiteTest()
	{
		System.out.println("After Suite");
	}
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest");
	}

	@BeforeClass
	public void beforeClassTest()
	{
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void afterClassTest()
	{
		System.out.println("AfterClass");
	}
	


}
