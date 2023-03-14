package com.dotKonnekt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CommonPagedetails;
import com.dotKonnekt.pages.MyAccountPage;
import com.dotKonnekt.pages.RecipePageFinal;
import com.dotKonnekt.utility.Log;

public class MyAccountPageTest extends BaseClass{
	CommonPagedetails commonPagedetails;
	MyAccountPage myAccountPage;
	RecipePageFinal recipePage;
	
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn") 
	public void profileIcon_NotLoggedIn(String page, String title, String browser, String url) {
		Log.startTestCase("-----------profileIcon_NotLoggedIn    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.UserButtonFunctionality(title);
		Log.endTestCase("-----------profileIcon_NotLoggedIn    Ends---------");
	}
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void profileIcon_LoggedIn(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------profileIcon_LoggedIn    Starts---------");
		myAccountPage = new MyAccountPage();
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		myAccountPage.profileIcon_LoggedIcon(title);
		recipePage.CategoryListVerification();
		Thread.sleep(5000);
		commonPagedetails.logoFunctionality("My Account");
		commonPagedetails.validateSeachFunctionality("Black", "Keyboard", "My Account");
		Log.endTestCase("-----------profileIcon_LoggedIn    Ends---------");
	}
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void MyAccountPage_ElementsVerification(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------MyAccountPage_ElementsVerification    Starts---------");
		myAccountPage = new MyAccountPage();
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		myAccountPage.profileIcon_LoggedIcon(title);
		myAccountPage.AccountPageElements();
		Log.endTestCase("-----------MyAccountPage_ElementsVerification    Ends---------");
	}
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void MyAccount_SignOutVerification(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------MyAccount_SignOutVerification    Starts---------");
		myAccountPage = new MyAccountPage();
		launchApp_V1(browser, url);
		myAccountPage.profileIcon_LoggedIcon(title);
		myAccountPage.SignoutFunctionality();
		Log.endTestCase("-----------MyAccount_SignOutVerification    Ends---------");
	}
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void MyAccount_BookMarkFunctionality(String page, String title, String browser, String url) throws InterruptedException  {
		Log.startTestCase("-----------MyAccount_BookMarkFunctionality    Starts---------");
		myAccountPage = new MyAccountPage();
		launchApp_V1(browser, url);
		myAccountPage.profileIcon_LoggedIcon(title);
		myAccountPage.BookmarkFunctionality();
		Log.endTestCase("-----------MyAccount_BookMarkFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void MyAccount_WishlistFunctionality(String page, String title, String browser, String url) throws InterruptedException  {
		Log.startTestCase("-----------MyAccount_WishlistFunctionality    Starts---------");
		myAccountPage = new MyAccountPage();
		launchApp_V1(browser, url);
		myAccountPage.profileIcon_LoggedIcon(title);
		myAccountPage.WishlistFunctionality();
		Log.endTestCase("-----------MyAccount_WishlistFunctionality    Ends---------");
	}
	
	
	@Test(dataProvider = "MyAccount", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void MyAccount_OrdersElements(String page, String title, String browser, String url) throws InterruptedException  {
		Log.startTestCase("-----------MyAccount_OrdersElements    Starts---------");
		myAccountPage = new MyAccountPage();
		launchApp_V1(browser, url);
		myAccountPage.profileIcon_LoggedIcon(title);
		myAccountPage.orderElements();
		Log.endTestCase("-----------MyAccount_OrdersElements    Ends---------");
	}
	
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void tearDown() {
		getDriver().close();
	}
}
