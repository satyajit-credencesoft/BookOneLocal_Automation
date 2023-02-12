package com.bookonelocal.abstractComponents;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//mat-icon[contains(.,'menu')]")
	WebElement menuButton;

	@FindBy(css = "button[aria-label$='Choose month and year']")
	WebElement monthYearOption;

	By monthYearTextBy = By.cssSelector("#mat-calendar-button-6");

	@FindBy(css = "button[type='button'] div:first-child")
	List<WebElement> dates;

	@FindBy(css = "button[type='button'] div:first-child")
	List<WebElement> years;

	@FindBy(css = "button[type='button'] div:first-child")
	List<WebElement> months;

	public void waitForWebEelementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForWebElementsToAppear(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void moveToWebElementAndClick(WebElement element) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
		Thread.sleep(1000);
	}

	public void switchToChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
	}

	public void clickOnMenuIcon() {
		menuButton.click();
	}

	public HashMap<String, String> getMonth() {
		HashMap<String, String> month = new HashMap<String, String>();
		month.put("1", "JAN");
		month.put("2", "FEB");
		month.put("3", "MAR");
		month.put("4", "APR");
		month.put("5", "MAY");
		month.put("6", "JUN");
		month.put("7", "JUL");
		month.put("8", "AUG");
		month.put("9", "SEP");
		month.put("10", "OCT");
		month.put("11", "NOV");
		month.put("12", "DEC");

		return month;
	}

	public void clickOnWebElementUsingJavascript(WebElement element) {
		waitForWebEelementToAppear(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void scrollToButtomOfWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public void scrollToElementView(List<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElementView(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
	}

	public void retryingFindClick(WebElement element) {
		int attempts = 0;
		while (attempts < 5) {
			try {
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}
}
