package com.LeadModule.TC_51_to_TC_55;


import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.LeadPage;

public class TC_54_SearchLeadByClickingOnLeadNoTest extends BaseClass {
	LeadPage leadPage;
	@Test(groups= {"sanity","regression"})
	public  void tC_54_SearchLeadByClickingOnLeadNoTest()
	{
		String value=XlsxUtility.getDataFromExcelSheet("leadno",1 , 1);
		String value1=XlsxUtility.getDataFromExcelSheet("leadno",1 , 2);
		leadPage=new LeadPage(driver);
		homePage.clickLeads();
		leadPage.goToAdvancedSearchIcon();
		leadPage.addFirstAndSecondDropDown(value, value1);	
		leadPage.sendkeys(XlsxUtility.getDataFromExcelSheet("leadno",1 , 3));
		leadPage.searchButton();
		String result=leadPage.getresult();
		javaLangUtility.printStatement(result);		
	}
}
