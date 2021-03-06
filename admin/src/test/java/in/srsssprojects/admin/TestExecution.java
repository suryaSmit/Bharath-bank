package in.srsssprojects.admin;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.DataFromExcel;
import utility.ExcelUtility;
import utility.Listener;
import utility.TestListener;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.ITestClass;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

@Listeners(TestListener.class)
public class TestExecution {
	/*
	 * branch creation page role creation page employee creation roles page employee
	 * page
	 * 
	 * 16th assignment testRoleCreationReset testRoleCreationCancel
	 * testEmployeeCreationReset testEmployeeCreationCancel
	 */
	// public static Dimension d;

	WebDriver wdriver;
	EventFiringWebDriver driver;
	Listener listener;
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	BranchesPage branchesPage;
	NewBranchPage newBranchPage;
	RolePage rolePage;
	NewRolePage newRolePage;
	EmployeePage employeePage;
	NewEmployeePage newEmployeePage;
	ExcelUtility excel;
	// ExtentReports report;
	// ExtentTest test;

	public void eventsHandle() {
		driver = new EventFiringWebDriver(wdriver);
		listener = new Listener();
		driver.register(listener);
	}

	public void setup() {
		eventsHandle();
		driver.get("http://srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bankHomePage = new BankHomePage();
		adminHomePage = new AdminHomePage(driver);
		branchesPage = new BranchesPage(driver);
		newBranchPage = new NewBranchPage(driver);
		rolePage = new RolePage(driver);
		newRolePage = new NewRolePage(driver);
		employeePage = new EmployeePage(driver);
		newEmployeePage = new NewEmployeePage(driver);
		// d = driver.manage().window().getSize();
		// excel = new ExcelUtility(".//resources/");
		// report = new ExtentReports(".//report.html");
	}

	@Test(priority = 0, timeOut = 10000, alwaysRun = true, groups = { "branch", "role", "employee", "create", "reset",
			"cancel", "search" })
	public void testLogin() throws InterruptedException {
		// test = report.startTest("testLogin");
		bankHomePage.fillUserName(driver, "Admin");
		// test.log(LogStatus.INFO, "username fillied with Admin");
		bankHomePage.fillPassword(driver, "Admin");
		// test.log(LogStatus.INFO, "password filled with Admin");
		// Thread.sleep(3000);
		bankHomePage.clickLoginButton(driver);
		// test.log(LogStatus.INFO, "login button cliked");
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult.testLogin);
		// test.log(LogStatus.PASS, "test case is passed");
		// report.endTest(test);
	}

