package com.vtiger.campaignTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.SearchProductPage;

public class CreateCampaignWithProductTest extends BaseClass{
	ProductPage productPage;
	CampaignPage campaignPage;
	CreateCampaignPage createCampaignPage;
	CreateProductPage createProductPage;
	ProductInformationPage productInformationPage;
	SearchProductPage searchProductPage;
	@Test(groups="regression")
	public void createCampaignWithProductTest()
	{
	String actual=XlsxUtility.getDataFromExcelSheet("campaign",5,1)+randomNum;
	String productname=XlsxUtility.getDataFromExcelSheet("campaign",5,2)+randomNum;
	
	productPage=new ProductPage(driver);
	campaignPage=new CampaignPage(driver);
	createCampaignPage=new CreateCampaignPage(driver);
	createProductPage=new CreateProductPage(driver);
	productInformationPage=new ProductInformationPage(driver);
	searchProductPage=new SearchProductPage(driver);
	homePage.clickProducts();
	productPage.createProductIcon();
	createProductPage.enterProductName(actual);
	createProductPage.saveButton();
	String expected=productInformationPage.checkproductNameInformation();
	System.out.println(expected);
	javaLangUtility.assetionThroughIfCondition(actual, expected, "Product");
	homePage.clickCampaign(driver, driverUtility);
	campaignPage.createCampaignIcon();
	createCampaignPage.enterCampaignName(productname);
	createCampaignPage.addProduct();
	searchProductPage.searchAndAddProduct(driver, actual);
	createProductPage.saveButton();
	String expected1=productInformationPage.checkCampaignNameinformation();
	String product=productInformationPage.checkproductInformation();
	javaLangUtility.assetionThroughIfCondition(actual, product,"");
	javaLangUtility.assetionThroughIfCondition(productname, expected1, "campaign");

}
}
