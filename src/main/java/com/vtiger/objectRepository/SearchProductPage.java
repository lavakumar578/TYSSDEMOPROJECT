package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class SearchProductPage {

	@FindBy(id="search_txt")
	private WebElement searchProductTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[contains(@onclick,'set_return_specific')]")
	private WebElement selectProduct;
	
	public SearchProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchAndAddProduct(WebDriver driver,String productName)
	{
		DriverUtility.switchToWindowBasedOnTitle(driver, "Products");
		searchProductTxt.sendKeys(productName);
		searchBtn.click();
		driver.findElement(By.xpath("//td/a[text()='"+productName+"']")).click();
		DriverUtility.switchToWindowBasedOnTitle(driver, "Campaign");
	}
	
	
}
