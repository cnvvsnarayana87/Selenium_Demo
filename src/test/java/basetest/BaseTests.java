package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTests {
	private WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(final String browser) {
		if (browser.equalsIgnoreCase("CHROME")) {
			this.driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("EDGE")) {
			this.driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			this.driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("SAFARI")) {
			this.driver = new SafariDriver();
		} else {
			throw new Error(
					"The browser name should be either Chrome, Firefox, Edge, or Safari!");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}
}
