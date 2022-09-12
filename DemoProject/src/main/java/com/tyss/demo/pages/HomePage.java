package com.tyss.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.demo.util.DriverUtility;



public class HomePage{
	
	public DriverUtility driverUtility;
	/*timeTrackTxt*/
	@FindBy(xpath = "//a[text()='Enter Time-Track']")
	private WebElement timeTrackTxt;
	
	/*logoutTxt*/
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutTxt;
	
	/*tasksTxt*/
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement tasksTxt;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to validatePage
	 * @author lavakumar
	 * @return
	 */
	public WebElement validatePage() {
		return timeTrackTxt;
	}
	/**
	 * This method is used to logout
	 * @author lavakumar
	 * 
	 */
	public void logout() {
		driverUtility.mouseHoverOnTheElement(logoutTxt);
	}
	/**
	 * This method is used to tasks
	 * @author lavakumar
	 * @return
	 */
	public String tasks() {
		String act=tasksTxt.getText();
		tasksTxt.click();
		return act;
	}
	
	
}
