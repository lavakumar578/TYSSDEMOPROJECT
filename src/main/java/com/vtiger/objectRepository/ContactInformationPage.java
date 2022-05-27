package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	@FindBy(id="dtlview_Last Name")
	private WebElement checkContactNameInformation;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
	private WebElement checkOrganizationName;
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkOrganizationName()
	{
		return checkOrganizationName.getText();
	}
	
	public String checkContactNameInformation() 
	{
		return checkContactNameInformation.getText();
	}
}
