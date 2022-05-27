package com.vtiger.organizationTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class OrganizationWithIndustryAndPressTest extends BaseClass{
	OrganizationPage organizationPage;
	CreateOrganizationPage createOrganizationPage;
	OrganizationInformationPage organizationInformationPage;
	@Test(groups="regression")
	public void organizationWithIndustryAndPressTest()
	{
	String actual=XlsxUtility.getDataFromExcelSheet("organization", 2, 1)+randomNum;
	organizationPage=new OrganizationPage(driver);
	createOrganizationPage=new CreateOrganizationPage(driver);
	organizationInformationPage=new OrganizationInformationPage(driver);
	homePage.clickOrganizations();
	organizationPage.createOrganizationIcon();
	createOrganizationPage.enterOrganizationName(actual);
	createOrganizationPage.addIndustryAndType(XlsxUtility.getDataFromExcelSheet("organization", 3, 1), XlsxUtility.getDataFromExcelSheet("organization", 4, 1));
	createOrganizationPage.saveButton();
	String expected=organizationInformationPage.checkOrganizationName();		
	javaLangUtility.assetionThroughIfCondition(actual, expected, XlsxUtility.getDataFromExcelSheet("organization",1,1));	
}
}



