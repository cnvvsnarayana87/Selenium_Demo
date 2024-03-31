package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	private WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement logoutBtn() {
		return this.driver.findElement(By.xpath("//div//i[contains(text(),' Logout')]"));
	}

	public SecureAreaPage performLogout() {
		this.logoutBtn().click();
		return new SecureAreaPage(this.driver);
	}
}
