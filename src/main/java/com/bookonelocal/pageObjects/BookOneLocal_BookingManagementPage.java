package com.bookonelocal.pageObjects;

import com.bookonelocal.abstractComponents.AbstractComponents;
import com.bookonelocal.popup.BookingConfirmationPop_up;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookOneLocal_BookingManagementPage extends AbstractComponents {
	WebDriver driver;

	public BookOneLocal_BookingManagementPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h1.title")
	WebElement bookingManagementTitle;

	@FindBy(xpath = "//button[contains(@class,'ml-1')]/span[1]")
	List<WebElement> bookingManagementHeaderButtons;

	@FindBy(xpath = "//u[@class='propertyReservcation']")
	List<WebElement> reservationIds;

	public List<WebElement> getReservationIds() {
		return reservationIds;
	}

	public WebElement getBookingManagementTitleText() {
		waitForWebEelementToAppear(bookingManagementTitle);
		return bookingManagementTitle;
	}

	public List<WebElement> getBookingManagementHeaderButtons() {
		waitForWebElementsToAppear(bookingManagementHeaderButtons);
		return bookingManagementHeaderButtons;
	}

	public WebElement getTargetHeaderButton(String buttonName) {
		clickOnMenuIcon();
		WebElement button = getBookingManagementHeaderButtons().stream()
				.filter(s -> s.getText().substring(10).trim().equalsIgnoreCase(buttonName)).findFirst().orElse(null);
		return button;
	}

	public BookOneLocal_BookingPage clickOnTargetHeaderButton(String buttonName) throws InterruptedException {
		WebElement button = getTargetHeaderButton(buttonName);
		button.click();
		BookOneLocal_BookingPage bookingPage = new BookOneLocal_BookingPage(driver);
		return bookingPage;
	}

	public BookOneLocal_MultiBookingPage clickOnMultiBookingButton(String buttonName) throws InterruptedException {
		WebElement button = getTargetHeaderButton(buttonName);
		try {
			button.click();
		} catch (Exception e) {
			moveToWebElementAndClick(button);
			button.click();
		}

		BookOneLocal_MultiBookingPage multiBookingPage = new BookOneLocal_MultiBookingPage(driver);
		return multiBookingPage;
	}

	public Boolean verifyReservationId(String reservationId) {
		Boolean match = reservationIds.stream().anyMatch(s -> s.getText().trim().equalsIgnoreCase(reservationId));
		return match;
	}
}
