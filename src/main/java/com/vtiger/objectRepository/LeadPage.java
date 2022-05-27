package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class LeadPage{

	@FindBy(xpath="//a[text()='Go to Advanced Search']")
	private WebElement goToAdvancedSearchLink;
	

	@FindBy(xpath="//select[@class='detailedViewTextBox']")
	private WebElement firstDropDown;
	
	@FindBy(xpath="//select[@id='fop0']")
	private WebElement secondDropDown;
	
	@FindBy(xpath="//td[@align='center']/input[@class='crmbutton small create']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//table[@class='layerPopupTransport']/tbody/tr/td[contains(text(),'Showing Records')]")
	private WebElement getText;
	@FindBy(xpath="//input[@id='fval0']")
	private WebElement sendkeys;
	
	
	
	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public String getresult()
	{
		return getText.getText();
	}
	public void goToAdvancedSearchIcon()
	{
		goToAdvancedSearchLink.click();
	}
	public void addFirstAndSecondDropDown(String dropDownFirst,String dropDownSecond)
	{
		DriverUtility.selectByDropDown(firstDropDown, dropDownFirst);
		DriverUtility.selectByDropDown(secondDropDown, dropDownSecond);
	}
	public void sendkeys(String name)
	{
		sendkeys.sendKeys(name);
	}
	public void searchButton()
	{
		searchBtn.click();
	}
}
