package com.bookonelocal.tests.bookingManagement;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookonelocal.pageObjects.BookOneLocal_AdminDashBoard;
import com.bookonelocal.pageObjects.BookOneLocal_BookingManagementPage;
import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.bookonelocal.testComponents.BaseTest;
import com.bookonelocal.testComponents.Retry;

public class ClickOnTheBookingManagementModule extends BaseTest {

	@Test(retryAnalyzer = Retry.class)
	public void clickOnTheBookingManagementModule() throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocal_LoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocal_LoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		BookOneLocal_BookingManagementPage bookingManagementPage = adminDashBoard.clickOnModule("Booking Management");
		String text = bookingManagementPage.getBookingManagementTitleText().getText();
		Assert.assertTrue(text.equalsIgnoreCase("booking management"));
	}

}
