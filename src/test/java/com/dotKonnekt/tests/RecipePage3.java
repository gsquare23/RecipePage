package com.dotKonnekt.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CommonUtils;
import com.dotKonnekt.utility.Log;

public class RecipePage3 extends BaseClass {

	public CommonUtils commonUtils;
	
	
	@Test(dataProvider = "RecipePage", dataProviderClass = DataProviders.class, enabled = false)
	public void titleVerification(String runText, String title, String page, String browser, String url,String AuthorName, String CategoryElements, String publishDate, String blogTitle,
			String ingredientsElements, String directionElements, String tagsElements, String nutritionList)
			throws InterruptedException {
		
		launchApp_V1(browser, url);
		Log.info("Verfying the title of the Page....RecipePage3");
		String actualTitle = getDriver().getTitle();
		System.out.println(actualTitle);
		System.out.println(title);
		Assert.assertEquals(actualTitle, title, "Title Verified");
	 
	}
	@Test(dataProvider = "RecipePage", dataProviderClass = DataProviders.class, enabled = false)
	public void pageHeaderVerification(String runText, String title, String page, String browser, String url,String AuthorName, String CategoryElements, String publishDate, String blogTitle,
			String ingredientsElements, String directionElements, String tagsElements, String nutritionList)
			throws InterruptedException {
		Log.startTestCase("verifyPageHeader....RecipePage3");
		launchApp_V1(browser, url);
		Action.implicitWait(getDriver(), 10);
		Log.info("-------SEARCHBOX FUNCTIONALITY START ------");

		WebElement searchBox = getDriver().findElement(By.xpath("//input[@id='free-solo-2-demo']"));
		if (searchBox.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + searchBox.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + searchBox.isDisplayed());
			Assert.assertTrue(searchBox.isDisplayed());
		}

