package com.alation.amazon.scripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.apache.commons.lang3.StringUtils;

import com.alation.amazon.driverScript.driverScript;

public abstract class browserAction {

	private static int timeout = 10;

	public browserAction() {
		driver = driverScript.getDriver();
	}

	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	public Select select;

	public void waitUntilElementIsDisplayedOnScreen(By by) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not visible: ", by));
		}
	}

	public void waitForElementToDisplay(By Selector) throws Exception {
		WebElement element = getElement(Selector);
		while (!element.isDisplayed()) {
			System.out.println("Waiting for element to display: " + Selector);
			Thread.sleep(200);
		}
	}

	public void navigateToURL(String URL) {
		try {
			driver.navigate().to(URL);
			Log.info("Navigated Successfully to the URL : " + URL);
		} catch (Exception e) {
			Log.error("FAILURE: URL did not load: " + URL);
			throw new TestException("URL did not load");
		}
	}

	public String getPageTitle() {
		try {
			Log.info("Page Title is : " + driver.getTitle().toString());
			return driver.getTitle();
		} catch (Exception e) {
			Log.error(e.toString());
			throw new TestException(String.format("Current page title is:", driver.getTitle().toString()));
		}
	}

	public String getCurrentURL() {
		try {
			Log.info("Current URL is : " + driver.getCurrentUrl());
			return driver.getCurrentUrl();
		} catch (Exception e) {
			Log.error(e.toString());
			throw new TestException(String.format("Current URL is: ", driver.getCurrentUrl()));
		}
	}

	public WebElement getElement(By by) {
		try {
			return driver.findElement(by);
		} catch (Exception e) {
			Log.error(e.toString());
			System.out.println(String.format("Element does not exist - proceeding", by));
		}
		return null;

	}

	public String getElementText(By by) {
		waitUntilElementIsDisplayedOnScreen(by);
		try {
			String value = driver.findElement(by).getText();
			return StringUtils.trim(value);

		} catch (Exception e) {
			Log.error(e.toString());
			System.out.println(String.format("Element %s does not exist - proceeding", by));
		}
		return null;
	}

	public void select(By by, By by1, String searchCriteria) throws Exception {

		if (searchCriteria == null) {
			System.out.println("No Search Criteria: " + searchCriteria);
			Log.error("No Search Criteria: " + searchCriteria);
			throw new TestException("Options for the dropdown list cannot be found.");
		} else {
			driver.findElement(by).click();
			new Select(driver.findElement(by)).selectByVisibleText(searchCriteria);
			driver.findElement(by1).click();
			Log.info("Successfully selected the search criteria : " + searchCriteria);
		}
	}

	public List<String> getDropdownValues(By by) throws Exception {

		waitForElementToDisplay(by);
		Select dropdown = new Select(getElement(by));
		List<String> elementList = new ArrayList<String>();

		List<WebElement> allValues = dropdown.getOptions();

		if (allValues == null) {
			throw new TestException("Some elements in the list do not exist");
		}

		for (WebElement value : allValues) {
			if (value.isDisplayed()) {
				elementList.add(value.getText().trim());
			}
		}
		return elementList;
	}

	public void click(By by) {
		WebElement element = getElement(by);
		try {
			if (element == null) {
				Log.error("No Button Element : " + by.toString());
				driver.findElement(by).click();
			} else {
				Log.info("Successfully Clicked the Button Element : " + element.getText());
				element.click();
			}
		} catch (Exception e) {
			Log.error("Retry Clicking the button..." + element.getText());
			driver.findElement(by).click();
			Log.error("Retry Clicking the button FAILED : " + element.getText());
			throw new TestException(String.format("The following element is not clickable: [%s]", by));
		}
	}

	public void waitForElementTextToBeEmpty(WebElement element) {
		String text;
		try {
			text = element.getText();
			int maxRetries = 10;
			int retry = 0;
			while ((text.length() >= 1) || (retry < maxRetries)) {
				retry++;
				text = element.getText();
			}
		} catch (Exception e) {
			System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
		}

	}

	public void clearField(WebElement element) {
		try {
			element.clear();
			waitForElementTextToBeEmpty(element);
			Log.info("Successfully cleared the texts in the Element : " + element.getText());
		} catch (Exception e) {
			Log.error(String.format("The following element could not be cleared: [%s]", element.getText()));
		}
	}

	public void sendKeys(By by, String value) {
		WebElement element = getElement(by);
		clearField(element);
		try {
			element.sendKeys(value);
			Log.info("Successfully cleared the entered in the Element : " + element.getText());
		} catch (Exception e) {
			throw new TestException(
					String.format("Error in sending [%s] to the following element: [%s]", value, by.toString()));
		}
	}

}
