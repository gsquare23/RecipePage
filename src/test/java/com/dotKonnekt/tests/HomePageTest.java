package com.dotKonnekt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CommonPagedetails;
import com.dotKonnekt.pages.HomePage;
import com.dotKonnekt.utility.Log;

public class HomePageTest extends BaseClass{
	
	HomePage homePage;
	CommonPagedetails commonPagedetails;
	
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn") 
	public void TitleVerification(String page, String title, String browser, String url) {
		Log.startTestCase("TitleVerification");
		commonPagedetails = new CommonPagedetails();
		//launchApp("Chrome", url);
		String actualTitle = commonPagedetails.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "dot beauty", "Title Not Verified");
		Log.endTestCase("TitleVerification");
	}
}