	@AfterMethod
	public void testResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			Reporter.log("test passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {

			}

		}
	}

	@Test(priority = 1, groups = { "branch", "search" })
	public void testBranchSearch() {
		adminHomePage.clickbranchesButton();
		branchesPage.selectCountry("INDIA");
		branchesPage.selectState("GOA");
		branchesPage.selectCity("GOA");
		branchesPage.clickSearch();
	}

	@Test(priority = 2, groups = { "branch", "search" })
	public void testBranchSearchClear() {
		adminHomePage.clickbranchesButton();
		branchesPage.selectCountry("INDIA");
		branchesPage.selectState("GOA");
		branchesPage.selectCity("GOA");
		branchesPage.clickSearch();
		branchesPage.clickClear();
	}

	@Test(priority = 3, groups = { "branch", "create" })
	public void testBranchCreation() {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.fillbranchName("kukatpally branch 2");
		newBranchPage.filladdress1("kukatpally");
		newBranchPage.fillzip("50050");
		newBranchPage.selectCountry("INDIA");
		newBranchPage.selectState("Delhi");
		newBranchPage.selectCity("Delhi");
		newBranchPage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		// driver.switchTo().alert().accept();
		Reporter.log(alertText, true);
		String actualResult = alertText;
		assertTrue(actualResult.contains(ExpectedResult.testBranchCreation));
	}

	@Test(priority = 12, groups = { "branch", "create" })
	public void testBranchCreationWithExcelData() {
		excel.setExcel("kexim data.xls", "branches");
		int nor = excel.getRowNumber();
		for (int i = 1; i < nor; i++) {
			String bname = excel.readData(i, 0);
			String add1 = excel.readData(i, 1);
			String zcode = excel.readData(i, 2);
			String country = excel.readData(i, 3);
			String state = excel.readData(i, 4);
			String city = excel.readData(i, 5);
			adminHomePage.clickbranchesButton();
			branchesPage.clickNewBranch();
			newBranchPage.fillbranchName(bname);
			newBranchPage.filladdress1(add1);
			newBranchPage.fillzip(zcode);
			newBranchPage.selectCountry(country);
			newBranchPage.selectState(state);
			newBranchPage.selectCity(city);
			newBranchPage.clickSubmit();
			String alertText = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Reporter.log(alertText, true);
			String actualResult = alertText;
			assertTrue(actualResult.contains(ExpectedResult.testBranchCreation));
		}

	}

	@Test(priority = 13, groups = { "branch",
			"create" }, dataProviderClass = utility.DataFromExcel.class, dataProvider = "branchData")
	public void testBranchCreationWithDP(String bname, String add1, String zcode, String country, String state,
			String city) {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.fillbranchName(bname);
		newBranchPage.filladdress1(add1);
		newBranchPage.fillzip(zcode);
		newBranchPage.selectCountry(country);
		newBranchPage.selectState(state);
		newBranchPage.selectCity(city);
		newBranchPage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Reporter.log(alertText, true);
		String actualResult = alertText;
		assertTrue(actualResult.contains(ExpectedResult.testBranchCreation));

	}

	@Test(priority = 4, groups = { "branch", "reset" })
	public void testBranchCreationReset() {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.fillbranchName("kukatpally branch 2");
		newBranchPage.filladdress1("kukatpally");
		newBranchPage.fillzip("50050");
		newBranchPage.selectCountry("INDIA");
		newBranchPage.selectState("Delhi");
		newBranchPage.selectCity("Delhi");
		newBranchPage.clickReset();
		String actualResult = newBranchPage.getSelectedOptionValue();
		Assert.assertEquals(actualResult, ExpectedResult.testBranchReset);
	}

	@Test(priority = 5, groups = { "branch", "cancel" })
	public void testBranchCreationCancel() {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.clickCancel();
	}

	@Test(priority = 14, groups = { "role",
			"create" }, dataProviderClass = utility.DataFromExcel.class, dataProvider = "roleData")
	public void testRoleCreationWithDP(String rname, String rtype) {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.fillRoleName(rname);
		newRolePage.selectRoleType(rtype);
		newRolePage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Reporter.log(alertText, true);

	}

	@Test(priority = 6, groups = { "role", "create" })
	public void testRoleCreation() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.fillRoleName("Regional Manager 2");
		newRolePage.selectRoleType("E");
		newRolePage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Reporter.log(alertText, true);

	}

	@Test(priority = 7, dependsOnMethods = { "testBranchCreation", "testRoleCreation" }, groups = { "employee",
			"create" })
	public void testEmployeeCreation() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		newEmployeePage.fillEmpName("bharath");
		newEmployeePage.fillPassword("selenium");
		newEmployeePage.selectRole("Regional Manager 2");
		newEmployeePage.selectBranch("kukatpally branch 2");
		newEmployeePage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Reporter.log(alertText, true);
	}

	@Test(priority = 8, groups = { "role", "reset" })
	public void testRoleReset() {
		// test = report.startTest("testRoleReset");
		adminHomePage.clickRolesButton();
		// test.log(LogStatus.INFO, "roles button clicked");
		rolePage.clickNewRole();
		// test.log(LogStatus.INFO, "new role button clicked");
		newRolePage.fillRoleName("Regional Manager 1");
		// test.log(LogStatus.INFO, "role nate entered");
		newRolePage.selectRoleType("E");
		// test.log(LogStatus.INFO, "role type seleced");
		newRolePage.clickReset();
		// test.log(LogStatus.INFO, "reset button clicked");
		// test.log(LogStatus.PASS, "test passed");
		// report.endTest(test);

	}

	@Test(priority = 9, groups = { "role", "cancel" })
	public void testRoleCancel() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.clickCancel();

	}

	@Test(priority = 10, groups = { "employee", "reset" })
	public void testEmployeeReset() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		newEmployeePage.fillEmpName("bharath");
		newEmployeePage.fillPassword("selenium");
		newEmployeePage.selectRole("Regional Manager 1");
		newEmployeePage.selectBranch("kukatpally branch 1");
		newEmployeePage.clickReset();

	}

	@Test(priority = 11, groups = { "employee", "cancel" })
	public void testEmployeeCanel() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		newEmployeePage.clickCancel();

	}
}
