package com.bookonelocal.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookonelocal.abstractComponents.AbstractComponents;

public class BookOneLocal_AdminDashBoard extends AbstractComponents {
	WebDriver driver;

	public BookOneLocal_AdminDashBoard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[contains(@class,'m-1')])[1]")
	WebElement newReservationButton;

	@FindBy(xpath = "(//button[contains(@class,'m-1')])[2]")
	WebElement newOrderButton;

	@FindBy(xpath = "(//button[contains(@class,'m-1')])[3]")
	WebElement newBookingButton;

	@FindBy(xpath = "(//button[contains(@class,'m-1')])[4]")
	WebElement KOT_Button;

	public BookOneLocal_BookingPage clickOnTheNewBookingButton() {
		newBookingButton.click();
		BookOneLocal_BookingPage bookingPage = new BookOneLocal_BookingPage(driver);
		return bookingPage;
	}

	@FindBy(css = ".mat-card.mat-focus-indicator")
	List<WebElement> userModules;

	By moduleNameBy = By.cssSelector("mat-card-content");

	public List<WebElement> getUserModules() {
		return userModules;
	}

	public WebElement getTargetModule(String moduleName) {
		WebElement module = getUserModules().stream()
				.filter(s -> s.findElement(By.cssSelector("mat-card-content")).getText().equalsIgnoreCase(moduleName))
				.findFirst().orElse(null);

		return module;
	}

	public BookOneLocal_BookingManagementPage clickOnModule(String moduleName) throws InterruptedException {
		WebElement module = getTargetModule(moduleName);
		clickOnWebElementUsingJavascript(module);
		Thread.sleep(3000);
		BookOneLocal_BookingManagementPage bookingManagementPage = new BookOneLocal_BookingManagementPage(driver);
		return bookingManagementPage;
	}

}
