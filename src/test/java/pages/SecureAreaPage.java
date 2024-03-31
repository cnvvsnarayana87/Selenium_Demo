package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public SecureAreaPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public boolean isLogoutBtnDisplayed() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button"))).isDisplayed();
	}

	public boolean isLoginBtnDisplayed() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("radius"))).isDisplayed();
	}
}
