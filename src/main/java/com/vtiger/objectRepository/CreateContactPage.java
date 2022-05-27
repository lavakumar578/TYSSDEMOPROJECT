package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(name="lastname")
	private WebElement contactNameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td[@class='dvtCellInfo']/input[@name='account_name']/..//img[@title='Select']")
	private WebElement addOrganizationbtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterContactName(String name)
	{
		contactNameTxt.sendKeys(name);
	}
	
	public void saveButton()
	{
		saveBtn.click();
	}
	
	public void addOrganization() {
		addOrganizationbtn.click();
	}
}
