package com.bookonelocal.testComponents;

import com.bookonelocal.pageObjects.BookOneLocal_LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.*;

public class BaseTest {
	WebDriver driver;
	Properties prop;

	@BeforeMethod(alwaysRun = true)
	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")
				+ "//src//main//java//com/bookonelocal//resources//GlobalData.properties"));
		prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addExtensions(new File(System.getProperty("user.dir") + "//Extensions//SelectorsHub.crx"));
			// options.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("headless");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			options.addExtensions(new File(System.getProperty("user.dir") + "//Extensions//SelectorsHub.crx"));
			options.addArguments("headless");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			OperaOptions options = new OperaOptions();
			options.setAcceptInsecureCerts(true);
			options.addExtensions(new File(System.getProperty("user.dir") + "//Extensions//SelectorsHub.crx"));
			options.addArguments("headless");
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver(options);
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();

		return driver;
	}

	public BookOneLocal_LoginPage lunchTheApplication() throws IOException, AWTException, InterruptedException {
		String url = prop.getProperty("url");
		driver.get(url);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);

		BookOneLocal_LoginPage bookOneLocalLoginPage = new BookOneLocal_LoginPage(driver);
		return bookOneLocalLoginPage;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		// String to HashMap- Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
		// {map, map}
	}

	public String getEmail() {
		String email = prop.getProperty("email");
		return email;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

//	@AfterMethod(alwaysRun = true)
	public void closeDriver() throws AWTException {
		driver.close();
	}

	public void waitForWebEelementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
	}

	public void scrollToButtomOfWebPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

}
