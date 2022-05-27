package com.vtiger.campaignTest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CampaignInfromationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class CreateCampaignTest extends BaseClass {
	
	
	CampaignPage campaignPage;
	CreateCampaignPage createCampaignPage;
	CampaignInfromationPage campaignInfromationPage;
	@Test(groups="sanity")
	@Description("Description:- CreateCampaignTest")
	@Epic("Epic:- CreateCampaignTest")
	@Story("Story:- CreateCampaignTest")
	@Severity(SeverityLevel.BLOCKER)
	public void createCampaignTest() throws IOException
	{
	String actual=XlsxUtility.getDataFromExcelSheet("campaign", 2, 1)+randomNum;
	campaignPage=new CampaignPage(driver);
	createCampaignPage=new CreateCampaignPage(driver);
	campaignInfromationPage=new CampaignInfromationPage(driver);
	
	homePage.clickCampaign(driver, driverUtility);
	campaignPage.createCampaignIcon();
	createCampaignPage.enterCampaignName(actual);
	
	createCampaignPage.saveButton();
	String expected=campaignInfromationPage.checkCampaignNameinformation();
	System.out.println(expected);
	javaLangUtility.assetionThroughIfCondition(actual, expected, "campaign");

}
}
