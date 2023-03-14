package com.dotKonnekt.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CommonPagedetails;
import com.dotKonnekt.pages.LoginPage;
import com.dotKonnekt.pages.RecipePageFinal;
import com.dotKonnekt.pages.BlogPage;
import com.dotKonnekt.pages.CategoryPage;
import com.dotKonnekt.utility.Log;

public class BlogPageTest  extends BaseClass {
	
	RecipePageFinal recipePage;
	CommonPagedetails commonPagedetails;
	BlogPage blogPage;
	CategoryPage categoryPage;	
	LoginPage loginPage;
	
	String welcomeTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-k1juyd'])[1]";
	String accessTxt ="(//p[@class='MuiTypography-root MuiTypography-body1 css-1yt7wtf'])[1]";
	String loginTxt = "(//button[normalize-space()='LOGIN/SIGNUP'])[1]";
	String BlogPageElements = "//div[@class='MuiBox-root css-1y4n82h']/button";
	String Author = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']";
	String P_Date = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']";
	String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a";
	String loginPageTxt = "//input[@placeholder='Email']";
	String likeIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	public void BlogPage_TitleVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) {
		Log.startTestCase("BlogPage_TitleVerification");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		String actualTitle = commonPagedetails.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, title, "Title Not Verified");
		Log.endTestCase("BlogPage_TitleVerification");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	
	public void BlogPage_PageHeaderVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) {
		Log.startTestCase("BlogPage_PageHeaderVerification");
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
		Log.endTestCase("BlogPage_PageHeaderVerification");
	}
	
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_SearchFucntionalityVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		
		Log.startTestCase("-----------BlogPage_SearchFucntionalityVerification    Starts---------");
		
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateSeachFunctionality("Black","Keyboard",title);
		
		Log.info("SearchFucntionality Works perfectly");
		Log.endTestCase("-----------BlogPage_SearchFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_CartFucntionalityVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_CartFucntionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateCartIconFunctionality();
		Log.info("CartFucntionality Works perfectly");
		Log.endTestCase("-----------BlogPage_CartFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_UserFunctionalityVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) {

		Log.startTestCase("-----------BlogPage_UserFunctionalityVerification    Starts---------");
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.UserButtonFunctionality(title);
		Log.endTestCase("-----------BlogPage_UserFunctionalityVerification    Ends---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_LogoFunctionalityVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {

		Log.startTestCase("-----------BlogPage_LogoFunctionalityVerification    Starts---------");
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.logoFunctionality(title);
		Log.info("LogoFunctionalityVerification Works perfectly");
		Log.endTestCase("-----------BlogPage_LogoFunctionalityVerification    Ends---------");
	}
	
	String BlogPage = "//div[@class='css-1hvic5s']/div/button";
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public  void BlogPage_BlogPageElements(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("BlogPage_BlogPageElements");
		Log.info("Verfying the BlogPage List");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		WebElement login = getDriver().findElement(By.xpath(BlogPage));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		//Thread.sleep(1000);
		recipePage.CategoryListVerification();	
		Log.endTestCase("-----------BlogPage_BlogPageElements---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void BlogPage_addCommentVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) {
		Log.startTestCase("-----------BlogPage_addCommentVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.addCommentVerification();
		Log.endTestCase("-----------BlogPage_addCommentVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_recipeImage(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_recipeImage    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.imageVerification();

		Log.endTestCase("-----------BlogPage_recipeImage    Ends---------");
	}
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_authornameVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle){
		
		Log.startTestCase("-----------BlogPage_authornameVerification    Starts---------");
		Log.info("Author Name Verification");
		launchApp_V1(browser, url);
		recipePage = new RecipePageFinal();
		recipePage.authoreDetailsVerification(AuthorName, PublishDate);
		
		Log.endTestCase("-----------BlogPage_authornameVerification    Ends---------");
	}
	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_likeIconFunctionality1(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_likeIconFunctionality1    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.LikeIconfunctionality("Loggedout");
		Log.endTestCase("-----------BlogPage_likeIconFunctionality1    Ends---------");
	}
	

	
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_bookMarkIconFunctionality(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_bookMarkIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.BookMarkIconfunctionality("Loggedout");
		Log.endTestCase("-----------BlogPage_bookMarkIconFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_ShareIconFunctionality(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_ShareIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.ShareIconfunctionality();
		Log.endTestCase("-----------BlogPage_ShareIconFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_blogTitleVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle){
		Log.startTestCase("-----------BlogPage_blogTitleVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		String actualBlogTitle = blogPage.blogTitleVerification();
		Assert.assertEquals(actualBlogTitle, blogTitle);
		Log.endTestCase("-----------BlogPage_blogTitleVerification    Ends---------");
	}
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_tagsVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_tagsVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.tagList();
		Log.endTestCase("-----------BlogPage_tagsVerification    Ends---------");
	}
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_ProductImageVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) {
		Log.startTestCase("-----------BlogPage_ProductImageVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.productImageVerification();
		Log.endTestCase("-----------BlogPage_ProductImageVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_ProductElementsVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) {
		Log.startTestCase("-----------BlogPage_ProductElementsVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.productElementsVerification();
		Log.endTestCase("-----------BlogPage_ProductElementsVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_BlogVideoVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_BlogVideoVerification    Starts---------");
		blogPage = new BlogPage();
		launchApp_V1(browser, url);
		blogPage.blogVideoSection();
		Log.endTestCase("-----------BlogPage_BlogVideoVerification    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled =  true, groups = "NotLoggedIn")
	public void BlogPage_BreadCrumbVerification(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_BreadCrumbVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.breadCrumbFunctionality(title);
		Log.endTestCase("-----------BlogPage_BreadCrumbVerification    Ends---------");
		
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	

	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = false, groups = "LoggedIn")
	public void BlogPage_AddCommentinCommentSeection(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("BlogPage_AddCommentinCommentSeection");

		launchApp_V1(browser, prop.getProperty("LoginUrl"));
		Log.startTestCase("Entering the data");
		loginPage = new LoginPage();
		loginPage.loginSetup(prop.getProperty("Username"), prop.getProperty("Password"));
		getDriver().get(url);
		recipePage = new RecipePageFinal();
		recipePage.LoggedInAddCommentsVerification("save");
		Log.endTestCase("-----------BlogPage_AddCommentinCommentSeection ---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = false, groups = "LoggedIn")
	public void BlogPage_bookMarkIconFunctionalityLoggedIn(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_bookMarkIconFunctionalityLoggedIn    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.BookMarkIconfunctionality("LoggedIn");
		Log.endTestCase("-----------BlogPage_bookMarkIconFunctionalityLoggedIn    Ends---------");
	}
	
	@Test(dataProvider = "BlogPage1", dataProviderClass = DataProviders.class, enabled = true, groups = "LoggedIn")
	public void BlogPage_likeIconFunctionality(String page, String title, String browser, String url, String BlogPageElements, String AuthorName, String PublishDate, String blogTitle) throws InterruptedException {
		Log.startTestCase("-----------BlogPage_likeIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.LikeIconfunctionality("Logged");
		Log.endTestCase("-----------BlogPage_likeIconFunctionality    Ends---------");
	}
	
	
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void teardown() {
		getDriver().close();
	}
}
