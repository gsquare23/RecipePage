 package com.dotKonnekt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotKonnekt.base.BaseClass;


public class HomePage extends BaseClass{

	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	String skin = "//button[normalize-space()='Skin']";
	public void clickOnCategory() {
		getDriver().findElement(By.xpath(skin)).click();
	}
	
	
	
}
