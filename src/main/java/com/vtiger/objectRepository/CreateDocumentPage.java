package com.vtiger.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentPage {

	@FindBy(name="notes_title")
	private WebElement enterDocumentName;
	
	@FindBy(className="cke_show_borders")
	private WebElement sendText;
	
	@FindBy(className="cke_button_bold")
	private WebElement clickBold;
	
	@FindBy(className="cke_button_italic")
	private WebElement clickItatlic;
	
	@FindBy(id="filename_I__")
	private WebElement sendPath;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterDocumentName(String name)
	{
		enterDocumentName.sendKeys(name);
	}
	public void clickOnboldIcon()
	{
		clickBold.click();
	}
	public void sendPath(String path)
	{
		sendPath.sendKeys(path);
	}
	public void clickOnItatlicIcon()
	{
		clickItatlic.click();
	}
	public void saveButton()
	{
		saveBtn.click();
	}
	public void sendText(String desc,String a)
	{
		sendText.sendKeys(desc,Keys.CONTROL+a);
	}
	
}
