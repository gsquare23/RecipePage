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

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class EB_selectContentPage extends BaseClass{

	

	public EB_selectContentPage() {
		PageFactory.initElements(getDriver(), this);
	}

	String loginbutton = "//span[@class='MuiButton-label']";
	
	
	String eb_button = "//span[normalize-space()='Experience Builder']";
	  
	 
	public void EB_login() throws InterruptedException {
		Log.info("Login of Expeience Builder Started Successfully");
		System.out.println("fdghjkl;'");
		//Thread.sleep(5000);
		WebElement loginBtn = getDriver().findElement(By.xpath(loginbutton));
		Action.click(getDriver(), loginBtn);
		Thread.sleep(2000);
		Action.explicitWaitbyTitle(getDriver(),"Sangria Command Center" ,Duration.ofSeconds(10));
		WebElement eb_btn = getDriver().findElement(By.xpath(eb_button));
		Action.click(getDriver(), eb_btn);
		Thread.sleep(2000);
		Log.info("Successfully Clicked on the Experience Builder button");
		
	}
	String noResultTxt = "//div[@class='MuiBox-root jss129']/p";
	String searchIcon = "//button[@aria-label='Search']//span[@class='MuiIconButton-label']";
	String searchBar = "//input[@placeholder='Search content, product or community']";
	public void EB_UniversalSearch(String searchTxt, String ClickType) {
		
		System.out.println(getDriver().findElement(By.xpath("//div[@class='MuiBox-root jss36 jss12']/h6")).getText());
		WebElement SearchBar = getDriver().findElement(By.xpath(searchBar));
		Action.click(getDriver(), SearchBar);
		Action.type(SearchBar, searchTxt);
		Log.info("Successfully Entered the value in the search bar");
		if(ClickType.equalsIgnoreCase("mouse")) {
			WebElement  SearchIcon = getDriver().findElement(By.xpath(searchIcon));
			Action.click(getDriver(), SearchIcon);
			Log.info("Successfully Clicked the Search icon");
		}
		else if(ClickType.equalsIgnoreCase("keyboard")){
			getDriver().findElement(By.xpath(searchIcon)).sendKeys(Keys.ENTER);
			Log.info("Successfully clicked the Enter to key to search the keyword");
		}
		
		/*
		 * String fhjk=
		 * "//span[@class='MuiButtonBase-root MuiIconButton-root jss104 MuiSwitch-switchBase jss118 MuiSwitch-colorSecondary']//span[@class='MuiIconButton-label']"
		 * ; WebElement fgh = getDriver().findElement(By.xpath(fhjk));
		 * Action.click(getDriver(), fgh);
		 * Log.info("Successfully tested the No Result Found Scenario");
		 */
		/*
		 * WebElement iframe =
		 * getDriver().findElement(By.xpath("//iframe[@title='sitePreview']"));
		 * getDriver().switchTo().frame(iframe);
		 */
		
		
		WebElement NoResultTxt = getDriver().findElement(By.xpath(noResultTxt));
		System.out.println(NoResultTxt.getText());
		Assert.assertEquals(NoResultTxt.getText(), "No results found", "No Result found message is not visible");
		Log.info("Successfully tested the No Result Found Scenario");
	}
	
	public void NoResultFound() throws InterruptedException {
		System.out.println("dfghjk");
		Thread.sleep(1000);
		WebElement NoResultTxt = getDriver().findElement(By.xpath(noResultTxt));
		Assert.assertEquals(NoResultTxt.getText(), "No results found", "No Result found message is not visible");
		Log.info("Successfully tested the No Result Found Scenario");
	}
	
	
}