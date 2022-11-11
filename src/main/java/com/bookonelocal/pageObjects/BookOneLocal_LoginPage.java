package com.bookonelocal.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookonelocal.abstractComponents.AbstractComponents;

public class BookOneLocal_LoginPage extends AbstractComponents {
	WebDriver driver;

	public BookOneLocal_LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(css = "button[type='submit']")
	WebElement signInButton;

	@FindBy(css = "a[class*='mb-10']")
	WebElement registerYourBusinessLink;

	public BookOneLocal_AdminDashBoard loginToBookOneLocal(String email, String password) throws InterruptedException {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signInButton.click();
		
		Thread.sleep(5000);
		BookOneLocal_AdminDashBoard adminDashBoard=new BookOneLocal_AdminDashBoard(driver);
		return adminDashBoard;
	}

}
