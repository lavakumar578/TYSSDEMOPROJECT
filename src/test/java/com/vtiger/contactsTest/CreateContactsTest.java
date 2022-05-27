package com.vtiger.contactsTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateContactsTest extends BaseClass{
	
	ContactPage contactPage;
	CreateContactPage createContactPage;
	ContactInformationPage contactInformationPage;
	@Test(groups="sanity")
	public void createContactTest()
	{
		
		String actual=XlsxUtility.getDataFromExcelSheet("contacts", 2, 1)+randomNum;
		contactPage=new ContactPage(driver);
		createContactPage=new CreateContactPage(driver);
		contactInformationPage=new ContactInformationPage(driver);
		homePage.clickContacts();
		contactPage.createContactsIcon();
		createContactPage.enterContactName(actual);
		createContactPage.saveButton();
		String expected=contactInformationPage.checkContactNameInformation();
		javaLangUtility.assetionThroughIfCondition(actual, expected, XlsxUtility.getDataFromExcelSheet("contacts", 4, 2));
		}
}
