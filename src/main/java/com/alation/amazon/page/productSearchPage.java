package com.alation.amazon.page;

import org.openqa.selenium.By;

import com.alation.amazon.scripts.browserAction;

public class productSearchPage extends browserAction {

	// All the objects related to the page.
	// Any changes to the object we change it here.

	private final By selectCategory = By.id("searchDropdownBox");
	private final By selectCategoryOption = By.cssSelector("option[value=\"search-alias=stripbooks\"]");
	private final By searchProduct = By.name("field-keywords");
	private final By performSearch = By.cssSelector("input.nav-input");

	private final By firstBookName = By.xpath("//*[@id='result_0']/div/div/div/div[2]/div[1]/div[1]/a");
	private final By firstBookAuthor = By.xpath("//*[@id='result_0']/div/div/div/div[2]/div[1]/div[2]/span[2]/a");
	private final By firstBookEditionType = By
			.xpath("//*[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/div[1]/a/h3");
	private final By firstBookRentPrice = By.xpath(
			"//li[@id='result_0']//span[.='to rent']/preceding-sibling::*[2]/span[contains(@class,'sx-price sx-price-large')]");
	private final By firstBookBuyPrice = By.xpath(
			"//li[@id='result_0']//span[.='to buy']/preceding-sibling::*[2]/span[contains(@class,'sx-price sx-price-large')]");
	private final By firstBookTotalStocksLeft = By
			.xpath("//*[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/div[5]/span");
	private final By firstBookKindlePrice = By
			.xpath("//li[@id='result_0']//div[.='Kindle Edition']/following-sibling::*[1]");
	private final By confirmCategory = By.xpath("//*[@id='s-result-count']/span/a");

	public productSearchPage() {
	}

	// Selects the category "Books" in the selection.

	public void selectCategory(String category) throws Exception {
		select(selectCategory, selectCategoryOption, category);
	}

	// Enters the value "Data Catalog" in the search bar.
	// This is parameterized.
	// We can send the value from the driver script @Test

	public void searchProduct(String bookName) {
		sendKeys(searchProduct, bookName);
	}

	// Clicks the Search button.
	public void performSearchGo() {
		click(performSearch);
	}

	// We get the First Book Name.
	public String getfirstBookName() {
		return getElementText(firstBookName);
	}

	// We get the First Book's Author Name.
	public String getfirstBookAuthor() {
		return getElementText(firstBookAuthor);
	}

	// We get the First Book's Edition Type.
	public String getfirstBookEditionType() {
		return getElementText(firstBookEditionType);
	}

	// We get the First Book's Rent Price (Total value and not whole or Fractional
	// value).
	public String getfirstBookRentPrice() {
		return getElementText(firstBookRentPrice);
	}

	// We get the First Book's Buy Price (Total value and not whole or Fractional
	// value).
	public String getfirstBookBuyPrice() {
		return getElementText(firstBookBuyPrice);
	}

	// We get the First Book's Total stocks left
	public String getfirstBookTotalStocksLeft() {
		return getElementText(firstBookTotalStocksLeft);
	}

	// We get the First Book's Kindle Price (Total value and not whole or Fractional
	// value).
	public String getfirstBookKindlePrice() {
		return getElementText(firstBookKindlePrice);
	}

	// We use this to confirm the selected category
	public String getconfirmCategory() {
		return getElementText(confirmCategory);
	}

}
