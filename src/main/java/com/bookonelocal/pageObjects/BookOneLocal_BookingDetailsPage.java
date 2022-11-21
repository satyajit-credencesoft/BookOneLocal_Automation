package com.bookonelocal.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookonelocal.abstractComponents.AbstractComponents;

public class BookOneLocal_BookingDetailsPage extends AbstractComponents {
	WebDriver driver;

	public BookOneLocal_BookingDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#bookingStatus div h2 strong")
	WebElement bookingStatus;

	public String getTheBookingStatusText() {
		String text = bookingStatus.getText().trim();
		return text;
	}

}
