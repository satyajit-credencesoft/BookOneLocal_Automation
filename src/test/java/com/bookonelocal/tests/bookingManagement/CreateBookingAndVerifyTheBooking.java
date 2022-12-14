package com.bookonelocal.tests.bookingManagement;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookonelocal.pageObjects.BookOneLocal_AdminDashBoard;
import com.bookonelocal.pageObjects.BookOneLocal_BookingDetailsPage;
import com.bookonelocal.pageObjects.BookOneLocal_BookingManagementPage;
import com.bookonelocal.pageObjects.BookOneLocal_BookingPage;
import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.bookonelocal.popup.BookingConfirmationPop_up;
import com.bookonelocal.testComponents.BaseTest;

public class CreateBookingAndVerifyTheBooking extends BaseTest {

	@Test(dataProvider = "getData")
	public void createBookingAndVerifyTheBooking(HashMap<String, String> input)
			throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLoginPage.loginToBookOneLocal(getEmail(), getPassword());
		BookOneLocal_BookingManagementPage bookingManagementPage = adminDashBoard.clickOnModule("Booking Management");
		BookOneLocal_BookingPage bookingPage = bookingManagementPage.clickOnTargetHeaderButton("Book A Room");
		bookingPage.selectRoomType(input.get("roomTypeName"));
		bookingPage.selectArrivalDate(input.get("arrivalDate"));
		bookingPage.selectDepartureDate(input.get("departureDate"));
		bookingPage.selectPlan(input.get("planName"));
		bookingPage.enterNumberOfRooms(input.get("numberOfRooms"));
		bookingPage.enterNumberOfPersons(input.get("numberOfPerson"));
		bookingPage.enterExternalBookingNumber(input.get("externalBookingNumber"));
		bookingPage.selectSourceOfBooking(input.get("sourceOfBooking"));
		bookingPage.clickOnCheckAvailabiltyButton();
		bookingPage.selectCounter(input.get("counterName"));
		bookingPage.selectOperator(input.get("operatorName"));
		bookingPage.selectRoomNumbers(input.get("numberOfRooms"), input.get("roomNumbers"));
		bookingPage.searchCustomer(input.get("searchOptionName"), input.get("firstName"), input.get("lastName"),
				input.get("phoneNumber"), input.get("email"));
		BookingConfirmationPop_up bookingPop_up = bookingPage.clickOnBookButton();
		Assert.assertTrue(bookingPop_up.getBookingConfirmationPopupTitle().equalsIgnoreCase("Booking Completed"));
		Assert.assertTrue(bookingPop_up.getThanksForBookingMessage().equalsIgnoreCase("Thanks for the booking"));
		String reservationId = bookingPop_up.clickOnGoToBookingList();
		Assert.assertTrue(bookingManagementPage.verifyReservationId(reservationId));
		Assert.assertTrue(bookingManagementPage.verifyTheCustometName(input.get("firstName"), input.get("lastName"),
				reservationId));
		Assert.assertTrue(bookingManagementPage.verifyTheBookingDate(input.get("arrivalDate"),
				input.get("departureDate"), reservationId));
		BookOneLocal_BookingDetailsPage bookingDetailsPage = bookingManagementPage.clickOnView();
		Assert.assertTrue(bookingDetailsPage.getTheBookingStatusText().equalsIgnoreCase("booking status"));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//com//bookonelocal//data//verifyBooking.json");
		return new Object[][] { { data.get(0) } };
	}

}
