package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	@FindBy(name="campaignname")
	private WebElement compaignNameTxt;
	
	@FindBy(className="lvtHeaderText")
	private WebElement  createNewCompaign;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addProductbtn;
	
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	public void addProduct()
	{
		addProductbtn.click();
	}
	
	public void enterCampaignName(String name)
	{
		compaignNameTxt.sendKeys(name);
	}
	public String checkCreateNewCompaign()
	{
		return createNewCompaign.getText();
	}
	
	public void saveButton()
	{
		saveBtn.click();
	}
}
