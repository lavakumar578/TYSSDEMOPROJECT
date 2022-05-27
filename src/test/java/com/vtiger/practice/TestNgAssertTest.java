package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sdet34l1.genericUtlity.BaseClass;
@Listeners(com.sdet34l1.genericUtlity.ListenerImplementation.class)
public class TestNgAssertTest{

	
	@Test
	public void practice1Test()
	{
		Reporter.log("a-practice1",true);
		Reporter.log("b-practice1",true);
		Reporter.log("c-practice1",true);
		Reporter.log("d-practice1",true);
		Reporter.log("e-practice1",true);
		Reporter.log("f-practice1",true);
	
	}
	
	@Test
	public void practice2Test()
	{
		Reporter.log("f-practice2",true);
		Reporter.log("e-practice2",true);
		Reporter.log("d-practice2",true);
		Reporter.log("c-practice2",true);
		Reporter.log("b-practice2",true);
		Reporter.log("a-practice2",true);
	
	}
	
	@Test(dependsOnMethods = "practice2Test")
	public void practice3Test()
	{
		Reporter.log("f-practice3",true);
		Reporter.log("e-practice3",true);
		Reporter.log("d-practice3",true);
		Reporter.log("c-practice3",true);
		Reporter.log("b-practice3",true);
		Reporter.log("a-practice3",true);
		
	}
	
	@Test
	public void practice4Test()
	{
		Reporter.log("f-practice4",true);
		Reporter.log("e-practice4",true);
		Reporter.log("d-practice4",true);
		Reporter.log("c-practice4",true);
		Reporter.log("b-practice4",true);
		Reporter.log("a-practice4",true);
		
	}
	
}
