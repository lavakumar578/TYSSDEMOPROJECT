package com.LeadModule.TC_51_to_TC_55;

import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.LeadPage;

public class TC_51_SearchLeadByClickingOnAnnualRevenueTest extends BaseClass 
	{
	LeadPage leadPage;
	@Test(groups= {"sanity","regression"})
	public void tC_51_SearchLeadByClickingOnAnnualRevenueTest() throws InterruptedException {
	leadPage=new LeadPage(driver);
	homePage.clickLeads();
	leadPage.goToAdvancedSearchIcon();
	leadPage.addFirstAndSecondDropDown(XlsxUtility.getDataFromExcelSheet("annualrevenue",1 , 2), XlsxUtility.getDataFromExcelSheet("annualrevenue",1 , 3));
	leadPage.searchButton();
	String result=leadPage.getresult();
	javaLangUtility.printStatement(result);	
	}
	
}
