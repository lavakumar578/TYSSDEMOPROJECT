package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest extends TestNGAnnotationTest{

	
			
			@Test
			public void demoTest()
			{
				
				System.out.println("hi");
				Reporter.log("demoTest is running",true);
			}
			
			@Test
			public void demoTest1()
			{
				System.out.println("bye");
				Reporter.log("demoTest1 is running",true);

			}
			
			

	}
	
	
		
		
		

