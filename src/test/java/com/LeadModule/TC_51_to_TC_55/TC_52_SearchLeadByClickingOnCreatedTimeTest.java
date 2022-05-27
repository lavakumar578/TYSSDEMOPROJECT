package com.LeadModule.TC_51_to_TC_55;

import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.LeadPage;

public class TC_52_SearchLeadByClickingOnCreatedTimeTest extends BaseClass 
{	
	LeadPage leadPage;
	@Test(groups= {"sanity","regression"})
	public  void tC_52_SearchLeadByClickingOnCreatedTimeTest() 
	{	
		leadPage=new LeadPage(driver);
	homePage.clickLeads();
	leadPage.goToAdvancedSearchIcon();
	leadPage.addFirstAndSecondDropDown(XlsxUtility.getDataFromExcelSheet("createdtime",1 , 1), XlsxUtility.getDataFromExcelSheet("createdtime",1 , 2));	
	leadPage.sendkeys(javaLangUtility.dateTimeInFormatForVtiger());
	leadPage.searchButton();
	String result=leadPage.getresult();
	javaLangUtility.printStatement(result);	
	}
}
