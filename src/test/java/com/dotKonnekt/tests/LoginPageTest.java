package com.dotKonnekt.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CommonPagedetails;
import com.dotKonnekt.pages.CommonUtils;
import com.dotKonnekt.pages.LoginPage;
import com.dotKonnekt.pages.RecipePageFinal;
import com.dotKonnekt.utility.Log;

public class LoginPageTest extends BaseClass {

	public LoginPageTest() {
		PageFactory.initElements(getDriver(), this);
	}
	RecipePageFinal recipePage;
	CommonPagedetails commonPagedetails;
	LoginPage loginPage;

	@Test(dataProvider = "LoginPage1", dataProviderClass = DataProviders.class, enabled = false)
	public void titleVerification(String page, String title, String browser, String url, String CategoryElements,
			String WelcomeMsg, String Username, String Password) {
		
		launchApp_V1(browser, url);
		Log.info("Verfying the title of the Page....LoginPageTest");
		String actualTitle = getDriver().getTitle();
		System.out.println(actualTitle);
		System.out.println(title);
		Assert.assertEquals(actualTitle, title, "Title Verified");
	 
	}
	
	
	@Test(dataProvider = "LoginPage1", dataProviderClass = DataProviders.class, enabled = false)
	public void pageHeaderVerification(String page, String title, String browser, String url, String CategoryElements,
			String WelcomeMsg, String Username, String Password) {
		Log.startTestCase("PageHeaderVerification");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		Log.info("-----------Logo Verification Starts----------");
		boolean logoResult = commonPagedetails.valaidateLogo();
		Assert.assertTrue(logoResult);
		Log.info("-----------Logo Verification End successfully----------");
		Log.info("-----------SearchBox Verification Starts----------");
		boolean searchResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(searchResult);
		Log.info("-----------SearchBox Verification End Successfully----------");
		Log.info("-----------Cartbutton Verification Starts----------");
		boolean cartResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(cartResult);
		Log.info("-----------Cartbutton Verification End Successfully----------");
		Log.info("-----------Userbutton Verification Starts----------");
		boolean userResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(userResult);
		Log.info("-----------Userbutton Verification End Successfully----------");
		Log.endTestCase("PageHeaderVerification");
	}
	String category = "//div[@class='css-1hvic5s']/div/button";
	@Test(dataProvider = "LoginPage1", dataProviderClass = DataProviders.class, enabled = true)
	public  void categoryElements(String page, String title, String browser, String url, String CategoryElements,
			String WelcomeMsg, String Username, String Password)throws InterruptedException {
		
		Log.startTestCase("categoryElements....RecipePage3");
		Log.info("Verfying the Category List");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		WebElement login = getDriver().findElement(By.xpath(category));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Thread.sleep(1000);
		recipePage.CategoryListVerification();	
		Log.endTestCase("-----------categoryElements    Ends---------");
	
	}
	
	@Test(dataProvider = "LoginPage1", dataProviderClass = DataProviders.class, enabled = true)
	public void loginSetup(String page, String title, String browser, String url, String CategoryElements,
			String WelcomeMsg, String Username, String Password) throws InterruptedException {

		Log.startTestCase("loginSetup....LoginPageTest");
		System.out.println(browser);
		launchApp_V1(browser, url);
		loginPage = new LoginPage();
		loginPage.loginSetup(Username, Password);

	}

	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}

}
