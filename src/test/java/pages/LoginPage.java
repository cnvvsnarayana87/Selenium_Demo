package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	private By pageHeader = By.tagName("h2");
	private By userNameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginBtn = By.className("radius");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String pageHeader() {
		return this.driver.findElement(pageHeader).getText();
	}

	private WebElement userNameField() {
		return this.driver.findElement(userNameField);
	}

	private WebElement passwordField() {
		return this.driver.findElement(passwordField);
	}

	private WebElement loginBtn() {
		return this.driver.findElement(loginBtn);
	}

	public SecureAreaPage performLogin(String userName, String password) {
		this.userNameField().sendKeys(userName);
		this.passwordField().sendKeys(password);
		this.loginBtn().click();
		return new SecureAreaPage(this.driver);
	}
	
	
}
