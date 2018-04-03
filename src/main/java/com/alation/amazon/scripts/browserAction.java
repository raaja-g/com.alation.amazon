package com.alation.amazon.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class browserAction {

	public static void click(WebDriver driver, By by) {
		try {

			@SuppressWarnings({ "unchecked", "rawtypes" })
			Wait<WebDriver> wait = new FluentWait(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			System.out.println("Waiting for the Element");
			WebElement element = driver.findElement(by);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			System.out.println("Desired Actionable element found");
			if (element != null) {
				element.click();
			} else {
				System.out.println("Not Clicked Button");
			}

		}

		catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			driver.findElement(by).click();
			StringBuilder sb = new StringBuilder();
			for (StackTraceElement element : sere.getStackTrace()) {
				sb.append(element.toString());
				sb.append("\n");
			}
			System.out.println("Not Clicked Button");
		}
	}

}
