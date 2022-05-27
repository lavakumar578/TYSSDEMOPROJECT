package com.vtiger.documentTest;


import org.testng.annotations.Test;

import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.DriverUtility;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.vtiger.objectRepository.CreateDocumentPage;
import com.vtiger.objectRepository.DocumentInformationPage;
import com.vtiger.objectRepository.DocumentPage;

public class CreateDocumentTest extends BaseClass {

	DocumentPage documentPage;
	CreateDocumentPage createDocumentPage;
	DocumentInformationPage documentInformationPage;
	@Test(groups="sanity")
	public void createDocumentTest() throws InterruptedException
	{
	String actual=XlsxUtility.getDataFromExcelSheet("documents",2,1)+randomNum;
	String desc=XlsxUtility.getDataFromExcelSheet("documents",2,2);
	String path=XlsxUtility.getDataFromExcelSheet("documents",2,3);
	String a=XlsxUtility.getDataFromExcelSheet("documents",2,4);
	documentPage=new DocumentPage(driver);
	createDocumentPage=new CreateDocumentPage(driver);
	documentInformationPage=new DocumentInformationPage(driver);
	homePage.clickDocuments();
	documentPage.clickOnDocumentIcon();
	createDocumentPage.enterDocumentName(actual);
	DriverUtility.switchToFrame(driver,0);
	createDocumentPage.sendText(desc, a);
	DriverUtility.switchBackToHomePage(driver);
	createDocumentPage.clickOnboldIcon();
	createDocumentPage.clickOnItatlicIcon();
	createDocumentPage.sendPath(path);
	DriverUtility.intializeJavaScriptExecutor(driver);
	createDocumentPage.saveButton();	
	String expected=documentInformationPage.getDocumentName();
	javaLangUtility.assetionThroughIfCondition(actual, expected, XlsxUtility.getDataFromExcelSheet("documents",1,4));
}
}
