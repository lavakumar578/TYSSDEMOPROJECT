package com.tyss.demo.pages;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class TaskListPage{

	/*plusIcon*/
	@FindBy(xpath = "//div[@class='plusIcon']")
	private WebElement plusIcon;
	
	/*newCustomerLink*/
	@FindBy(xpath = "//div[@class='dropdownContainer addNewMenu']/div[text()='+ New Customer']")
	private WebElement newCustomerLink;
	
	/*enterCustomerName*/
	@FindBy(xpath = "//div[@class='customerNameDiv']/descendant::input[@type='text' and @placeholder='Enter Customer Name']")
	private WebElement enterCustomerName;
	
	/*enterCustomerDescription*/
	@FindBy(xpath = "//div[@class='inputContainer']/descendant::textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustomerDescription;
	
	/*dropDown*/
	@FindBy(xpath = "//div[@class='customerImportDiv']/descendant::div[@class='dropdownButton']")
	private WebElement dropDown;
	
	/*selectBigBangComapanyTxt*/
	@FindBy(xpath = "//div[@class='searchItemList']/descendant::div[text()='Big Bang Company']")
	private WebElement selectBigBangComapanyTxt;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath = "//div[@class='taskManagementHeaderPanel hasSelectedCustomer']/descendant::div[@class=\"title\"]")
	private WebElement titletxt;
	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * This method is used to addCustomer
	 * @author lavakumar
	 * @param name
	 * @param description
	 * @return
	 */
	public String addCustomer(String name,String description) {
		
		plusIcon.click();
		newCustomerLink.click();
		enterCustomerName.sendKeys(name);
		enterCustomerDescription.sendKeys(description);
		createCustomerBtn.click();
		String exp=titletxt.getText();
		String act=name;
		Assert.assertTrue(act.contains(exp), act +" is not validated");
		return act;
	}
	
	
	
}
