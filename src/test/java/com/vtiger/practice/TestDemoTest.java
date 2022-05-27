package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemoTest extends TestNGAnnotationTest {

	@Test()
	public void Test()
	{
		
		System.out.println("hi");
		Reporter.log("Test is running",true);
	}
	
	@Test
	public void Test1()
	{
		System.out.println("jack");
		Reporter.log("Test1 is running",true);

	}
	
}
