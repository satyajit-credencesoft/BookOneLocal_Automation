package com.bookonelocal.tests.bookingManagement;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.bookonelocal.pageObjects.BookOneLocal_AdminDashBoard;
import com.bookonelocal.pageObjects.BookOneLocal_BookingPage;
import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.bookonelocal.testComponents.BaseTest;
import com.bookonelocal.testComponents.Retry;

public class Click_On_The_NewBookingButton extends BaseTest {

	@Test(retryAnalyzer = Retry.class)
	public void clickOnTheNewBookingButton() throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocal_LoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocal_LoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		BookOneLocal_BookingPage bookingPage = adminDashBoard.clickOnTheNewBookingButton();
		String text = bookingPage.getNewBookingEntryText();
		assertTrue(text.equalsIgnoreCase("New Booking Entry"));
	}

}
