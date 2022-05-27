package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CampaignPage {

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignPageLink;
	
	
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	public void createCampaignIcon()
	{
		campaignPageLink.click();
		
	}
}
