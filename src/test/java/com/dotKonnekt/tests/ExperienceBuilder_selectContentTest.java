package com.dotKonnekt.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.EB_selectContentPage;
import com.dotKonnekt.utility.Log;

public class ExperienceBuilder_selectContentTest extends BaseClass {
	EB_selectContentPage ebPage;
	
	@Test(dataProvider = "ExperienceBuilder", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void universalSearchBarFunctionality(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------universalSearchBarFunctionality    Starts---------");
		ebPage = new EB_selectContentPage();
		launchApp_EB(browser, url);
		ebPage.EB_login();
		ebPage.EB_UniversalSearch("blavk","mouse");
		Log.endTestCase("-----------universalSearchBarFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "ExperienceBuilder", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void noResultFoundTest(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------noResultFoundTest    Starts---------");
		ebPage = new EB_selectContentPage();
		launchApp_EB(browser, url);
		ebPage.EB_login();
		ebPage.EB_UniversalSearch("blavk","mouse");
		ebPage.NoResultFound();
		Log.endTestCase("-----------noResultFoundTest    Ends---------");
	}
	
	
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void teardown() {
		getDriver().close();
	}
	
}
