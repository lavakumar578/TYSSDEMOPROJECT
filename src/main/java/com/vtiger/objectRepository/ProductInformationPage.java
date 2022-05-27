package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	@FindBy(id="dtlview_Product Name")
	private WebElement checkProductNameInformation;
	
	@FindBy(id="dtlview_Product")
	private WebElement checkProductInformation;
	@FindBy(id="dtlview_Campaign Name")
	private WebElement checkCampaignNameinformation; 
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkproductNameInformation()
	{
		return checkProductNameInformation.getText().trim();
	}
	
	public String checkCampaignNameinformation()
	{
		return checkCampaignNameinformation.getText().trim();
		
	}
	
	public String checkproductInformation()
	{
		return checkProductInformation.getText().trim();
	}
}
