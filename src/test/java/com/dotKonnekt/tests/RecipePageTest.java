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
import com.dotKonnekt.utility.Log;

public class RecipePageTest extends BaseClass {

	RecipePageFinal recipePage;
	CommonPagedetails commonPagedetails;
	LoginPage loginPage;
	String category = "//div[@class='css-1hvic5s']/div/button";
	String welcomeTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-k1juyd'])[1]";
	String accessTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1yt7wtf'])[1]";
	String loginTxt = "(//button[normalize-space()='LOGIN/SIGNUP'])[1]";
	String categoryElements = "//div[@class='MuiBox-root css-1y4n82h']/button";
	String Author = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']";
	String P_Date = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']";
	String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a";
	String loginPageTxt = "//input[@placeholder='Email']";
	String likeIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";
	

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_TitleVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {

		Log.startTestCase("RecipePage_TitleVerification");
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		String actualTitle = commonPagedetails.getTitle();
		Assert.assertEquals(actualTitle, title, "Title Not Verified");
		Log.endTestCase("RecipePage_TitleVerification");

	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_BreadCrumbVerification (String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		 Log.startTestCase("-----------RecipePage_BreadCrumbVerification    Starts---------");
		 recipePage = new RecipePageFinal();
		 launchApp_V1(browser, url);
		 recipePage.breadCrumbFunctionality(title);
		 Log.endTestCase("-----------RecipePage_BreadCrumbVerification    Ends---------");
	 }
	
	
	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_LogoFunctionalityVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {

		Log.startTestCase("-----------RecipePage_LogoFunctionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.logoFunctionality(title);
		Log.endTestCase("-----------RecipePage_LogoFunctionalityVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_SearchFucntionalityVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_SearchFucntionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateSeachFunctionality("Black", "Keyboard", title);
		Log.info("SearchFucntionality Works perfectly");
		Log.endTestCase("-----------RecipePage_SearchFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_CartFucntionalityVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_CartFucntionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateCartIconFunctionality();
		Log.info("CartFucntionality Works perfectly");
		Log.endTestCase("-----------RecipePage_CartFucntionalityVerification    Ends---------");
	}
	
	
	
	

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_UserFunctionalityVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {

		Log.startTestCase("-----------RecipePage_UserFunctionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.UserButtonFunctionality(title);
		Log.endTestCase("-----------RecipePage_UserFunctionalityVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_categoryElements(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {

		Log.startTestCase("RecipePage_categoryElements....RecipePage3");
		Log.info("Verfying the Category List");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		WebElement login = getDriver().findElement(By.xpath(category));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		recipePage.CategoryListVerification();
		Log.endTestCase("-----------RecipePage_categoryElements    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_authornameVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {

		Log.startTestCase("-----------RecipePage_authornameVerification    Starts---------");
		Log.info("Author Name Verification");
		launchApp_V1(browser, url);
		recipePage = new RecipePageFinal();
		recipePage.authoreDetailsVerification(AuthorName, PublishDate);
		Log.endTestCase("-----------RecipePage_authornameVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")

	public void RecipePage_recipeImage(String page, String title, String browser, String url, String CategoryElements,
			String AuthorName, String PublishDate, String Blogtitle, String nutritionList, String see_more)
			throws InterruptedException {
		Log.startTestCase("-----------RecipePage_recipeImage    Starts---------");
		recipePage = new RecipePageFinal();
		// loginPage = new LoginPage();
		launchApp_V1(browser, url);
		recipePage.recipeImage();

		Log.endTestCase("-----------RecipePage_recipeImage    Ends---------");
	}

	

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_likeIconFunctionality1(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_likeIconFunctionality1    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.LikeIconfunctionality("Loggedout");
		Log.endTestCase("-----------RecipePage_likeIconFunctionality1    Ends---------");

		Log.startTestCase("-----------BookMark__IconFunctionality    Starts---------");
		recipePage.BookMarkIconfunctionality("Loggedout");
		Log.endTestCase("-----------BookMark__IconFunctionality    Ends---------");

		Log.startTestCase("-----------Share__IconFunctionality    Starts---------");
		recipePage.ShareIconfunctionality();
		Log.endTestCase("-----------Share__IconFunctionality    Ends---------");
	}

	

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_blogTitleVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_blogTitleVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		String actualBlogTitle = recipePage.blogTitleVerification();
		Assert.assertEquals(actualBlogTitle, Blogtitle);
		Log.endTestCase("-----------RecipePage_blogTitleVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_tagsVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_tagsVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.tagList();
		Log.endTestCase("-----------RecipePage_tagsVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_NutritionlistVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_NutritionlistVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.nutrilionListVerification(nutritionList);
		Log.endTestCase("-----------RecipePage_NutritionlistVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_shopTheIngredientsVeriffication(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_shopTheIngredientsVeriffication    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.shoptheIngredients();
		Log.startTestCase("-----------RecipePage_shopTheIngredientsVeriffication    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_commentsSection(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_commentsSection    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.commentsSectionVerification();
		Log.endTestCase("-----------RecipePage_commentsSection    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_addCommentVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_addCommentVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.addCommentVerification();
		Log.endTestCase("-----------RecipePage_addCommentVerification    Ends---------");
	}

	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_RecipeVideoverification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_RecipeVideoverification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.recipeVideoSection();
		Log.endTestCase("-----------RecipePage_RecipeVideoverification    Ends---------");
	}
	
	@Test(dataProvider = "NewRecipePage1", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void RecipePage_TaglistElementsVerification(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_TaglistElementsVerification    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.tagElements();
		Log.endTestCase("-----------RecipePage_TaglistElementsVerification    Ends---------");
		
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "LoggedIn")
	public void RecipePage_AddCommentinCommentSeection(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("RecipePage_AddCommentinCommentSeection");

		launchApp_V1(browser, prop.getProperty("LoginUrl"));
		Log.startTestCase("Entering the data");
		loginPage = new LoginPage();
		loginPage.loginSetup(prop.getProperty("Username"), prop.getProperty("Password"));
		getDriver().get(url);
		recipePage = new RecipePageFinal();
		recipePage.LoggedInAddCommentsVerification("save");
		Log.endTestCase("-----------RecipePage_AddCommentinCommentSeection ---------");
	}
	
	
	
	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "LoggedIn")
	public void RecipePage_bookMarkIconFunctionality(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_bookMarkIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.BookMarkIconfunctionality("LoggedIn");
		Log.endTestCase("-----------RecipePage_bookMarkIconFunctionality    Ends---------");
	}
	
	@Test(dataProvider = "NewRecipePage", dataProviderClass = DataProviders.class, enabled = true, groups = "LoggedIn")

	public void RecipePage_likeIconFunctionality(String page, String title, String browser, String url,
			String CategoryElements, String AuthorName, String PublishDate, String Blogtitle, String nutritionList,
			String see_more) throws InterruptedException {
		Log.startTestCase("-----------RecipePage_likeIconFunctionality    Starts---------");
		recipePage = new RecipePageFinal();
		launchApp_V1(browser, url);
		recipePage.LikeIconfunctionality("Logged");

		Log.endTestCase("-----------RecipePage_likeIconFunctionality    Ends---------");
	}

	@AfterMethod(groups = { "LoggedIn", "NotLoggedIn" })
	public void teardown() {
		getDriver().close();
	}

}
