package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basetest.BaseTests;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SecureAreaPage;

public class TestLoginLogout extends BaseTests {

	private Properties config;

	@BeforeClass
	public void setUp() throws IOException {

		config = new Properties();
		FileInputStream inputDataFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configurationfiles\\config.properties");
		config.load(inputDataFile);
		inputDataFile.close();
	}

	@Test
	public void testLoginPage() {

		WebDriver driver = getDriver();
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		
		final LoginPage loginPage = new LoginPage(driver);
		assertEquals(loginPage.pageHeader(), "Login Page");

		SecureAreaPage secureAreaPageLogin = loginPage.performLogin(config.getProperty("userName"),
				config.getProperty("passWord"));
		assertTrue(secureAreaPageLogin.isLogoutBtnDisplayed());
	}

	@Test
	public void testLogoutPage() {

		final LogoutPage logoutPage = new LogoutPage(this.getDriver());

		SecureAreaPage secureAreaPageLogout = logoutPage.performLogout();
		assertTrue(secureAreaPageLogout.isLoginBtnDisplayed());
	}
}
