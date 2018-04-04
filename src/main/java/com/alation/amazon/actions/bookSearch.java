package com.alation.amazon.actions;

import com.alation.amazon.page.*;
import com.alation.amazon.objects.*;
import com.alation.amazon.scripts.Log;

public class bookSearch {

	public void navigateToHomePage() {
		homePage homePage = new homePage();
		homePage.navigateToHomePage();
	}

	public void navigateToLoginPage() {
		homePage homePage = new homePage();
		homePage.navigateToLoginPage();
	}

	public void searchBook(String category, String bookName) throws Exception {
		productSearchPage searchBook = new productSearchPage();
		searchBook.selectCategory(category);
		searchBook.searchProduct(bookName);
		searchBook.performSearchGo();

	}

	public Book loadbookInformation() {
		System.out.println("Starting process to load info for Books :");
		Book book = new Book();
		productSearchPage productPage = new productSearchPage();
		if (productPage.getconfirmCategory().equals("Books")) {
			book.bookInformation();
			Log.info("**********************  B O O K  I N F O R M A T I O N   **************************");
			Log.info(" TITLE OF THE FIRST BOOK : " + productPage.getfirstBookName());
			Log.info(" NAME OF THE BOOK'S AUTHOR: " + productPage.getfirstBookAuthor());
			Log.info(" TYPE OF BOOK'S EDITION: " + productPage.getfirstBookEditionType());
			Log.info(" BOOK'S BUY PRICE: " + productPage.getfirstBookBuyPrice());
			Log.info(" BOOK'S RENT PRICE: " + productPage.getfirstBookRentPrice());
			Log.info(" BOOK'S KINDLE EDITION PRICE: " + productPage.getfirstBookKindlePrice());
			Log.info("**********************  END OF BOOK  INFORMATION   ********************************");
			return book;
		} else {
			System.out.println("Required book not found and below are the found book information" + "\n");
			Log.info("**********************  P R O D U C T  I N F O R M A T I O N   **************************");
			Log.info(" TITLE OF THE BOOK DISPLAYED : " + productPage.getfirstBookName());
			Log.info(" NAME OF THE BOOK'S AUTHOR: " + productPage.getfirstBookAuthor());
			Log.info(" TYPE OF BOOK'S EDITION: " + productPage.getfirstBookEditionType());
			Log.info(" BOOK'S BUY PRICE: " + productPage.getfirstBookBuyPrice());
			Log.info(" BOOK'S RENT PRICE: " + productPage.getfirstBookRentPrice());
			Log.info(" BOOK'S KINDLE EDITION PRICE: " + productPage.getfirstBookKindlePrice());
			Log.info("**********************  END OF BOOK  INFORMATION   ********************************");
			return book;
		}

	}

}