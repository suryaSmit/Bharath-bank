package in.srsssprojects.admin;

import org.testng.annotations.Test;

import utility.DataFromExcel;
import utility.ExcelUtility;
import utility.Listener;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestExecution {
	/*
	 * branch creation page role creation page employee creation roles page employee
	 * page
	 * 
	 * 16th assignment testRoleCreationReset testRoleCreationCancel
	 * testEmployeeCreationReset testEmployeeCreationCancel
	 */

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
		excel = new ExcelUtility(".//resources/");
	}

	@Test(priority = 0, timeOut = 10000, alwaysRun = true, groups = { "branch", "role", "employee", "create", "reset",
			"cancel", "search" })
	public void testLogin() throws InterruptedException {
		bankHomePage.fillUserName(driver, "Admin");
		bankHomePage.fillPassword(driver, "Admin");
		// Thread.sleep(3000);
		bankHomePage.clickLoginButton(driver);
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult.testLogin);

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
		driver.switchTo().alert().accept();
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
	

	@Test(priority = 13, groups = { "branch", "create" },dataProviderClass=utility.DataFromExcel.class, dataProvider="branchData")
	public void testBranchCreationWithDP(String bname, String add1, String zcode, String country, String state, String city) {
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
	
	@Test(priority = 14, groups = { "role", "create" },dataProviderClass=utility.DataFromExcel.class, dataProvider="roleData")
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
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.fillRoleName("Regional Manager 1");
		newRolePage.selectRoleType("E");
		newRolePage.clickReset();

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
