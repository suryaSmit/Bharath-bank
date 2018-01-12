package in.srsssprojects.admin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class TestExecution {
	/*
	 * branch creation page
	 * role creation page
	 * employee creation
	 * roles page
	 * employee page
	 */
	
	WebDriver driver;
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	BranchesPage branchesPage;
	
	@Test(priority =0)
	public void testLogin() {
		bankHomePage.fillUserName(driver, "Admin");
		bankHomePage.fillPassword(driver, "Admin");
		bankHomePage.clickLoginButton(driver);
		
	}
	
	@Test(priority =1)
	public void testBranchSearch() {
		adminHomePage.clickbranchesButton();
		branchesPage.selectCountry("INDIA");
		branchesPage.selectState("GOA");
		branchesPage.selectCity("GOA");
		branchesPage.clickSearch();
	}
	
	@Test(priority =2)
	public void testBranchSearchClear() {
		adminHomePage.clickbranchesButton();
		branchesPage.selectCountry("INDIA");
		branchesPage.selectState("GOA");
		branchesPage.selectCity("GOA");
		branchesPage.clickSearch();
		branchesPage.clickClear();
	}

	@BeforeClass
	public void launch() {
		System.setProperty("webdriver.gecko.driver", ".//drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://www.srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bankHomePage = new BankHomePage();
		adminHomePage = new AdminHomePage(driver);
		branchesPage = new BranchesPage(driver);
		
		
	}

	@AfterClass
	public void close() {
		driver.close();
	}

}
