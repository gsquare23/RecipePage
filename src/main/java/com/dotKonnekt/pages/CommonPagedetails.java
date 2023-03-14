package com.dotKonnekt.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class CommonPagedetails extends BaseClass {
	
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
	public CommonPagedetails() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean valaidateLogo() {
		boolean result  = getDriver().findElement(By.xpath("(//img[@alt='logo'])[1]")).isDisplayed();
		return result;
	}
	
	public boolean validateSearchBox() {
		boolean result  = getDriver().findElement(By.xpath(searchBox)).isDisplayed();
		return result;
	}
	
	public boolean validateCartButton() {
		boolean result  = getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-1p3qk0r']//img[@alt='logo']")).isDisplayed();
		return result;
	}
	public boolean validateUserButton() {
		boolean result  = getDriver().findElement(By.xpath("(//img[@alt ='logo'])[4]")).isDisplayed();
		return result;
	}
	
	String cart = "//div[@class='MuiBox-root css-1p3qk0r']//img[@alt='logo']";
	
	public void validateCartIconFunctionality() {
		WebElement cartIcon  =  getDriver().findElement(By.xpath(cart));
		Action.click(getDriver(), cartIcon);
		String totalItmesTxt = getDriver().findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1093urb']")).getText();
		Assert.assertEquals(totalItmesTxt, "Total item(s):");
		String shippingtxt = getDriver().findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-kidj9m']")).getText();
		Assert.assertEquals(shippingtxt, "Shipping and tax will be calculated on checkout");
		boolean result = getDriver().findElement(By.xpath("(//button[@type='button'][normalize-space()='checkout'])[1]")).isEnabled();
		if(result) 
			Assert.assertTrue(false, "Checkout is enabled it should be disabled ");
	}
	
	
	String recentSearch = "//p[@class='MuiTypography-root MuiTypography-body1 css-64acg5']";
	String trending = "//p[@class='MuiTypography-root MuiTypography-body1 css-8s8b0g']";
	public void validateSeachFunctionality(String searchData, String ClickedBy,String Title) throws InterruptedException {
		getDriver().findElement(By.xpath(searchBox)).click();
		/*
		 * //Action.explicitWait(getDriver(), RecentSearch, null); Thread.sleep(5000);
		 * 
		 * WebElement RecentSearch = getDriver().findElement(By.xpath(recentSearch));
		 * String recentSerchTxt = RecentSearch.getText();
		 * Assert.assertEquals(recentSerchTxt, "You Recent Searches");
		 */
		
		WebElement Trending = getDriver().findElement(By.xpath(trending));
		String trendingTxt = Trending.getText();
		Assert.assertEquals(trendingTxt, "Trending");
		
		getDriver().findElement(By.xpath(searchBox)).sendKeys(searchData);
		if(ClickedBy.equalsIgnoreCase("Mouse")) {
		getDriver().findElement(By.xpath(clickButton)).click();	
		}
		else if(ClickedBy.equalsIgnoreCase("Keyboard")) {
			getDriver().findElement(By.xpath(searchBox)).sendKeys(Keys.ENTER);
		}
		
		
		
		Action.explicitWaitbyTitle(getDriver(), "Search Page", Duration.ofSeconds(10));
		String title1 = getDriver().getTitle();
		Assert.assertEquals(title1, "Search Page"); 
		
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), Title, Duration.ofSeconds(5));
		
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), Title, Duration.ofSeconds(5));
		
	}
	//String welcomeTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-k1juyd'])[1]";
	public void UserButtonFunctionality(String Title) {
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		String welcomeText = getDriver().findElement(By.xpath(welcomeTxt1)).getText();
		Assert.assertEquals(welcomeText, "Welcome");
		String AccessMsg = getDriver().findElement(By.xpath(accessTxt)).getText();
		Assert.assertEquals(AccessMsg, "To access account and manage orders");
		String login_signupMsg =getDriver().findElement(By.xpath(loginTxt)).getText();
		Assert.assertEquals(login_signupMsg, "LOGIN/SIGNUP");
		getDriver().findElement(By.xpath(loginTxt)).click();
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		String loginTitle = getDriver().getTitle();
		Assert.assertEquals(loginTitle, "Login");
		
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), Title, Duration.ofSeconds(5));
	}
	
	public void logoFunctionality(String title) {
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-86v618']//img[@alt='logo']")).click();
		Action.explicitWaitbyTitle(getDriver(), "dot beauty", Duration.ofSeconds(10));
		String recipeTitle = getDriver().getTitle();
		Assert.assertEquals(recipeTitle, "dot beauty"); 
		Log.info("LogoFunctionalityVerification Works perfectly");
		
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), title, Duration.ofSeconds(10));
	}
	
	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}
	
	
}
