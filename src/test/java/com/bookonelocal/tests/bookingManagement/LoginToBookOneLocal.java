package com.bookonelocal.tests.bookingManagement;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.bookonelocal.testComponents.BaseTest;

public class LoginToBookOneLocal extends BaseTest {
	@Test
	public void loginToBookOneLocal() throws IOException, AWTException, InterruptedException {
		BookOneLocal_LoginPage bookOneLocalLoginPage = lunchTheApplication();
		bookOneLocalLoginPage.loginToBookOneLocal(getEmail(), getPassword());
	}

}
