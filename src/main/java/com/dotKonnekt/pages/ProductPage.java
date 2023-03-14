package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;


public class ProductPage extends BaseClass {

	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}

	String productName = "//div[@class='MuiTypography-root MuiTypography-body1 css-122og3s']";
	String Bigimage = "(//div[@class='magnifier_container']//img)[2]";
	String smallImage = "(//div[@class='css-j6afl0']//img)[2]";

	// SoftAssert softAssert = new SoftAssert();
	public void productDetailVerification() throws InterruptedException {
		WebElement smallProductImage = getDriver().findElement(By.xpath(smallImage));
		String value2 = smallProductImage.getAttribute("alt");
		System.out.println(value2);

		WebElement ProductImages = getDriver().findElement(By.xpath(Bigimage));
		String value1 = ProductImages.getAttribute("alt");
		System.out.println(value1);

		if (value1.equals(value2)) {
			boolean result = Action.isDisplayed(getDriver(), ProductImages);
			if (result) {
				Action.mouseOverElement(getDriver(), ProductImages);
				Thread.sleep(2000);
			} else {
				Assert.assertTrue(result, "Product is not visible or present");
			}
		} else {
			Assert.assertTrue(false, "The zommed image and side image are not same");
		}

		String ProductName = getDriver().findElement(By.xpath(productName)).getText();
		System.out.println(ProductName);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		for (int i = 0; i < ProductName.length(); i++) {
			char ch = ProductName.charAt(i);
			String s = String.valueOf(new char[] { ch });
			// System.out.println(s);
			if (specialCharactersString.contains(Character.toString(ch))) {
				System.out.println(s + " contains special character");

				if (ProductName.contains(s)) {
					String splits1[] = ProductName.split(s);
					System.out.println(splits1[0]);
					String actualName = splits1[0];
					if (value1.contains(actualName)) {
						System.out.println("Product name verified");
					} else {
						Assert.assertTrue(false, "Product Name are not correct");
					}
				}
				break;
			}
		}
	}

	String cartButton = "//div[@class='MuiBox-root css-gw6fln']/button[1]";
	String stockCount = "//input[@class='MuiInputBase-input css-mnn31']";

	public void availabiltyStock() {

		Log.info("AddToCart of Product Page verification");
		WebElement addToCartIcon = getDriver().findElement(By.xpath(cartButton));
		boolean result = Action.isDisplayed(getDriver(), addToCartIcon);
		String elementTxt = addToCartIcon.getText();
		if ((elementTxt.equalsIgnoreCase("ADD TO CART") && result)
				|| (elementTxt.equalsIgnoreCase("OUT OF STOCK") && result)) {
		} else {

			System.out.println("Cart Icon is not present");
			Assert.assertTrue(result, "Cart Icon is not present");
		}

		WebElement StockCount = getDriver().findElement(By.xpath(stockCount));
		Assert.assertEquals(StockCount.getAttribute("value"), "1", "Count is not set to 1");

	}

	/*
	 * String count = "//input[@class= 'MuiInputBase-input css-mnn31']"; public void
	 * defaultCount () {
	 * 
	 * Log.info("Verifying the default qunatity present for a product");
	 * 
	 * WebElement Count = getDriver().findElement(By.xpath(count)); String
	 * value=Count.getAttribute("Value"); int i = Integer.parseInt(value);
	 * Assert.assertEquals(i, 1, "value is not set to 1"); }
	 */
	String icon = "(//*[local-name()='svg' and @data-testid='FavoriteBorderOutlinedIcon'])[1]";
	String loginbutton = "//button[normalize-space()='LOG IN']";
	String loginPageTxt = "//input[@name='email']";
	String crossbutton1 = "//*[local-name()='svg' and @data-testid='ClearIcon']";

	public void wishlistIconFunctionalityforNotLoggedIn() {
		WebElement iconFunctionality = getDriver().findElement(By.xpath(icon));
		Action.click(getDriver(), iconFunctionality);
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		// Thread.sleep(5000);
	}

	String wishlistsTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1wrh8ds'])[2]";
	String productnames = "//div[@class='MuiBox-root css-d8xk2t']/p";

	// String iconn = "(//*[local-name()='svg' and
	// @data-testid='FavoriteIcon'])[1]";

	public void wishlistIconFunctionalityForLoggedIn() throws InterruptedException {
		WebElement iconFunctionality = getDriver().findElement(By.xpath(icon));
		Action.click(getDriver(), iconFunctionality);

		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		System.out.println("dfghjk");
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());

		getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
		;
		getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		Thread.sleep(20000);
		getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
		System.out.println("fdghjkcgvhj");
		Thread.sleep(10000);
		JavascriptExecutor j = (JavascriptExecutor) getDriver();
		j.executeScript("window.scrollBy(0,450)");
		// Action.scrollByVisibilityOfElement(getDriver(), iconFunctionality);
		System.out.println("fdghjkcgvhj");
		// getDriver().navigate().refresh();

		WebElement iconFunctionality1 = getDriver().findElement(By.xpath(icon));
		Action.explicitWait(getDriver(), iconFunctionality1, Duration.ofSeconds(5000));
		Action.click(getDriver(), iconFunctionality1);

		/*
		 * Thread.sleep(5000); System.out.println("fdghjkcgvhj");
		 * 
		 * 
		 * WebElement wish = getDriver().findElement(By.xpath(iconn));
		 * Assert.assertTrue(wish.isDisplayed());
		 * 
		 * 
		 * 
		 * Thread.sleep(5000);
		 */
		// getDriver().navigate().refresh();
		// Action.pageLoadTimeOut(getDriver(), 10);
		JavascriptExecutor j1 = (JavascriptExecutor) getDriver();
		j1.executeScript("window.scrollBy(0,50)");
		WebElement productName1 = getDriver().findElement(By.xpath(productName));
		String text = productName1.getText();
		System.out.println(text);
		Log.info("Click on user account button");
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		Action.explicitWaitbyTitle(getDriver(), "My Account", Duration.ofSeconds(10));
		// Assert.assertEquals(getDriver().getTitle(), "My Account");
		System.out.println("dfghgjkl");
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		WebElement wishlistText = getDriver().findElement(By.xpath(wishlistsTxt));
		Action.scrollByVisibilityOfElement(getDriver(), wishlistText);
		System.out.println("dfghgjkl");
		List<WebElement> Wishlists = getDriver().findElements(By.xpath(productnames));
		System.out.println(Wishlists.size());
		boolean flag = false;
		for (WebElement webElement : Wishlists) {
			String name = webElement.getText();
			System.out.println(name);
			String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				// System.out.println("test1");
				String s = String.valueOf(new char[] { ch });
				// System.out.println(s);
				if (specialCharactersString.contains(Character.toString(ch))) {
					System.out.println(s + " contains special character");

					if (name.contains(s)) {
						String splits1[] = name.split(s);
						System.out.println(splits1[0]);
						String actualName = splits1[0];
						if (text.contains(actualName)) {
							System.out.println("Product is present in Wishlist tab ");
							flag = true;
						} else {
							Assert.assertTrue(false, " Not Present in Wishlist Tab ");

						}

					}
					break;

				}
			}
			if (flag) {
				break;
			} 

		}
	}
	
	
	String descrtiption = "//div[@class='MuiTypography-root MuiTypography-body1 css-80jcir']";       
	public void readMoreFunctionality() {
		WebElement readMoreBtn = getDriver()
				.findElement(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-rkcvek']"));
		String text = getDriver()
				.findElement(By.xpath(descrtiption)).getText();
		if (!text.isEmpty()) {
			if (readMoreBtn.isDisplayed()) {
				String text1 = getDriver()
						.findElement(By.xpath(descrtiption))
						.getText();
				// System.out.println(text);
				String smallDes = text1.replace("...", "");
				System.out.println(smallDes);
				Action.click(getDriver(), readMoreBtn);
				if ((readMoreBtn.getText()).equalsIgnoreCase("Read Less")) {
					Assert.assertTrue(true);

					String FullDes = getDriver()
							.findElement(By.xpath(descrtiption))
							.getText();
					System.out.println(FullDes);
					if (FullDes.contains(smallDes)) {
						Assert.assertTrue(true);
					} else
						Assert.assertTrue(false, "Small description are not present in Full description");
				}

				else {
					Assert.assertTrue(false, "After Clicking on Read More button Read Less button is not visible");
				}
			}
		} else {
			System.out.println("Description for the product are not present");
			Assert.assertTrue(false, "Description for the product are not present");
		}
	}
	
	String allproduct = "(//div[@class='swiper-wrapper'])[1]/div/div";
	String carticon = "//*[name()='svg' and @data-testid='ShoppingCartOutlinedIcon']";
	String wishlist = "//*[name()='svg' and @data-testid='FavoriteBorderOutlinedIcon']";
	String quickview = "//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String discountedPrice = "//p[@class='MuiTypography-root MuiTypography-body1 css-1tva794']";
	String actualPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-lgaoco']";
	String productsName = "(//div[@class='swiper-wrapper'])[1]/div/div/div/div[1]";
	String images = "(//div[@class='swiper-wrapper'])[1]/div/div/span/img";
	SoftAssert softAssert = new SoftAssert();

	public void wefoundOtherSections() {
		String productYouMightLikeSection = "//div[normalize-space()='We found other products you might like']";
		WebElement products = getDriver().findElement(By.xpath(productYouMightLikeSection));
		Action.scrollByVisibilityOfElement(getDriver(), products);

		List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
		int n = products1.size();
		System.out.println(n);

		List<WebElement> image = getDriver().findElements(By.xpath(images));
		int x = image.size();
		if (x == n) {
			System.out.println("All images are present");
		} else {
			System.out.println(n - x + " Images are not present ");
			softAssert.assertTrue(false, +n - x + " Images are not present ");
		}

		List<WebElement> productName1 = getDriver().findElements(By.xpath(productsName));
		int j = productName1.size();
		if (j == n) {
			System.out.println("All Products name are present");
		} else {
			System.out.println(n - j + " Products name are not present ");
			softAssert.assertTrue(false, +n - j + " Products name are not present ");
		}

		List<WebElement> productActPrice = getDriver().findElements(By.xpath(actualPrice));
		int z = productActPrice.size();
		if (z == n) {
			System.out.println("All Actual Prices are present");
		} else {
			System.out.println(n - z + " Actual Prices are not present ");
			softAssert.assertTrue(false, n - z + " Actual Prices are not present ");
		}

		List<WebElement> quickviewlink = getDriver().findElements(By.xpath(quickview));
		int i = quickviewlink.size();
		if (i == n) {
			System.out.println("All Quick View links are present");
		} else {
			System.out.println(n - i + " Quick View links are not present ");
			softAssert.assertTrue(false, n - i + " Quick View links are not present ");
		}

		List<WebElement> carticon1 = getDriver().findElements(By.xpath(carticon));
		int c = carticon1.size();
		if (c == n) {
			System.out.println("All carticon are present");
		} else {
			System.out.println(n - c + " carticon are not present ");
			softAssert.assertTrue(false, +n - c + " carticon are not present ");
		}

		List<WebElement> wishlist1 = getDriver().findElements(By.xpath(wishlist));

		int d = carticon1.size();
		if (d == n) {
			System.out.println("All Wishlist icon are present");
		} else {
			System.out.println(n - d + " Wishlist icon are not present ");
			softAssert.assertTrue(false, +n - c + " Wishlist icon are not present ");
		}

		softAssert.assertAll();
	}
	String faq = "//div[normalize-space()='FAQ']";
	String recentQuestions = "(//div[@class='MuiBox-root css-1hm6ahe'])";
	String viewAll= "(//div[@class='MuiBox-root css-1hm6ahe'])/a";
	String Questions = "(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiAccordion-root MuiAccordion-rounded css-iu7gzq'])";
	String  totalQue = "(//div[@class='MuiButtonBase-root MuiAccordionSummary-root css-st02k6'])";
	String queText = "//div[@class='MuiTypography-root MuiTypography-body1 css-zc3yas']";
	String plusIcon = "//*[name()='svg' and @data-testid='AddIcon']";
	String removeIcon = "//*[name()='svg' and @data-testid='RemoveIcon']";
	String ansText = "(//div[@class='MuiTypography-root MuiTypography-body1 css-otef3t'])";
	public void faqSections() throws InterruptedException {
		WebElement faqs = getDriver().findElement(By.xpath(faq));
		Action.scrollByVisibilityOfElement(getDriver(), faqs);
		
		WebElement RecentQuestions = getDriver().findElement(By.xpath(recentQuestions));
		softAssert.assertEquals(RecentQuestions.getText(), "Recent Questions");
		
		WebElement ViewAll = getDriver().findElement(By.xpath(viewAll));
		softAssert.assertEquals(ViewAll.getText(), "View All");
		
		List<WebElement>Question = getDriver().findElements(By.xpath(Questions));
		int size = Question.size();
		
		WebElement PlusIcon = getDriver().findElement(By.xpath(plusIcon));
		WebElement QueText = getDriver().findElement(By.xpath(queText));
		
		
		
		List<WebElement>Que = getDriver().findElements(By.xpath(totalQue));
		int queCount  = Que.size();
		if(size ==  queCount) {
			for(WebElement i : Que) {
				String text = QueText.getText();
				if(text.equals(null)) {
					System.out.println("Question text are not present");
					softAssert.assertTrue(false, " Question text are not present");
				
					if (!PlusIcon.isDisplayed()){
					System.out.println("Plus Icon are not present");
					softAssert.assertTrue(false, " Plus Icon are not present");
					}
				}	
				else {
					Action.click(getDriver(), i);
					System.out.println("Successfully verified the FAQ Sections");
					Thread.sleep(2000);
					WebElement AnsText = getDriver().findElement(By.xpath(ansText));
					WebElement RemoveIcon = getDriver().findElement(By.xpath(removeIcon));
					if(!RemoveIcon.isDisplayed()) {
						System.out.println("Remove Icon are not present");
						softAssert.assertTrue(false, " Remove Icon are not present");
					
					 if(!AnsText.equals(null)) {
						System.out.println("Question text  after click are not present");
						softAssert.assertTrue(false, " Question text after click are not present");
					 }
					} 
				}
			}
		}
		else {
			softAssert.assertTrue(false, " Total faq questions are not present");
		}
		
	}
	String bookMarkicon = "//*[name()='svg' and @data-testid='BookmarkBorderIcon']";
	String mightLikeProductDescription = "(//div[@class='swiper-wrapper'])[2]/div/div/div/div[2]";
	String mightLikeProductNames = "(//div[@class='swiper-wrapper'])[2]/div/div/div/div[1]";
	String mightLikeallproduct = "(//div[@class='swiper-wrapper'])[2]/div/div";
	String mightLikeimages = "(//div[@class='swiper-wrapper'])[2]/div/div/span/img";
	String mightLike1 = "(//div[normalize-space()='We found other content you might like'])";
	public void weFoundOtherContentYouMightLike() {

			WebElement MightLike1 = getDriver().findElement(By.xpath(mightLike1));
			Action.scrollByVisibilityOfElement(getDriver(), MightLike1);
			
			List<WebElement> MightLikeallproduct = getDriver().findElements(By.xpath(mightLikeallproduct));
			int n = MightLikeallproduct.size();
			
			List<WebElement> MightLikeimages = getDriver().findElements(By.xpath(mightLikeimages));
			int x = MightLikeimages.size();
			if(x==n) {System.out.println("All "+ x +" images are present");
			}
				else {
				System.out.println(n-x + " Images are not present ");
				softAssert.assertTrue(false, +n-x+" Images are not present ");
				}
			
			List<WebElement> MightLikeProductName= getDriver().findElements(By.xpath(mightLikeProductNames));
			int y = MightLikeProductName.size();
			if(y==n) {System.out.println("All "+ y +" Might_Like Product Names are present");}
				else {
				System.out.println(n-y + "  Might Like Product Names are not present ");
				softAssert.assertTrue(false, +n-y+"  Might Like Product Names are not present ");
				}
			
			List<WebElement> MightLikeProductDescription= getDriver().findElements(By.xpath(mightLikeProductDescription));
			int z = MightLikeProductDescription.size();
			if(z==n) {System.out.println("All "+ z +" Might_Like Product description are present");}
				else {
				System.out.println(n-z + "  Might Like Product description are not present ");
				softAssert.assertTrue(false, +n-z+"  Might Like Product description are not present ");
				}
			
			List<WebElement> BookMarkicon =getDriver().findElements(By.xpath(bookMarkicon));
			int c = BookMarkicon.size();
			if(c==n) {System.out.println("All "+ c +"  BookMarkicon are present");}
				else {
				System.out.println(n-c + " BookMarkicon are not present ");
				softAssert.assertTrue(false, +n-c+" BookMarkicon are not present ");
				}
				
	}

}
