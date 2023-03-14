package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class RecipePageFinal extends BaseClass {
	
	String searchBox = "//input[@placeholder='Search']";
	String clickButton=  "//div[@class='MuiInputAdornment-root MuiInputAdornment-positionStart MuiInputAdornment-outlined MuiInputAdornment-sizeMedium css-1a6giau']//*[name()='svg']";
	String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a";
	String bd_Blog = "(//li[@class='MuiBreadcrumbs-li'])/p";
	String Author = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']";
	String P_Date = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']";
	String loginbutton = "//button[normalize-space()='LOG IN']";
	String loginPageTxt = "//input[@name='email']";
	String likeIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";
	String bookMarkIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[2]";
	String shareIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[3]";
	String likeCount = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-5cgcae'][1]";
	String bookCount = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-5cgcae'][2]";
	String socialMediaIcons = "(//*[name()='circle'])";
	String categoryElements = "//div[@class='css-1hvic5s']/div/button";
	String blog_title = "//div[@class='MuiTypography-root MuiTypography-body1 css-1q9lqtf']";
	String quickview = "//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String actualPrice = "//p[@class='MuiTypography-root MuiTypography-body1 css-1tva794']";
	String discountedPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-lgaoco']";
	String productsName = "//div[@class='MuiBox-root css-y1fexb']";
	String images  = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-9rdiop']/span/img";
	String carticon = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-nle8bv']";
	String wishlist = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-v7k3k0']//*[name()='svg']";
	String commentTxt = "//h5[@class='MuiTypography-root MuiTypography-h5 css-3tvp08']";
	String commentBox ="//input[@id='outlined-adornment-password']";
	String postbutton = "//span[@class='MuiTypography-root MuiTypography-span css-1fz7ep2']";
	String commentCount ="//span[@class='MuiTypography-root MuiTypography-span css-1ov61vh']";
	String see_more = "//span[normalize-space()='See more']";
	String commentPosted = "//div[@class = 'MuiBox-root css-12tyeii']";
	String replyCount = "//span [@class= 'MuiTypography-root MuiTypography-span css-4ccwly']";
	String crossbutton1 = "//*[local-name()='svg' and @data-testid='ClearIcon']";
	String recipeImage =  "//img[@class='MuiBox-root css-11cts2d']";
	String taggscount= "//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7']";
	String nutritions = "//p[@class='MuiTypography-root MuiTypography-body1 css-22dtt9']";
	
	String reportAbuse = "//div[@class='css-viqta1']/button";
	String recipeVideo = "//h5[@class='MuiTypography-root MuiTypography-h5 css-12esd7r']";
	String frame = "//iframe[@id='widget2']";
	
	@FindBy (xpath = "//span[@class='MuiTypography-root MuiTypography-span css-1fz7ep2']")
	WebElement postBtn;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='LOG IN']")
	WebElement loginBtn;
	@FindBy(xpath = "//div[normalize-space()='Cooking Time :']")
	WebElement cookingTime;
	
	SoftAssert softAssert = new SoftAssert();
	
	public RecipePageFinal() {
		PageFactory.initElements(getDriver(), this);
		softAssert.assertAll();
	}
	
	
	

	
	public void recipeImage() {
		WebElement recipeimage = getDriver().findElement(By.xpath(recipeImage));
		//Boolean p = (Boolean) ((JavascriptExecutor)getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", recipeImage); 
		boolean p = Action.isDisplayed(getDriver(), recipeimage);
		Assert.assertTrue(p);
		
		
	}
	
	
	public void breadCrumbFunctionality(String title) {
		int count =0;
		List<WebElement>  breadcrumb = getDriver().findElements(By.xpath(bd_Home));
		List<String> listElements = new ArrayList<String>();
		for (WebElement webElement : breadcrumb) {
			listElements.add(webElement.getText().replace(" ", "|"));
			count++;
		}
		String delim = "|";
		String actualBreadcrumb = String.join(delim, listElements);
		 System.out.println(actualBreadcrumb);
			getDriver().findElement(By.xpath(bd_Home)).click();
			Action.explicitWaitbyTitle(getDriver(), "dot beauty", Duration.ofSeconds(10));
			String HomeTitle = getDriver().getTitle();
			Assert.assertEquals(HomeTitle, "dot beauty"); 
			getDriver().navigate().back();
			Action.explicitWaitbyTitle(getDriver(), title, Duration.ofSeconds(5));
		
	}
	
	public void authoreDetailsVerification(String AuthorName, String  PublishDate) {
		
		WebElement author = getDriver().findElement(By.xpath(Author));
		Action.explicitWait(getDriver(), author, Duration.ofSeconds(10));
		String actualAuthorName = getDriver().findElement(By.xpath(Author)).getText();
		if(!actualAuthorName.isBlank()) {
		System.out.println(actualAuthorName);
		Assert.assertEquals(actualAuthorName, AuthorName);
		}
		else if(actualAuthorName.isBlank()) {
			System.out.println("Auhtor name are not Present");
			Log.warn("Author name are not present");
			Assert.assertTrue(false);
		}
		String actualPublishDate = getDriver().findElement(By.xpath(P_Date)).getText();
		if(!actualPublishDate.isBlank()) {
		String actdate = "/" + actualPublishDate + "/";
		System.out.println("/"+actualPublishDate+"/");
		Assert.assertEquals(actdate, PublishDate);}
		else if(actualPublishDate.isBlank()) {
			System.out.println("Date are not Present");
			Log.warn("Date are not present");
			softAssert.assertTrue(false, "Publish Date are not present");
			//softAssert.assertAll();
		}
	}
	
	
	public void LikeIconfunctionality(String status) throws InterruptedException {
		String countTxt =	getDriver().findElement(By.xpath(likeCount)).getText();
		getDriver().findElement(By.xpath(likeIcon)).click();
		if(status.equalsIgnoreCase("Loggedout")) {
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		Thread.sleep(1000);
		}
		else {
		//getDriver().get("https://develop.d1fzm6olmw007.amplifyapp.com/recipe/sugarcane-juice-black-wheat-muffins-cake");
		
		getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
		getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
		Thread.sleep(2000)	;
		getDriver().navigate().refresh();
		int count=Integer.parseInt(countTxt); 
		getDriver().findElement(By.xpath(likeIcon)).click();
		Thread.sleep(2000)	;
		String countTxt2 =	getDriver().findElement(By.xpath(likeCount)).getText();
		int newCount = Integer.parseInt(countTxt2);
		Assert.assertEquals(count+1, newCount);
		System.out.println("dfghjklcghgjhjk");
		//WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		//Action.moveto
		
		getDriver().findElement(By.xpath(likeIcon)).click();
		
		Thread.sleep(5000);
		//System.out.println("dfghjklcghgjhjk");
		}
		
	}
	
	public void BookMarkIconfunctionality(String status) throws InterruptedException {
		String countTxt =	getDriver().findElement(By.xpath(bookCount)).getText();
		getDriver().findElement(By.xpath(bookMarkIcon)).click();
		System.out.println(countTxt);
		if(status.equalsIgnoreCase("Loggedout")) {
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		Thread.sleep(5000);
		}
		else {
			getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
			getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
			Thread.sleep(10000);
			getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
			Thread.sleep(2000)	;
			getDriver().navigate().refresh();
			int count=Integer.parseInt(countTxt); 
			System.out.println(count); 
			Thread.sleep(2000)	; 
			getDriver().findElement(By.xpath(bookMarkIcon)).click();
			Thread.sleep(2000)	; 
		String countTxt2 =	getDriver().findElement(By.xpath(bookCount)).getText();
		System.out.println(countTxt2);
		int newCount = Integer.parseInt(countTxt2);
		Assert.assertEquals(count+1, newCount);
		getDriver().findElement(By.xpath(bookMarkIcon)).click();
		}
	}
	
	public void ShareIconfunctionality() throws InterruptedException {
		getDriver().findElement(By.xpath(shareIcon)).click();
		//Thread.sleep(2000);
		List<WebElement> socialMediaList =	getDriver().findElements(By.xpath(socialMediaIcons));
		System.out.println(socialMediaList.size());
		
	}
	
	public void CategoryListVerification() {
		int count = 0;
		List<WebElement> menuList = getDriver().findElements(By.xpath(categoryElements));
		//int size = menuList.size();
		List<String> listElements = new ArrayList<String>();
		for (WebElement webElement : menuList) {
			listElements.add(webElement.getText().replace(" ", ","));
			count++;
		}
		String delim = ",";
		String category = String.join(delim, listElements);
		 System.out.println(category);
		  if (count != 0) { if (count == menuList.size())
		  { System.out.println("Category elements are equal"); } else {
		  System.out.println("Category elements are not equal");
		  Assert.assertTrue(false); } } else {
		  System.out.println("Category are not present"); }
	
	}
	
	
	public String blogTitleVerification() {
		String actualblogTitle = getDriver().findElement(By.xpath(blog_title)).getText();
		return actualblogTitle;
		
	}
	
	 
	public void tagList(){
		 Log.info("Veryfying the Tag List");
		 WebElement tagText = getDriver().findElement(By.
				  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']"));
		  Action.scrollByVisibilityOfElement(getDriver(), tagText);
		   System.out.println(tagText.getText());
		List<WebElement> taggs = getDriver().findElements(By.xpath(taggscount));
		System.out.println(taggs.size());
			if(taggs.size() == 5) {
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
			else if(taggs.size()<5 && taggs.size() !=0) {
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
				Assert.assertTrue(false);
			}			
	}
	
		public void tagElements() throws InterruptedException {
			 Log.info("Veryfying the Tag Elements functionality");
			 WebElement tagText = getDriver().findElement(By.
					  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']"));
			  Action.scrollByVisibilityOfElement(getDriver(), tagText);
			  System.out.println(tagText.getText());
				List<WebElement> taggs = getDriver().findElements(By.xpath(taggscount));
				System.out.println(taggs.size());
				
				  Random r = new Random(); 
				  int randomValue = r.nextInt(taggs.size()); //Getting a random value that is between 0 and (list's size)-1
				  taggs.get(randomValue).click(); //Clicking on the random item in the list.\
				 System.out.println( taggs.get(randomValue).getText());
				 Action.explicitWaitbyTitle(getDriver(), "Search Page", Duration.ofSeconds(5));
				  Assert.assertEquals(getDriver().getTitle(), "Search Page");
				 
	}
	
	
	public void nutrilionListVerification(String message) {
		
		Log.info("Nutrition per Saving lists");
		WebElement nutritions_Display = getDriver()
				.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1aoo3g']"));
		Action.scrollByVisibilityOfElement(getDriver(), nutritions_Display);
		 System.out.println(nutritions_Display.getText());
		//	List<WebElement> taggs = getDriver().findElements(By.xpath(nutritions));
		
		//if()
		
		
		
		
		if (message.equalsIgnoreCase("yes,yes") || message.equalsIgnoreCase("yes")) {

			Log.info("Nutrition per Saving lists");
		//	WebElement nutritions_Display = getDriver()
		//			.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1aoo3g']"));

			// String nutrionName =
			// getDriver().findElement(By.xpath("//p[@class='MuiTypography-root
			// MuiTypography-body1 css-1aoo3g']")).getText();
			if (nutritions_Display.isDisplayed()) {

				Assert.assertEquals(nutritions_Display.getText(), "Nutritions Per Serving");
				WebElement seeButton = getDriver()
						.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1fatci1']"));
				if (seeButton.isDisplayed()) {
					seeButton.click();
				}
				List<WebElement> nutritionLists = getDriver()
						.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-22dtt9']"));
				System.out.println(nutritionLists.size());
				int count111 = 0;
				List<String> NutritionElements = new ArrayList<String>();
				for (WebElement webElement : nutritionLists) {
					NutritionElements.add(webElement.getText());
					count111++;
				}
				String delii = "\n";
				String nutritions = String.join(delii, NutritionElements);
				System.out.println(nutritions);

				if (count111 == nutritionLists.size()) {
					System.out.println("nutritionList List are equal");
					Assert.assertTrue(true);
				} else {
					System.out.println("nutritionList list Steps are not equal");
					Assert.assertTrue(false);
				}
			}
		} else if (message.equalsIgnoreCase("yes,no")) {
			Log.info("Nutrition per Saving lists");
			WebElement nutritions_Display1 = getDriver()
					.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1aoo3g']"));

			// String nutrionName =
			// getDriver().findElement(By.xpath("//p[@class='MuiTypography-root
			// MuiTypography-body1 css-1aoo3g']")).getText();
			if (nutritions_Display1.isDisplayed()) {

				Assert.assertEquals(nutritions_Display1.getText(), "Nutritions Per Serving");
				List<WebElement> nutritionLists = getDriver()
						.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-22dtt9']"));
				System.out.println(nutritionLists.size());
				int count111 = 0;
				List<String> NutritionElements = new ArrayList<String>();
				for (WebElement webElement : nutritionLists) {
					NutritionElements.add(webElement.getText());
					count111++;
				}
				String delii = "\n";
				String nutritions = String.join(delii, NutritionElements);
				System.out.println(nutritions);

				if (count111 == nutritionLists.size()) {
					System.out.println("nutritionList List are equal");
					Assert.assertTrue(true);
				} else {
					System.out.println("nutritionList list Steps are not equal");
					Assert.assertTrue(false);
				}
			} else {
				System.out.println("Nutritions List are not Present");
			}
		}
		

	}
	
	
	
	
	
	public void shoptheIngredients() throws InterruptedException {
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		  js1.executeScript("window.scrollBy(0,2000)", "");
		  
			List<WebElement> image = getDriver().findElements(By.xpath(images));
			int  i =image.size();
			System.out.println(i);
			if(i>0) {
			List<WebElement> productName = getDriver().findElements(By.xpath(productsName));
			int j = productName.size();
			System.out.println(j);
			for (WebElement x : productName) {
			 System.out.println(x.getText());
			}
			
			List<WebElement> productDisPrice = getDriver().findElements(By.xpath(discountedPrice));
			int k = productDisPrice.size();
			System.out.println(k);
			List<WebElement> productActPrice = getDriver().findElements(By.xpath(actualPrice));
			int l = productActPrice.size();
			System.out.println(l);
			List<WebElement> quickviewlink = getDriver().findElements(By.xpath(quickview));
			int m = quickviewlink.size();
			System.out.println(m);
			String allproduct = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-9rdiop']";
			List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
			int n = products1.size();
			System.out.println(n);
			WebElement carticon1 =getDriver().findElement(By.xpath(carticon));
			WebElement wishlist1 =getDriver().findElement(By.xpath(wishlist));
			if(i==j && j==k && k==l && l==m && m==i && i != 0 ) {
				//List<String> productElements = new ArrayList<String>();
				for (WebElement element : products1) {
					
					Action.mouseOverElement(getDriver(), element);
					
					System.out.println(Action.isDisplayed(getDriver(), carticon1));
					System.out.println(Action.isDisplayed(getDriver(), wishlist1));
					Thread.sleep(2000);
					
				}}}
			
		else {
			System.out.println("No products are available ");
			Assert.assertTrue(false);
		}
		
		
		
	}
	
	public void commentsSectionVerification() {
		WebElement comment = getDriver().findElement(By.xpath(commentTxt));
		Action.scrollByVisibilityOfElement(getDriver(), comment);
		String actualTxt = getDriver().findElement(By.xpath(commentTxt)).getText();
		Assert.assertEquals(actualTxt, "COMMENTS");
		Assert.assertTrue(getDriver().findElement(By.xpath(commentBox)).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.xpath(postbutton)).isDisplayed());
		}
	
	
	
	public void addCommentVerification() {
		WebElement CommentBox =getDriver().findElement(By.xpath(commentBox));
		Action.type(CommentBox, "Comment");
		WebElement PostButton =getDriver().findElement(By.xpath(postbutton));
		//getDriver().findElement(By.xpath(postbutton)).click();
		Action.click(getDriver(), PostButton);
		WebElement LoginButton =getDriver().findElement(By.xpath(loginbutton));
		boolean p = Action.isDisplayed(getDriver(), LoginButton);
		Assert.assertTrue(p);
		//Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton =getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		//getDriver().findElement(By.xpath(crossbutton)).click();
		String countTxt = getDriver().findElement(By.xpath(commentCount)).getText();
		int count=Integer.parseInt(countTxt); 
		System.out.println("Total Posted Count  = "+count);
		if(count>4) {
			getDriver().findElement(By.xpath(see_more)).click();
			List<WebElement> postedcomments = getDriver().findElements(By.xpath(commentPosted));
			int postedCount = postedcomments.size();
			System.out.println("Total Posted Count after click on see more = "+postedCount);
			
			List<WebElement> abuse= getDriver().findElements(By.xpath(reportAbuse));
			int abuseCount = abuse.size();
			System.out.println("Report Abuse Count = "+ abuseCount);
			
			
			
			List<WebElement> replycomments = getDriver().findElements(By.xpath(replyCount));
			int temp =0;
			for (WebElement element: replycomments) {
			String data =	element.getText();
			int data1=Integer.parseInt(data);
			temp = temp + data1;
			}
			System.out.println("Reply Comments are = "+ temp);
			int totalCount = postedCount +  temp;
			System.out.println("Total Count are verification = "+totalCount);
			Assert.assertEquals(count, totalCount, "Comments Counts are not equal");
			
			Log.info("Report abuse count verification");
			Assert.assertEquals(abuseCount, postedCount, "Counts are not equal of Report Abuse button");
			System.out.println("Successfully verified the Report Abuse buttons ");
					
		}
		else if(count<4 && count!=0){
			List<WebElement> postedcomments = getDriver().findElements(By.xpath(commentPosted));
			int postedCount = postedcomments.size();
			System.out.println("Total Posted Count = "+postedCount);
			
			List<WebElement> abuse= getDriver().findElements(By.xpath(reportAbuse));
			int abuseCount = abuse.size();
			System.out.println("Report Abuse Count = "+ abuseCount);
			
			List<WebElement> replycomments = getDriver().findElements(By.xpath(replyCount));
			int temp =0;
			for (WebElement element: replycomments) {
			String data =	element.getText();
			int data1=Integer.parseInt(data);
			temp = temp + data1;
			}
			System.out.println(temp);
			int totalCount = postedCount +  temp;
			System.out.println("Total Count are verification = "+totalCount);
			Assert.assertEquals(count, totalCount, "Comments Counts are not equal");

			Log.info("Report abuse count verification");
			Assert.assertEquals(abuseCount, totalCount, "Counts are not equal of Report Abuse button");
			System.out.println("Successfully verified the Report Abuse buttons ");
		}
		else {
			System.out.println("Comments are not Present");
		}
	}
	
	
	public void ReportAbuseFunctionality() {
		WebElement comment = getDriver().findElement(By.xpath(commentTxt));
		Action.scrollByVisibilityOfElement(getDriver(), comment);
		
		//List<WebElement> abuse= getDriver().findElements(By.xpath(reportAbuse));
		
		
	}
	
	
	
	
	public void recipeVideoSection() throws InterruptedException {
		WebElement frames = getDriver().findElement(By.xpath(frame));
		WebElement recipeVideos = getDriver().findElement(By.xpath(recipeVideo));
		Action.scrollByVisibilityOfElement(getDriver(), recipeVideos);
		String text = recipeVideos.getText();
		Assert.assertEquals(text, "RECIPE VIDEO");
		System.out.println(Action.isDisplayed(getDriver(), frames));
		Action.click(getDriver(), frames);
		Thread.sleep(5000);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy (xpath = "//input[@id='outlined-adornment-password']")
	WebElement typecomment;
	@FindBy(xpath = "(//div[@class='MuiBox-root css-6n7j50'])[1]")
	WebElement postedComment;
	@FindBy(xpath = "//img[@alt='Picture of the author']")
	WebElement editButton;
	@FindBy(xpath = "(//img[@alt='Dlt Button'])")
	WebElement deleteButton;
	
	@FindBy(xpath = "//input[@id='standard-helperText']")
	WebElement editTextbox;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1bvc4cc'])/button[2]")
	WebElement saveBtn;
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1bvc4cc'])/button[1]")
	WebElement cancelBtn;
	
	public void LoggedInAddCommentsVerification(String save) throws InterruptedException {
		WebElement comment = getDriver().findElement(By.xpath(commentTxt));
		Action.scrollByVisibilityOfElement(getDriver(), comment);
		//Thread.sleep(5000);
		String typedComment = "This is selenium test9";
		Action.type(typecomment, typedComment);
		System.out.println("T1");
		Action.click(getDriver(), postBtn);
		Thread.sleep(1000);
		System.out.println("T2");
		Action.explicitWait(getDriver(), editButton, Duration.ofSeconds(10));
		Assert.assertEquals(postedComment.getText(), typedComment);
		Thread.sleep(1000);
		System.out.println("T3");
		Action.click(getDriver(), editButton);
		System.out.println("T4");
		String editTypedComment = "This is edited selenium test9";
		
		Action.type(editTextbox, editTypedComment);
		System.out.println("T5");
		if (save.equalsIgnoreCase("save")) {
			System.out.println("T6");
			Action.click(getDriver(), saveBtn);
			System.out.println("T7");
			Thread.sleep(2000);
			Assert.assertEquals(postedComment.getText(), editTypedComment);
			Action.click(getDriver(), deleteButton);
			Thread.sleep(1000);
			String txt = getDriver().findElement(By.xpath("(//h2[normalize-space()='Delete comment'])[1]")).getText();
			if (txt.equalsIgnoreCase("Delete Comment"))
			getDriver().findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(1000);
			System.out.println("Comment successfully deleted");
			
		}
		
		  else if(save.equalsIgnoreCase("cancel"))
		  { Action.click(getDriver(),cancelBtn); 
		  Assert.assertEquals(postedComment.getText(), typedComment); }
		 
	}
}
