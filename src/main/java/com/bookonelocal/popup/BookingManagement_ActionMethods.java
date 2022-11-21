package com.bookonelocal.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookonelocal.abstractComponents.AbstractComponents;

public class BookingManagement_ActionMethods extends AbstractComponents {
	WebDriver driver;

	public BookingManagement_ActionMethods(WebDriver driver) {
		super(driver);
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[@role='menuitem'])[1]")
	WebElement viewOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[2]")
	WebElement addOnServiceOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[3]")
	WebElement convertInToGroupBooking;

	@FindBy(xpath = "(//button[@role='menuitem'])[4]")
	WebElement add_RemoveGuestOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[5]")
	WebElement additionalGuestInformation;

	@FindBy(xpath = "(//button[@role='menuitem'])[6]")
	WebElement cancel_Option;

	@FindBy(xpath = "(//button[@role='menuitem'])[7]")
	WebElement copy_Option;

	@FindBy(xpath = "(//button[@role='menuitem'])[8]")
	WebElement dateChange_Option;

	@FindBy(xpath = "(//button[@role='menuitem'])[9]")
	WebElement details_Option;

	@FindBy(xpath = "(//button[@role='menuitem'])[10]")
	WebElement roomCategoryChangeOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[11]")
	WebElement roomAllocationOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[12]")
	WebElement sendPaymentLinkOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[13]")
	WebElement sendConfirmationEmail_Option;

	@FindBy(xpath = "(//button[@role='menuitem'])[14]")
	WebElement voidBookingOption;

	@FindBy(xpath = "(//button[@role='menuitem'])[15]")
	WebElement NoShow_Option;

	public WebElement getViewOption() {
		return viewOption;
	}

	public WebElement getAddOnServiceOption() {
		return addOnServiceOption;
	}

	public WebElement getConvertInToGroupBooking() {
		return convertInToGroupBooking;
	}

	public WebElement getAdd_RemoveGuestOption() {
		return add_RemoveGuestOption;
	}

	public WebElement getAdditionalGuestInformation() {
		return additionalGuestInformation;
	}

	public WebElement getCancel_Option() {
		return cancel_Option;
	}

	public WebElement getCopy_Option() {
		return copy_Option;
	}

	public WebElement getDateChange_Option() {
		return dateChange_Option;
	}

	public WebElement getDetails_Option() {
		return details_Option;
	}

	public WebElement getRoomCategoryChangeOption() {
		return roomCategoryChangeOption;
	}

	public WebElement getRoomAllocationOption() {
		return roomAllocationOption;
	}

	public WebElement getSendPaymentLinkOption() {
		return sendPaymentLinkOption;
	}

	public WebElement getSendConfirmationEmail_Option() {
		return sendConfirmationEmail_Option;
	}

	public WebElement getVoidBookingOption() {
		return voidBookingOption;
	}

	public WebElement getNoShow_Option() {
		return NoShow_Option;
	}

}
