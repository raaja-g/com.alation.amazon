package com.alation.amazon.objects;

import org.testng.TestException;

import com.alation.amazon.pages.productSearchPage;

public class Book {

	private String bookTitle = "";
	private String author = "";
	private String edition = "";
	private String rentPrice = "";
	private String buyPrice = "";
	private String kindlePrice = "";
	private String stocksLeft = "";

	public Book() {
	}

	// Forms a string with all the necessary Book details.
	public String bookDetails() {
		return String.format("Book Title:  " + this.bookTitle + "\n" + "Author: " + this.author + "\n" + "Edition:  "
				+ this.edition + "\n" + "Rent Price:  " + this.rentPrice + "\n" + "Buy Price:  " + this.buyPrice + "\n"
				+ "kindle Price:  " + this.kindlePrice + "\n" + "Stocks Left:  " + this.stocksLeft);
	}

	// We use this method to get all the necessary book information.

	public void bookInformation() {
		productSearchPage bookPage = new productSearchPage();
		String catBook = bookPage.getconfirmCategory();

		if (catBook.contains("Books")) {
			System.out.println("LOAD_INFO: Required data...\n");
			this.bookTitle = bookPage.getfirstBookName();
			this.author = bookPage.getfirstBookAuthor();
			this.edition = bookPage.getfirstBookEditionType();
			this.rentPrice = bookPage.getfirstBookBuyPrice();
			this.buyPrice = bookPage.getfirstBookRentPrice();
			this.kindlePrice = bookPage.getfirstBookKindlePrice();
			this.stocksLeft = bookPage.getfirstBookTotalStocksLeft();
		} else {
			throw new TestException("ERROR: Selected category is NOT " + catBook);

		}
	}

	public String getbooktTitle() {
		return bookTitle;
	}

	public void setProductTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getrentPrice() {
		return rentPrice;
	}

	public void setrentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getbuyPrice() {
		return rentPrice;
	}

	public void setbuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getkindlePrice() {
		return kindlePrice;
	}

	public void setkindlePrice(String kindlePrice) {
		this.kindlePrice = kindlePrice;
	}

	public String getstocksLeft() {
		return stocksLeft;
	}

	public void setstocksLeft(String stocksLeft) {
		this.stocksLeft = stocksLeft;
	}

}