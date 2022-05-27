package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfromationPage {
	
	@FindBy(className="dvHeaderText")
	private WebElement checkCampaignInformation;
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement checkCampaignNameinformation; 
	
	public CampaignInfromationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkCampaignInformationName()
	{
		return checkCampaignInformation.getText();
	}
	
	public String checkCampaignNameinformation()
	{
		return checkCampaignNameinformation.getText();
	}
}
