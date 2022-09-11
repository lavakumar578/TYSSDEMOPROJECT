package com.tyss.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.demo.util.DriverUtility;



public class HomePage{

	public DriverUtility driverUtility;
	@FindBy(xpath = "//a[text()='Enter Time-Track']")
	private WebElement timeTrackTxt;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutTxt;
	
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement tasksTxt;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement validatePage() {
		return timeTrackTxt;
	}
	
	public void logout() {
		driverUtility.mouseHoverOnTheElement(logoutTxt);
	}
	
	public String tasks() {
		String act=tasksTxt.getText();
		tasksTxt.click();
		return act;
	}
	
	
}