		// that the “Search” Box is enabled
		if (searchBox.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + searchBox.isEnabled()); // Thread.sleep(5000);
			Action.explicitWait(getDriver(), searchBox, Duration.ofSeconds(10));																			
			// searchBox.sendKeys("Selenium");
		
		} else {
			System.out.println("Search Box is not enabled. Return: " + searchBox.isEnabled());
			Assert.assertTrue(searchBox.isEnabled());
		}
		Log.info("-------SEARCHBOX FUNCTIONALITY END ------");

		Log.info("-------CARTButton FUNCTIONALITY START ------");

		WebElement cart = getDriver().findElement(By.xpath("(//img[@alt ='logo'])[3]"));
		if (cart.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + cart.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + cart.isDisplayed());
		}

		// verify that the “Cart” Button is enabled
		if (cart.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + cart.isEnabled());
		} else {
			System.out.println("Search Box is not enabled. Return: " + cart.isEnabled());
			Assert.assertTrue(cart.isEnabled());
		}
		Log.info("-------CARTButton FUNCTIONALITY END ------");

		Log.info("-------userButton FUNCTIONALITY START ------");

		WebElement userButton = getDriver().findElement(By.xpath("(//img[@alt='logo'])[4]"));
		if (userButton.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + userButton.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + userButton.isDisplayed());
		}

		// verify that the “Search” Box is enabled
		if (userButton.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + userButton.isEnabled());
		} else {
			System.out.println("Search Box is not enabled. Return: " + userButton.isEnabled());
			Assert.assertTrue(userButton.isEnabled());
		}
		Log.info("-------userButton FUNCTIONALITY END ------");

		Log.info("-------Logo FUNCTIONALITY START ------");

		WebElement Logo = getDriver().findElement(By.xpath("(//img[@alt='logo'])[1]"));
		if (Logo.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + Logo.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + Logo.isDisplayed());
			Assert.assertTrue(false);
		}

		// verify that the “LOGO” Box is enabled
		if (Logo.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + Logo.isEnabled());

		} else {
			System.out.println("Search Box is not enabled. Return: " + Logo.isEnabled());
			Assert.assertTrue(Logo.isEnabled());
		}
		Log.info("-------Logo FUNCTIONALITY END ------");
		
	}
	
	@Test(dataProvider = "RecipePage", dataProviderClass = DataProviders.class)
	public  void categoryElements(String runText, String title, String page, String browser, String url,String AuthorName, String CategoryElements, String publishDate, String blogTitle,
			String ingredientsElements, String directionElements, String tagsElements, String nutritionList)throws InterruptedException {
		
		
		Log.startTestCase("categoryElements....RecipePage3");
		Log.info("Verfying the Category List");
		launchApp_V1(browser, url);
		int count = 0;
		List<WebElement> menuList = getDriver().findElements(By.xpath("//div[@class='MuiBox-root css-1y4n82h']/button"));
		System.out.println(menuList.size());

		List<String> listElements = new ArrayList<String>();
		for (WebElement webElement : menuList) {
			// String text = webElement.getText();
			// System.out.print(text+", ");
			listElements.add(webElement.getText().replace(" ", ","));
			count++;
		}
		// System.out.println(listElements);
		String delim = ",";
		String category = String.join(delim, listElements);
		System.out.println(category);
		// System.out.println(CategoryElements);
		Assert.assertEquals(category, CategoryElements);
		if (count != 0) {
			if (count == menuList.size()) {
				System.out.println("Category elements are equal");
			} else {
				System.out.println("Category elements are not equal");
				Assert.assertTrue(false);
			}
		} else {
			System.out.println("Category are not present");
		}
	
	}
	
	@Test(dataProvider = "RecipePage", dataProviderClass = DataProviders.class, enabled = false)
	public void authornameVerification(String runText, String title, String page, String browser, String url,String AuthorName, String CategoryElements, String publishDate, String blogTitle,
			String ingredientsElements, String directionElements, String tagsElements, String nutritionList)
			throws InterruptedException  {
		Log.info("Author Name Verification");
		launchApp_V1(browser, url);
		String actualAuthorName = getDriver()
				.findElement(By.xpath(
						"//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']"))
				.getText();
		System.out.println(actualAuthorName);
		Assert.assertEquals(actualAuthorName, AuthorName);

		String actualPublishDate = getDriver()
				.findElement(By.xpath(
						"//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']"))
				.getText();
		String actdate = "/" + actualPublishDate + "/";
		// System.out.println("/"+actualPublishDate+"/");
		Assert.assertEquals(actdate, publishDate);
	}
	@Test(dataProvider = "RecipePage", dataProviderClass = DataProviders.class, enabled = false)
	public void blogTitle(String runText, String title, String page, String browser, String url,String AuthorName, String CategoryElements, String publishDate, String blogTitle,
			String ingredientsElements, String directionElements, String tagsElements, String nutritionList)
			throws InterruptedException {
		Log.info("-----Veryfying the blog title--------....RecipePage3");
		launchApp_V1(browser, url);
		String actualblogTitle = getDriver()
				.findElement(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-1q9lqtf']")).getText();
		System.out.println(actualblogTitle);
		Assert.assertEquals(blogTitle, actualblogTitle);
	}
	
	@Test(dataProvider = "RecipePage", dataProviderClass = DataProviders.class, enabled = false)
	public  void recipePagesetUp(String runText, String title, String page, String browser, String url,String AuthorName, String CategoryElements, String publishDate, String blogTitle,
			String ingredientsElements, String directionElements, String tagsElements, String nutritionList)
			throws InterruptedException {
		if(runText.equalsIgnoreCase("yes")) {

		Log.startTestCase("recipePagesetUp....RecipePage3");
		System.out.println(browser);
		launchApp_V1(browser, url);

// --------------vERYFYING THE INGREDIENTS LIST

		Log.info("------vERYFYING THE INGREDIENTS LIST--------");
		int count1 = 0;
		List<String> listElements1 = new ArrayList<String>();
		List<WebElement> ingredientsList = getDriver().findElements(By.xpath("//p[@id= 'ingredientText']/ul/li"));
		System.out.println(ingredientsList.size());

		for (WebElement webElement : ingredientsList) {
			listElements1.add(webElement.getText());
			count1++;
		}
		String delim1 = "\n";
		String ingredients = String.join(delim1, listElements1);
		System.out.println(ingredients);
		Assert.assertEquals(ingredients, ingredientsElements);

		if (count1 == ingredientsList.size()) {
			System.out.println("menuLists elements are equal");

		} else {
			System.out.println("menuLists elements are not equal");
			Assert.assertTrue(false);
		}

		Log.info("----Image is displayed or not ----");
		Assert.assertTrue(getDriver().findElement(By.xpath("//img[@alt='The house from the offer.']")).isDisplayed());

//  Directions List Verification------------------------

		Log.info("-------------------Directions Verification----------");
		Log.info("----Verifyine the directions ---");

		String text1 = getDriver().findElement(By.xpath("(//p[@varient='h5'])[2]")).getText();
		Assert.assertEquals(text1, "Directions");

		Log.info("Checking the content for Directions");

		List<WebElement> directionsSteps = getDriver().findElements(By.xpath("(//p[@id='directionText'])/ol/li"));

		System.out.println(directionsSteps.size());
		int count11 = 0;
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)", "");

		List<String> directionElements1 = new ArrayList<String>();
		for (WebElement webElement : directionsSteps) {
			directionElements1.add(webElement.getText());
			count11++;
		}
		String delim11 = "\n";
		String directions = String.join(delim11, directionElements1);
		System.out.println(directions);
		Assert.assertEquals(directions, directionElements);
		if (count11 == directionsSteps.size()) {
			System.out.println("Directions Steps are equal");
			// Assert.assertTrue(false);
		} else {
			System.out.println("Directions Steps are not equal");
			Assert.assertTrue(false);
		}

		/*
		 * Log.info("Veryfying the Tag List");
		 * 
		 * System.out.println(getDriver().findElement(By.
		 * xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']")).
		 * getText());
		 * 
		 * WebElement seeMoreButton =getDriver().findElement(By.
		 * xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-juaq']"));
		 * if(seeMoreButton.isDisplayed()) { seeMoreButton.click(); }
		 * 
		 * //getDriver().findElements(By.
		 * xpath("//span[@class=\"MuiChip-label MuiChip-labelMedium css-9iedg7\"]"))
		 * List<WebElement> tagList = getDriver().findElements(By.
		 * xpath("//div[@class='MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-filledDefault css-19weim']/span"
		 * )); System.out.println(tagList.size()); int countt = 0; //JavascriptExecutor
		 * js1 = (JavascriptExecutor) getDriver();
		 * //js1.executeScript("window.scrollBy(0,1000)", ""); List<String> tags = new
		 * ArrayList<String>(); for (WebElement webElement : tagList) {
		 * tags.add(webElement.getText()); countt++; } String deli = "\n"; String taggs
		 * = String.join(delim11, tags); System.out.println(taggs);
		 * Assert.assertEquals(taggs, tagsElements);
		 * 
		 * if (countt == tagList.size()) { System.out.println("Tags List are equal");
		 * //Assert.assertTrue(false); } else {
		 * System.out.println("Tags list Steps are not equal");
		 * Assert.assertTrue(false); }
		 */

//////////////////////////////////////////////////////////////////////////////////////////////		

		// Nutrition List verification

		Log.info("Nutrition per Saving lists");
		String nutrionName = getDriver()
				.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1aoo3g']")).getText();
		Assert.assertEquals(nutrionName, "Nutritions Per Serving");
		WebElement seeButton = getDriver()
				.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1fatci1']"));
		if (seeButton.isDisplayed()) {
			seeButton.click();
		}
		List<WebElement> nutritionLists = getDriver()
				.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-22dtt9']"));
		System.out.println(nutritionLists.size());
		int count111 = 0;
		// JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		// js1.executeScript("window.scrollBy(0,1000)", "");

		List<String> NutritionElements = new ArrayList<String>();
		for (WebElement webElement : nutritionLists) {
			// System.out.println(webElement.getText());
			NutritionElements.add(webElement.getText());
			count111++;
		}
		System.out.println(nutritionList);
		String deli = "\n";
		String nutritions = String.join(deli, NutritionElements);
		System.out.println(nutritions);
		Assert.assertEquals(nutritions, nutritionList);

		if (count111 == nutritionLists.size()) {
			System.out.println("nutritionList List are equal");
			// Assert.assertTrue(false);
		} else {
			System.out.println("nutritionList list Steps are not equal");
			Assert.assertTrue(false);
		}
	}
		
		else {
			Log.warn("This is test step is set to No Run.");
		}
	}

	@AfterMethod
	public void teardown() {
		getDriver().close();
	}

}
