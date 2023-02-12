package com.bookonelocal.pageObjects;

import com.bookonelocal.abstractComponents.AbstractComponents;
import com.bookonelocal.popup.BookingConfirmationPop_up;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class BookOneLocal_BookingPage extends AbstractComponents {
	WebDriver driver;

	public BookOneLocal_BookingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mat-card-title")
	WebElement newBookingEntryText;

	@FindBy(tagName = "h2")
	WebElement pageTitleText;

	@FindBy(css = "mat-select[placeholder='Choose Room']")
	WebElement chooseRoomOption;

	@FindBy(css = "span.mat-option-text")
	List<WebElement> roomTypes;

	By roomTypeNames = By.cssSelector("b");

	@FindBy(xpath = "(//mat-icon[.='event'])[1]")
	WebElement arrivalDateCalendarIcon;

	@FindBy(xpath = "(//mat-icon[.='event'])[2]")
	WebElement departureDateCalendarIcon;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']//span[1]/span")
	WebElement currentMonth$Year;

	@FindBy(xpath = "//td[@class='mat-calendar-body-label']")
	WebElement currentMonth;

	@FindBy(css = "button[type$='button'] div:first-child")
	List<WebElement> allMonths;

	@FindBy(css = ".mat-calendar-body-cell-content.mat-focus-indicator")
	List<WebElement> allDates;

	@FindBy(css = ".mat-calendar-body-cell-content.mat-focus-indicator")
	List<WebElement> allYears;

	@FindBy(css = "mat-select[placeholder='Choose Plan']")
	WebElement choosePlanOption;

	@FindBy(css = "span.mat-option-text")
	List<WebElement> roomTypePlans;

	By roomPlanNameBy = By.cssSelector("b:first-child");

	@FindBy(css = "input[placeholder$='No Of Rooms']")
	WebElement enterNumberOfRoomsField;

	@FindBy(css = "input[placeholder$='No Of Person(s)']")
	WebElement enterNumberOfPersonsField;

	@FindBy(css = "input[placeholder$='No Of Child(ren)']")
	WebElement enterNumberOfChildrenField;

	@FindBy(css = "input[placeholder$='External Booking Number']")
	WebElement enterExternalBookingNumberField;

	@FindBy(xpath = "//span[.='Source Of Booking']")
	WebElement sourceOfBookingsOption;

	@FindBy(css = "span.mat-option-text")
	List<WebElement> bookingSources;

	@FindBy(xpath = "//span[.=' Check Availability ']")
	WebElement checkAvailabilityButton;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement resetButton;

	@FindBy(css = "button[name='counter']")
	List<WebElement> counters;

	By counterNameBy = By.cssSelector("b");

	@FindBy(css = "button[name='op']")
	List<WebElement> operators;

	By operatorNameBy = By.cssSelector("b");

	@FindBy(css = "span[class='mat-checkbox-label']")
	List<WebElement> availableRoomNumbers;

	@FindBy(css = "span[class='mat-checkbox-inner-container']")
	List<WebElement> availableRoomsCheckboxs;

	@FindBy(css = "label.mat-radio-label")
	List<WebElement> customerSearchOptions;

	By searchOptionsNameBy = By.cssSelector("span.mat-radio-label-content");
	By searchOptionCheckboxsBy = By.cssSelector("span.mat-radio-container");

	@FindBy(css = "input[type$='email']")
	WebElement searchCustomerWithEmail;

	@FindBy(xpath = "//button[contains(.,'Search')]")
	WebElement searchButton;

	@FindBy(css = "input[placeholder$='Phone Number']")
	WebElement searchCustomerWithPhoneNumber;

	@FindBy(css = "input[placeholder$='Search Name']")
	WebElement searchCustomerWithSearchBar;

	@FindBy(xpath = "//span[@class='mat-list-item-content']")
	List<WebElement> customerNames;

	@FindBy(xpath = "//span[.=' Book ']")
	WebElement bookButton;

	@FindBy(xpath = "//mat-card-title[.='Counter Information']")
	WebElement counterInformationText;

	@FindBy(xpath = "//mat-card-title[.='Customer Information']")
	WebElement customerrInformationText;

	@FindBy(css = "p[class='text-warning']")
	WebElement customerNotFound_WarningMessage;

	By customerNotFound_WarningMessageBy = By.cssSelector("p[class='text-warning']");

	@FindBy(xpath = "//a[@class='searchCustomer']")
	WebElement addNewCustomerButton;

	@FindBy(css = "input[placeholder='First Name']")
	WebElement newCustomer_firstName;

	@FindBy(css = "input[placeholder='Last Name']")
	WebElement newCustomer_lastName;

	@FindBy(css = "input[placeholder='Email']")
	WebElement newCustomer_email;

	@FindBy(css = "input[placeholder='Phone Number']")
	WebElement newCustomer_phoneNumber;

	@FindBy(xpath = "(//mat-icon[.='mode_edit'])[1]")
	WebElement roomPriceEditOption;

	@FindBy(xpath = "(//mat-icon[.='mode_edit'])[2]")
	WebElement extraPaxChargeEditOption;

	@FindBy(xpath = "(//mat-icon[.='mode_edit'])[3]")
	WebElement extraChildChargeOption;

	@FindBy(xpath = "(//mat-icon[.='mode_edit'])[4]")
	WebElement discountOption;

	@FindBy(xpath = "(//mat-icon[.='mode_edit'])[5]")
	WebElement netAmountEditOption;

	@FindBy(xpath = "(//mat-icon[.='mode_edit'])[6]")
	WebElement totalPayableAmountEditOption;

	@FindBy(css = "input[class*='roomprice']")
	WebElement roomPriceEditField;

	@FindBy(xpath = "//mat-icon[.='check']")
	WebElement checkMarkIcon;

	@FindBy(xpath = "//mat-icon[.='close']")
	WebElement closeMarkIcon;

	@FindBy(css = "input[class*='mat-input-element mat-form-field-autofill-control ng-tns-c120-37 ng-pristine ng-valid cdk-text-field-autofill-monitored ng-touched']")
	WebElement extraPaxChargeEditField;

	@FindBy(css = "input[class*='mat-input-element mat-form-field-autofill-control ng-tns-c120-40 ng-untouched ng-pristine ng-valid cdk-text-field-autofill-monitored']")
	WebElement extraChildChargeEditField;

	@FindBy(css = "input[class*='mat-input-element mat-form-field-autofill-control ng-tns-c120-45 ng-touched ng-pristine ng-valid cdk-text-field-autofill-monitored']")
	WebElement editDiscountField;

	@FindBy(css = "input[class*='mat-input-element mat-form-field-autofill-control ng-tns-c120-47 ng-pristine ng-valid cdk-text-field-autofill-monitored ng-touched']")
	WebElement netAmountEditField;

	@FindBy(xpath = "(//mat-icon[.=' check_box_outline_blank'])[1]")
	WebElement CGST_Tax;

	@FindBy(xpath = "(//mat-icon[.=' check_box_outline_blank'])[2]")
	WebElement SGST_Tax;

	@FindBy(xpath = "(//mat-icon[.=' check_box_outline_blank'])[3]")
	WebElement IGST_Tax;

	@FindBy(xpath = "//textarea[@placeholder='Booking Notes']")
	WebElement bookingNotes;

	@FindBy(xpath = "//mat-select[@placeholder='Mode of Payment']")
	WebElement modeOfPaymentDropDown;

	@FindBy(xpath = "//mat-option[@role='option']/span")
	List<WebElement> modeOfPayments;

	@FindBy(xpath = "//input[@placeholder='Advance Amount']")
	WebElement takeAdvancedAmountField;

	public void takeAdvancedAmount(int amount) {
		takeAdvancedAmountField.clear();
		takeAdvancedAmountField.sendKeys(Integer.toString(amount));
	}

	public void selectModeOfPayment(String paymentMode) throws InterruptedException {
		modeOfPaymentDropDown.click();
		WebElement modeOfPayment = modeOfPayments.stream().filter(s -> s.getText().trim().equalsIgnoreCase(paymentMode))
				.findFirst().orElse(null);
		try {
			modeOfPayment.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('div[role='listbox']').scrollBy(0,1000)");
			Thread.sleep(1000);
			modeOfPayment.click();
		}
	}

	public void takeBookingNotes(String notes) {
		bookingNotes.sendKeys(notes);
	}

	public void check_IGST() {
		IGST_Tax.click();
	}

	public void check_SGST() {
		SGST_Tax.click();
	}

	public void check_CGST() {
		CGST_Tax.click();
	}

	public void editTheRoomPrice(int amount) {
		String amounts = Integer.toString(amount);
		roomPriceEditOption.click();
		roomPriceEditField.clear();
		roomPriceEditField.sendKeys(amounts);
		checkMarkIcon.click();
	}

	public void editTheExtraPaxCharge(int amount) {
		String amounts = Integer.toString(amount);
		extraPaxChargeEditOption.click();
		extraPaxChargeEditField.sendKeys(amounts);
		checkMarkIcon.click();
	}

	public void editTheExtraChildCharge(int amount) {
		String amounts = Integer.toString(amount);
		extraChildChargeOption.click();
		extraChildChargeEditField.sendKeys(amounts);
		checkMarkIcon.click();
	}

	public void giveDiscount(int discount) {
		String discountAmount = Integer.toString(discount);
		discountOption.click();
		editDiscountField.sendKeys(discountAmount);
		checkMarkIcon.click();
	}

	public void editNetAmount(int amount) {
		String amounts = Integer.toString(amount);
		netAmountEditOption.click();
		netAmountEditField.sendKeys(amounts);
		checkMarkIcon.click();
	}

	public BookingConfirmationPop_up clickOnBookButton() throws InterruptedException {
		scrollToElementView(bookButton);
		bookButton.click();
		Thread.sleep(2000);

		BookingConfirmationPop_up bookingPopup = new BookingConfirmationPop_up(driver);
		return bookingPopup;
	}

	public void searchCustomer(String searchOptionName, String firstName, String lastName, String phoneNumber,
			String email) throws InterruptedException {
		scrollToElementView(customerrInformationText);
		if (searchOptionName.equalsIgnoreCase("firstName")) {
			WebElement option = customerSearchOptions.stream()
					.filter(s -> s.findElement(searchOptionsNameBy).getText().trim().equalsIgnoreCase("First Name"))
					.findFirst().orElse(null);
			option.findElement(searchOptionCheckboxsBy).click();
			searchCustomerWithSearchBar.sendKeys(firstName);
			Thread.sleep(3000);
			Boolean display = false;
			Boolean warningMessageTextIsEqual = false;
			if (driver.getPageSource().contains("Customer Not Found! Please create customer")) {
				display = true;
				warningMessageTextIsEqual = customerNotFound_WarningMessage.getText().trim()
						.equalsIgnoreCase("Customer Not Found! Please create customer");
			}
			if (display && warningMessageTextIsEqual) {
				// add new customer
				addNewCustomerButton.click();
				Thread.sleep(3000);
				newCustomer_firstName.sendKeys(firstName);
				newCustomer_lastName.sendKeys(lastName);
				newCustomer_email.sendKeys(email);
				newCustomer_phoneNumber.sendKeys(phoneNumber);
				Thread.sleep(1000);
			} else {
				for (int i = 0; i < customerNames.size(); i++) {
					Thread.sleep(3000);
					String name1 = customerNames.get(i).getText().substring(15).trim();
					String[] name2 = name1.split(" ");

					if (Arrays.asList(name2).contains(firstName)
							&& name1.equalsIgnoreCase(firstName + " " + lastName)) {
						customerNames.get(i).click();
						break;
					}
				}
			}

		} else if (searchOptionName.equalsIgnoreCase("lastName")) {
			WebElement option = customerSearchOptions.stream()
					.filter(s -> s.findElement(searchOptionsNameBy).getText().trim().equalsIgnoreCase("Last Name"))
					.findFirst().orElse(null);
			option.findElement(searchOptionCheckboxsBy).click();
			searchCustomerWithSearchBar.sendKeys(lastName);
			Thread.sleep(3000);
			Boolean display = false;
			Boolean warningMessageTextIsEqual = false;
			if (driver.getPageSource().contains("Customer Not Found! Please create customer")) {
				display = true;
				warningMessageTextIsEqual = customerNotFound_WarningMessage.getText().trim()
						.equalsIgnoreCase("Customer Not Found! Please create customer");
			}
			if (display && warningMessageTextIsEqual) {
				// add new customer
				addNewCustomerButton.click();
				Thread.sleep(3000);
				newCustomer_firstName.sendKeys(firstName);
				newCustomer_lastName.sendKeys(lastName);
				newCustomer_email.sendKeys(email);
				newCustomer_phoneNumber.sendKeys(phoneNumber);
				Thread.sleep(1000);
			} else {
				for (int i = 0; i < customerNames.size(); i++) {
					Thread.sleep(3000);
					String name1 = customerNames.get(i).getText().substring(15).trim();
					String[] name2 = name1.split(" ");

					if (Arrays.asList(name2).contains(lastName) && name1.equalsIgnoreCase(firstName + " " + lastName)) {
						customerNames.get(i).click();
						break;
					}
				}
			}

		} else if (searchOptionName.equalsIgnoreCase("phone")) {
			WebElement option = customerSearchOptions.stream()
					.filter(s -> s.findElement(searchOptionsNameBy).getText().trim().equalsIgnoreCase("Phone"))
					.findFirst().orElse(null);
			option.findElement(searchOptionCheckboxsBy).click();
			searchCustomerWithPhoneNumber.sendKeys(phoneNumber);
			searchButton.click();
			Thread.sleep(2000);
			Boolean display = false;
			Boolean warningMessageTextIsEqual = false;
			if (driver.getPageSource().contains("Customer Not Found!")) {
				display = true;
				warningMessageTextIsEqual = customerNotFound_WarningMessage.getText().trim()
						.equalsIgnoreCase("Customer Not Found!");
			}
			if (display && warningMessageTextIsEqual) {
				Thread.sleep(1000);
				newCustomer_firstName.sendKeys(firstName);
				newCustomer_lastName.sendKeys(lastName);
				newCustomer_email.sendKeys(email);
				newCustomer_phoneNumber.sendKeys(phoneNumber);
				Thread.sleep(1000);
			}
		} else if (searchOptionName.equalsIgnoreCase("email")) {
			WebElement option = customerSearchOptions.stream()
					.filter(s -> s.findElement(searchOptionsNameBy).getText().trim().equalsIgnoreCase("Email"))
					.findFirst().orElse(null);
			option.findElement(searchOptionCheckboxsBy).click();
			searchCustomerWithEmail.sendKeys(email);
			searchButton.click();
			Thread.sleep(2000);
			Boolean display = false;
			Boolean warningMessageTextIsEqual = false;
			if (driver.getPageSource().contains("Customer Not Found!")) {
				display = true;
				warningMessageTextIsEqual = customerNotFound_WarningMessage.getText().trim()
						.equalsIgnoreCase("Customer Not Found!");
			}
			if (display && warningMessageTextIsEqual) {
				Thread.sleep(1000);
				newCustomer_firstName.sendKeys(firstName);
				newCustomer_lastName.sendKeys(lastName);
				newCustomer_email.sendKeys(email);
				newCustomer_phoneNumber.sendKeys(phoneNumber);
				Thread.sleep(1000);
			}
		}
	}

	public void selectRoomNumbers(String numberOfRooms, String roomNumbers) throws InterruptedException {
		String[] roomsToAssign = null;

		if (roomNumbers.contains(",")) {
			roomsToAssign = roomNumbers.split(",");

			int roomCount = Integer.parseInt(numberOfRooms);
			int count = 0;
			for (int i = 0; i < availableRoomNumbers.size(); i++) {
				List<String> room = Arrays.asList(roomsToAssign);
				if (room.contains(availableRoomNumbers.get(i).getText().trim())) {
					count++;
					availableRoomNumbers.get(i).click();
				}

				if (count == roomCount)
					break;
			}

		} else {
			for (int i = 0; i < availableRoomNumbers.size(); i++) {
				if (availableRoomNumbers.get(i).getText().trim().equalsIgnoreCase(roomNumbers)) {
					Thread.sleep(1000);
					availableRoomNumbers.get(i).click();
					break;
				}
			}
		}
	}

	public void selectOperator(String operatorName) {
		WebElement operator = operators.stream()
				.filter(s -> s.findElement(operatorNameBy).getText().trim().equalsIgnoreCase(operatorName)).findFirst()
				.orElse(null);
		operator.click();
	}

	public void selectCounter(String counterName) throws InterruptedException {
		scrollToElementView(counterInformationText);
		Thread.sleep(2000);
		WebElement counter = counters.stream()
				.filter(s -> s.findElement(counterNameBy).getText().trim().equalsIgnoreCase(counterName)).findFirst()
				.orElse(null);
		counter.click();
	}

	public void clickOnResetButton() {
		resetButton.click();
	}

	public void clickOnCheckAvailabiltyButton() {
		checkAvailabilityButton.click();
	}

	public void selectSourceOfBooking(String sourceOfBooking) {
		sourceOfBookingsOption.click();
		WebElement source = bookingSources.stream().filter(s -> s.getText().trim().equalsIgnoreCase(sourceOfBooking))
				.findFirst().orElse(null);
		source.click();
	}

	public void enterExternalBookingNumber(String externalBookingNumber) {
		enterExternalBookingNumberField.sendKeys(externalBookingNumber);
	}

	public void enterNumberOfChildrens(String numberOfChildren) {
		enterNumberOfChildrenField.sendKeys(numberOfChildren);
	}

	public void enterNumberOfPersons(String numberOfPerson) {
		enterNumberOfPersonsField.sendKeys(numberOfPerson);
	}

	public void enterNumberOfRooms(String numberOfRooms) {
		enterNumberOfRoomsField.sendKeys(numberOfRooms);
	}

	public List<WebElement> getRoomTypes() {
		return roomTypes;
	}

	public String getNewBookingEntryText() {
		waitForWebEelementToAppear(newBookingEntryText);
		String text = newBookingEntryText.getText();
		return text;
	}

	public String getPageTitleText() {
		String text = pageTitleText.getText().trim();
		return text;
	}

	public void selectRoomType(String roomTypeName) throws InterruptedException {
		try {
			clickOnWebElementUsingJavascript(chooseRoomOption);
		} catch (Exception e) {
			retryingFindClick(chooseRoomOption);
		}
		WebElement roomType = getRoomTypes().stream()
				.filter(s -> s.findElement(roomTypeNames).getText().trim().equalsIgnoreCase(roomTypeName)).findFirst()
				.orElse(null);
		roomType.click();
	}

	public void selectArrivalDate(String arrivalDate) throws InterruptedException {
		// arrivalDateCalendarIcon.click();
		clickOnWebElementUsingJavascript(arrivalDateCalendarIcon);
		String[] dateDetails = arrivalDate.split("/");
		String date = dateDetails[0].trim();
		String month = dateDetails[1].trim();
		String year = dateDetails[2].trim();

		if (currentMonth$Year.getText().trim().equalsIgnoreCase(getMonth().get(month) + " " + year)) {
			WebElement Date = null;
			for (int i = 0; i < allDates.size(); i++) {
				String day = allDates.get(i).getText();
				if (day.equalsIgnoreCase(date)) {
					Date = allDates.get(i);
					break;
				}
			}
			try {
				moveToWebElementAndClick(Date);
			} catch (Exception e) {
				clickOnWebElementUsingJavascript(Date);
			}
			// Date.click();
		} else {
			currentMonth$Year.click();
			WebElement Year = allYears.stream().filter(s -> s.getText().trim().equalsIgnoreCase(year)).findFirst()
					.orElse(null);
			Year.click();
			WebElement Month = allMonths.stream()
					.filter(s -> s.getText().trim().equalsIgnoreCase(getMonth().get(month))).findFirst().orElse(null);
			Month.click();
			WebElement Date = allDates.stream().filter(s -> s.getText().trim().equalsIgnoreCase(date)).findFirst()
					.orElse(null);
			try {
				moveToWebElementAndClick(Date);
			} catch (Exception e) {
				clickOnWebElementUsingJavascript(Date);
			}
		}
	}

	public void selectDepartureDate(String departureDate) throws InterruptedException {
		// moveToWebElementAndClick(departureDateCalendarIcon);
		clickOnWebElementUsingJavascript(departureDateCalendarIcon);
		String[] dateDetails = departureDate.split("/");
		String date = dateDetails[0].trim();
		String month = dateDetails[1].trim();
		String year = dateDetails[2].trim();
		// clickOnMenuIcon();
		if (currentMonth$Year.getText().trim().equalsIgnoreCase(getMonth().get(month) + " " + year)) {
			WebElement Date = null;
			for (int i = 0; i < allDates.size(); i++) {
				String day = allDates.get(i).getText();
				if (day.equalsIgnoreCase(date)) {
					Date = allDates.get(i);
					break;
				}
			}
			try {
				moveToWebElementAndClick(Date);
			} catch (Exception e) {
				clickOnWebElementUsingJavascript(Date);
			}
		} else {
			currentMonth$Year.click();
			WebElement Year = allYears.stream().filter(s -> s.getText().trim().equalsIgnoreCase(year)).findFirst()
					.orElse(null);
			Year.click();
			WebElement Month = allMonths.stream()
					.filter(s -> s.getText().trim().equalsIgnoreCase(getMonth().get(month))).findFirst().orElse(null);
			Month.click();
			WebElement Date = allDates.stream().filter(s -> s.getText().trim().equalsIgnoreCase(date)).findFirst()
					.orElse(null);
			try {
				moveToWebElementAndClick(Date);
			} catch (Exception e) {
				clickOnWebElementUsingJavascript(Date);
			}
		}
	}

	public void selectPlan(String planName) {
		choosePlanOption.click();
		WebElement roomPlane = roomTypePlans.stream()
				.filter(s -> s.findElement(roomPlanNameBy).getText().trim().equalsIgnoreCase(planName)).findFirst()
				.orElse(null);
		roomPlane.click();
	}
}
