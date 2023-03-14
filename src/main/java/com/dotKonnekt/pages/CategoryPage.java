package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class CategoryPage extends BaseClass{

	String searchBox = "//input[@placeholder='Search']";
	String clickButton=  "//div[@class='MuiInputAdornment-root MuiInputAdornment-positionStart MuiInputAdornment-outlined MuiInputAdornment-sizeMedium css-1a6giau']//*[name()='svg']";
	String welcomeTxt1 = "(//p[@class='MuiTypography-root MuiTypography-body1 css-k1juyd'])[1]";
	String accessTxt ="(//p[@class='MuiTypography-root MuiTypography-body1 css-1yt7wtf'])[1]";
	String loginTxt = "(//button[normalize-space()='LOGIN/SIGNUP'])[1]";
	String categoryElements = "//div[@class='MuiBox-root css-1y4n82h']/button";
	String Author = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']";
	String P_Date = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']";
	String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a";
	String loginPageTxt = "//input[@placeholder='Email']";
	String likeIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";

	public CategoryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	//String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a[1]";
	String bd_Category = "//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-18zeukv']";
	public String breadCrumbFunctionality() {
		String bd1text = getDriver().findElement(By.xpath(bd_Home)).getText();
		Assert.assertEquals(bd1text, "Home");
		String bdlast = getDriver().findElement(By.xpath(bd_Category)).getText();
		return bdlast;
		
	}
	
	String imageDescription = "//div[@class='MuiBox-root css-cgiybc']//img[@alt='logo']";
	public void imageVerification() {
		WebElement imageDes = getDriver().findElement(By.xpath(imageDescription));
		Action.explicitWait(getDriver(), imageDes, Duration.ofSeconds(5));
		//boolean p =Action.isDisplayed(getDriver(), imageDes);
		Boolean p = (Boolean) ((JavascriptExecutor)getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", imageDes);
		if(p) {
			System.out.println("Image is present nad verified successfully");
		}
		else {
			System.out.println("Image is not present");
			Assert.assertTrue(false, "Image is not present");
		}
	}
	
	String taggscount= "//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7']";
	public void tagList(){
		 Log.info("Veryfying the Tag List");
		  WebElement tagText = getDriver().findElement(By.
				  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']"));
		  Action.scrollByVisibilityOfElement(getDriver(), tagText);
		   System.out.println(tagText.getText());
		List<WebElement> taggs = getDriver().findElements(By.xpath(taggscount));
		System.out.println(taggs.size());
			if(taggs.size() == 4) {
				System.out.println(getDriver().findElement(By.xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-juaq']")).getText());
				  WebElement seeMoreButton =getDriver().findElement(By.
				  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-juaq']"));
				  if(seeMoreButton.isDisplayed()) { seeMoreButton.click(); }
				  
				  getDriver().findElements(By. xpath("//span[@class=\"MuiChip-label MuiChip-labelMedium css-9iedg7\"]"));
				  Action.explicitWait(getDriver(), seeMoreButton, Duration.ofSeconds(10));
				  List<WebElement> tagList = getDriver().findElements(By.
				  xpath(taggscount)); 
				  System.out.println(tagList.size()); 
				  int countt = 0;
				  JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
				  js1.executeScript("window.scrollBy(0,1000)", "");
				  List<String> tags = new  ArrayList<String>();
				  for (WebElement webElement : tagList) {
					  tags.add(webElement.getText()); 
					  countt++;
					  } 
				  String deli = "\n"; 
				  String taggs1 = String.join(deli, tags);
				  System.out.println(taggs1);
				  
				  //  Assert.assertEquals(taggs, tagsElements);
				  
				  if (countt == tagList.size()) 
				  { System.out.println("Tags List are equal");
				  Assert.assertTrue(true); } 
				  else {
				  System.out.println("Tags list Steps are not equal");
				  Assert.assertTrue(false); }}
			else if(taggs.size()<4 && taggs.size() !=0) {
					List<WebElement> tagList = getDriver().findElements(By.
							  xpath(taggscount)); 
							  System.out.println(tagList.size()); 
							  int countt = 0;
							  JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
							  js1.executeScript("window.scrollBy(0,1000)", "");
							  List<String> tags = new  ArrayList<String>();
							  for (WebElement webElement : tagList) {
								  tags.add(webElement.getText()); 
								  countt++;
								  } 
							  String deli = "\n"; 
							  String taggs1 = String.join(deli, tags);
							  System.out.println(taggs1);
							  
							  //  Assert.assertEquals(taggs, tagsElements);
							  
							  if (countt == tagList.size()) 
							  { System.out.println("Tags List are equal");
							  Assert.assertTrue(true); } 
							  else {
							  System.out.println("Tags list Steps are not equal");
							  Assert.assertTrue(false); }
						}
			else if(taggs.size()==0) {
				System.out.println("Taggs elements are blank");
				Assert.assertTrue(false, "Taggs elements are blank");
			}			
	}
	
	String subtabs  = "//div[@class='MuiTabs-flexContainer css-k008qs']/button";
	public void subTabsverification() {
		int count =0;
		List<WebElement>  tabs =getDriver().findElements(By.xpath(subtabs));
		int size = tabs.size();
		System.out.println(size);
		List<String> tabsElements = new ArrayList<String>();
		for (WebElement webElement : tabs) {
			tabsElements.add(webElement.getText());
			if(webElement.isEnabled()) {
			count++;}
		}
		 String deli = "\n"; 
		  String subtabss= String.join(deli, tabsElements);
		  System.out.println(subtabss);
		  
		  if (count == tabs.size() && count != 0 ) 
		  { System.out.println("subTabs List are equal");
		  Assert.assertTrue(true); } 
		  else  {
		  System.out.println("subTabs list Steps are not equal");
		  Assert.assertTrue(false, "subTabs list Steps are not equal" ); }
	}
	 String allproduct ="//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-1y49jfj']";
	String quickview = "//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String discountedPrice = "//p[@class='MuiTypography-root MuiTypography-body1 css-1tva794']";
	String actualPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-lgaoco']";
	String productsName = "//div[@class='MuiBox-root css-kgu7cg']";
	String images  = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-1y49jfj']/span/img";
	String carticon = "//*[name()='svg' and @data-testid='ShoppingCartOutlinedIcon']";
	String wishlist = "//*[name()='svg' and @data-testid='FavoriteBorderOutlinedIcon']";
	SoftAssert softAssert = new SoftAssert();
		public void newArrival() throws InterruptedException {
		String filter = "//p[@class='MuiTypography-root MuiTypography-body1 css-1rp7iwk']";
		WebElement filterBy = getDriver().findElement(By.xpath(filter));
		Action.scrollByVisibilityOfElement(getDriver(), filterBy);
  
		//List<WebElement> carticon1 =getDriver().findElements(By.xpath(carticon));
		//List<WebElement> wishlist1 =getDriver().findElements(By.xpath(wishlist));
		
		
		List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
		int n = products1.size();
		System.out.println(n);
	
		
		if(n>0) {
		List<WebElement> productName1 = getDriver().findElements(By.xpath(productsName));
		int j = productName1.size();
		if(j==n) {System.out.println("All Products name are present");}
			else {
			System.out.println(n-j + " Products name are not present ");
			softAssert.assertTrue(false, +n-j+" Products name are not present ");
			}
		
		List<WebElement> productActPrice = getDriver().findElements(By.xpath(actualPrice));
		int z = productActPrice.size();
		if(z==n) {System.out.println("All Actual Prices are present");}
			else {
			System.out.println(n-z + " Actual Prices are not present ");
			softAssert.assertTrue(false, n-z+" Actual Prices are not present ");
			}
		
		List<WebElement> quickviewlink = getDriver().findElements(By.xpath(quickview));
		int i = quickviewlink.size();
		if(i==n) {System.out.println("All Quick View links are present");}
			else {
			System.out.println(n-i + " Quick View links are not present ");
			softAssert.assertTrue(false, n-i+" Quick View links are not present ");
			}
		
		List<WebElement> image = getDriver().findElements(By.xpath(images));
		int x = image.size();
		if(x==n) {System.out.println("All images are present");}
			else {
			System.out.println(n-x + " Images are not present ");
			softAssert.assertTrue(false, +n-x+" Images are not present ");
			}
		
		List<WebElement> carticon1 =getDriver().findElements(By.xpath(carticon));
		int c = carticon1.size();
		if(c==n) {System.out.println("All carticon are present");}
			else {
			System.out.println(n-c + " carticon are not present ");
			softAssert.assertTrue(false, +n-c+" carticon are not present ");
			}
		
		List<WebElement> wishlist1 =getDriver().findElements(By.xpath(wishlist));
		
		int d = carticon1.size();
		if(d==n) {System.out.println("All Wishlist icon are present");}
			else {
			System.out.println(n-d + " Wishlist icon are not present ");
			softAssert.assertTrue(false, +n-c+" Wishlist icon are not present ");
			}
			/*
			 * for(WebElement img : image) { Action.mouseOverElement(getDriver(), img);
			 * Thread.sleep(1000); for(WebElement a : carticon1) { if(a.isDisplayed()) {
			 * System.out.println("Cart Icon is present"); break; } else
			 * {softAssert.assertTrue(false, " Cart icon is not present"); } }
			 * 
			 * for(WebElement b : wishlist1) { if(b.isDisplayed()) {
			 * System.out.println("Wishlist Icon is present"); break; } else
			 * {softAssert.assertTrue(false, " Wishlist icon is not present"); } } }
			 */
	
		
		softAssert.assertAll();
		}
		else {
			System.out.println("No Products are available");
		}
	
	}
	
			
}
