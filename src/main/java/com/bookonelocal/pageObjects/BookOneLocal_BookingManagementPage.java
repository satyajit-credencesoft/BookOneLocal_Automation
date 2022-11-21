package com.bookonelocal.pageObjects;

import com.bookonelocal.abstractComponents.AbstractComponents;
import com.bookonelocal.popup.BookingConfirmationPop_up;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

	@FindBy(css = "mat-row.mat-row.cdk-row.ng-star-inserted")
	List<WebElement> allBookings;

	By actionButtonsBy = By.cssSelector("button");
	By reservationIDsBy = By.cssSelector("mat-cell[data-label='propertyReservationNumber'] a u");
	By customerNamesBy = By.cssSelector("mat-cell[data-label='Name'] b");
	By bookingDatesBy = By.cssSelector("mat-cell[data-label='fromDate'] span");
	By arrivalDate$timeBy = By.cssSelector("mat-cell[data-label='checkIn'] span");
	By departureDate$timeBy = By.cssSelector("mat-cell[data-label='checkOut'] span");
	By roomType$roomNumberBy = By.cssSelector("mat-cell[data-label='roomName'] span");
	By sourceOfBookingsBy = By.cssSelector("mat-cell[data-label='externalSite'] span");

	@FindBy(xpath = "//button[@role='menuitem']")
	List<WebElement> action_Options;

	By actionOptionNamesBy = By.xpath("/span");

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

	public Boolean verifyTheCustometName(String firstName, String lastName, String reservationId) {
		Boolean match = false;
		WebElement reservation = allBookings.stream()
				.filter(s -> s.findElement(reservationIDsBy).getText().trim().equalsIgnoreCase(reservationId))
				.findFirst().orElse(null);
		String customerName = reservation.findElement(customerNamesBy).getText().trim();
		if (customerName.equalsIgnoreCase(firstName + " " + lastName)) {
			match = true;
		}

		return match;
	}

	public Boolean verifyTheBookingDate(String arrivalDate, String departureDate, String reservationId) {
		Boolean match = false;
		// arrival
		String[] arrivalDetails = arrivalDate.split("/");
		String arrival_date = arrivalDetails[0].trim();
		String arrival_month = arrivalDetails[1].trim();
		String arrival_year = arrivalDetails[2].trim();

		// departure
		String[] departureDetails = departureDate.split("/");
		String departure_date = departureDetails[0].trim();
		String departure_month = departureDetails[1].trim();
		String departure_year = departureDetails[2].trim();

		WebElement reservation = allBookings.stream()
				.filter(s -> s.findElement(reservationIDsBy).getText().trim().equalsIgnoreCase(reservationId))
				.findFirst().orElse(null);
		String[] bookingDates = reservation.findElement(bookingDatesBy).getText().trim().split("to");
		String arrival = bookingDates[0].trim();
		String departure = bookingDates[1].trim();
		String arrival_Date = getMonth().get(arrival_month) + " " + arrival_date + ", " + arrival_year;
		String departure_Date = getMonth().get(departure_month) + " " + departure_date + ", " + departure_year;
		if ((arrival_Date.equalsIgnoreCase(arrival)) && (departure_Date).equalsIgnoreCase(departure)) {
			match = true;
		}

		return match;
	}
}
