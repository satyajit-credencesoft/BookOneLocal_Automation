package com.bookonelocal.tests.bookingManagement;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookonelocal.pageObjects.BookOneLocal_AdminDashBoard;
import com.bookonelocal.pageObjects.BookOneLocal_BookingManagementPage;
import com.bookonelocal.pageObjects.BookOneLocal_BookingPage;
import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.bookonelocal.pageObjects.BookOneLocal_MultiBookingPage;
import com.bookonelocal.testComponents.BaseTest;
import com.bookonelocal.testComponents.Retry;

public class ClickOnTheHeaderButtonsOfBookingManagementPage extends BaseTest {

	@Test(retryAnalyzer = Retry.class)
	public void clickOnTheBook_A_Room_Button_UnderBookingManagementPage()
			throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocal_LoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocal_LoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		BookOneLocal_BookingManagementPage booingBookingManagementPage = adminDashBoard
				.clickOnModule("booking management");
		BookOneLocal_BookingPage bookingPage = booingBookingManagementPage.clickOnTargetHeaderButton("Book A Room");
		String text = bookingPage.getNewBookingEntryText();
		Assert.assertTrue(text.equalsIgnoreCase("New Booking Entry"));
	}

	@Test(retryAnalyzer = Retry.class)
	public void clickOnTheBookPropertyButton_UnderBookingManagementPage()
			throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocal_LoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocal_LoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		BookOneLocal_BookingManagementPage bookingManagementPage = adminDashBoard.clickOnModule("booking management");
		bookingManagementPage.clickOnMenuIcon();
		BookOneLocal_BookingPage bookingPage = bookingManagementPage.clickOnTargetHeaderButton("Book Property");
		Assert.assertTrue(bookingPage.getPageTitleText().equalsIgnoreCase("book property"));
	}

	@Test(retryAnalyzer = Retry.class)
	public void clickOnThe_RoomEnquiry_Button_UnderBookingManagementPage()
			throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocal_LoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocal_LoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		BookOneLocal_BookingManagementPage bookingManagementPage = adminDashBoard.clickOnModule("Booking Management");
		BookOneLocal_BookingPage bookingPage = bookingManagementPage.clickOnTargetHeaderButton("Room Enquiry");
		Assert.assertTrue(bookingPage.getPageTitleText().equalsIgnoreCase("Room Enquiry"));
	}

	@Test(retryAnalyzer = Retry.class)
	public void clickOnThe_BookMultipleRoom_Button_UnderBookingManagementPage()
			throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocal_LoginPage = lunchTheApplication();
		BookOneLocal_AdminDashBoard adminDashBoard = bookOneLocal_LoginPage.loginToBookOneLocal(getEmail(),
				getPassword());
		BookOneLocal_BookingManagementPage bookingManagementPage = adminDashBoard.clickOnModule("Booking Management");
		BookOneLocal_MultiBookingPage multiBookingPage = bookingManagementPage
				.clickOnMultiBookingButton("Book Multiple Room");
		Assert.assertTrue(multiBookingPage.getMultiBookingPageTitle().equalsIgnoreCase("multi booking"));
	}

}
