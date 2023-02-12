package com.bookonelocal.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookonelocal.abstractComponents.AbstractComponents;
import com.bookonelocal.pageObjects.BookOneLocal_BookingManagementPage;

public class BookingConfirmationPop_up extends AbstractComponents {
	WebDriver driver;

	public BookingConfirmationPop_up(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "mat-card-title[class*='mat-card-title'] h2")
	WebElement bookingConfirmationPopupTitle;

	@FindBy(xpath = "(//div[contains(@class,'body')])[2]//b")
	WebElement thanksForBookingMessage;

	@FindBy(xpath = "mat-dialog-actions[class*='mat-dialog-actions'] button")
	WebElement goToBookingListButton;

	@FindBy(css = "mat-dialog-content[class='mat-dialog-content']")
	WebElement messageWithReservationNumber;

	public String getBookingConfirmationPopupTitle() {
		String bookingCompletedText = bookingConfirmationPopupTitle.getText().trim();
		return bookingCompletedText;
	}

	public String getThanksForBookingMessage() {
		String thanksForBookingText = thanksForBookingMessage.getText().trim();
		return thanksForBookingText;
	}

	public WebElement getMessageWithReservationNumber() {
		return messageWithReservationNumber;
	}

	public String getReservationId() {
		String reservationNumber = getMessageWithReservationNumber().getText().split(" ")[6].trim();
		return reservationNumber;
	}

	public String clickOnGoToBookingList() {
		String id = getReservationId();

		try {
			waitForWebEelementToAppear(goToBookingListButton);
			goToBookingListButton.click();
		} catch (Exception e) {
			goToBookingListButton.click();
		}

		return id;
	}

}
