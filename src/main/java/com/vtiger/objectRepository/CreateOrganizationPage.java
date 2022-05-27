package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class CreateOrganizationPage {

	@FindBy(name="accountname")
	private WebElement enterOrganizationNameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement addIndustry;
	
	@FindBy(name="accounttype")
	private WebElement addType;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addProductbtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterOrganizationName(String name) 
	{
		enterOrganizationNameTxt.sendKeys(name);
	}
	public void saveButton()
	{
		saveBtn.click();
	}
	public void addIndustryAndType(String industry,String type)
	{
		DriverUtility.selectDropDown(addIndustry, industry);
		DriverUtility.selectDropDown(addType, type);
	}
	
}