package com.alation.amazon.page;

import org.openqa.selenium.By;

import com.alation.amazon.scripts.browserAction;

public class productSearchPage extends browserAction {

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

	public void selectCategory(String category) throws Exception {
		select(selectCategory, selectCategoryOption, category);
	}

	public void searchProduct(String bookName) {
		sendKeys(searchProduct, bookName);
	}

	public void performSearchGo() {
		click(performSearch);
	}

	public String getfirstBookName() {
		return getElementText(firstBookName);
	}

	public String getfirstBookAuthor() {
		return getElementText(firstBookAuthor);
	}

	public String getfirstBookEditionType() {
		return getElementText(firstBookEditionType);
	}

	public String getfirstBookRentPrice() {
		return getElementText(firstBookRentPrice);
	}

	public String getfirstBookBuyPrice() {
		return getElementText(firstBookBuyPrice);
	}

	public String getfirstBookTotalStocksLeft() {
		return getElementText(firstBookTotalStocksLeft);
	}

	public String getfirstBookKindlePrice() {
		return getElementText(firstBookKindlePrice);
	}

	public String getconfirmCategory() {
		return getElementText(confirmCategory);
	}

}
