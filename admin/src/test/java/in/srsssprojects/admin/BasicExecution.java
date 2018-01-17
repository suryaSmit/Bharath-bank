package in.srsssprojects.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution{
	
	@BeforeClass( groups= {"branch","role","employee","create","reset","cancel","search"})
	public void launch() {
		System.setProperty("webdriver.gecko.driver", ".//drivers/geckodriver");
		wdriver = new FirefoxDriver();
		setup();
	}
	
	@AfterClass( groups= {"branch","role","employee","create","reset","cancel"})
	public void close() {
		driver.close();
	}

	

}
