package com.bookonelocal.tests.bookingManagement;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookonelocal.pageObjects.BookOneLocal_AdminDashBoard;
import com.bookonelocal.pageObjects.BookOneLocal_BookingManagementPage;
import com.bookonelocal.pageObjects.BookOneLocal_BookingPage;
import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.bookonelocal.popup.BookingConfirmationPop_up;
import com.bookonelocal.testComponents.BaseTest;

public class ClickOnTodaysArrivalButton extends BaseTest {

	@Test(dataProvider = "getData")
	public void createBooking(HashMap<String, String> input) throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocalLoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocalLoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		adminDashBoard.clickOnMenuIcon();
		BookOneLocal_BookingManagementPage bookingManagementPage = adminDashBoard.clickOnModule("booking management");
		BookOneLocal_BookingPage bookingPage = bookingManagementPage.clickOnTargetHeaderButton("book a room");
		bookingPage.selectRoomType(input.get("roomTypeName"));
		bookingPage.selectArrivalDate(input.get("arrivalDate"));
		bookingPage.selectDepartureDate(input.get("departureDate"));
		bookingPage.selectPlan(input.get("planName"));
		bookingPage.enterNumberOfRooms(input.get("numberOfRooms"));
		bookingPage.enterNumberOfPersons(input.get("numberOfPersons"));
		bookingPage.enterExternalBookingNumber("12345678910");
		bookingPage.selectSourceOfBooking(input.get("sourceOfBooking"));
		bookingPage.clickOnCheckAvailabiltyButton();
		bookingPage.editTheRoomPrice(2000);
		bookingPage.selectModeOfPayment("cheque");
		bookingPage.selectModeOfPayment("cash");
		bookingPage.takeAdvancedAmount(1000);
		bookingPage.selectCounter(input.get("counter"));
		bookingPage.selectOperator(input.get("operator"));
		bookingPage.selectRoomNumbers(input.get("numberOfRooms"), input.get("roomNumbers"));
		bookingPage.searchCustomer(input.get("searchOptionName"), input.get("firstName"), input.get("lastName"),
				input.get("phoneNumber"), input.get("email"));
		bookingPage.takeBookingNotes("Make sure the room should be cleaned");
		BookingConfirmationPop_up confirmationPop_up = bookingPage.clickOnBookButton();
		Assert.assertTrue(confirmationPop_up.getBookingConfirmationPopupTitle().equalsIgnoreCase("Booking Completed"));
		Assert.assertTrue(confirmationPop_up.getThanksForBookingMessage().equalsIgnoreCase("Thanks for the booking"));
		String reservationId = confirmationPop_up.clickOnGoToBookingList();
		Boolean verifyReservationId = bookingManagementPage.verifyReservationId(reservationId);
		Assert.assertTrue(verifyReservationId);
		bookingManagementPage.clickOnTheTodaysArrivalButton();
		Boolean verifyTodaysArrivalBooking = bookingManagementPage.verifyReservationId(reservationId);
		Assert.assertTrue(verifyTodaysArrivalBooking);
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "//src//test//java//com//bookonelocal//data//verify_today_arrival_button.json");
		return new Object[][] { { data.get(0) } };

	}
}
