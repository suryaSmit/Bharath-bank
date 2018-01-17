package in.srsssprojects.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution{
	@BeforeClass( groups= {"branch","role","employee","create","reset","cancel","search"})
	@Parameters("url")
	public void launch(String url) {
		System.setProperty("webdriver.gecko.driver", ".//drivers/geckodriver");
		wdriver = new FirefoxDriver();
		setup();
	}
	
	@AfterClass( groups= {"branch","role","employee","create","reset","cancel"})
	public void close() {
		driver.close();
	}

}
