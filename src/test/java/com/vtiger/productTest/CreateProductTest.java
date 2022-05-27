package com.vtiger.productTest;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;

public class CreateProductTest extends BaseClass{
	
	ProductPage productPage;
	CreateProductPage createProductpage;
	ProductInformationPage productInformationPage;
	@Test(groups="sanity")
public void createProductTest() {
	String actual =XlsxUtility.getDataFromExcelSheet("products", 2,1)+randomNum;
	productPage=new ProductPage(driver);
	createProductpage=new CreateProductPage(driver);
	productInformationPage=new ProductInformationPage(driver);
	homePage.clickProducts();
	productPage.createProductIcon();
	createProductpage.enterProductName(actual);
	createProductpage.saveButton();
	String expected=productInformationPage.checkproductNameInformation();
	javaLangUtility.assetionThroughIfCondition(actual, expected, XlsxUtility.getDataFromExcelSheet("products", 1,1));
	
}
}
