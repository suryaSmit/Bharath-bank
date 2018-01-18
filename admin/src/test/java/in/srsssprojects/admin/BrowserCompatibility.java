package in.srsssprojects.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BrowserCompatibility extends TestExecution {
	@BeforeClass(groups = { "branch", "role", "employee", "create", "reset", "cancel" ,"search"})
	@Parameters({"browser"})
	public void launch(String b) {
		if (b.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//drivers/geckodriver");
			wdriver = new FirefoxDriver();
		} else if (b.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver");
			wdriver = new ChromeDriver();
		}else if(b.equalsIgnoreCase("safari")) {
			wdriver = new SafariDriver();
		}
		setup();
	}

	@AfterClass(groups = { "branch", "role", "employee", "create", "reset", "cancel" })
	public void close() {
		driver.close();
	}

}
