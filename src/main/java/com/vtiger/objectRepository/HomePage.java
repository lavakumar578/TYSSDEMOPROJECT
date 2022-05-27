package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class HomePage {
	
	@FindBy(linkText="More")
	private WebElement moreDropDown;
	
	@FindBy(name="Campaigns")
	private WebElement campaignsTab;
	
	@FindBy(linkText="Products")
	private WebElement productsTab;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsTab;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsTab;
	
	@FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
	private WebElement administrorIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutIcon;
	
	@FindBy(linkText="Documents")
	private WebElement documentsTab;
	
	@FindBy(linkText="Leads")
	private WebElement leadsTab;
	
	public void clickLeads()
	{
		leadsTab.click();
	}
	public void clickDocuments()
	{
		documentsTab.click();
	}
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void campaignTab()
	{
		campaignsTab.click();
	}
	public void signout(WebDriver driver, DriverUtility driverUtility)
	{
		driverUtility.mouseHoverOnTheElement(administrorIcon);
		signOutIcon.click();
	}
	public void clickCampaign(WebDriver driver, DriverUtility driverUtility)
	{
		driverUtility.mouseHoverOnTheElement(moreDropDown);
		campaignsTab.click();
	}
	public void clickProducts()
	{
		productsTab.click();
	}
	public void clickContacts()
	{
		contactsTab.click();
	}
	public void clickOrganizations()
	{
		organizationsTab.click();
	}
}
