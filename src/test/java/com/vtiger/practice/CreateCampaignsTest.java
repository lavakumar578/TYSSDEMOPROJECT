package com.vtiger.practice;


import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CampaignInfromationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;

public class CreateCampaignsTest extends BaseClass {

	CampaignPage cp;
	CreateCampaignPage ccp;
	CampaignInfromationPage cip;
	String actual;
	@Test
	public void createCampaignsTest()
	{
	cp=new CampaignPage(driver);
	ccp=new CreateCampaignPage(driver);
	cip=new CampaignInfromationPage(driver);
	actual=XlsxUtility.getDataFromExcelSheet("campaign", 2, 1)+randomNum;
	homePage.clickCampaign(driver, driverUtility);
	cp.createCampaignIcon();
	ccp.enterCampaignName(actual);
	ccp.saveButton();
	String expected=cip.checkCampaignNameinformation();
	javaLangUtility.assetionThroughIfCondition(actual, expected, "campaign");
	}

}
