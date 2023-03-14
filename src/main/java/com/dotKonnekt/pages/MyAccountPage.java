package com.dotKonnekt.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class MyAccountPage extends BaseClass{

	

	public MyAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	SoftAssert softAssert = new SoftAssert();
	
	String welcomeTxt1 = "(//p[@class='MuiTypography-root MuiTypography-body1 css-k1juyd'])[1]";
	String accessTxt ="(//p[@class='MuiTypography-root MuiTypography-body1 css-1yt7wtf'])[1]";
	String loginTxt = "(//button[normalize-space()='LOGIN/SIGNUP'])[1]";
	String loginPageTxt = "//input[@placeholder='Email']";
	String profileImage = "//img[@alt='Profile Image']";
	String helloText = "//div[@class='MuiBox-root css-13wixn3']";
	String user = "//p[@class='MuiTypography-root MuiTypography-body1 css-nf0076']";
	String editProfile = "//div[@class='MuiBox-root css-1uq2ht']/button[1]";
	String Signout = "//div[@class='MuiBox-root css-1uq2ht']/button[2]";
	String bookMark  = "//div[@class='MuiBox-root css-4qp2c5']/div/p[1]";
	String haveAnythingMsg = "//div[@class='MuiBox-root css-1l3hrxc']";
	String viewAll_bookmark = "//div[@class='MuiBox-root css-4qp2c5']/div/p[2]";
	//String bookMark_haveanything = "(//div[@class='MuiBox-root css-1l3hrxc'])[1]";
	String wishlist_viewAll = "//div[@class='MuiBox-root css-olbtjp']/div/p[2]";
	String wishlist = "//div[@class='MuiBox-root css-olbtjp']/div/p[1]";
	String wishlist_haveanything = "(//div[@class='MuiBox-root css-1l3hrxc'])[2]";
	String address = "//div[@class='MuiBox-root css-1dj18ac']/div/p[1]";
	String editButton = "//div[@class='MuiBox-root css-1dj18ac']/div/p[2]";
	String orders = "//div[@class='MuiBox-root css-vyhwca']/div/p[1]";
	
	
	public void profileIcon_LoggedIcon(String Title) throws InterruptedException {
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		Log.info("Profile Icon is present");
		String welcomeText = getDriver().findElement(By.xpath(welcomeTxt1)).getText();
		Log.info("Welcome Message is present");
		Assert.assertEquals(welcomeText, "Welcome");
		String AccessMsg = getDriver().findElement(By.xpath(accessTxt)).getText();
		Assert.assertEquals(AccessMsg, "To access account and manage orders");
		Log.info("'To access account and manage' orders Message is present");
		String login_signupMsg =getDriver().findElement(By.xpath(loginTxt)).getText();
		Assert.assertEquals(login_signupMsg, "LOGIN/SIGNUP");
		Log.info("Login/Signup button are present");
		getDriver().findElement(By.xpath(loginTxt)).click();
		Log.info("Successfully Clicked on Login/Signup button");
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		String loginTitle = getDriver().getTitle();
		Assert.assertEquals(loginTitle, "Login");
		Log.info("Sucessfully land on Login Page");
		getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
		Log.info("Sucessfully Enter the User name ");
		getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		Log.info("Sucessfully Enter the Password");
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
		Log.info("Successfully Clicked on Login/Signup button");
		Action.explicitWaitbyTitle(getDriver(), Title, Duration.ofSeconds(10));
		Log.info("Successfully land on Home Page");
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		Log.info("Clicked on the profile Icon");
		Action.explicitWaitbyTitle(getDriver(), "My Account", Duration.ofSeconds(10));
		Log.info("Successfully land on the My Account Page");
			
	}
	
	public void AccountPageElements() {
		Log.info("Account Page Elements Start");
		Assert.assertTrue(getDriver().findElement(By.xpath(profileImage)).isDisplayed(), "Profile image is not present");
		Log.info("Profile image is present");
		//String hello = getDriver().findElement(By.xpath(helloText)).getText();
		//Assert.assertEquals(getDriver().findElement(By.xpath(helloText)).getText(), "Hello\r\n"+ "Olivia!", "Hello text is not present");
		//Log.info("Hello Text is successfully Verified");
		
		Assert.assertEquals(getDriver().findElement(By.xpath(user)).getText(), "Olivia!", "User name is not present");
		Log.info("User name is successfully Verified");
		
		Assert.assertEquals(getDriver().findElement(By.xpath(editProfile)).getText(), "Edit Profile", "Edit Profile is not present");
		Assert.assertTrue(getDriver().findElement(By.xpath(editProfile)).isEnabled());
		Log.info("Edit Profile  is successfully Verified");
		
		Assert.assertEquals(getDriver().findElement(By.xpath(Signout)).getText(), "Sign Out", "Sign Out icon is not present");
		Assert.assertTrue(getDriver().findElement(By.xpath(Signout)).isEnabled());
		Log.info("Sign Out icon is successfully Verified");
		
		Assert.assertEquals(getDriver().findElement(By.xpath(bookMark)).getText(), "Bookmarks", "BookMark Text is not present");
		Log.info("Bookmarks text is successfully Verified");
		if(getDriver().findElement(By.xpath(haveAnythingMsg)).getText().equals("You don't have anything in your Bookmarks yet...")) {
			Assert.assertTrue(getDriver().findElement(By.xpath(viewAll_bookmark)).isEnabled(), " view All is clickable when no items sre present in this sections");	
		}
		
		Assert.assertEquals(getDriver().findElement(By.xpath(wishlist)).getText(), "Wishlist", "Wishlist Text is not present");
		Log.info("Wishlist text is successfully Verified");
		if(getDriver().findElement(By.xpath(wishlist_haveanything)).getText().equals("You don't have anything in your Bookmarks yet...")) {
			Assert.assertTrue(!getDriver().findElement(By.xpath(wishlist_viewAll)).isEnabled(), " view All is clickable when no items are present in this sections");	
		}
		else {
			Assert.assertTrue(getDriver().findElement(By.xpath(wishlist_viewAll)).isEnabled(), " view All is clickable when no items are present in this sections");	
			String wishlistElements = "(//div[@class='MuiBox-root css-d8xk2t'])";
			List<WebElement> WishlistElements = getDriver().findElements(By.xpath(wishlistElements));
			System.out.println(WishlistElements.size());
			Log.info("Wishlist Elements are present in Wishlist Sections");
		}

		Assert.assertEquals(getDriver().findElement(By.xpath(address)).getText(), "Addresses", "Addresses is not present");
		Log.info("addresses text is successfully Verified");
		Assert.assertEquals(getDriver().findElement(By.xpath(editButton)).getText(), "Edit", "Edit is not present");
		Assert.assertTrue(getDriver().findElement(By.xpath(editButton)).isEnabled());
		Log.info("Edit button is successfully Verified");
		
		Assert.assertEquals(getDriver().findElement(By.xpath(orders)).getText(), "Orders", "Orders text is not present");
		Log.info("Orders text is successfully Verified");
	}
	
	public void SignoutFunctionality() {
		Log.info("Profile Icon is present");
		WebElement signout = getDriver().findElement(By.xpath(Signout));
		Action.click(getDriver(), signout);
		Log.info("Successfully clicked on the Sign out Icon");
		Assert.assertEquals(getDriver().getTitle(), "Login", "SignOut is not successfully happen");
		Log.info("Successfully perform the signout Functionality");
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		String welcomeText = getDriver().findElement(By.xpath(welcomeTxt1)).getText();
		Log.info("Welcome Message is present");
		Assert.assertEquals(welcomeText, "Welcome");
		Log.info("User is logged out from the page");
	}
	String chevronRight = "//*[local-name()='svg' and @data-testid='ChevronRightIcon']";
	public void BookmarkFunctionality() throws InterruptedException {
		Assert.assertEquals(getDriver().findElement(By.xpath(bookMark)).getText(), "Bookmarks", "BookMark Text is not present");
		Thread.sleep(3000);
		Log.info("Bookmarks text is successfully Verified");
		if(getDriver().findElement(By.xpath(haveAnythingMsg)).getText().equals("You don't have anything in your Bookmarks yet...")) {
			String BookMarkElements = "(//div[@class='MuiBox-root css-129qwum'])";
			List<WebElement> BookMarkElement = getDriver().findElements(By.xpath(BookMarkElements));
			System.out.println(BookMarkElement.size());
			System.out.println("fghjkl");
			if(BookMarkElement.size()==0) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else {
			String BookMarkElements = "(//div[@class='MuiBox-root css-129qwum'])";
			List<WebElement> Bookmark = getDriver().findElements(By.xpath(BookMarkElements));
			System.out.println(Bookmark.size());
			if(Bookmark.size()>0) {
				WebElement viewAll_bm = getDriver().findElement(By.xpath(viewAll_bookmark));
				Action.click(getDriver(),viewAll_bm );
				Log.info("Successfully clicked on the Book Mark View All Button");
				Assert.assertTrue(getDriver().findElement(By.xpath(chevronRight)).isDisplayed(), " Chevron right icon of BookMarks slide is not visible");
				Log.info("Chevron right icon of BookMarks slide is present");
				String bm_Text = "//p[@class='MuiTypography-root MuiTypography-body1 css-1dyjmp7']";
				Assert.assertEquals(getDriver().findElement(By.xpath(bm_Text)).getText(), "Bookmarks", "Bookmarks heading is not present in the right side of pane");
				Log.info("BookMark text is present in the view All functinlaity");
				String viewAll_bookmarkElements = "//div[@class='MuiBox-root css-1f3x5w2']";
				List<WebElement> ViewAll_bookmarkElements = getDriver().findElements(By.xpath(viewAll_bookmarkElements));
				if(ViewAll_bookmarkElements.size()==Bookmark.size()) {
					Assert.assertTrue(true);
					Log.info("Successfully verified the bookmark elements");
				}
				else {
					Assert.assertTrue(false, "Elements of BookMarks are not same");
				}
				
				String BookMarkIcon = "//*[local-name()='svg' and @data-testid='BookmarkIcon']";
				List<WebElement> BookMarkIcons = getDriver().findElements(By.xpath(BookMarkIcon));
				System.out.println(BookMarkIcons.size());
				if(BookMarkIcons.size()==(Bookmark.size())*2) {
					Assert.assertTrue(true);
					Log.info("Successfully verified the bookmark icon of  elements");
				}
				else {
					Assert.assertTrue(false, "No. of Icon of BookMarks are not same");
				}
			}
		}
	}
	
	
	public void WishlistFunctionality() throws InterruptedException {
		Assert.assertEquals(getDriver().findElement(By.xpath(wishlist)).getText(), "Wishlist", "Wishlist Text is not present");
		Thread.sleep(3000);
		Log.info("Wishlist text is successfully Verified");
		if(getDriver().findElement(By.xpath(wishlist_haveanything)).getText().equals("You don't have anything in your Wishlist yet...")) {
			String wishlistElements = "(//div[@class='MuiBox-root css-d8xk2t'])";
			List<WebElement> WishlistElements = getDriver().findElements(By.xpath(wishlistElements));
			System.out.println(WishlistElements.size());
			Log.info("Wishlist Elements are present in Wishlist Sections");
			if(WishlistElements.size()==0) {
				Assert.assertTrue(true);
				Log.info("Right now no products are available in wishlist section");
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else {
			String wishlistElements = "(//div[@class='MuiBox-root css-d8xk2t'])";
			List<WebElement> WishlistElements = getDriver().findElements(By.xpath(wishlistElements));
			System.out.println(WishlistElements.size());
			if(WishlistElements.size()>0) {
				WebElement viewAll_wish = getDriver().findElement(By.xpath(wishlist_viewAll));
				Action.click(getDriver(),viewAll_wish );
				Log.info("Successfully clicked on the WishList View All Button");
				Assert.assertTrue(getDriver().findElement(By.xpath(chevronRight)).isDisplayed(), " Chevron right icon of Wishlist slide is not visible");
				Log.info("Chevron right icon of Wishlist slide is present");
				String wish_Text = "//p[@class='MuiTypography-root MuiTypography-body1 css-1dyjmp7']";
				Assert.assertEquals(getDriver().findElement(By.xpath(wish_Text)).getText(), "Wishlists", "Wishlists heading is not present in the right side of pane");
				Log.info("Wishlists text is present in the view All functinlaity");
				String viewAll_wishlistElements = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-z5uvai']";
				List<WebElement> viewAll_wishlistElement = getDriver().findElements(By.xpath(viewAll_wishlistElements));
				System.out.println(viewAll_wishlistElement.size());
				if(viewAll_wishlistElement.size()==WishlistElements.size()) {
					Assert.assertTrue(true);
					Log.info("Successfully verified the Wishlist elements");
				}
				else {
					Assert.assertTrue(false, "Elements of Wishlist are not same");
				}
				
				String WishlistIcon = "//*[local-name()='svg' and @data-testid='FavoriteIcon']";
				List<WebElement> WishlistsIcons = getDriver().findElements(By.xpath(WishlistIcon));
				if(WishlistsIcons.size()==(WishlistElements.size())*2) {
					Assert.assertTrue(true);
					Log.info("Successfully verified the wishlist icon of  elements");
				}
				else {
					Assert.assertTrue(false, "No. of Icon of wishlist are not same");
				}
			}
		}
	}
	String orderStatus = "(//div[@class='MuiBox-root css-hxbevj'])/div";
	String orderId = "(//div[@class='MuiBox-root css-1wflp0t'])/div[3]/div[1]/p[1]";
	String totalPrice = "(//div[@class='MuiBox-root css-1wflp0t'])/div[2]/p[1]";
	String orderedOn = "(//div[@class='MuiBox-root css-1wflp0t'])/div[1]/p[1]";
	String orderNo =  "//div[@class='MuiBox-root css-1r9o0lz']/div";
	String ordersDetails = "//div[@class='MuiBox-root css-1wflp0t']";
	String ordersImageSections = "//div[@class='MuiBox-root css-1del6zu']";
	public void orderElements() throws InterruptedException {
		WebElement order = getDriver().findElement(By.xpath(orders));
		softAssert.assertEquals(order.getText(), "Orders", "Orders text is not present");
		Log.info("Orders text is successfully Verified");
		Thread.sleep(2000);
		List<WebElement> OrderCount = getDriver().findElements(By.xpath(orderNo));
		System.out.println(OrderCount.size()+ " are the order presenet in the orders sections ");
		
		
		List<WebElement> OrdersDetails = getDriver().findElements(By.xpath(ordersDetails));
		softAssert.assertEquals(OrderCount.size(), OrdersDetails.size());
		Log.info("OrderDetails are successfully verified");
		for (WebElement x : OrdersDetails) {
			String elementInOrdersOnSection = "//div[@class='MuiBox-root css-1wflp0t']/div";
			List<WebElement> ElementinOrdersOnSection = getDriver().findElements(By.xpath(elementInOrdersOnSection));
			softAssert.assertEquals(ElementinOrdersOnSection.size(), OrderCount.size()*4);
			Log.info("All 4 Ordered On, Total Price, OrderId & Status text are present");
		}
		
		List<WebElement> OrdersImageSections = getDriver().findElements(By.xpath(ordersImageSections));
		softAssert.assertEquals(OrderCount.size(), OrdersImageSections.size());
		Log.info("OrdersImageSections are successfully verified");
		
		List<WebElement> OrderedOn = getDriver().findElements(By.xpath(orderedOn));
		softAssert.assertEquals(OrderCount.size(), OrderedOn.size());
		for (WebElement j : OrderedOn) {
			softAssert.assertEquals(j.getText(), "Ordered on");
		}
		Log.info("OrderedOn are successfully verified");
		
		List<WebElement> TotalPrice = getDriver().findElements(By.xpath(totalPrice));
		softAssert.assertEquals(OrderCount.size(), TotalPrice.size());
		for (WebElement i : TotalPrice) {
			softAssert.assertEquals(i.getText(), "Total Price");
		}
		Log.info("Total Price are successfully verified");
		
		List<WebElement> OrderId = getDriver().findElements(By.xpath(orderId));
		softAssert.assertEquals(OrderCount.size(), OrderId.size());
		for (WebElement i : OrderId) {
			softAssert.assertEquals(i.getText(), "OrderId");
		}
		Log.info("OrderId are successfully verified");
		
		List<WebElement> OrderStatus = getDriver().findElements(By.xpath(orderStatus));
		softAssert.assertEquals(OrderCount.size(), OrderStatus.size());
		int count = 0;
		int count1 = 0;
		for (WebElement i : OrderStatus) {
	
			if(i.getText().equals("Refunded")) {
				count++;
				/*
				 * String text1 = "(//div[@class='MuiBox-root css-ymwa6a'])/p[3]"; WebElement
				 * Text1 = getDriver().findElement(By.xpath(text1));
				 * System.out.println("sdsfgthyjk"); Assert.assertEquals(Text.getText(),
				 * "• Order is Cancelled");
				 */
				
			}
			if(i.getText().equals("Payment Paid")) {
				count1++;
			}
		}
		System.out.println(count + " are in Refunded status");
		System.out.println(count1 + " are in Payment Paid Status");
		Log.info("Order Status are successfully verified");
		
		
		  String text2 = "(//div[@class='MuiBox-root css-ymwa6a'])/p[3]"; 
		  List<WebElement> Text2 = getDriver().findElements(By.xpath(text2));
		  softAssert.assertEquals(Text2.size(), OrderCount.size(), "No. of status of Transit and cancelled are not correct");
		  Log.info("No. of status of Transit and cancelled are correct");
		  int count3= 0;
		  int count4=0;
		  for (WebElement i : Text2) {
			if(i.getText().equals("• Order is Cancelled")) {
				count3++;
			}
			if(i.getText().equals("• Order in Transit")) {
				count4++;
			}
		}
		  System.out.println(count3 + " are in  Order is Cancelled");
			System.out.println(count4 + " are in  Order in Transit");
			softAssert.assertEquals(count, count3);
			Log.info("Order is cancelled & Refunded status are same");
			softAssert.assertEquals(count, count3);
			Log.info("Order in transit & Payment Paid status are same");
		  
		String downloadInvoice = "(//button[@aria-label='download invoice'])";
		List<WebElement> DownloadInvoice = getDriver().findElements(By.xpath(downloadInvoice));
		softAssert.assertEquals(DownloadInvoice.size(),OrderCount.size(), "Download icon are not present perfectly");
		Log.info("Download icon are present as order no. in orders section");
		
		String orderName = "//div[@class='MuiBox-root css-ymwa6a']/p[1]";
		List<WebElement> OrderNames = getDriver().findElements(By.xpath(orderName));
		for (WebElement i : OrderNames) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "Order name is not present");
			}
			else
				System.out.println(i.getText());
		}
		softAssert.assertEquals(OrderNames.size(),OrderCount.size(), "Order Names are not present perfectly");
		Log.info("Orders name  are present as order no. in orders section");
		
		
		String orderQty = "//div[@class='MuiBox-root css-ymwa6a']/p[2]";
		List<WebElement> OrderQtys = getDriver().findElements(By.xpath(orderQty));
		for (WebElement i : OrderQtys) {
			if(i.getText().equals(null)) {
				
				softAssert.assertTrue(false, "Order Quantity is not present");
			}
			else
				System.out.println(i.getText());
			
		}
		softAssert.assertEquals(OrderQtys.size(),OrderCount.size(), "Order Quantity are not present perfectly");
		Log.info("Orders Quantity  are present as order no. in orders section");
		
		String orderPrice = "//div[@class='MuiBox-root css-1u2espl']/p[1]";
		List<WebElement> OrderPrices = getDriver().findElements(By.xpath(orderPrice));
		for (WebElement i : OrderPrices) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "Order Price is not present");
			}
			else
				System.out.println(i.getText());
		}
		softAssert.assertEquals(OrderQtys.size(),OrderCount.size(), "Order Price are not present perfectly");
		Log.info("Orders Price  are present as order no. in orders section");
		
		
		String orderStatus = "//div[@class='MuiBox-root css-ymwa6a']/p[3]";
		List<WebElement> OrderStatus1 = getDriver().findElements(By.xpath(orderStatus));
		for (WebElement i : OrderStatus1) {
			if(i.getText().equals("• Order in Transit")) {
				String cancelItem  = "//div[@class='MuiBox-root css-5dzd79']/p";
				WebElement CancelItem = getDriver().findElement(By.xpath(cancelItem));
				softAssert.assertTrue(CancelItem.isDisplayed(), "Cancel Item button is not present");
				System.out.println("Cancel Item Button is present when Order is in transit status");
			}
			
			else if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "Order Status is not present");
			}
			else
				System.out.println(i.getText());
		}
		softAssert.assertEquals(OrderStatus1 .size(),OrderCount.size(), "Order Price are not present perfectly");
		Log.info("Orders Status  are present as order no. in orders section");
		
		softAssert.assertAll();
		
	}
	
}