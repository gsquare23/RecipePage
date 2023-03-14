package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class BlogPage extends BaseClass{

	

	public BlogPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	String Blogimage = "//div[@class='MuiBox-root css-xyyqyk']//img[@alt='logo']";
	public void imageVerification() throws InterruptedException {
		WebElement imageDes = getDriver().findElement(By.xpath(Blogimage));
		System.out.println(imageDes.isDisplayed());
		Thread.sleep(2000);
		Action.explicitWait(getDriver(), imageDes, Duration.ofSeconds(5));
		Boolean p = (Boolean) ((JavascriptExecutor)getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", imageDes);
		if(p) {
			System.out.println("Image is present nad verified successfully");
		}
		else {
			System.out.println("Image is not present");
			Assert.assertTrue(false, "Image is not present");
		}
		
		
	}
	
	String blog_title = "//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css-rhwwre']";
	public String blogTitleVerification() {
		String actualblogTitle = getDriver().findElement(By.xpath(blog_title)).getText();
		return actualblogTitle;
		
	}
	
	String image = "//div[@class='MuiBox-root css-0']/img";
	String wishlist = "//div[@class='MuiBox-root css-1u95go6']/button";
	public void productImageVerification() {
		List<WebElement> images = getDriver().findElements(By.xpath(image));
		List<WebElement> wishlistIcons = getDriver().findElements(By.xpath(wishlist));
		if(images.size() == wishlistIcons.size()) {
		if(images.size()==0 || images.size()<0) {
			System.out.println("Product images are not present");
		}
		else {
			for (WebElement webElement : images) {
				boolean result = Action.isDisplayed(getDriver(), webElement);
				Assert.assertTrue(result);
			}
		}
		}
		else {
			System.out.println(wishlistIcons.size());
			System.out.println(images.size());
			System.out.println("Wishlist icons and images are not equal");
		}
	}
	
	String ratings = "//div[@class='MuiBox-root css-yeouz0']/span";
	String quickView ="//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String productName = "//div[@class='MuiTypography-root MuiTypography-h5 css-qla7e7']";
	String productPrice = "//p[@class='MuiTypography-root MuiTypography-body1 css-1tk0scz']";
	String addtoCartBtn = "//div[@class='css-jf1lks']/button";
	String productDetail = "//div[@class='MuiTypography-root MuiTypography-body1 css-rkcvek']/a";
	public void productElementsVerification() {
		List<WebElement> Ratings = getDriver().findElements(By.xpath(ratings));
		List<WebElement> QuickView = getDriver().findElements(By.xpath(quickView));
		List<WebElement> ProductName = getDriver().findElements(By.xpath(productName));
		List<WebElement> ProductPrice = getDriver().findElements(By.xpath(productPrice));
		List<WebElement> AddtoCartBtn = getDriver().findElements(By.xpath(addtoCartBtn));
		int i = Ratings.size();
		int j = QuickView.size();
		int k = ProductName.size();
		int l = ProductPrice.size();
		int m = AddtoCartBtn.size();
		System.out.println(i);
		if(i==j || j==k || k==l || l==m) {
			System.out.println("Products have all the elements");
			for( WebElement element : AddtoCartBtn) {
				boolean result =  Action.isEnabled(getDriver(), element);
				 if(!result) {
					 System.out.println("AddtoCartbutton is not Enabled yet");
					 Assert.assertTrue(result,"AddtoCartbutton is not Enabled yet");
				 }
				
			}
			/*
			 * WebElement ProductDetail = getDriver().findElement(By.xpath(productDetail));
			 * for(WebElement qView : QuickView) { qView.click(); boolean result =
			 * Action.isDisplayed(getDriver(), ProductDetail); System.out.println(result); }
			 */
		}
		else if(k==0) {
			System.out.println("No products are available");
		}
		else {
			System.out.println("Not able to find the products");
			Assert.assertTrue(false);
		}	
	}
	
	
	String recipeVideo = "//div[@class='MuiBox-root css-1cbkcwo']";
	public void blogVideoSection() throws InterruptedException {
		WebElement recipeVideos = getDriver().findElement(By.xpath(recipeVideo));
		Action.scrollByVisibilityOfElement(getDriver(), recipeVideos);
		System.out.println(Action.isDisplayed(getDriver(), recipeVideos));
		Action.click(getDriver(), recipeVideos);
		Thread.sleep(5000);
	}
	
}
