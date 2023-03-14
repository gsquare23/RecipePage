package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class LoginPage extends BaseClass {

	LoginPage loginPage;
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
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "checkedB")
	WebElement rememberMeCheckboxBtn;

	@FindBy(linkText = "Forgot password ?")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//button[normalize-space()='LOG IN']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 css-lmqqn1']")
	WebElement incrtMsg;
	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 css-1svf6t0']")
	WebElement welcomeMsg;
	
	@FindBy(name = "checkedB")
	WebElement checkbox;
	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 css-od1sh9']")
	WebElement welcomeDescription;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	WebElement catchaChbx;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void validateTitle() {
	String title =	getDriver().getTitle();
		Assert.assertEquals(title, "Login");
	}
	
	
	public boolean login(String uname, String passd) {
		Action.type(username,uname);
		Action.type(password, passd);
		Action.click(getDriver(), loginBtn);
		boolean result = Action.isDisplayed(getDriver(), incrtMsg);
		Assert.assertTrue(result);
		return result;
		
	}
	public void validateWelcomeMsg() {
		boolean msgTxt  = Action.isDisplayed(getDriver(), welcomeMsg);
		Assert.assertTrue(msgTxt);
	}
	
	public void verifyingCheckbox() {
		Action.click(getDriver(), checkbox);
		boolean result2 =Action.isSelected(getDriver(), checkbox);
		System.out.println(result2);
	}
	public void validatetext () {
		Log.info("Comparing the Welcome Text on Login Page");
		String actualtxt = getDriver().findElement(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-od1sh9']")).getText();
		Assert.assertEquals(actualtxt, "Please enter your account details below");
		Log.info("Welcome text successfully found");
	}
	
	public HomePage loginSetup(String Username, String Password) throws InterruptedException {
		// Verifying the WelcomeMessage
		String actualWelcomeMsg = getDriver().findElement(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-1svf6t0']")).getText();
		if (actualWelcomeMsg.equalsIgnoreCase("Welcome")) {
			Log.info("Login with username and password ");
			Action.type(username, Username);
			Action.type(password, Password);
			Thread.sleep(15000);
			Action.click(getDriver(), loginBtn);
			Action.explicitWaitbyTitle(getDriver(), "Sangria Base UI", Duration.ofSeconds(10));
			String titleNew = getDriver().getTitle();
			System.out.println(titleNew);
			Assert.assertEquals(titleNew, "Sangria Base UI");
		}
		return new HomePage();
	}
	
	public HomePage loginSetup1(String Username, String Password) throws InterruptedException {
		getDriver().findElement(By.xpath("(//img[@alt ='logo'])[4]")).click();
		getDriver().findElement(By.xpath(loginTxt)).click();
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		String loginTitle = getDriver().getTitle();
		Assert.assertEquals(loginTitle, "Login");
			Log.info("Login with username and password ");
			Action.type(username, Username);
			Action.type(password, Password);
			Thread.sleep(10000);
			Action.click(getDriver(), loginBtn);
			Action.explicitWaitbyTitle(getDriver(), "Sangria Base UI", Duration.ofSeconds(10));
			String titleNew = getDriver().getTitle();
			System.out.println(titleNew);
			Assert.assertEquals(titleNew, "Sangria Base UI");
		
		return new HomePage();
	}
	String bookCount = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-5cgcae'][2]";
	String bookMarkIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[2]";
	String likeIcon1 = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";
	String likeCount = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-5cgcae'][1]";
	public void likebutton() {
		
		//Log.startTestCase("likebutton");
		WebElement LikeIcon = getDriver().findElement(By.xpath(likeIcon1));
		String countTxt =	getDriver().findElement(By.xpath(likeCount)).getText();
		int count=Integer.parseInt(countTxt);
		System.out.println(count);
		Action.click(getDriver(), LikeIcon);
		/*
		 * getDriver().navigate().refresh(); Action.explicitWait(getDriver(), LikeIcon,
		 * Duration.ofSeconds(5));
		 */
		String countTxt2 =	getDriver().findElement(By.xpath(likeCount)).getText();
		int newCount = Integer.parseInt(countTxt2);
		System.out.println(newCount);
		Assert.assertEquals(count+1, newCount);
		
		Log.info("bookmark functionality ");
		WebElement BookMarkIcon = getDriver().findElement(By.xpath(bookMarkIcon));
		String countTxt3 =	getDriver().findElement(By.xpath(bookCount)).getText();
		int count1=Integer.parseInt(countTxt3);
		System.out.println(count1);
		Action.click(getDriver(), BookMarkIcon);
		//getDriver().navigate().refresh();
		String countTxt4 =	getDriver().findElement(By.xpath(bookCount)).getText();
		int newCount1 = Integer.parseInt(countTxt4);
		System.out.println(newCount1);
		Assert.assertEquals(count1+1, newCount1);
		
		//Log.endTestCase("likebutton");
		
	}
	
	String recentSearchText = "//p[@class='MuiTypography-root MuiTypography-body1 css-2ediy8']";
	
	String recentSearch1 = "//p[@class='MuiTypography-root MuiTypography-body1 css-64acg5']";
	String trending = "//p[@class='MuiTypography-root MuiTypography-body1 css-8s8b0g']";
	public void validateSeachFunctionality(String searchData, String ClickedBy,String title) throws InterruptedException {
		
		getDriver().findElement(By.xpath(searchBox)).click();
		
		  WebElement RecentSearch = getDriver().findElement(By.xpath(recentSearch1));
		  String recentSerchTxt = RecentSearch.getText();
		  Assert.assertEquals(recentSerchTxt, "You Recent Searches", "Your Recent search are not present");
		//  System.out.println("recent searches1");
		List<WebElement> element = getDriver().findElements(By.xpath(recentSearchText));
		if(element.size()==4) {
			Assert.assertTrue(true, "Your Recent Searches are less than 4");
		}
		
		WebElement Trending = getDriver().findElement(By.xpath(trending));
		String trendingTxt = Trending.getText();
		Assert.assertEquals(trendingTxt, "Trending", "Trending keyword is not Present ");
		
		getDriver().findElement(By.xpath(searchBox)).sendKeys(searchData);
		if(ClickedBy == "Mouse") {
		getDriver().findElement(By.xpath(clickButton)).click();	
		}
		else if(ClickedBy == "Keyboard") {
			getDriver().findElement(By.xpath(searchBox)).sendKeys(Keys.ENTER);
		}
		Action.explicitWaitbyTitle(getDriver(), "Search Page", Duration.ofSeconds(10));
		String title1 = getDriver().getTitle();
		Assert.assertEquals(title1, "Search Page", "SearchPage Not available");
		
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), title, Duration.ofSeconds(5));
		
		//Log.endTestCase("validateSeachFunctionality");
	}
	
	public void UserButtonFunctionality(String title) {
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		
		Action.explicitWaitbyTitle(getDriver(), "My Account", Duration.ofSeconds(10));
		String loginTitle = getDriver().getTitle();
		Assert.assertEquals(loginTitle, "My Account");
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), title, Duration.ofSeconds(5));
	}
	
	public void logoFunctionality(String title) {
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-86v618']//img[@alt='logo']")).click();
		Action.explicitWaitbyTitle(getDriver(), "Sangria Base UI", Duration.ofSeconds(10));
		String recipeTitle = getDriver().getTitle();
		Assert.assertEquals(recipeTitle, "Sangria Base UI"); 
		getDriver().navigate().back();
		Action.explicitWaitbyTitle(getDriver(), title, Duration.ofSeconds(5));
		Log.info("LogoFunctionalityVerification Works perfectly");
	}
	
	
	//public void login
}
