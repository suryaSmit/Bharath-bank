package in.srsssprojects.admin;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution{
	@BeforeClass(groups = { "branch", "role", "employee", "create", "reset", "cancel" ,"search"})
	@Parameters({"browser","os","nodeUrl"})
	public void launch(String b, String os, String node) throws MalformedURLException {
		System.out.println(b+" "+os+" "+node);
		DesiredCapabilities cap = new DesiredCapabilities();
		if(b.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
		}else if(b.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
		}
		if(os.equalsIgnoreCase("mac")) {
			cap.setPlatform(Platform.MAC);
		}else if(os.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WIN10);
		}else if(os.equalsIgnoreCase("linux")) {
			cap.setPlatform(Platform.LINUX);
		}
		wdriver = new RemoteWebDriver(new URL(node), cap);
		setup();
	}
	
	@AfterClass(groups = { "branch", "role", "employee", "create", "reset", "cancel" })
	public void close() {
		driver.close();
	}
}
