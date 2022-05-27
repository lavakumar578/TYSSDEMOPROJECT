package com.vtiger.practice;


import java.io.IOException;
import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CampaignInfromationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;

public class CreateCampaignTest extends BaseClass {
	CampaignPage campaignPage;
	CreateCampaignPage createCampaignPage;
	CampaignInfromationPage campaignInfromationPage;
	@Test
	public void createCampaignTest() throws IOException
	{
	String actual=XlsxUtility.getDataFromExcelSheet("campaign", 2, 1)+randomNum;
	campaignPage=new CampaignPage(driver);
	createCampaignPage=new CreateCampaignPage(driver);
	campaignInfromationPage=new CampaignInfromationPage(driver);
		if(driver.getTitle().contains("Home"))
	{
		XlsxUtility.setDataFromExcelSheet("campaign", 10, 6, "Home page is Displayed");
		XlsxUtility.setDataFromExcelSheet("campaign", 10, 7, "Pass");
	}
	homePage.clickCampaign(driver, driverUtility);
	if(driver.getTitle().contains("Campaigns"))
	{
		XlsxUtility.setDataFromExcelSheet("campaign", 11, 6, "Campaign page is Displayed");
		XlsxUtility.setDataFromExcelSheet("campaign", 11, 7, "Pass");
	}
	campaignPage.createCampaignIcon();
	String res=createCampaignPage.checkCreateNewCompaign();
	if(res.contains("Creating New Campaign"))
	{
	XlsxUtility.setDataFromExcelSheet("campaign", 12, 6, "create Campaigns page is Displayed");
	XlsxUtility.setDataFromExcelSheet("campaign", 12, 7, "pass");
	}
	createCampaignPage.enterCampaignName(actual);
	createCampaignPage.saveButton();
	String res1=campaignInfromationPage.checkCampaignInformationName();
	if(res1.contains("Campaign Information"))
	{
		XlsxUtility.setDataFromExcelSheet("campaign", 13, 6, "Campaigns Info page is Displayed");
		XlsxUtility.setDataFromExcelSheet("campaign", 13, 7, "pass");
	}
	String expected=campaignInfromationPage.checkCampaignNameinformation();
	System.out.println(expected);
	javaLangUtility.assetionThroughIfCondition(actual, expected, "campaign");
	if(res1.contains("Campaign Information")&&(actual.equals(expected)))
	{
		XlsxUtility.setDataFromExcelSheet("campaign", 14, 6, "Campaigns validation done successfully");
		XlsxUtility.setDataFromExcelSheet("campaign", 14, 7, "pass");
	}
	if(driver.getTitle().contains("vtiger"))
	{
		XlsxUtility.setDataFromExcelSheet("campaign", 15, 6, "Login page Displayed");
		XlsxUtility.setDataFromExcelSheet("campaign", 15, 7, "pass");
	}
}
}
