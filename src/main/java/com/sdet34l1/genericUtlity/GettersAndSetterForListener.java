package com.sdet34l1.genericUtlity;

import org.openqa.selenium.WebDriver;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class GettersAndSetterForListener {
	
	private static GettersAndSetterForListener instance;
	
	public LoginPage loginPage;
	public HomePage homePage;
	public WebDriver driver;
	public JavaLangUtility javaLangUtility;
	public long longTimeOut;
	public int randomNum;
	public String username;
	public String password;
	public String browser;
	public String url;
	public DriverUtility driverUtility;
	public XlsxUtility xlsxUtility;
	public PropertiesUtility propertiesUtility;
	
	
	public String getBrowser() {
		return browser;
	}

	public XlsxUtility getXlsxUtility() {
		return xlsxUtility;
	}

	public PropertiesUtility getPropertiesUtility() {
		return propertiesUtility;
	}

	

	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setJavaLangUtility(JavaLangUtility javaLangUtility) {
		this.javaLangUtility = javaLangUtility;
	}

	public void setLongTimeOut(long longTimeOut) {
		this.longTimeOut = longTimeOut;
	}

	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriverUtility(DriverUtility driverUtility) {
		this.driverUtility = driverUtility;
	}

	public void setXlsxUtility(XlsxUtility xlsxUtility) {
		this.xlsxUtility = xlsxUtility;
	}

	public void setPropertiesUtility(PropertiesUtility propertiesUtility) {
		this.propertiesUtility = propertiesUtility;
	}

	private GettersAndSetterForListener() {}
	
	public static GettersAndSetterForListener getInstance() {
		if(instance==null) {
			instance=new GettersAndSetterForListener();
		}
		return instance;
	}
	public static void setInstance(GettersAndSetterForListener instance) {
		GettersAndSetterForListener.instance = instance;
	}
	public LoginPage getLoginPage() {
		return loginPage;
	}
	public HomePage getHomePage() {
		return homePage;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public JavaLangUtility getJavaLangUtility() {
		return javaLangUtility;
	}
	public long getLongTimeOut() {
		return longTimeOut;
	}
	public int getRandomNum() {
		return randomNum;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	public DriverUtility getDriverUtility() {
		return driverUtility;
	} 

}
