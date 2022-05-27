package com.vtiger.contactsTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.SearchOrganizationPage;

public class CreateContantWithOrganizationTest extends BaseClass{

	ContactPage contactPage;
	CreateContactPage createContactPage;
	ContactInformationPage contactInformationPage;
	OrganizationPage organizationPage;
	CreateOrganizationPage createOrganizationPage;
	OrganizationInformationPage organizationInformationPage;
	SearchOrganizationPage searchOrganizationPage;
	@Test(groups="regression")
	public void createContantWithOrganizationTest()
	{
	String actual=XlsxUtility.getDataFromExcelSheet("contacts", 5, 1)+randomNum;
	String actual1=XlsxUtility.getDataFromExcelSheet("contacts", 5, 2)+randomNum;
	contactPage=new ContactPage(driver);
	createContactPage=new CreateContactPage(driver);
	contactInformationPage=new ContactInformationPage(driver);
	organizationPage=new OrganizationPage(driver);
	createOrganizationPage=new CreateOrganizationPage(driver);
	organizationInformationPage=new OrganizationInformationPage(driver);
	searchOrganizationPage=new SearchOrganizationPage(driver);
	homePage.clickOrganizations();
	organizationPage.createOrganizationIcon();
	createOrganizationPage.enterOrganizationName(actual);
	createOrganizationPage.saveButton();
	String expected=organizationInformationPage.checkOrganizationName();
	javaLangUtility.assetionThroughIfCondition(actual, expected, XlsxUtility.getDataFromExcelSheet("contacts", 4, 1));
	homePage.clickContacts();
	contactPage.createContactsIcon();
	createContactPage.enterContactName(actual1);
	createContactPage.addOrganization();
	searchOrganizationPage.searchOrganizationAndAdd(driver, actual);
	createContactPage.saveButton();
	String expected1=contactInformationPage.checkContactNameInformation();
	String organizationExpected=contactInformationPage.checkOrganizationName();
	javaLangUtility.assetionThroughIfCondition(actual, organizationExpected, "");
	javaLangUtility.assetionThroughIfCondition(actual1, expected1, XlsxUtility.getDataFromExcelSheet("contacts", 4, 2));
}
}
