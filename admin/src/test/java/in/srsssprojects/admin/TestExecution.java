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
	 * 
	 * 16th assignment
	 * testRoleCreationReset
	 * testRoleCreationCancel
	 *testEmployeeCreationReset
	 *testEmployeeCreationCancel
	 */
	
	WebDriver driver;
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	BranchesPage branchesPage;
	NewBranchPage newBranchPage;
	RolePage rolePage;
	NewRolePage newRolePage;
	EmployeePage employeePage;
	NewEmployeePage newEmployeePage;
	
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
		newBranchPage = new NewBranchPage(driver);
		rolePage = new RolePage(driver);
		newRolePage = new NewRolePage(driver);
		employeePage = new EmployeePage(driver);
		newEmployeePage = new NewEmployeePage(driver);
		
	}
	
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
	
	@Test(priority=3)
	public void testBranchCreation() {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.fillbranchName("kukatpally branch 1");
		newBranchPage.filladdress1("kukatpally");
		newBranchPage.fillzip("50050");
		newBranchPage.selectCountry("INDIA");
		newBranchPage.selectState("Delhi");
		newBranchPage.selectCity("Delhi");
		newBranchPage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
		
	}
	
	@Test(priority=4)
	public void testBranchCreationReset() {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.fillbranchName("kukatpally branch 1");
		newBranchPage.filladdress1("kukatpally");
		newBranchPage.fillzip("50050");
		newBranchPage.selectCountry("INDIA");
		newBranchPage.selectState("Delhi");
		newBranchPage.selectCity("Delhi");
		newBranchPage.clickReset();
	}
	
	@Test(priority=5)
	public void testBranchCreationCancel() {
		adminHomePage.clickbranchesButton();
		branchesPage.clickNewBranch();
		newBranchPage.clickCancel();
	}
	
	@Test(priority=6)
	public void testRoleCreation() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.fillRoleName("Regional Manager 1");
		newRolePage.selectRoleType("E");
		newRolePage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
		
	}
	@Test(priority =7)
	public void testEmployeeCreation() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		newEmployeePage.fillEmpName("bharath");
		newEmployeePage.fillPassword("selenium");
		newEmployeePage.selectRole("Regional Manager 1");
		newEmployeePage.selectBranch("kukatpally branch 1");
		newEmployeePage.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
	}
	
	
	@Test(priority=8)
	public void testRoleReset() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.fillRoleName("Regional Manager 1");
		newRolePage.selectRoleType("E");
		newRolePage.clickReset();
		
	}

	@Test(priority=9)
	public void testRoleCancel() {
		adminHomePage.clickRolesButton();
		rolePage.clickNewRole();
		newRolePage.clickCancel();
		
	}
	
	@Test(priority =10)
	public void testEmployeeReset() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		newEmployeePage.fillEmpName("bharath");
		newEmployeePage.fillPassword("selenium");
		newEmployeePage.selectRole("Regional Manager 1");
		newEmployeePage.selectBranch("kukatpally branch 1");
		newEmployeePage.clickReset();
		
	}
	
	@Test(priority =11)
	public void testEmployeeCanel() {
		adminHomePage.clickEmployeeButton();
		employeePage.clickNewEmployee();
		newEmployeePage.clickCancel();
		
	}


	@AfterClass
	public void close() {
		driver.close();
	}

}
