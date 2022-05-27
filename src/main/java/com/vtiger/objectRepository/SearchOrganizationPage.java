package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class SearchOrganizationPage {

	@FindBy(id="search_txt")
	private WebElement enterOrganization;
	
	@FindBy(name="search")
	private WebElement searchOrganization;
	
	@FindBy()
	private WebElement selectOrganization;
	
	public SearchOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchOrganizationAndAdd(WebDriver driver,String actual)
	{
		DriverUtility.switchToWindowBasedOnTitle(driver, "Accounts");
		enterOrganization.sendKeys(actual);
		searchOrganization.click();
		driver.findElement(By.xpath("//td/a[text()='"+actual+"']")).click();
		DriverUtility.switchToWindowBasedOnTitle(driver, "Contacts");
	}
	
}
