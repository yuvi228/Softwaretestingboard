package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Eventhelper {

	private static final Logger logger = LogManager.getLogger(Eventhelper.class);

	public static void get(WebDriver driver, String url) {
		driver.get(url);
		logger.info("Navigated to: " + url);
	}

	public static WebElement findElement(WebDriver driver, By locator) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			logger.info("Element found: " + locator);
		} catch (Exception e) {
			logger.error("Exception during find element: " + e.getMessage(), e);
		}
		return element;
	}

	public static void sendkeys(WebDriver driver, By locator, String val) {
		WebElement element = findElement(driver, locator);
		element.clear();
		element.sendKeys(val);
		logger.info("Entered text: " + val + " into field: " + locator);
	}

	public static void click(WebDriver driver, By locator) {
		WebElement element = findElement(driver, locator);
		try {
			element.click();
			logger.info("Clicked on field: " + locator);
		} catch (ElementClickInterceptedException | StaleElementReferenceException | NoSuchElementException e) {
			logger.error("Exception occurred during element interaction: " + e.getMessage());
		}
	}

	public static String getText(WebDriver driver, By locator) {
		String text = null;
		try {
			WebElement element = findElement(driver, locator);
			text = element.getText();
			logger.info("Retrieved text: '" + text + "' from element: " + locator);
		} catch (Exception e) {
			logger.error("Exception occurred while retrieving text from element: " + locator + " - " + e.getMessage(),
					e);
		}
		return text;
	}

	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		WebElement element = findElement(driver, locator);
		boolean isDisplayed = element != null && element.isDisplayed();
		logger.info("Element " + locator + " is displayed: " + isDisplayed);
		return isDisplayed;
	}
}
