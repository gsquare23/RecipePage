package com.dotKonnekt.dataProviders;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.dotKonnekt.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	// Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest,
	// orderHistoryandDetailsTest

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

	// Class --> AccountCreationPage Test Case--> verifyCreateAccountPageTest
	@DataProvider(name = "NewRecipePage1")
	public Object[][] getRecipeDetails() {
		// Totals rows count
		int rows = obj.getRowCount("recipe");
		// Total Columns
		int column = obj.getColumnCount("recipe");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("recipe", j, i + 2);
			}
		}
		return data;
	}
	
	
	// Class --> AccountCreationPage Test Case--> verifyCreateAccountPageTest
		@DataProvider(name = "NewRecipePage")
		public Object[][] getRecipeDetails1() {
			// Totals rows count
			int rows = obj.getRowCount("NewRecipePage1");
			// Total Columns
			int column = obj.getColumnCount("NewRecipePage1");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("NewRecipePage1", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "MyAccount")
		public Object[][] getMyAccountDetails() {
			// Totals rows count
			int rows = obj.getRowCount("MyAccount");
			// Total Columns
			int column = obj.getColumnCount("MyAccount");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("MyAccount", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "CategoryPage")
		public Object[][] getCategoryDetails() {
			// Totals rows count
			int rows = obj.getRowCount("CategoryPage");
			// Total Columns
			int column = obj.getColumnCount("CategoryPage");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("CategoryPage", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "CategoryPage1")
		public Object[][] getCategoryDetails1() {
			// Totals rows count
			int rows = obj.getRowCount("CategoryPage1");
			// Total Columns
			int column = obj.getColumnCount("CategoryPage1");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("CategoryPage1", j, i + 2);
				}
			}
			return data;
		}
		
		
		@DataProvider(name = "BlogPage")
		public Object[][] getBlogDetails() {
			// Totals rows count
			int rows = obj.getRowCount("BlogPage");
			// Total Columns
			int column = obj.getColumnCount("BlogPage");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("BlogPage", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "BlogPage1")
		public Object[][] getBlogDetails1() {
			// Totals rows count
			int rows = obj.getRowCount("BlogPage1");
			// Total Columns
			int column = obj.getColumnCount("BlogPage1");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("BlogPage1", j, i + 2);
				}
			}
			return data;
		}
	
	
	@DataProvider(name = "ProductPage")
	public Object[][] getProductDetails() {
		// Totals rows count
		int rows = obj.getRowCount("ProductPage");
		// Total Columns
		int column = obj.getColumnCount("ProductPage");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ProductPage", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "ProductPage1")
	public Object[][] getProductDetails1() {
		// Totals rows count
		int rows = obj.getRowCount("ProductPage1");
		// Total Columns
		int column = obj.getColumnCount("ProductPage1");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ProductPage1", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "LoginPage1")
	public Object[][] getLoginDetails() {
		// Totals rows count
		int rows = obj.getRowCount("LoginPage");
		// Total Columns
		int column = obj.getColumnCount("LoginPage");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("LoginPage", j, i + 2);
			}
		}
		return data;
	}
	
	
	
	@DataProvider(name = "ExperienceBuilder")
	public Object[][] ExperienceBuilderDetails() {
		// Totals rows count
		int rows = obj.getRowCount("ExperienceBuilder");
		// Total Columns
		int column = obj.getColumnCount("ExperienceBuilder");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ExperienceBuilder", j, i + 2);
			}
		}
		return data;
	}
		
	public Object[][] getEmail1() {
		// Totals rows count
		int rows = obj.getRowCount("Title");
		// Total Columns
		int column = obj.getColumnCount("Title");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Title", j, i + 2);
			}
		}
		return data;
	}

	/*
	 * //Class --> AddToCartPageTest, EndToEndTest, Test Case--> addToCartTest,
	 * endToEndTest
	 * 
	 * @DataProvider(name = "getTitle") public Object[][] getProduct() { // Totals
	 * rows count int rows = obj.getRowCount("Title"); // Total Columns int column =
	 * obj.getColumnCount("Title"); int actRows = rows - 1;
	 * 
	 * Object[][] data = new Object[actRows][column];
	 * 
	 * for (int i = 0; i < actRows; i++) { for (int j = 0; j < column; j++) {
	 * data[i][j] = obj.getCellData("Title", "LoginPage", i + 2); } } return data; }
	 */

	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
	@DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		// Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0] = hashMap;
		}
		return data;
	}

	/*
	 * //Class --> AddToCartPageTest, EndToEndTest, Test Case--> addToCartTest,
	 * endToEndTest
	 * 
	 * @DataProvider(name = "Title") public Object[][] getTitle() { // Totals rows
	 * count int rows = obj.getRowCount("Title"); // Total Columns int column =
	 * obj.getColumnCount("Title"); int actRows = rows - 1;
	 * 
	 * Object[][] data = new Object[actRows][column];
	 * 
	 * for (int i = 0; i < actRows; i++) { for (int j = 0; j < column; j++) {
	 * data[i][j] = obj.getCellData("ProductDetails", j, i + 2); } } return data; }
	 */
}
