package com.bookonelocal.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookonelocal.abstractComponents.AbstractComponents;

public class BookOneLocal_MultiBookingPage extends AbstractComponents {
	WebDriver driver;

	public BookOneLocal_MultiBookingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h1:first-child")
	WebElement multiBookingPageTitle;

	public String getMultiBookingPageTitle() {
		String title = multiBookingPageTitle.getText();
		return title;
	}

}
